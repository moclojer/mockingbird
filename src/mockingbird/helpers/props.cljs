(ns mockingbird.helpers.props)

(defn get-props
  [{:keys [size width height
           roundness shadow
           margin padding class]
    :or {size :md width nil height nil roundness :none shadow :none padding :none margin :none}}]
  (let [actual-size
        (case size
          :none ""
          :sm "w-8 h-8 "
          :md "w-16 h-16 "
          :lg "w-32 h-32 "
          :xl "w-64 h-64 "
          :full "w-full "
          "w-16 h-16 ")
        actual-roundness
        (case roundness
          :none ""
          :sm "rounded-sm "
          :md "rounded-md "
          :full "rounded-full "
          nil)
        cast-shadow
        (case shadow
          :none ""
          :sm "shadow-sm "
          :md "shadow-md "
          :lg "shadow-lg "
          nil)
        actual-padding
        (case padding
          :none ""
          :sm "p-2 "
          :md "p-4 "
          :lg "p-8 "
          nil)
        actual-margin
        (case margin
          :none ""
          :sm "m-2 "
          :md "m-4 "
          :lg "m-8 "
          nil)]
    (str class " " actual-size actual-roundness cast-shadow actual-padding actual-margin )))
