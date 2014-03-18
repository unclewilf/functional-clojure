(ns week2.poker_test
  (:require [clojure.test :refer :all]
            [week2.poker :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))

;(high-card '({:suit :diamonds, :pip 4}{:suit :clubs, :pip 10}{:suit :clubs, :pip 1}))

(deal deck)


;(def x (shuffle deck))

;hnd1 (take 5 deck)
;        hnd2 (take 5 (nthrest deck 5)

;tests

;(count deck)

;(frequencies (map :suit deck))


;(map :pip hand)

;(map :suit hand)


;(full-house '({:suit :diamonds, :pip 3} {:suit :diamonds, :pip 3} {:suit :diamonds, :pip 3} {:suit :diamonds, :pip 3} {:suit :diamonds, :pip 3}))

;(full-house '({:suit :heart, :pip 3} {:suit :heart, :pip 3} {:suit :diamonds, :pip 3} {:suit :diamonds, :pip 2} {:suit :diamonds, :pip 2}))

;(full-house '({:suit :diamonds, :pip 3} {:suit :diamonds, :pip 3} {:suit :diamonds, :pip 3} {:suit :diamonds, :pip 3} {:suit :diamonds, :pip 3}))


;(two-of-a-kind '({:suit :hearts, :pip 3} {:suit :diamonds, :pip 3}))

;(three-of-a-kind hand)

;(four-of-a-kind hand)
