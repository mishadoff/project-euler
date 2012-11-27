(ns project-euler)

(defn square? [n]
  (let [r (int (Math/sqrt n))]
    (= (* r r) n)))

(defn diophantine-solution [d]
  (if-not (square? d)
    (loop [x 1 y 1]
      (print x y)
      (let [left (dec (* x x))
            right (* d y y)]
        (cond (> right left)
              (recur (inc x) (int (Math/sqrt (/ left d))))
              (< right left) (recur x (inc y))
              (= right left) [x y])))))

(defn euler-066 []
  (first
   (sort-by #(max (second %1) (second %2))
            (for [d (range 1 100)]
              [d (first (diophantine-solution d))]))))