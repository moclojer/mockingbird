(ns mockingbird.examples.main
  (:require
   [helix.core :refer [$]]
   [helix.dom :as d]
   [mockingbird.lib :refer-macros [defnc]]
   [mockingbird.components.aside :refer [aside]]
   [mockingbird.layout.footer :refer [footer]]
   [mockingbird.layout.header :refer [header]]
   [mockingbird.components.hero :refer [hero]]
   [mockingbird.layout.main :refer [main]]
   [mockingbird.layout.navbar :refer [nav-bar]]))

;; TODO create a example to render on this app and demonstrate the components power!
(defnc app []
  (d/div {:class "w-screen h-screen"}
         ($ header
            ($ nav-bar)
            ($ hero))
         (comment ($ aside))
         ($ main (d/p "ok"))
         ($ footer)))
