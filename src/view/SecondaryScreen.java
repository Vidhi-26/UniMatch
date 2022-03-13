package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import controller.MainController;
import model.Student;

/**
 * This class is an extension from the Initial Screen, 
 * which gets called during the button selection
 * 
 * @author johnselvin
 */
public class SecondaryScreen {

	private JFrame frmSecondaryScreen;

	/**
	 * Create the application.
	 */
	public SecondaryScreen() {
		setup();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void setup() {
		frmSecondaryScreen = new JFrame();
		frmSecondaryScreen.getContentPane().setBackground(new Color(240, 230, 255));
		frmSecondaryScreen.setTitle("UniMatch - Find Your Future");
		frmSecondaryScreen.setBounds(100, 100, 1600, 800);
		frmSecondaryScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSecondaryScreen.getContentPane().setLayout(null);
		frmSecondaryScreen.setVisible(true);

		JButton btnBackButton = new JButton("Back");
		btnBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnBackButton) {
					frmSecondaryScreen.setVisible(false);
					new InitialScreen();
				}
			}
		});
		btnBackButton.setBounds(6, 6, 148, 55);
		frmSecondaryScreen.getContentPane().add(btnBackButton);

		JButton btnYes = new JButton("Yes");
		btnYes.setBackground(new Color(51, 255, 255));
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student temp = MainController.getStudent();
				temp.setAnswer(1);
				MainController.setStudent(temp);
				frmSecondaryScreen.setVisible(false);
				new CourseDialog().setVisible(true);;
			}
		});
		btnYes.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnYes.setBounds(942, 22, 485, 349);
		frmSecondaryScreen.getContentPane().add(btnYes);

		// 'No' selection button
		JButton btnNo = new JButton("No");
		btnNo.setFont(new Font("Roboto", Font.PLAIN, 16));
		btnNo.setBounds(942, 407, 485, 359);
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student temp = MainController.getStudent();
				temp.setAnswer(2);
				MainController.setStudent(temp);
				frmSecondaryScreen.setVisible(false);
				new CourseDialog().setVisible(true);
			}
		});
		frmSecondaryScreen.getContentPane().add(btnNo);

		// Display question in a JTextArea
		JTextArea txtrDoYouLike = new JTextArea();
		txtrDoYouLike.setText(
				"                    \n\n\n Do you like to design or build projects \n    (e.g. machinery, robots, circuits)?");
		txtrDoYouLike.setFont(new Font("Roboto", Font.PLAIN, 20));
		txtrDoYouLike.setEditable(false);
		txtrDoYouLike.setBackground(new Color(204, 204, 255));
		txtrDoYouLike.setBounds(136, 236, 375, 219);
		frmSecondaryScreen.getContentPane().add(txtrDoYouLike);
		
		
		//yes --> answer = 1
		//no  --> answer = 2
	}
}