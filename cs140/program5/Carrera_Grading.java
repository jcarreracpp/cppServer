/***************************************************************
	File: Carrera_Grading.java
	Author: Jorge Luis Carrera
	Class: CS140 - Introduction to Computer Science

	Assignment: Program 5
	Date Last Modified: 6/1/2014

	Purpose: This Program reads in lines as input from the text file, 
accumulate summary data about the students while ignoring any line with any 
invalid data. The summary data will include info on the mean, mode, minimum, 
and maximum of the grades, including the student ID of the students with the 
highest and lowest grades.
***************************************************************/

import java.util.Scanner;
import java.io.*;
import java.io.File;

public class Carrera_Grading
{
	//The main method calls all the other methods and serves as the central hub.
	public static void main(String[] args)throws IOException
	{
		File inputFile = new File("gradeInput.txt");

		FileWriter mathR = new FileWriter("mathResponses.txt");
		PrintWriter mR = new PrintWriter(mathR);

		validateFile(inputFile);
		validateData(inputFile);
		mR.println(mean(false));
		mR.println(mean(true));
		mR.println(mode(false));
		mR.println(mode(true));
		mR.close();
		printData();
	}

	//validateFile checks to see whether the source file exists or not.
	public static void validateFile(File inputFile)throws IOException
	{
		if (!inputFile.exists())
		{
			System.out.println("\nThe file is not found.");
			System.exit(0);
		}
	}


	//validateData manages checking whether the data in the source file is legal or not. Illegal lines are discarded into a text file(badAnswers.txt),
	//while the valid answers are saved into a seperate text file (validAnswers.txt).
	public static void validateData(File inputFile)throws IOException
	{
		String vgrd1, vgrd2, vgrd3, vgrd4, vgrd5, vgrd6, vgrd7, vgrd8, vgrd9, vgrd10, vgrd11;
		Scanner validate = new Scanner(inputFile);
		vgrd1 = validate.nextLine();
		vgrd2 = validate.nextLine();
		vgrd3 = validate.nextLine();
		vgrd4 = validate.nextLine();
		vgrd5 = validate.nextLine();
		vgrd6 = validate.nextLine();
		vgrd7 = validate.nextLine();
		vgrd8 = validate.nextLine();
		vgrd9 = validate.nextLine();
		vgrd10 = validate.nextLine();
		vgrd11 = validate.nextLine();

		seperator(stringValid(vgrd1), vgrd1);
		seperator(stringValid(vgrd2), vgrd2);
		seperator(stringValid(vgrd3), vgrd2);
		seperator(stringValid(vgrd4), vgrd4);
		seperator(stringValid(vgrd5), vgrd5);
		seperator(stringValid(vgrd6), vgrd6);
		seperator(stringValid(vgrd7), vgrd7);
		seperator(stringValid(vgrd8), vgrd8);
		seperator(stringValid(vgrd9), vgrd9);
		seperator(stringValid(vgrd10), vgrd10);
		seperator(stringValid(vgrd11), vgrd11);
	}

	//stringValid takes individual lines passed from validateData and filters them through parameters to check if they are legal or not.
	//illegal data is marked as false, legal data is marked as true.
	public static boolean stringValid(String obj)
	{
		int sID, sEC;
		double sGrades;
		Scanner sobj = new Scanner(obj);
		if(sobj.hasNextInt())
		{
			sID = sobj.nextInt();

			if(00000 <= sID && sID <= 99999)
			{
				if(sobj.hasNextInt())
				{
					sEC = sobj.nextInt();

					if(0 <= sEC && sEC <= 5)
					{

						if(sobj.hasNextDouble())
						{
							sGrades = sobj.nextDouble();

							if(00.00 <= sGrades && sGrades <= 100.00)
							{
								return true;
							}else{
								return false;
							}
						}else{
							return false;
						}
					}else{
						return false;
					}
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	//seperator saves data marked as false to "badAnswers.txt", and saves data marked as true to "validAnswers.txt"
	public static void seperator(boolean yesno, String content)throws IOException
	{
		FileWriter validA = new FileWriter("validAnswers.txt", true);
		PrintWriter vA = new PrintWriter(validA);

		FileWriter badA = new FileWriter("badAnswers.txt", true);
		PrintWriter bA = new PrintWriter(badA);

		if(yesno)
		{
			vA.println(content);
		}else{
			bA.println(content);
		}

		vA.close();
		bA.close();
	}


	//mean adds all the grade values, while incrementing by one per line it has to scan. it divides the sum of all the grades by the number of times
	//incremented to find the mean of all the grades.
	public static double mean(Boolean gradeType)throws IOException
	{
		File validA = new File("validAnswers.txt");
		Scanner vA = new Scanner(validA);

		int id1, extraC2, jjj=1;
		double grade3, accum=0, mean;

		if(gradeType)
		{
			for(int iii=0;vA.hasNextInt();iii++)
			{
				id1 = vA.nextInt();
				extraC2 = vA.nextInt();
				grade3 = vA.nextDouble();

				accum += (extraC2 + grade3);
				jjj = iii + 1;
			}
			mean = (accum/jjj);
			return mean;
		}else{
			for(int iii=0;vA.hasNextInt();iii++)
			{
				id1 = vA.nextInt();
				extraC2 = vA.nextInt();
				grade3 = vA.nextDouble();

				accum += grade3;
				jjj = iii + 1;
			}
			mean = (accum/jjj);
			return mean;
		}
	}


	//mode checks for the number of occurences that each grade has in the data. true accounts for extra credit, false accounts for the base grade.
	public static double mode(Boolean gradeType)throws IOException
	{
		File validA = new File("validAnswers.txt");
		Scanner vA = new Scanner(validA);

		int id, extraC, lProbe=0,cProbe=1, countProbe=1, currentCounter=0, mostId=0, mostCounter=0;
		double grade, currentGrade=0, mostGrade=0;

		if(gradeType)
		{
			while(vA.hasNextInt())
			{
				vA.nextLine();
				++lProbe;
			}
			vA.close();
			vA = new Scanner(validA);

			while(cProbe<lProbe)
			{

				do{
					mostId=vA.nextInt();
					mostCounter=vA.nextInt();
					mostGrade=vA.nextDouble();
					--countProbe;
				}while(countProbe>0);

				while(vA.hasNextInt())
				{
					id  = vA.nextInt();
					extraC = vA.nextInt();
					grade = vA.nextDouble();
					if((extraC + grade)==(mostCounter + mostGrade))
					{
						currentCounter = mostCounter;
						currentGrade = mostGrade;
					}
				}
				vA.close();
				vA = new Scanner(validA);
				++cProbe;
				countProbe=cProbe;
			}
			return (currentCounter + currentGrade);
		}else{
			while(vA.hasNextInt())
			{
				vA.nextLine();
				++lProbe;
			}
			vA.close();
			vA = new Scanner(validA);

			while(cProbe<lProbe)
			{
				do{
					mostId=vA.nextInt();
					mostCounter=vA.nextInt();
					mostGrade=vA.nextDouble();
					--countProbe;
				}while(countProbe>0);

				while(vA.hasNextInt())
				{
					id = vA.nextInt();
					extraC = vA.nextInt();
					grade = vA.nextDouble();
					if(grade==mostGrade)
					{
						currentCounter = mostCounter;
						currentGrade = mostGrade;
					}
				}
				vA.close();
				vA = new Scanner(validA);
				++cProbe;
				countProbe=cProbe;
			}
			return currentGrade;
		}
	}

	//min 'grabs' the first line of data from the list, and compares it to the next item. if the next item is a lower value, it replaces the currently
	//held data and checks the next line against the new held data. if the next item is not a lower value, the program proceeds to check the next line.
	public static double min(Boolean gradeType)throws IOException
	{
		File validA = new File("validAnswers.txt");
		Scanner vA = new Scanner(validA);
		FileWriter mathR = new FileWriter("mathResponses.txt", true);
		PrintWriter mR = new PrintWriter(mathR);

		int id, extra, id2, extra2;
		double grade, grade2;

		if(gradeType)
		{
			id = vA.nextInt();
			extra = vA.nextInt();
			grade = vA.nextDouble();

			while(vA.hasNextInt())
			{
				id2 = vA.nextInt();
				extra2 = vA.nextInt();
				grade2 = vA.nextDouble();
				if((extra+grade)>(extra2+grade2))
				{
					id = id2;
					extra = extra2;
					grade = grade2;
				}
			}

			mR.println(id);
			mR.close();
			return (extra+grade);
		}else{
			id = vA.nextInt();
			extra = vA.nextInt();
			grade = vA.nextDouble();

			while(vA.hasNextInt())
			{
				id2 = vA.nextInt();
				extra2 = vA.nextInt();
				grade2 = vA.nextDouble();
				if(grade>grade2)
				{
					id = id2;
					extra = extra2;
					grade = grade2;
				}
			}
			mR.println(id);
			mR.close();
			return grade;
		}
	}

	//max 'grabs' the first line of data and checks it against the next line. if the next line is greater, it replaces the currently held line and proceeds
	//to check it against the next line. if the next line is not greater, the program proceeds to check the next line without replacing.
	public static double max(Boolean gradeType)throws IOException
	{
		File validA = new File("validAnswers.txt");
		Scanner vA = new Scanner(validA);
		FileWriter mathR = new FileWriter("mathResponses.txt", true);
		PrintWriter mR = new PrintWriter(mathR);

		int id, id2, extra, extra2;
		double grade, grade2;

		if(gradeType)
		{
			id = vA.nextInt();
			extra = vA.nextInt();
			grade = vA.nextDouble();

			while(vA.hasNextInt())
			{
				id2 = vA.nextInt();
				extra2 = vA.nextInt();
				grade2 = vA.nextDouble();
				if((extra+grade)<(extra2+grade2))
				{
					id = id2;
					extra = extra2;
					grade = grade2;
					if((extra+grade)>100.00)
					{
						grade = 100.00;
					}
				}
			}

			mR.println(id);
			mR.close();
			return grade;
		}else{
			id = vA.nextInt();
			extra = vA.nextInt();
			grade = vA.nextDouble();

			while(vA.hasNextInt())
			{
				id2 = vA.nextInt();
				extra2 = vA.nextInt();
				grade2 = vA.nextDouble();
				if(grade<grade2)
				{
					id = id2;
					extra = extra2;
					grade = grade2;
				}
			}

			mR.println(id);
			mR.close();
			return grade;
		}
	}

	//printData takes the formatted information from the three files (validAnswers.txt, badAnswers.txt, and mathResponses.txt) and prints it to the
	//screen when called, showing exempted lines of data and the reason, the mean of the grades with and without extra credit involved, the mode of the grades
	//with and without extra credit involved, the minimum of the grades with and without extra credit involved & with the respective students, and finally
	//the maximum of the grades with and without extra credit involved & with the respective students.
	public static void printData()throws IOException
	{
		File validA = new File("validAnswers.txt");
		File badA = new File("badAnswers.txt");
		File mathR = new File("mathResponses.txt");
		Scanner vA = new Scanner(validA);
		Scanner bA = new Scanner(badA);
		Scanner mR = new Scanner(mathR);

		min(false);
		min(true);
		max(false);
		max(true);

		double mean = Double.parseDouble(mR.nextLine());
		double meanE = Double.parseDouble(mR.nextLine());
		double mode = Double.parseDouble(mR.nextLine());
		double modeE = Double.parseDouble(mR.nextLine());
		int min = Integer.parseInt(mR.nextLine());
		int minE = Integer.parseInt(mR.nextLine());
		int max = Integer.parseInt(mR.nextLine());
		int maxE = Integer.parseInt(mR.nextLine());

		String sOne = "Ignoring student with invalid ID number ";
		String sTwo = "Ignoring student ";
		String sTwoA = " with invalid extra credit ";
		String sTwoB = " with invalid grade ";
		String sMean = "Mean Earned Grade: ";
		String sMeanE = "Mean Enhanced Grade: ";
		String sMode = "Mode Earned Grade: ";
		String sModeE = "Mode Enhanced Grade: ";
		String sMin = "Minimum Earned Grade: ";
		String sMinE = "Minimum Enhanced Grade: ";
		String sMax = "Maximum Earned Grade: ";
		String sMaxE = "Maximum Enhanced Grade: ";

		int idHold, extraHold;
		double gradeHold;
		String firstInt, secondInt, thirdDouble;

		while(bA.hasNextLine())
		{
			if(bA.hasNextInt())
			{
				idHold = bA.nextInt();

				if(idHold >= 00000 && idHold <= 99999)
				{
					if(bA.hasNextInt())
					{
						extraHold = bA.nextInt();

						if(extraHold <= 5 && extraHold >= 0)
						{
							if(bA.hasNextDouble())
							{
								gradeHold = bA.nextDouble();

								if(gradeHold >= 00.00 && gradeHold <= 100.00)
								{

								}else{
									System.out.printf("%s%5d%s%.2f\n", sTwo, idHold, sTwoB, gradeHold);
									bA.nextLine();
								}
							}else{
								String problem2 = bA.nextLine();
								String p2B = problem2.substring(0);
								System.out.printf("%s%5d%s%s\n", sTwo, idHold, sTwoB, p2B);
							}
						}else{
							System.out.printf("%s%5d%s%1d\n", sTwo, idHold, sTwoA, extraHold);
							bA.nextLine();
						}
					}else{
						String problem1 = bA.nextLine();
						String pB = problem1.substring(0);
						System.out.printf("%s%5d%s%s\n", sTwo, idHold, sTwoA, pB);
					}
				}else{
					System.out.printf("%s%5d\n", sOne, idHold);
				}
			}else{
				System.out.printf("%s%5s\n", sOne, bA.nextLine().substring(0, 5));
			}
		}
		bA.close();

		System.out.printf("%25s%6.2f\n",sMean,mean);
		System.out.printf("%25s%6.2f\n",sMeanE,meanE);
		System.out.printf("%25s%6.2f\n",sMode,mode);
		System.out.printf("%25s%6.2f\n",sModeE,modeE);
		System.out.printf("%25s%6.2f (student %5d)\n",sMin,min(false),min);
		System.out.printf("%25s%6.2f (student %5d)\n",sMinE,min(true),minE);
		System.out.printf("%25s%6.2f (student %5d)\n",sMax,max(false),max);
		System.out.printf("%25s%6.2f (student %5d)\n",sMaxE,max(true),maxE);

	}
}
