(ns project-euler.problem026)

;; calculate cycle for 1/denom
;; e.g 1/3 = 0.(3), cycle is 3, length 1
;; e.g 1/7 = 0.(142857), cycle is 142857, length is 6

(defn unit-fraction [denom]
  (loop [numer 1 i 1 known {}]
    (let [r (rem (* 10 numer) denom)]
      (cond (zero? r) 0
            (get known r) (- i (get known r))
            :else (recur r (inc i) (assoc known r i))))))

;; "Elapsed time: 312.829133 msecs"
(defn euler-026 []
  (->> (range 1 1000)
       (map #(vec [% (unit-fraction %)]))
       (apply max-key second)
       (first)))
