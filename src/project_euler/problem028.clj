(ns project-euler)

;; Elapsed time: 3.276816 msecs
(defn euler-028 []
  (inc (reduce + 
               (loop [incr 2 times 0 number 1 lst [] depth 0]
                 (if (= (/ (dec 1001) 2) depth) lst
                     (if (= times 4)
                       (recur (+ 2 incr) 0 number lst (inc depth)) 
                       (recur incr (inc times) (+ number incr) 
                              (conj lst (+ number incr)) depth)))))))