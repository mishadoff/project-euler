(ns mishadoff)
(defn sum-of [n]
  (reduce + (range n 1000 n)))
(- (+ (sum-of 3) (sum-of 5)) (sum-of 15))