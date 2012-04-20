(ns project-euler)

(defn pow-10 [n]
  (if (zero? n) 1
    (reduce * (take n (repeat 10)))))

(defn get-interval [n]
  (range (pow-10 n) (pow-10 (inc n))))

(defn calc [n idx sum]
  (let [idx1 (quot (- (dec n) sum) (inc idx))
	idx2 (mod (- (dec n) sum) (inc idx))]
    (- (int (nth (seq (str (nth (get-interval idx) idx1))) idx2)) 48)))

(defn get-digit [n]
  (loop [idx 0 cur-sum 0]
    (if
	(> n (+ cur-sum (* (inc idx) (count (get-interval idx)))))
      (recur (inc idx) (+ cur-sum (* (inc idx)(count (get-interval idx)))))
      (calc n idx cur-sum))))

;;Elapsed time: 202.645058 msecs
(defn euler-040 []
  (reduce * (map #(get-digit (pow-10 %)) (take 7 (iterate inc 0)))))