(ns mockingbird.examples.main
  (:require [mockingbird.lib :refer [defnc]]
            [helix.dom :as d]))

;; TODO create a example to render on this app and demonstrate the components power!
(try
  ($ header)
  ($ aside)
  ($ hero)
  ($ footer)
  (catch js/Error e
    (js/console.error "Error rendering components:" e)))
