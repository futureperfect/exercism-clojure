(ns bob
  (:use [clojure.string :only [upper-case ends-with?]]))

(def replies
  {:question "Sure.",
   :yell     "Whoa, chill out!",
   :empty    "Fine. Be that way!",
   :default  "Whatever."})

(defn- yelling? [statement]
  (and (= (upper-case statement) statement)
         (re-find #"[A-Z][A-Z]+" statement)))

(defn- question? [statement]
  (ends-with? statement "?"))

(defn- empty? [statement]
  (re-matches #"^\s*$" statement))

(defn response-for [statement]
  (cond
    (yelling? statement) (replies :yell)
    (question? statement) (replies :question)
    (empty? statement) (replies :empty)
    :else (replies :default)))
