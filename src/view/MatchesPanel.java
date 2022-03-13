/*
 * Name: Vidhi Ruparel
 * Date: December 16, 2021
 * Course: ICS4U1-02 Mr. Fernandes
 * Description: This sets up the MatchesPanel that displays the 5 MatchBoxes, which are the user's top 5 matched programs. 
 */
package view;


//imports
import javax.swing.*;

import controller.MainController;

import java.awt.*;
import java.awt.event.*;
import model.Student;


/**
 * MatchesPanel class displays the 5 MatchBoxes that show the user's top 5 matched programs.
 */
@SuppressWarnings("serial")
public class MatchesPanel extends JPanel {
	
	//instance variables
	private JButton seeAllButton;
	private JPanel[] matchBoxes = new JPanel[5];		//five matched university programs
	private int xPosition = 0, yPosition = 0;
	
	
	//constructor
	public MatchesPanel() {
		
		setLayout(null);
		
		//assigns information to each matchBox
		for (int index = 0; index < matchBoxes.length; index++) {
			Student student = MainController.getStudent();
			
			if (student.getMatchedPrograms().size() == 0) {
				JOptionPane.showMessageDialog(null, "Sorry, none of our programs match. Good luck from UniMatch :)");
				break;
			}
			
			matchBoxes[index] = new MatchBoxPanel(student.getMatchedPrograms().get(index), index);
			
			//set proper position 
			switch(index) {
			
			case 0: 									//first panel
				xPosition = 175;
				yPosition = 50;
				break;
				
			case 1:										//second panel
				xPosition = 625;
				yPosition = 50;
				break;
				
			case 2:										//third panel
				xPosition = 1075;
				yPosition = 50;
				break;
				
			case 3:										//fourth panel
				xPosition = 400;
				yPosition = 350;
				break;
				
			case 4:										//fifth panel
				xPosition = 850;
				yPosition = 350;
				break;
				
			}
			
			matchBoxes[index].setBounds(xPosition, yPosition, 250, 250);
			add(matchBoxes[index]);
		}
		
		seeAllButton = new JButton("SEE ALL");
		seeAllButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		seeAllButton.setOpaque(true);
		seeAllButton.setBackground(Color.white);										
		seeAllButton.setBounds(1200, 550, 150, 50);
		
		
		//opens the new frame (table with all matches programs) when button is clicked
		seeAllButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame parent = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, seeAllButton);
				parent.dispose();
				new AllMatchesFrame();
			}
		});
		
		add(seeAllButton);
		
	}

	
	//getters and setters
	public JButton getSeeAllButton() {
		return seeAllButton;
	}

	public void setSeeAllButton(JButton seeAllButton) {
		this.seeAllButton = seeAllButton;
	}

	public JPanel[] getMatchBoxes() {
		return matchBoxes;
	}

	public void setMatchBoxes(JPanel[] matchBoxes) {
		this.matchBoxes = matchBoxes;
	}
	
	
	//utility methods
	
	/**
	 * Sets the background of the panel as a gradient >> cite: https://stackoverflow.com/questions/14364291/jpanel-gradient-background
	 */
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

}	//end of MatchesPanel class
