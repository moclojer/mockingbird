(ns mockingbird.layout.footer
  (:require [cljs.pprint :as pprint]
            [mockingbird.lib :refer-macros [defnc]]
            [helix.core :refer [$]]
            [helix.dom :as d]
            [refx.alpha :as refx]))

(defnc footer [{:keys [children]}]
  (d/footer
   {:class-name "bg-slate-50"}
   children))
