(defun sq(num) (* num num))
(defun op-some(C E L)
	(cond ((null L) nil)
		((funcall C (car L))
			(cons (funcall E (car L))(op-some C E (cdr L))))
			(t (cons (car L)(op-some C E (cdr L))))))
(write (op-some #'oddp #'sq nil))
(print (op-some #'oddp #'sq '(2)))
(print (op-some #'oddp #'sq '(3)))
(print (op-some #'oddp #'sq '(3 6 4 5 2)))

#|
NIL
(2)
(9)
(9 6 4 25 2)
|#
