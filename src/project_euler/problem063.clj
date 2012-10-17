(ns project-euler)

(defn pow [n e]
  (reduce *' (repeat e n)))

;; Elapsed time: 4.921157 msecs
(defn euler-063 []
  (loop [powers (iterate inc 1)
         [x & xs] (map #(pow % (first powers)) (iterate inc 1)) sum 0 hit false]
    (let [n (quot x (pow 10 (dec (first powers))))]
      (cond (< n 1) (recur powers xs sum hit)
            (< n 10) (recur powers xs (inc sum) true)
            :else (if hit (recur (rest powers)
                                 (map #(pow % (second powers)) (iterate inc 1))
                                 sum false) sum)))))