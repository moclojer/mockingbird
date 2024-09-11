(ns mockingbird.node
  (:require
   [mockingbird.components.button :refer [button]]
   [mockingbird.components.image :refer [pfp]]
   [helix.dom :as d]))

(defn hello []
  (prn "hello")
  "hello")

(defn generate-exports []
  #js{:hello hello
      :helix-dom d/img
      :button button
      :image pfp})
