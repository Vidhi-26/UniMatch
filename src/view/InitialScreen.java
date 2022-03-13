package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

/**
 * This class is the initial screen which will give the user two
 * button options to choose, and each button will take them to it's
 * respected screens. 
 * 
 * @author johnselvin
 */
public class InitialScreen {

	private JFrame frmUnimatchInitialScreen;

	/**
	 * Create the application.
	 */
	public InitialScreen() {
		setup();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void setup() {
		frmUnimatchInitialScreen = new JFrame();
		frmUnimatchInitialScreen.getContentPane().setBackground(new Color(240, 230, 255));
		frmUnimatchInitialScreen.setBackground(new Color(209, 179, 255));
		frmUnimatchInitialScreen.setTitle("UniMatch - Find Your Future");
		frmUnimatchInitialScreen.setBounds(100, 100, 1600, 800);
		frmUnimatchInitialScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUnimatchInitialScreen.getContentPane().setLayout(null);
		frmUnimatchInitialScreen.setVisible(true);

		JButton btnNewButton = new JButton("Outdoors (Factories, indsutrial, worksites...)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton) {
					frmUnimatchInitialScreen.setVisible(false);
					new SecondaryScreen();
				}
			}
		});
		btnNewButton.setFont(new Font("Roboto", Font.PLAIN, 20));
		btnNewButton.setBounds(888, 389, 528, 377);
		frmUnimatchInitialScreen.getContentPane().add(btnNewButton);

		// Button selection which will take user to the tertiary screen
		JButton btnIndoorsofficesLaboratories = new JButton("Indoors (Offices, Laboratories, Home...)");
		btnIndoorsofficesLaboratories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnIndoorsofficesLaboratories) {
					frmUnimatchInitialScreen.setVisible(false);
					new TertiaryScreen();
				}
			}
		});
		btnIndoorsofficesLaboratories.setFont(new Font("Roboto", Font.PLAIN, 20));
		btnIndoorsofficesLaboratories.setBounds(888, 6, 528, 364);
		frmUnimatchInitialScreen.getContentPane().add(btnIndoorsofficesLaboratories);

		// Back button
		JButton btnBackButton = new JButton("Back");
		btnBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnBackButton) {
					frmUnimatchInitialScreen.setVisible(false);
					new HomeScreenFrame();
				}
			}
		});
		btnBackButton.setBounds(6, 6, 148, 55);
		frmUnimatchInitialScreen.getContentPane().add(btnBackButton);

		// Display question in a JTextArea
		JTextArea txtrQuestion = new JTextArea();
		txtrQuestion.setBackground(new Color(204, 204, 255));
		txtrQuestion.setEditable(false);
		txtrQuestion.setFont(new Font("Roboto", Font.PLAIN, 20));
		txtrQuestion.setText("                    \n\n\n     What is your ideal work environment?");
		txtrQuestion.setBounds(145, 281, 423, 169);
		frmUnimatchInitialScreen.getContentPane().add(txtrQuestion);

	}
}