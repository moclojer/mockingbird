(ns mockingbird.components.input
  (:refer-clojure :exclude [class type])
  (:require
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

(defnc input
  [{:keys [class type theme on-load
           on-change placeholder label
           children]
    :or {theme :mockingbird
         type :text
         on-load (fn [_])
         on-change (fn [_])
         placeholder "Type here..."}}]
  (d/div
   (when label
     (d/label
      {:class label-style}
      label))
   (d/input
    {:class (str (get-in styles [type theme]) " " class)
     :type (name type)
     :on-load on-load
     :on-change on-change
     :placeholder placeholder})
   children))
