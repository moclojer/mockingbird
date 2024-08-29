(ns mockingbird.utils.props)

(defn get-props [size roundness shadow & classes]
  (let [actual-size 
        (case size
          :sm "w-8 h-8"
          :md "w-16 h-16"
          :lg "w-32 h-32"
          :xl "w-64 h-64"
          :full "w-full md:w-1/2 sm:w-1/3 "
          :2x "w-2xl"
          :else " ")
        actual-roundness
         (case roundness
          :sm "rounded-sm"
          :full "rounded-full"
          :none "rounded-none"
          :else " ")
        cast-shadow
        (case shadow
          :sm ""
          :none " "
          :else " ")]
    (str actual-size " " actual-roundness " " cast-shadow " " classes)))
