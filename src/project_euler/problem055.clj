(ns project-euler)

(defn reverse-num [n]
  (bigint (truncate-lead-zeros (apply str (reverse (str n))))))

(defn truncate-lead-zeros [s]
  (if (.startsWith s "0") (truncate-lead-zeros (.substring s 1)) s))

(defn is-palindrom? [n]
  (= n (reverse-num n)))

(defn is-lychrel? [n]
  (loop [num n iter 1]
    (if (>= iter 50) true
        (if (and (not= iter 1) (is-palindrom? num)) false
            (recur (+ num (reverse-num num)) (inc iter))))))

(def lychrel-seq
  (for [i (iterate inc 10)
        :when (is-lychrel? i)]
    i))

;; Elapsed time: 862.352047 msec
(defn euler-055 []
  (count (take-while #(< % 10000) lychrel-seq)))