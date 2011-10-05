(ns mishadoff)
(defn sum-of-digits [n]
  (reduce + (map #(- (int %) 48) (seq (str n)))))
(sum-of-digits (reduce * (take 100 (iterate inc 1))))

