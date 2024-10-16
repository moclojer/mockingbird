# mockingbird

Design System using [tailwind](https://tailwindcss.com/) and [helix](https://github.com/lilactown/helix) in [ClojureScript](https://clojurescript.org/).

A simple way to develop a user interface with a consistent user experience, without the need to clutter **cljs** code with **CSS** (unless you want to).

> Work In Progress: if your desire is to use mockingbird using npm (how dare you!), you can, of course, use our npm package. Read more [here](docs/npm.md).

## name reference?

> "mockingbird" is for everyone!

The name is a reference to the book [To Kill a Mockingbird](https://en.wikipedia.org/wiki/To_Kill_a_Mockingbird) by Harper Lee. The idea is that the design system is a "mockingbird" that sings the same song everywhere.

It's impossible to talk about *"mockingbird"* without remembering the song [Mockingbird by Eminem](https://www.youtube.com/watch?v=S9bCLPwzSC0) with his daughter Hailie Jade. The song is a declaration of love from a father to his daughter.

**mockingbird** is a declaration of love for all developers ~~(frontend will never be easy for backend developers)~~.

# Overview

Mockingbird offers a set of reusable components and utilities that increases speed and beauty on your UI development. By integrating Tailwind, Helix and ReFx, Mockingbird combines functional programming and a powerful component model in order to create a fast and lightweight design system. This allows your team to focus on building robust, reactive interfaces without getting bogged down in styling and local state management concerns.

# Getting Started

Prerequisites

Before you begin, ensure you have the following installed:
- Clojure: Follow the [Clojure Installation guide](https://clojure.org/guides/install_clojure) to set up your environment.
- [Node](https://nodejs.org/en/download/prebuilt-installer/current).
- [npm](https://www.npmjs.com/package/downloads).

# Installation

We distribute our software via clojars (and intend to do so also by npm):

deps.edn:
``` clj
  moclojer/mockingbird {:mvn/version "0.0.1"}
```

You will also need to start a project with shadow-cljs and install the npm deps.

npm:

``` sh

$ npx create-cljs-project your-project
$ npm install react react-dom react-refresh autoprefixer css-loader cssnano karma karma-chrome-launcher karma-cljs-test msw npm-run-all postcss postcss-cli postcss-loader postcss-preset-env shadow-cljs tailwindcss rimraf glob cliui --save-dev

```

Consider creating a package.json file and adding these used dependencies or, maybe, you can just copy our package.json. 

As you can see, our components have specific built-in styles for you. You can see a handful tutorial on the parameters for styling the components [here](docs/params.md).

## deps.edn
Add these deps to your project in order to render using helix.

``` clj

{:paths ["src" "resources"]
 :deps {moclojer/mockingbird {:mvn/version "0.0.1"}
        com.fbeyer/refx {:mvn/version "0.0.49"}
        lilactown/helix {:mvn/version "0.1.11"}
        com.teknql/shadow-cljs-tailwind-jit {:mvn/version "1.0.0"}}
 :aliases {:dev {:extra-paths ["test"]
                 :extra-deps {cider/cider-nrepl {:mvn/version "0.28.6"}
                              thheller/shadow-cljs {:mvn/version "2.20.10"}}}}}

```

## Shadow cljs config
This is a shadow-cljs config example, you can use it the way you want it

``` clj

{:deps {:aliases [:dev]}
 :builds {:app {:target      :browser
                :output-dir  "resources/public/assets/js"
                :asset-path  "/assets/js"
                :devtools    {:reload-strategy :full
                              :http-port 8080
                              :http-root "resources/public"}
                :dev         {:modules {:core {:init-fn your.ns.core/init}}}}}}

```

# Usage 

Add a import on a specific component or layout component you want and load it in your screen

``` clj
(:require 
  [mockingbird.components.button :refer [button]]
  [helix.core :refer [$]])
  ;; use it then
  ($ button)

```

You can pass arguments into our components simply as this:


``` clj

    ($ button {:type :submit
               :theme :mockingbird
               :size :lg} 
    "my magic button")

```

# Getting our styles

Add this entry to your shadow-cljs build, so you can copy the styles from our .jar file. 

> remember to create the direcotory where your css file will be set.

``` clj
:build-hooks [(mockingbird.dev.shadow.hooks/get-target-css 
    {:path "resources/public/assets/css/target.css"})]
```

``` html
# html file exambple

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>My Project</title>
    <link rel="stylesheet" href="./assets/css/target.css">
  </head>
  <body>
    <div id="app"></div>
    <script src="./assets/js/core.js"></script> 
  </body>
</html>
```
This hook copies the Mockingbird styles from the JAR file to your project's resources directory during the build process.

# Rendering with shadow-cljs

You will also need to render the components on your UI, so you can use our [core file](src/mockingbird/core.cljs) and this [example file](src/mockingbird/examples/main.cljs).


It will look something like this:

``` clj

(ns your-project.core
  (:require
   ["react-dom/client" :as rdom]
   [mockingbird.examples.main :as ex]
   [helix.core :refer [$ <>]]))

;; this is a front app application using shadow-cljs, postcss, helix and refx.
;; You can see a simple page example running here.

(defn app []
  (<>
   ($ ex/app)))

(defonce root
  (rdom/createRoot (js/document.getElementById "app")))

(defn render []
  (.render root ($ app)))

(defn config []
  (println "ok"))

(defn ^:export init []
  (config)
  (render))

```

> for better understanding, follow the offcial [shadow-cljs guide](https://github.com/thheller/shadow-cljs) and [helix](https://github.com/lilactown/helix)

You can clone and build this repo, to see some examples of good usage of our dear Mockingbird. You can read more [here](docs/test.md).


# Contributing

Mockingbird is open-source, and contributions are welcome! If you have ideas for new features, improvements, or bug fixes, feel free to open an issue or submit a pull request.
