(ns project-euler)

(defn sum-of-digits [n]
  (reduce + (map #(- (int %) 48) (seq (str n)))))

;; Elapsed time: 1.74764 msecs
(defn euler-020 []
  (sum-of-digits (reduce *' (take 100 (iterate inc 1)))))
