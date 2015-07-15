(ns schrodinger.macros)

(defmacro defcon
  "Defines a logical connector"
  [{:keys [arity display conditions actions]}])

