(ns mishadoff)

(defn sum-of-proper-divisors [n]
  (let [base (filter #(zero? (mod n %)) (range 2 (inc (Math/sqrt n))))]
    (inc (reduce + (set (concat base (map #(/ n %) base)))))))

(defn is-abundant? [n]
  (> (sum-of-proper-divisors n) n))

(- (reduce + (range 1 28124))
   (reduce + (set 
     (let [abundant (filter is-abundant? (range 12 28124))]
       (for [i abundant j abundant :while (< (+ i j) 28124)]
         (+ i j))))))
      
  