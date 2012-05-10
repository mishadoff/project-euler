(ns project-euler)

(defn fact [n]
  (reduce *' (range 1 (inc n))))

(defn comb [n r]
  (/ (fact n) (*' (fact r) (fact (- n r)))))

;; Elapsed time: 400.7951 msecs
(defn euler-053 []
  (count 
   (filter #(> % 1000000)
           (for [n (range 1 (inc 100)) r (range n)]
             (comb n r)))))