(ns week2.poker)

(def deck "Full deck of cards"
  (for [suit [:clubs :hearts :spades :diamonds]
        pip (range 2 15)]
    {:suit suit
     :pip pip}))

(def score-ranking "Map of each score to its calculating function in order of ranking"
  {:royal-flush      royal-flush
   :straight-flush   straight-flush
   :four-of-a-kind   four-of-a-kind
   :full-house       full-house
   :flush            a-flush
   :straight         straight
   :three-of-a-kind  three-of-a-kind
   :two-pairs        two-pair
   :pair             a-pair
   :high-card        high-card})

(defn n-of-a-kind
  [hand n] (contains? (set (vals (frequencies (map :pip hand)))) n))

(defn royal-flush
  ;every? func collection ?
  [hand] {})

(defn straight-flush [hand]
  {})

(defn four-of-a-kind [hand]
  (n-of-a-kind hand 4))

(defn full-house [hand]
  (and (a-pair hand) (three-of-a-kind hand)))

(defn a-flush [hand]
  {})

(defn straight [hand]
  {})

(defn three-of-a-kind [hand]
  (n-of-a-kind hand 3))

(defn two-pair [hand]
  {})

(defn a-pair [hand]
  (n-of-a-kind hand 2))

(defn high-card [hand]
  ())

(defn resolve-draw "If score 1 better, return 1; if score 2 better return -1; return 0 for draw"
  [score1 score2]
  ())

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
    (print-deal computer player)
    {:player computer :computer player})))

(defn play-game []
  (deal (shuffle deck)))










