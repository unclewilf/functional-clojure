(ns testarea)

(read-string "42")

(read-string "(+ 21 2)")

(+ 21 2)

(def person {:name "Will" :age 12})

(println :name person)

(println (:name person))

(println (person :name))

(keys person)

(apply str '(1 2 3 4 5))

(apply str '("yo" "moma" "so" "fat"))

(apply str (interpose ", " '("yo" "moma" "so" "fat")))


(do (print "yo ") (print "moma") 42)

(do (println "yo ") (println "moma") 42)

(let [a 10 b 32] (println (format "The answer is %s" 23)))

(let [a 10 b 32] (println (format "The answer is %s" a)))

(let [a 10 b 32] (println (format "The answer is %s" (+ a b))))

(def v [1 "test" "BO" [12]])

(let [[x y z] v] (print x y z))

(let [[x y z] v] (println x y z))


(let [[x y z a] v] (println x y z))

(let [[x y z a] v] (println x y z (first a)))

(let [[x y z [a b]] v] (println x y z a b))

(let [[x y z [a b]] v] (println x y z a))

(def v [1 "test" "BO" [12 13]])


(let [[x y z [a b]] v] (println x y z a b))

(let [[x y z & rest] v] (println rest))

(let [[x y z & rest] v] (println (second rest)))

(let [[x y z & rest] v] (println (first rest)))

(let [[x y z & rest] v] (println (first (first rest))))




(defn add [listie]
  (let [x (first listie)
        y (second listie)]
    (+ x y)))

(println (add '(1 2)))


(def deck
  (for [suit [:clubs :hearts :spades :diamonds]
        pip (range 2 15)]
    {:suit suit
     :pip pip}))

(defn print-deal [hand1 hand2]
  (println
   (format "Computer has: %s, Players has: %s"
           (apply str hand1)
           (apply str hand2))))

(defn deal
  [sdeck]
  (let [computer (take 5 sdeck)
        player (take 5 (nthrest sdeck 5))]
  (do
    (println "Hi")
    {:player computer :computer player})))



(deal deck)










