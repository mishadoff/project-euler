(ns project-euler
  (:use [clojure.contrib.math :only (sqrt)]))

(defn triangle-solutions [n]
  (for [a (range 1 n) b (range a n)
        :let [c (sqrt (+ (* a a) (* b b)))]
        :when (and (= n (+ a b c)) 
                   (> (+ a b) c))]
    [a b (int c)]))

;; Elapsed time: 265066.799355 msecs
(defn euler-039 []
  (first (reduce #(if (> (last %1) (last %2)) %1 %2)
                 (filter #(not (zero? (last %)))
                         (map #(cons % (cons (count (triangle-solutions %)) nil)) (range 1 1001))))))