package customer;
import org.json.simple.*;

//Customer class
//Implements Comparable so the Customers can be sorted by the user_id 
public class Customer implements Comparable {

	//customer attributes
	private double latitude;
	private double longitude;
	private long user_id;
	private String name;
	

	
	
	public void createCustomer(String jsonLine)
	{
		//String converted to JSONObject
		Object obj=JSONValue.parse(jsonLine);
		JSONObject jsonObject= (JSONObject) obj;
		
		//Each attribute within the JSON file is extracted and set as a Customer object attribute
		this.latitude= Double.parseDouble((String)jsonObject.get("latitude"));
		this.longitude= Double.parseDouble((String)jsonObject.get("longitude"));
		this.user_id= (Long) jsonObject.get("user_id");
		this.name=(String)jsonObject.get("name");
	}
	
	//getter and setter methods
	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public long getUser_id() {
		return user_id;
	}


	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Customer() {
		// TODO Auto-generated constructor stub
		
		
	}

	//compareTo method overriden to compare the user_id of the customer
	@Override
	public int compareTo(Object compareCust) {
		int compareId=(int)((Customer)compareCust).getUser_id();
		// TODO Auto-generated method stub
		return (int)this.getUser_id() -compareId;
	}

}
