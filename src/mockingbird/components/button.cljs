(ns mockingbird.components.button
  (:require
   [mockingbird.lib :refer [defnc]]
   [helix.dom :as d]
   [helix.core :refer [$]]
   [refx.alpha :as refx]
   [reitit.frontend.easy :as rfe]
   [mockingbird.components.popup :as popup]))

; #TODO remove solid, outline keeping here because it is used in other pages

; deprecated solid -old layout
; deprecated outline -old layout

(def base-styles
  {:solid "group inline-flex items-center justify-center rounded-full py-2 px-4 text-sm font-semibold focus:outline-none focus-visible:outline-2 focus-visible:outline-offset-2 "
   :solid-blue "py-3 px-5 w-full text-base font-medium text-center text-white rounded-lg bg-primary-700 focus:ring-4 focus:ring-primary-300 dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800 "
   :outline "group inline-flex ring-1 items-center justify-center rounded-full py-2 px-4 text-sm focus:outline-none "})

(def variant-styles
  {:solid {:slate "bg-slate-900 text-white hover:bg-slate-700 hover:text-slate-100 active:bg-slate-800 active:text-slate-300 focus-visible:outline-slate-900 ",
           :blue "bg-blue-600 text-white hover:text-slate-100 hover:bg-blue-500 active:bg-blue-800 active:text-blue-100 focus-visible:outline-blue-600 ",
           :white "bg-white text-slate-900 hover:bg-blue-50 active:bg-blue-200 active:text-slate-600 focus-visible:outline-white "},
   :solid-blue {:pink " login-button"
                :grey " login-button-block"}
   :outline {:slate "ring-slate-200 text-slate-700 hover:text-slate-900 hover:ring-slate-300 active:bg-slate-100 active:text-slate-600 focus-visible:outline-blue-600 focus-visible:ring-slate-300 ",
             :pink " login-button"
             :grey " login-button-block"
             :white "ring-slate-700 text-white hover:ring-slate-500 active:ring-slate-700 active:text-slate-400 focus-visible:outline-white "}})

;; TODO
(def aside-styles {})

(defnc button
  [{:keys [children class-name  on-click type disabled template]
    :or {class-name "" on-click "" base "solid" variant "blue" template "default" type "button"}}]
  (d/button
   {:class-name class-name
    :on-click on-click
    :type type
    :disabled disabled}
   children))

(defn get-login-style
  [class-name base variant]
  (let [base-style (keyword base)
        variant-style (keyword variant)]
    (str
     (get base-styles base-style)
     (get-in variant-styles [base-style variant-style])
     class-name)))

(defnc login-button
  [{:keys [children base variant class-name type disabled]
    :or {children "" base "solid" variant "blue" type "submit" disabled false}}]
  (let [class-name (get-login-style class-name base variant)]
    ($ button
       {:class-name class-name
        :type type
        :disabled disabled}
       children)))

(defnc button [])

(defnc new-mock-btn
  [{:keys [?icon1 ?icon2]
    :or {?icon1 "" ?icon2 ""}}]
  ($ button {:class-name "px-3 py-2 bg-pink-600 rounded-lg flex flex-row space-x-2 items-center btn-add"
             :on-click #(refx/dispatch [:app.dashboard/toggle-mock-modal])}
     ($ ?icon1)
     (d/p {:class-name "text-white text-xs font-bold"}
          "new mock")
     ($ ?icon2)))

(defnc toggle-aside-btn
  [{:keys [aside-open?]
    :or {aside-open? false}}]
  (d/button
   {:id "aside-toggle"
    :class (str (if aside-open?
                  "lg:absolute -right-4 "
                  "block w-full ")
                "p-1 mt-2 flex flex-row justify-center z-50 bg-gray-300 rounded-lg "
                "opacity-30 hover:opacity-100 transition-all lg:flex hidden")
    :on-click #(refx/dispatch [:app.dashboard/toggle-aside! (not aside-open?)])}
   ($ svg/arrow
      {:direction (if aside-open?
                    :left
                    :right)
       :class "w-3 h-3"})))

(defnc home-btn
  [{:keys [aside-open?]
    :or {aside-open? false}}]
  (d/button
   {:class-name (str "flex items-center p-2 text-base font-normal text-gray-900 rounded-lg "
                     "transtion duration-75 hover:bg-gray-100 group dark:text-gray-200 dark:hover:bg-gray-700 "
                     (if aside-open?
                       "w-[calc(100%-8px)]"
                       "w-full"))
    :on-click #(rfe/push-state :app.core/dashboard)}
   ($ svg/house)
   (d/span {:class-name (str "ml-3 "
                             (when-not aside-open?
                               "lg:hidden lg:absolute"))} "Home")))



