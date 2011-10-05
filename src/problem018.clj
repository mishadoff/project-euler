(ns mishadoff)
(def *triangle*
  (map #(Integer/parseInt %)(map #(reduce str %) (partition 2 2 (remove #(or (= \newline %) (= \ %))
    (seq (slurp "res/problem018.txt")))))))

(def *size*
  (loop [lst *triangle* t 0]
    (if (= 0 (count lst)) t
      (recur (drop (inc t) lst) (inc t)))))

(def *nested-triangle*
  (loop [lst *triangle* n 1 newlist nil]
    (if (empty? lst) (reverse newlist)
      (recur (drop n lst) (inc n) (cons (take n lst) newlist)))))

(defn max-row [lst]
  (map #(reduce max %) (partition 2 1 lst)))

(loop [triangle *nested-triangle* sum-row (take *size* (repeat 0))]
  (if (= 1 (count triangle)) (+ (first sum-row) (first (first triangle)))
    (recur (drop-last triangle) (max-row (map + (last triangle) sum-row))))) 