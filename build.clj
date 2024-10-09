(ns build
  (:require 
    [clojure.tools.build.api :as b]
    [clojure.java.io :as io]))

(def lib 'com.github.moclojer/mockingbird)
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


(defn prepend-to-css-file []
  "Prepend to the output css file generated a version tag which will be
  later compared by the build hook evaluated on the end user project"
  (try 
    (let [file-path (get-css-file)
          first-line (with-open [reader (io/reader file-path)]
                       (first (line-seq reader)))]
      (when (not= first-line version)
        (let [old-content (slurp file-path)
              new-content (str version "\n" old-content)]
          (with-open [writer (io/writer file-path)]
            (.write writer new-content)))))
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
