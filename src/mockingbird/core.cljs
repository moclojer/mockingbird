(ns mockingbird.core
  (:require
   ["react-dom/client" :as rdom]
   [mockingbird.examples.main :as ex]
   [helix.core :refer [$ <>]]
   [helix.dom :as d]))

;; this is a front app application using shadow-cljs, postcss, helix and refx.
;; You can see a simple page example running.
(defn app []
  (d/div {:class "w-screen h-screen"}
      ($ ex/app))) ;; TODO change size 

(defonce root
  (rdom/createRoot (js/document.getElementById "app")))

(defn render []
  (.render root ($ app)))

(defn config []
  (println 'ok))

(defn ^:export init []
  (config)
  (render))
