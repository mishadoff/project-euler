(ns project-euler
  (:require [clojure.contrib.math :as m]))

(defn num-of-sums-stupid [n]
  (for [x (range 1 (inc (* n n)))
        y (range 1 (inc (* n n)))
        :when (= (/ 1 n) (+ (/ 1 x) (/ 1 y)))]
    [x y]))
