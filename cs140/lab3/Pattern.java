/**************************************************************************
	File: Pattern.java
	Author: Jorge Luis Carrera
	Class: CS 140 - Introduction to Computer Science

	Assignment: Lab 3
	Date Last Modified: 5/29/2014

	Purpose: Program prints numbers 1 to 6 in increasing order, while
eliminating the last number per decreasing line.
**************************************************************************/

public class Pattern
{
	/* This method prints numbers 1 to 6 in increasing order, while
eliminating the last number per decreasing line.*/
	public static void main(String[] args)
	{
		for (int iii = 7; iii > 0; --iii)
		{
			for (int jjj = 1; jjj < iii; ++jjj)
			{
				System.out.print(jjj + " ");
			}
			System.out.println();
		}
	}
}
