(ns euler.problem5
  "2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

  What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?"
  (:require 
    [common.prime :refer [prime-factors]]
    [fastmath.core :refer [fpow]]))

(def divisors 
  "The range of numbers we're going to divide by."
  (range 2 21))

(defn -main 
  "We can construct the answer directly by multiplying the prime factors of all the divisors by their total arities"
  []
  (time
  (->> divisors
    (map prime-factors)
    (map frequencies)
    (apply merge-with max)
    (map (fn [[x y]] (fpow x y)))
    (reduce *)
    int
    println)))
