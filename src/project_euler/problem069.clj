(ns project-euler
  (:require [clojure.contrib.lazy-seqs :as lazy]))

;; phi(n) calculationg due to formula
;; phi(n) = n * product of (1 - 1/p_n) p_n - element from number factorization

(defn factorize [n]
  (loop [[p & ps] lazy/primes num n fact []]
    (if (= 1 num) (distinct fact)
        (if (zero? (mod num p)) (recur lazy/primes (/ num p) (conj fact p))
            (recur ps num fact)))))

(defn phi [n]
  (reduce * n (map #(- 1 (/ 1 %)) (factorize n))))

;; slow one
(defn euler-069-slow []
  (apply max-key second
         (for [i (range 1 10000)]
           [i (double (/ i (phi i)))])))

(defn euler-069 []
  (last (take-while #(< % 1000000) (reductions * lazy/primes))))