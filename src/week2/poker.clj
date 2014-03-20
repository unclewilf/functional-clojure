(ns week2.poker)

(def duff-hand '({:suit :diamonds, :pip 2}{:suit :clubs, :pip 3}{:suit :diamonds, :pip 5}{:suit :hearts, :pip 6}{:suit :spades, :pip 7}))

(def pair-hand '({:suit :diamonds, :pip 2}{:suit :clubs, :pip 2}{:suit :diamonds, :pip 3}{:suit :hearts, :pip 5}{:suit :spades, :pip 6}))

(def two-hand '({:suit :diamonds, :pip 2}{:suit :clubs, :pip 2}{:suit :diamonds, :pip 3}{:suit :hearts, :pip 3}{:suit :spades, :pip 5}))

(def three-hand '({:suit :diamonds, :pip 2}{:suit :clubs, :pip 2}{:suit :diamonds, :pip 3}{:suit :hearts, :pip 2}{:suit :spades, :pip 9}))

(def straight-hand '({:suit :diamonds, :pip 2}{:suit :clubs, :pip 3}{:suit :diamonds, :pip 4}{:suit :hearts, :pip 5}{:suit :spades, :pip 6}))

(def flush-hand '({:suit :clubs, :pip 2}{:suit :clubs, :pip 10}{:suit :clubs, :pip 4}{:suit :clubs, :pip 5}{:suit :clubs, :pip 6}))

(def full-hand '({:suit :clubs, :pip 2}{:suit :hearts, :pip 2}{:suit :clubs, :pip 4}{:suit :clubs, :pip 4}{:suit :clubs, :pip 4}))

(def four-hand '({:suit :diamonds, :pip 2}{:suit :clubs, :pip 2}{:suit :spades, :pip 2}{:suit :hearts, :pip 2}{:suit :spades, :pip 5}))

(def sflush-hand '({:suit :diamonds, :pip 2}{:suit :diamonds, :pip 4}{:suit :diamonds, :pip 3}{:suit :diamonds, :pip 5}{:suit :diamonds, :pip 6}))

(def rflush-hand '({:suit :clubs, :pip 13}{:suit :clubs, :pip 14}{:suit :clubs, :pip 12}{:suit :clubs, :pip 10}{:suit :clubs, :pip 11}))

(def duff '({:suit :diamonds, :pip 2}{:suit :clubs, :pip 2}{:suit :diamonds, :pip 3}{:suit :hearts, :pip 2}{:suit :spades, :pip 2}))

(def deck "Full deck of cards"
  (for [suit [:clubs :hearts :spades :diamonds]
        pip (range 2 15)]
    {:suit suit
     :pip pip}))

(defn n-of-a-kind
  [hand n] (contains? (set (vals (frequencies (map :pip hand)))) n))

(defn high-card? [hand]
  ({:high-card (sort (fn[c1 c2](> c1 c2)) hand)}))

(defn pair? [hand]
  (n-of-a-kind hand 2))

(defn two-pair? [hand]
  {})

(defn three-of-a-kind? [hand]
  (n-of-a-kind hand 3))

(defn straight? [hand]
  {})

(defn flush? [hand]
  {})

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
  {:royal-flush      royal-flush?
   :straight-flush   straight-flush?
   :four-of-a-kind   four-of-a-kind?
   :full-house       full-house?
   :flush            flush?
   :straight         straight?
   :three-of-a-kind  three-of-a-kind?
   :two-pair         two-pair?
   :pair             pair?
   :high-card        high-card?})

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
  
