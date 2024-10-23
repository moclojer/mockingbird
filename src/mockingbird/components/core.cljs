(ns
 ^{:doc "Core namespace for re-exporting all Mockingbird UI components.
    This namespace provides a centralized access point for all components,
    making it easier to import and use them in other applications."}
 mockingbird.components.core
  (:refer-clojure :exclude [class type])
  (:require
   [helix.core :refer [$]]
   [mockingbird.components.breadcrumb :as breadcrumb]
   [mockingbird.components.button :as button]
   [mockingbird.components.filedropdown :as filedropdown]
   [mockingbird.components.form :as form]
   [mockingbird.components.icon :as icon]
   [mockingbird.components.image :as image]
   [mockingbird.components.input :as input]
   [mockingbird.components.message :as message]
   [mockingbird.components.pfp :as pfp]
   [mockingbird.components.popup :as popup]
   [mockingbird.components.selectdropdown :as selectdropdown]
   [mockingbird.components.status :as status]))

(defn ^:export button
  [{:keys [class theme type
           disabled label on-click
           size roundness shadow
           margin padding loading?]
    :or {class ""
         theme :mockingbird
         type :submit
         disabled false
         label nil
         on-click (fn [_])
         size :md
         roundness :md
         shadow :none
         margin :none
         padding :none
         loading? false}}
   children]
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
      :loading? loading?}
     children))

(defn ^:export icon
  [{:keys [class theme icon-name size color loading?]
    :or {class ""
         theme :mockingbird
         icon-name "default-icon"
         size :md
         color "black"
         loading? false}}
   children]
  ($ icon/icon
     {:class class
      :theme theme
      :icon-name icon-name
      :size size
      :color color
      :loading? loading?}
     children))

(defn ^:export image
  [{:keys [class theme src alt
           size roundness shadow
           margin padding loading?]
    :or {class ""
         theme :mockingbird
         src "/images/logo.png"
         alt "Image description"
         size :md
         roundness :none
         shadow :none
         margin :none
         padding :none
         loading? false}}
   children]
  ($ image/image
     {:class class
      :theme theme
      :src src
      :alt alt
      :size size
      :roundness roundness
      :shadow shadow
      :margin margin
      :padding padding
      :loading? loading?}
     children))

(defn ^:export input
  [{:keys [class theme value placeholder
           on-change disabled loading?]
    :or {class ""
         theme :mockingbird
         value ""
         placeholder "Enter text"
         on-change (fn [_])
         disabled false
         loading? false}}
   children]
  ($ input/input
     {:class class
      :theme theme
      :value value
      :placeholder placeholder
      :on-change on-change
      :disabled disabled
      :loading? loading?}
     children))

(defn ^:export message
  [{:keys [class theme content type loading?]
    :or {class ""
         theme :mockingbird
         content ""
         type :info
         loading? false}}
   children]
  ($ message/message
     {:class class
      :theme theme
      :content content
      :type type
      :loading? loading?}
     children))

(defn ^:export pfp
  [{:keys [class theme style src alt
           size roundness shadow
           margin padding loading?]
    :or {class ""
         theme :mockingbird
         style :default
         src "/images/logo.png"
         alt "Profile picture"
         size :md
         roundness :none
         shadow :none
         margin :none
         padding :none
         loading? false}}
   children]
  ($ pfp/pfp
     {:class class
      :theme theme
      :style style
      :src src
      :alt alt
      :size size
      :roundness roundness
      :shadow shadow
      :margin margin
      :padding padding
      :loading? loading?}
     children))
