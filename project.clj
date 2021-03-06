(defproject butterfly "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.4"]
                 [org.clojure/clojurescript "0.0-2080"]]
  :plugins [[lein-ring "0.8.8"]
            [lein-cljsbuild "1.0.1-SNAPSHOT"]]
  :ring {:handler butterfly.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}}
  :cljsbuild {
              :builds [{
                        :source-paths ["src-cljs"]
                        :compiler {
                                   :output-to "resources/public/js/clj.js"
                                   :optimizations :whitespace
                                   :pretty-print true }}]}
  )
