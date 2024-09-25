(ns mockingbird.components.button
  (:refer-clojure :exclude [type class])
  (:require
   [mockingbird.helpers.props :refer [get-props]]
   [mockingbird.lib :refer-macros [defnc]]
   [helix.dom :as d]))

(def styles
  {:default {:mockingbird "group inline-flex transition-all ring-1 items-center justify-center rounded-full py-2 px-4 text-sm focus:outline-none ring-slate-200 text-slate-700 hover:text-slate-900 hover:ring-slate-300 active:bg-slate-100 active:text-slate-600 focus-visible:outline-blue-600 focus-visible:ring-slate-300 "}
   :highlight {:mockingbird "group inline-flex transition-all ring-1 items-center justify-center py-2 px-4 text-sm focus:outline-none ring-slate-200 text-gray-50 bg-mockingbird-main hover:bg-mockingbird-700 text-gray-50 "}
   :submit {:mockingbird "group transition-all py-3 px-5 text-base font-medium text-center text-white rounded-lg bg-mockingbird-main hover:bg-mockingbird-700 focus:ring-4 focus:ring-primary-300 transition-all"}
   :icon {:mockingbird "group transition-all p-0"}})

(defnc ^:export button
  [{:keys [class theme type
           disabled label on-click
           size roundness shadow
           margin padding loading? children]
    :or {type :default
         theme :mockingbird
         on-click (fn [_])
         disabled false
         roundness :none
         size :none
         shadow :none
         margin :none
         padding :none
         loading? false
         children nil}}]
  (d/div
   (d/button
     {:class (str (get-in styles [type theme]) " "
                  (get-props 
                    {:size size
                     :roundness roundness
                     :shadow shadow
                     :margin margin
                     :padding padding
                     :class class}))
     :on-click (when-not disabled on-click)
     :type type
     :disabled (or disabled loading?)
     :aria-label (if loading? "Loading..." label)}
    (if loading?
      "Loading..."
      (or children "Insert some text")))))
