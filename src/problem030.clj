(ns mishadoff)
(defn pow-5 [n]
  (reduce * (take 5 (repeat n))))
(defn sum-digits-pow-5 [n]
  (reduce + (map #(pow-5 (- (int %) 48)) (seq (str n)))))

(reduce + (filter #(= % (sum-digits-pow-5 %)) (range 10 295246)))
; 443839

