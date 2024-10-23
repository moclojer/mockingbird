# Using our NPM package

> disclaimer: currently, only supports other cljs projects. Not tested in non cljs projects. 

To install mockingbird, simply run:

```sh

npm i mockingbird-cljs

```


deps.edn example config (you will need at least helix and shadow-cljs to use mockingbird):

```clj 

{:paths ["src" "resources"]
 :deps {;;moclojer/mockingbird {:local/root "../../mockingbird/target/mockingbird-0.0.1.jar"}
        com.fbeyer/refx {:mvn/version "0.0.49"}
        lilactown/helix {:mvn/version "0.1.11"}
        com.teknql/shadow-cljs-tailwind-jit {:mvn/version "1.0.0"}}
 :aliases {:dev {:extra-paths ["test"]
                 :extra-deps {cider/cider-nrepl {:mvn/version "0.28.6"}
                              thheller/shadow-cljs {:mvn/version "2.20.10"}}}}}

```

# Usage

This is an example of using mockingbird without clojars:

```clj 

(ns main.core
  (:require 
    ["mockingbird-cljs" :refer [button]]
    ["react-dom/client" :as rdom]
    [helix.core :refer [$ <>]]))

;; this is a front app application using shadow-cljs, postcss, helix and refx.
;; You can see a simple page example running here.

(defn app []
  (<>
    (button 
      {:type  :text
       :theme :mockingbird
       :size  :md }
      "my magic button")))

(defonce root
  (rdom/createRoot (js/document.getElementById "app")))

(defn render []
  (.render root ($ app)))

(defn ^:export init []
  (render))

```

> You will also need to grab our _target.css_, file which can be found at "node_nodules/mockingbird-cljs/target.css", and link it to your index.html
