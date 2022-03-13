/**
 * Author: Jasper Fei
 * 
 * This class implement UI to display all available grade 12 courses in checkboxes in a JScrollPane and input of marks of the selected courses. 
 * The average mark is also calculated after user input all the marks. "Next" Button is disabled until user select 6 courses from the list and
 * input valid marks.   
 * 
 * */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import controller.MainController;
import model.Courses;
import model.Student;
import utils.SQLiteJDBC;

public class CourseDialog extends JDialog{
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel() {
// Override paintComponent of JPanel to support gradual panel background		
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
	};
	private final JPanel panel_left;
	private JPanel listOfCourses = new JPanel();
	private ArrayList<JCheckBox> allcoursesCheckbox = new ArrayList<JCheckBox>();
	private JTextField [] textField = new JTextField[12];
	private ArrayList<String> allcourseCode = new ArrayList<String>();
	private JButton btnNext;
	

	/**
	 * Create the JDialog.
	 */
	public CourseDialog() {
		
// Before display the GUI, Load all the available courses and selected courses and marks from SQLite.		
		SQLiteJDBC.sqliteLoadAllCourses();
		SQLiteJDBC.sqliteLoadCourseMarks();

		// Center this dialog to the screen.
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		setSize(1600,800);
		final int x = (screenSize.width - getWidth()) / 2;
		final int y = (screenSize.height - getHeight()) / 2;
		setLocation(x, y);
		
		// For Fixing JButton background does't change on MAC.		
		 try {
			    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
			 } catch (Exception e) {
			            e.printStackTrace();
		 }
				 
		setTitle("UniMatch - Find Your Future");
		getContentPane().setLayout(null);
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
// This panel is for listing all the available courses.		
		panel_left = new JPanel();
		panel_left.setBounds(0, 272, 700, 478);
		panel_left.setLayout(new FlowLayout());
		panel_left.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_left.setOpaque(false);
		contentPanel.add(panel_left);
		listOfCourses.setLayout(new BoxLayout(listOfCourses, BoxLayout.Y_AXIS));
		listOfCourses.setPreferredSize(new Dimension (700, 1600));
		listOfCourses.setOpaque(false);
		LoadAllCoursesCheckBox();
// JScrollPane to hold very long list of available courses.		
		JScrollPane jScrollPane = new JScrollPane(listOfCourses);
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jScrollPane.setPreferredSize(new Dimension (700, 450));
		panel_left.add(jScrollPane);
		jScrollPane.setOpaque(false);
		jScrollPane.getViewport().setOpaque(false);		
		
		JButton btnAddButton = new JButton("Add");
// select 6 courses from the available course list and add to the mark panel for the average make calculation.		
		btnAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = 0;
				int index = 0;
				// Count the selected options amount.
				for(JCheckBox chkbox: allcoursesCheckbox) {
					if(chkbox.isSelected() == true) {
						textField[count].setText(allcourseCode.get(index));
						count++;
					}
					index++;
				}
				if(count != 6 ) {
					clearAllTextFields();
					JOptionPane.showMessageDialog(null, "You have to select 6 courses. Please try again", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
			}
		});
		
		btnAddButton.setBounds(770, 362, 170, 72);
		contentPanel.add(btnAddButton);
		btnAddButton.setBackground(new Color(0, 0x57, 0xd8));
		btnAddButton.setForeground(new Color(255, 255, 255));

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAllTextFields();				
			}
		});
		btnReset.setForeground(Color.WHITE);
		btnReset.setBackground(new Color(0, 87, 216));
		btnReset.setBounds(770, 561, 170, 72);
		contentPanel.add(btnReset);
		
		JLabel lblNewLabel = new JLabel("All courses");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Bodoni MT Black", Font.PLAIN, 34));
		lblNewLabel.setBounds(0, 193, 305, 33);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Please choose 6 courses from the following list.");
		lblNewLabel_1.setFont(new Font("Bodoni MT Black", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(0, 102, 804, 33);
		contentPanel.add(lblNewLabel_1);
		
		JPanel markPanel = new JPanel();
		markPanel.setBounds(1004, 281, 295, 450);
		markPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		contentPanel.add(markPanel);
		markPanel.setLayout(null);
		markPanel.setOpaque(false);
		

		textField[0] = new JTextField();
		textField[0].setEditable(false);
		textField[0].setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField[0].setBackground(new Color(0xff, 0xf2, 0xcc));
		textField[0].setForeground(Color.BLACK);
		textField[0].setBounds(33, 25, 86, 33);
		markPanel.add(textField[0]);
		
		textField[1] = new JTextField();
		textField[1].setForeground(Color.BLACK);
		textField[1].setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField[1].setEditable(false);
		textField[1].setColumns(10);
		textField[1].setBackground(new Color(255, 242, 204));
		textField[1].setBounds(33, 69, 86, 33);
		markPanel.add(textField[1]);
		
		textField[2] = new JTextField();
		textField[2].setForeground(Color.BLACK);
		textField[2].setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField[2].setEditable(false);
		textField[2].setColumns(10);
		textField[2].setBackground(new Color(255, 242, 204));
		textField[2].setBounds(33, 113, 86, 33);
		markPanel.add(textField[2]);
		
		textField[3] = new JTextField();
		textField[3].setForeground(Color.BLACK);
		textField[3].setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField[3].setEditable(false);
		textField[3].setColumns(10);
		textField[3].setBackground(new Color(255, 242, 204));
		textField[3].setBounds(33, 157, 86, 33);
		markPanel.add(textField[3]);
		
		textField[4] = new JTextField();
		textField[4].setForeground(Color.BLACK);
		textField[4].setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField[4].setEditable(false);
		textField[4].setColumns(10);
		textField[4].setBackground(new Color(255, 242, 204));
		textField[4].setBounds(33, 201, 86, 33);
		markPanel.add(textField[4]);
		
		textField[5] = new JTextField();
		textField[5].setForeground(Color.BLACK);
		textField[5].setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField[5].setEditable(false);
		textField[5].setColumns(10);
		textField[5].setBackground(new Color(255, 242, 204));
		textField[5].setBounds(33, 245, 86, 33);
		markPanel.add(textField[5]);

		textField[6] = new JTextField();
		textField[6].setForeground(Color.BLACK);
		textField[6].setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField[6].setColumns(10);
		textField[6].setBackground(new Color(0xf8, 0xce, 0xcc));
		textField[6].setBounds(175, 25, 86, 33);
		markPanel.add(textField[6]);
		
		textField[7] = new JTextField();
		textField[7].setForeground(Color.BLACK);
		textField[7].setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField[7].setColumns(10);
		textField[7].setBackground(new Color(248, 206, 204));
		textField[7].setBounds(175, 69, 86, 33);
		markPanel.add(textField[7]);
		
		textField[8] = new JTextField();
		textField[8].setForeground(Color.BLACK);
		textField[8].setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField[8].setColumns(10);
		textField[8].setBackground(new Color(248, 206, 204));
		textField[8].setBounds(175, 113, 86, 33);
		markPanel.add(textField[8]);
		
		textField[9] = new JTextField();
		textField[9].setForeground(Color.BLACK);
		textField[9].setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField[9].setColumns(10);
		textField[9].setBackground(new Color(248, 206, 204));
		textField[9].setBounds(175, 157, 86, 33);
		markPanel.add(textField[9]);
		
		textField[10] = new JTextField();
		textField[10].setForeground(Color.BLACK);
		textField[10].setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField[10].setColumns(10);
		textField[10].setBackground(new Color(248, 206, 204));
		textField[10].setBounds(175, 201, 86, 33);
		markPanel.add(textField[10]);
		
		textField[11] = new JTextField();
		textField[11].setForeground(Color.BLACK);
		textField[11].setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField[11].setColumns(10);
		textField[11].setBackground(new Color(248, 206, 204));
		textField[11].setBounds(175, 245, 86, 33);
		markPanel.add(textField[11]);
		
		JLabel lblAvgMarks = new JLabel("Avg Mark: ");
		lblAvgMarks.setBounds(10, 319, 176, 33);
		markPanel.add(lblAvgMarks);
		lblAvgMarks.setForeground(Color.MAGENTA);
		lblAvgMarks.setFont(new Font("Bodoni MT Black", Font.PLAIN, 22));

		JLabel lblMarks = new JLabel("Marks");
		lblMarks.setForeground(SystemColor.textHighlight);
		lblMarks.setFont(new Font("Bodoni MT Black", Font.PLAIN, 34));
		lblMarks.setBounds(1004, 193, 183, 33);
		getContentPane().add(lblMarks);
		
		ImageIcon Logo = new ImageIcon("images/UniMatch200.png");
		JLabel lblLogo = new JLabel(Logo);
		lblLogo.setText("");
		lblLogo.setBounds(785, 11, 170, 162);
		contentPanel.add(lblLogo);
		
		btnNext = new JButton("Next");
		btnNext.setBounds(1369, 436, 170, 72);
		contentPanel.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveData();
				dispose();
				new ExtracurricularCategories();
			}
		});
		btnNext.setForeground(Color.WHITE);
		btnNext.setBackground(new Color(0, 87, 216));
// Load data from scores table
		LoadData();
		
// Timer event listener to determine the "Next" button status. 		
		ActionListener taskPerformer = new ActionListener() {
	      public void actionPerformed(ActionEvent evt) {
	    	  int avg = checkMarks();
	    	  if(avg != -1) {
	    		  lblAvgMarks.setText(String.format("Avg Mark: %d", avg));
	    		  btnNext.setEnabled(true);
	    	  }
	    	  else {
	    		  lblAvgMarks.setText("Avg Mark:");
	    		  btnNext.setEnabled(false);
	    	  }
	      }
		};
// 300ms timer event		
	    new Timer(300, taskPerformer).start();
	}
// Check the inputed marks. if you don't select any courses or the mark range is incorrect, "Next" button is disabled.
	private int checkMarks() {
		int avg_mark = 0;
		try {
				for(int i = 6; i < 12; i++) {
					if(textField[i-6].getText().indexOf("Course") != -1)
						throw new Exception("You need to select 6 courses.");

					int mark = Integer.parseInt(textField[i].getText()); 
					if(mark < 0 || mark > 100)
						throw new Exception("Mark should be between 0 to 100");
					avg_mark += mark;
				}
				avg_mark = avg_mark/6;
		}catch(Exception e) {
			avg_mark = -1;
		}
		
		return avg_mark;
	}
// Load the available course names and add as checkbox title.	
	private void LoadAllCoursesCheckBox()
	{
		for(Courses i: Courses.allcourses) {
			JCheckBox ch = new JCheckBox(i.getCode() + " - " + i.getName());
			allcoursesCheckbox.add(ch);
			allcourseCode.add(i.getCode());
			Dimension s = ch.getSize();
			s.width = s.width + 250;
			ch.setSize(s);
			ch.setOpaque(false);
			ch.setFont(new Font("Tahoma", Font.PLAIN, 16));
			listOfCourses.add(ch);
		}
	}
// Load the selected course and mark from sqlite and display in the Mark panel.	
	private void LoadData() {
		// Load course/mark from sqllist scores table

		Student obj = MainController.getStudent();
		if(obj.getCoursesTaken()[0] != null &&
				!obj.getCoursesTaken()[0].isEmpty()) {	
			for(int i = 0; i < 6; i++) {
				textField[i].setText(obj.getCoursesTaken()[i]);
				textField[i+6].setText(Integer.toString((int)obj.getMarksInCourses()[i]));
			}
		}
		else
			return;
		for(JCheckBox k: allcoursesCheckbox) {
			for(int i = 0; i < 6; i++){
				if(k.getText().indexOf(obj.getCoursesTaken()[i]) == 0) {
					k.setSelected(true);
				}
			}
		}
	}
// Clean up the text fields if click "Reset" button	
	private void clearAllTextFields() {
		for(int i = 0; i < 12; i++) {
			textField[i].setText("");
		}
		for(JCheckBox j :allcoursesCheckbox) {
			j.setSelected(false);
		}
	}
// Save selected courses/marks to the model and SQLite DB.
	private void SaveData() {
		// To match the definition inside Student model.
		String [] course = new String [6];
		String [] mark = new String [6];
		double [] double_mark =  new double [6];
		double avg = 0;
		for(int i = 0; i < 6; i++) {
			course[i] = textField[i].getText();
			mark[i] = textField[i+6].getText();
			double_mark[i] = Double.parseDouble(mark[i]);
			avg += double_mark[i];
		}
		
		avg = avg / 6;
		
		// fill the model member
		Student obj = MainController.getStudent();
		obj.setCoursesTaken(course);
		obj.setMarksInCourses(double_mark);
		obj.setAverageMark(avg);
		MainController.setStudent(obj);
		// save to sqlite.
		SQLiteJDBC.sqliteSaveCourseMarks(course, mark);
		
		
	}
}