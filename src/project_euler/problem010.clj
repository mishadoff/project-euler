(ns project-euler.problem010
  (:use [clojure.contrib.lazy-seqs :only (primes)]))

;; Elapsed time: 12975.457287 msecs
(defn euler-010 []
  (reduce + (take-while #(< % 2000000) primes)))

;; small optimization to problem
(defn sieve []
  (loop [nums (set (cons 2 (range 3 2000000 2))) n 3]
    (if (> (* n n) 2000000) (reduce + nums)
        (recur (clojure.set/difference nums (range (* n n) 2000000 n)) (+ n 2)))))