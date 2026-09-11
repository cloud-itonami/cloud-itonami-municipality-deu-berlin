(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Berlin -- the FIFTH
  municipality-level entry (see cloud-itonami-municipality-jpn-tokyo,
  -usa-washington-dc, -gbr-london, -can-toronto for the first four) per
  ADR-2607141700 (cloud-itonami-compliance-fact-federation).

  Every entry cites an OFFICIAL Land Berlin source -- never fabricated.
  An ordinance not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/number.

  gesetze.berlin.de (Berlin's own official legal database) rendered only
  the site shell to WebFetch for individual documents (JS-only, like
  several other government portals in this family); its legacy
  `jportal` mirror is a login-walled Jetspeed instance, a dead end.
  Both entries below were instead verified by directly reading the
  source PDF text via the Read tool from the Berlin Data Protection and
  Freedom of Information Commissioner's own document republication site
  (datenschutz-berlin.de): the Berliner Informationsfreiheitsgesetz
  (IFG) PDF's structured cover page gave exact dates and the official
  gazette citation directly; the Berliner Datenschutzgesetz (BlnDSG)
  PDF's foreword (Vorwort) directly states its original 1978-07 entry
  into force, with the current post-GDPR-reform version's 2018-06-13
  (GVBl. p. 418) date corroborated via WebSearch rather than
  independently re-verified on a primary page.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"berlin"
   [{:ordinance/id "berlin.informationsfreiheitsgesetz"
     :ordinance/title "Gesetz zur Förderung der Informationsfreiheit im Land Berlin (Berliner Informationsfreiheitsgesetz, IFG)"
     :ordinance/municipality "berlin"
     :ordinance/country "DEU"
     :ordinance/kind :ordinance
     :ordinance/number "GVBl. 1999, 561"
     :ordinance/url "https://www.datenschutz-berlin.de/fileadmin/user_upload/pdf/gesetzestexte/2025-GVBl_IFG.pdf"
     :ordinance/url-provenance :official-berlin-datenschutzbeauftragte
     :ordinance/enacted-date "1999-10-15"
     :ordinance/last-revised-date "2025-07-10"
     :ordinance/retrieved-at "2026-07-15"
     :ordinance/topic #{:information-disclosure :transparency}}
    {:ordinance/id "berlin.datenschutzgesetz"
     :ordinance/title "Berliner Datenschutzgesetz (BlnDSG)"
     :ordinance/municipality "berlin"
     :ordinance/country "DEU"
     :ordinance/kind :ordinance
     :ordinance/url "https://www.datenschutz-berlin.de/fileadmin/user_upload/pdf/gesetzestexte/2022-BlnBDI_BlnDSG.pdf"
     :ordinance/url-provenance :official-berlin-datenschutzbeauftragte
     :ordinance/enacted-date "1978-07"
     :ordinance/last-revised-date "2018-06-13"
     :ordinance/retrieved-at "2026-07-15"
     :ordinance/topic #{:data-protection :privacy}}]})

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
      :note (str "cloud-itonami-municipality-deu-berlin Wave 0 (ADR-2607141700): "
                 (count (get catalog "berlin")) " Berlin entries seeded with "
                 "an official datenschutz-berlin.de PDF republication citation. "
                 "Extend `ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
