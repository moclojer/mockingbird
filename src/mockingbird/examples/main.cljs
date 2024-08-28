(ns mockingbird.examples.main
  (:require 
    [helix.core :refer [$]]
    [helix.dom :as d]
    [mockingbird.lib :refer-macros [defnc]]
    [mockingbird.components.aside :refer [aside]]
    [mockingbird.layout.footer :refer [footer]]
    [mockingbird.layout.header :refer [header]]
    [mockingbird.components.hero :refer [hero]]
    [mockingbird.components.main :refer [main]]))

;; TODO create a example to render on this app and demonstrate the components power!
(defnc main []
  (d/div
    ($ header 
       ($ hero))
    #_($ aside)
    ($ main (d/p "ok"))
    ($ footer)))
