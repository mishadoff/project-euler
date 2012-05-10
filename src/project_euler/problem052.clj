(ns project-euler)

(defn is-permut? [num1 num2]
  (= (sort (map #(- (int %) 48) (str num1)))
     (sort (map #(- (int %) 48) (str num2)))))

;; Elapsed time: 5603.315127 msecs
(defn euler-052 []
  (loop [c 1]
    (if (reduce #(and %1 %2)
                (map #(is-permut? c %)
                     (map #(* % c) [2 3 4 5 6])))
      c
      (recur (inc c)))))