(ns mishadoff)
(defn is-palindrom? [n]
  (let [s (seq (str n))]
    (= s (reverse s))))
(reduce max (filter is-palindrom? 
  (for [i (range 100 1000) j (range i 1000)] (* i j))))