/***
 * Author: Jasper Fei
 * 
 * SQLite function to Save/Load Course Marks, Load all the available courses, Load all the university info.
 * SQLite db file is under Files/ouac.db. You can use www.sqliteonline.com online IDE to view/modify it. 
 */

package utils;
import java.sql.*;
import controller.*;

import model.*;

public class SQLiteJDBC {
    private static Connection con = null;
    public static Statement stmt = null;
    public SQLiteJDBC() {
    
    }
// Save the selected courses/marks of the current user.    
    public static void sqliteSaveCourseMarks(String [] Codelist, String [] Marklist) {
	    try {
		       Class.forName("org.sqlite.JDBC");
		       con = DriverManager.getConnection("jdbc:sqlite:Files/ouac.db");
		       con.setAutoCommit(false);
	    	   stmt = con.createStatement();
/*	    	   
	    	   try {
		    	   stmt.executeQuery( "DELETE FROM scores where USERNAME = '" + PSApplication.currentUser + "';");
		    	   con.commit();
	    	   } catch(Exception e) {
	    		   // JOptionPane.showMessageDialog(null, e.getMessage());
	    		   // Ignore empty rows exception.
	    	   }
*/	    	   
	    	   // CODE1 ... CODE8 are the format of CODE:SCORE 
	    	   String sql = String.format("insert or replace into scores (USERNAME, CODE1, MARK1, CODE2, MARK2, CODE3, MARK3, CODE4, MARK4, CODE5, MARK5, CODE6, MARK6) "
	    	   + "values('%s','%s','%d','%s','%d','%s','%d','%s','%d','%s','%d','%s','%d')", MainController.getStudent().getUsername(), 
	    	   Codelist[0], Integer.parseInt(Marklist[0]), Codelist[1], Integer.parseInt(Marklist[1]), 
	    	   Codelist[2], Integer.parseInt(Marklist[2]), Codelist[3], Integer.parseInt(Marklist[3]), 
	    	   Codelist[4],Integer.parseInt(Marklist[4]), Codelist[5], Integer.parseInt(Marklist[5]));
	    	   stmt.executeUpdate(sql);
	    	   
	    	   con.commit();
    	       stmt.close();
    	       con.close();		       
		    } catch ( Exception e ) {
		       System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		       System.exit(0);
		    }
    }

 // Load the selected courses/marks of the current user for displaying     
    public static void sqliteLoadCourseMarks() {
    	String [] code = new String [6];
    	String [] mark = new String [6];
    	// To match the definition in Student model.
    	double [] mark_double = new double [6];
    	
	    try {
		       Class.forName("org.sqlite.JDBC");
		       con = DriverManager.getConnection("jdbc:sqlite:Files/ouac.db");
		       con.setAutoCommit(false);
	    	   stmt = con.createStatement();
	    	   ResultSet rs = stmt.executeQuery( "SELECT * FROM scores where USERNAME = '"+ MainController.getStudent().getUsername() + "';");
	    	   while ( rs.next() ) {
	    		   	
	    	         code[0] = rs.getString("CODE1");
	    	         mark[0] = Integer.toString(rs.getInt("MARK1"));
	    	         code[1] = rs.getString("CODE2");
	    	         mark[1] = Integer.toString(rs.getInt("MARK2"));
	    	         code[2] = rs.getString("CODE3");
	    	         mark[2] = Integer.toString(rs.getInt("MARK3"));
	    	         code[3] = rs.getString("CODE4");
	    	         mark[3] = Integer.toString(rs.getInt("MARK4"));
	    	         code[4] = rs.getString("CODE5");
	    	         mark[4] = Integer.toString(rs.getInt("MARK5"));
	    	         code[5] = rs.getString("CODE6");
	    	         mark[5] = Integer.toString(rs.getInt("MARK6"));
	    
	    	         for(int i = 0; i < 6; i++) {
	    	        	 mark_double[i] = Double.parseDouble(mark[i]);
	    	         }
	    	         
	    	         Student temp = MainController.getStudent();
	    	         temp.setCoursesTaken(code);
	    	         temp.setMarksInCourses(mark_double);
	    	         
	    	         MainController.setStudent(temp);    		     

	    	   }
    	      rs.close();
    	      stmt.close();
    	      con.close();		       
		    } catch ( Exception e ) {
		       System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		       System.exit(0);
		    }
    }
    
// Load all the available courses from SQLite    
    public static void sqliteLoadAllCourses() {
    	String  course_code;
    	String  course_name;
	    try {
		       Class.forName("org.sqlite.JDBC");
		       con = DriverManager.getConnection("jdbc:sqlite:Files/ouac.db");
		       con.setAutoCommit(false);
	    	   stmt = con.createStatement();
	    	   ResultSet rs = stmt.executeQuery( "SELECT * from CourseCode where name LIKE \"Grade 12%\"" );
	    	   while ( rs.next() ) {
	    	         course_code = rs.getString("code");
	    	         course_name = rs.getString("name");
	    	         new Courses(course_code, course_name);
	    	   }
    	      rs.close();
    	      stmt.close();
    	      con.close();		       
		    } catch ( Exception e ) {
		       System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		       System.exit(0);
		    }
    }
// Load all the university information - name, address, X-cord, Y-cord    
    public static void sqliteLoadUniversityInfo() {
    	String name;
    	String address;
    	double X;
    	double Y;
	    try {
		       Class.forName("org.sqlite.JDBC");
		       con = DriverManager.getConnection("jdbc:sqlite:Files/ouac.db");
		       con.setAutoCommit(false);
	    	   stmt = con.createStatement();
	    	   ResultSet rs = stmt.executeQuery( "SELECT * FROM University;" );
	    	   while ( rs.next() ) {
	    	         name = rs.getString("name");
	    	         address = rs.getString("address");
	    	         X = rs.getDouble("X");
	    	         Y = rs.getDouble("Y");
	    	         new University(name, address, X, Y);
	    	   }
	 	      rs.close();
	 	      stmt.close();
	 	      con.close();		       
		    } catch ( Exception e ) {
		       System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		       System.exit(0);
		    }
    }
}