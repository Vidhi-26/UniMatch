/*
 * Name: Vidhi Ruparel
 * Date: December 16, 2021
 * Course: ICS4U1-02 Mr. Fernandes
 * Description: This is the header panel, which creates a header for the Matches and AllMatches Frames. 
 */
package view;


//imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * HeaderPanel class. This is a template header class that
 * sets up headers for the Matches and AllMatches screens. 
 */
@SuppressWarnings("serial")
public class HeaderPanel extends JPanel {
	
	//instance variables
	
	//back button
	private JButton backButton;
	
	//logo
	private ImageIcon logoImage = new ImageIcon("./images/logoImage.png");		//logo image
	private JLabel logoLabel;													//logo label
	
	private JLabel titleLabel = new JLabel("We found a match for you!");		//title of the screen
	
	//home
	private ImageIcon homeImage = new ImageIcon("./images/homeImage.png");		//home image
	private JButton homeButton;													//home button
	
	//constructor
	public HeaderPanel() {
		
		setLayout(null);
		
		setBackground(new Color(240, 230, 255));
		
		//adds the logo image to the logo label
		logoLabel = new JLabel(logoImage);
		logoLabel.setBounds(200, 15, 100, 60);
		add(logoLabel);
		
		titleLabel.setBounds(500, 0, 1000, 75);
		titleLabel.setFont(new Font("Roboto", Font.BOLD, 25));
		add(titleLabel);
		
		//adds the home image to the home button
		homeButton = new JButton(homeImage);
		homeButton.setBorder(BorderFactory.createEmptyBorder());
		homeButton.setBackground(getBackground());
		homeButton.setBounds(1200, 0, 100, 100);
		
		//opens the home screen when clicked
		homeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame parent = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, backButton);
				parent.dispose();
				new HomeScreenFrame();
			}
		});
		
		add(homeButton);
		
		//adds the back button
		backButton = new JButton("BACK");
		backButton.setForeground(Color.white);
		backButton.setBorder(BorderFactory.createEmptyBorder());
		backButton.setFont(new Font("Roboto", Font.PLAIN, 15));
		backButton.setBounds(10, 15, 70, 45);
		
		//opens the previous frame when button is clicked
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame parent = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, backButton);
				parent.dispose();
				if (parent instanceof MatchesFrame)
					new ExtracurricularCompetitionInfo();
				else if (parent instanceof AllMatchesFrame)
					new MatchesFrame();
			}
		});
		
		add(backButton);
		
	}


	//getters and setters
	public JLabel getLogoLabel() {
		return logoLabel;
	}

	public void setLogoLabel(JLabel logoLabel) {
		this.logoLabel = logoLabel;
	}

	public JLabel getTitleLabel() {
		return titleLabel;
	}

	public void setTitleLabel(JLabel titleLabel) {
		this.titleLabel = titleLabel;
	}

	public JButton getHomeButton() {
		return homeButton;
	}

	public void setHomeButton(JButton homeButton) {
		this.homeButton = homeButton;
	}

	public JButton getBackButton() {
		return backButton;
	}

	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}
	
	
}	//end of HeaderPanel class
