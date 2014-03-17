
(ns week2.poker)

(def deck
  (for [suit [:clubs :hearts :spades :diamonds]
        pip (range 2 15)]
    {:suit suit
     :pip pip}))

(count deck)

(frequencies (map :suit deck))

(def sdeck (shuffle deck))

(def hand (take 5 sdeck))

(map :pip hand)

(map :suit hand)

(set (vals (frequencies (map :suit hand))))

(defn two-of-a-kind
  [hand] (n-of-a-kind hand 2))

(defn three-of-a-kind
  [hand] (n-of-a-kind hand 3))

(defn four-of-a-kind
  [hand] (n-of-a-kind hand 4))

(defn full-house
  [hand] (n-of-a-kind hand 5))

(defn n-of-a-kind
  [hand n] (contains? (set (vals (frequencies (map :suit hand)))) n))

(two-of-a-kind hand)

(three-of-a-kind hand)

(four-of-a-kind hand)

(full-house hand)













