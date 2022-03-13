package model;
import java.util.ArrayList;
import utils.*;

public class Courses {
	private String m_course_code;
	private String m_course_name;
	public static ArrayList<Courses> allcourses =  new ArrayList<Courses>(); 
	public void setCode(String v) {
		m_course_code = v;
	}
	public void setName(String v) {
		m_course_name = v;
	}
	public String getCode() {
		return m_course_code;
	}
	public String getName() {
		return m_course_name;
	}
	
	public Courses(String code, String name) {
		m_course_code = code;
		m_course_name = name;
		allcourses.add(this);
	}
}