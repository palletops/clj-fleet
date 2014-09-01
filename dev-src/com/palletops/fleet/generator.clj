(ns com.palletops.fleet.generator
  "API generator"
  (:require
   [clojure.java.io :refer [file]]
   [clojure.string :as string]
   [com.palletops.discovery :refer [api-ns-string document-from-resource]]))

(def ^:internal versions ["v1-alpha"])

(defn- fleet-fn-name [id]
  (-> (com.palletops.discovery.resources/default-function-name id)
      (string/replace "fleet-" "")
      symbol))

(defn generate-version
  [version]
  (let [doc (document-from-resource "discovery/v1-alpha")
        options {:fn-name-f fleet-fn-name}
        c (api-ns-string
           doc (symbol (str "com.palletops.fleet." version)) options)
        f (file
           "src/com/palletops/fleet"
           (str (string/replace version "-" "_") ".clj"))]
    (.mkdirs (.getParentFile f))
    (spit f c)))

(defn generate-versions
  []
  (doseq [version versions]
    (generate-version version)))

(comment
  (generate-versions))

(defn -main [& args]
  (generate-versions))
