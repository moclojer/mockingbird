(ns dev.core
  (:require
   [mockingbird.core :as m]))

;; TODO
(defn ^:export init
  []
  (try
    (m/init)
    (catch js/Error e
      (js/console.error "Initialization failed:" (.message e)))))

