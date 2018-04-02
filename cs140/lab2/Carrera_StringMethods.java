/***************************************************************
	File: Carrera_StringMethods.java
	Author: Jorge Luis Carrera
	Class: CS 140 - Introduction to Computer Science

	Assignment: Lab 2
	Date Last Modified: 4/30/2014

	Purpose: This program asks the user to input their whole
name, age, lucky number, along with their favorite color, then
reprints the inputted items in different forms through-out a
story.
***************************************************************/
import java.util.Scanner;

public class Carrera_StringMethods
{
	/* This method asks the user to input their whole name, age, lucky
number, along with their favorite color, then reprints the inputted items
in different forms through-out a story. */

	public static void main(String[] args)
	{
		int age, luckyNum;

		Scanner input = new Scanner(System.in);

		System.out.println("Please enter your first name:");
		String firstName = input.nextLine();
		System.out.println();
		System.out.println("Please enter your middle name:");
		String middleName = input.nextLine();
		System.out.println();
		System.out.println("Please enter your last name:");
		String lastName = input.nextLine();
		System.out.println();
		System.out.println("Please enter your age:");
		age = input.nextInt();
		System.out.println();
		System.out.println("Please enter your lucky number:");
		luckyNum = input.nextInt();
		input.nextLine();
		System.out.println();
		System.out.println("Please enter your favorite color:");
		String favColor = input.nextLine();
		System.out.println("\n");

		System.out.println("A story about " + 
firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase() + " " + middleName.substring(0, 1).toUpperCase() + 
middleName.substring(1).toLowerCase() + " " + lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase() + ":\n");

		System.out.println(firstName.toUpperCase() + " " + middleName.toUpperCase() + " " + lastName.toUpperCase() + " is " + 
firstName.substring(0, 1).toUpperCase() + middleName.substring(0, 1).toUpperCase() + lastName.substring(0, 1).toUpperCase() + ".\n");

		System.out.println(firstName.substring(0, 1).toUpperCase() + middleName.substring(0, 1).toUpperCase() + lastName.substring(0, 1).toUpperCase() + 
"'s favorite color is " + favColor.toLowerCase() + ", and " + firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase() + " " +
lastName.substring(0, 1).toUpperCase() + ". is " + age + ".\n");

		System.out.println("The lucky number of " + firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase() + " " + 
middleName.substring(0, 1).toUpperCase() + ". " + lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase() + " is " + luckyNum + ".");
	}
}
