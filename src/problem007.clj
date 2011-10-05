(ns mishadoff
  (:use [clojure.contrib.lazy-seqs :only (primes)]))
(last (take 10001 primes))  


