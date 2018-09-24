(ns project-euler.problem013)

;; Elapsed time: 24.427424 msecs
(defn euler-013 []
  (read-string
   (apply str (take 10 (str (reduce + (map bigint (re-seq #"\w+" (slurp "res/problem013.txt")))))))))