inc([],[]) :- !.
inc([X|X1],[Y|Y1]) :- 
	X+1 =:= Y,
	inc(X1,Y1).


sode([],[]).
sode([E|T], T1) :-
	E mod 2 =:= 0,
	sode(T, T1).
sode([H|T1],[B|T2]) :-
	H mod 2 =\= 0,
	B is H * H,
	sode(T1,T2).

/**
*
**/
