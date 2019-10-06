(ns gists-bkp.core
  (:require [clj-http.client :as client]
            [cheshire.core :refer :all]))


(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn get-gists-pull-url
  []
  (parse-string (:body (client/get "https://api.github.com/users/medeiros/gists")) (fn [x] (= x "git_pull_url")))
  ;; iterate through all items: (val (last (item x)))
  ;; then create own list of gist urls
  
  )
