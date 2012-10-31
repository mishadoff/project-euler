(ns project-euler)

(defn palindrome? [s]
  (= s (reverse s)))

(defn palindrome-number? [n]
  (palindrome? (seq (str n))))

;; Elapsed time: 297.596835 msecs
(defn euler-004 []
  (reduce max (filter palindrome-number?
                      (for [i (range 100 1000) j (range i 1000)] (* i j)))))