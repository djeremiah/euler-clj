(ns euler.problem6
  "The sum of the squares of the first ten natural numbers is,

  1^2+2^2+...+10^2=385
  The square of the sum of the first ten natural numbers is,

  (1+2+...+10)^2=552=3025
  Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025−385=2640.

  Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.")

(def numbers 
  "The range of numbers we're going to sum"
  (range 1 101))

(defn square 
  "Square a number"
  [x]
  (* x x))

(def sum-of-squares
  "The sum of the squares of the numbers"
  (reduce + (map square numbers)))

(def square-of-sum
  "The square of the sum of the numbers"
  (square (reduce + numbers)))

(defn -main []
  (time (println (- square-of-sum sum-of-squares))))