(ns mishadoff
  (:use [clojure.contrib.lazy-seqs :only (fibs)]))
(reduce + (filter even? (take-while #(< % 4000000) (fibs))))
