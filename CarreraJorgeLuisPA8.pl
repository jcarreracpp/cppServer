power(X,N,V) :- X=:=0,N>0,V is 0, !.
power(X,N,V) :- X>0,N =:= 0, V is 1, !.
power(X,N,V) :- X =:= 0, N =:= 0, V = undefined, !.
power(X,N,V) :- V is X ** N.

power2(X, N, V) :-
	X =:= 0, N > 0 ->
	V is 0;
	X > 0, N =:= 0 ->
	V is 1;
	X =:= 0, N =:= 0 ->
	V = undefined;
	V is X**N.

randseq(0,[]).
randseq(X,L) :-
	X > 0,
	random(1,100,Lh),
	Xn is X - 1,
	L = [Lh|Lt],
	randseq(Xn,Lt).



