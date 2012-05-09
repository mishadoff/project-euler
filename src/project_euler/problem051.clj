(ns project-euler
  (:use [clojure.contrib.lazy-seqs :only (primes)])
  (:use [clojure.contrib.combinatorics :as comb]))

(defn prime? [prime]
  (if (= 1 prime) false
    (not-any? #(zero? (rem prime %)) (take-while #(<= (* % %) prime) primes))))

(defn make-gold [nums patset]
  "Transforms digit array into gold pattern due to set of indexes.
   (make-gold [3 5 7] #{1}) => [3 :replace 7]"
  (loop [c 0 res []]
    (if (< c (count nums))
      (if (contains? patset c)
        (recur (inc c) (conj res :replace))
        (recur (inc c) (conj res (nth nums c))))
      res)))

(defn candidates [num patset]
  (let [nums (map #(- (int %) 48) (seq (str num)))
        gold (make-gold nums patset)
        sq (if (contains? patset 0) (range 1 10) (range 10))]
    (for [i sq]
      (read-string (apply str
                          (for [j gold]
                            (if (= j :replace) i j)))))))
    
(defn patterns [num]
  (let [n (count (seq (str num)))]
    (map set (rest (comb/subsets (range (dec n)))))))

(defn count-primes [num]
  (loop [[pat & pats] (patterns num) pc 0 rslt []]
    (if pat
      (let [new-pc (count (filter prime? (candidates num pat)))]
        (if (> new-pc pc) (recur pats new-pc (candidates num pat)) (recur pats pc rslt)))
      [pc rslt])))

;; Elapsed time: 35722.899957 msecs
(defn euler-051 []
  (loop [[pr & prim] (drop-while #(< % 10) primes)]
    (let [[a b] (count-primes pr)]
      (if (= 8 a) (first b)
          (recur prim)))))