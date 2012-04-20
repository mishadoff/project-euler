(ns mishadoff
  (:use [clojure.contrib.lazy-seqs :only (primes)]))

(defn prime? [prime]
  (if (= 1 prime) false
    (not-any? #(zero? (rem prime %)) (take-while #(<= (* % %) prime) primes))))

(defn make-seq-accumulator [seq]
  (map first (iterate (fn [[sum s]]
            [(+ sum (first s)) (next s)])
              [(first seq) (rest seq)])))
 
(def prime-sums (conj (make-seq-accumulator primes) 0))

(defn euler-50 []
  (loop [c   1]
    (let [bots (reverse (take c prime-sums))
      tops (take c (reverse (take-while #(> 1000000 (- % (last bots)))
                        (rest prime-sums))))]
      (if-let [v (some #(if (prime? %) % nil)
               (map #(- %1 %2) tops bots))]
    v
    (recur (inc c))))))
 
(euler-50 1000000)