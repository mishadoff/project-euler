(ns mishadoff)
(defn fact-digit [n]
  (reduce + (map #(reduce * (range 1 (inc (- (int %) 48)))) (seq (str n)))))
; find the way to calculate upper bound more smartly
(filter #(not (nil? %)) (for [i (range 10 1000000)]
  (if (= i (fact-digit i)) i)))