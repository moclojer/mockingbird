(ns mockingbird.layout.header
  (:require
   [helix.dom :as d]
   [mockingbird.lib :refer-macros [defnc]]))

(defnc header [{:keys [children]}]
  (d/div {:class "w-screen h-max"}
         children))
