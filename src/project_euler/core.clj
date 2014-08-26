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
