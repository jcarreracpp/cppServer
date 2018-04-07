(defun randList (x y)
	(setf result (list))	
	(do ((i 0 (+ i 1))) ((> i 19) result)
		(setf result (cons (+ (random (- y x)) x) result))
	 )
result)

(write (randList 0 100))
(print (randList 10.0 80.0))

(setf hoopla (string ""))
(defun writepoly (xlist)	
	(when xlist
	    (setf hoopla (concatenate 'string hoopla (write-to-string (car (car xlist))) "x^" (write-to-string (cdr (car xlist))) " "))
	    (writepoly (cdr xlist)))
hoopla)

(print (writepoly (list '())))
(setf hoopla (string ""))
(print (writepoly (list (list 2 1) (list 1 0))))
(setf hoopla (string ""))
(print (writepoly (list (list 3 2) (list -1 0))))
(setf hoopla (string""))
(print (writepoly (list (list 5 2) (list -4 1) (list 1 0))))
(setf hoopla (string ""))
(print (writepoly (list (list 7 14) (list 11 13) (list -3 2) (list 7 1) (list -5 0))))
(setf hoopla (string ""))
(print (writepoly (list (list 1 0) (list 2 1) (list -5 3) (list -3 1) (list 7 0))))


;(93 64 41 44 94 73 76 64 74 97 75 35 34 42 85 7 4 16 75 75)
;(15.752285 66.374725 65.670235 15.26083 48.89414 46.532707 54.639687 72.71749 15.622504 67.49423 79.415955 24.913918 23.638062 42.264236 56.54168 50.233486 15.352163 12.430839 50.290726 27.54358)
;"NILx^NIL "
;"2x^(1) 1x^(0) "
;"3x^(2) -1x^(0) "
;"5x^(2) -4x^(1) 1x^(0) "
;"7x^(14) 11x^(13) -3x^(2) 7x^(1) -5x^(0) "
;"1x^(0) 2x^(1) -5x^(3) -3x^(1) 7x^(0) "

