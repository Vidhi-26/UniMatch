package view;
/*
 * Group #1
 * Name: Sylvia
 * Date: 2021/12/16
 * Course: ICS4U1-01, Mr. Fernandes
 * Title: Post-secondary App, ExtracurricularCompetitionInfo
 * Description: This class sets up the extracurricular competition info frame allowing users to enter
 * up to 5 competitions
 * Features: get places in competitions, get names of competitions participated, calculate competition points
 * Major Skills: JComboBox, JTextField, GUI, ActionListener
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.MainController;
import controller.MatchingController;

import java.awt.*;
import javax.swing.*;

import model.Student;

public class ExtracurricularCompetitionInfo implements ActionListener{

	private JFrame frame = new JFrame ();
	private JButton addButton =new JButton("Add Another");
	private JButton finishButton =new JButton("Finish");
	private JComboBox comboBox1;
	private JComboBox comboBox2;
	private JComboBox comboBox3;
	private JComboBox comboBox4;
	private JComboBox comboBox5;
	private JTextField competitionName1;
	private JTextField competitionName2;
	private JTextField competitionName3;
	private JTextField competitionName4;
	private JTextField competitionName5;
	private JLabel placelabel1;
	private JLabel placelabel2;
	private JLabel placelabel3;
	private JLabel placelabel4;
	private JLabel placelabel5;
	private JLabel namelabel1;
	private JLabel namelabel2;
	private JLabel namelabel3;
	private JLabel namelabel4;
	private JLabel namelabel5;
	//Create a String array storing places in competition 
	private String places[] = {"1","2","3","Other"}; 
	
	public ExtracurricularCompetitionInfo() {
		
		//frame
		frame.setTitle("UniMatch - Find Your Future");
		frame.setSize(1600,800);  
		frame.getContentPane().setBackground(new Color(209,179,255));
		frame.setLayout(null);  
		frame.setVisible(true);  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //competition name label
        namelabel1 = new JLabel("Competition Name:");            
        namelabel1.setBounds(100,70,500,50); 
        namelabel1.setFont(new Font("Roboto", Font.BOLD, 28));
        frame.add(namelabel1);
        namelabel2 = new JLabel("Competition Name:");            
        namelabel2.setBounds(100,210,500,50); 
        namelabel2.setFont(new Font("Roboto", Font.BOLD, 28));
        frame.add(namelabel2);
        namelabel3 = new JLabel("Competition Name:");            
        namelabel3.setBounds(100,350,500,50); 
        namelabel3.setFont(new Font("Roboto", Font.BOLD, 28));
        frame.add(namelabel3);
        namelabel4 = new JLabel("Competition Name:");            
        namelabel4.setBounds(100,490,500,50); 
        namelabel4.setFont(new Font("Roboto", Font.BOLD, 28));
        frame.add(namelabel4);
        namelabel5 = new JLabel("Competition Name:");            
        namelabel5.setBounds(100,630,500,50); 
        namelabel5.setFont(new Font("Roboto", Font.BOLD, 28));
        frame.add(namelabel5);
        
        //text field
        competitionName1 = new JTextField(); 
        competitionName1.setBounds(500,70,300,40);
        frame.add(competitionName1);
        competitionName2 = new JTextField(); 
        competitionName2.setBounds(500,210,300,40);
        frame.add(competitionName2);
        competitionName3 = new JTextField(); 
        competitionName3.setBounds(500,350,300,40);
        frame.add(competitionName3);
        competitionName4 = new JTextField(); 
        competitionName4.setBounds(500,490,300,40);
        frame.add(competitionName4);
        competitionName5 = new JTextField(); 
        competitionName5.setBounds(500,630,300,40);
        frame.add(competitionName5);
        
        //places label
        placelabel1 = new JLabel("Place in Competition:");            
        placelabel1.setBounds(100,140,800,50); 
        placelabel1.setFont(new Font("Roboto", Font.BOLD, 28));
        frame.add(placelabel1);
        placelabel2 = new JLabel("Place in Competition:");            
        placelabel2.setBounds(100,280,800,50); 
        placelabel2.setFont(new Font("Roboto", Font.BOLD, 28));
        frame.add(placelabel2);
        placelabel3 = new JLabel("Place in Competition:");            
        placelabel3.setBounds(100,420,800,50); 
        placelabel3.setFont(new Font("Roboto", Font.BOLD, 28));
        frame.add(placelabel3);
        placelabel4 = new JLabel("Place in Competition:");            
        placelabel4.setBounds(100,560,800,50); 
        placelabel4.setFont(new Font("Roboto", Font.BOLD, 28));
        frame.add(placelabel4);
        placelabel5 = new JLabel("Place in Competition:");            
        placelabel5.setBounds(100,700,800,50); 
        placelabel5.setFont(new Font("Roboto", Font.BOLD, 28));
        frame.add(placelabel5);
        
        
        //combo box
        comboBox1 = new JComboBox(places);
        comboBox1.setBounds(500,140,300,40);  
        comboBox1.setSelectedIndex(0);
        comboBox1.addActionListener(this); 
        frame.add(comboBox1);
        comboBox2 = new JComboBox(places);
        comboBox2.setBounds(500,280,300,40);  
        comboBox2.setSelectedIndex(0);
        comboBox2.addActionListener(this); 
        frame.add(comboBox2);
        comboBox3 = new JComboBox(places);
        comboBox3.setBounds(500,420,300,40);  
        comboBox3.setSelectedIndex(0);
        comboBox3.addActionListener(this); 
        frame.add(comboBox3);
        comboBox4 = new JComboBox(places);
        comboBox4.setBounds(500,560,300,40);  
        comboBox4.setSelectedIndex(0);
        comboBox4.addActionListener(this); 
        frame.add(comboBox4);
        comboBox5 = new JComboBox(places);
        comboBox5.setBounds(500,700,300,40);  
        comboBox5.setSelectedIndex(0);
        comboBox5.addActionListener(this); 
        frame.add(comboBox5);
        
        //set buttons         
//        addButton.setBounds(250,500,300,63);  
//        addButton.setFont(new Font("Roboto", Font.BOLD, 38));
//        addButton.addActionListener(this); 
//        frame.add(addButton);
        
        finishButton.setBounds(880,350,300,50);  
        finishButton.setFont(new Font("Roboto", Font.BOLD, 30));
        finishButton.addActionListener(this); 
        frame.add(finishButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//store in student profile
		Student student = MainController.getStudent();
		String [] temp = student.getCompetitionsParticipated();
//		//if click Add Another
//		if (e.getSource()==addButton) {
//			//store info in user profile
//			temp[0] = competitionName.getText();
//			//add another
//			frame.dispose();
//			//ExtracurricularCompetitionInfo newWindow = new ExtracurricularCompetitionInfo();
//			//newWindow.setVisible(true);
//			new ExtracurricularCompetitionInfo();
//		}
		if (e.getSource()==finishButton)
		{
			//store info in user profile
			temp[0] = competitionName1.getText();	
			temp[1] = competitionName2.getText();
			temp[2] = competitionName3.getText();
			temp[3] = competitionName4.getText();
			temp[4] = competitionName5.getText();
			
			student.setCompetitionsParticipated(temp);
			MainController.setStudent(student);
			System.out.println("\n\nIm here!");
			System.out.println(MainController.getStudent());
			frame.dispose();
			MatchingController.findMatches();
			
		}


	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	public JButton getFinishButton() {
		return finishButton;
	}

	public void setFinishButton(JButton finishButton) {
		this.finishButton = finishButton;
	}

	public JComboBox getComboBox1() {
		return comboBox1;
	}

	public void setComboBox1(JComboBox comboBox1) {
		this.comboBox1 = comboBox1;
	}

	public JComboBox getComboBox2() {
		return comboBox2;
	}

	public void setComboBox2(JComboBox comboBox2) {
		this.comboBox2 = comboBox2;
	}

	public JComboBox getComboBox3() {
		return comboBox3;
	}

	public void setComboBox3(JComboBox comboBox3) {
		this.comboBox3 = comboBox3;
	}

	public JComboBox getComboBox4() {
		return comboBox4;
	}

	public void setComboBox4(JComboBox comboBox4) {
		this.comboBox4 = comboBox4;
	}

	public JComboBox getComboBox5() {
		return comboBox5;
	}

	public void setComboBox5(JComboBox comboBox5) {
		this.comboBox5 = comboBox5;
	}

	public JTextField getCompetitionName1() {
		return competitionName1;
	}

	public void setCompetitionName1(JTextField competitionName1) {
		this.competitionName1 = competitionName1;
	}

	public JTextField getCompetitionName2() {
		return competitionName2;
	}

	public void setCompetitionName2(JTextField competitionName2) {
		this.competitionName2 = competitionName2;
	}

	public JTextField getCompetitionName3() {
		return competitionName3;
	}

	public void setCompetitionName3(JTextField competitionName3) {
		this.competitionName3 = competitionName3;
	}

	public JTextField getCompetitionName4() {
		return competitionName4;
	}

	public void setCompetitionName4(JTextField competitionName4) {
		this.competitionName4 = competitionName4;
	}

	public JTextField getCompetitionName5() {
		return competitionName5;
	}

	public void setCompetitionName5(JTextField competitionName5) {
		this.competitionName5 = competitionName5;
	}

	public JLabel getPlacelabel1() {
		return placelabel1;
	}

	public void setPlacelabel1(JLabel placelabel1) {
		this.placelabel1 = placelabel1;
	}

	public JLabel getPlacelabel2() {
		return placelabel2;
	}

	public void setPlacelabel2(JLabel placelabel2) {
		this.placelabel2 = placelabel2;
	}

	public JLabel getPlacelabel3() {
		return placelabel3;
	}

	public void setPlacelabel3(JLabel placelabel3) {
		this.placelabel3 = placelabel3;
	}

	public JLabel getPlacelabel4() {
		return placelabel4;
	}

	public void setPlacelabel4(JLabel placelabel4) {
		this.placelabel4 = placelabel4;
	}

	public JLabel getPlacelabel5() {
		return placelabel5;
	}

	public void setPlacelabel5(JLabel placelabel5) {
		this.placelabel5 = placelabel5;
	}

	public JLabel getNamelabel1() {
		return namelabel1;
	}

	public void setNamelabel1(JLabel namelabel1) {
		this.namelabel1 = namelabel1;
	}

	public JLabel getNamelabel2() {
		return namelabel2;
	}

	public void setNamelabel2(JLabel namelabel2) {
		this.namelabel2 = namelabel2;
	}

	public JLabel getNamelabel3() {
		return namelabel3;
	}

	public void setNamelabel3(JLabel namelabel3) {
		this.namelabel3 = namelabel3;
	}

	public JLabel getNamelabel4() {
		return namelabel4;
	}

	public void setNamelabel4(JLabel namelabel4) {
		this.namelabel4 = namelabel4;
	}

	public JLabel getNamelabel5() {
		return namelabel5;
	}

	public void setNamelabel5(JLabel namelabel5) {
		this.namelabel5 = namelabel5;
	}

	public String[] getPlaces() {
		return places;
	}

	public void setPlaces(String[] places) {
		this.places = places;
	}
	

	
}