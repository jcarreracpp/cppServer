(defun quadraticEq (a b c)
	(cond ((> a 0)
	(list (/ (+ (- b) (sqrt (- (* b b) (* 4 a c) ))) (* 2 a) )   (/ (- (- b) (sqrt 
(- (* b b) (* 4 a c) )) ) (* 2 
a) )   ))(t (string "Cannot divide by zero!"))
))

(write (quadraticEq 2 -1 -1))
(write-line "")
(write (quadraticEq 1 4 4))
(write-line "")
(write (quadraticEq 3 11 0))
(write-line "")
(write (quadraticEq 4 0 8))
(write-line "")
(write (quadraticEq 0 4 4))
(write-line "")

#|
(1 -1/2)
(-2 -2)
(0 -11/3)
(#C(0 1.4142135) #C(0 -1.4142135))
"Cannot divide by zero!"
|#
