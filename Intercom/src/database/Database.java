package database;
import java.io.*;
import java.util.*;
import customer.*;


public class Database {
	
	//Constant containing the customers.json file name
	private final String customerDatabase = "customers.json";
	
	File customersFile = new File(customerDatabase);
	
	
	Scanner in;
	
	//list of lines in the customer.json file
	ArrayList<String> linesFromCustomerFile= new ArrayList<String>();
	
	//list of customers
	ArrayList<Customer> customerList= new ArrayList<Customer>();
	

	Customer customer;
	
	//static instance of the database
	private static Database databaseFirstInstance = null;

	
		
		
		//when database is initialised the customers.json is read
		private Database() throws IOException
		{
			populateCustomers();
			
			
		}
		
		public void populateCustomers() throws IOException
		{
			// each line of the customers.json file is read
			in = new Scanner(customersFile);
			String lineFromFile="";
			while(in.hasNext())
			{
				lineFromFile = in.nextLine();
				linesFromCustomerFile.add(lineFromFile);
				
				//each line is a different customer
				customer = new Customer();
				
				//line from the customers.json file is converted to a Customer object
				customer.createCustomer(lineFromFile);
				
				//Customer object is added to the list of customers
				customerList.add(customer);
			}
			
		}
		
		public static Database getInstance()
	    {
			//if the database is not initialised a new one is created
	    	if(databaseFirstInstance == null)
	    	{
	    		try 
	    		{
	    			databaseFirstInstance = new Database();
				} 
	    		catch (IOException e)
	    		{
					e.printStackTrace();
				}
	    	}
	    	return databaseFirstInstance;
	    }
		
		//return list of customers
		public ArrayList<Customer> getCustomerList() {
			return customerList;
		}

}
