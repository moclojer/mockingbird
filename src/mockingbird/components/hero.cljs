(ns mockingbird.components.hero
  (:require
   [helix.dom :as d]
   [helix.core :refer [$]]
   [mockingbird.lib :refer-macros [defnc]]
   [mockingbird.components.image :refer [pfp]]))

(defnc hero []
  (d/div {:class "group p-16 mt-16 w-screen h-full bg-gray-50 flex items-center justify-left"}
    (d/div {:class "flex justify-center w-1/3"}
      ($ pfp {:theme :mockingbird :size :lg}))
    (d/div {:class "w-full"}
      (d/h1 {:class "ml-16 text-4xl"} "MOCKINGBIRD"))))

;; TODO: Implement the hero component
