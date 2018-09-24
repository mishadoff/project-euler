(ns project-euler.problem019
  (import [java.util GregorianCalendar]))

(defn calendar-for [year month]
  (doto (GregorianCalendar.)
    (.set GregorianCalendar/YEAR year)
    (.set GregorianCalendar/MONTH month)
    (.set GregorianCalendar/DAY_OF_MONTH 1)))

;; Elapsed time: 30.138531 msecs
(defn euler-019 []
  (reduce +
          (for [year (range 1901 (inc 2000)) month (range 1 (inc 12))]
            (let [c (calendar-for year month)]
              (if (= GregorianCalendar/SUNDAY 
                     (.get c GregorianCalendar/DAY_OF_WEEK)) 1 0)))))
