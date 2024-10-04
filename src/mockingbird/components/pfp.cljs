(ns mockingbird.components.pfp
  (:refer-clojure :exclude [class])
  (:require
   [mockingbird.helpers.props :refer [get-props]]
   [mockingbird.lib :refer-macros [defnc]]
   [helix.dom :as d]))

(def pfp-styles
  {:mockinbird {:default "w-8 h-8 rounded-none opacity-100"
                :rounded "w-8 h-8 rounded-full opacity-100"
                :loading "w-8 h-8 rounded-full opacity-30 animate-pulse"}})

(defnc ^:export pfp
  [{:keys [class theme style src
           alt size roundness
           shadow margin padding
           loading? children]
    :or {theme :mockinbird
         style :default
         src "/images/logo.png"
         alt "Profile picture"
         size :md
         roundness :none
         shadow :none
         margin :none
         padding :none
         loading? false}}]
  (d/div
     (d/img {:class (str (get-in pfp-styles 
                                 [theme (if loading? 
                                          :loading
                                          style)] " ")
                         (get-props
                          {:size size
                           :roundness roundness
                           :shadow shadow
                           :margin margin
                           :padding padding
                           :class class}))
             :src src
             :alt alt})
   children))
