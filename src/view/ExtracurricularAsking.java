/*
 * Name: Sylvia
 * Date: 2021/12/16
 * Title: Post-secondary App, ExtracurricularAsking
 * Description: This class sets up the extracurricular asking frame asking users if they have participated
 * in any competitions
 * Features: get answers from users and act accordingly, go back to previous screen
 * Major Skills: GUI, ActionListener
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.MainController;
import controller.MatchingController;

public class ExtracurricularAsking extends JFrame implements ActionListener{
	
	private JButton yesButton =new JButton("Yes (^ - ^)");
	private JButton noButton =new JButton("NO (T_T)");
	private JButton backButton = new JButton("Back");
	private JLabel label;
	
	ExtracurricularAsking (){
		
		//set frame
		setTitle("UniMatch - Find Your Future");
		setSize(1600,800);  
		getContentPane().setBackground(new Color(209,179,255));
        setLayout(null);  
        setVisible(true);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //set label
        label = new JLabel("Have you participated in any competitions?");            
        label.setBounds(80,200,1253,63); 
        //label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Roboto", Font.BOLD, 54));
        add(label);
        
        //set buttons         
        yesButton.setBounds(250,500,300,63);  
        yesButton.setHorizontalAlignment(JButton.CENTER);
        yesButton.setFont(new Font("Roboto", Font.BOLD, 38));
        yesButton.addActionListener(this); 
        add(yesButton);
        
        noButton.setBounds(800,500,300,63);  
        noButton.setHorizontalAlignment(JButton.CENTER);
        noButton.setFont(new Font("Roboto", Font.BOLD, 38));
        noButton.addActionListener(this); 
        add(noButton);
        
        backButton.setBounds(600,600,150,63);  
        backButton.setHorizontalAlignment(JButton.CENTER);
        backButton.setFont(new Font("Roboto", Font.BOLD, 38));
        backButton.addActionListener(this); 
        add(backButton);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==yesButton)
		{
			dispose();
			new ExtracurricularCompetitionInfo();
			
		}
		if (e.getSource()==noButton)
		{
			dispose();
			MatchingController.findMatches();
		}
		if (e.getSource()==backButton)
		{
			dispose();
			new ExtracurricularCategories();
		}
	}
	
	public JButton getYesButton() {
		return yesButton;
	}
	public void setYesButton(JButton yesButton) {
		this.yesButton = yesButton;
	}
	public JButton getNoButton() {
		return noButton;
	}
	public void setNoButton(JButton noButton) {
		this.noButton = noButton;
	}
	public JButton getBackButton() {
		return backButton;
	}
	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}
	public JLabel getLabel() {
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
	}

	
}
