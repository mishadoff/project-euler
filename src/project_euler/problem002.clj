(ns project-euler
  (:use [clojure.contrib.lazy-seqs :only (fibs)]))

;; Elapsed time: 1.250295 msecs
(defn euler-002 []
  (reduce + (filter even? (take-while #(< % 4000000) (fibs)))))