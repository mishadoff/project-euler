(ns project-euler
  (:use [clojure.contrib.lazy-seqs :only (primes)]))

(defn perm? [triplet]
  (apply = (map #(sort (seq (str %))) triplet)))

(defn prime? [number]
  (= number (first (drop-while #(< % number) primes))))

;; Elapsed time: 265.708508 msecs
(defn euler-049 []
  (read-string (apply str (last
	      (filter #(and (every? prime? %) (perm? %)) 
		      (loop [number 1001 lst []]
			(if (< number 3339)
			  (recur (inc number)
				 (conj lst (list number (+ number 3330) (+ number (* 2 3330)))))
			  lst)))))))