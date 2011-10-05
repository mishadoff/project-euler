(ns mishadoff)
(defn concat-product [num mul string]
  (cond 
    (< (count string) 9) (recur num (inc mul) (str string (* num mul)))
    (> (count string) 9) nil
    (= (count string) 9) string ))
(defn is-pandigital? [dig-string]
  (and (= (count dig-string) 9)
       (= dig-string (apply str (distinct (seq dig-string))))
       (not (some #(= % \0) (seq dig-string)))))
(reduce max (map #(Integer/parseInt %) (filter is-pandigital? 
    (map #(concat-product % 1 nil) (take 10000 (iterate inc 1))))))