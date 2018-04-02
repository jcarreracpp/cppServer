/***************************************************
	File: Painting.java
	Author: Miranda Ortiz & Jorge Luis Carrera
	Class: CS 140 - Introduction to Computer Science

	Assignment: In class assignment
	Date Last Modified: 5/25/2014

	Purpose: User enters number of rooms to be painted, the price
of the paint per gallon, and the square feet of wall space in each
room, then displays the data on screen.
***************************************************/

import java.util.Scanner;

public class Painting
{
	/* User enters number of rooms to be painted, the price of the paint per gallon,
and the square feet of wall space in each room, then displays the data on screen.*/

	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);

		int roomspace, originalRooms;
		double pricePerGal, wallSpace = 0;

		System.out.print("Number of rooms? ");
		roomspace = keyboard.nextInt();
		originalRooms = roomspace;
		System.out.print("\nPrice of paint per gallon? ");
		pricePerGal = keyboard.nextDouble();

		while (roomspace > 0)
		{
			System.out.print("\nSquare feet of wall space in one " + 
"room? ");
			wallSpace += keyboard.nextDouble();
			--roomspace;
		}

		System.out.printf("\n%.2f gallons required for this job.", gallonsNeeded(wallSpace));
		System.out.printf("\n%.2f hours of labor required.", laborHrsNeeded(wallSpace));
		System.out.printf("\n$%.2f will be the total cost of paint.", paintCost(pricePerGal, wallSpace));
		System.out.printf("\n$%.2f will be the total cost of labor.", laborCost(wallSpace));
		System.out.printf("\n$%.2f will be the total cost of the painting project.\n", totalCost(pricePerGal, wallSpace));
	}


	public static double gallonsNeeded(double squareFeet)
	{
		return squareFeet/115;
	}


	public static double laborHrsNeeded(double spaceLabor)
	{
		return (gallonsNeeded(spaceLabor)*8);
	}


	public static double paintCost(double paintPrice, double spacePaint)
	{
		return (gallonsNeeded(spacePaint)*paintPrice);
	}


	public static double laborCost(double spaceLabor)
	{
		return ((gallonsNeeded(spaceLabor)*8)*18);
	}


	public static double totalCost(double paintPrice, double spacePaint)
	{
		return ((gallonsNeeded(spacePaint)*paintPrice)+((gallonsNeeded(spacePaint)*8)*18));
	}
}
