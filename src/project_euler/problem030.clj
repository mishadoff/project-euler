(ns project-euler)

(defn pow-5 [n]
  (reduce * (take 5 (repeat n))))

(defn sum-digits-pow-5 [n]
  (reduce + (map #(pow-5 (- (int %) 48)) (seq (str n)))))

;; Elapsed time: 6470.950529 msecs
(defn euler-030 []
  (reduce + (filter #(= % (sum-digits-pow-5 %)) (range 10 295246))))

