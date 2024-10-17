(ns build
  (:require 
    [clojure.tools.build.api :as b]
    [clojure.java.io :as io]))

(def lib 'com.moclojer/mockingbird)
(def version "0.0.1")
(def class-dir "target/classes")
(def basis (b/create-basis {:project "deps.edn"}))
(def jar-file (format "target/%s-%s.jar" (name lib) version))

(defn get-css-file []
  (let [path (io/file "resources/public/assets/css/")
        files (file-seq path)]
    (some 
      #(when (.endsWith (.getName %) "target.css") %)
      files)))

(def pom-template
  [[:description "Design System using tailwind and helix in ClojureScript.
    A simple way to develop a user interface with a consistent user experience, without the need to clutter cljs code with CSS (unless you want to)."]
   [:url "https://github.com/moclojer/mockingbird"]
   [:licenses
    [:license
     [:name "MIT License"]
     [:url "https://opensource.org/licenses/MIT"]]]
   [:scm
    [:url "https://github.com/moclojer/mockingbird"]
    [:connection "scm:git:https://github.com/moclojer/mockingbird.git"]
    [:developerConnection "scm:git:ssh:git@github.com:moclojer/mockingbird.git"]
    [:tag (str "v" version)]]])

(defn prepend-to-css-file []
  "Prepends a version tag to the beginning of the generated CSS file.
  This version tag will later be compared by the build hook in the end-user project."
  (try 
    (let [file-path (get-css-file)]
      (if file-path 
        (let [first-line (with-open [reader (io/reader file-path)]
                           (first (line-seq reader)))]
          (when (not= first-line version)
            (let [old-content (slurp file-path)
                  new-content (str "/* " version " */\n" old-content)]
              (with-open [writer (io/writer file-path)]
                (.write writer new-content)))))
        (prn "CSS file not found. Skipping version prepending.")))
    (catch Exception e
      (prn "Error writing to CSS file:" (.getMessage e)))))

(defn clean [_]
  (b/delete {:path "target"}))

(defn jar [_]
  (prepend-to-css-file)
  (b/write-pom {:class-dir class-dir
                :lib lib
                :version version
                :basis basis
                :pom-data pom-template
                :src-dirs ["src"]})
  (b/copy-dir {:src-dirs ["src" "resources"]
               :target-dir class-dir})
  (b/jar {:class-dir class-dir
          :jar-file jar-file}))

(defn install [_]
  (b/install {:basis      basis
              :lib        lib
              :version    version
              :jar-file   jar-file
              :class-dir  class-dir}))
