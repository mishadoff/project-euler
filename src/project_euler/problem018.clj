(ns project-euler)

(def triangle
  (map #(Integer/parseInt %)(map #(reduce str %) (partition 2 2 (remove #(or (= \newline %) (= \ %))
    (seq (slurp "res/problem018.txt")))))))

(def nested-triangle
  (loop [lst triangle n 1 newlist nil]
    (if (empty? lst) (reverse newlist)
      (recur (drop n lst) (inc n) (cons (take n lst) newlist)))))

(defn max-row [lst]
  (map #(reduce max %) (partition 2 1 lst)))

(defn step-max [lst1 lst2]
  (map + (max-row lst1) lst2))

;; Elapsed time: 0.421325 msecs
(defn euler-018 []
  (reduce step-max (reverse nested-triangle)))