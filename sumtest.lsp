(defun sum (b)
	(if b (+ (car b) (sum (cdr b)) ) 0
	)
)

(write (sum (list 1 2 3 4 5 6 7 8 9 10)))

