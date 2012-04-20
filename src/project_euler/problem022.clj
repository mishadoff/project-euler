(ns project-euler)

(defn score [string]
  (reduce + (map #(- (int %) 64) (seq string))))

;; Elapsed time: 165.422506 msecs
(defn euler-022 []
  (reduce +
          (map *
               (map score (sort (re-seq #"\w+" (slurp "res/problem022.txt"))))
               (iterate inc 1))))
