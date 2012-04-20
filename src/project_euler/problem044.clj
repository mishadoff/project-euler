(ns project-euler
  (:use [clojure.contrib.math :only (abs)]))

(defn is-pentagonal? [n]
  (let [t (/ (inc (Math/sqrt (inc (* 24 n)))) 6)]
    (if (and (pos? n) (= t (quot t 1))) true false)))

(defn pentagonal-number [n]
  (* n (/ (- (* 3 n) 1) 2)))

(def pentagonals (map pentagonal-number (iterate inc 1)))

;; Elapsed time: 37549.503401 msecs
(defn euler-044 []
  (first (filter #(not (nil? %))
          (for [i (take 10000 pentagonals) j (take 10000 pentagonals)]
            (if (and (is-pentagonal? (- i j)) (is-pentagonal? (+ i j)))
              (abs (- i j)))))))