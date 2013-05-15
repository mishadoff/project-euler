(ns project-euler
  (:require [clojure.contrib.lazy-seqs :as lazy]))

;; Find the size of farey sequence

(defn factorize [n]
  (loop [x n fact []]
    (if (= 1 x) fact
        (let [d (first (drop-while #(not (zero? (rem x %))) lazy/primes))]
          (recur (/ x d) (conj fact d))))))

(defn totient [n]
  (reduce * n (map #(- 1 (/ 1 %)) (distinct (factorize n)))))

(defn euler-072 []
  (reduce + (map totient (range 2 1000000))))