(ns schrodinger.core
  (:require [schrodinger.macros]
            [clojure.core.logic]
            [clojure.core.match :refer [match]]
            [clojure.walk :as w]))

;; connectors as data structures, rules as functions
;; strategies as functions too

(def data
  [:and
   [:and [:nom :A] :X]
   [:pos :R [:and [:nom :B] :Y]]])

(defn rewrite [node]
  (letfn [(mand [xs res]
            (if (or (keyword? xs) (empty? xs)) res
                (match xs
                       [:and a b] (set (mapcat #(mand % (conj res a b)) (rest xs)))
                       [_ & _] (set (mapcat #(mand % res) (rest xs)))
                       :else res))
            )]
    (mand node [])))


(rewrite data)


(def sausages
  [:and
   [:and [:nom :s0] [:interdiction "Joey" "Punch" "Sausages"]]
   [:pos :A [:and [:absentation "Joey"] [:nom :s1]]]])






