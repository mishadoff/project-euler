(ns project-euler)
  
(defn num-of-digits [n]
  (count (seq (str n))))

(defn fibs-long []
  (map first (iterate (fn [[a b]] [b (+' a b)]) [0 1])))

;; Elapsed time: 1089.690584 msecs
(defn euler-025 []
  (first (first (drop-while #(< (num-of-digits (last %)) 1000)
                            (map #(vec [%2 %1]) (fibs-long) (iterate inc' 0))))))