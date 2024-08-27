(ns mockingbird.components.button
  (:refer-clojure :exclude [type class])
  (:require
   [mockingbird.lib :refer-macros [defnc]]
   [reitit.frontend.easy :as rfe]
   [mockingbird.components.popup :as popup]
   [mockingbird.defaultstyles :refer [label-style]]
   [helix.dom :as d]
   [helix.core :refer [$]]
   [refx.alpha :as refx]))

; #TODO remove solid, outline keeping here because it is used in other pages

; deprecated solid -old layout
; deprecated outline -old layout

(def styles 
  {:default {:mockingbird "group inline-flex ring-1 items-center justify-center rounded-full py-2 px-4 text-sm focus:outline-none ring-slate-200 text-slate-700 hover:text-slate-900 hover:ring-slate-300 active:bg-slate-100 active:text-slate-600 focus-visible:outline-blue-600 focus-visible:ring-slate-300 "}
   :login {:mockingbird "group inline-flex ring-1 items-center justify-center rounded-full py-2 px-4 text-sm focus:outline-none ring-slate-200 bg-mockingbird-main text-gray-50"}})

(defnc button
  [{:keys [class template type
           disabled label on-click 
           children]
    :or {type :login
         template :mockingbird
         on-click (fn [_]) 
         disabled false
         children "Insert some text"}}]
  (d/div
   (d/button
    {:class (str (get-in styles [type template]) " " class)
     :on-click on-click
     :type type
     :disabled disabled} 
   children)))
