/*
 * Name: Vidhi Ruparel
 * Date: December 16, 2021
 * Description: This panel displays the top 5 matched programs of the student.
 */
package view;


//imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import controller.MainController;
import model.Program;
import model.Student;


/**
 * MatchBoxPanel class displays 5 Match Boxes, each displaying
 * the rank, university, program (with website link), and an 
 * option to make a program favourite for the top 5 matches programs of the student. 
 */
@SuppressWarnings("serial")
public class MatchBoxPanel extends JPanel {
	
	//instance variables
	
	//heart icon to mark program as favourite
	private ImageIcon heartImage = new ImageIcon("./images/emptyHeartImage.svg.png");		//heart image
	private JButton heartButton;															//heart button
	private boolean empty = true;															//indicates if heart is empty or full

	//information (rank, university, program)
	private JLabel rankLabel;
	private JLabel universityLabel;
	private JLabel programLabel;
	
	
	//constructor
	public MatchBoxPanel(Program program, int index) {
		
		//fixes and adds spaces to university and program names before display
		String universityName = correctUniversityName(program.getUniversity());
		String programName = correctProgramName(program.getProgram());
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.white);
		setBorder(BorderFactory.createLineBorder(Color.black, 2));
		
		//adds the heart image to the heart label
		heartButton = new JButton(heartImage);
		heartButton.setOpaque(true);
		heartButton.setBackground(Color.white);
		heartButton.setBorder(BorderFactory.createEmptyBorder());
		heartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		//heartButton.setBounds(0, 3, 35, 35);
		
		//fills the heart to full heart from empty heart when clicked, and vice-verse to mark program as favourite 
		heartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//if heart is empty
				if (empty) {
					heartImage = new ImageIcon("./images/fullHeartImage.png");
					heartButton.setIcon(heartImage);
					empty = false;
				}
				
				//if heart is full
				else {
					heartImage = new ImageIcon("./images/emptyHeartImage.svg.png");
					heartButton.setIcon(heartImage);
					empty = true;
				}
			}
		});
		
		//to vertically space elements
		add(Box.createVerticalStrut(10));

		add(heartButton);
		
		//adds program rank
		String rank = determineRank(index);
		rankLabel = new JLabel(rank);			
		rankLabel.setFont(new Font("Roboto", Font.BOLD, 30));
		rankLabel.setAlignmentX(Component.CENTER_ALIGNMENT);		
		add(Box.createVerticalStrut(20));
		add(rankLabel);
		
		//adds university name
		universityLabel = new JLabel(universityName);
		universityLabel.setFont(new Font("Roboto", Font.PLAIN, 22));
		universityLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(Box.createVerticalStrut(20));
		add(universityLabel);
		
		//adds program name
		programLabel = new JLabel(programName);
		programLabel.setOpaque(true);
		programLabel.setBackground(new Color(102, 0, 255));
		programLabel.setForeground(Color.white);
		programLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		programLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//add link of the university website	>>		cite:https://stackhowto.com/how-to-create-hyperlink-with-jlabel-in-java/
		programLabel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI(program.getHyperlink()));
				}
				catch (IOException | URISyntaxException el){
					el.printStackTrace();
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				programLabel.setText(program.getProgram());
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				programLabel.setText(program.getProgram());
			}
		});
				
		add(Box.createVerticalStrut(30));
		add(programLabel);
		
	}
	
	
	//getters and setters
	public JButton getHeartButton() {
		return heartButton;
	}
	
	public void setHeartButton(JButton heartButton) {
		this.heartButton = heartButton;
	}
	
	public JLabel getRankLabel() {
		return rankLabel;
	}
	
	public void setRankLabel(JLabel rankLabel) {
		this.rankLabel = rankLabel;
	}
	
	public JLabel getUniversityLabel() {
		return universityLabel;
	}
	
	public void setUniversityLabel(JLabel universityLabel) {
		this.universityLabel = universityLabel;
	}
	
	public JLabel getProgramLabel() {
		return programLabel;
	}
	
	public void setProgramLabel(JLabel programLabel) {
		this.programLabel = programLabel;
	}	
	
	
	//utility methods
	/**
	 * Determines the rank (1 to 5) of the top 5 matches programs of the user. 
	 * Then returns it to rank placed on rankLabel.
	 */
	private static String determineRank(int index) {
		
		switch(index) {
		case 0:
			return "1";
		case 1:
			return "2";
		case 2:
			return "3";
		case 3:
			return "4";
		case 4:
			return "5";
		}
		
		return "0";
	}
	
	/**
	 * Corrects (adds spaces) to university names before displaying them. 
	 * Returns university name as a string. 
	 */
	public static String correctUniversityName(String universityName) {
		
		if (universityName.equals("UniversityofToronto"))
			universityName = "University of Toronto";
		
		else if (universityName.equals("WesternUniversity"))
			universityName = "Western University";
		
		else if (universityName.equals("UniversityofOttawa"))
			universityName = "University of Ottawa";
		
		else if (universityName.equals("YorkUniversity"))
			universityName = "York University";
		
		else if (universityName.equals("UniversityofWaterloo"))
			universityName = "University of Waterloo";
		
		return universityName;
	}
	
	/**
	 * Corrects (adds spaces) to program names before displaying them. 
	 * Returns program name as a string. 
	 */
	public static String correctProgramName(String programName) {
		
		if (programName.equals("ChemicalEngineering"))
			programName = "Chemical Engineering";
		
		else if (programName.equals("CivilEngineering"))
			programName = "Civil Engineering";
		
		else if (programName.equals("ComputerEngineering"))
			programName = "Computer Engineering";
		
		else if (programName.equals("ElectricalEngineering"))
			programName = "Electrical Engineering";
		
		else if (programName.equals("IndsutrialEngineering"))
			programName = "Industrial Engineering";
		
		else if (programName.equals("MaterialsEngineering"))
			programName = "Materials Engineering";
		
		else if (programName.equals("MechanicalEngineering"))
			programName = "Mechanical Engineering";
		
		else if (programName.equals("SoftwareEngineering"))
			programName = "Software Engineering";
		
		else if (programName.equals("BiomedicalEngineering"))
			programName = "Biomedical Engineering";
		
		else if (programName.equals("GeomaticEngineering"))
			programName = "Geomatic Engineering";
		
		else if (programName.equals("GeologicalEngineering"))
			programName = "Geological Engineering";
		
		else if (programName.equals("EnvironmentalEngineering"))
			programName = "Environmental Engineering";
		
		else if (programName.equals("ArchitecturalEngineering"))
			programName = "Architectural Engineering";
		
		else if (programName.equals("ManagementEngineering"))
			programName = "Management Engineering";
		
		else if (programName.equals("MechatronicsEngineering"))
			programName = "Mechatronics Engineering";
		
		else if (programName.equals("NanotechnologyEngineering"))
			programName = "Nanotechnology Engineering";
		
		else if (programName.equals("SystemsDesignEngineering"))
			programName = "Systems Design Engineering";
		
		return programName;
	}

}	//end of MatchBoxPanel class
