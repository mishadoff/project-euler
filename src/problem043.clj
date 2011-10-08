(ns mishadoff
  (:use [clojure.contrib.combinatorics :only (combinations permutations)]))
(def *seq* (range 10))
(defn drop-elem [elm seq]
  (filter #(not (= elm %)) seq))
(defn drop-elems [to-drop seq]
  (if (empty? to-drop) seq 
    (recur (rest to-drop) (drop-elem (first to-drop) seq))))
(defn is-div-by-n? [seq n]
  (zero? (mod (Integer/parseInt (reduce str seq)) n)))
(defn is-first5 [seq]
  (and (even? (nth seq 3))
       (zero? (mod (+ (nth seq 2) (nth seq 3) (nth seq 4)) 3))))
(defn first5-comb [digit5]
    (combinations (drop-elem digit5 *seq*) 5))
(defn first5 [digit5]
  (filter is-first5 
    (loop [sq (first5-comb digit5) resq nil] 
      (if (empty? sq) resq
        (recur (rest sq) (concat (permutations (first sq)) resq))))))
(defn last4 [first5-seq digit5]
  (permutations (drop-elem digit5 (drop-elems first5-seq *seq*))))
(reduce + (map #(bigint (reduce str %)) (filter #(not (nil? %)) 
  (for [digit5 [0 5] first5-seq (first5 digit5) last4-seq (last4 first5-seq digit5)]
    (let [n4 (nth first5-seq 4) n6 (nth last4-seq 0) n7 (nth last4-seq 1)
          n8 (nth last4-seq 2) n9 (nth last4-seq 3)]
      (if (and (is-div-by-n? [n4 digit5 n6] 7)
               (is-div-by-n? [digit5 n6 n7] 11)
               (is-div-by-n? [n6 n7 n8] 13)
               (is-div-by-n? [n7 n8 n9] 17))
        (concat first5-seq (cons digit5 last4-seq))))))))
