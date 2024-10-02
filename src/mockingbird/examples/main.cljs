(ns mockingbird.examples.main
  (:require
    [helix.core :refer [$]]
    [helix.dom :as d]
    [mockingbird.lib :refer-macros [defnc]]
    [mockingbird.components.aside :refer [aside]]
    [mockingbird.components.message :refer [message]]
    [mockingbird.layout.footer :refer [footer]]
    [mockingbird.layout.header :refer [header]]
    [mockingbird.components.hero :refer [hero]]
    [mockingbird.layout.main :refer [main]]
    [mockingbird.layout.navbar :refer [nav-bar]]))

;; TODO create a example to render on this app and demonstrate the components power!
(defnc app []
  (d/div {:class "w-screen h-screen"}
         ($ header
            ($ nav-bar {:logo "/images/logo.png"})
            ($ hero))
         (comment ($ aside))
         ($ main 
            ($ message
               {:title "Welcome to moclojer beta"
                :email "avelino@moclojer.com"
                :author "Avelino"
                :image "/images/logo.png"
                :image-style "rounded"
                :message ["I'm happy to have you here, we are launching the SaaS version of moclojer, seeking to make it simple for you to put a mock API in the air to develop your projects." "I look forward to your feedback (this is the only way we can improve the product)."]}))
         ($ footer)))
