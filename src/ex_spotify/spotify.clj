(ns ex-spotify.spotify
  (:require [clj-http.client :as http]
            [clojure.edn :as edn]
            [cheshire.core :refer [parse-string]]
            [clojure.pprint :refer [pprint]]))

(defn query-spotify
  "Run an arbitrary query agains Spotify's API."
  [query]
  (parse-string (:body (http/get "http://ws.spotify.com/search/1/track.json"
                                 {:query-params {:q query}}))
                true))

(def lovesongs (query-spotify "love songs"))

(keys lovesongs)

(:num_results (lovesongs :info))

(first (:tracks lovesongs))
(nth (:tracks lovesongs) 13)
((:tracks lovesongs) 14)
(second (:tracks lovesongs))
(count (take 5 (:tracks lovesongs)))

(map #(:name %) (:tracks lovesongs))

(map :name (:tracks lovesongs))


(defn summarise-track
  [track]
  (format "%s : %s"
  (:name track)
  (:length track)))


(map summarise-track (:tracks lovesongs))

(reduce str (map :name (:tracks lovesongs)))





(first (:tracks lovesongs))

(defn name-from-artists
  [artists]
  (map :name artists))

(defn artist-from-tracks
  [tracks]
  (map :artists tracks))

(defn unique-artists
  [names]
  (distinct (flatten names)))

(defn to-comma-separated-string
  [artists]
  (apply str (interpose ", " artists)))


(to-comma-separated-string (unique-artists (map name-from-artists (artist-from-tracks (:tracks lovesongs)))))










































































