(ns project1-simple-web.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.util.response :as resp]
            [project1-simple-web.views :as views]
            [project1-simple-web.files :as file]))

(defroutes app-routes
  (GET "/" [] (views/index file/txt))
  (POST "/" [note]
       (do (file/add note)
           (resp/redirect "/")))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
