(ns mockingbird.components.popup
  (:require
   [mockingbird.lib :refer-macros [defnc]]
   [helix.core :refer [$]]
   [helix.dom :as d]
   [helix.hooks :as hooks]
   [refx.alpha :as refx]))

;; notification
(refx/reg-sub
 :app/notifications
 (fn [db _]
   (:notifications db)))

(refx/reg-event-db
 :app/enqueue-notification
 (fn [db [_ notification]]
   (update-in db [:notifications]
              assoc (random-uuid) notification)))

(refx/reg-event-db
 :app/dequeue-notification
 (fn [db [_ id]]
   (update-in db [:notifications] dissoc id)))

(refx/reg-fx
 :notification
 (fn [notification]
   (refx/dispatch [:app/enqueue-notification
                   notification])))
;; alerts
(def error-styles
  {:card "rounded border-l-4 border-red-500 bg-red-50 p-4"
   :tittle "block font-medium text-red-700"
   :desc "mt-2 text-sm text-red-700"})

(defnc error
  [{:keys [id error description]}]
  (let [{:keys [card title desc]} error-styles]
    (d/div
     {:id id
      :class card}
     (d/strong
      {:class title}
      error)
     (when description
       (d/p
        {:class desc}
        (str description))))))

(def toast-data
  {:info {:class "bg-green-50 fill-green-700 text-green-700 border-green-700"}
   :error {:class "bg-red-50 fill-red-700 text-red-700 border-red-700"}})

(defnc toast [{[id {:keys [type content icon]}] :children}]
  (hooks/use-effect
   :once
   (js/setTimeout
    #(refx/dispatch-sync [:app/dequeue-notification id])
    1500))

  (d/div
   {:class (str "w-fit px-5 py-4 bg-blue-600 rounded-lg border-2 "
                (get-in toast-data [type :class]))}
   (d/div
    {:class "flex flex-row items-center align-center space-between"}
    (d/div
     {:class "flex flex-row space-x-2 items-center align-center"}
     (when (icon)
       ($ icon))
     (d/span content)))))

(defnc notifications []
  (let [ns (refx/use-sub [:app/notifications])]
    (d/div
     {:class (str "flex flex-col start space-y-2 right-8 "
                  "bottom-8 z-50 "
                  (if (empty? ns) "hidden" "fixed"))}
     (for [n ns]
       ($ toast n)))))
