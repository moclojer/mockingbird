(ns mockingbird.components.hero
  (:require
   [helix.dom :as d]
   [helix.core :refer [$]]
   [mockingbird.lib :refer-macros [defnc]]
   [mockingbird.components.button :refer [button]]
   [mockingbird.components.pfp :refer [pfp]]))

(defnc hero []
  (d/div {:class "group w-screen h-screen bg-gray-50 flex items-center justify-left pl-16"}
         (d/div {:class "flex justify-center w-1/3"}
                ($ pfp {:theme :mockingbird
                        :size :full}))
         (d/div {:class "w-full ml-32 "}
                (d/h1 {:class "text-[calc(120px)] lg:text-[calc(90px)] md:text-[calc(60px)]"} "MOCKINGBIRD")
                (d/div {:class "flex"}
                       ($ button {:theme :mockingbird
                                  :class "mr-2"} "Learn More")
                       ($ button {:type :highlight
                                  :theme :mockingbird} "Test It Out")))))

;; TODO: Implement the hero component
