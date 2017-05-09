(ns project-euler.problem100)

(defn score [n blue]
  (/ (* blue (dec blue)) (* n (dec n))))

(defn is50? [n blue]
  (= (* 2 blue (dec blue))
     (* n (dec n))))

(defn report [max]
  (doseq [n (range 2 max)]
    (doseq [blue (range 1 (dec n))]
      (let [score (score n blue)]
        (when (is50? n blue) (print "MATCH >> "))
        (print
         (format "N=%d, B/R=[%d,%d], SCORE=%.2f\n"
                 n blue (- n blue) (double score)))))))


;; Simple bruteforce over N and B
;; is too much and quadratic complexity, let's simplify
;;
;; B - blue, N - total
;;
;; (B*(B-1))/(N*(N-1)) = 1/2
;; or
;; B^2 - B - ((N*(N-1))/2) = 0
;;
;; Solve this quadratic equation in terms of B
;;
;; D = b^2 - 4ac = (-1)^2 - 4*1*(-((N*(N-1))/2)) = 1 + 2 * N * (N - 1)
;;
;; B1,2 = (-b +- sqrt(D)) / 2a = (1 +- SQRT(D)) / 2
;;
;; Observation #1: B must be integer, so D should be PERFECT SQUARE
;; Observation #2: B must be integer so SQRT(D) should be ODD
;;
;; If D is perfect square of some number, say S
;; D = S^2 = 1 + 2 * N * (N - 1)
;;
;; We have a constraint N > 10^12
;; S^2 = 1 + 2 * 10^12 * (10^12 - 1)

(def S (long (Math/sqrt (+' 1
                            (*' 2
                                (reduce *' (repeat 12 10))  ;; 10^12
                                (-' (reduce *' (repeat 12 10)) 1)) ;;  10^12 -1
                            ))))

;; S => 1414213562327
;; Start iterating from this number
;; B = (1 + S) / 2
;; So, iterate only on odd, 1,3,5,7
;; for every S
;;   calculate B as = (1+S)/2
;;   calculate N as ...
;;
;; We defined S^2 = 2N^2 - 2N + 1
;; or
;; 2N^2 - 2N - (S^2 - 1) = 0
;; Solve this quadratic equation in terms of N
;; 
;; D = b^2 - 4ac = (-2)^2 - 4 * 2 * (-1) * (S^2 -1)
;; D = 4 + 8 (S^2 -1) = 4 + 8S^2 - 8 = 8S^2 - 4 = 4 * (2S^2 - 1)
;; N = 2 + sqrt(4 * (2S^2 - 1)) / 4 = 1 + SQRT(2S^2 - 1) / 2
;;
;; 2S^2 - 1 = K^2
;; 2S^2 - 1 should be a perfect square as well...
;;
;; s, whivh produce perfect sequence 2S^2 -1
;; https://oeis.org/search?q=1%2C5%2C29&sort=&language=&go=Search
;; defined by fromula
;; s(1) = 1
;; s(2) = 5
;; s(n) = 6 * s(n-1) - s(n-2)


(defn perfect-square? [n]
  (let [sqrt (bigint (Math/sqrt n))]
    (= n (*' sqrt sqrt))))

(defn quess-sqroot [s])

(defn solve []
  (let [mins 1414213562327
        afn (fn [a b] (- (* 6 b) a))]
    (loop [[a s] [1 5] [b k] [1 7]]
      (cond (>= s mins)
            (let [b (/ (+' 1 s) 2)] {:s s :b b :k k})
            :else (recur [s (afn a s)]
                         [k (afn b k)])))))

;; Done.
