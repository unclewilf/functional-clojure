(ns week2.poker-test
  (:require [clojure.test :refer :all]
            [week2.poker :refer :all]
            [week2.dummy-hands :refer :all]))

(deftest pair-test
  (testing "A matching hand returns true"
    (is (true? (pair? pair-hand))))
  (testing "An invalid hand returns false"
    (is (false? (pair? duff-hand)))))

(deftest high-card-test
  (testing "High card should be 7"
    (is (=
          (high-card duff-hand)
          {:high-card 7}))))

(deftest three-of-a-kind-test
  (testing "A valid hand returns true"
    (is (true? (three-of-a-kind? three-hand))))
  (testing "Invalid hand returns false"
    (is (false? (three-of-a-kind? duff-hand)))))

(deftest four-of-a-kind-test
  (testing "A valid hand returns true"
    (is (true? (four-of-a-kind? four-hand))))
  (testing "Invalid hand returns false"
    (is (false? (four-of-a-kind? duff-hand)))))

(deftest two-pair-test
  (testing "A valid two pair should return true"
    (is (true? (two-pair? two-hand))))
  (testing "Invalid two pair should return false"
    (is (true? (two-pair? two-hand)))))

(deftest straight-test
  (testing "Valid sraight returns true"
    (is (true? (straight? straight-hand))))
  (testing "Invalid straign should return false"
    (is (false? (straight? duff-hand)))))

(deftest flush-test
  (testing "Valid flush returns true"
    (is (true? (flush? flush-hand))))
  (testing "Invalid flush should return false"
    (is (false? (flush? duff-hand)))))


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
;(defn full-house
;  (testing "FIXME, I fail."
;    (is (=
;         (royal-flush rflush)
;         {:royal-flush royal-flush}))))



