(ns mockingbird.examples.main
  (:require
   [helix.core :refer [$]]
   [helix.dom :as d]
   [mockingbird.components.message :refer [message]]
   [mockingbird.examples.hero :refer [hero]]
   [mockingbird.layout.aside :refer [aside]]
   [mockingbird.layout.footer :refer [footer]]
   [mockingbird.layout.header :refer [header]]
   [mockingbird.layout.main :refer [main]]
   [mockingbird.layout.navbar :refer [nav-bar]]
   [mockingbird.lib :refer-macros [defnc]]))

(defnc app []
  (d/div {:class "w-screen h-screen"}
         ($ header
            ($ nav-bar {:logo "/images/logo.png"})
            ($ hero))
         (comment ($ aside))
         ($ main
            ($ message
               {:title "Welcome to mockingbird"
                :email "avelino@moclojer.com"
                :author "moclojer team"
                :image "/images/logo.png"
                :image-style "rounded"
                :message ["" "I look forward to your feedback (this is the only way we can improve our code)."]}))
         ($ footer)))
