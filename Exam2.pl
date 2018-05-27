/**
*Problem 1.
**/
spec(comp1, pc, 32).
spec(comp2, mac, 128).
spec(comp3, pc, 64).
runs(pc, movie_edit, 96).
runs(pc, vb, 16).
runs(pc, cpp, 28).
runs(mac, vb, 24).
runs(mac, prolog, 128).
access(judy, comp1).
access(peter, comp3).
access(david, comp1).
access(david, comp2).

can_use(P, SW) :-
	access(P, W),
	spec(W, Y, R),
	runs(Y, SW, X),
	R >= X.
/**
*?- can_use(david, prolog).
*true.
*
*?- can_use(judy, X).
*X = vb ;
*X = cpp.
*
*?- can_use(X, movie_edit).
*false.
**/

/**
*Problem 3.
**/
getGrade(NUM, G) :- NUM < 0, !, G = "I".
getGrade(NUM, G) :- NUM > 100, !, G = "I".
getGrade(NUM, G) :- NUM >= 0 ,NUM =< 60,!, G = "F", !.
getGrade(NUM, G) :- NUM > 60 ,NUM =< 80,!, G = "G", !.
getGrade(NUM, G) :- NUM > 80 ,NUM =< 100,!, G = "E".

/**
*?- getGrade(30, G).
*G = "F".
*
*?- getGrade(-6, G).
*G = "I".
*
*?- getGrade(104, G).
*G = "I".
*
*?- getGrade(90, G).
*G = "E".
**/


/**
*Problem 2.
**/
flatten([],[]) :- !.
flatten([L|Lt], Flatten) :-
	!,
	flatten(L, NL),
	flatten(Lt, NLt),
	append(NL, NLt, Flatten).
flatten(L, [L]).

/**
*?- flatten([a,[b,[c,d],e]],X).
*X = [a, b, c, d, e].
**/

/**
*Problem 4
**/
gen(0, []).
gen(X, L) :-
	X > 0,
	mod(X,2) =:= 0,
	random(1, 10, Lh),
	Lr is Lh * 2,
	Xn is X - 1,
	L = [Lr|Lt],
	gen(Xn, Lt).

gen(X, L) :-
	X > 0,
	mod(X,2) =\= 0,
	random(1, 10, Lh),
	Lr is Lh * 2,
	Ls is Lr - 1,
	Xn is X -1,
	L = [Ls|Lt],
	gen(Xn, Lt).	

gen2(0, []).

gen2(X, L) :-
	R is 0,
	X >= R,
	gen2(X, L, R).

gen2(X, L, R) :-
	Rr is R + 1,
	X >= Rr,
	Rs is Rr^3,
	L = [Rs|Lt],
	gen2(X, Lt, Rr).

/**
*?- gen(10, L).
*L = [2, 9, 10, 15, 10, 15, 14, 7, 12, 15].
*
*?- gen(7, L).
*L = [1, 10, 9, 6, 1, 16, 5].
**/

/**
*Problem 5.
**/
samefreq(L1, L2, C) :-
	count(L1,C,N),
	count(L2,C,M),
	!,
	N =:= M.

count([],_,0).

count([C|Lt], C, Cc) :-
	!,
	count(Lt, C, Cn),
	Cc is Cn + 1.

count([_|Lt], C, Cc) :-
	count(Lt, C, Cc).
/**
*?- samefreq([a,a,a,a,b,c,c,a,a,d,e,e,e,e],[b,b,a,c,a,a,a,d,a,a,e,e],a).
*true.
*
*?- samefreq([a,a,a,a,b,c,c,a,a,d,e,e,e,e],[b,b,a,c,a,a,a,d,a,a,e,e],b).
*false.
*
*?- samefreq([],[],c).
*true.
**/
