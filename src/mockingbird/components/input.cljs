(ns mockingbird.components.input
  (:refer-clojure :exclude [class type])
  (:require
   [mockingbird.helpers.props :refer [get-props]]
   [mockingbird.lib :refer-macros [defnc]]
   [helix.dom :as d]))

(def label-style "block mb-2 text-sm font-medium text-gray-900")

(def styles
  {:text {:mockingbird (str "shadow-sm bg-gray-50 focus:ring-mockingbird-main "
                            "focus:border-mockingbird-main block w-full sm:text-sm "
                            "border-gray-300 rounded-md")}
   :checkbox {:default (str "")}
   :file {:default (str "")}
   :select {:default (str "")}
   :login (str "")})

(defnc ^:export input
  [{:keys [class type theme on-load
           on-change placeholder label
           size roundness shadow margin padding
           children]
    :or {theme :mockingbird
         type :text
         on-load (fn [_])
         on-change (fn [_])
         placeholder "Type here..."
         size :none
         roundness :none
         shadow :none
         margin :none
         padding :none}}]
  (d/div {:class (when label "flex flex-col")}
         (when label
           (d/label
            {:class label-style}
            label))
         (d/input
          {:class (str (get-in styles [type theme]) " "
                       (get-props
                        {:size size
                         :roundness roundness
                         :shadow shadow
                         :margin margin
                         :padding padding
                         :class class}))
           :type (name type)
           :on-load on-load
           :on-change on-change
           :placeholder placeholder})
         children))
