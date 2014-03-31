(ns week4.single-macro)

(defmacro refuse-func [code]
  (if (list? code)
    "bad code here!"
    code))