(ns project-euler)

(defn select-coins [money lst]
    (if (or (empty? lst) (< money 0)) 0
      (if (= 1 (count lst)) 1
        (+ (select-coins money (butlast lst))
           (select-coins (- money (last lst)) lst)))))

;; Elapsed time: 211.23126 msecs
(defn euler-031 []
  (select-coins 200 [1 2 5 10 20 50 100 200]))
