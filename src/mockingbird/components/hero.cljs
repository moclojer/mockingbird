(ns mockingbird.components.hero
  (:require
   [helix.dom :as d]
   [helix.core :refer [$]]
   [mockingbird.lib :refer-macros [defnc]]
   [mockingbird.components.button :refer [button]]
   [mockingbird.components.image :refer [image]]))

(defnc ^:export hero []
  (d/div {:class "group w-screen h-screen bg-gray-50 flex items-center justify-left pl-16 flex-row md:flex-row sm:flex-col md:h-screen sm:h-[calc(600px)]"}
         (d/div {:class "flex justify-center lg:w-1/3 sm:w-full"}
                ($ image {:theme :mockingbird
                          :size :full}))
         (d/div {:class "w-full lg:ml-32 md:ml-0"}
                (d/h1 {:class "text-[calc(120px)] lg:text-[calc(90px)] md:text-[calc(60px)] sm:text-[calc(40px)]"} "MOCKINGBIRD")
                (d/p  {:class "ml-2 pb-4 w-[calc(60%)] line-clamp-6"} "A simple way to develop a user interface with a consistent user experience, without the need to clutter cljs code with CSS.")
                (d/div {:class "flex"}
                       ($ button {:theme :mockingbird
                                  :class "mr-2"}
                          (d/a {:href "https://github.com/moclojer/mockingbird/blob/main/README.md"
                                :target "blank"}
                               "Learn More"))
                       ($ button {:type :highlight
                                  :theme :mockingbird
                                  :roundness :full}
                          (d/a {:href "https://github.com/moclojer/mockingbird"
                                :target "blank"}
                               "Test It Out"))))))
