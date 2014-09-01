(defproject com.palletops/clj-fleet "0.1.1-SNAPSHOT"
  :description "An API client for Fleet"
  :url "https://github.com/palletops/clj-fleet"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[clj-http "1.0.0"]]
  :profiles
  {:provided {:dependencies [[org.clojure/clojure "1.6.0"]]}
   :dev {:dependencies [[com.palletops/discovery-api "0.1.0"]]
         :source-paths ["dev-src"]
         :resource-paths ["dev-resources"]
         :plugins [[lein-pallet-release "RELEASE"]]}
   :gen {:prep-tasks ^:replace []}}
  :prep-tasks ["generate"  "compile"]
  :aliases {"generate"
            ["with-profile" "+gen,+dev"
             "run" "-m" "com.palletops.fleet.generator"]})
