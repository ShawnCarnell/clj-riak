# `clj-riak`

Clojure bindings to the [Riak](http://www.basho.com/Riak.html) [Protocol Buffers API](https://wiki.basho.com/display/RIAK/PBC+API).

## Differences in this fork

* Dependency updated to Clojure 1.3.0.
* Dependency updated to the official Basho client com.basho.riak/riak-client "1.0.2-SNAPSHOT"

I forked from org.clojars.ossareh/clj-riak "0.1.0-SNAPSHOT" which included support for links like so:

    ;; an example put fn
    (defn put [bucket key data]
      (let [links (or (:links (meta data)) '())
            data {:value (.getBytes (json/json-str data))
                  :content-type "application/json"
                  :links links}]

        (riak/put riak-client
                  bucket
                  key
                  data)))
        
    (put "test-bucket" "test-key"
         (with-meta {:a 1} {:links '({:bucket "foo"
                                      :key "bar"
                                      :tag "foobar"})}))

## Installation

`clj-riak` is available as a Maven artifact from [Clojars](http://clojars.org/clj-riak):

    :dependencies
      [[org.clojars.shawncarnell/clj-riak "0.1.0-SNAPSHOT"] ...]

## Usage

For an introduction to the library, see the blog post [Exploring Riak with Clojure](http://mmcgrana.github.com/2010/08/riak-clojure.html)

## License

Released under the MIT License: <http://www.opensource.org/licenses/mit-license.php>
