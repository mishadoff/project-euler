(ns project-euler
  (:use [clojure.contrib.lazy-seqs :only (primes)]))

;; Elapsed time: 20.637195 msecs
(defn euler-007 []
  (last (take 10001 primes)))