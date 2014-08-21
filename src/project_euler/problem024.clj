(ns project-euler
  (:require [clojure.math.combinatorics :as comb]))

;; Elapsed time: 2848.733561 msecs
(defn euler-024 []
  (->> (range 10)
       (comb/permutations)
       (drop (dec 1000000))
       (first)
       (apply str)))
