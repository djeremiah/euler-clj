(ns euler.problem3
  "The prime factors of 13195 are 5, 7, 13 and 29.

  What is the largest prime factor of the number 600851475143 ?"
  (:require 
    [common.prime :refer [prime?]]
    [fastmath.core :refer [sqrt]]))

(def target 
  "The target composite number (change value for testing)"
  600851475143)

(defn factor? 
  "Is x a factor of 'target"
  [x]
  (zero? (mod target x)))

(defn -main []
  (time
  (->>
    (range 1 (sqrt target))
    (filter factor?)
    (map (fn [x] [x (/ target x)])) ; the other factor
    flatten
    distinct
    (filter prime?)
    (apply max)
    println)))

