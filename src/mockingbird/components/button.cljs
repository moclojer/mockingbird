(ns mockingbird.components.button
  (:refer-clojure :exclude [type class])
  (:require
   [mockingbird.lib :refer-macros [defnc]]
   [helix.dom :as d]))

(def styles
  {:default {:mockingbird "group inline-flex ring-1 items-center justify-center rounded-full py-2 px-4 text-sm focus:outline-none ring-slate-200 text-slate-700 hover:text-slate-900 hover:ring-slate-300 active:bg-slate-100 active:text-slate-600 focus-visible:outline-blue-600 focus-visible:ring-slate-300 "}
   :highlight {:mockingbird "group inline-flex ring-1 items-center justify-center rounded-full py-2 px-4 text-sm focus:outline-none ring-slate-200 bg-mockingbird-main text-gray-50 bg-mockingbird-main hover:bg-mockingbird-700 text-gray-50"}})

(defnc ^:export Button
  [{:keys [class theme type
           disabled label on-click
           children]
    :or {type :default
         theme :mockingbird
         on-click (fn [_])
         disabled false
         children "Insert some text"}}]
  (d/div
   (d/button
    {:class (str (get-in styles [type theme]) " " class)
     :on-click on-click
     :type type
     :disabled disabled}
    children)))


(defn ^:export button [{:keys [keys]}]
  ( Button {:keys keys}))
