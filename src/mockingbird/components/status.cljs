(ns mockingbird.components.status
  (:require [mockingbird.lib :refer [defnc]]
            [helix.core :refer [$]]
            [helix.hooks :as hooks]
            [helix.dom :as d]
            [refx.alpha :as refx]))

(defnc status-card [{:keys [status loading? title]}]
  (d/div {:class (str "px-3 mr-2 flex flex-row space-x-2 items-center rounded-md dns-"
                      (name status) (when loading? " opacity-70 animate-pulse"))}
         ($ (case status
              :offline svg/dns-offline
              :offline-invalid svg/dns-offline
              :publishing svg/dns-publishing
              :published svg/dns-published
              :default svg/dns-offline))
         (d/p {:class "text-sm font-semibold"} title)))

(defnc publication-status
  "There are 4 possible status:

   1. offline
   2. offline-invalid
   3. publishing
   4. published

   A mock is offline only if its not enabled, not
   saved yet, or invalid. When saved, we ping the
   domain, and while not returning a 200 OK for
   the max of 24 attempts, it will be :publishing,
   or :published otherwise.

   When :offline, it will try to ping as well,
   since newly created mocks are offline, but
   they do need to be pinged."
  [{:keys [children enabled id stt-type title]
    :or {enabled (:enabled children)
         id (:id children)
         stt-type (:stt-type children)
         title (:title children)}}]
  (let [{:keys [attempt]
         :or {attempt 0}
         :as pub-stt} (refx/use-sub [:app.dashboard/mock-pub-stts id])
        status (get pub-stt stt-type)
        loading? (and enabled (< attempt 24)
                      (some #(= % status)
                            ["publishing" "offline"]))]

    (hooks/use-effect
     [status attempt]
     (when loading?
       (js/setTimeout #(refx/dispatch
                        [:app.dashboard/get-mock-pub-stts
                         {:mock-id id}])
                      5000)))

    ($ status-card
       {:status (if enabled
                  (or (keyword status) :publishing)
                  :offline)
        :loading? loading?
        :title title})))
