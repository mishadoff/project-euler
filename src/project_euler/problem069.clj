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

(defn euler-069 []
  (apply max-key second
         (for [i (range 1 100000)]
           [i (double (/ i (phi i)))])))