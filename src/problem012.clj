(ns mishadoff)
(defn triangle-number [n]
  (* n (/ (+ n 1) 2)))
(def triangles (map triangle-number (iterate inc 1)))
(defn num-of-divisors [n]
  (+ 2 (* 2 (count (filter #(= (mod n %) 0) (range 2 (Math/sqrt n)))))))

(first (drop-while #(< (num-of-divisors %) 500) triangles))
            
