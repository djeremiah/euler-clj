(ns euler.problem4
  "A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

  Find the largest palindrome made from the product of two 3-digit numbers.")

(defn palindrome? 
  "Is n a palindrome?"
  [n]
  (let [f (str n)
        r (apply str (reverse f))]
    (= f r)))

(def multiples
  "All the products of two 3-digit numbers"
  (for [x (range 999 100 -1)
        y (range x 100 -1)
        :let [t (* x y)]]
    t))

(defn -main []
  (time
  (->> multiples
    (filter palindrome?)
    (reduce max)
    println)))