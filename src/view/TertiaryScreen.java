package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import controller.MainController;
import controller.MatchingController;
import model.Student;

/**
 * This class is an extension from the Initial Screen, 
 * which gets called during the button selection
 * 
 * @author johnselvin
 */
public class TertiaryScreen {

	private JFrame frmUnimatchTertiaryScreen;
	private JButton btnYes;
	private JButton btnNo;

	/**
	 * Create the application.
	 */
	public TertiaryScreen() {
		setup();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void setup() {
		frmUnimatchTertiaryScreen = new JFrame();
		frmUnimatchTertiaryScreen.setTitle("UniMatch - Find Your Future");
		frmUnimatchTertiaryScreen.getContentPane().setBackground(new Color(240, 230, 255));
		frmUnimatchTertiaryScreen.getContentPane().setLayout(null);
		frmUnimatchTertiaryScreen.setBounds(100, 100, 1600, 800);
		frmUnimatchTertiaryScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUnimatchTertiaryScreen.setVisible(true);

		JButton btnBackButton = new JButton("Back");
		btnBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnBackButton) {
					frmUnimatchTertiaryScreen.setVisible(false);
					new InitialScreen();
				}
			}
		});

		btnBackButton.setBounds(6, 6, 150, 55);
		frmUnimatchTertiaryScreen.getContentPane().add(btnBackButton);
		
		btnYes = new JButton("Yes");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student temp = MainController.getStudent();
				temp.setAnswer(3);
				MainController.setStudent(temp);
				frmUnimatchTertiaryScreen.setVisible(false);
				new CourseDialog().setVisible(true);
			}
		});
		btnYes.setFont(new Font("Roboto", Font.PLAIN, 30));
		btnYes.setBounds(969, 6, 463, 368);
		frmUnimatchTertiaryScreen.getContentPane().add(btnYes);
		
		btnNo = new JButton("No");
		btnNo.setFont(new Font("Roboto", Font.PLAIN, 30));
		btnNo.setBounds(969, 398, 463, 368);
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student temp = MainController.getStudent();
				temp.setAnswer(4);
				MainController.setStudent(temp);
				frmUnimatchTertiaryScreen.setVisible(false);
				new CourseDialog().setVisible(true);
			}
		});
		frmUnimatchTertiaryScreen.getContentPane().add(btnNo);
		
		JTextArea txtrDoYouLike_1 = new JTextArea();
		txtrDoYouLike_1.setText("                    \n\n\n        Do you like to design or program? \n(coding apps, AI development, UI/UX design...)");
		txtrDoYouLike_1.setFont(new Font("Roboto", Font.PLAIN, 20));
		txtrDoYouLike_1.setEditable(false);
		txtrDoYouLike_1.setBackground(new Color(204, 204, 255));
		txtrDoYouLike_1.setBounds(158, 279, 453, 219);
		frmUnimatchTertiaryScreen.getContentPane().add(txtrDoYouLike_1);

	}
	

	public JButton getBtnYes() {
		return btnYes;
	}

	public void setBtnYes(JButton btnYes) {
		this.btnYes = btnYes;
	}

	public JButton getBtnNo() {
		return btnNo;
	}

	public void setBtnNo(JButton btnNo) {
		this.btnNo = btnNo;
	}
	
	//yes --> answer = 3
	//no  --> answer = 4

}