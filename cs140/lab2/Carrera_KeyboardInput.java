/*************************************************************
	File: Carrera_KeyboardInput.java
	Author: Jorge Luis Carrera
	Class: CS 140 - Introduction to Computer Science

	Assignment: Lab 2
	Date Last Modified: 4/30/2014

	Purpose: This program asks the user for name, age,
and company name, then prints a message.
*************************************************************/
import java.util.Scanner;

public class Carrera_KeyboardInput
{
	/* This method asks the user for name, age, and company name, then
prints a message. */

	public static void main(String[] args)
	{
		int age;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Name: ");
		String name = keyboard.nextLine();
		System.out.println();

		System.out.print("Age: ");
		age = keyboard.nextInt();
		keyboard.nextLine();
		System.out.println();

		System.out.print("Company name: ");
		String companyName = keyboard.nextLine();
		System.out.println();

		System.out.print("My name is " + name + ", my age is " + age +
" and\n" + "I hope to work for " + companyName + ".");
		System.out.println();
	}
}
