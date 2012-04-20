(ns project-euler)

(defn to-seq [n]
  (map #(- (int %) 48) (seq (str n))))

(defn is-pandigital? [a b]
  (if-not (= 4 (count (seq (str (* a b)))))
    false
    (if-not (= [1 2 3 4 5 6 7 8 9] 
            (sort (concat (to-seq a) (to-seq b) (to-seq (* a b)))))
      false true)))

;; Elapsed time: 909.178114 msecs
(defn euler-032 []
  (+
   (reduce + (distinct (filter #(not (nil? %))
                               (for [a (range 10 100) b (range 100 1000)]
                                 (if (is-pandigital? a b) (* a b))))))
   (reduce + (distinct (filter #(not (nil? %))
                               (for [a (range 1 10) b (range 1000 10000)]
                                 (if (is-pandigital? a b) (* a b))))))))
