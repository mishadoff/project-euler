(ns project-euler.problem006)

(defn sqr [n] (* n n))

;; Elapsed time: 0.199956 msecs
(defn euler-006 []
  (let [rn (range 1 101)]
    (- (sqr (reduce + rn)) (reduce + (map sqr rn)))))