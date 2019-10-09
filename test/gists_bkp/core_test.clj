(ns gists-bkp.core-test
  (:require [clojure.test :refer :all]
            [gists-bkp.core :refer :all]))

(deftest should-get-file-from-uri
  (testing "URI file name is incorrect"
    (is (= (get-file-from-uri "https://gist.github.com/medeiros/12345.git") "12345.git"))))

(deftest should-get-cloning-message
  (testing "Log action not working as expected"
    (is (= (clone-message "https://gists.github.com/medeiros/12345.git" "12345.git") 
           "cloning https://gists.github.com/medeiros/12345.git (file: 12345.git) ..."))))


