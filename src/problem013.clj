(ns mishadoff)
(bigint (apply str (take 10 (str (reduce + 
  (map bigint (re-seq #"\w+" (slurp "res/problem013.txt"))))))))

