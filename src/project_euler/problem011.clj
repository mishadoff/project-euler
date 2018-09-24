(ns project-euler.problem011)

(defn get-matrix []
  (map #(Integer/parseInt (apply str %))
       (partition 2 2 (remove #(or (= \newline %) (= \ %))
                              (seq (slurp "res/problem011.txt"))))))

(defn get-at [i j matrix]
  (if (and (>= i 0) (< i 20) (>= j 0) (< j 20))
    (nth matrix (+ j (* i 20))) 0))

;; Elapsed time: 152.426437 msecs
(defn euler-011 []
  (let [matrix (get-matrix)
        ways (for [i (range 20) j (range 20)]
               [(map #(get-at i (+ % j) matrix) (range 4))
                (map #(get-at (+ % i) j matrix) (range 4))
                (map #(get-at (+ % i) (+ % j) matrix) (range 4))
                (map #(get-at (+ % i) (- j %) matrix) (range 4))])]
    (reduce max (map #(reduce * %) (reduce concat ways)))))