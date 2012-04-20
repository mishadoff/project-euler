(ns project-euler
  (:use [clojure.contrib.lazy-seqs :only (primes)]))

;; Elapsed time: 12975.457287 msecs
(defn euler-010 []
  (reduce + (take-while #(< % 2000000) primes)))