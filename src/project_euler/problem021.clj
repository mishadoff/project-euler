(ns project-euler.problem021)

(defn sum-of-proper-divisors [n]
  (let [base (filter #(zero? (mod n %)) (range 2 (Math/sqrt n)))]
    (reduce + 1 (concat (map #(/ n %) base) base))))

(defn amicable? [a b]
  (and (not (= a b))
       (= a (sum-of-proper-divisors b))
       (= b (sum-of-proper-divisors a))))

;; Elapsed time: 72.493076 msecs
(defn euler-021 []
  (reduce +
          (let [sums (vec (map sum-of-proper-divisors (range 1 10000)))] ;; vec is important
            (for [i (range 1 10000)]
              (if (amicable? i (nth sums (dec i))) i 0)))))
