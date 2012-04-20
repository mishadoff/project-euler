(ns project-euler
  (:use [clojure.contrib.lazy-seqs :only (primes)]))

(defn shift [vect n]
  (loop [idx n sqnc vect]
    (if (zero? idx) sqnc
      (recur (dec idx) (concat (rest sqnc) (list (first sqnc)))))))

(defn is-prime? [prime-seq]
  (let [prime (bigint (reduce str prime-seq))]
    (= (first (drop-while #(< % prime) primes)) prime)))

(defn to-seq [n]
  (map #(- (int %) 48) (seq (str n))))

(defn is-circular? [prime]
  (and (not (some #(
         or (= % 0) (= % 2) (= % 4) (= % 5) (= % 6) (= % 8)) (to-seq prime)))
       (not (zero? (reduce * 
         (for [i (range (count (to-seq prime)))]
	         (if (is-prime? (shift (to-seq prime) (inc i))) 1 0)))))))

;; Elapsed time: 45633.570512 msecs
(defn euler-035 []
  (+ 2 (count (filter is-circular? (take-while #(< % 1000000) primes)))))