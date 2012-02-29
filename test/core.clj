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
  (println (client/put rc "clj-riak-test1-bucket" "clj-riak-test1-key" {:value (.getBytes "clj-riak-test1-value")}))
  (println (client/get rc "clj-riak-test1-bucket" "clj-riak-test1-key"))
)
