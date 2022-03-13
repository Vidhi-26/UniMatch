package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Program;

/*
 * Name: Sutavin Vinothan
 * Date: December 16, 2021
 * Description:Import controller that gets all the fields from the spreadsheet and puts it into a arraylist
 */
public class UniversityInputController {

	public static ArrayList<Program> universityArray = new ArrayList<Program>();


	public UniversityInputController() {


		try {

			// Create a scanner to input the data from the laptop csv file
			Scanner input = new Scanner(new File("Files/Universities.csv"));
			input.useDelimiter(",");

			// Read the headings row, but ignore them
			input.nextLine();

			// Continue inputting the laptops while there are more rows of data
			while (input.hasNextLine()) {

				// Create a new laptop
				Program program = new Program();
			
				// Set values from .csv file - IN ORDER **There are lots - be careful
				program.setUniversity(input.next());

				program.setProgram(input.next());

				program.setCoop(input.nextBoolean());

				String[] preReq = new String[5];
				for(int x=0; x<preReq.length;x++) {

					preReq[x] = input.next();
				}

				program.setPreReq(preReq);

				program.setMinMark(input.nextDouble());

				program.setMaxMark(input.nextDouble());

				program.setExtraCurr(input.nextBoolean());

				program.setBudget(input.nextDouble());

				program.setResidence(input.nextBoolean());

				program.setxCoor(input.nextDouble());
		
				program.setyCoor(input.nextDouble());
				
				program.setRank(input.nextInt());
				
				program.setHyperlink(input.next());


				// Print the University to the console to test proper input


				universityArray.add(program);
				//System.out.print(program);
			}
			

			input.close();
		} catch (FileNotFoundException error) {

			// Provide an error message In case the file is not found
			System.out.println("Sorry file not loading - please check the name/location");

		} // End try-catch block

	} // End method


	//getters and setters
	public static ArrayList<Program> getUniversityArray() {
		return universityArray;
	}


	public static void setUniversityArray(ArrayList<Program> universityArray) {
		UniversityInputController.universityArray = universityArray;
	}
	
	

}


