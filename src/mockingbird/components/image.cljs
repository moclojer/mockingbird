(ns mockingbird.components.image
  (:refer-clojure :exclude [class])
  (:require
   [mockingbird.lib :refer-macros [defnc]]
   [helix.dom :as d]))

(def pfp-styles {:mockingbird ""})

(defn get-props [size roundness]
(let [actual-size 
      (case size
        :sm "w-8 h-8"
        :md "w-16 h-16"
        :lg "w-32 h-32"
        :else "w-16 h-16")
      actual-roundness 
      (case roundness
        :sm "rounded-sm"
        :full "rounded-full"
        :none "rounded-none"
        :else "rounded-sm")]
  (str actual-size " " actual-roundness " ")))

(defnc pfp 
  [{:keys [class theme image 
           alt size roundness
           children] 
    :or {theme :mockingbird
         image "/images/logo.png"
         alt "test"
         size :sm
         roundness :none}}]
  (let [size (if (keyword? size)
               size
               (keyword size))
        roundness (if (keyword? roundness)
                    roundness 
                    (keyword roundness))]
  (d/div 
    (d/img {:class (str (get pfp-styles theme) " " class " " (get-props size roundness))
            :src image
            :alt alt})
    children)))
