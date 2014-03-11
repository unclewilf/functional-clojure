(ns ex-spotify.spotify
  (:require [clj-http.client :as http]
            [clojure.edn :as edn]
            [cheshire.core :refer [parse-string]]
            [clojure.pprint :refer [pprint]]))

(defn get-rq
  [url & body]
  (if (empty? body)
    (parse-string (:body (http/get url {})) true)
    (parse-string (:body (http/get url body)) true)))

(defn query-user
  "Run an arbitrary query agains Spotify's API."
  [username]
  (get-rq (str "https://api.github.com/users/" username)))

(def myhub (query-user "unclewilf"))

(keys myhub)
(vals myhub)


