(ns mockingbird.components.aside
  (:require
   [mockingbird.components.button :refer [button]]
   [mockingbird.components.icon :refer [icon]]
   [mockingbird.lib :refer-macros [defnc]]
   [helix.core :refer [$]]
   [helix.dom :as d]
   [helix.hooks :as hooks]
   [refx.alpha :as refx]
   [reitit.frontend.easy :as rfe]))

;; TODO add mock content
(defnc mock [{:keys [aside aside-open? 
                     current-user menu-open?
                     mocks-raw when-mock-raw
                     children]
              :or {aside "" aside-open? false
                   current-user "" menu-open? false
                   mocks-raw false when-mock-raw ""}}]
      (d/li
       (d/div
        {:class "flex flex-row"}
        children)))

(defnc aside
  [{:keys [id class type theme
           aria-label position
           children]
    :or {id ""
         class ""
         theme :mockingbird
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
                          ($ button {:theme "aside"} "a"))
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
            (d/div
             {:class (str "absolute bottom-0 left-0 justify-center p-4 space-x-4 w-full lg:flex"
                          #_(when aside-open?
                              " flex-col space-y-4 p-4"))}
             ($ button
                {:class (str "flex items-center p-2 text-base font-normal text-gray-900 rounded-lg transition "
                             "duration-75 hover:bg-gray-100 group dark:text-gray-200 dark:hover:bg-gray-700")
                 :theme ""} ($ icon))
             #_(when aside-open?
                 (d/span {:class "ml-3"}
                         "Logout"))))))))


;; TODO aside specific components
(defnc aside-componet [])
