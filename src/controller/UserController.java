package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import model.Student;

public class UserController {
	
	private String usersFilePath = "Files/users.txt";
	private String passwordFilePath = "Files/password.txt";
	private String courseMarksFilePath = "Files/courseMarks.txt";
	private String extraCurrFilePath = "Files/extraCurr.txt";
	
	public static ArrayList<Student> studentList = new ArrayList<Student>();
	
	public static String[] questionArray = new String[] {
					"Q1:In what city were you born?",
					"Q2:What is the name of your favorite pet?",
					"Q3:What is your mother's maiden name?",
					"Q4:What is the name of your first school?",
					"Q5:What was your favorite food?",
					"Q6:What Is your favorite book?",
					"Q7:Where is your favorite place to vacation?",
					"Q8:Who was your childhood hero?",
					"Q9:What’s your favorite movie?",
					"Q10:What was your childhood nickname?",
				};
	
	
	public UserController() {
		
		// Import userlist from users.txt file into Student ArrayList
		importUserList();
		importCourseMarksList();
		importExtraCurrList();

	}
	
	//Method to write into txt files
	public void writeIntoFile(String userDetails) {
		
		File myFile = new File("Files/Users.txt");
		FileWriter myWriter;
		PrintWriter myPrintWriter;
		
	    String s1 = "Sutavin1,Sutavin123,12";
	    String s2 = "Sutavin2,Sutavin123,34,";
	    String s3 = "Sutavin3,Sutavin123,56";
		

	    
		try {
			
			myWriter = new FileWriter(myFile, true);
			myPrintWriter = new PrintWriter(myWriter);

			Scanner input = new Scanner(new File(usersFilePath));
			
			if (input.hasNextLine()) {
				myPrintWriter.print(",\n");
				myPrintWriter.print(userDetails);
			} else {
				myPrintWriter.print(userDetails);
			}

			myPrintWriter.close();
		    myWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	//method to update password
	public  void updatePassword(String searchUserName,String newPassword)  {
		
		
        File fileName = new File(passwordFilePath);
        String userName="";
        String password="";
        
        try
        {
        	Scanner input = new Scanner(new File(passwordFilePath));
        	input.useDelimiter(",");
            
            StringBuffer newContent = new StringBuffer("");
            
            while(input.hasNext())
            {
            	
            	userName = input.next().replaceAll("\n", "").replaceAll("\r", "");
            	password = input.next().replaceAll("\n", "").replaceAll("\r", "");
                
                if(userName.equals(searchUserName))
                {
                	newContent.append(userName + "," + newPassword);
                }
                else
                {
                	newContent.append(userName + "," + password);
                }
                
                if (input.hasNextLine()) {
                	newContent.append("," + System.lineSeparator());
                }
            }
            input.close();
        
        FileWriter fw = new FileWriter(fileName);
                
        fw.write(newContent.toString());
        fw.close();
       }
        catch(Exception e)
        {
            System.out.println("Error");
            e.printStackTrace();

        }
        
    }
	//method to get password
	public String retrievePassword(String searchUserName) {
		
		String userName = "";
		String password = null;
		String age = "";
		
    	try {
				Scanner input = new Scanner(new File(usersFilePath));
				input.useDelimiter(",");
				
	           while(input.hasNext())
	            {
	            	
	            	userName = input.next().replaceAll("\n", "").replaceAll("\r", "");
	            	password = input.next().replaceAll("\n", "").replaceAll("\r", "");
	                age = input.next().replaceAll("\n", "").replaceAll("\r", "");
	                
	                if(userName.equals(searchUserName))
	                {
	                	return password;
	                } else {
	                	password = "";
	                }
	                
	            }
	            input.close();			
						
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return password;
		
	}
	
	//check if a user exists
	public boolean isUserExist(String searchUserName) {
		
		boolean userExist = false;
		String userName = "";
		String password = null;
		
    	try {
				Scanner input = new Scanner(new File(passwordFilePath));
				input.useDelimiter(",");
				
	           while(input.hasNext())
	            {
	            	
	            	userName = input.next().replaceAll("\n", "").replaceAll("\r", "");
	            	password = input.next().replaceAll("\n", "").replaceAll("\r", "");
	                
	                if(userName.equals(searchUserName))
	                {
	                	return true;
	                } 
	                
	            }
	            input.close();			
						
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return userExist;
	}
	
	//method to save password into password.txt
	public void savePassword(String userName, String password) {
		
		File myFile = new File(passwordFilePath);
		FileWriter myWriter;
		PrintWriter myPrintWriter;
	    
		try {
			
			myWriter = new FileWriter(myFile, true);
			myPrintWriter = new PrintWriter(myWriter);

			Scanner input = new Scanner(myFile);
			
			if (input.hasNextLine()) {
				myPrintWriter.print(",\n");
				myPrintWriter.print(userName + "," + password);
			} else {
				myPrintWriter.print(userName + "," + password);
			}

			myPrintWriter.close();
		    myWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}	
	
	//method to check if user is authenticated
	public boolean isUserAuthenticated(String searchUserName, String searchPassword ) {
		
		boolean isUserAuthenticated = false;
		String userName = "";
		String password = "";
		
    	try {
				Scanner input = new Scanner(new File(passwordFilePath));
				input.useDelimiter(",");
				
	           while(input.hasNext())
	            {
	            	
	            	userName = input.next().replaceAll("\n", "").replaceAll("\r", "");
	            	password = input.next().replaceAll("\n", "").replaceAll("\r", "");
	                
	                if(userName.equals(searchUserName) && password.equals(searchPassword))
	                {
	                	return true;
	                } 
	                
	            }
	            input.close();			
						
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return isUserAuthenticated;
	}	
	
	// Import userlist from users.txt file into Student ArrayList
	public void importUserList() {
		
		// Create a scanner to input the data from the users.txt file
		Scanner input;
		try {
			input = new Scanner(new File(usersFilePath));

			input.useDelimiter(",");
	
			// Start at the first laptop - number 0
			//int index = 0;
	
			// Continue inputting the laptops while there are more rows of data
			while (input.hasNextLine()) {
	
				Student student = MainController.getStudent();
				
				student.setFirstName(input.next());
				student.setLastName(input.next());
				student.setUsername(input.next());
				student.setStreet(input.next());
				student.setCity(input.next());
				student.setPostalCode(input.next());
				
				studentList.add(student);
				
				System.out.println("Saved users imported from file: " + student);
				
				if (checkReturningUser(student)) {
					System.out.println("Re-logging user: " + student);
					break;
				}
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// Save course-marks into courseMarks.txt file
	public void saveCourseMarks(String username, String[] coursesTaken, double[] marksInCourses, double agerage) {
		
		File myFile = new File(courseMarksFilePath);
		FileWriter myWriter;
		PrintWriter myPrintWriter;
		
		// Create course-marks as a comma separated single line
		StringBuffer courseMarks = new StringBuffer("");
		courseMarks.append(username + ",");
		
		for (int i=0; i < coursesTaken.length; i++) {
			courseMarks.append(coursesTaken[i] + ","); 
			courseMarks.append(marksInCourses[i] + ","); 
		}

		courseMarks.append(agerage); 
	    
		try {
			
			myWriter = new FileWriter(myFile, true);
			myPrintWriter = new PrintWriter(myWriter);

			Scanner input = new Scanner(myFile);
			
			if (input.hasNextLine()) {
				myPrintWriter.print(",\n");
				myPrintWriter.print(courseMarks.toString());
			} else {
				myPrintWriter.print(courseMarks.toString());
			}

			myPrintWriter.close();
		    myWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Save ExtraCurr into extraCurr.txt file
	public void saveExtraCurr(String username, boolean[] extracurricularsDone, int[] placeInExtraCurricular) {
		
		File myFile = new File(extraCurrFilePath);
		FileWriter myWriter;
		PrintWriter myPrintWriter;
		
		// Create extraCurr as a comma separated single line
		StringBuffer extraCurr = new StringBuffer("");
		extraCurr.append(username + ",");
		
		for (int i=0; i < extracurricularsDone.length; i++) {
			
			extraCurr.append(extracurricularsDone[i] + ","); 
			
			if(i != (extracurricularsDone.length -1) )
				extraCurr.append(placeInExtraCurricular[i] + ","); 
			else
				extraCurr.append(placeInExtraCurricular[i]); 
		}
	    
		try {
			
			myWriter = new FileWriter(myFile, true);
			myPrintWriter = new PrintWriter(myWriter);

			Scanner input = new Scanner(myFile);
			
			if (input.hasNextLine()) {
				myPrintWriter.print(",\n");
				myPrintWriter.print(extraCurr.toString());
			} else {
				myPrintWriter.print(extraCurr.toString());
			}

			myPrintWriter.close();
		    myWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	// Import course-marks list from courseMarks.txt file into Student ArrayList
	public void importCourseMarksList() {
		
		// Create a scanner to input the data from the courseMarks.txt file
		Scanner input;
		try {
			input = new Scanner(new File(courseMarksFilePath));

			input.useDelimiter(",");
	
			// Continue inputting while there are more rows of data
			while (input.hasNext()) {
				
				String line = input.nextLine().replaceAll("\n", "").replaceAll("\r", "");
				
				String[] words = line.split(",");
//				System.out.println(Arrays.toString(words));
				//System.out.println(words[0]);
				
				int courseIndex = 1;
				int markIndex = 2;
				
				String username = words[0];
				Student student = MainController.getStudent();
				
				if (student.getUsername().equals(username)) {
					
					String[] coursesTaken = new String[6];
					double[] marksInCourses = new double[6];
					
					for (int i=0; i < coursesTaken.length; i++) {
						coursesTaken[i] = words[courseIndex];
						marksInCourses[i] = Double.parseDouble(words[markIndex]);	
						courseIndex+=2;
						markIndex+=2;
					}
					
					student.setCoursesTaken(coursesTaken);
					student.setMarksInCourses(marksInCourses);
					student.setAverageMark(Double.parseDouble(words[13]));
					
					MainController.setStudent(student);
					
					System.out.println("Part 2 of saved student: " + student);
					
				}
				
				// Add course-marks for the specific student in the studentList
					//System.out.println("This is the username: " + userName);
//					if(student.getUsername().equals(userName)) {
//						
//						String[] coursesTaken = new String[6];
//						double[] marksInCourses = new double[6];
//					
//						
//						for (int i=0; i < coursesTaken.length; i++) {
//							//System.out.println("here: " + input.next());
////							coursesTaken[i] = input.next();
////							marksInCourses[i] = input.nextDouble();	
//							System.out.println(input.next());
//							System.out.println(input.nextDouble());
//						}
//						
//						student.setCoursesTaken(coursesTaken);
//						student.setMarksInCourses(marksInCourses);
//						
//						student.setAverageMark(input.nextDouble());
//						
//						MainController.setStudent(student);
						
						//System.out.println(student);

					//}
				//}

			}
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
	public void importExtraCurrList() {
		
		// Create a scanner to input the data from the extraCurr.txt file
		Scanner input;
		try {
			input = new Scanner(new File(extraCurrFilePath));

			input.useDelimiter(",");
	
			// Continue inputting while there are more rows of data
			while (input.hasNextLine()) {
				
				String line = input.nextLine().replaceAll("\n", "").replaceAll("\r", "");
				
				String[] words = line.split(",");
//				System.out.println(Arrays.toString(words));
				//System.out.println(words[0]);
				
				int ecIndex = 1;
				int placeIndex = 2;
				
				String username = words[0];
				Student student = MainController.getStudent();
				
				if (student.getUsername().equals(username)) {
					
					boolean[] extracurricularsDone = new boolean[8];
					int[] placeInExtraCurricular = new int[8];
					
					for (int i=0; i < extracurricularsDone.length; i++) {
						extracurricularsDone[i] = Boolean.parseBoolean(words[ecIndex]);
						placeInExtraCurricular[i] = Integer.parseInt(words[placeIndex]);	
						ecIndex+=2;
						placeIndex+=2;
					}
					
					student.setExtracurricularsDone(extracurricularsDone);
					student.setPlacesInCompetitions(placeInExtraCurricular);
					
					MainController.setStudent(student);
					
					System.out.println("Part 3 of saved student: " + student);
				}
				
				//String userName = input.next().replaceAll("\n", "").replaceAll("\r", "");
				
				// Add course-marks for the specific student in the studentList
//				for (Student student: UserController.studentList) {
//					
//					if(student.getUsername().equals(userName)) {
//						
//						// Get all eight extra curr from home screen
//						boolean[] extracurricularsDone = new boolean[8];
//						int[] placeInExtraCurricular = new int[8];
//
//						for (int i=0; i < extracurricularsDone.length; i++) {
//							
//							extracurricularsDone[i] = input.nextBoolean();
//							placeInExtraCurricular[i] = input.nextInt();
//							
//						}							
//						
//						student.setExtracurricularsDone(extracurricularsDone);
//						student.setPlacesInCompetitions(placeInExtraCurricular);
//						
//						MainController.setStudent(student);
//												
//						//places in competition
//						
//						//System.out.println(student);
//
//					}
//				}

			}
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean checkReturningUser(Student student) {
		
		System.out.println("REACHED");
		
		String userName = student.getUsername();
		if(isUserExist(userName)) {
			
			MainController.setStudent(student);
			
			return true;
		}
		
		
		return false;
	}
	
}