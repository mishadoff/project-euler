(ns mishadoff)
(let [
   digits ["one" "two" "three" "four" "five" "six" "seven" "eight" "nine"]
   numbers-after-ten ["ten" "eleven" "twelve" "thirteen" "fourteen" 
      "fifteen" "sixteen" "seventeen" "eighteen" "nineteen"]
   numbers-10 ["twenty" "thirty" "forty" "fifty" "sixty" "seventy" "eighty" "ninety"]
   hundred ["hundred"] thousand ["thousand"] and-symbol ["and"]]
  (+ 
    (* 190 (reduce + (map count digits)))
    (* 10 (reduce + (map count numbers-after-ten)))
    (* 100 (reduce + (map count numbers-10)))
    (* 900 (reduce + (map count hundred)))
    (* 891 (reduce + (map count and-symbol)))
    (* 1 (count (nth digits 0)))
    (* 1 (reduce + (map count thousand))))
  )
