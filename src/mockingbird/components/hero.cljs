(ns mockingbird.components.hero
  (:require
   [helix.dom :as d]
   [helix.core :refer [$]]
   [mockingbird.lib :refer-macros [defnc]]
   [mockingbird.components.image :refer [pfp]]))

(defnc hero []
  (d/div {:class "w-screen h-max bg-gray-50 flex"}
    (d/div 
      ($ pfp {:theme :mockingbird :size " h-[calc(30%-5pxw-[calc(30%-5px)])]"}))
    (d/div 
      (d/h1 "title"))))

;; TODO: Implement the hero component


