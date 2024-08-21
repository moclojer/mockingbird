(ns mockingbird.core
  (:require
   ["react-dom/client" :as rdom]
   [mockingbird.components.input :refer [input]] 
   [helix.core :refer [$ <>]]
   [helix.dom :as d]))

;; this is a front app application using shadow-cljs, tailwind jit, helix and refx.
;; You can see a simple page example running.
(defn app []
  (<>
    ($ input {:label "carlos"})))

(defonce root
  (rdom/createRoot (js/document.getElementById "app")))

(defn render []
  (.render root ($ app)))

(defn config []
  (println 'ok))

(defn ^:export init []
  (config)
  (render))

