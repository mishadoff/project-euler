(ns project-euler.problem014)

(defn collatz-next [n]
  (if (even? n) (/ n 2) (inc (* n 3))))

(defn collatz-chain-recursive [n]
  (if (= n 1) 1
      (inc (collatz-chain-recursive (collatz-next n)))))

;; Elapsed time: 12668.080554 msecs
(defn euler-014 []
  (first
   (apply max-key second
          (map #(list % (collatz-chain-recursive %)) (range 1 1000000)))))