(ns project-euler)

(defn collatz-next [n]
  (if (even? n) (/ n 2) (inc (* n 3))))

(defn collatz-chain-length [n]
  [n (inc (count (take-while #(> % 1) (iterate collatz-next n))))])

;; Elapsed time: 61465.886757
(defn euler-014 []
  (first (reduce #(if (> (nth %1 1) (nth %2 1)) %1 %2)
                 (map #(collatz-chain-length %) (range 1 1000000)))))