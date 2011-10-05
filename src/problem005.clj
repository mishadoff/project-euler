(ns mishadoff
  (:use [clojure.contrib.math :only (lcm)]))
(reduce lcm (range 1 21))

