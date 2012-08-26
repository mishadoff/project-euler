(ns project-euler)

(defn sum-of [n]
  (reduce + (map #(- (int %) 48) (str n))))

(defn pow [a b]
  (reduce *' (repeat b a)))

;; Elapsed time: 832.28377 msecs
(defn euler-056 []
  (apply max
         (for [i (range 100) j (range 100)]
           (sum-of (pow i j)))))