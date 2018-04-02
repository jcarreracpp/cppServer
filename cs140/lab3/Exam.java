/*********************************************************************
	File: Exam.java
	Author: Jorge Luis Carrera
	Class: CS 140 - Introduction to Computer Science

	Assignment: Lab 3
	Date Last Modified: 5/29/2014

	Purpose: Asks user to input failures or successes of students,
but outputs an error message if an incorrect input is given. Incorrect
answers are not incremented into neither failures or successes.
*********************************************************************/
//analysis of examination results
import java.util.Scanner;

public class Exam
{
	/* This method asks the user to input 1's and 0's, signifying 
successes and failures of students, respectively. Any incorrect input is 
ignored and met with an error message.*/

	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		int passes=0, failures=0, students=0, result;
		for (int iii = students; students < 10; students++)
		{
			System.out.print("enter result (1=pass, 0=fail): ");
			result = keyboard.nextInt();
			if (result==1)
				passes++;
			else if (result==0)
				failures++;
			else
			{
				System.out.print("Not a valid answer, try " +
"again.\n");
				students--;
			}
		}
		System.out.println(passes + " passed\n" + failures +
" failed");
		if (passes < 5)
			System.out.println("Raise tuition");
	}
}
