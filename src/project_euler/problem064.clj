(ns project-euler)

(defn continued-step [sq a n d]
  (if (= (* a a) sq) [a 0 0]
      (let [n-new (- (* a d) n)
            d-new (quot (- sq (* n-new n-new)) d)
            a-new (quot (+ (int (Math/sqrt sq)) n-new) d-new)]
        [a-new n-new d-new])))

(defn continued-fraction [sq]
  (iterate #(continued-step sq (nth % 0) (nth % 1) (nth % 2))
           [(int (Math/sqrt sq)) 0 1]))

(defn cycle-length [sq]
  (let [a (int (Math/sqrt sq))]
    (if (= (* a a) sq) 0
        (loop [[lc & lazy-cont] (continued-fraction sq)
               mpcl {} cl 1]
          (if (and (= (nth lc 0) -1) (= (nth lc 1) -1)) 0
              (let [mpkey (apply str (interpose "," lc))]
                (if (contains? mpcl mpkey)
                  (- cl (get mpcl mpkey))
                  (recur lazy-cont (assoc mpcl mpkey cl) (inc cl)))))))))

;; Elapsed time: 2564.481559 msecs
(defn euler-064 []
  (count (filter odd? (map cycle-length (range 1 (inc 10000))))))