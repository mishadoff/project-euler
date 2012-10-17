(ns project-euler)

(defn anagram-default [n1]
  (apply str (sort (str n1))))

(defn anagram-number? [n1 n2]
  (= (anagram-default n1) (anagram-default n2)))

(def cubes (map #(* % % %) (iterate inc 1)))

;; Elapsed time: 86.66619 msecs
(defn euler-062 []
  (loop [[c & cs] cubes mp {}]
    (let [angr (anagram-default c)]
      (if (= 4 (count (get mp angr []))) (reduce min (get mp angr))
          (recur cs (assoc mp angr (conj (get mp angr []) c)))))))
