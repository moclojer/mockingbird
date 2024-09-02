(ns mockingbird.utils.props)

(defn get-props 
  [{:keys [size roundness shadow 
           margin padding class]
    :or {size :md roundness :md shadow :md padding :md margin :md}}]
  (let [actual-size 
        (case size
          :sm "w-8 h-8"
          :md "w-16 h-16"
          :lg "w-32 h-32"
          :xl "w-64 h-64"
          :full "w-full"
          :else " ")
        actual-roundness
        (case roundness
          :sm "rounded-sm"
          :md "rounded-md"
          :full "rounded-full"
          :none "rounded-none"
          :else " ")
        cast-shadow
        (case shadow
          :none "shadow-none"
          :sm "shadow-sm"
          :md "shadow-md"
          :lg "shadow-lg"
          :else " ")
        actual-padding
        (case padding
          :none "p-0"
          :sm "p-2"
          :md "p-4"
          :lg "p-8"
          :else " ")
        actual-margin
        (case margin
          :none "m-0"
          :sm "m-2"
          :md "m-4"
          :lg "m-8"
          :else " ")]
    (str actual-size " " actual-roundness " " cast-shadow " " actual-padding " " actual-margin " " class)))
