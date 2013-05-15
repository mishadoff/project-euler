(ns project-euler)

;; as bruteforce solution on farey sequence is very slow
;; we use property of 'Farey Pair' http://en.wikipedia.org/wiki/Farey_sequence#Farey_neighbours

;; a/b < c/d and they are neigbours
;; their difference 1/bd
;; bc - ad = 1
;; c/d is 3/7
;; 3b - 7a = 1
;; It's a diofantine equation
;;
;; a = (3b - 1) / 7
;; Solve it.

(defn euler-071 []
  (loop [b 1000000]
    (let [tmp (dec (* 3 b))]
      (if (zero? (rem tmp 7)) [(/ tmp 7) b]
          (recur (dec b))))))
