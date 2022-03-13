package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.SwingConstants;


import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This is the class for the home screen which contains
 * the users: Name, Average, Courses, Extracurriculars;  
 * a button to proceed to the 'uniMatch quiz'
 * 
 * @author John Selvin
 */

public class HomeScreenFrame extends JFrame{

	private HomeScreenPanel homeScreenPanel = new HomeScreenPanel();

	// Constructors
	public HomeScreenFrame() {
		setupFrame();
	}

	private void setupFrame() {
		setSize(1600,900);
		setTitle("UniMatch - Find Your Future");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(homeScreenPanel);
		setVisible(true);
	}

}