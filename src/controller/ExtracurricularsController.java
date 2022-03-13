/*
 * Name: Sylvia
 * Date: 2021/12/16
 * Title: Post-secondary App, ExtracurricularsController
 * Description: This class contains methods to calculate points of extracurricular activities done and
 * competitions participated
 * Features: calculate total points for extracurricular activities, calculate points for places in competitions
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Student;

public class ExtracurricularsController {

//	private static int totalPoints;

	
//	public ExtracurricularsController() {
//
//		extracurricularsNumCal(student);
//		competitionCal(student);
//	}

	//calculate points for number of activities user has
	public static void extracurricularsNumCal ()
	{
		Student student = MainController.getStudent();
		boolean [] extracurricularsNum = student.getExtracurricularsDone();
		int point = student.getExtraCurricularPoints();
		for (int i=0; i<extracurricularsNum.length; i++)
		{
			if(extracurricularsNum[i]==true)
			{
				point++;
				student.setExtraCurricularPoints(point);
			}
		}
		MainController.setStudent(student);
		
		
	}
	
	//calculate points for competitions
	public static void competitionCal () {
			
		//points += points;
		//four points for a first place, three points for a second place...
		Student student = MainController.getStudent();
		int [] placesInComp = student.getPlacesInCompetitions();
		int point = student.getExtraCurricularPoints();
		
		if(placesInComp[0]>0)
		{
			point+=placesInComp[0]*4;
			student.setExtraCurricularPoints(point);
		}
		if(placesInComp[1]>0)
		{
			point+=placesInComp[1]*3;
			student.setExtraCurricularPoints(point);
		}
		if(placesInComp[2]>0)
		{
			point+=placesInComp[2]*2;
			student.setExtraCurricularPoints(point);
		}
		if(placesInComp[3]>0)
		{
			point+=placesInComp[3];
			student.setExtraCurricularPoints(point);
		}
		
		MainController.setStudent(student);
	}

}
