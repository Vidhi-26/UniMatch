/*
 * Name: Vidhi Ruparel
 * Date: December 16, 2021
 * Description: This frame displays all the programs a user matches with in a table format. 
 */
package view;


//imports
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import controller.MainController;
import model.Program;
import model.Student;


/**
 * AllMatchesFame class sets up a frame that displays all the programs a user matches with in a table format. 
 * The user can also go to the program website by clicking the program name. 
 */
@SuppressWarnings("serial")
public class AllMatchesFrame extends JFrame {
	
	//instance variables
	private HeaderPanel headerPanel = new HeaderPanel();	//header
	
	//table
	private String[] columnNames = {"University", "Program"};
	private String[][] tableData = new String[15][2];
	private JTable programsTable;

	
	//constructor
	public AllMatchesFrame() {
		
		Student student = MainController.getStudent();
		ArrayList<Program> programs = student.getMatchedPrograms();
		
		//changes title of screen
		JLabel tempLabel = headerPanel.getTitleLabel();
		tempLabel.setText("All your matched programs");
		headerPanel.setTitleLabel(tempLabel);
		
		setTitle("UniMatch- Find Your Future");
		setLayout(null);
		setSize(1600, 800);
		this.getContentPane().setBackground(new Color(240, 230, 255));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		headerPanel.setBounds(0, 0, 1600, 100);
		add(headerPanel);
		
		//making the table
		findTableData(programs);
		
		programsTable = new JTable(getTableData(), this.columnNames);
		
		programsTable.setFillsViewportHeight(true);
		programsTable.setFont(new Font("Roboto", Font.PLAIN, 18));
		programsTable.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		
		programsTable.setBounds(100, 150, 1250, 550);
		programsTable.setRowHeight(37);
		
		//changing alignment and font colour of table
		DefaultTableCellRenderer tableRenderer = new DefaultTableCellRenderer();
        tableRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		for (int column = 0; column < programsTable.getColumnCount(); column++) 
			programsTable.getColumnModel().getColumn(column).setCellRenderer(tableRenderer);
		
		TableColumn col = programsTable.getColumnModel().getColumn(1);
		tableRenderer.setForeground(new Color(102, 0, 255));
		col.setCellRenderer(tableRenderer);
	
		//adding link to the program so user can go to the program website by clicking at program link
		programsTable.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked (MouseEvent e) {
				try {
					
					JTable table = (JTable) e.getSource();
					int column = table.columnAtPoint(e.getPoint());
					int row = table.rowAtPoint(e.getPoint());
					
					if (column == 1) {
						Desktop.getDesktop().browse(new URI(programs.get(row).getHyperlink()));
					}
				}
				catch (IOException | URISyntaxException el){
					el.printStackTrace();
				}
			}
			
		});
		
		programsTable.setDefaultEditor(Object.class, null);
		
		add(programsTable);
		
		JLabel message = new JLabel("Click on the program name to visit its website!");
		message.setFont(new Font("Roboto", Font.BOLD, 20));
		message.setBounds(500, 675, 550, 100);
		add(message);
		
		setVisible(true);
	}


	//setters and getters
	public HeaderPanel getHeaderPanel() {
		return headerPanel;
	}

	public void setHeaderPanel(HeaderPanel headerPanel) {
		this.headerPanel = headerPanel;
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	public String[][] getTableData() {
		return tableData;
	}

	public void setTableData(String[][] tableData) {
		this.tableData = tableData;
	}
	

	//utility methods
	/**
	 * Sets the data of the table.
	 * This includes the university and program the user matches with.
	 */
	private void findTableData(ArrayList<Program> programs) {
		
		Object[] matchedPrograms = programs.toArray();
		
		String[][] temp = new String[15][2];
		
		for (int index = 0; index < matchedPrograms.length; index++) {
			
			Program program = (Program) matchedPrograms[index];
			
			temp[index][0] = MatchBoxPanel.correctUniversityName(program.getUniversity());
			
			temp[index][1] = MatchBoxPanel.correctProgramName(program.getProgram());
			
			setTableData(temp);
			
		}
		
	}	//end of findTableData method
	
	
}	//end of MatchesFrame class

