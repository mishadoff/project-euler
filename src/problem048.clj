(ns mishadoff)
(defn power [n]
  (reduce * (take n (repeat n))))
(reduce + (take 1000 (map power (iterate inc 1))))
