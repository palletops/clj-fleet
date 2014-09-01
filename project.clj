(defproject com.palletops/clj-fleet "0.1.0-SNAPSHOT"
  :description "An API client for Fleet"
  :url "https://github.com/palletops/clj-fleet"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[com.palletops/discovery-api "0.1.0-SNAPSHOT"]]
  :profiles
  {:project [:discovery-api]
   :provided {:dependencies [[org.clojure/clojure "1.6.0"]]}
   :dev {:dependencies [[com.palletops/discovery-api "0.1.0-SNAPSHOT"]]
         :source-paths ["dev-src"]
         :resource-paths ["dev-resources"]}
   :gen {:prep-tasks ^:replace []}}
  :prep-tasks ["generate"  "compile"]
  :aliases {"generate"
            ["with-profile" "+gen,+dev"
             "run" "-m" "com.palletops.fleet.generator"]})
