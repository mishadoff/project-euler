(ns project-euler
  (:require [clojure.set :as sets])
  (:require [clojure.contrib.combinatorics :as comb]))

(defn selections [items n]
  (filter #(= n (count (distinct %)))
          (comb/selections items n)))

(defn diff [items & ss]
  (apply sets/difference items (map set ss)))

(defn start-from-min [arr]
  (let [[idx _]
        (apply min-key second (map-indexed vector (map first arr)))
        [a b] (split-at idx arr)]
    (concat b a)))

(defn euler-068 []
  (->
   (let [items #{1 2 3 4 5 6 7 8 9 10}]
     (for [line1 (map vec (selections items 3)) :let [s (reduce + line1)]
           line2 (map vec (selections (diff items line1) 2))
           :let [line2-true [(first line2) (nth line1 2) (second line2)]]
           :when (= s (reduce + line2-true))
           line3 (map vec (selections (diff items line1 line2) 2))
           :let [line3-true [(first line3) (nth line2 1) (second line3)]]
           :when (= s (reduce + line3-true))
           line4 (map vec (selections (diff items line1 line2 line3) 2))
           :let [line4-true [(first line4) (nth line3 1) (second line4)]]
           :when (= s (reduce + line4-true))
           :let [e (first (diff items line1 line2 line3 line4))
                 line5-true [e (second line4) (second line1)]]
           :when (= s (reduce + line5-true))]
       (apply str (flatten (start-from-min [line1 line2-true line3-true line4-true line5-true])))))
   distinct
   sort
   reverse
   first
   read-string))
