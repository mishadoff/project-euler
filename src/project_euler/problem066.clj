(ns project-euler)

;; This Diophantine equation known as Pell's equation
;; http://en.wikipedia.org/wiki/Pell%27s_equation
;;
;; Let h_i/k_i denote the sequence of convergents to the continued fraction sqrt(n)
;; Then the pair (x,y) solving Pell's equation and minimizing x,
;; x = h_i, y = k_i. Fundamental solution.

(defn square? [n]
  (let [a (int (Math/sqrt n))]
    (= n (* a a))))

(defn convergent [seq]
  "Number of convergents, sequence"
  (letfn [(partial-sum [fseq]
            (reduce #(+ (/ 1 %1) %2) (reverse fseq)))] ;; TODO improve performance
    (map #(partial-sum (take % seq)) (iterate inc 1))))

(defn continued-fraction-sqroot-seq [n]
  "TODO document"
  (let [a0 (int (Math/sqrt n))]
    (letfn [(next-frac [a m d]
              (let [m1 (- (* a d) m)
                    d1 (/ (- n (* m1 m1)) d)
                    a1 (quot (+ a0 m1) d1)]
                (cons a1 (lazy-seq (next-frac a1 m1 d1)))))]
      (if (= (* a0 a0) n) (list a0)
          (cons a0 (lazy-seq (next-frac a0 0 1)))))))

(defn solution? [x y d]
  (zero? (- (* x x)
            (* d y y) 1)))

(defn solve-fundamental [d]
  (numerator
   (first (filter #(solution? (numerator %) (denominator %) d)
                  (filter ratio?
                          (convergent (continued-fraction-sqroot-seq d)))))))

;; Elapsed time: 504.251763 msecs
(defn euler-066 []
  (apply max-key first
         (map #(list (solve-fundamental %) %)
              (filter (comp not square?) (range 1 1001)))))