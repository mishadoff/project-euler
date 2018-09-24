(ns project-euler.problem023)

(defn sum-of-proper-divisors [n]
  (let [divs (filter #(zero? (mod n %)) (range 2 (Math/sqrt n)))]
    (reduce + 1 (set (concat
                      (let [isq (int (Math/sqrt n))]
                        (if (= n (* isq isq)) [isq] []))
                      divs
                      (map #(/ n %) divs))))))

(defn abundant? [n]
  (> (sum-of-proper-divisors n) n))

(defn abundant-sum? [n abundant]
  (some #(abundant (- n %))
        (take-while #(< % n) abundant)))

;; Elapsed time: 14591.108689 msecs
(defn euler-023 []
  (let [abundant (into (sorted-set) (filter abundant? (range 12 28124)))]
    (->> (range 1 28124)
         (remove #(abundant-sum? % abundant))
         (reduce +))))
