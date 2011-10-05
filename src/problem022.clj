(ns mishadoff)
(defn score [string]
  (reduce + (map #(- (int %) 64) (seq string))))

(reduce + (map * 
  (map score (sort (re-seq #"\w+" (slurp "res/problem022.txt"))))
  (iterate inc 1)))

