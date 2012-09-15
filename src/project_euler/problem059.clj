(ns project-euler)

(def TEXT (map read-string (re-seq #"\d+" (slurp "res/problem059.txt"))))

(defn possible-pass []
  (for [i (range 97 123) j (range 97 123) k (range 97 123)]
    [i j k]))

(defn to-text [n]
  (apply str (map char n)))

(defn get-words [text]
  (set (re-seq #"\w+" text)))

(defn break-cipher [TEXT key]
  (let [key-long (take (count TEXT) (cycle key))
        orig (map bit-xor key-long TEXT)
        sum-num (reduce + orig)
        wrds (get-words (to-text orig))]
    (if (contains? wrds "The")
         [sum-num wrds] [0 #{}])))

;; Elapsed time: 10784.349459 msecs
(defn euler-059 []
  (loop [[k & ks] (possible-pass)]
    (if k
      (let [[s ws] (break-cipher TEXT k)]
        (if (= s 0) (recur ks) [s ws])) 0)))