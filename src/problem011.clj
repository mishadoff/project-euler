(ns mishadoff)
(def *matrix*
  (map #(Integer/parseInt %)(map #(reduce str %) (partition 2 2 (remove #(or (= \newline %) (= \ %))
    (seq (slurp "res/problem011.txt")))))))

(defn get-at [i j matrix]
  (if (and (>= i 0) (< i 20) (>= j 0) (< j 20))
    (nth matrix (+ i (* j 20))) 0))

(let [ways (for [i (range 20) j (range 20)]
  [(map #(get-at i (+ % j) *matrix*) (range 4))
   (map #(get-at (+ % i) j *matrix*) (range 4))
   (map #(get-at (+ % i) (+ % j) *matrix*) (range 4))
   (map #(get-at (+ % i) (- j %) *matrix*) (range 4))])]
     (reduce max (map #(reduce * %) (reduce concat ways))))