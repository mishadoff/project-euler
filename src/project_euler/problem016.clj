(ns project-euler.problem016)

(defn powers-of-2 []
  (iterate (partial *' 2) 1))

(defn sum-of-digits [n]
  (reduce + (map #(- (int %) 48) (seq (str n)))))

(defn euler-016 []
  (sum-of-digits (last (take 1001 (powers-of-2)))))