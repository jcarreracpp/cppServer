/*******************************************************************************
	File: PrimeChecker.java
	Author: Jorge Luis Carrera
	Class: CS 140 - Introduction to Computer Science

	Assignment: Lab 3
	Date Last Modified: 5/29/2014

	Purpose: This program asks the user for an integer, passes the 
number to a prime-checking method, then decides whether the number was a 
prime number. The result is output for the user to see.
*******************************************************************************/
import java.util.Scanner;

public class PrimeChecker
{
	/*This method asks the user for an integer, then passes it to the 
method, isPrime().*/

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.print("Enter an integer: ");
		int y = input.nextInt();

		if(isPrime(y)==true)
		{
			System.out.print("\nThat was not a prime " +
"number!\n");
		}
		else
			System.out.print("\nThat was a prime number!\n");
	}


	/*This method recieves an integer from main(), and begins dividing 
the number by 2, incrementing the divisor all the way to half of the 
integer's value. If it divides evenly to any denominator, it is not a prime 
number. The result is returned to main.*/

	public static boolean isPrime(int x)
	{
		int test = 2;
		boolean result = false;
		while(test <= x/2)
		{
			if (x%test==0)
			{
				result = true;
			}
			test++;
		}

		return result;
	}
}
