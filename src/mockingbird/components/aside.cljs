(ns mockingbird.components.aside
  (:require
   [mockingbird.components.button :refer [button]]
   [mockingbird.lib :refer-macros [defnc]]
   [helix.core :refer [$]]
   [helix.dom :as d]
   [helix.hooks :as hooks]
   [refx.alpha :as refx]
   [reitit.frontend.easy :as rfe]))

#_(defnc mock []
  (let [aside (refx/use-sub [:app.dashboard/aside])
        aside-open? (:open? aside)
        current-user (refx/use-sub [:app.auth/current-user])
        menu-open? (refx/use-sub [:app.dashboard/is-menu-open?])
        mocks-raw (refx/use-sub [:app.dashboard/mocks-raw])]

    (hooks/use-effect
     [mocks-raw]
     (when (nil? mocks-raw)
       (refx/dispatch-sync [:app.dashboard/get-mocks current-user])))

    (d/li
     (d/div
      {:class "flex flex-row"}
      (d/button
       {:on-click #(rfe/push-state :app.core/mocks)
        :class (str "flex items-center p-2 w-full text-base font-normal text-gray-900 rounded-lg "
                    "transition duration-75 group hover:bg-gray-100 dark:text-gray-200 dark:hover:bg-gray-700 ")
        :aria-controls "dropdown-mocks"
        :aria-expanded aside-open?
        :data-collapse-toggle "dropdown-mocks"}
       (d/span {:class (str "flex ml-3 text-left whitespace-nowrap "
                            (when-not aside-open?
                              "lg:absolute lg:hidden"))} "Mocks"))
      (d/button
       {:class (str "px-2 rounded-lg fill-gray-200 bg-transparent hover:bg-gray-200 hover:fill-gray-400 "
                    (if aside-open? "block " "hidden "))
        :on-click #(refx/dispatch-sync [:app.dashboard/toggle-menu])})))))

(defnc aside
  [{:keys [id class type template
           aria-label position]
    :or {id ""
         class ""
         template :mockingbird
         aria-label "Sidebar"
         position :left}}]
  (d/div
   {:class "overflow-hidden bg-gray-50 dark:bg-gray-900 pt-16"}
   (d/aside
    {:id "sidebar"
     :class (str "fixed flex-col top-0 left-0 z-20 flex-shrink-0 w-full h-full duration-75 transition-width "
                 #_(if aside-open? "flex lg:w-64" "hidden lg:flex lg:w-16"))
     :aria-label aria-label}

    (d/div
     {:class (str "flex relative flex-col flex-1 pt-16 min-h-0 bg-white border-r "
                  "border-gray-200 dark:bg-gray-800 dark:border-gray-700")}
     (d/div {:class "flex overflow-y-auto flex-col flex-1 pt-5 pb-4"}
            (d/div {:class "flex-1 px-3 space-y-1 bg-white divide-y divide-gray-200 dark:bg-gray-800 dark:divide-gray-700"}
                   (d/ul {:class "pb-2 space-y-2 pt-4"}
                         (d/li
                          ($ button {:template "aside"}))
                         (d/div {:class "pt-2 space-y-2"}
                                (d/a {:href "https://docs.moclojer.com/"
                                      :target "_blank"
                                      :class (str "flex items-center p-2 text-base font-normal text-gray-900 rounded-lg transition"
                                                  " duration-75 hover:bg-gray-100 group dark:text-gray-200 dark:hover:bg-gray-700")}
                                     (d/span {:class
                                              (str "ml-3 "
                                                   #_(when-not aside-open?
                                                     "lg:hidden lg:absolute"))}
                                             "Docs"))
                                (d/a {:href "https://discord.gg/pbhBzKjhTb"
                                      :target "_blank"
                                      :class "flex items-center p-2 text-base font-normal text-gray-900 rounded-lg transition duration-75 hover:bg-gray-100 group dark:text-gray-200 dark:hover:bg-gray-700"}
                                     (d/span {:class
                                              (str "ml-3 "
                                                   #_(when-not aside-open?
                                                     "lg:hidden lg:absolute"))}
                                             "Help")))))
            (d/div {:class (str "absolute bottom-0 left-0 justify-center p-4 space-x-4 w-full lg:flex"
                                #_(when aside-open?
                                  " flex-col space-y-4 p-4"))}
                   ($ button {:class "flex items-center p-2 text-base font-normal text-gray-900 rounded-lg transition duration-75 hover:bg-gray-100 group dark:text-gray-200 dark:hover:bg-gray-700"
                              :icon ""})
                   #_(when aside-open?
                     (d/span {:class "ml-3"}
                             "Logout"))))))))
