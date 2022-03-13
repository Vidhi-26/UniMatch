/*
 * Name: Vidhi Ruparel
 * Date: December 16, 2021
 * Description: This is the main controller. New student is created and app is set up for them to use. 
 */
package controller;

import model.Student;

/**
 * MainController class. This runs right after the program starts.
 * It sets up the user when they log in, and begins to play music. 
 */
public class MainController {
	
	//instance variables
	private static Student student = new Student();
	private MusicController musicController;
	
	
	//constructor
	public MainController() {
		
		//loads all universities and sets the user (login / register) for using the app
		new LoginController();
		
		new UniversityInputController();
		
		//starts playing music
		musicController = new MusicController();
		musicController.beginMusic();
		
	}

	
	//getters and setters
	public static Student getStudent() {
		return student;
	}


	public static void setStudent(Student student) {
		MainController.student = student;
	}
	
}	//end of class
