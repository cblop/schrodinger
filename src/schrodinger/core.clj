(ns schrodinger.core
  (:require [schrodinger.macros]
            [clojure.core.logic]))

;; connectors as data structures, rules as functions
;; strategies as functions too

(defn add-to-node
  "Adds formulas fs to node w"
  [w fs]
  (assoc w :contents (concat (:contents w) fs)))

(defn land [x y]
  (let [w (this-node)]
    (add-to-node w [x y])))

(defn build-model
  "Takes an input formula and attempts to build a Kripke model"
  [f]
  )

(def sausages
  '(land
    (land (nom :s0) (interdiction "Joey" "Punch" "Sausages"))
    (pos "A" (land (absentation "Joey") (nom :s1)))))

(def land
  {:arity 2
   :display (infix "^")
   :action (fn [w p q]
             (if (has-element? w p q)
               (add w p)))})

;; what if each connector were a macro?

(def graph
  [
   {:id :s0
    :contents [[:nom :s0] [:interdiction "Joey" "Punch" "Sausages"]]
    :links [["A" :s1]]}])



