bill(X,TP,TC) :-
	X =< 0 ->
	TP is 0,
	TC is 0;
	X > 0, X < 20 ->
	TP is X * 0.1,
	TC is X + TP;
	X >= 20 ->
	TP is X * 0.15,
	TC is X + TP.

male(john).
male(sam).
female(mary).
female(alice).
female(jody).
parent(john,alice).
parent(john,jody).
parent(sam,mary).
parent(alice,mary).

is_father(X) :-
	parent(X,Y),
	male(X).
is_aunt(X,Y) :-
	parent(Z,X),
	parent(Z,W),
	parent(W,Y),
	female(X).
is_grandparent(X) :-
	parent(X,Y) ->
	parent(Y,Z).

square([],[]) :- !.

square([H|T1],[B|T2]) :-
	B =:= H * H ->
	square(T1,T2);
	B is H * H,
	square(T1,T2).
