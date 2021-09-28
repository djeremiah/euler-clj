(ns common.prime
  (:require [fastmath.core :as fm]))

(defn coprime-x? [x]
  (fn [n]
    (pos? (mod n x))))

(defn prime? [n]
  (case n
    1 false
    2 true
    3 true
    (if (odd? n)
      ((apply every-pred (map coprime-x? (range 3 (inc (fm/sqrt n)) 2))) n)
      false )))

(def primes
  (filter prime? (range)))

(defn prime-factors
  "Return a list of prime factors of N."
  ([n]
    (prime-factors n 2 ()))
  ([n k acc]
    (if (= 1 n)      
      acc
      (if (zero? (rem n k))        
        (recur (quot n k) k (cons k acc))
        (recur n (inc k) acc)))))
