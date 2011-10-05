(ns mishadoff
  (:use [clojure.contrib.lazy-seqs :only (primes)]))
(reduce + (take-while #(< % 2000000) primes))


