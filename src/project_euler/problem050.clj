(ns project-euler
  (:use [clojure.contrib.lazy-seqs :only (primes)]))

(defn prime? [prime]
  (if (= 1 prime) false
    (not-any? #(zero? (rem prime %)) (take-while #(<= (* % %) prime) primes))))

(def prime-sums
  (map first
       (iterate (fn [[sum s]] [(+ sum (first s)) (rest s)])
                [0 primes])))

(defn euler-50 []
  (loop [c 1]
    (let [sums (reverse (take c prime-sums))
          subs (take c (reverse (take-while #(> 1000000 (- % (last sums)))
                                            (rest prime-sums))))]
      (if-let [el (some #(if (prime? %) % nil)
                        (map #(- %1 %2) subs sums))]
        el
        (recur (inc c))))))