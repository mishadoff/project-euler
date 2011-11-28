(ns mishadoff
  (:use [clojure.contrib.lazy-seqs :only (primes)]))

(defn perm? [triplet]
  (apply = (map #(sort (seq (str %))) triplet)))

(defn prime? [number]
  (= number (first (drop-while #(< % number) primes))))

(defn euler-49 []
  (apply str (last
	      (filter #(and (every? prime? %) (perm? %)) 
		      (loop [number 1001 lst []]
			(if (< number 3339)
			  (recur (inc number)
				 (conj lst (list number (+ number 3330) (+ number (* 2 3330)))))
			  lst))))))


