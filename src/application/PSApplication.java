package application;

import utils.SQLiteJDBC;
import view.*;
public class PSApplication {
//	public static String currentUser = "JasperFei";
	public static void main(String[] args) {
		SQLiteJDBC.sqliteLoadAllCourses();
		SQLiteJDBC.sqliteLoadCourseMarks();

		new CourseDialog().setVisible(true);

	}

}