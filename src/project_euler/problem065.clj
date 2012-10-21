(ns project-euler)

(defn convergent [n [s & sq]]
  (if (= n 1) s
      (+ s (/ 1 (convergent (dec n) sq)))))

(defn sum-of-digits [n]
  (reduce + (map #(- (int %) 48) (seq (str n)))))

(defn exp-seq-n [n]
  (let [v (if (= 2 (mod n 3))
            (* 2 (+ 1 (quot n 3))) 1)]
  (cons v (lazy-seq (exp-seq-n (inc n))))))

(def exp-seq (cons 2 (exp-seq-n 1)))

;; Elapsed time: 1.544052 msecs
(defn euler-065 []
  (sum-of-digits (numerator (convergent 100 exp-seq))))
