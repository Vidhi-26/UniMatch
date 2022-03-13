/*
 * Name: Vidhi Ruparel
 * Date: December 16, 2021
 * Description: This class contains the sophisticated matching algorithm used to match the user with university programs. 
 */
package controller;


//imports
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

import model.*;
import view.MatchesFrame;


/**
 * MatchingController class matches the user with university programs 
 * based on courses/marks, survey questions, extracurriculars, preferences, and more.
 */
public class MatchingController {
	
	//instance variables
	private static ArrayList<Program> availablePrograms = UniversityInputController.getUniversityArray();		//holds all available programs
	
	
	//So, Java's ArrayList.remove() stopped working last night
	//Initially, I was able to remove programs from availablePrograms
	//Last, night, it did not remove programs (not even availablePrograms.removeAll(availablePrograms) worked!?!?!?)
	//So, instead of removing, I had to find this way of adding programs into a new ArrayList
	private static ArrayList<Program> selectedPrograms = new ArrayList<Program>();
	
	private static final int END_MATCH = 15;																	//ends matching when 15 programs left
	
	
	//utility methods
	
	/**
	 * finds programs that match with the student
	 */
	public static void findMatches() { 
		
		Student student = MainController.getStudent();
		System.out.println("Matching Controller: " + student);
		
		/*	TARGET QUESTIONS/ANSWERS	*/
		//1. match programs based on student's answers to survey questions 
		checkUserAnswers(student.getAnswer());
		
		//if 15 or less than 15 programs remain, stop matching
		if (checkMatchComplete(student))
			return;
		
		
		/*	TARGET COURSES/MARKS	*/
		//2. if courses taken do not have all prerequisite courses required for the program, remove that program
		checkPreReqCourses(student);
		
		//if 15 or less than 15 programs remain, stop matching
		if (checkMatchComplete(student))
			return;
			
		
		//3. if student's average is less than minimum average required by program, remove program from list
		checkMinAverage(student);
		
		//if 15 or less than 15 programs remain, stop matching
		if (checkMatchComplete(student))
			return;
			
		
		//4. if student's average is more than maximum average required by program, remove program from list
//		checkMaxAverage(student);								>> decided not to call as ultimately, it is unfair to the user to remove a program they are eligibe for	
		
		
		/*	TARGET EXTRACURRICULARS	*/
		//5. Check student's extracurricular points
		//max = 28 and min = 0
			//5.1 if student's extracurricular points are less than or equal to 14, remove programs with weight from 6 and 10
			//5.2 if student's extracurricular points are less than or equal to 28, remove programs with weight between 1 and 5
		checkExtraCurricularPoints(student);
		
		//if 15 or less than 15 programs remain, stop matching
		if (checkMatchComplete(student))
			return;
		
		
		/*	TARGET PREFERENCES	*/
		//6. if student wants to live at residence, check if university provides residence
			//6.1 if university does not provide residence, remove from list
		checkResidencePreference(student);
		
		//if 15 or less than 15 programs remain, stop matching
		if (checkMatchComplete(student))
			return;
			

		//7. if student's budget is lower than university budget, remove university with higher budgets
		//checkBudgetPreference(student);						>> not calling as budget preference is not asked	
			
			
		//8. if student wants coop, check if university program provide coop
			//8.1 if program does not provide coop, remove from list
		checkCoopPreference(student);
		
		//if 15 or less than 15 programs remain, stop matching
		if (checkMatchComplete(student))
			return;

		
		//9. if student wants to live closer to home, sort list so that distance from home is sorted in ascending order
		//checkProximityPreference(student);					>> not calling as distance is not calculated properly

		
		student.setMatchedPrograms(availablePrograms);			//sets the user's matched programs
		
		MainController.setStudent(student);
		
		new MatchesFrame();										//displays the user's matched programs
		
	}	//end of findMatches method
	
	
	/*	TARGET PREFERENCES	*/
	
	/**
	 * checks if student wants to live at residence or not, and decides whether to remove program from list
	 */
	private static void checkResidencePreference(Student student) {
		
	//1. traverse through all available programs
	for (int index = 0; index < availablePrograms.size(); index++)
		
		//1.1 if student wants to live at residence, but university does not provide residence
		if ((!student.isHomeResChoice()) && (!availablePrograms.get(index).getResidence()))
			
			//remove program from list
			availablePrograms.remove(availablePrograms.get(index));
	
	}	//end of checkResidencePreference method
	
	
	/**
	 * checks if student's budget is lower than university budget, and decides whether to remove program from list
	 */
	private static void checkBudgetPreference(Student student) {
		
	//1. traverse through all available programs
	for (int index = 0; index < availablePrograms.size(); index++)
		
		//1.1 if student's budget is lower than university budget, remove university with higher budgets
		if (student.getBudget() < (availablePrograms.get(index).getBudget() + 1000))
			
			//remove program from list
			availablePrograms.remove(availablePrograms.get(index));
	
	}	//end of checkBudgetPreference method
	
	
	/**
	 * checks if student wants coop, and decides whether to remove program from list
	 */
	private static void checkCoopPreference(Student student) {
		
	//1.  traverse through all available programs
	for (int index = 0; index < availablePrograms.size(); index++)
		
		//1.1 if student wants coop, but program does not provide coop
		if ((student.isCoopChoice()) && (!availablePrograms.get(index).getCoop()))
			
			//remove program from list
			availablePrograms.remove(availablePrograms.get(index));
	
	}	//end of checkCoopPreference method
	
	
	/**
	 * if student wants to live closer to home, sort list so that distance from home is sorted in ascending order
	 */
	private static void checkProximityPreference(Student student) {
		
		//1. if student wants to live closer to home
		if (student.isPromixityMatters()) {
			
			//1.1 sort list so that distance from home is sorted in ascending order
			//sorting code
			
		}	//end of if statement to check if proximity matters
	
	}	//end of checkProximityPreference method
	
	
	/*	TARGET COURSES/MARKS	*/
	
	/**
	 * checks if courses taken have all prerequisite courses required for the program, and decides whether to remove program from list
	 */
	private static void checkPreReqCourses(Student student) {

		selectedPrograms.removeAll(selectedPrograms);
		
		Arrays.sort(student.getCoursesTaken());
		
		//1.  traverse through all available programs
		for (int index = 0; index < availablePrograms.size(); index++) {
			
			//1.1 if courses taken have all prerequisite courses required for the program
				
			if (isSubset(student.getCoursesTaken(), availablePrograms.get(index).getPreReq(), 6, 5))	{
				
				selectedPrograms.add(availablePrograms.get(index));

				//remove all programs from list because the pre-requisites for all courses are the same 
				//availablePrograms.removeAll(availablePrograms);
				
			}
			
		}
		
		availablePrograms.removeAll(availablePrograms);
		availablePrograms.addAll(selectedPrograms);
	
	}	//end of checkPreReqCourses method
	
	
	/**
	 * checks if student's average is less than minimum average required by program, and decides whether to remove program from list
	 */
	private static void checkMinAverage(Student student) {
		
		selectedPrograms.removeAll(selectedPrograms);
		
		//1.  traverse through all available programs
		for (int index = 0; index < availablePrograms.size(); index++)	{
			
			//1.1 if student's average is less than minimum average required by program
			if (student.getAverageMark() > availablePrograms.get(index).getMinMark())	{
				
				selectedPrograms.add(availablePrograms.get(index));
				
				//remove program from list
				//availablePrograms.remove(availablePrograms.get(index));
			}
			
		}
		
		availablePrograms.removeAll(availablePrograms);
		availablePrograms.addAll(selectedPrograms);
	
	}	//end of checkMinAverage method
		
		
	/**
	 * checks if student's average is more than maximum average required by program, and decides whether to remove program from list
	 */
	private static void checkMaxAverage(Student student) {
		
		//1.  traverse through all available programs
		for (int index = 0; index < availablePrograms.size(); index++)
			
			//1.1 if student's average is more than maximum average required by program
			if (student.getAverageMark() > availablePrograms.get(index).getMaxMark())
				
				//remove program from list
				availablePrograms.remove(availablePrograms.get(index));
	
	}	//end of checkMaxAverage method
	
	
	/*	TARGET QUESTIONS	*/
	/**
	 * match programs based on student's answers to survey questions 
	 */
	private static void checkUserAnswers(int weight) {
		
		for (int index = 0; index < availablePrograms.size(); index++) {
			
			Program program = availablePrograms.get(index);
			
			//EVEN THIS DID NOT WORK?!?!?!
//			availablePrograms.remove(program);
//			System.out.println(availablePrograms);
			
			switch(weight) {
			case 1: 						//Architectural, Civil, Mechanical, Mechatronics programs matches
				
				System.out.println("CASE 1");
				
//				  if (!(program.getProgram().equals("ArchitecturalEngineering"))) {
//						
//						if (!(program.getProgram().equals("CivilEngineering"))) {
//							
//							if (!(program.getProgram().equals("MechanicalEngineering"))) {
//								
//								if (!(program.getProgram().equals("MechatronicsEngineering"))) {
//									
//									availablePrograms.remove(program);
//									
//									System.out.println(program.getProgram() + " removed");
//									
//								}
//							}
//						}
//					}
				  
				  if ((program.getProgram().equals("ArchitecturalEngineering")) || (program.getProgram().equals("CivilEngineering")) || (program.getProgram().equals("MechanicalEngineering")) || (program.getProgram().equals("MechatronicsEngineering"))) {
						selectedPrograms.add(program);
				  }
				  
				break;
				
			case 2:							//Environmental, Geological programs matches
				System.out.println("CASE 2");
				
//				  if (!(program.getProgram().equals("EnvironmentEngineering"))) {
//						
//						if (!(program.getProgram().equals("GeologicalEngineering"))) {
//							
//							if (!(program.getProgram().equals("ManagementEngineering"))) {
//								
//								if (!(program.getProgram().equals("ElectricalEngineering"))) {
//									
//									availablePrograms.remove(program);
//									
//									System.out.println(program.getProgram() + " removed");
//									
//								}
//							}
//						}
//					}
				  
					if ((program.getProgram().equals("EnvironmentEngineering")) || (program.getProgram().equals("GeologicalEngineering")) || (program.getProgram().equals("ManagementEngineering")) || (program.getProgram().equals("ElectricalEngineering"))) {
						selectedPrograms.add(program);
					}
				  
				break;
				
			case 3:							//Computer engineering, Software, computer science, systems design programs matches
				
				System.out.println("CASE 3");
				
//				if (!(program.getProgram().equals("ComputerEngineering"))) {
//					
//					if (!(program.getProgram().equals("SoftwareEngineering"))) {
//						
//						if (!(program.getProgram().equals("ComputerScience"))) {
//							
//							if (!(program.getProgram().equals("SystemsDesignEngineering"))) {
//								
//								System.out.println("HERE FOR CASE 3");
//				
//								EVEN THIS DID NOT WORK?!?!?!
//								System.out.println(availablePrograms);
//								availablePrograms.remove(index);
//								
//								System.out.println("Program: " + program.getProgram() + " removed");
//								System.out.println("Index: " + index + " removed");
//								
//							}
//						}
//					}
//				}
				
				if ((program.getProgram().equals("ComputerEngineering")) || (program.getProgram().equals("SoftwareEngineering")) || (program.getProgram().equals("ComputerScience")) || (program.getProgram().equals("SystemsDesignEngineering"))) {
					selectedPrograms.add(program);
				}
				
				break;
				
			case 4:							//Biomedical, chemical, nanotechnology, managament programs matched
				System.out.println("CASE 4");
				
//			  if (!(program.getProgram().equals("BiomedicalEngineering"))) {
//					
//					if (!(program.getProgram().equals("ChemicalEngineering"))) {
//						
//						if (!(program.getProgram().equals("NanotechnologyEngineering"))) {
//							
//							if (!(program.getProgram().equals("ManagementEngineering"))) {
//								
//								availablePrograms.remove(program);
//								
//								System.out.println(program.getProgram() + " removed");
//								
//							}
//						}
//					}
//				}
			  
				if ((program.getProgram().equals("BiomedicalEngineering")) || (program.getProgram().equals("ChemicalEngineering")) || (program.getProgram().equals("NanotechnologyEngineering")) || (program.getProgram().equals("ManagementEngineering"))) {
					selectedPrograms.add(program);
				}
				
				break;
				
			}	// end of switch statement for weight of answer
			
		}	// end of programs traversal
		
		availablePrograms.removeAll(availablePrograms);
		availablePrograms.addAll(selectedPrograms);

	}	// end of checkUserAnswers method
	
	
	/*	TARGET EXTRACURRICULARS	*/
	
	/**
	 * checks student's extracurricular points, and decides whether to remove program from list
	 */
	private static void checkExtraCurricularPoints(Student student) {
		
		//1.  traverse through all available programs
		for (int index = 0; index < availablePrograms.size(); index++)	{
			
			//1.1 if student's extracurricular points are less than or equal to 14
			if (student.getExtraCurricularPoints() <= 14) {
				
				//1. 1. 1. remove programs with weight from 1 and 5
				if ((availablePrograms.get(index).getRank() >= 1) && (availablePrograms.get(index).getRank() <= 5))
					
					availablePrograms.remove(availablePrograms.get(index));
				
			}
		
			//1.2 otherwise, if student's extracurricular points are less than or equal to 28 (between 14 and 28)
			else if (student.getExtraCurricularPoints() <= 28) {
				
				//1. 2. 1. remove programs with weight between 6 and 10
				if ((availablePrograms.get(index).getRank() >= 6) && (availablePrograms.get(index).getRank() <= 10))
					
					availablePrograms.remove(availablePrograms.get(index));
				
			}
			
		}	// end of programs traversal
	
	}	//end of checkExtraCurricularPoints method
	
	
	/*	END MATCHING	*/
	
	/**
	 * if 15 or less than 15 programs remain, return true so findMatches method can break and matching can stop
	 * otherwise, return false and matching continues
	 */
	private static boolean checkMatchComplete(Student student) {
		
		if (availablePrograms.size() <= END_MATCH) {
			
			student.setMatchedPrograms(availablePrograms);					//sets the user's matched programs
			
			MainController.setStudent(student);
			
			new MatchesFrame();												//displays the user's matched programs
			
			return true;
		}
		
		return false;
		
	}	
	
	/**
	 * return true if one array is a subarray of another							cite: https://www.geeksforgeeks.org/find-whether-an-array-is-subset-of-another-array-set-1/
	 * otherwise, return false
	 */
	private static boolean isSubset(String arr1[], String arr2[], int m, int n) {
		
		int i = 0;
		int j = 0;
		
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++)
				if (arr2[i].equals(arr1[j]))
		    break;
	
			if (j == m)
				return false;
		}
	
		return true;
	}
	

}	//end of MatchingController class
