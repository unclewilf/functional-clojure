(ns week2.poker_test
  (:require [clojure.test :refer :all]
            [week2.poker :refer :all]))


(def duff '({:suit :diamonds, :pip 2}{:suit :clubs, :pip 2}{:suit :diamonds, :pip 3}{:suit :hearts, :pip 2}{:suit :spades, :pip 2}))

(def rflush '({:suit :clubs, :pip 14}{:suit :clubs, :pip 12}{:suit :clubs, :pip 11}{:suit :clubs, :pip 13}{:suit :clubs, :pip 10}))
(deftest royal-flush?
  (testing "Should be a royal-flush"
    (is (=
         (royal-flush rflush)
         {:royal-flush rflush}))))

(def sflush '({:suit :clubs, :pip 3}{:suit :clubs, :pip 4}{:suit :clubs, :pip 6}{:suit :clubs, :pip 9}{:suit :clubs, :pip 12}))
(defn straight-flush?
  (testing "Should be straight-flush"
    (is (=
         (straight-flush sflush)
         {:straight-flush sflush}))))

(def foak '({:suit :clubs, :pip 3}{:suit :diamonds, :pip 3}{:suit :hearts, :pip 3}{:suit :spades, :pip 3}{:suit :clubs, :pip 12}))
(defn four-of-a-kind
  (testing "FIXME, I fail."
    (is (=
         (four-of-a-kind foak)
         {:four-of-a-kind foak}))))

;(defn full-house
;  (testing "FIXME, I fail."
;    (is (=
;         (royal-flush rflush)
;         {:royal-flush royal-flush}))))

;(defn a-flush
;  (testing "FIXME, I fail."
;    (is (=
;         (royal-flush rflush)
;         {:royal-flush royal-flush}))))

;(defn straight
;  (testing "FIXME, I fail."
;    (is (=
;         (royal-flush rflush)
;         {:royal-flush royal-flush}))))

;(defn three-of-a-kind
;  (testing "FIXME, I fail."
;    (is (= `
;         (royal-flush rflush)
;         {:royal-flush royal-flush}))))

;(defn two-pair
;  (testing "FIXME, I fail."
;    (is (=
;         (royal-flush rflush)
;         {:royal-flush royal-flush}))))

;(defn a-pair
;  (testing "FIXME, I fail."
;    (is (=
;         (royal-flush rflush)
;         {:royal-flush royal-flush}))))

;(defn high-card
;  (testing "FIXME, I fail."
;    (is (=
;         (royal-flush rflush)
;         {:royal-flush royal-flush}))))

(run-tests)

;(high-card '({:suit :diamonds, :pip 4}{:suit :clubs, :pip 10}{:suit :clubs, :pip 1}))

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
