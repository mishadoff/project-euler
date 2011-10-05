(ns mishadoff)

(defn sum-of-proper-divisors [n]
  (let [base (filter #(= (mod n %) 0) (range 2 (Math/sqrt n)))]
    (inc (reduce + (concat (map #(/ n %) base) base)))))

(defn is-amicable? [a b]
  (if (and (not (= a b))
           (= a (sum-of-proper-divisors b))
           (= b (sum-of-proper-divisors a))) true false))

(reduce + (filter #(not (nil? %))
  (let [sums (map sum-of-proper-divisors (range 1 10000))]
    (for [i (range 0 (dec 10000))]
      (if (is-amicable? (inc i) (nth sums i)) (inc i))))))