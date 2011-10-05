(ns mishadoff)
(defn pow [n pw]
  (reduce * (take pw (repeat n))))

(count (distinct
  (for [i (range 2 101) j (range 2 101)]
    (pow i j))))
; 9183

