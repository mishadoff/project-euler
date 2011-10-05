(ns mishadoff
  (:use [clojure.contrib.math :only (floor)]))
(defn find-pos [elm lst pos]
  (if (empty? lst) -1
  (if (= elm (first lst)) pos
    (recur elm (rest lst) (inc pos)))))

(defn recur-length [numer n lst]
    (if (some #(= % [(floor (/ numer n)) numer]) lst)
    [(inc (find-pos [(floor (/ numer n)) numer] lst 0)) n]
    (if (zero? numer)
      [0 n]
      (if (< numer n)
        (recur-length (* 10 numer) n (cons [0 numer] lst))
        (recur-length (* 10 (rem numer n)) n (cons [(floor (/ numer n)) numer] lst))))))

(reduce #(if (> (first %1) (first %2)) %1 %2) 
         (map #(recur-length 10 % []) (range 1 1000)))