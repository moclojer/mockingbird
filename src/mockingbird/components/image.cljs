(ns mockingbird.components.image
  (:refer-clojure :exclude [class])
  (:require
   [mockingbird.helpers.props :refer [get-props]]
   [mockingbird.lib :refer-macros [defnc]]
   [helix.dom :as d]))

(defnc ^:export image
  [{:keys [class theme image
           alt size roundness
           shadow margin padding
           loading? children]
    :or {theme :mockingbird
         image "/images/logo.png"
         alt "Image description"
         size :md
         roundness :none
         shadow :none
         margin :none
         padding :none
         loading? false
         children nil }}]
  (d/div
   (if loading?
     (d/div {:class "loading-placeholder"} "Loading...")
     (d/img {:class (str (get-props
                           {:size size
                            :roundness roundness
                            :shadow shadow
                            :margin margin
                            :padding padding
                            :class class}))
             :src image
             :alt alt }))
   children))
