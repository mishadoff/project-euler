(ns mishadoff
  (:use [clojure.contrib.lazy-seqs :only (fibs)]))
(defn num-of-digits [n]
  (count (seq (str n))))

(first (first (drop-while #(< (num-of-digits (last %)) 1000)
  (map #(cons %2 (cons %1 nil)) (fibs) (iterate inc 0)))))

