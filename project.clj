(defproject soteria "0.0.1-SNAPSHOT"
  :description "Authentication module for Arachane based projects"
  :url "https://github.com/big-bad-wolf/soteria"
  :license      {:name "MIT"}
  :dependencies [
                 [org.clojure/clojure "1.9.0-alpha12" :scope "provided"]
                 [org.arachne-framework/arachne-core "0.1.0-master-0057-ad6d720"]]

  ;; Use Arachne's development builds
  :repositories [["arachne-dev" "http://maven.arachne-framework.org/artifactory/arachne-dev"]]

  :profiles {:dev
             {:dependencies
              [
               ;; Include both DataScript and Datomic so we can test against both; we
               ;; don't know which our users will choose!
               [datascript "0.15.2" :scope "test"]
               [com.datomic/datomic-free "0.9.5350"
                :exclusions [org.slf4j/slf4j-log4j12
                             org.slf4j/slf4j-nop
                             org.slf4j/slf4j-api
                             org.slf4j/log4j-over-slf4j]
                :scope "test"]

               ;; Logging stuff for development
               [ch.qos.logback/logback-classic "1.1.3" :scope "test"]
               [org.slf4j/jul-to-slf4j "1.7.12"
                :exclusions [org.slf4j/slf4j-api]
                :scope "test"]
               [org.slf4j/jcl-over-slf4j "1.7.12" :scope "test"]
               [org.slf4j/log4j-over-slf4j "1.7.12" :scope "test"]
               [clj-http "2.2.0" :scope "test"]]}})
