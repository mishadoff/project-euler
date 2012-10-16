(ns project-euler)

;; lazy seqs
(defn- n-angle [f]
  (map f (rest (range))))

(defn filter-4-digits [lazy]
     (take-while #(< % 10000) (drop-while #(< % 1000) lazy)))

(def triangle (filter-4-digits (n-angle #(/ (* % (inc %)) 2))))
(def square (filter-4-digits (n-angle #(* % %))))
(def pentagonal (filter-4-digits (n-angle #(/ (* % (dec (* 3 %))) 2))))
(def hexagonal (filter-4-digits (n-angle #(* % (dec (* 2 %))))))
(def heptagonal (filter-4-digits (n-angle #(/ (* % (- (* 5 %) 3)) 2))))
(def octagonal (filter-4-digits (n-angle #(* % (- (* 3 %) 2)))))

;; Elapsed time: 138.196338 msecs
(defn euler-061 []
  (let [amap {:squ square :pen pentagonal :hex hexagonal :hep heptagonal :oct octagonal}]
    (first (for [n1 triangle :let [abn1 (quot n1 100) cdn1 (mod n1 100)]
                 k2 (keys amap) n2 (filter #(= cdn1 (quot % 100)) (get amap k2))
                 :let [cdn2 (mod n2 100) amap2 (dissoc amap k2)]
                 k3 (keys amap2) n3 (filter #(= cdn2 (quot % 100)) (get amap2 k3))
                 :let [cdn3 (mod n3 100) amap3 (dissoc amap2 k3)]
                 k4 (keys amap3) n4 (filter #(= cdn3 (quot % 100)) (get amap3 k4))
                 :let [cdn4 (mod n4 100) amap4 (dissoc amap3 k4)]
                 k5 (keys amap4) n5 (filter #(= cdn4 (quot % 100)) (get amap4 k5))
                 :let [cdn5 (mod n5 100) amap5 (dissoc amap4 k5)]
                 n6 (filter #(and (= cdn5 (quot % 100)) (= abn1 (mod % 100))) (first (vals amap5)))
                 :when (and n1 n2 n3 n4 n5 n6)]
             (+ n1 n2 n3 n4 n5 n6)))))