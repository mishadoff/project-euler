(ns project-euler
  (:use [clojure.contrib.lazy-seqs :only (primes)]))

(defn is-prime? [prime]
  (if (= 1 prime) false
    (not-any? #(zero? (rem prime %)) (take-while #(<= (* % %) prime) primes))))

(defn is-square? [n]
  (let [sqr (Math/sqrt n)]
    (= sqr (quot sqr 1))))

(defn is-writable-as-sum? [n]
  (loop [candidate-primes (take-while #(< % n) primes)]
    (if (empty? candidate-primes) false
      (if (is-square? (/ (- n (first candidate-primes)) 2)) true
        (recur (rest candidate-primes))))))

(def composites (filter #(and (odd? %) (not (is-prime? %))) (iterate inc 2)))

;; Elapsed time: 306.410403 msecs
(defn euler-046 []
  (first (drop-while #(is-writable-as-sum? %) composites)))