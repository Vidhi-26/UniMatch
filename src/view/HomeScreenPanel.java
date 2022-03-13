package view;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;

import controller.MainController;
import model.Student;

/**
 * This class is for the 'HomeScreenPanel' which displays
 * the users Name, Links to universities, their current courses, and extracurriculars.
 * There is a button which will proceed to the 'quiz' screen.
 *
 */

public class HomeScreenPanel extends JPanel {

	public HomeScreenPanel() {
		setupPanel();
	}

	// Setup the frame (bounds, titles, colors)
	private void setupPanel() {
		setBounds(100, 100, 1600, 800);
		setLayout(null);
				
		
		Student student = MainController.getStudent();
		// Label which will display the users name
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText("Welcome " + student.getFirstName() + " " + student.getLastName());
		lblNewLabel.setBounds(460, 50, 500, 50);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 30));
		add(lblNewLabel);
		
		// Label for the current average the user has under their profile
		/*
		 * JLabel lblNewLabel_1 = new JLabel("Current Average: 100%\n");
		 * lblNewLabel_1.setBounds(595, 66, 211, 35); lblNewLabel_1.setFont(new
		 * Font("Roboto", Font.PLAIN, 18)); add(lblNewLabel_1);
		 */
		
		// Button which will open the 'InitialScreen'
		JButton btnNewButton = new JButton("Proceed to Quiz\n");
		btnNewButton.setFont(new Font("Roboto", Font.PLAIN, 20));
		btnNewButton.setBounds(577, 713, 211, 35);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame parent = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, btnNewButton);
				parent.setVisible(false);
				parent.dispose();
				new InitialScreen();
			}
		});
		add(btnNewButton);
		
		// Links for all 10 universities (as a resource)
				JEditorPane txtrLinksToUniversities = new JEditorPane();
				txtrLinksToUniversities.setEditable(false);
				txtrLinksToUniversities.setBounds(46, 130, 345, 551);
				CompoundBorder border = new CompoundBorder(BorderFactory.createEtchedBorder(BevelBorder.RAISED),
						BorderFactory.createEmptyBorder());
				border = new CompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 5), border);
				txtrLinksToUniversities.setBorder(border);
				txtrLinksToUniversities.setFont(new Font("Roboto", Font.PLAIN, 13));
				add(txtrLinksToUniversities);

				/**
				 * @link: https://stackoverflow.com/questions/3693543/hyperlink-in-jeditorpane'using HTML'
				 */
				txtrLinksToUniversities.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
				txtrLinksToUniversities.setText("<font face=\"Roboto\" size=\"19px\""
						+ "<br>Links to Universities:<br> "
						+ "<br> University of Toronto <br> <a href=\"http://utoronto.ca\">utoronto.ca</a><br>"
						+ "<br> University of Waterloo <br> <a href=\"http://uwaterloo.ca\">uwaterloo.ca</a><br>"
						+ "<br> University of Ottawa <br> <a href=\"http://uottawa.ca\">uottawa.ca</a><br>"
						+ "<br> Carleton University <br> <a href=\"http://carleton.ca\">carleton.ca</a><br>"
						+ "<br> York University <br> <a href=\"http://yorku.ca\">yorku.ca</a><br>"
						+ "<br> Ryerson University <br> <a href=\"http://ryerson.ca\">ryerson.ca</a><br>"
						+ "<br> Queens University <br> <a href=\"http://queensu.ca\">queensu.ca</a><br>"
						+ "<br> Western University <br> <a href=\"http://uwo.ca\">uwo.ca</a><br> "
						+ "<br> University of Guelph <br> <a href=\"http://uoguelph.ca\">uoguelph.ca</a><br>"
						+ "<br> McMaster University <br> <a href=\\\"http://mcmaster.ca\\\">mcmaster.ca</a><br>");

				txtrLinksToUniversities.addHyperlinkListener(new HyperlinkListener() {

					public void hyperlinkUpdate(HyperlinkEvent e) {
						if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {

							if (Desktop.isDesktopSupported()) {
								try {
									Desktop.getDesktop().browse(e.getURL().toURI());
								} catch (IOException | URISyntaxException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
					}
				});
		
		// List of extracurriculars that the user has under their profile
		JTextArea txtExtracurriculars = new JTextArea();
		txtExtracurriculars.setEditable(false);
		txtExtracurriculars.setFont(new Font("Roboto", Font.PLAIN, 20));
		// TODO Get extracurriculars from user
		String ecs = "Extracurriculars:";
		
		if(student.getExtracurricularsDone()[0]) 
			ecs += "\n\nVolunteering";
		else if (student.getExtracurricularsDone()[1]) 
			ecs += "\nStudent Government";
		else if (student.getExtracurricularsDone()[2]) 
			ecs += "\nAcademic Organization";
		else if (student.getExtracurricularsDone()[3]) 
			ecs += "\nMutlicultural";
		else if (student.getExtracurricularsDone()[4]) 
			ecs += "\nArts";
		else if (student.getExtracurricularsDone()[5]) 
			ecs += "\nAthletics";
		else if (student.getExtracurricularsDone()[6]) 
			ecs += "\nInstrument";
		else if (student.getExtracurricularsDone()[7]) 
			ecs += "\nTechnology";
		
		txtExtracurriculars.setText(ecs);
		
		CompoundBorder border2 = new CompoundBorder(BorderFactory.createEtchedBorder(BevelBorder.RAISED),
			      BorderFactory.createEmptyBorder(5, 5, 5, 5));
			  border2 = new CompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 5), border);
			  txtExtracurriculars.setBorder(border);
		txtExtracurriculars.setBounds(525, 130, 345, 551);
		add(txtExtracurriculars);
		
		// Volunteering, Student government, academic organization, multicultural, arts, athletics, instrument, technology
		
		// List of Current Courses the user has under their profile
		JTextArea txtCurrentCourses = new JTextArea();
		txtCurrentCourses.setEditable(false);
		txtCurrentCourses.setFont(new Font("Roboto", Font.PLAIN, 20));
		String[] temp = student.getCoursesTaken();
		String label = "Courses:\n";
		for (String course : temp) {
			label += "\n" + course;
		}
		txtCurrentCourses.setText(label);
		CompoundBorder border3 = new CompoundBorder(BorderFactory.createEtchedBorder(BevelBorder.RAISED),
			      BorderFactory.createEmptyBorder(5, 5, 5, 5));
			  border3 = new CompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 5), border);
			 txtCurrentCourses.setBorder(border);
		txtCurrentCourses.setBounds(1045, 131, 345, 551);
		add(txtCurrentCourses);
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