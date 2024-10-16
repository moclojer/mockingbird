(ns
 ^{:doc "Core namespace for re-exporting all Mockingbird layout components.
    This namespace provides a centralized access point for all layout components,
    making it easier to import and use them in other applications."}
  mockingbird.layout.core
  (:refer-clojure :exclude [class type])
  (:require
   [helix.core :refer [$]]
   [mockingbird.layout.aside :as aside]
   [mockingbird.layout.main :as main]
   [mockingbird.layout.footer :as footer]
   [mockingbird.layout.header :as header]
   [mockingbird.layout.navbar :as navbar]))

(defn ^:export main [{:keys [children]}]
  ($ main/main
     (when children children)))

(defn ^:export footer [{:keys [children]}]
  ($ footer/footer
     (when children children)))

(defn ^:export header [{:keys [children]}]
  ($ header/header
     (when children children)))

(defn ^:export navbar [{:keys [children]}]
  ($ navbar/nav-bar
     (when children children)))
