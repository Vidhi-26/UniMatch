package view;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

/*
 * Name: Sutavin Vinothan
 * Date: December 16, 2021
 * Course: ICS4U1-02 Mr. Fernandes
 * Description:Login frame that holds the Login Panel, RegisterPanel, and Change Password Panel
 */
public class LoginFrame extends JFrame {

	//Fields for the panels
	private LoginPanel loginPanel = new LoginPanel();
	private RegisterPanel registerPanel= new RegisterPanel();
	private PasswordChangePanel passwordChangePanel= new PasswordChangePanel();

	//Constructor method
	public LoginFrame() throws HeadlessException {

		//Login Frame sizes and visibility
		setTitle("UniMatch - Find Your Future");
		setLayout(null);
		setSize(1600,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		//Login Panel Size
		loginPanel.setBounds(0, 0, 1600,800);
		add(loginPanel);

		//Register Panel Size
		registerPanel.setBounds(0, 0, 1600, 800);
		add(registerPanel);

		//Password Change Panel Size
		passwordChangePanel.setBounds(0, 0, 1600,800);
		add(passwordChangePanel);	


	}

	//Setters and Getters
	public LoginPanel getLoginPanel() {
		return loginPanel;
	}
	public void setLoginPanel(LoginPanel loginPanel) {
		this.loginPanel = loginPanel;
	}
	public RegisterPanel getRegisterPanel() {
		return registerPanel;
	}
	public void setRegisterPanel(RegisterPanel registerPanel) {
		this.registerPanel = registerPanel;
	}
	public PasswordChangePanel getPasswordChangePanel() {
		return passwordChangePanel;
	}
	public void setPasswordChangePanel(PasswordChangePanel passwordChangePanel) {
		this.passwordChangePanel = passwordChangePanel;
	}

}