(ns week2.poker)

(def deck "Full deck of cards"
  (for [suit [:clubs :hearts :spades :diamonds]
        pip (range 2 15)]
    {:suit suit
     :pip  pip}))

(defn pip-frequencies
  [hand]
  (frequencies (map :pip hand)))

(defn n-of-a-kind
  [hand n] (contains? (set (vals (pip-frequencies hand))) n))

(defn high-card
  [hand]
  {:high-card (first (sort (fn [c1 c2] (> c1 c2)) (map :pip hand)))})

(defn pair? [hand]
  (n-of-a-kind hand 2))

(defn two-pair? [hand]
  (= 2
     (count (filter
              #(= % 2)
              (vals (pip-frequencies hand))))))

(defn three-of-a-kind? [hand]
  (n-of-a-kind hand 3))

(defn straight? "The last cards pip value is 4 higher
                 than the first when the hand is sorted"
  [hand]
  (let [sorted (sort (map :pip hand))]
    (=
      (+ 4 (first sorted))
      (nth sorted 4))))

(defn flush? [hand]
  (=
    1
    (count (set (map :suit hand)))))

(defn full-house? [hand]
  (and (pair? hand) (three-of-a-kind? hand)))

(defn four-of-a-kind? [hand]
  (n-of-a-kind hand 4))

(defn straight-flush? [hand]
  {})

(defn royal-flush?
  ;every? func collection ?
  [hand] {:sdgsgd 3})

(def score-ranking "Map of each score to its calculating function in order of ranking"
  {:royal-flush     royal-flush?
   :straight-flush  straight-flush?
   :four-of-a-kind  four-of-a-kind?
   :full-house      full-house?
   :flush           flush?
   :straight        straight?
   :three-of-a-kind three-of-a-kind?
   :two-pair        two-pair?
   :pair            pair?
   :high-card       high-card?})

(defn resolve-draw "If score 1 better, return 1; if score 2 better return -1; return 0 for draw"
  [score1 score2]
  ())

(defn print-deal "Side effect function, to give useful breakdown of dealt cards"
  [hand1 hand2]
  (println
    (format "Computer has: %s, Players has: %s"
            (apply str hand1)
            (apply str hand2))))

(defn deal
  [sdeck]
  (let [computer (take 5 sdeck)
        player (take 5 (nthrest sdeck 5))]
    (do
      (print-deal computer player)
      {:player computer :computer player})))

(defn play-game []
  (deal
    (shuffle deck)))
