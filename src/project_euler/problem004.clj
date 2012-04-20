(ns project-euler)

(defn is-palindrom? [n]
  (let [s (seq (str n))]
    (= s (reverse s))))

;; Elapsed time: 687.401805 msecs
(defn euler-004 []
  (reduce max (filter is-palindrom? 
                      (for [i (range 100 1000) j (range i 1000)] (* i j)))))