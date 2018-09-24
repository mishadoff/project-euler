(ns project-euler.problem009)

(defn is-triplet? [a b c]
  (= (+ (* a a) (* b b)) (* c c)))

;; Elapsed time: 42.579438 msecs
(defn euler-009 []
  (first (for [a (range 1 1000) b (range a (- 1000 a))
               :let [c (- 1000 a b)]
               :when (and (> c b) (is-triplet? a b c))] (* a b c))))