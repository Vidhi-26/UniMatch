/*
 * Name: Vidhi Ruparel
 * Date: December 16, 2021
 * Description: The Matches Frame sets up the header and Matches Panel (that eventually displays user's top 5 matches.
 */
package view;


//imports
import javax.swing.JFrame;
import model.Student;


/**
 * MatchesFame class contains 2 panels:
 * HeaderPanel is the header.
 * MatchesPanel displays 5 MatchBoxePanels that displays user's top 5 matched programs.
 */
@SuppressWarnings("serial")
public class MatchesFrame extends JFrame {
	
	//instance variables
	private HeaderPanel headerPanel = new HeaderPanel();	//header
	private MatchesPanel matchesPanel;

	
	//constructor
	public MatchesFrame() {
		
		setTitle("UniMatch - Find Your Future");
		setLayout(null);
		setSize(1600, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		headerPanel.setBounds(0, 0, 1600, 100);
		add(headerPanel);
		
		matchesPanel = new MatchesPanel();
		matchesPanel.setBounds(0, 100, 1600, 700);
		add(matchesPanel);
		
		setVisible(true);
	}


	//setters and getters
	public HeaderPanel getHeaderPanel() {
		return headerPanel;
	}

	public void setHeaderPanel(HeaderPanel headerPanel) {
		this.headerPanel = headerPanel;
	}

	public MatchesPanel getMatchesPanel() {
		return matchesPanel;
	}

	public void setMatchesPanel(MatchesPanel matchesPanel) {
		this.matchesPanel = matchesPanel;
	}
	
}	//end of MatchesFrame class
