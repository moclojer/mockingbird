(ns mockingbird.components.selectdropdown
  (:require
   [mockingbird.lib :refer-macros [defnc]]
   [helix.dom :as d]))

;; TODO
(def styles {})

(defnc select-dropdown
  [{:keys [class theme label
           children]
    :or {theme :mockingbird
         children "Insert some text"}}]
  (d/div
   (d/form
    {:class (str (get-in styles [theme]) " " class)}
    children)))
