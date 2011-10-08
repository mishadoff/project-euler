(ns mishadoff)
(defn is-triangle? [n]
  (let [t (/ (dec (Math/sqrt (inc (* 8 n)))) 2)]
    (if (and (pos? n) (= t (quot t 1))) true false)))
(defn is-pentagonal? [n]
  (let [t (/ (inc (Math/sqrt (inc (* 24 n)))) 6)]
    (if (and (pos? n) (= t (quot t 1))) true false)))
(defn is-hexagonal? [n]
  (let [t (/ (inc (Math/sqrt (inc (* 8 n)))) 2)]
    (if (and (pos? n) (= t (quot t 1))) true false)))
(defn triangle-number [n]
  (* n (/ (+ n 1) 2)))
(defn pentagonal-number [n]
  (* n (/ (- (* 3 n) 1) 2)))
(defn hexagonal-number [n]
  (* n (- (* 2 n) 1)))
(def triangles (map triangle-number (iterate inc 1)))
(def pentagonals (map pentagonal-number (iterate inc 1)))
(def hexagonals (map hexagonal-number (iterate inc 1)))
(first (drop-while #(not (and (is-triangle? %) (is-pentagonal? %)))
                   (drop-while #(< % (inc 40755)) hexagonals)))

