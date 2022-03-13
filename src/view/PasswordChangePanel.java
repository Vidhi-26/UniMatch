package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
/*
 * Name: Sutavin Vinothan
 * Date: December 16, 2021
 * Course: ICS4U1-02 Mr. Fernandes
 * Description:Password change panels that allows input for username,
 * password and confirm password
 */
public class PasswordChangePanel extends JPanel {
	
	
// label
JLabel heading_label = new JLabel("Password Change");
JLabel user_label = new JLabel("Username:");
JLabel password_label = new JLabel("New Password:");
JLabel confirm_label = new JLabel("Confirm Password:");
JTextArea message_area = new JTextArea("");
JLabel logo = new JLabel(new ImageIcon("images/UniMatch200.png"));

// Text Field
JTextField userName_text = new JTextField();

// Password Field
JPasswordField password_text = new JPasswordField();
JPasswordField confirm_text = new JPasswordField();

//
JButton save = new JButton("SAVE");  
JButton cancel = new JButton("Cancel");  
//JButton forgot_password = new JButton("Forgot Password ?");  	

	public PasswordChangePanel() {
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		this.setBorder(blackline);
		setupPasswordChangeScreen();
	}

	
	
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



	public JLabel getConfirm_label() {
		return confirm_label;
	}



	public void setConfirm_label(JLabel confPasswd_label) {
		this.confirm_label = confPasswd_label;
	}



	public JTextArea getMessage_area() {
		return message_area;
	}



	public void setMessage_area(JTextArea message_area) {
		this.message_area = message_area;
	}



	public JTextField getUserName_text() {
		return userName_text;
	}



	public void setUserName_text(JTextField userName_text) {
		this.userName_text = userName_text;
	}



	public JPasswordField getPassword_text() {
		return password_text;
	}



	public void setPassword_text(JPasswordField password_text) {
		this.password_text = password_text;
	}



	public JPasswordField getConfirm_text() {
		return confirm_text;
	}



	public void setConfirm_text(JPasswordField confPasswd_text) {
		this.confirm_text = confPasswd_text;
	}



	public JButton getSave() {
		return save;
	}



	public void setSave(JButton save) {
		this.save = save;
	}



	public JButton getCancel() {
		return cancel;
	}



	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}



	private void setupPasswordChangeScreen() {
		
		  setLayout(null);
		  
		  logo.setBounds(665, 25, 200, 200);
		  heading_label.setFont(new Font("Serif", Font.BOLD,50));
		  heading_label.setForeground(Color.BLACK);
		  heading_label.setBounds(625, 200, 500, 100);
	      
		  user_label.setBounds(600, 300, 300, 25);
		  user_label.setFont(new Font("Serif", Font.BOLD,35));
	      password_label.setBounds(535, 340, 300, 50);
		  password_label.setFont(new Font("Serif", Font.BOLD,35));
	      confirm_label.setBounds(475, 380, 300, 50);
	     confirm_label.setFont(new Font("Serif", Font.BOLD,35));
	      
	      userName_text.setBounds(775, 300, 150, 30);
	      userName_text.setSize(200, 35);
	      password_text.setBounds(775, 350, 150, 25);
	      password_text.setSize(200, 35);
	      confirm_text.setBounds(775, 390, 150, 25);
	      confirm_text.setSize(200, 35);
	      
	      save.setBounds(620, 450, 150, 35);   
	      
	      // Cancel
	      cancel.setBounds(790, 450, 150, 35);
	      	      
	      //Message Label
	      message_area.setFont(new Font("Serif", Font.ITALIC, 15));
	      message_area.setForeground(Color.RED);
	      message_area.setOpaque(false);
	      message_area.setBounds(650, 500, 300, 80);     
	      
	      add(logo);
	      add(heading_label);
	      add(user_label);
	      add(userName_text);
	      add(password_label);
	      add(password_text);
	      add(confirm_label);
	      add(confirm_text);

	      add(save);
	      add(cancel);
	      add(message_area);

	      
	      //setVisible(true);

		
	}
	
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