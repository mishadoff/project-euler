(ns project-euler)

(defn fact-digit [n]
  (reduce + (map #(reduce *' (range 1 (inc (- (int %) 48)))) (seq (str n)))))

;; TODO find the way to calculate upper bound more smartly
;; Elapsed time: 10856.205671 msecs
(defn euler-034 []
  (reduce + (filter #(not (nil? %)) (for [i (range 10 1000000)]
                                      (if (= i (fact-digit i)) i)))))