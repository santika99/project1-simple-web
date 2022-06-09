(ns project1-simple-web.views
  (:require [hiccup.page :refer :all]
            [ring.util.anti-forgery :refer (anti-forgery-field)]))

(defn base-page [& body]
(html5
 [:head
  [:title "simple web"]]
 [:body
  [:div
    [:h1 "Welcome"]
    [:form {:method "POST" :action "/"}
     [:input {:type "text" :placeholder "input disini" :name "note"}]
     (anti-forgery-field)
     [:input {:type "submit" :onclick "insert-text" :value "insert"}]
     ]]
  body]))

(defn index [notes]
  (base-page
   (for [note @notes]
     [:p note])))

