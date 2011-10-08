(ns mishadoff
  (:use [clojure.contrib.lazy-seqs :only (primes)])
  (:use [clojure.contrib.combinatorics :only (lex-permutations subsets)]))
(defn is-prime? [prime]
  (if (= 1 prime) false
    (not-any? #(zero? (rem prime %)) (take-while #(<= (* % %) prime) primes))))
(defn all-perm [sq]
  (sort (reduce concat (map lex-permutations (subsets sq)))))
(first (drop-while #(not (is-prime? (Integer/parseInt (reduce str %))))
     (reverse (all-perm [1 2 3 4 5 6 7 8 9]))))
