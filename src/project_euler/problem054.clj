(ns project-euler
  (:use [clojure.set :as set]))

(declare str-to-card)

(def cards (map str-to-card (re-seq #"\w+" (slurp "res/poker.txt"))))

(def ROYAL_SET #{\T \J \Q \K \A})

(defn cardnum [rank]
  (cond (= rank \T) 10
        (= rank \J) 11
        (= rank \Q) 12
        (= rank \K) 13
        (= rank \A) 14
        :else (- (int rank) 48)))

(defn handscore [ranks]
  (loop [[c & cs] (reverse (sort-by cardnum ranks)) sum 0 size (count ranks)]
    (if c (recur cs (+ sum (* (int (Math/pow 15 (dec size))) (cardnum c))) (dec size)) sum)))

(defn is-straight? [ranks]
  (let [cards (sort-by cardnum ranks)]
    (and (= 5 (count cards))
         (= 5 (count (distinct cards)))
         (= 4 (- (cardnum (last cards)) (cardnum (first cards)))))))

(defn str-to-card [s]
  (seq s))

(defn card-rate [ss]
  (let [ranks (map first ss)
        suits (map second ss)]
    (cond (and (= 1 (count (distinct suits)))  ;; royal flush
               (= ROYAL_SET (set ranks)))
          (+ 1000000000 0)
          (and (= 1 (count (distinct suits))) ;; straight flush
               (is-straight? ranks))
          (+ 900000000 (handscore ranks))
          (some #(= % 4) (vals (frequencies ranks))) ;; four of kind
          (let [fr (frequencies ranks)]
            (+ 800000000 (reduce +
                             (for [[k v] fr]
                               (cond (= 4 v) (* 4 15 (cardnum k))
                                     (= 1 v) (cardnum k)
                                     :else 0)))))
          (and
           (some #(= % 3) (vals (frequencies ranks)))   ;; Full House
           (some #(= % 2) (vals (frequencies ranks))))
          (let [fr (frequencies ranks)]
            (+ 700000000 (reduce +
                             (for [[k v] fr]
                               (cond (= 3 v) (* 3 15 (cardnum k))
                                     (= 2 v) (* 2 (cardnum k))
                                     :else 0)))))
          (= 1 (count (distinct suits))) ;; Flush
          (+ 600000000 (handscore ranks))
          (is-straight? ranks)  ;; Straight
          (+ 500000000 (handscore ranks))
          (some #(= % 3) (vals (frequencies ranks))) ;; Three of Kind
          (let [fr (frequencies ranks)]
            (+ 400000000 (reduce +
                             (for [[k v] fr]
                               (cond (= 3 v) (* 3 15 (cardnum k))
                                     :else 0)))
                             (handscore (filter #(= (get fr %) 1) (keys fr)))))
          (= 2 (count (filter #(= % 2) (vals (frequencies ranks)))))  ;; Two Pairs
          (let [fr (frequencies ranks)]
            (+ 300000000 (* 15 (handscore (filter #(= 2 (get fr %)) ranks))) (handscore (filter #(= 1 (get fr %)) ranks))))
          (= 1 (count (filter #(= % 2) (vals (frequencies ranks)))))  ;; One Pair
          (let [fr (frequencies ranks)]
            (+ 200000000 (* 15 15 15 (handscore (filter #(= 2 (get fr %)) ranks))) (handscore (filter #(= 1 (get fr %)) ranks))))
          :else (handscore ranks)))) ;; High Card

(defn win? [h1 h2]
  (> (card-rate h1) (card-rate h2)))

;; Elapsed time: 350.271917 msecs
(defn euler-054 []
  (count (filter true? (for [e (partition 10 10 cards)]
    (win? (take 5 e) (drop 5 e))))))