(ns euler.problem9
  "A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

  a^2 + b^2 = c^2
  For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

  There exists exactly one Pythagorean triplet for which a + b + c = 1000.
  Find the product abc.")

(defn sq 
  "Square n"
  [n]
  (* n n))

(defn pythag-triple? 
  "Is [a b c] a Pythagorean triplet?"
  [[a b c]]
  (= (sq c) (+ (sq a) (sq b))))

(def triples
  "All triples (Pythagorean or not) for which a + b + c = 1000"
  (for [a (range 1 1000)
        b (range (inc a) 1000)
        :let [c (- 1000 a b)]
        :when (= 1000 (+ a b c))]
      [a b c]))

(defn -main []
  (time
  (->> triples
    (filter pythag-triple?)
    first
    (reduce *)
    println)))