(ns schrodinger.core
  (:require [schrodinger.macros]
            [clojure.core.logic]))

;; connectors as data structures, rules as functions
;; strategies as functions too

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

(def sausages
  '(land
    (land (nom :s0) (interdiction "Joey" "Punch" "Sausages"))
    (pos "A" (land (absentation "Joey") (nom :s1)))))

(build-kripke sausages)

;; start
[
 {:id 0
  :contents ['(land (land (nom :s0) (interdiction "Joey" "Punch" "Sausages")) (pos "A" (land (absentation "Joey") (nom :s1))))]
  :links []}
 ]

;; and
[
 {:id 0
  :contents [
             '(land (land (nom :s0) (interdiction "Joey" "Punch" "Sausages")) (pos "A" (land (absentation "Joey") (nom :s1))))
             '(land (nom :s0) (interdiction "Joey" "Punch" "Sausages"))
             '(pos "A" (land (absentation "Joey") (nom :s1)))
             ]
  :links []}
 ]

;; pos
[
 {:id :0
  :contents [
             '(land (land (nom :s0) (interdiction "Joey" "Punch" "Sausages")) (pos "A" (land (absentation "Joey") (nom :s1))))
             '(land (nom :s0) (interdiction "Joey" "Punch" "Sausages"))
             '(pos "A" (land (absentation "Joey") (nom :s1)))
             ]
  :links [["A" :1]]}

 {:id :1
  :contents [
             '(land (nom :s1) (absentation "Joey"))
             ]
  :links []}
 ]

;; and
[
 {:id :0
  :contents [
             '(land (land (nom :s0) (interdiction "Joey" "Punch" "Sausages")) (pos "A" (land (absentation "Joey") (nom :s1))))
             '(land (nom :s0) (interdiction "Joey" "Punch" "Sausages"))
             '(pos "A" (land (absentation "Joey") (nom :s1)))
             ]
  :links [["A" :1]]}

 {:id :1
  :contents [
             '(land (nom :s1) (absentation "Joey"))
             '(nom :s1)
             '(absentation "Joey")
             ]
  :links []}
 ]

;; init
[
 {:id :0
  :contents [
             '(land (land (nom :s0) (interdiction "Joey" "Punch" "Sausages")) (pos "A" (land (absentation "Joey") (nom :s1))))
             '(land (nom :s0) (interdiction "Joey" "Punch" "Sausages"))
             '(pos "A" (land (absentation "Joey") (nom :s1)))
             ]
  :links [["A" :1] ["@S0" :0]]}

 {:id :1
  :contents [
             '(land (nom :s1) (absentation "Joey"))
             '(nom :s1)
             '(absentation "Joey")
             ]
  :links []}
 ]

;; id
[
 {:id :0
  :contents [
             '(land (land (nom :s0) (interdiction "Joey" "Punch" "Sausages")) (pos "A" (land (absentation "Joey") (nom :s1))))
             '(land (nom :s0) (interdiction "Joey" "Punch" "Sausages"))
             '(pos "A" (land (absentation "Joey") (nom :s1)))
             ]
  :links [["A" :1] ["@S0" :0] ["@S1"] :1]}

 {:id :1
  :contents [
             '(land (nom :s1) (absentation "Joey"))
             '(nom :s1)
             '(absentation "Joey")
             ]
  :links []}
 ]


