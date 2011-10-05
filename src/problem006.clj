(ns mishadoff)
(defn sqr [n] (* n n))
(let [rn (range 1 101)]
  (- (sqr (reduce + rn)) (reduce + (map sqr rn))))

