/*
 * Name: Vidhi Ruparel
 * Date: December 16, 2021
 * Course: ICS4U1-02 Mr. Fernandes
 * Description: This is the template for a Student object.
 */
package model;


//imports
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Student class that is a template for a Student. 
 * It has instance variables, constructors, getters and setters, and toString.
 */
public class Student {
	
	//instance variables
	
	//basic user information (name, address)
	private String firstName, lastName;
	private String street, city, postalCode;
	
	//user's username and password for the app
	private String username, password;
	
	//user's answers to questions asked
	private int answer;
	
	//user's preferences (live at home or residence, budget, coop preference, proximity to home)
	private boolean homeResChoice;									//true for home, false for residence
	private double budget;											//budget for tuition)
	private boolean coopChoice;										//true if they want to do coop, false if they don't want to	
	private boolean promixityMatters;								//true if proximity to university matters for student, otherwise false
	
	//user's courses, marks, average
	private String[] coursesTaken;
	private double[] marksInCourses;
	private double averageMark;										//average mark of 6 U/M courses
	
	//user's extracurricular activities information
	private boolean[] extracurricularsDone = new boolean[8];		//index of array represents extracurricular activity category (example: athletics, music, dance)
	private String[] competitionsParticipated = new String[5];		//names of competitions the student participated in
	private int[] placesInCompetitions = new int[4];				//index 0 of array represent 1st place position, index 1 represent 2nd place, and so on, index 3 represents places after 3rd place
	private int extraCurricularPoints;								//combined score of number of extracurriculars and competition positions
	
	//user's matched programs
	private ArrayList<Program> matchedPrograms;
	
	
	//constructors
	
	//default constructor
	public Student() {
		super();
	}

	//overloaded constructor
	public Student(String firstName, String lastName, String street, String city, String postalCode, String username,
			String password, int answer, boolean homeResChoice, double budget, boolean coopChoice,
			boolean promixityMatters, String[] coursesTaken, double[] marksInCourses, double averageMark,
			boolean[] extracurricularsDone, String[] competitionsParticipated, int[] placesInCompetitions,
			int extraCurricularPoints, ArrayList<Program> matchedPrograms) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
		this.username = username;
		this.password = password;
		this.answer = answer;
		this.homeResChoice = homeResChoice;
		this.budget = budget;
		this.coopChoice = coopChoice;
		this.promixityMatters = promixityMatters;
		this.coursesTaken = coursesTaken;
		this.marksInCourses = marksInCourses;
		this.averageMark = averageMark;
		this.extracurricularsDone = extracurricularsDone;
		this.competitionsParticipated = competitionsParticipated;
		this.placesInCompetitions = placesInCompetitions;
		this.extraCurricularPoints = extraCurricularPoints;
		this.matchedPrograms = matchedPrograms;
	}

	
	//setters and getters
	
	//basic user information (name, address)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	//user's username and password for the app
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	//user's answers to questions asked
	public int getAnswer() {
		return answer;
	}
	
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	
	//user's preferences (live at home or residence, budget, coop preference, proximity)
	public boolean isHomeResChoice() {
		return homeResChoice;
	}
	
	public void setHomeResChoice(boolean homeResChoice) {
		this.homeResChoice = homeResChoice;
	}
	
	public double getBudget() {
		return budget;
	}
	
	public void setBudget(double budget) {
		this.budget = budget;
	}
	
	public boolean isCoopChoice() {
		return coopChoice;
	}
	
	public void setCoopChoice(boolean coopChoice) {
		this.coopChoice = coopChoice;
	}
	
	public boolean isPromixityMatters() {
		return promixityMatters;
	}

	public void setPromixityMatters(boolean promixityMatters) {
		this.promixityMatters = promixityMatters;
	}
	
	//user's courses, marks, average
	public String[] getCoursesTaken() {
		return coursesTaken;
	}
	
	public void setCoursesTaken(String[] coursesTaken) {
		this.coursesTaken = coursesTaken;
	}
	
	public double[] getMarksInCourses() {
		return marksInCourses;
	}
	
	public void setMarksInCourses(double[] marksInCourses) {
		this.marksInCourses = marksInCourses;
	}
	
	public double getAverageMark() {
		return averageMark;
	}
	
	public void setAverageMark(double averageMark) {
		this.averageMark = averageMark;
	}
	
	//user's extracurricular activities information
	public boolean[] getExtracurricularsDone() {
		return extracurricularsDone;
	}
	
	public void setExtracurricularsDone(boolean[] extracurricularsDone) {
		this.extracurricularsDone = extracurricularsDone;
	}
	
	public int[] getPlacesInCompetitions() {
		return placesInCompetitions;
	}
	
	public void setPlacesInCompetitions(int[] placesInCompetitions) {
		this.placesInCompetitions = placesInCompetitions;
	}

	public String[] getCompetitionsParticipated() {
		return competitionsParticipated;
	}

	public void setCompetitionsParticipated(String[] competitionsParticipated) {
		this.competitionsParticipated = competitionsParticipated;
	}

	public int getExtraCurricularPoints() {
		return extraCurricularPoints;
	}

	public void setExtraCurricularPoints(int extraCurricularPoints) {
		this.extraCurricularPoints = extraCurricularPoints;
	}

	//user's matched programs
	public ArrayList<Program> getMatchedPrograms() {
		return matchedPrograms;
	}

	public void setMatchedPrograms(ArrayList<Program> matchedPrograms) {
		this.matchedPrograms = matchedPrograms;
	}

	
	//toString method
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", street=" + street + ", city=" + city
				+ ", postalCode=" + postalCode + ", username=" + username + ", password=" + password + ", answers="
				+ answer + ", homeResChoice=" + homeResChoice + ", budget=" + budget + ", coopChoice="
				+ coopChoice + ", promixityMatters=" + promixityMatters + ", coursesTaken="
				+ Arrays.toString(coursesTaken) + ", marksInCourses=" + Arrays.toString(marksInCourses)
				+ ", averageMark=" + averageMark + ", extracurricularsDone=" + Arrays.toString(extracurricularsDone)
				+ ", competitionsPartcipated=" + Arrays.toString(competitionsParticipated) + ", placesInCompetitions="
				+ Arrays.toString(placesInCompetitions) + ", extraCurricularPoints=" + extraCurricularPoints
				+ ", matchedPrograms=" + matchedPrograms + "]";
	}

	
}	//end of Student class