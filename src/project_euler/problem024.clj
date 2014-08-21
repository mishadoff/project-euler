(ns project-euler
  (:require [clojure.math.combinatorics :as comb]))

;; Elapsed time: 2848.733561 msecs
(defn euler-024 []
  (->> (range 10)
       (comb/permutations)
       (drop (dec 1000000))
       (first)
       (apply str)))

(defn euler-024-clever []
  (let [! (fn [n] (reduce * (range 1 (inc n))))]
    (loop [available-digits (range 10)
           num 1000000
           current-digit 0
           init 9
           result []]
      (let [f (! init)]
        (cond
         (= 0 init)
         (apply str (concat result available-digits))
         
         (< f num) (recur available-digits
                          (- num f)
                          (inc current-digit)
                          init
                          result)

         :else (recur (concat (take current-digit available-digits)
                              (drop (inc current-digit) available-digits))
                      num
                      0
                      (dec init)
                      (conj result (nth available-digits current-digit))))))))
