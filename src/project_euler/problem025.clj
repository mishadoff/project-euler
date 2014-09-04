(ns project-euler)
  
(defn num-of-digits [n]
  (count (str n)))

(defn fibonacci []
  (->> [0 1]
       (iterate (fn [[a b]] [b (+' a b)]))
       (map first)))

;; Elapsed time: 834.545293 msecs
(defn euler-025 []
  (->> (fibonacci)
       (map-indexed (fn [i n] [i (num-of-digits n)]))
       (drop-while #(< (second %) 1000))
       (first)
       (first)))
