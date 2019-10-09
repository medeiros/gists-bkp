(ns gists-bkp.core
  (:require [clj-http.client :as client]
            [cheshire.core :refer :all]
            [clj-jgit.porcelain :as jgit]))


(def gists_url "https://api.github.com/users/medeiros/gists")


(defn get-file-from-uri
  "Get a file part from a uri."
  [uri]
  (subs uri (inc (clojure.string/last-index-of uri "/"))))


(defn clone-message
  "Returns cloning action message."
  [url file]
  (str "cloning " url " (file: " file ") ..."))


(defn get-gists-pull-url
  "Iterate through all public gists and clone those repos.
   It would be better to split this in several more specialized functions."
  []
  (let [lseq (parse-string (:body (client/get gists_url)) 
                          #(= % "git_pull_url"))]
    (loop [item (first lseq), sublist (rest lseq)]
      (when item
        (let [url (val (last item))
              file (get-file-from-uri url)]
          (println (clone-message url file))
          (jgit/git-clone url :dir (str "gist-clones/" file)))
        (recur (first sublist) (rest sublist))))))



