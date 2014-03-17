(ns week2.ns
  (:require [quil.core :as quil :refer :all]))

(defn setup []
  (smooth)
  (frame-rate 3)
  (background 200))

(defn draw []
  (fill (random 255))
  (ellipse (random (quil/width))
           (random (quil/height))
           (random 100)
           (random 100)))

(defsketch example
  :title "Ellipses are great"
  :setup setup
  :draw draw
  :size [400 400])

(defn five [] 5)

(+ (five) 5)
