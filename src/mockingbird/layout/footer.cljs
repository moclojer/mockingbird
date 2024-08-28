(ns mockingbird.layout.footer
  (:require [cljs.pprint :as pprint]
            [mockingbird.lib :refer-macros [defnc]]
            [helix.core :refer [$]]
            [helix.dom :as d]
            [refx.alpha :as refx]))

(defnc footer []
    (d/footer {:class-name "bg-slate-50"}
              (d/div 
                 (d/pre (with-out-str
                          (pprint/pprint ""))))))
