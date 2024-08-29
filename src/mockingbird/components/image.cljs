(ns mockingbird.components.image
  (:refer-clojure :exclude [class])
  (:require
   [mockingbird.utils.props :refer [get-props]]
   [mockingbird.lib :refer-macros [defnc]]
   [helix.dom :as d]))

(def pfp-styles {:mockingbird ""})


(defnc pfp 
  [{:keys [class theme image 
           alt size roundness
           shadow children] 
    :or {theme :mockingbird
         image "/images/logo.png"
         alt "test"
         size :md
         roundness :none
         shadow :none}}]
  (let [size (if (keyword? size)
               size
               (keyword size))
        roundness (if (keyword? roundness)
                    roundness 
                    (keyword roundness))
        shadow (if (keyword? shadow)
                    shadow 
                    (keyword shadow))]
  (d/div 
    (d/img {:class (str (get pfp-styles theme) " " 
                        (get-props size roundness shadow class))
            :src image
            :alt alt})
    children)))
