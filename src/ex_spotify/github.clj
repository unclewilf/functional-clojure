(ns ex-spotify.spotify
  (:require [clj-http.client :as http]
            [clojure.edn :as edn]
            [cheshire.core :refer [parse-string]]
            [clojure.pprint :refer [pprint]]))

(def github-uri "https://api.github.com")

(defn get-rq
  [url & body]
  (if (empty? body)
    (parse-string (:body (http/get url {})) true)
    (parse-string (:body (http/get url body)) true)))

(defn query-user
  "Run an arbitrary query agains Spotify's API."
  [username]
  (get-rq (str github-uri "/users/" username)))

(defn search-github
  "Run an arbitrary query agains Spotify's API."
  [query]
  (get-rq (str github-uri "/search/repositories?q=" query)))

;query my account
;(def myhub (query-user "unclewilf"))

(def clojure-search
  (search-github "clojure"))

(keys clojure-search)
(vals clojure-search)

(def found-items
  (:items clojure-search))

(count found-items)

(def order-by-watchers
  (map :html_url
       (sort (fn[x y] (> (:watchers_count x)(:watchers_count y))) found-items)))

(map :html_url
     (sort (fn[x y] (> (:watchers_count x)(:watchers_count y))) found-items))



(defn urls-and-descriptions
  [items]
  (map (fn[item] (hash-map :desc (:description item) :url (:html_url item)))
       items))

(apply str
       (interpose ", "
                  (map :desc (urls-and-descriptions found-items))))



"The top clojure projects"
(apply str
       (interpose ", " order-by-watchers))







































