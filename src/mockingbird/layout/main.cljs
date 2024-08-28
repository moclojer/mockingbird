(ns mockingbird.layout.main
  (:require 
    [helix.dom :as d]
    [mockingbird.lib :refer-macros [defnc]]))

(defnc main [{:keys [children]}]
  (d/div {:class "w-screen h-max"}
    children))
