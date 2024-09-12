(ns mockingbird.components.image
  (:refer-clojure :exclude [class])
  (:require
   [mockingbird.helpers.props :refer [get-props]]
   [mockingbird.lib :refer-macros [defnc]]
   [helix.dom :as d]))

(def pfp-styles
  {:default "w-8 h-8 rounded-none opacity-100"
   :rounded "w-8 h-8 rounded-full opacity-100"
   :loading "w-8 h-8 rounded-full opacity-30 animate-pulse"})

(defnc pfp
  [{:keys [class theme image
           alt size roundness
           shadow margin padding
           children]
    :or {theme :mockingbird
         image "/images/logo.png"
         alt "test"
         size :md
         roundness :none
         shadow :none
         margin :none
         padding :none}}]
  (d/div
   (d/img {:class (str (get pfp-styles theme) " "
                       (get-props
                        {:size size
                         :roundness roundness
                         :shadow shadow
                         :margin margin
                         :padding padding
                         :class class}))
           :src image
           :alt alt})
   children))

(defnc image 
  [{:keys [class theme image
           alt size roundness
           shadow margin padding
           children]
    :or {theme :mockingbird
         image "/images/logo.png"
         alt "test"
         size :md
         roundness :none
         shadow :none
         margin :none
         padding :none}}]
  (d/div
   (d/img {:class (str (get-props
                        {:size size
                         :roundness roundness
                         :shadow shadow
                         :margin margin
                         :padding padding
                         :class class}))
           :src image
           :alt alt})
   children))
