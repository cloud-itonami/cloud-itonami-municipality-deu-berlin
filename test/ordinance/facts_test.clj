(ns ordinance.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [ordinance.facts :as facts]))

(deftest berlin-has-spec-basis
  (let [sb (facts/spec-basis "berlin")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:ordinance/url %) "https://www.datenschutz-berlin.de/") sb))))

(deftest unknown-municipality-has-no-spec-basis
  (is (nil? (facts/spec-basis "munich")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["berlin" "munich"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["munich"] (:missing-municipalities c)))))

(deftest by-topic-filters
  (is (= ["berlin.datenschutzgesetz"]
         (mapv :ordinance/id (facts/by-topic "berlin" :data-protection))))
  (is (empty? (facts/by-topic "berlin" :labor)))
  (is (empty? (facts/by-topic "munich" :transparency))))
