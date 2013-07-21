(ns project-euler)

(defn sum-of-digits [n]
  (reduce + (map #(- (int %) 48) (seq (str n)))))

(defn ! [n]
  (reduce *' (range 1 (inc n))))

;; Elapsed time: 1.74764 msecs
(defn euler-020 []
  (sum-of-digits (! 100)))
