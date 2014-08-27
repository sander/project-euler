(ns project-euler.core)

(defn divisible? [n d]
  (zero? (rem n d)))

(defn problem-1 []
  (apply + (apply clojure.set/union (map #(set (range 0 1000 %)) [3 5]))))
(defn problem-1 []
  (apply + (filter #(or (divisible? % 3) (divisible? % 5)) (range 1000))))
(defn problem-1 []
  (apply + (distinct (concat (range 0 1000 3) (range 0 1000 5)))))

(defn fib [a b]
  (cons a (lazy-seq (fib b (+ a b)))))

(defn problem-2 []
  (apply + (for [n (filter even? (fib 1 2)) :while (< n 4000000)] n)))

(def N (iterate inc 1))
(def triples (for [lim [25e6]
                   a (range 1 lim)
                   b (range 1 (inc a))
                   c (range (- a b) (inc b))]
               ;; better use triangle inequality
               ;; z <= x + y for all z
               ;; this sets a lower boundary for c at least?
               ;; a <= b + c so c >= a - b
               ;; b <= a + c so c >= b - a
               ;; b is always smaller than a so only the first is ok
               [a b c]))
(defn barely-acute? [[a b c]] (= (+ (* a a) (* b b)) (+ (* c c) 1)))
(defn problem-223 []
  ;; Let us call an integer sided triangle with sides a <= b <= c *barely
  ;; acute* if the sides satisfy
  ;;
  ;;     a^2 + b^2 = c^2 + 1
  ;;
  ;; How many barely acute triangles are there with perimeter <= 25 000 000?

  ;; a^2 + b^2 >= 1/2 (a + b)^2 cauchy-schwarz
  (filter barely-acute? triples))
