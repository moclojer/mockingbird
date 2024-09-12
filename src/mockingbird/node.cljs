(ns mockingbird.node
  (:require
   [mockingbird.components.button :refer [button]]
   [mockingbird.components.input :refer [input]]
   [mockingbird.components.image :refer [image pfp]]))

(defn hello []
  (prn "hello")
  "hello")

(defn generate-exports []
  #js{:hello hello
      :button button
      :image image
      :pfp pfp
      :input input})
