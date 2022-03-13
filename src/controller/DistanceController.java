package controller;
import model.*;
import utils.SQLiteJDBC;

public class DistanceController {
	private static final double BurOak_X = 43.89667992593892;
	private static final double BurOak_Y = -79.2688678304612;
	
	
	public static void LoadUniversities() {
		SQLiteJDBC.sqliteLoadUniversityInfo();
	}

	public static double getDistance(String uni) {
		double distance = 0;
		for(University i: University.Universities) {
			if(i.getM_name().equals(uni)) {
				distance = getDistance(i.getM_X(), i.getM_Y(), BurOak_X, BurOak_Y, "K");
				break;
			}
		}
		return distance;
	}
	
//  /*::    unit = the unit you desire for results                               :*/
	/*::           where: 'M' is statute miles (default)                         :*/
	/*::                  'K' is kilometers                                      :*/
	/*::                  'N' is nautical miles									  */
	
	private static double getDistance(double lat1, double lon1, double lat2, double lon2, String unit) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			if (unit.equals("K")) {
				dist = dist * 1.609344;
			} else if (unit.equals("N")) {
				dist = dist * 0.8684;
			}
			return (dist);
		}
	}	
}