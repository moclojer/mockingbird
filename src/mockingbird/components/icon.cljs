(ns mockingbird.components.icon
  (:require
   [mockingbird.lib :refer-macros [defnc]]
   [helix.dom :as d]))

;; TODO

(def styles
  {:mockingbird {}})

(defnc icon
  [{:keys [class theme label href
           children]
    :or {theme :mockingbird
         children "Insert some text"}}]
  (d/div
   (d/i
    {:class (str (get-in styles [theme]) " " class)
     :href href}
    children)))
