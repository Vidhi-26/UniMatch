package view;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.text.PlainDocument;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;
import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * Name: Sutavin Vinothan
 * Date: December 16, 2021
 * Description:Login Panel that allows username and password input
 * Also includes a register and forget password button
 */
public class LoginPanel extends JPanel {
		
	//label fields
	JLabel heading_label = new JLabel("Login");
	JLabel user_label = new JLabel("Username:");
	JLabel password_label = new JLabel("Password:");
	JLabel logo = new JLabel(new ImageIcon("images/UniMatch200.png"));
	
	// Text Field
	JTextField userName_text = new JTextField();
	
	//Text area
	JTextArea message_area = new JTextArea("");
	
	// Password Field
	JPasswordField password_text = new JPasswordField();
	
	//Button Fields
	JButton register = new JButton("REGISTER");  
	JButton submit = new JButton("SUBMIT");  
	JButton forgot_password = new JButton("Forgot Password ?");  
	
	JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
	
	//Constructor Methjod
	public LoginPanel() {
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		this.setBorder(blackline);
		setupLoginScreen();

	}

	//Setters and Getters
	public JLabel getHeading_label() {
		return heading_label;
	}

	public void setHeading_label(JLabel heading_label) {
		this.heading_label = heading_label;
	}

	public JLabel getUser_label() {
		return user_label;
	}

	public void setUser_label(JLabel user_label) {
		this.user_label = user_label;
	}

	public JLabel getPassword_label() {
		return password_label;
	}

	public void setPassword_label(JLabel password_label) {
		this.password_label = password_label;
	}

	public JLabel getLogo() {
		return logo;
	}

	public void setLogo(JLabel logo) {
		this.logo = logo;
	}

	public JTextField getUserName_text() {
		return userName_text;
	}

	public void setUserName_text(JTextField userName_text) {
		this.userName_text = userName_text;
	}

	public JTextArea getMessage_area() {
		return message_area;
	}

	public void setMessage_area(JTextArea message_area) {
		this.message_area = message_area;
	}

	public JPasswordField getPassword_text() {
		return password_text;
	}

	public void setPassword_text(JPasswordField password_text) {
		this.password_text = password_text;
	}

	public JButton getRegister() {
		return register;
	}

	public void setRegister(JButton register) {
		this.register = register;
	}

	public JButton getSubmit() {
		return submit;
	}

	public void setSubmit(JButton submit) {
		this.submit = submit;
	}

	public JButton getForgot_password() {
		return forgot_password;
	}

	public void setForgot_password(JButton forgot_password) {
		this.forgot_password = forgot_password;
	}

	public JFrame getTopFrame() {
		return topFrame;
	}

	public void setTopFrame(JFrame topFrame) {
		this.topFrame = topFrame;
	}

	//Set up the screen
	private void setupLoginScreen() {
		
		  setLayout(null);
		  
		  //Logo and Heading 
		  logo.setBounds(0, 1, 200, 200);
		  heading_label.setFont(new Font("Roboto", Font.BOLD,50));
		  heading_label.setForeground(Color.BLACK);
		  heading_label.setBounds(650, 100, 300, 100);
		  
		  //Username and Password labels
		  user_label.setBounds(520, 300, 300, 30);
		  user_label.setFont(new Font("Roboto", Font.BOLD,35));
	      password_label.setBounds(520, 340, 300, 50);
		  password_label.setFont(new Font("Roboto", Font.BOLD,35));

		  //Username and password text boxes
	      userName_text.setBounds(735, 300, 150, 25);
	      userName_text.setSize(200, 35);
	      password_text.setBounds(735, 350, 150, 25);
	      password_text.setSize(200, 35);

		   // Register
	      register.setBounds(570, 500, 150, 35);     

	      // Submit
	      submit.setBounds(740, 500, 150, 35);
	      
	      // forgot password
	      forgot_password.setBounds(630, 650, 200, 35);
	      
	      //Message Label
	      message_area.setFont(new Font("Serif", Font.ITALIC, 15));
	      message_area.setForeground(Color.RED);
	      message_area.setOpaque(false);
	      message_area.setBounds(600, 460, 300, 80);   
	      
	      //Add to the panel
	      add(logo);
	      add(heading_label);
	      add(user_label);
	      add(userName_text);
	      add(password_label);
	      add(password_text);
	      add(register);
	      add(submit);
	      add(forgot_password);
	      add(message_area);
		
	}
	
	//Gradient background method
	@Override
    protected void paintComponent(Graphics g) {
		
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
        int w = getWidth();
        int h = getHeight();
        
        Color color1 = new Color(240, 230, 255);
        Color color2 = new Color(163, 102, 255);
        
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
        
    }

}
