(ns mishadoff
  (:use [clojure.contrib.lazy-seqs :only (primes)]))
(defn is-prime? [prime]
  (if (= 1 prime) false
    (not-any? #(zero? (rem prime %)) (take-while #(<= (* % %) prime) primes))))
(defn to-seq [n]
  (map #(- (int %) 48) (seq (str n))))
(defn to-num [seq]
  (bigint (reduce str seq)))
(defn is-truncatable-left? [prime-seq]
  (if (empty? prime-seq) true
	  (if (is-prime? (to-num prime-seq)) 
	    (recur (rest prime-seq))
	    false)))
(defn is-truncatable-right? [prime-seq]
	(if (empty? prime-seq) true
		  (if (is-prime? (to-num prime-seq)) 
		    (recur (butlast prime-seq))
		    false)))
(defn is-truncatable-both? [prime]
  (let [prime-seq (to-seq prime)]
    (if (and (is-truncatable-left? prime-seq) (is-truncatable-right? prime-seq)) true false)))
(reduce + (take 11 (drop-while #(< % 10) (filter is-truncatable-both? primes))))