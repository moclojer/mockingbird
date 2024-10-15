(ns mockingbird.components.core
  (:refer-clojure :exclude [class type])
  (:require
    [helix.core :refer [$]]
    [mockingbird.components.aside :as aside]
    [mockingbird.components.breadcrumb :as breadcrumb]
    [mockingbird.components.button :as button]
    [mockingbird.components.filedropdown :as filedropdown]
    [mockingbird.components.form :as form]
    [mockingbird.components.hero :as hero]
    [mockingbird.components.icon :as icon]
    [mockingbird.components.image :as image]
    [mockingbird.components.input :as input]
    [mockingbird.components.message :as message]
    [mockingbird.components.pfp :as pfp]
    [mockingbird.components.popup :as popup]
    [mockingbird.components.selectdropdown :as selectdropdown]
    [mockingbird.components.status :as status]))

;; Re-export all components
(defn ^:export aside [keys] 
  ($ aside/aside {:keys keys}))

(def ^:export breadcrumb breadcrumb/breadcrumb )

(defn ^:export button
  [{:keys [class theme type
           disabled label on-click
           size roundness shadow
           margin padding loading? children]
    :or {class ""
         theme :mockingbird
         type :submit
         disabled false
         label "Insert some text"
         on-click (fn [_])
         size :md
         roundness :md
         shadow :none
         margin :none
         padding :none
         loading? false
         children nil}}]
  ($ button/button 
     {:class class
      :theme theme
      :type type
      :disabled disabled
      :label label
      :on-click on-click
      :size size
      :roundness roundness
      :shadow shadow
      :margin margin
      :padding padding
      :loading? loading? }
     children))

(defn ^:export filedropdown [keys] 
  ($ filedropdown/filedropdown {:keys keys}))

(defn ^:export form [keys] 
  ($ form/form {:keys keys}))

(defn ^:export hero [keys] 
  ($ hero/hero {:keys keys}))

(defn ^:export icon [keys] 
  ($ icon/icon {:keys keys}))

(defn ^:export image [keys] 
  ($ image/image {:keys keys}))

(defn ^:export input [keys] 
  ($ input/input {:keys keys}))

(defn ^:export message [keys] 
  ($ message/message {:keys keys}))

(defn ^:export pfp [keys] 
  ($ pfp/pfp {:keys keys}))

(defn ^:export selectdropdown [keys] 
  ($ selectdropdown/selectdropdown {:keys keys}))
