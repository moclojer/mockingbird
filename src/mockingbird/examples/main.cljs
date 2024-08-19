(ns mockingbird.examples.main
  (:require [mockingbird.lib :refer [defnc]]
            [helix.dom :as d]))

;; TODO create a example to render on this app and demonstrate the components power!
(defnc landing-page-test []
  ($ header)
  ($ aside)
  ($ hero)
  ($ footer))
