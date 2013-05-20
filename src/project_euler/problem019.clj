(ns project-euler
  (import [java.util GregorianCalendar]))

;; Elapsed time: 45.007752 msecs
(defn euler-019 []
  (reduce +
   (let [c (new GregorianCalendar)]
     (for [year (range 1901 (inc 2000)) month (range 1 (inc 12))]
       (do
         (.set c GregorianCalendar/YEAR year)
         (.set c GregorianCalendar/MONTH month)
         (.set c GregorianCalendar/DAY_OF_MONTH 1)
         (if (= GregorianCalendar/SUNDAY (.get c GregorianCalendar/DAY_OF_WEEK)) 1 0))))))