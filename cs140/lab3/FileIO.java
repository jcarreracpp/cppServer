/*******************************************************************************
	File: FileIO.java
	Author: Jorge Luis Carrera
	Class: CS 140 - Introduction to Computer Science

	Assignment: Lab 3
	Date Last Modified: 5/29/2014

	Purpose: The program asks for the user to input the name of three 
files. It takes the first file, copies it to the second while capitalizing 
the text content. The program copies the content of the first file, 
capitalizes it, but appends it to the third file instead of just copying.
*******************************************************************************/
import java.util.Scanner;
import java.io.*;
import java.io.File;

public class FileIO
{
	/* This method asks the user to input the name of three files. It 
copies and capitalizes the contents of the first into the second and 
appends it to the third.*/
	public static void main(String[] args)throws IOException
	{
		Scanner input = new Scanner(System.in);

		System.out.print("Enter input filename: ");
		String inFileName = input.nextLine();
		File inF = new File(inFileName);

		Scanner fInput = new Scanner(inF);

		System.out.print("\n\nEnter output filename: ");
		String outFileName = input.nextLine();

		System.out.print("\n\nEnter another output filename (append): ");
		String appFileName = input.nextLine();

		FileWriter outF = new FileWriter(outFileName);
		PrintWriter outP = new PrintWriter(outF);

		FileWriter appF = new FileWriter(appFileName, true);
		PrintWriter appP = new PrintWriter(appF);

		while(fInput.hasNextLine())
		{
			outP.println(fInput.nextLine().toUpperCase());
			System.out.println();
		}

		fInput.close();
		fInput = new Scanner(inF);

		while(fInput.hasNextLine())
		{
			appP.println(fInput.nextLine().toUpperCase());
			System.out.println();
		}
		outP.close();
		appP.close();
	}
}
