///*
// * Name: Vidhi Ruparel
// * Date: December 16, 2021
// * Course: ICS4U1-02 Mr. Fernandes
// * Description:
// */
//package U4;
//
//
//import java.util.ArrayList;
//
////imports
//import controller.MainController;
//import controller.MatchingController;
//import model.Program;
//import model.Student;
//import view.MatchesFrame;
//
//
///**
// * MatchingAlgorithmTest class.
// */
//public class MatchingAlgorithmTest {
//	
//	public static void main(String[] args) {
//		
//		new MainController();
//		
//		String[] saraAnswers = {"a", "b", "c", "d", "e"};
//		String[] rainAnswers = {"v", "w", "x", "y", "z"};
//		
//		String[] saraCourses = {"ENG4U", "MCV4U", "MHF4U", "SCH4U", "SPH4U", "ICS4U"};
//		String[] rainCourses = {"ENG4U", "MCV4U", "MHF4U", "XYZV1", "XYZV2", "ICS4U"};
//		
//		double[] saraMarks = {95.00, 96.00, 94.00, 93.00, 97.00, 95.00};
//		double[] rainMarks = {90.00, 89.00, 91.00, 88.00, 92.00, 90.00};
//		
//		boolean[] saraExtracurriculars = {true, false, true, false, false, false, false};
//		boolean[] rainExtracurriculars = {true, false, true, true, false, true, false};
//		
//		String[] saraCompetitions = {"ENG4U", "MHF4U", "MCV4U", "SCH4U", "SPH4U"};
//		String[] rainCompetitions = {"v", "w", "x", "y", "z"};
//		
//		int[] saraPlaceInComp = {2, 1, 4, 0};
//		int[] rainPlaceInComp = {1, 2, 1, 4};
//		
//		ArrayList<Program> saraMatches = new ArrayList<Program>();
//		ArrayList<Program> rainMatches = new ArrayList<Program>();
//		
//		Student student1 = new Student("Sara", "Li", "miller", "markham", "loi 908", "complife", "abcde", saraAnswers, true, 14000.00, true, false, saraCourses, saraMarks, 95.00, saraExtracurriculars, saraCompetitions, saraPlaceInComp, 25, saraMatches);
//		Student student2 = new Student("Rain", "Fernandes",  "lowquay", "markham", "lib 908", "scifi", "vwxyz", rainAnswers, false, 10000.00, false, false, rainCourses, rainMarks, 85.00, rainExtracurriculars, rainCompetitions, rainPlaceInComp, 14, rainMatches);
//	
//		MatchingController.findMatches(student1);
//		//MatchingController.findMatches(student2);
//		
//		System.out.println("\n\n\nSara!!!!");
//		System.out.println(student1);
//		
//		System.out.println("\n\n\nRain!!!!");
//		//System.out.println(student2);
//		
//	}	
//
//}
