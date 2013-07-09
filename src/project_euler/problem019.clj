(ns project-euler
  (import [java.util GregorianCalendar]))

;; Elapsed time: 13.592651 msecs
(defn euler-019 []
  (reduce +
          (for [year (range 1901 (inc 2000)) month (range 1 (inc 12))]
            (let [c (doto (GregorianCalendar.)
                      (.set GregorianCalendar/YEAR year)
                      (.set GregorianCalendar/MONTH month)
                      (.set GregorianCalendar/DAY_OF_MONTH 1))]
              (if (= GregorianCalendar/SUNDAY 
                     (.get c GregorianCalendar/DAY_OF_WEEK)) 1 0)))))
