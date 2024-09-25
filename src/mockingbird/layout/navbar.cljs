(ns mockingbird.layout.navbar
  (:require
   [mockingbird.components.button :refer [button]]
   [mockingbird.components.image :refer [image]]
   [mockingbird.lib :refer-macros [defnc]]
   [reitit.frontend.easy :as rfe]
   [helix.core :refer [$]]
   [helix.dom :as d]
   [refx.alpha :as refx]))

(def navlink-style "inline-block rounded-lg py-1 px-2 text-sm text-slate-700 hover:bg-slate-100 hover:text-slate-900 ")

(def styles {:mockingbird "z-30 w-full h-max bg-white border-b border-gray-200 dark:bg-gray-800 dark:border-gray-700 "})

(defnc nav-link
  [{:keys [href on-click children]
    :or {href ""
         on-click (fn [_])
         children ""}}]
  (d/a
   {:href href
    :on-click on-click
    :class navlink-style}
   children))

(defnc nav-bar
  [{:keys [theme aside-state hamburguer-menu
           hamburguer-menu-close label logo
           buttons fixed? & children]
    :or {theme :mockingbird
         aside-state false
         fixed? true
         hamburguer-menu false
         hamburguer-menu-close false
         buttons nil
         label false
         logo false}}]
  (let [aside-open? (:open? aside-state)]
    (d/nav
     {:class (str (when fixed? "fixed ")
                  (get styles theme))}
     (d/div
      {:class "py-3 px-3 lg:px-5 lg:pl-3"}
      (d/div
       {:class "flex justify-between items-center"}
       (d/div {:class "flex justify-start items-center"}
              (when hamburguer-menu
                ($ button {:id "toggleSidebar"
                           :on-click "" #_#(rfe/push-state :app.core/dashboard)
                           :class (str "p-2 mr-3 text-gray-600 rounded cursor-pointer "
                                       "hover:text-gray-900 hover:bg-gray-100 dark:text-gray-400 "
                                       "dark:hover:text-white dark:hover:bg-gray-700 lg:hidden")}
                   #_(if aside-open?
                       ($ icon hamburger-menu-close)
                       ($ icon hamburger-menu))))
              (when logo
                ($ button {:type :icon
                           :disabled false
                           :class "flex "}
                   ($ image {:src logo
                             :class "mr-3 "})
                   (when label
                     (d/div {:class "w-max h-full flex items-center justify-center"}
                            (d/h1 {:class "text-2xl text-center"} "MOCKINGBIRD")))))
              (when buttons
                buttons)))
      children))))

