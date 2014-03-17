
(ns week2.poker)

(def deck
  (for [suit [:clubs :hearts :spades :diamonds]
        pip (range 2 15)]
    {:suit suit
     :pip pip}))


(def sdeck (shuffle deck))

(def hand (take 5 sdeck))


(defn two-of-a-kind
  [hand] (n-of-a-kind hand 2))

(defn three-of-a-kind
  [hand] (n-of-a-kind hand 3))

(defn four-of-a-kind
  [hand] (n-of-a-kind hand 4))

(defn full-house
  [hand] (and (two-of-a-kind hand) (three-of-a-kind hand)))

(defn n-of-a-kind
  [hand n] (contains? (set (vals (frequencies (map :pip hand)))) n))




;tests

(count deck)

(frequencies (map :suit deck))


(map :pip hand)

(map :suit hand)


(full-house '({:suit :diamonds, :pip 3} {:suit :diamonds, :pip 3} {:suit :diamonds, :pip 3} {:suit :diamonds, :pip 3} {:suit :diamonds, :pip 3}))

(full-house '({:suit :heart, :pip 3} {:suit :heart, :pip 3} {:suit :diamonds, :pip 3} {:suit :diamonds, :pip 2} {:suit :diamonds, :pip 2}))

(full-house '({:suit :diamonds, :pip 3} {:suit :diamonds, :pip 3} {:suit :diamonds, :pip 3} {:suit :diamonds, :pip 3} {:suit :diamonds, :pip 3}))


(two-of-a-kind '({:suit :hearts, :pip 3} {:suit :diamonds, :pip 3}))

(three-of-a-kind hand)

(four-of-a-kind hand)










