(ns test)
(defn proper-divisors [n]
  (let [sqrt-n (int (Math/sqrt n))
        divs-upto-sqrt (filter #(zero? (rem n %)) (range 2 (inc sqrt-n)))
        rest-of-divs (reverse (map #(/ n %) divs-upto-sqrt))]
    (concat '(1) divs-upto-sqrt
      (if (= n (* sqrt-n sqrt-n))
        (drop 1 rest-of-divs)
        rest-of-divs))))
 
(defn abundant? [n]
  (> (apply + (proper-divisors n)) n))
 
(defn sum-abnums [upto]
  (reduce +
    (let [abnums (filter abundant? (range 1 upto))]
      (set
        (for [x abnums
              y abnums
              :while (and (<= y x) (<= (+ x y) upto))]
          (+ x y)
          )
        )
      )
    )
  )
 
(def test-upto 28123)
 
(defn euler-23 []
  (- (/ (* test-upto (inc test-upto)) 2)
    (sum-abnums test-upto)))

