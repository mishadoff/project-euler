(ns mishadoff
  (:use [clojure.contrib.lazy-seqs :only (primes)]))

(defn next-prime [number]
  (let [n (first (drop-while #(not (zero? (mod number %))) 
                     (take-while #(<= % (inc (quot (Math/sqrt number) 1))) primes)))]
    (if (nil? n) number n)))

(defn unique-factorization [number st]
  (if (= number 1) 
    st
    (let [n (next-prime number)]
    (recur (/ number n) (conj st n)))))

(defn find-consecutive
  ([] (find-consecutive 2))
  ([n] (find-consecutive 2 n []))
  ([n size lst]
    (if (= size (count lst)) 
      lst
      (if (= size (count (unique-factorization n #{})))
        (recur (inc n) size (conj lst n))
        (recur (inc n) size [])))))

