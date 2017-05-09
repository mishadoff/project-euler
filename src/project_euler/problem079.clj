(ns project-euler.problem079)

(defn orderings
  ([onenum] [onenum])
  ([basenum num] (orderings [] basenum num))
  ([prefix basenum num]
   (cond
     (and (empty? basenum) (empty? num)) [prefix]
     (empty? basenum) (orderings (conj prefix (first num)) basenum (rest num))
     (empty? num) (orderings (conj prefix (first basenum)) (rest basenum) num)
     :else (concat
            (orderings (conj prefix (first basenum)) (rest basenum) num)
            (orderings (conj prefix (first num)) basenum (rest num))))))

(defn simplify [ordering]
  (->> ordering
       (partition-by identity)
       (map first)
       (into [])))

(defn orderings-simplified [orderings]
  (->> orderings
       (mapv simplify)
       ((fn [ords]
          (let [mincount (apply min (map count ords))]
            (filterv #(= mincount (count %)) ords))))
       (distinct)
       (into [])))

(defn advance-secret [best-orderings next]
  (let [to-digits (fn [n] (into [] (map #(- (int %) 48) (str n))))]
    (cond
      (empty? best-orderings) (orderings (to-digits next))
      :else
      ;; for each ordering merge it with current, concat all and simplify
      (->> (for [o best-orderings]
             (orderings-simplified (orderings o (to-digits next))))
           (apply concat)
           (orderings-simplified)))))

(defn find-password []
  (apply str (first (reduce #(advance-secret %1 %2) nil guesses))))




(def guesses
  [319
680
180
690
129
620
762
689
762
318
368
710
720
710
629
168
160
689
716
731
736
729
316
729
729
710
769
290
719
680
318
389
162
289
162
718
729
319
790
680
890
362
319
760
316
729
380
319
728
716])
