(defproject domina "1.0.0-SNAPSHOT"
  :description "A DOM manipulation library for ClojureScript inspired by JQuery"
  :source-path "src/clj"
  :dependencies [[org.clojure/clojurescript "0.0-1011"]
                 [org.clojure/clojure "1.3.0"]]
  :plugins [[lein-cljsbuild "0.1.7"]]
  :dev-dependencies [[lein-clojars "0.6.0"]]
  :hooks [leiningen.cljsbuild]
  :cljsbuild {:builds [{:source-path "src/cljs"
                        :jar true
                        :compiler {:libs ["goog/dom/query.js"]
                                   :pretty-print true
                                   :output-dir ".cljsbuild/domina"
                                   :output-to "public/domina.js"}}
                       {:source-path "test/cljs"
                        :compiler  {:libs ["goog/dom/query.js"]
                                    :pretty-print true
                                    :output-dir "public/build_no_opt"
                                    :output-to "public/test_no_opt.js"}}
                       {:source-path "test/cljs"
                        :compiler  {:libs ["goog/dom/query.js"]
                                    :optimizations :whitespace
                                    :pretty-print true
                                    :output-dir ".cljsbuild/whitespace"
                                    :output-to "public/test_whitespace.js"}}
                       {:source-path "test/cljs"
                        :compiler  {:libs ["goog/dom/query.js"]
                                    :optimizations :simple
                                    :pretty-print true
                                    :output-dir ".cljsbuild/simple"
                                    :output-to "public/test_simple.js"}}
                       {:source-path "test/cljs"
                        :compiler  {:libs ["goog/dom/query.js"]
                                    :optimizations :advanced
                                    :pretty-print true
                                    :output-dir ".cljsbuild/advanced"
                                    :output-to "public/test_advanced.js"}}]})

(comment
  (do
    (require '[cljs.repl :as repl])
    (require '[cljs.repl.browser :as browser])
    (def env (browser/repl-env))
    (repl/repl env))

  )
