(ns project-euler.problem001)

(defn sum-of [n]
  (reduce + (range n 1000 n)))

;; Elapsed time: 2.147203 msecs
(defn euler-001 []
  (- (+ (sum-of 3) (sum-of 5)) (sum-of 15)))
