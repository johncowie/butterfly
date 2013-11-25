(ns butterfly.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [hiccup.core :as hiccup]
            [hiccup.page :as page]))

(defn test-page []
  [:body
   (page/include-js "js/d3.v3.min.js")
   (page/include-js "js/clj.js")])

(defroutes app-routes
  (GET "/" [] (hiccup/html (test-page)))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
