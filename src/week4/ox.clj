(ns week4.ox)

(defn nth-column-win [game pos]
  (= 1 (count (set
                (map pos game)))))

(defn first-column-win? [game]
  (nth-column-win game first))

(defn third-column-win? [game]
  (nth-column-win game last))



(defn winner? [game]
  (or (first-column-win? game)
      (third-column-win? game)))
