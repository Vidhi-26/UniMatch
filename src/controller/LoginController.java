package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Student;
import view.HomeScreenFrame;
import view.LoginFrame;

/*
 * Name: Sutavin Vinothan
 * Date: December 16, 2021
 * Course: ICS4U1-02 Mr. Fernandes
 * Description:Login Controllers that handles all the button functionalities as well as
 * the message popups, confirmations, and many other features
 */
public class LoginController implements ActionListener, MouseListener {

	LoginFrame loginframe = new LoginFrame();
	UserController fileController = new UserController();

	public LoginController() {

		// Add listeners
		loginframe.getLoginPanel().getRegister().addActionListener(this);
		loginframe.getLoginPanel().getSubmit().addActionListener(this);
		loginframe.getLoginPanel().getForgot_password().addActionListener(this);

		loginframe.getRegisterPanel().getCancel().addActionListener(this);
		loginframe.getRegisterPanel().getSave().addActionListener(this);

		loginframe.getPasswordChangePanel().getCancel().addActionListener(this);
		loginframe.getPasswordChangePanel().getSave().addActionListener(this);

		setAllPanelsInVisible();
		loginframe.getLoginPanel().setVisible(true);


		String filepath = "Files/Users.txt";

		String userDetails = "Sutavin1,Sutavin123,12";
		String userName = "Sutavin2";
		String newPassword = "Sutavin567";
		String email = "abc@cd.com";

		//		fileController.writeIntoFile(userDetails);
		//		fileController.updateRecord(userName, newPassword);
		//		
		//		String password = fileController.retrievePassword(userName);
		//		System.out.println("UserName: " + userName + " Password: " + password);
		//		
		//		System.out.println("UserName: " + userName + " Exist?: " + fileController.isUserExist(userName, email));
		//		
		//		System.out.println("UserName: " + userName + " Authenticated?: " + fileController.isUserAuthenticated(userName, newPassword));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Click Register button
		if (e.getSource().equals(loginframe.getLoginPanel().getRegister())) {

			//JOptionPane.showMessageDialog(loginframe, "Register Pressed");

			loginframe.getLoginPanel().setVisible(false);
			loginframe.getRegisterPanel().setVisible(true);

		}
		else if (e.getSource().equals(loginframe.getRegisterPanel().getCancel())) {	//Register to Login Panel

			loginframe.getRegisterPanel().setVisible(false);
			loginframe.getLoginPanel().setVisible(true);
		}

		else if (e.getSource().equals(loginframe.getPasswordChangePanel().getCancel())) {	//Password change to Register Panel

			loginframe.getPasswordChangePanel().setVisible(false);
			loginframe.getLoginPanel().setVisible(true);
		}
		// Login	
		else if (e.getSource().equals(loginframe.getLoginPanel().getSubmit())) {

			String username = loginframe.getLoginPanel().getUserName_text().getText();
			char[] passwordArray = loginframe.getLoginPanel().getPassword_text().getPassword();
			StringBuffer password = new StringBuffer("");

			for (int i=0; i < passwordArray.length; i++) {
				password.append(passwordArray[i]);
			}

			if ( fileController.isUserAuthenticated(username, password.toString()) ) {

				setAllPanelsInVisible();	
				//Re-directed to home page
				//next page
				//loginframe.getRegisterPanel().setVisible(true);
				loginframe.dispose();
				new HomeScreenFrame();
			} else {
				loginframe.getLoginPanel().getMessage_area().setText("Username and/or Password not correct!");
			}

			// Click forgot password				
		} else if (e.getSource().equals(loginframe.getLoginPanel().getForgot_password())) {

			String username = loginframe.getLoginPanel().getUserName_text().getText();

			if (username.isEmpty()) {
				loginframe.getLoginPanel().getMessage_area().setText("Username is Empty!");

			} else {

				loginframe.getPasswordChangePanel().getUserName_text().setText(loginframe.getLoginPanel().getUserName_text().getText());

				setAllPanelsInVisible();			
				loginframe.getPasswordChangePanel().setVisible(true);
			}

		} 

		else if (e.getSource() == (loginframe.getRegisterPanel().getSave())) {

			String firstname = loginframe.getRegisterPanel().getFirst_name_text().getText();
			String lastname = loginframe.getRegisterPanel().getLast_name_text().getText();
			String userName = loginframe.getRegisterPanel().getUserName_text().getText();
			char[] passwordArray = loginframe.getRegisterPanel().getPassword_text().getPassword();
			StringBuffer password = new StringBuffer("");
			String street = loginframe.getRegisterPanel().getStreet_text().getText();
			String city = loginframe.getRegisterPanel().getCity_text().getText();
			String postal = loginframe.getRegisterPanel().getPostal_text().getText();

			if(isInputValid()) {

				StringBuffer userDetails = new StringBuffer("");

				userDetails.append(firstname + ",");
				userDetails.append(lastname + ",");
				userDetails.append(userName + ",");
				userDetails.append(street + ",");
				userDetails.append(city + ",");
				userDetails.append(postal);

				for (int i=0; i < passwordArray.length; i++) {
					password.append(passwordArray[i]);
				}
				
				fileController.writeIntoFile(userDetails.toString());	//save to Users.txt
				fileController.savePassword(userName, password.toString());	//save to password.txt
				
				// Create student object and add into StudentList
				Student student = MainController.getStudent();
				
				student.setFirstName(firstname);
				student.setLastName(lastname);
				student.setUsername(userName);
				student.setStreet(street);
				student.setCity(city);
				student.setPostalCode(postal);
				
				UserController.studentList.add(student);
				
				MainController.setStudent(student);
				
				// Add student course-marks
				addStudentmarks();
				
				// Add Extra Curr for students
				addExtraCurr();
				
				MainController.setStudent(student);
				
				// Re-direct to login screen
				setAllPanelsInVisible();
				loginframe.getLoginPanel().setVisible(true);

			} 
			
			System.out.println("StudentList size: " + UserController.studentList.size() );
			

		} 

		//Password change save button
else if (e.getSource().equals(loginframe.getPasswordChangePanel().getSave())) {	 	
			
	//convert entered items to strings
			StringBuffer message = new StringBuffer("");	
			String userName = loginframe.getPasswordChangePanel().getUserName_text().getText();
			char[] newPasswordArray = loginframe.getPasswordChangePanel().getPassword_text().getPassword();
			char[] confPasswordArray = loginframe.getPasswordChangePanel().getConfirm_text().getPassword();
			
			StringBuffer newPassword = new StringBuffer("");
			StringBuffer confirmPassword = new StringBuffer("");

			for (int i=0; i < newPasswordArray.length; i++) {
				newPassword.append(newPasswordArray[i]);
			}
			for (int i=0; i < confPasswordArray.length; i++) {
				confirmPassword.append(confPasswordArray[i]);
			}
			
			if (newPasswordArray.length == 0) {
				loginframe.getPasswordChangePanel().getMessage_area().setText("Password is empty!");
			} else if (newPasswordArray.length < 8) {
				loginframe.getPasswordChangePanel().getMessage_area().setText("Password must be atleast 8 charactors long!");
			} else if (!newPassword.toString().equals(confirmPassword.toString())) {
				loginframe.getPasswordChangePanel().getMessage_area().setText("Confirm password mismatch!");
			} else {
					
				if(!fileController.isUserExist(userName)) {
					loginframe.getPasswordChangePanel().getMessage_area().setText("Username not exist!");
				} else {
					fileController.updatePassword(userName, newPassword.toString());
					loginframe.getLoginPanel().getMessage_area().setText("Password changed successfully");
					
					// Re-direct to login screen
					setAllPanelsInVisible();
					loginframe.getLoginPanel().setVisible(true);
					
				}
			}
		}
	}
	//Check if an input is invalid
	private boolean isInputValid() {

		boolean isValid = true;
		StringBuffer message = new StringBuffer("");	

		String firstname = loginframe.getRegisterPanel().getFirst_name_text().getText();
		String lastname = loginframe.getRegisterPanel().getLast_name_text().getText();
		String userName = loginframe.getRegisterPanel().getUserName_text().getText();
		char[] passwordArray = loginframe.getRegisterPanel().getPassword_text().getPassword();
		char[] confPasswordArray = loginframe.getRegisterPanel().getConfirm_text().getPassword();
		StringBuffer password = new StringBuffer("");
		StringBuffer confPassword = new StringBuffer("");
		String street = loginframe.getRegisterPanel().getStreet_text().getText();
		String city = loginframe.getRegisterPanel().getCity_text().getText();
		String postal = loginframe.getRegisterPanel().getPostal_text().getText();

		for (int i=0; i < passwordArray.length; i++) {
			password.append(passwordArray[i]);
		}
		for (int i=0; i < confPasswordArray.length; i++) {
			confPassword.append(confPasswordArray[i]);
		}
		
		if (firstname.isEmpty()) {
			message.append("First Name is empty!\n");
			isValid = false;

		}
		if(lastname.isEmpty()) {
			message.append("Last Name is empty!\n");
			isValid = false;
		}
		if (userName.isEmpty()) {
			message.append("Username is empty!\n");
			isValid = false;
		} else {

			if(fileController.isUserExist(userName)) {
				message.append("Username already exist!\n");
				isValid = false;
			}
		}

		if (passwordArray.length == 0) {
			message.append("Password is empty!\n");
			isValid = false;
		} else if (passwordArray.length < 8) {
			message.append("Password must be atleast 8 charactors long!\n");
			isValid = false;
		} else if (!password.toString().equals(confPassword.toString())) {
			message.append("Confirm password mismatch!\n");	
			isValid = false;
		}
		
		if(street.isEmpty()) {
			message.append("Street is empty!\n");
			isValid = false;
		}
		if(city.isEmpty()) {
			message.append("City is empty!\n");
			isValid = false;
		}
		if(postal.isEmpty()) {
			message.append("Postal Code is empty!\n");
			isValid = false;
		}

		loginframe.getRegisterPanel().getMessage_area().setText(message.toString());		

		return isValid;

	}

	//method to set all panels invisible
	private void setAllPanelsInVisible() {
		loginframe.getLoginPanel().setVisible(false);
		loginframe.getRegisterPanel().setVisible(false);
		loginframe.getPasswordChangePanel().setVisible(false);
	}

	//method to add student courses and marks to txt file
	private void addStudentmarks() {
		
		System.out.println("HERE NOE?");
		
		// Get username from home screen
		String userName = loginframe.getRegisterPanel().getUserName_text().getText();
		double total = 0;
		double average = 0;
		String[] coursesTaken = new String[6];
		double[] marksInCourses= new double[6];
		
		// Add course-marks for the specific student in the studentList
		for (Student student: UserController.studentList) {
			
			if(student.getUsername().equals(userName)) {
				
				if(fileController.checkReturningUser(student)) {
					System.out.println("HEREREEEEEEE");
					break;
				}
				
				// Get all six course index and marks from home screen

				for (int i=0; i < coursesTaken.length; i++) {
					System.out.println("HEREREEEEEEE!!!!!!!!");
					coursesTaken[i] = "Course" + (i+1);
					marksInCourses[i] = 90.5 + i;
					
					total += marksInCourses[i];
				}
				
				average = (double)total / coursesTaken.length;
				
				student.setCoursesTaken(coursesTaken);
				student.setMarksInCourses(marksInCourses);
				MainController.setStudent(student);
				break;
			}
		}
		
		// Save course-marks in the courseMarks.txt file
		fileController.saveCourseMarks(userName, coursesTaken, marksInCourses, average);

	}
	
	//add extracurriculars to the student
	private void addExtraCurr() {
		
		// Get username from home screen
		String userName = loginframe.getRegisterPanel().getUserName_text().getText();
		
		// Get all eight extra curr from home screen
		boolean[] extracurricularsDone = new boolean[8];
		int[] placeInExtraCurricular = new int[8];

		for (int i=0; i < extracurricularsDone.length; i++) {
			
			extracurricularsDone[i] = true;
			placeInExtraCurricular[i] = i;
			
		}	
		
		// Add extra curr for the specific student in the studentList
		for (Student student: UserController.studentList) {
			
			if(student.getUsername().equals(userName)) {
				student.setExtracurricularsDone(extracurricularsDone);
				student.setPlacesInCompetitions(placeInExtraCurricular);
				MainController.setStudent(student);
				break;
			}
		}
		
		// Save extra curr in the courseMarks.txt file
		fileController.saveExtraCurr(userName, extracurricularsDone, placeInExtraCurricular);

	}
	
}