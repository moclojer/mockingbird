(ns mockingbird.components.filedropdown
  (:require 
    [mockingbird.lib :refer-macros [defnc]]
    [helix.dom :as d]))

(def styles {})


(defnc form-dropdown
  [{:keys [class theme label 
           children]
    :or {theme :mockingbird
         children "Insert some text"}}]
  (d/div
   (d/form
    {:class (str (get-in styles [theme]) " " class)}
    children)))
