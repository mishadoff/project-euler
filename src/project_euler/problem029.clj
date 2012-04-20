(ns project-euler)

(defn pow [n pw]
  (reduce *' (take pw (repeat n))))

;; Elapsed time: 706.130155 msecs
(defn euler-029 []
  (count (distinct
          (for [i (range 2 101) j (range 2 101)]
            (pow i j)))))

