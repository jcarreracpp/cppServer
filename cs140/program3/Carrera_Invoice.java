/**********************************************************************
	File: Carrera_Invoice.java
	Author: Jorge Luis Carrera
	Class: CS 140 - Introduction to Computer Science

	Assignment: Invoice
	Date Last Modified: 4/23/2014

	Purpose: This program prompts the user on whether they are a
member or not, prompts user for quality of gasoline, and asks for
amount of gasoline desired (in gallons). The program then takes the
input and using the entered information, determines the total cost of
gas, along with county tax, city tax, and subtotal while printing the
previous in a receipt-like format.
**********************************************************************/

import java.util.Scanner;

public class Carrera_Invoice
{
	/* This method asks for several inputs and prints out a recipt
style gas reciept. */

	public static void main(String[] args)
	{
		int gasAmount, gasQuality;
		boolean membership;
		double countyTax, cityTax, subTotal, total, gUnleaded, gPlus, gPremium, perGallon;
		String invoice = "INVOICE FOR GASOLINE";
		String memStat = "Member Status: ";
		String gasSP = "Gasoline Sold/Price: ";
		String sTot = "Subtotal: $ ";
		String coTax = "County Tax: $ ";
		String ciTax = "City Tax: $ ";
		String tot = "Total: $ ";
		
		
		gUnleaded = 3.87;
		gPlus = 3.98;
		gPremium = 4.01;


		Scanner Keyboard = new Scanner(System.in);


		System.out.print("Are you a member? ");
		String memberStatus = Keyboard.nextLine();
		System.out.println();


		if (memberStatus.equalsIgnoreCase("yes"))
		{
			membership = true;

		}
		else
			membership = false;


		if (memberStatus.equalsIgnoreCase("yes"))
		{
			memberStatus = "Yes";
		}
		else
			memberStatus = "No";
	
	
		System.out.print("  Quality of gas: ");
		gasQuality = Keyboard.nextInt();
		System.out.println();


		if (membership == true)
		{
			gUnleaded -= .10;
			gPlus -= .10;
			gPremium -= .10;
		}

		
		switch(gasQuality)
		{
			case 87:
				perGallon = gUnleaded;
				break;
			case 89:
				perGallon = gPlus;
				break;
			case 91:
				perGallon = gPremium;
				break;
			default:
				perGallon = gUnleaded;
				break;
		}
		

		System.out.print(" Gallons desired: ");
		gasAmount = Keyboard.nextInt();

		
		subTotal = gasAmount * perGallon;
		countyTax = subTotal * .07;
		cityTax = subTotal * .0375;
		total = subTotal + countyTax + cityTax;

		System.out.println();
		System.out.println();
		System.out.printf("%30s\n", invoice);
		System.out.printf("%23s %4s\n", memStat, memberStatus);
		System.out.printf("%23s %3d @ $%5.2f\n\n", gasSP, gasAmount, perGallon);
		System.out.printf("%23s %6.2f\n",sTot,  subTotal);
		System.out.printf("%23s %6.2f\n", coTax, countyTax);
		System.out.printf("%23s %6.2f\n", ciTax, cityTax);
		System.out.print("                       ---------\n");
		System.out.printf("%23s %6.2f\n",tot,  total);
	}
}
