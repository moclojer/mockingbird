(ns mockingbird.components.navbar
  (:require
   [mockingbird.components.button :refer [new-mock-btn]]
   [mockingbird.components.icons :as svg]
   [front.app.lib :refer [defnc]]
   [reitit.frontend.easy :as rfe]
   [helix.core :refer [$]]
   [helix.dom :as d]
   [refx.alpha :as refx]))

(defnc nav-link
  [{:keys [href children on-click]}]
  (d/a
   {:href href
    :on-click on-click
    :class "inline-block rounded-lg py-1 px-2 text-sm text-slate-700 hover:bg-slate-100 hover:text-slate-900 "}
   children))

(defnc nav-bar
  [{:keys [user-data]}]
  (let [aside (refx/use-sub [:app.dashboard/aside])
        aside-open? (:open? aside)]
    (d/nav
     {:class "fixed mb-16 z-30 w-full bg-white border-b border-gray-200 dark:bg-gray-800 dark:border-gray-700"}
     (d/div
      {:class "py-3 px-3 lg:px-5 lg:pl-3"}
      (d/div
       {:class "flex justify-between items-center"}
       (d/div {:class "flex justify-start items-center"}
              (d/button {:id "toggleSidebar"
                         :aria-expanded "true"
                         :aria-controls "sidebar"
                         :on-click #(refx/dispatch [:app.dashboard/toggle-aside! (not aside-open?)])
                         :class (str "p-2 mr-3 text-gray-600 rounded cursor-pointer "
                                     "hover:text-gray-900 hover:bg-gray-100 dark:text-gray-400 "
                                     "dark:hover:text-white dark:hover:bg-gray-700 lg:hidden")}
                        (if aside-open?
                          ($ svg/hamburger-menu-close)
                          ($ svg/hamburger-menu)))
              (d/button {:class "flex"
                         :on-click #(rfe/push-state :app.core/dashboard)}
                        (d/img {:src "/images/logo.svg"
                                :class "mr-3 h-9"})))
       (d/div {:class "flex items-center lg:gap-3"}
              ($ new-mock-btn)
              ($ user-profile {:user-data user-data})))))))
