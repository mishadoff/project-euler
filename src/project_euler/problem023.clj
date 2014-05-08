(ns project-euler)

(defn sum-of-proper-divisors [n]
  (let [divs (filter #(zero? (mod n %))
                     (range 2 (Math/sqrt n)))]
    (reduce + (set (concat [1]
                           (let [isq (int (Math/sqrt n))]
                             (if (= n (* isq isq)) [isq] []))
                           divs
                           (map #(/ n %) divs))))))

(defn is-abundant? [n]
  (> (sum-of-proper-divisors n) n))

(defn abundant-sum? [n abundant]
  (some #(abundant (- n %))
        (take-while #(< % n) abundant)))
   
;; Elapsed time: 14591.108689 msecs
(defn euler-023 []
  (let [abundant (into (sorted-set) (filter is-abundant? (range 12 28124)))]
    (reduce + (remove #(abundant-sum? % abundant) (range 1 28124)))))
