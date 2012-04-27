(ns project-euler)

(defn num-greater? [rat]
  (> (count (str (numerator rat)))
     (count (str (denominator rat)))))

(defn sqroot-next [rat]
  (+ 1 (/ 1 (+ 2 (- rat 1)))))

;; Elapsed time: 496.012248 msecs
(defn euler-057 []
  (count
   (filter true? 
           (map num-greater? (take 1000 (iterate sqroot-next 3/2))))))