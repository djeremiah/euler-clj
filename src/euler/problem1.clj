(ns euler.problem1
  "If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

  Find the sum of all the multiples of 3 or 5 below 1000.")

(defn div3? 
  "Is the number divisible by 3?"
  [x]
  (zero? (mod x 3)))

(defn div5? 
  "Is the number divisible by 5?"
  [x]
  (zero? (mod x 5)))

(defn -main []
  (time
  (->> 
    (range 1 1000)
    (filter (some-fn div3? div5?))
    (reduce +)
    println)))