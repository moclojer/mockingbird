(ns mockingbird.components.image
  (:require
   [mockingbird.lib :refer-macros [defnc]]
   [helix.dom :as d]))

(def pfp-styles {:mockingbird ""})

(defnc pfp 
  [{:keys [class theme image 
           size rounded? alt 
           children]
    :or {theme :mockingbird
         image "/images/logo.png"
         alt "test"}}]
  (d/div 
    (d/img {:class (str (get pfp-styles theme) " " 
                        class " " size " " 
                        (when rounded? "rounded-lg"))
            :src image
            :alt alt})
    children))
