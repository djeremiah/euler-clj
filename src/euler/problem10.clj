(ns euler.problem10
  "The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

  Find the sum of all the primes below two million."
  (:require 
    [common.prime :refer [primes]]))

(defn -main 
  "Brute. Force."
  []
  (time
  (->> primes
    (take-while (partial > 2e6))
    (reduce +)
    println)))
    