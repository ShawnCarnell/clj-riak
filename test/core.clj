(ns core
  (:use [core])
  (:use [clojure.test])
  (:refer-clojure :exclude (get))
  (:require [clojure.data.json :as json]))

(require '[clj-riak.client :as client])

(deftest init 
  (def rc (client/init {:host "webviddev-m01.ehost.aol.com" :port 8087})) 
	(client/ping rc)
  (println (client/get-server-info rc))
  (println (client/list-buckets rc))
)
