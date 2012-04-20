(ns project-euler
  (:use [clojure.contrib.math :only (lcm)]))

;; Elapsed time: 0.210153 msecs
(defn euler-005 []
  (reduce lcm (range 1 21)))