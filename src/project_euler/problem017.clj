(ns project-euler)

(def first20 ["one" "two" "three" "four" "five"
              "six" "seven" "eight" "nine" "ten"
              "eleven" "twelve" "thirteen" "fourteen" "fifteen"
              "sixteen" "seventeen" "eighteen" "nineteen"])
(def decas ["" "ten" "twenty" "thirty" "forty" "fifty" "sixty" "seventy" "eighty" "ninety"])
(def h "hundred")
(def t "thousand")
(def a "and")

(defn word-length [n]
  (cond (= n 1000) (+ (count t) (count (nth first20 1)))
        (< n 100)
        (let [q (quot n 10) m (mod n 10)
              d (count (nth decas q))]
          (if (zero? m) d
              (if (< q 2) (count (nth first20 (dec (+ m (* 10 q)))))
                  (+ d (count (nth first20 (dec m)))))))
        (< n 1000)
        (let [q (quot n 100) m (mod n 100)]
          (if (zero? m) (+ (word-length q) (count h))
              (+ (count a) (count h) (word-length q) (word-length m))))))

;; Elapsed time: 30.973979 msecs
(defn euler-017 []
  (reduce + (map word-length (range 1 1001))))