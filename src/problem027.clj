(ns mishadoff
  (:use [clojure.contrib.lazy-seqs :only (primes)]))
(defn quad-form [a b n]
  (+ (* n n) (* a n) b))
(defn is-prime? [n]
  (if (< n 2) false
    (if (= n (first (drop-while #(> n %) primes))) true false )))

(reduce #(if (> (first %1) (first %2)) %1 %2)
  (for [a (range -999 1000) b (range -999 1000)]
    [(count (take-while is-prime? 
       (map #(quad-form a b %) (iterate inc 0)))) (* a b)]))

;; [71 -59231]