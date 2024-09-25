# mockingbird

Design System using [tailwind](https://tailwindcss.com/) and [helix](https://github.com/lilactown/helix) in [ClojureScript](https://clojurescript.org/).

A simple way to develop a user interface with a consistent user experience, without the need to clutter `cljs` code with **CSS**.

> if your desire is to use mockingbird without ClojureScript (how you dare!) you can of course use our npm package into your JS application. Read more [here](#Installation).

## name reference?

> "mockingbird" is for everyone!

The name is a reference to the book [To Kill a Mockingbird](https://en.wikipedia.org/wiki/To_Kill_a_Mockingbird) by Harper Lee. The idea is that the design system is a "mockingbird" that sings the same song everywhere.

It's impossible to talk about *"mockingbird"* without remembering the song [Mockingbird by Eminem](https://www.youtube.com/watch?v=S9bCLPwzSC0) with his daughter Hailie Jade. The song is a declaration of love from a father to his daughter.

**mockingbird** is a declaration of love for all developers ~~(frontend will never be easy for backend developers)~~.

# Overview

Mockingbird offers a set of reusable components and utilities that increases speed and beauty on your UI development. By integrating Tailwind, Helix and ReFx, Mockingbird combines functional programming, a powerful component model together creating a fast and lightweight design system. This allows your team (or simply yourself) to focus on building robust, reactive interfaces without getting bogged down in styling and local state management concerns.

# Getting Started

Prerequisites

Before you begin, ensure you have the following installed:
- Clojure: Follow the [Clojure Installation guide](https://clojure.org/guides/install_clojure) to set up your environment.
- [Node](https://nodejs.org/en/download/prebuilt-installer/current).
- [npm](https://www.npmjs.com/package/downloads).

# Installation

We distribute our software via clojars (and intend to do so also by npm):

npm:
``` bash

npm install react autoprefixer babel-loader css-loader cssnano karma karma-chrome-launcher karma-cljs-test msw npm-run-all postcss postcss-cli postcss-loade postcss-preset-env shadow-cljs tailwindcss webpack webpack-cli rimraf glob @isaacs/cliui --save-dev

```


if you are prone to build using our clojar, you will also need to install the deps on node and start a project with shadow-cljs!!! read more [here](# Testing Locally)
deps.edn:
``` clj
  moclojer/mockingbird {:mvn/version "0.0.1"}
```

# Usage 

add a import on a specific component or layout component you want and load it in your screen
``` clj
(:require 
  [mockingbird.components.button :refer [button]]
  [helix.core :refer [$]])
;; use it then
  ($ button)

```

# Testing Locally 

You can clone and build this repo, to see some examples of good usage of our dear Mockingbird. You can read more [here](docs/test.md).

- Set up your project: Start by creating a new ClojureScript project, or use an existing one.

- Install node dependencies with a simple command: 

``` sh
npm ci
```

- configure your shadow cljs

> for better understanding, follow the offcial [guide](https://github.com/thheller/shadow-cljs)

# Contributing

Mockingbird is open-source, and contributions are welcome! If you have ideas for new features, improvements, or bug fixes, feel free to open an issue or submit a pull request.
