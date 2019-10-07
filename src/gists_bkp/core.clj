(ns gists-bkp.core
  (:require [clj-http.client :as client]
            [cheshire.core :refer :all]))


(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))


(def gists_url "https://api.github.com/users/medeiros/gists")

(defn get-gists-pull-url
  "Iterate through all public gists.
   At this poing, this method is just printing the gists urls.
   It will be improved to back up code related to those urls."
  []
  (let [lseq (parse-string (:body (client/get gists_url)) 
                          #(= % "git_pull_url"))]
    (loop [item (first lseq), sublist (rest lseq)]
      (when item
        (println (val (last item)))
        (recur (first sublist) (rest sublist))))))


