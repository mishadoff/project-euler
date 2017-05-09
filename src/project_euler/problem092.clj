(ns project-euler.problem092)

(def cache (atom {1 1
                  89 89}))

(defn advance [n]
  (->> n
       (str)
       (map #(- (int %) 48))
       (map #(* % %))
       (reduce +)))

(defn last-chain
  ([n] (last-chain n [] #{1 89}))
  ([n nums sets]
   (cond
     ;; chain finished?
     (sets n) (do ;; add numbers
                (doseq [nn nums] (swap! cache assoc nn (sets n)))
                ;; return last
                (sets n))
     :else
     (let [cnum (get @cache n)]
       (if cnum
         (do
           (doseq [nn nums] (swap! cache assoc nn cnum))
           cnum)
         ;; not in cache
         (do (last-chain (advance n) (conj nums n) (conj sets n))))))))
  

(defn solve []
  (loop [[i & rst] (range 1 10000000) cnt89 0]
    (if i
      (do (when (zero? (mod i 10000)) (println i))
          (let [end (last-chain i)]
            (if (= end 89)
              (recur rst (inc cnt89))
              (recur rst cnt89))))
      ; else
      cnt89
      )))
