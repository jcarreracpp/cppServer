/***********************************************************
	File: Carrera_VendingMachine.java
	Author: Jorge Luis Carrera
	Class: CS 140 - Introduction to Computer Science

	Assignment: Lab 2
	Date Last Modified: 4/30/2014

	Purpose: This program asks the user to input a 
number between 25 and 100, then gives proper change out of
a dollar from the given number.
***********************************************************/
import java.util.Scanner;

public class Carrera_VendingMachine
{
	/* This method asks the user to input a number between 25 and 100, 
then gives proper change out of a dollar from the given number. */

	public static void main(String[] args)
	{
		int price, quarter, dime, nickel;
		
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter price of the item");
		System.out.print("(must be between 25 cents to a dollar," +
" in 5-cent increments): ");
		price = keyboard.nextInt();
		System.out.print("\n\n");

		if (price >= 25 && price <= 100 && price % 5 == 0)
		{
			quarter = ((100 - price) / 25);
			dime = (((100 - price) - (quarter * 25)) / 10);
			nickel = ((((100 - price) - (quarter * 25)) - (dime * 10)) / 5);
			
			System.out.print("You bought an item for " + price + " cent(s) and gave me a" 
+ " dollar,\nSo your change is:\n\n" + quarter + " quarter(s),\n" + dime + " dime(s), and\n" + nickel 
+ " nickel(s).\n");
		}else
		System.out.print("That was not within the given parameters!\n");
	}
}
