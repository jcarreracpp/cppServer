bmi(WeightInPounds, HeightInInches, SomeVariable) :-
	HeightInInches =:= 0 ->
	SomeVariable is 0 * 703;
	SquaredHeight is HeightInInches ** 2,
	Doink is WeightInPounds / SquaredHeight,
	SomeVariable is Doink * 703.

pair(A, B, X, Y) :-
	A >= B ->
	X is A - B,
	Y is A * B;
	X is A + B,
	Y is A / B.

has(jack,apples).
has(ann,plums).
has(dan,money).
fruit(apples).
fruit(plums).

happy(bill).
happy(mary).
happy(john).
happy(alex).
sad(bill).
likes(john,corvettes).
likes(john,wine).
likes(john,book).
likes(mary,book).
likes(mary,corvettes).
likes(alex,corvettes).

smart(X) :- likes(X,book).
valuable(X) :- likes(mary,X).

/**
*
*
**/
