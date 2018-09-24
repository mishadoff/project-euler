(ns project-euler.problem012
  (:use [clojure.contrib.lazy-seqs :only (primes)])
  (:use [clojure.contrib.math :only (sqrt)]))

(defn triangle-number [n]
  (* n (/ (+ n 1) 2)))

(def triangles (map triangle-number (iterate inc 1)))

(defn num-of-divisors [n]
  (* 2 (count (filter #(zero? (mod n %)) (range 1 (sqrt n))))))

(defn factorize [n]
  (loop [x n [p & ps] primes factors []]
    (cond (= 1 x) factors
          (zero? (mod x p)) (recur (/ x p) primes (conj factors p))
          :else (recur x ps factors))))

(defn factorize-count [n]
  (reduce * (map (comp inc count) (vals (group-by identity (factorize n))))))

;; Elapsed time: 2850.205718 msecs
(defn euler-012 []
  (first (drop-while #(< (factorize-count %) 500) triangles)))