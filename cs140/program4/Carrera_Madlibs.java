/**********************************************************************
	File: Carrera_Madlibs.java
	Author: Jorge Luis Carrera
	Class: CS 140 - Introduction to Computer Science

	Assignment: Madlibs
	Date Last Modified: 4/23/2014

	Purpose: This program prompts the user to enter a file name,
reads the file specified, then asks the user for a series of words
based on the direction given by the file, then prints the resulting
silly story with the user's input.
**********************************************************************/

import java.util.Scanner;
import java.io.*;
import java.io.File;

public class Carrera_Madlibs
{
	/* This method asks for the user to input a file name,
reads the file, asks the user for input based on file directions,
then prints the story with user's input. */

	public static void main(String[] args)throws IOException
	{

		//Creates user response file
		FileWriter ui = new FileWriter("userinput.txt", true);
		PrintWriter output = new PrintWriter(ui);

		Scanner rinput = new Scanner(System.in);

		//Initializes scanner, asks for filename, opens file
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the filename: ");
		String filename = input.nextLine();
		File file = new File(filename);

		//Checks to see if file exists
		if (!file.exists())
		{
			System.out.println("\nThe file " + filename +
" is not found.");
			System.exit(0);
		}

		//Reads first line of file and parses it to a number
		Scanner inputFile = new Scanner(file);
		String lines = inputFile.nextLine();
		int questions = Integer.parseInt(lines);
		int objectCounter = questions * 2;

		//Loops per # of times the first line specified
		while(objectCounter > 0)
		{
			while(objectCounter > questions)
			{
				lines = inputFile.nextLine();
				System.out.println("\n" + lines);
				String response = rinput.nextLine();
				output.println(response);
				--objectCounter;
			}

			output.close();
			File rfile = new File("userinput.txt");
			Scanner inputrFile = new Scanner(rfile);

			while(objectCounter <= questions && objectCounter > 0)
			{
				lines = inputFile.nextLine();
				String rLines = inputrFile.nextLine();
				System.out.print(lines);
				System.out.print(rLines);
				--objectCounter;
			}
		lines = inputFile.nextLine();
		System.out.print(lines);
		System.out.println();
		}
		inputFile.close();
	}
}
