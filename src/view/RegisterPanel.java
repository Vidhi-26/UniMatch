package view;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;


public class RegisterPanel extends JPanel {
		
	// label
	JLabel heading_label = new JLabel("Register");
	JLabel first_name_label = new JLabel("First Name: ");
	JLabel last_name_label = new JLabel("Last Name: ");
	JLabel user_label = new JLabel("Username:");
	JLabel password_label = new JLabel("Password:");
	JLabel confirm_label = new JLabel("Confirm Password:");
	JLabel street_label = new JLabel("Street: ");
	JLabel city_label = new JLabel("City: ");
	JLabel postal_label = new JLabel("Postal Code: ");
	
	// Text Field
	JTextField first_name_text = new JTextField();
	JTextField last_name_text = new JTextField();
	JTextField userName_text = new JTextField();
	JPasswordField password_text = new JPasswordField();
	JPasswordField confirm_text = new JPasswordField();
	JTextField street_text = new JTextField();
	JTextField city_text = new JTextField();
	JTextField postal_text = new JTextField();

	//Text area
	JTextArea message_area = new JTextArea("");
	
	//
	JButton save = new JButton("SAVE");  
	JButton cancel = new JButton("Cancel");  
	//JButton forgot_password = new JButton("Forgot Password ?");  
	
	JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
	
	public RegisterPanel() {
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		this.setBorder(blackline);
		setupRegisterScreen();

		// TODO Auto-generated constructor stub
	}

	private void setupRegisterScreen() {
		
		  setLayout(null);
		  
		  
		  heading_label.setFont(new Font("Roboto", Font.BOLD, 30));
		  heading_label.setForeground(Color.BLACK);
		  heading_label.setBounds(700, 50, 150, 50);
		  
		  //Labels
	      first_name_label.setBounds(600, 120, 100, 25);
	      last_name_label.setBounds(800, 120, 100, 25);
	      user_label.setBounds(500, 240, 100, 25);
		  password_label.setBounds(700, 240, 100, 25);
		  confirm_label.setBounds(900, 240, 115, 25);
	      street_label.setBounds(500, 360, 100, 25);
	      city_label.setBounds(700, 360, 100, 25);
	      postal_label.setBounds(900, 360, 100, 25);
	      
	      //Text boxes
	      first_name_text.setBounds(600, 140, 150, 25);
	      last_name_text.setBounds(800, 140, 150, 25);
	      userName_text.setBounds(500, 260, 150, 25);
	      password_text.setBounds(700, 260, 150, 25);
	      confirm_text.setBounds(900, 260, 150, 25);
	      street_text.setBounds(500, 380, 150, 25);
	      city_text.setBounds(700, 380, 150, 25);
	      postal_text.setBounds(900, 380, 150, 25);
	      
		  //  Save
	      save.setBounds(625, 480, 100, 25);     
	      
	      // Cancel
	      cancel.setBounds(825, 480, 100, 25);
	      	      
	      //Message Label
	      message_area.setFont(new Font("Serif", Font.ITALIC, 15));
	      message_area.setForeground(Color.RED);
	      message_area.setOpaque(false);
	      message_area.setBounds(725,550, 500, 500);     
	      
	      add(heading_label);
	      add(save);
	      add(cancel);
	      add(message_area);
	      
	      add(first_name_label);
	      add(last_name_label);
	      add(user_label);
	      add(password_label);
	      add(confirm_label);
	      add(street_label);
	      add(city_label);
	      add(postal_label);
	      
	      add(first_name_text);
	      add(last_name_text);
	      add(userName_text);
	      add(password_text);
	      add(confirm_text);
	      add(street_text);
	      add(city_text);
	      add(postal_text);

	      //setVisible(true);

		
	}

	public JLabel getHeading_label() {
		return heading_label;
	}

	public void setHeading_label(JLabel heading_label) {
		this.heading_label = heading_label;
	}

	public JLabel getFirst_name_label() {
		return first_name_label;
	}

	public void setFirst_name_label(JLabel first_name_label) {
		this.first_name_label = first_name_label;
	}

	public JLabel getLast_name_label() {
		return last_name_label;
	}

	public void setLast_name_label(JLabel last_name_label) {
		this.last_name_label = last_name_label;
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

	public void setConfirm_label(JLabel confirm_label) {
		this.confirm_label = confirm_label;
	}

	public JLabel getStreet_label() {
		return street_label;
	}

	public void setStreet_label(JLabel street_label) {
		this.street_label = street_label;
	}

	public JLabel getCity_label() {
		return city_label;
	}

	public void setCity_label(JLabel city_label) {
		this.city_label = city_label;
	}

	public JLabel getPostal_label() {
		return postal_label;
	}

	public void setPostal_label(JLabel postal_label) {
		this.postal_label = postal_label;
	}

	public JTextField getFirst_name_text() {
		return first_name_text;
	}

	public void setFirst_name_text(JTextField first_name_text) {
		this.first_name_text = first_name_text;
	}

	public JTextField getLast_name_text() {
		return last_name_text;
	}

	public void setLast_name_text(JTextField last_name_text) {
		this.last_name_text = last_name_text;
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

	public void setConfirm_text(JPasswordField confirm_text) {
		this.confirm_text = confirm_text;
	}

	public JTextField getStreet_text() {
		return street_text;
	}

	public void setStreet_text(JTextField street_text) {
		this.street_text = street_text;
	}

	public JTextField getCity_text() {
		return city_text;
	}

	public void setCity_text(JTextField city_text) {
		this.city_text = city_text;
	}

	public JTextField getPostal_text() {
		return postal_text;
	}

	public void setPostal_text(JTextField postal_text) {
		this.postal_text = postal_text;
	}

	public JTextArea getMessage_area() {
		return message_area;
	}

	public void setMessage_area(JTextArea message_area) {
		this.message_area = message_area;
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

	public JFrame getTopFrame() {
		return topFrame;
	}

	public void setTopFrame(JFrame topFrame) {
		this.topFrame = topFrame;
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

	

	

//	@Override
//	public void actionPerformed(ActionEvent e) {
//				
//		if (e.getSource().equals(this.register)) {
//		
//			JOptionPane.showMessageDialog(topFrame, "Register Pressed");
//		}
//	}
}