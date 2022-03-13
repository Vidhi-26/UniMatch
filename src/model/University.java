package model;

import java.util.ArrayList;

import utils.SQLiteJDBC;

public class University {
	private String m_name;
	private String m_address;
	private Double m_X;
	private Double m_Y;
	public static ArrayList<University> Universities = new ArrayList<University>();
	
	public University(String name, String address, double X, double Y) {
		m_name = name;
		m_address = address;
		m_X = X;
		m_Y = Y;
		Universities.add(this);
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_address() {
		return m_address;
	}
	public void setM_address(String m_address) {
		this.m_address = m_address;
	}
	public Double getM_X() {
		return m_X;
	}
	public void setM_X(Double m_X) {
		this.m_X = m_X;
	}
	public Double getM_Y() {
		return m_Y;
	}
	public void setM_Y(Double m_Y) {
		this.m_Y = m_Y;
	}
	
	
}