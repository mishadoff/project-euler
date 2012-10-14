(ns project-euler
  (:use [clojure.contrib.lazy-seqs :only (primes)]))

(defn prime? [n]
  (empty? (filter #(zero? (mod n %))
                  (take-while #(<= % (Math/sqrt n)) primes))))

(defn concat-num [n1 n2]
  (read-string (str n1 n2)))

(defn concat-all-primes? [primes prime]
  (every? prime? (concat
                  (map #(concat-num prime %) primes)
                  (map #(concat-num % prime) primes))))

;; Incorrect assumption that list of 5 is the list of 4 + 1

;; Elapsed time: 88104.727919 msecs
(defn euler-060 []
  (loop [n 100]
    (let [r (let [limit (take-while #(< % n) primes)]
              (first (for [p1 limit
                           p2 (filter #(concat-all-primes? [p1] %) (drop-while #(< % p1) limit))
                           p3 (filter #(concat-all-primes? [p1 p2] %) (drop-while #(< % p2) limit))
                           p4 (filter #(concat-all-primes? [p1 p2 p3] %) (drop-while #(< % p3) limit))
                           p5 (filter #(concat-all-primes? [p1 p2 p3 p4] %) (drop-while #(< % p4) limit))]
                       (+ p1 p2 p3 p4 p5))))]
      (if (nil? r) (recur (* 5 n)) r))))