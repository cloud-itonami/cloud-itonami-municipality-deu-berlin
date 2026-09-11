(ns culture.facts
  "Regional-culture catalog for Berlin (Land Berlin) -- local dishes,
  protected products, beverages, festivals and heritage sites, piggybacked
  onto this municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"berlin"
   [{:culture/id "berlin.dish.currywurst"
     :culture/name "Currywurst"
     :culture/municipality "berlin"
     :culture/country "DEU"
     :culture/kind :dish
     :culture/summary "Grilled pork sausage with ketchup and curry powder, invented in 1949 by Herta Heuwer, who began selling it at a food stand in West Berlin."
     :culture/url "https://en.wikipedia.org/wiki/Currywurst"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "berlin.dish.doner-kebab"
     :culture/name "Doner kebab"
     :culture/name-local "Döner"
     :culture/municipality "berlin"
     :culture/country "DEU"
     :culture/kind :dish
     :culture/summary "The modern sandwich variant of doner kebab originated and was popularized in 1970s West Berlin by Turkish immigrants; the sandwich is connected to the city of Berlin."
     :culture/url "https://en.wikipedia.org/wiki/Doner_kebab"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "berlin.dish.berliner-doughnut"
     :culture/name "Berliner"
     :culture/municipality "berlin"
     :culture/country "DEU"
     :culture/kind :dish
     :culture/summary "German jam doughnut with no central hole, made from sweet yeast dough fried in lard or oil and usually covered in powdered sugar; its connection to Berlin is reflected in its name."
     :culture/url "https://en.wikipedia.org/wiki/Berliner_(doughnut)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "berlin.beverage.berliner-weisse"
     :culture/name "Berliner Weisse"
     :culture/municipality "berlin"
     :culture/country "DEU"
     :culture/kind :beverage
     :culture/summary "Cloudy, sour wheat beer of around 3.5% ABV; by the late 19th century it was the most popular alcoholic drink in Berlin, and Berliner Kindl Weisse is among the few brands still produced in the city."
     :culture/url "https://en.wikipedia.org/wiki/Berliner_Weisse"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "berlin.craft.kpm-porcelain"
     :culture/name "KPM porcelain"
     :culture/name-local "Königliche Porzellan-Manufaktur Berlin"
     :culture/municipality "berlin"
     :culture/country "DEU"
     :culture/kind :craft
     :culture/summary "The Royal Porcelain Factory in Berlin, founded in 1763 by King Frederick II of Prussia, manufactures European hard-paste porcelain."
     :culture/url "https://en.wikipedia.org/wiki/K%C3%B6nigliche_Porzellan-Manufaktur_Berlin"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "berlin.festival.karneval-der-kulturen"
     :culture/name "Karneval der Kulturen"
     :culture/municipality "berlin"
     :culture/country "DEU"
     :culture/kind :festival
     :culture/summary "Multicultural festival in Kreuzberg, Berlin, celebrated annually since 1996 around Pentecost weekend."
     :culture/url "https://en.wikipedia.org/wiki/Karneval_der_Kulturen"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "berlin.festival.berlinale"
     :culture/name "Berlin International Film Festival"
     :culture/name-local "Berlinale"
     :culture/municipality "berlin"
     :culture/country "DEU"
     :culture/kind :festival
     :culture/summary "Annual film festival held in Berlin, taking place every February since 1978, one of Europe's most prestigious cinema events."
     :culture/url "https://en.wikipedia.org/wiki/Berlin_International_Film_Festival"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "berlin.heritage.museum-island"
     :culture/name "Museum Island"
     :culture/name-local "Museumsinsel"
     :culture/municipality "berlin"
     :culture/country "DEU"
     :culture/kind :heritage
     :culture/summary "Museum Island in Berlin was designated a UNESCO World Heritage Site in 1999 for its testimony to the architectural and cultural development of museums in the 19th and 20th centuries."
     :culture/url "https://en.wikipedia.org/wiki/Museum_Island"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "berlin.heritage.brandenburg-gate"
     :culture/name "Brandenburg Gate"
     :culture/name-local "Brandenburger Tor"
     :culture/municipality "berlin"
     :culture/country "DEU"
     :culture/kind :heritage
     :culture/summary "18th-century neoclassical monument in Berlin, built from 1788 to 1791."
     :culture/url "https://en.wikipedia.org/wiki/Brandenburg_Gate"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-deu-berlin culture catalog "
                 "(ADR-2607171400): " (count (get catalog "berlin"))
                 " Berlin entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
