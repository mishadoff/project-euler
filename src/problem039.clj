(ns mishadoff)
(defn triangle-solutions [n]
  (for [a (range 1 n) b (range a n)
        :let [c (Math/sqrt (+ (* a a) (* b b)))]
        :when (and (= n (+ a b c)) 
                   (> (+ a b) c))]
    [a b (int c)]))
(first (reduce #(if (> (last %1) (last %2)) %1 %2)
	(filter #(not (zero? (last %)))
	  (map #(cons % (cons (count (triangle-solutions %)) nil)) (take 1000 (iterate inc 1))))))