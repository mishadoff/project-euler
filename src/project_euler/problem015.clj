(ns project-euler.problem015)

(defn routes-extend [lst]
  (let [size (count lst)]
    (for [i (range (inc size))]
      (if (or (= 0 i) (= size i)) 1
        (+ (nth lst (dec i)) (nth lst i))))))

;; Elapsed time: 14.809846 msecs
(defn euler-015 []
  (let [n 20 d (inc (* n 2))]
    (nth (last (take d (iterate routes-extend [1]))) n)))
