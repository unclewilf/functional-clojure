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
  [hand n]
  (contains? (set (vals (pip-frequencies hand))) n))

(defn high-card
  [hand]
  true)

(defn pair? [hand]
  (n-of-a-kind hand 2))

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
  (and
    (straight? hand)
    (flush? hand)))

(defn royal-flush?
  [hand]
  (and
    (straight-flush? hand)
    (= 14 (last (sort (map :pip hand))))))

(def score-ranking "Map of each score to its calculating function in order of ranking"
  (array-map :royal-flush royal-flush?
   :straight-flush straight-flush?
   :four-of-a-kind four-of-a-kind?
   :full-house full-house?
   :flush flush?
   :straight straight?
   :three-of-a-kind three-of-a-kind?
   :two-pair two-pair?
   :pair pair?
   :high-card high-card))

(defn determine-score [hand]
  (loop [my-keys (keys score-ranking)
         my-vals (vals score-ranking)]
    (if ((first my-vals) hand)
      (first my-keys)
      (recur (rest my-keys) (rest my-vals)))))

(defn resolve-draw "If score 1 better, return 1; if score 2 better return -1; return 0 for draw"
  [score1 score2]
  ())

(defn print-deal "Side effect function, to give useful breakdown of dealt cards"
  [hand1 hand2]
  (println
    (format "Computer has: %s\nPlayer has: %s"
            (apply str hand1)
            (apply str hand2))))

(defn deal
  [sdeck]
  (let [computer (take 5 sdeck)
        player (take 5 (nthrest sdeck 5))]
    (do
      (print-deal computer player)
      {:player computer :computer player})))

(defn score-hands [hands]
  (into {}
        (map
          (juxt key (comp determine-score val))
          hands)))

(defn show-winner [scores]
  (let [ranking (keys score-ranking)
        player-rank (.indexOf ranking (:player scores))
        computer-rank (.indexOf ranking (:computer scores))]
    (if (< player-rank computer-rank)
      (println (str "player wins with " (:player scores) " computer had " (:computer scores)))
      (if (< computer-rank player-rank)
        (println (str "you lost with " (:player scores) " computer had " (:computer scores)))
        (println (str "draw! player and computer had " (:player scores)))))))

(defn play-game []
  (show-winner (score-hands (deal (shuffle deck)))))

