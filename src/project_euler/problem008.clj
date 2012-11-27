(ns project-euler)

(defn calc-product [lst]
  (reduce * (map #(- (int %) 48) lst)))

;; Elapsed time: 33.323509 msecs
(defn euler-008 []
  (reduce max (map calc-product
                   (partition 5 1 (remove #(= \newline %) (seq (slurp "res/problem008.txt")))))))