/**************************************************************************
	File: Carrera_Program2b.java
	Author: Jorge Luis Carrera
	Class: CS 140 - Introduction to Computer Science

	Assignment: Program 2b
	Date Last Modified: 4/21/2014

	Purpose: This program asks the user to input a value for kilograms, 
then converts the weight to pounds, then prints the appropriate weight in 
tons, pounds, and ounces respectively.
**************************************************************************/

import java.util.Scanner;

public class Carrera_Program2b
{
	/* This method takes a number of kilograms from the user, then 
converts it into the appropriate weight in tons, pounds, and ounces.*/

	public static void main(String[] args)
	{
		double originalKilo, kilo, ton, pound, ounce;

		//This portion asks for a value of kilograms
		System.out.print("Enter kilograms: ");
		Scanner keyboard = new Scanner(System.in);
		kilo = keyboard.nextDouble();

		/* This part allows the kilo variable to be used,
		and passed around while having the original value saved for later */
		originalKilo = kilo;
		System.out.println();
		System.out.println();

		/* This block converts kilograms to pounds, then divides 
		down to tons, pounds, then finally ounces. */
		kilo *= 2.2;
		ton = Math.round((kilo/2000)*10)/10;
		kilo %= 2000;
		pound = Math.round(kilo*10)/10;
		kilo %= 1;
		ounce = Math.round((kilo*16)*10)/10;

		//This part prints out the inputted value and the resulting values.
		System.out.print(originalKilo + " kilogram(s) converts " + 
"to: " + ton +
" ton(s), " + pound + " pound(s), and " + ounce + " ounce(s).");
		
		
	}
}
