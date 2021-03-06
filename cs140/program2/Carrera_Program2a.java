/**********************************************************************
	File: Carrera_Program2a.java
	Author: Jorge Luis Carrera
	Class: CS 140 - Introduction to Computer Science

	Assignment: Program 2a
	Date Last Modified: 4/21/2014
	
	Purpose: This program asks the user to input integer values for 
tons, pounds, and ounces, then prints out the total weight in kilograms, 
rounded to the tenths place.
***********************************************************************/



import java.util.Scanner;

public class Carrera_Program2a
{
	/* This method asks the user for input in the form of tons, pounds, 
	 and ounces. It outputs the weight in the form of kilograms. */

	public static void main(String[] args)
	{
		int ton, pound, ounce;


		//This portion asks for the user to input several weights
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter tons: ");
		ton = keyboard.nextInt();
		System.out.print("\n");
		System.out.print("Enter pounds: ");
		pound = keyboard.nextInt();
		System.out.print("\n");
		System.out.print("Enter ounces: ");
		ounce = keyboard.nextInt();
		System.out.print("\n");

		//This portion totals up the weight from the values inputted
		int totalPound = (ton * 2000) + pound + (ounce / 16);

		//This portion converts the pounds to kilograms
		double kilo = (totalPound / 2.2);

		//This portion rounds the kilograms to the tenth place
		kilo = Math.round(kilo * 10)/10.0;

		//This last part displays the values inputted and the resulting value
		System.out.printf(ton + " ton(s), " + pound + " pound(s), "
 + "and " + ounce + " ounce(s) converts to " + kilo + " kilogram(s).");
	}
}
