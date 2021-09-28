(ns common.fib)

(defn step 
  "The Fibonacci step function"
  [[a b]]
  [b (+ a b)])

(def fibonacci-numbers
  "A lazy sequence of Fibonacci numbers"
  (map first (iterate step [0 1])))
