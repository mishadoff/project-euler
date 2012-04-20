(ns project-euler)

(defn is-triplet? [a b c]
  (and (> c b a) (= (+ (* a a) (* b b)) (* c c))))

;; Elapsed time: 240.380779 msec
(defn euler-009 []
  (first
   (for [a (range 1 1000) b (range a 1000) c [(- 1000 a b)]
         :when (is-triplet? a b c)] (* a b c))))