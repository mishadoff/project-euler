(ns project-euler)

(defn power [n]
  (reduce *' (take n (repeat n))))

;; Elapsed time: 1628.871589 msecs
(defn euler-048 []
  (let [s (str (reduce +' (take 1000 (map power (iterate inc 1)))))]
    (read-string (subs s (- (count s) 10)))))