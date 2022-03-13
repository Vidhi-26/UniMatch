/*
 * Name: Vidhi Ruparel (class creator), Sutavin, John, Sylvia, Jasper
 * 
 * Vidhi: UniMatchApplication, MainController, MatchingController, MusicController, Student, AllMatchesFrame, HeaderPanel, MatchBoxPanel, MatchesFrame, MatchesPanel, MatchingAlgorithmTest
 * 
 * Sutavin: LoginController, UniversityInputController, UserController, LoginFrame, LoginPanel, PasswordChagnePanel, RegisterPanel
 * 
 * John: University, HomeScreenFrame, HomeScreenPanel, InitialScreen, SecondaryScreen, TertiaryScreen
 * 
 * Sylvia: ExtraCurricularsController, ExtracurricularAsking, ExtracurricularCategories, ExtracurricularCompetitionInfo
 * 
 * Jasper: PSApplication, DistanceController, Courses, user_info, Program, CourseDialog
 * 
 * 
 * Date: December 16, 2021
 * Course: ICS4U1-02 Mr. Fernandes
 * 
 * Title: UniMatch Post-Secondary App
 * 
 * Description: A comprehensive app that will assist high school students in finding the best post-secondary program. 
 * The app will match users to Ontario universities based on their courses/marks, survey questions, extracurriculars, and more. 
 * 
 * Features:
 * 1. Interactive GUI for high school students to match with their post-secondary programs of choice
 * 2. New users can register, and returning users can login
 * 3. Matching based on almost 10 factors through a sophisticated algorithm
 * 
 * - Extra Features That Work:
 * 1. Vidhi: Live links to university programs available
 * 2. Vidhi: Inspirational Sound/Music + Gradient backgrouns
 * 
 * Major skills: GUI (Swing package, Tables, Hyperlinks, Multiple frames), Object oriented programming, Communication and team-work skills, Handling files (importing, storing, exporting data)
 * 
 * Areas Of Concern: 
 * HomeScreenPanel: The home screen doesn't always display the user's information (it displays name, some extracurriculars, and sometimes all courses)
 * CouseDialog: Marks can only be entered as integers
 * ExtracurricularCompetitionInfo: Doesn't let user not enter any competition
 * 
 */
package application;


//imports
import controller.MainController;
import utils.SQLiteJDBC;


/**
 * UniMatchApplication class. The app start running from this class.
 */
public class UniMatchApplication {
	
	//main method - application starts here
	public static void main(String[] args) {
		
		new MainController();
		
	}

}
