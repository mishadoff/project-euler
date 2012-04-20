(ns project-euler
  (:use [clojure.contrib.lazy-seqs :only (primes)])
  (:use [clojure.contrib.math :only (sqrt)]))

(defn greatest-prime-of [number]
  (reduce max (filter #(zero? (mod number %))
                      (take-while #(< % (sqrt number)) primes))))

;; Elapsed time: 123.886287 msecs
(defn euler-003 []
  (greatest-prime-of 600851475143))