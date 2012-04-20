(ns project-euler)

(defn to-seq [n]
  [(quot n 10) (mod n 10)])

(defn silly-simplify [numer denom]
  (let [rat1 (to-seq numer) rat2 (to-seq denom)]
    (if (and 
          (= (last rat1) (first rat2))
          (= (/ (first rat1) (last rat2)) (/ numer denom)))
      (/ numer denom))))

;; Elapsed time: 27.491206 msecs
(defn euler-033 []
  (denominator (reduce * (filter #(not (nil? %))
                    (for [numer (range 10 99) denom (range (inc numer) 100)]
                      (if (or (zero? (mod numer 10)) (zero? (mod denom 10))) nil
                          (silly-simplify numer denom)))))))
