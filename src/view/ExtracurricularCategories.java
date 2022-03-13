package view;
/*
 * Group #1
 * Name: Sylvia
 * Date: 2021/12/16
 * Course: ICS4U1-01, Mr. Fernandes
 * Title: Post-secondary App, ExtracurricularCategories
 * Description: This class sets up the extracurricular activity categories frame showing eight categories
 * for users to select
 * Features: get number of activities done, calculate extracurriculars points, go to home screen
 * Major Skills: JCheckBox class, GUI, ActionListener
 * Source of images: <div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from 
 * <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
 * https://www.flaticon.com/
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.MainController;
import model.Student;

public class ExtracurricularCategories implements ActionListener{

	//fields
	private JFrame f= new JFrame("UniMatch - Find Your Future");
	private JCheckBox box1;
	private JCheckBox box2;
	private JCheckBox box3;
	private JCheckBox box4;
	private JCheckBox box5;
	private JCheckBox box6;
	private JCheckBox box7;
	private JCheckBox box8;
	
	private JButton nextButton;
	private JButton homeButton;
	private JLabel label;


	ExtracurricularCategories(){
		//set frame
		
		f.setSize(1600,800);  
		f.getContentPane().setBackground(new Color(209,179,255));
        f.setLayout(null);  
        f.setVisible(true);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        //set label
        label = new JLabel("Tell us what you do outside of class");            
        label.setBounds(420,50,800,45); 
        //label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Roboto", Font.BOLD, 30));
        f.add(label);
        
        //set check boxes
		box1=new JCheckBox("Volunteering");  
        box1.setBounds(215,150,400,35);  
        box1.setFont(new Font("Roboto", Font.PLAIN, 28));
        box1.setBackground(new Color(209,179,255));
        box1.addActionListener(this); 
        ImageIcon icon1 = new ImageIcon("images/volunteer.png");
        Image image1 = icon1.getImage();
        Image newimg1 = image1.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH);
        icon1 = new ImageIcon(newimg1);
        JLabel lb1 = new JLabel (icon1);
        lb1.setBounds(550,150,35,35);
        f.add(lb1);
        box2=new JCheckBox("Student Government");  
        box2.setBounds(215,250,400,35);  
        box2.setFont(new Font("Roboto", Font.PLAIN, 28));
        box2.setBackground(new Color(209,179,255));
        box2.addActionListener(this); 
        ImageIcon icon2 = new ImageIcon("images/government.png");
        Image image2 = icon2.getImage();
        Image newimg2 = image2.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH);
        icon2 = new ImageIcon(newimg2);
        JLabel lb2 = new JLabel (icon2);
        lb2.setBounds(550,250,35,35);
        f.add(lb2);
        box3=new JCheckBox("Academic Organization");  
        box3.setBounds(215,350,400,35);  
        box3.setFont(new Font("Roboto", Font.PLAIN, 28));
        box3.setBackground(new Color(209,179,255));
        box3.addActionListener(this); 
        ImageIcon icon3 = new ImageIcon("images/academic.png");
        Image image3 = icon3.getImage();
        Image newimg3 = image3.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH);
        icon3 = new ImageIcon(newimg3);
        JLabel lb3 = new JLabel (icon3);
        lb3.setBounds(550,350,35,35);
        f.add(lb3);
        box4=new JCheckBox("Multicultural");  
        box4.setBounds(215,450,400,35);  
        box4.setFont(new Font("Roboto", Font.PLAIN, 28));
        box4.setBackground(new Color(209,179,255));
        box4.addActionListener(this);
        ImageIcon icon4 = new ImageIcon("images/multiculture.png");
        Image image4 = icon4.getImage();
        Image newimg4 = image4.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH);
        icon4 = new ImageIcon(newimg4);
        JLabel lb4 = new JLabel (icon4);
        lb4.setBounds(550,450,35,35);
        f.add(lb4);
        box5=new JCheckBox("Arts");  
        box5.setBounds(920,150,400,35);  
        box5.setFont(new Font("Roboto", Font.PLAIN, 28));
        box5.setBackground(new Color(209,179,255));
        box5.addActionListener(this);
        ImageIcon icon5 = new ImageIcon("images/art.png");
        Image image5 = icon5.getImage();
        Image newimg5 = image5.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH);
        icon5 = new ImageIcon(newimg5);
        JLabel lb5 = new JLabel (icon5);
        lb5.setBounds(1100,150,35,35);
        f.add(lb5);
        box6=new JCheckBox("Athletics");  
        box6.setBounds(920,250,400,35);
        box6.setFont(new Font("Roboto", Font.PLAIN, 28));
        box6.setBackground(new Color(209,179,255));
        box6.addActionListener(this);
        ImageIcon icon6 = new ImageIcon("images/gymnastic.png");
        Image image6 = icon6.getImage();
        Image newimg6 = image6.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH);
        icon6 = new ImageIcon(newimg6);
        JLabel lb6 = new JLabel (icon6);
        lb6.setBounds(1100,250,35,35);
        f.add(lb6);
        box7=new JCheckBox("Instrument");  
        box7.setBounds(920,350,400,35);  
        box7.setFont(new Font("Roboto", Font.PLAIN, 28));
        box7.setBackground(new Color(209,179,255));
        box7.addActionListener(this);
        ImageIcon icon7 = new ImageIcon("images/music.png");
        Image image7 = icon7.getImage();
        Image newimg7 = image7.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH);
        icon7 = new ImageIcon(newimg7);
        JLabel lb7 = new JLabel (icon7);
        lb7.setBounds(1100,350,35,35);
        f.add(lb7);
        box8=new JCheckBox("Technology");  
        box8.setBounds(920,450,400,35); 
        box8.setFont(new Font("Roboto", Font.PLAIN, 28));
        box8.setBackground(new Color(209,179,255));
        box8.addActionListener(this);
        ImageIcon icon8 = new ImageIcon("images/technology.png");
        Image image8 = icon8.getImage();
        Image newimg8 = image8.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH);
        icon8 = new ImageIcon(newimg8);
        JLabel lb8 = new JLabel (icon8);
        lb8.setBounds(1100,450,35,35);
        f.add(lb8);
        f.add(box1);
        f.add(box2);
        f.add(box3);
        f.add(box4);
        f.add(box5);
        f.add(box6);
        f.add(box7);
        f.add(box8);
        
        //set button
        nextButton =new JButton("Next");  
        nextButton.setBounds(550,600,105,40);  
        //nextButton.setHorizontalAlignment(JButton.CENTER);
        nextButton.setFont(new Font("Roboto", Font.BOLD, 22));
        nextButton.addActionListener(this); 
        f.add(nextButton);
        
        homeButton =new JButton("Home");  
        homeButton.setBounds(700,600,102,40);  
        //nextButton.setHorizontalAlignment(JButton.CENTER);
        homeButton.setFont(new Font("Roboto", Font.BOLD, 22));
        homeButton.addActionListener(this); 
        f.add(homeButton);

	}
	
	


	@Override
	public void actionPerformed(ActionEvent e) {

		Student student = MainController.getStudent();
		if (e.getSource()==nextButton)
		{
			//Go to next window for competitions (asking if participated in any)
			f.dispose();
			new ExtracurricularAsking();
		}
		if (e.getSource()==homeButton)
		{
			f.dispose();
			new HomeScreenFrame();
		}
		boolean [] temp = student.getExtracurricularsDone();
		//Store selected activities in user profile
		if(box1.isSelected())
		{
			temp[0]=true;
		}
		if(box2.isSelected())
		{
			temp[1]=true;
		}
		if(box3.isSelected())
		{
			temp[2]=true;
		}
		if(box4.isSelected())
		{
			temp[3]=true;
		}
		if(box5.isSelected())
		{
			temp[4]=true;
		}
		if(box6.isSelected())
		{
			temp[5]=true;
		}
		if(box7.isSelected())
		{
			temp[6]=true;
		}
		if(box8.isSelected())
		{
			temp[7]=true;
		}
		student.setExtracurricularsDone(temp);
		MainController.setStudent(student);
	}

	public JFrame getF() {
		return f;
	}

	public void setF(JFrame f) {
		this.f = f;
	}

	public JCheckBox getBox1() {
		return box1;
	}

	public void setBox1(JCheckBox box1) {
		this.box1 = box1;
	}

	public JCheckBox getBox2() {
		return box2;
	}

	public void setBox2(JCheckBox box2) {
		this.box2 = box2;
	}

	public JCheckBox getBox3() {
		return box3;
	}

	public void setBox3(JCheckBox box3) {
		this.box3 = box3;
	}

	public JCheckBox getBox4() {
		return box4;
	}

	public void setBox4(JCheckBox box4) {
		this.box4 = box4;
	}

	public JCheckBox getBox5() {
		return box5;
	}

	public void setBox5(JCheckBox box5) {
		this.box5 = box5;
	}

	public JCheckBox getBox6() {
		return box6;
	}

	public void setBox6(JCheckBox box6) {
		this.box6 = box6;
	}

	public JCheckBox getBox7() {
		return box7;
	}

	public void setBox7(JCheckBox box7) {
		this.box7 = box7;
	}

	public JCheckBox getBox8() {
		return box8;
	}

	public void setBox8(JCheckBox box8) {
		this.box8 = box8;
	}

	public JButton getNextButton() {
		return nextButton;
	}

	public void setNextButton(JButton nextButton) {
		this.nextButton = nextButton;
	}

	public JButton getHomeButton() {
		return homeButton;
	}

	public void setHomeButton(JButton homeButton) {
		this.homeButton = homeButton;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

}