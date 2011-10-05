(ns mishadoff
  (:use [clojure.contrib.lazy-seqs :only (primes)])
  (:use [clojure.contrib.math :only (sqrt)]))
(defn greatest-prime-of [number]
  (reduce max (filter #(zero? (mod number %))
    (take-while #(< % (sqrt number)) primes))))

