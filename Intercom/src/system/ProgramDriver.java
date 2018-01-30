package system;
import database.Database;
import java.util.*;
import customer.Customer;

public class ProgramDriver {

	static Database database;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Customers within 100km");
		
		//database initialized and accessed
		database= Database.getInstance();
		
		//Dublin co-ordinates converted to radians
		double dublinLatitude= 53.339428;
		double dublinLongitude= -6.257664;
		dublinLatitude= Math.toRadians(dublinLatitude);
		dublinLongitude= Math.toRadians(dublinLongitude);
		
		//List of customers accessed and sorted by User_ID ascending
		ArrayList<Customer> customers= database.getCustomerList();
		Collections.sort(customers);
		
		//variables for the customer latitude, longitude and distance
		double cLat=0;
		double cLong=0;
		double distance=0;
		
		//iteration of the list of customers
		for(int i=0; i<customers.size();i++)
		{
		//customer co-ordinates converted to radians
		cLat= Math.toRadians(customers.get(i).getLatitude());
		cLong= Math.toRadians(customers.get(i).getLongitude());
		
		//distance between customer and dublin office in kilometres
		distance= distanceCalculator(cLat, cLong,dublinLatitude, dublinLongitude);
		
		//prints out name and user_id of customers within 100km
		if(distance<100)
		{
		System.out.print("Name: " + customers.get(i).getName() + "\t\t");
		System.out.print("User ID: " + customers.get(i).getUser_id() + "\n");
		
		}
	}
		
		
		
		
		
	}
	
	
	//Tested against online longitude/latitude distance calculator https://www.nhc.noaa.gov/gccalc.shtml
	public static double distanceCalculator(double cLat,double cLong, double dLat, double dLong)
	{
		//cLat & cLong are the customers co-ordinates in radians
		//dLat & dLong are the Dublin office co-ordinates in radians
		
		//great circle distance in radians
		double angle= Math.acos(Math.sin(cLat) * Math.sin(dLat)
                + Math.cos(cLat) * Math.cos(dLat) * Math.cos(cLong - dLong));
		
		// convert back to degrees
		angle= Math.toDegrees(angle);
		
		// each degree on a great circle of Earth is 60 nautical miles
        double distance1 = 60 * angle;
        
        //convert to kilometres
        distance1= distance1*1.852;
        
        //return distance in km
		return distance1;
		
	}
	
	

}
