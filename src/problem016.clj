(ns mishadoff
  (:use [clojure.contrib.lazy-seqs :only (powers-of-2)]))
(defn sum-of-digits [n]
  (reduce + (map #(- (int %) 48) (seq (str n)))))
(sum-of-digits (last (take 1001 (powers-of-2))))
