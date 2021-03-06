/*********************************************************************
	File: Carrera_ArrayProcessing.java
	Author: Jorge Luis Carrera
	Class: CS 140 - Introduction to Computer Science

	Assignment: Program 6
	Date Last Modified: 6/5/2013

	Purpose: This program asks for a file name, checks to see if 
it exists, then opens it if it does. It uses the first number to
define the size of an array, and the rest of the numbers fill the
array's empty slots. After that, the program prints the array out,
forwards and backwards, prints out the sum of the array elements,
the mean of the elements, the minimum-most element, and the element
with the highest value. It then runs through the array, saving even
numbered values to 'even.out' and the other values to 'odd.out'.
*********************************************************************/
import java.io.*;
import java.io.File;
import java.util.Scanner;

public class Carrera_ArrayProcessing
{

// This method calls the rest of the methods to use, and does not do any calculation
//itself.

	public static void main(String[] args)throws IOException
	{
		int[] array = inputData();
		printArray(array);
		reverseArray(array);
		evenOdd(array);

		System.out.println("The sum of all elements is: " + sum(array));
		System.out.println("The mean of all elements is: " + mean(array));
		System.out.println("The minimum of all elements is: " + min(array));
		System.out.println("The maximum of all elements is: " + max(array));
		System.out.println();
		System.out.println("Program completed, remember to inspect \'even.out\'" 
+ "and \'odd.out\' files.");
	}


//This method asks the user for a file name, then checks to see if it exists before
//it starts saving the data to an array. The saved array is returned.

	public static int[] inputData()throws IOException
	{
		Scanner kb = new Scanner(System.in);

		String fileName;
		int first;

		System.out.print("Enter a filename: ");
		fileName = kb.nextLine();
		System.out.println();

		File inputFile = new File(fileName);

		if(!inputFile.exists())
		{
			System.out.println(fileName + " was not found!");
			System.exit(0);
		}

		Scanner file = new Scanner(inputFile);

		int[] mainArray;

		first = file.nextInt();

		mainArray = new int[first];

		for(int i=0;i<mainArray.length;i++)
		{
			mainArray[i]=file.nextInt();
		}

		return mainArray;
	}


//This method prints each individual element of the array.

	public static void printArray(int[] array)
	{
		System.out.println("Printing Array:");
		System.out.print("\t");
		for(int i=0;i<array.length;++i)
		{
			System.out.printf("%3d ", array[i]);
			if((i+1)%10==0)
			{
				System.out.println();
				System.out.print("\t");
			}
		}
		System.out.println();
	}


//This method prints each element of the array but in reverse order.

	public static void reverseArray(int[] array)
	{
		System.out.println("Printing Reversed Array:");
		System.out.print("\t");
		for(int i=(array.length-1);i>=0;--i)
		{
			System.out.printf("%3d ", array[i]);
			if((i%10)==0)
			{
				System.out.println();
				System.out.print("\t");
			}
		}
		System.out.println();
	}

//This method accumulates and adds the value of all the array's elements together.

	public static int sum(int[] array)
	{
		int temp=0;
		for(int i=0;i<array.length;++i)
		{
			temp+=array[i];
		}
		return temp;
	}


//This method finds the mean of the array's elements by first finding the total value
//and then dividing that value by the size of the array.

	public static double mean(int[] array)
	{
		int temp=0;
		double dtemp;
		for(int i=0;i<array.length;++i)
		{
			temp+=array[i];
		}
		dtemp = (temp/array.length);
		return dtemp;
	}


//This method finds the lowest value of the array by designating the first element
//as the lowest, then comparing it to the next. If the following element has a 
//lower value, it replaces the original. It does this until it reaches the end
//of the array.

	public static int min(int[] array)
	{
		int min = array[0];
		for(int i=1;i<array.length;++i)
		{
			if(min>array[i])
				min = array[i];
		}
		return min;
	}


//This method finds the largest value of the array by marking the first value as
//the highest, then comparing it to the next. If the next element is a higher value,
//it becomes the new maximum. It repeats this process until it reaches the array's end.

	public static int max(int[] array)
	{
		int max = array[0];
		for(int i=1;i<array.length;++i)
		{
			if(max<array[i])
				max = array[i];
		}
		return max;
	}


//This method creates two files: 'even.out' and 'odd.out' . It reads in the array
//and subjects each element to a modulus calculation. If the answer is zero, then
//the element is even and it is saved to 'even.out', else, saved to 'odd.out' .

	public static void evenOdd(int[] array)throws IOException
	{
		FileWriter even = new FileWriter("even.out");
		FileWriter odd = new FileWriter("odd.out");
		PrintWriter en = new PrintWriter(even);
		PrintWriter od = new PrintWriter(odd);

		for(int i=0;i<array.length;++i)
		{
			if((array[i]%2)==0)
			{
				en.println(array[i]);
			}else{
				od.println(array[i]);
			}
		}
		en.close();
		od.close();
		even.close();
		odd.close();
	}
}
