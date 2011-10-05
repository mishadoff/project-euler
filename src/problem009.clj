(ns mishadoff)
(defn is-triplet? [a b c]
  (and (> c b a) (= (+ (* a a) (* b b)) (* c c))))
(for [a (range 1 1000) b (range a 1000) c [(- 1000 a b)]
  :when (is-triplet? a b c)] (* a b c))

