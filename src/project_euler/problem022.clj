(ns project-euler)

(defn score [string]
  (reduce + (map #(- (int %) 64) string)))

;; Elapsed time: 34.330959 msecs
(defn euler-022 []
  (->> "res/problem022.txt"
       (slurp)
       (re-seq #"\w+")
       (sort)
       (map-indexed #(* (inc %1) (score %2)))
       (reduce +)))
