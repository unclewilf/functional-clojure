(ns week2.poker_test
  (:require [clojure.test :refer :all]
            [week2.poker :refer :all]
            [week2.test-hands :refer :all]))

(deftest pair-test
  (testing "A matching hand returns true"
    (is (= (pair? pair-hand) true)))
  (testing "An invalid hand returns false"
    (is (= (pair? duff-hand) false))))

(deftest high-card-test
  (testing "High card should be 7"
    (is (=
          (high-card duff-hand)
          {:high-card 7}))))

;(deftest should-be-valid-royal-flush
;  (testing "Should be a royal-flush"
;    (is (=
;          (royal-flush? rflush-hand)
;          {:royal-flush}))))
;
;(defn should-be-valid-straight-flush?
;  (testing "Should be straight-flush"
;    (is (=
;          (straight-flush? sflush-hand)
;          {:straight-flush sflush-hand}))))
;
;(defn four-of-a-kind
;  (testing "FIXME, I fail."
;    (is (=
;          (four-of-a-kind foak)
;          {:four-of-a-kind foak}))))

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


;(defn valid-two-pair
;  (testing "A valid two pair should return true"
;    (is (=
;         true
;         true))))




