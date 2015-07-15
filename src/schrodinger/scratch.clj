(ns schrodinger.scratch)


(build-model sausages)
;; -->

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
