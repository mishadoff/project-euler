(ns project-euler
  (:use [clojure.contrib.combinatorics :only (lex-permutations)]))

;; Elapsed time: 1096.703496 msecs
(defn euler-024 []
  (read-string (apply str 
         (nth (lex-permutations (map #(- (int %) 48) (seq "0123456789")))
              (dec 1000000)))))