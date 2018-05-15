power(X,N,V) :- X=:=0,N>0,V is 0, !.
power(X,N,V) :- X>0,N =:= 0, V is 1, !.
power(X,N,V) :- X =:= 0, N =:= 0, V = undefined, !.
power(X,N,V) :- V is X ** N.
