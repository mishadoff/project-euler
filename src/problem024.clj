(ns mishadoff
  (:use [clojure.contrib.combinatorics :only (lex-permutations)]))
(apply str 
  (nth (lex-permutations (map #(- (int %) 48) (seq "0123456789")))
       (dec 1000000)))
