(ns project-euler)

;; bruteforce solution (not works well)
(defn generate-fractions [maxd]
  (sort
   (distinct
    (for [i (range 1 maxd)
          j (range (inc i) maxd)]
      (/ i j)))))

;; Take a look at the Farey Sequence
;; http://en.wikipedia.org/wiki/Farey_sequence
;;
;; Mega property:
;; if [p1/q1 are neighbour to p2/q2] then q1p2 - q2p1 = 1
;; p2 = 3, q2 = 7
;; We need to solve diofantine equation
;; 3q1 - 7p1 = 1
;; 3q1 - 1 = 7p1

(defn euler-071 []
  (loop [q1 1000000]
    (let [left (dec (* 3 q1))]
      (if (zero? (mod left 7)) [q1 (/ left 7)]
          (recur (dec q1))))))