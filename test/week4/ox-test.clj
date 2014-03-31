(ns week4.ox-test
  (:require [clojure.test :refer :all]
            [week4.ox :refer :all]))

(deftest winner-is-found
  (testing "Winner first col hand"
    (is (winner? [[:X :_ :_]
                  [:X :_ :_]
                  [:X :_ :_]]))))

(deftest winner-is-found
  (testing "Winner third col hand"
    (is (winner? [[:_ :_ :X]
                  [:_ :_ :X]
                  [:_ :_ :X]]))))