(ns mishadoff
  (:use [clojure.contrib.lazy-seqs :only (primes)])
  (:use [clojure.contrib.combinatorics :only (lex-permutations)]))
(defn is-prime? [prime]
  (if (= 1 prime) false
    (not-any? #(zero? (rem prime %)) (take-while #(<= (* % %) prime) primes))))
(defn all-pandigital-perm []
  (sort (reduce concat (map lex-permutations (take 8 (map #(range 1 %) (iterate inc 2)))))))
(Integer/parseInt (reduce str 
  (first (drop-while #(not (is-prime? (Integer/parseInt (reduce str %))))
    (reverse (all-pandigital-perm))))))
