/*******************************************************************************
	File: EduLearnTools.java
	Author: Jorge Luis Carrera
	Class: CS 140 - Introduction to Computer Science

	Assignment: Lab 3
	Date Last Modified: 5/29/2014

	Purpose:This program is an educational game that generates two 
random numbers, and asks the user to give the proper product of the two 
numbers. If the wrong answer is given, the user recieves a message and the 
question is repeated. If answered right, the user recieves a positive 
message and procedes to a new question. The game does not end unless the 
user inputs a kill value of -1.
*******************************************************************************/
import java.util.Scanner;

public class EduLearnTools
{
	/*This method has two nested loops. The first loop is the game 
instance itself, and will keep repeating itself so long as the game 
continues. The second loop is to ensure that the user recieves the same 
question if answered incorrectly. There are if statements 
permeating the program that trigger if the user inputs the value of -1. 
These if statements prevent the messages from being printed, and shuts down 
the game.*/

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		int response;
		int answer = -2;
		boolean gameRunning = true;

		while(gameRunning==true)
		{
			int first = (int)(Math.random()*10);
			int second = (int)(Math.random()*10);

			while(answer != (first*second))
			{
				System.out.print("How much is " +
first + " times " + second + "? ");

				answer = input.nextInt();
				
				if(answer != (first*second) && answer != -1)
				{
					response = (int)(Math.random()*8);
					if(response >= 0 && response <= 2)
						System.out.println("\nNo. Please try again.");
					else if(response > 2 && response <= 4)
						System.out.println("\nWrong. Try once more.");
					else if(response > 4 && response <= 6)
						System.out.println("\nDon't give up!");
					else if(response > 6 && response <= 8)
						System.out.println("\nNo. Keep trying.");
				}
				

				if(answer == -1)
				{
					answer = (first*second);
					gameRunning = false;
				}	
			}

			if(gameRunning != false)
			{
				response = (int)(Math.random()*8);
				if(response >= 0 && response <= 2)
					System.out.println("\nVery good!");
				else if(response > 2 && response <= 4)
					System.out.println("\nExcellent!");
				else if(response > 4 && response <= 6)
					System.out.println("\nNice work!");
				else if(response > 6 && response <= 8)
					System.out.println("\nKeep up the good work!");
			}
		}
	}
}
