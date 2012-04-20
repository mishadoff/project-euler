(ns project-euler)

(defn routes-extend [lst]
  (let [size (count lst)]
    (for [i (range (inc size))]
      (if (or (= 0 i) (= size i)) 1 
        (+ (nth lst (dec i)) (nth lst i))))))

(defn routes-narrow [lst]
  (map + lst (rest lst)))

;; Elapsed time: 15.202699 msecs
(defn euler-015 []
  (let [n 20]
    (first (last (take (inc n) (iterate routes-narrow 
                                        (last (take (inc n) (iterate routes-extend [1])))))))))