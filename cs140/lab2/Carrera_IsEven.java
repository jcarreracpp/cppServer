/*********************************************************
	File: Carrera_IsEven.java
	Author: Jorge Luis Carrera
	Class: CS 140 - Introduction to Computer Science

	Assignment: Lab 2
	Date Last Modified: 4/30/2014

	Purpose: This program asks the user to input an
integer and determines whether it is even or odd.
*********************************************************/
import java.util.Scanner;

public class Carrera_IsEven
{
	/* This method asks the user to input an integer and determines
whether it is even or odd. */

	public static void main(String[] args)
	{
		boolean evenOdd = false;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter an integer from 0-10: ");
		int n = keyboard.nextInt();
		System.out.println();
		
		if (n % 2 == 0)
			evenOdd = true;

		System.out.println("Is that number even? " + evenOdd);
	}
}
