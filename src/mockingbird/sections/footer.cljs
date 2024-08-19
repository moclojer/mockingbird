(ns mockingbird.sections.footer
  (:require [cljs.pprint :as pprint]
            [front.app.components.container :refer [aside-container]]
            [front.app.lib :refer [defnc]]
            [helix.core :refer [$]]
            [helix.dom :as d]
            [refx.alpha :as refx]))

(defnc footer []
  (let [db (refx/use-sub [:app.database/db])]
    (d/footer {:class-name "bg-slate-50"}
              ($ aside-container
                 (d/pre (with-out-str
                          (pprint/pprint db)))))))
