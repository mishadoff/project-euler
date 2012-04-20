(ns project-euler)

(defn is-palindrom? [str]
  (= (seq str) (reverse (seq str))))

;; Elapsed time: 1966.153173 msecs
(defn euler-036 []
  (reduce + (filter #(not (nil? %)) 
                    (for [i (range 1 1000000)]
                      (if (and (is-palindrom? (str i)) (is-palindrom? (Integer/toString i 2)))
                        i )))))

