(ns culture.facts-test
  (:require [clojure.edn :as edn]
            [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [culture.facts :as facts]))

(deftest berlin-has-culture-basis
  (let [sb (facts/spec-basis "berlin")]
    (is (= 9 (count sb)))
    (is (= (count sb) (count (set (map :culture/id sb)))))
    (is (every? #(str/starts-with? (:culture/url %) "https://") sb))
    (is (every? #(= "berlin" (:culture/municipality %)) sb))
    (is (every? #(= "DEU" (:culture/country %)) sb))
    (is (every? #(seq (:culture/summary %)) sb))
    (is (every? #(string? (:culture/retrieved-at %)) sb))))

(deftest unknown-municipality-has-no-basis
  (is (nil? (facts/spec-basis "hamburg")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["berlin" "hamburg"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["hamburg"] (:missing-municipalities c)))))

(deftest by-kind-filters
  (is (= 3 (count (facts/by-kind "berlin" :dish))))
  (is (= ["berlin.beverage.berliner-weisse"]
         (mapv :culture/id (facts/by-kind "berlin" :beverage))))
  (is (= 1 (count (facts/by-kind "berlin" :craft))))
  (is (empty? (facts/by-kind "hamburg" :dish))))

(deftest tx-file-matches-catalog
  (let [tx (edn/read-string (slurp "data/culture-tx.edn"))
        flat (mapcat val (sort-by key facts/catalog))]
    (is (= (vec flat) (vec tx)))))
