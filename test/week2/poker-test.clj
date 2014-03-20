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

(deftest full-house-test
  (testing "Valid full-house returns true"
    (is (true? (full-house? full-hand))))
  (testing "Invalid full-house should return false"
    (is (false? (full-house? duff-hand)))))

(deftest straight-flush-test
  (testing "Valid straight flush returns true"
    (is (true? (straight-flush? sflush-hand))))
  (testing "Invalid straight flush should return false"
    (is (false? (straight-flush? duff-hand)))))

(deftest royal-flush-test
  (testing "Valid royal flush returns true"
    (is (true? (royal-flush? rflush-hand))))
  (testing "Invalid royal flush should return false"
    (is (false? (royal-flush? duff-hand)))))



