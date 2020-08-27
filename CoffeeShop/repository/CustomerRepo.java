package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class CustomerRepo implements ICustomerRepo
{
	DatabaseConnection dbc;
	
	public CustomerRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void Customer(Customer c)
	{
		String query = "INSERT INTO customer VALUES ('"+c.getCId()+"','"+c.getName()+"','"+c.getAddress()+"',"+c.getBill()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteCustomer(String cId)
	{
		String query = "DELETE from customer WHERE cId='"+cId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateCustomer(Customer c)
	{
		String query = "UPDATE customer SET customerName='"+c.getName()+"', address = '"+c.getAddress()+"', bill = "+c.getBill()+" WHERE cId='"+c.geCId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Customer searchCustomer(String cId)
	{
		Customer c = null;
		String query = "SELECT `customerName`, `address`, `bill` FROM `customer` WHERE `cId`='"+cId+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String name = dbc.result.getString("customerName");
				String address = dbc.result.getString("address");
				double bill = dbc.result.getDouble("bill");
				
				c = new Customer();
				c.setCId(cId);
				c.setName(name);
				c.setRequestOrder(address);
				c.setBill(bill);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return c;
	}
	public String[][] getAllCustomer()
	{
		ArrayList<Customer> ar = new ArrayList<Customer>();
		String query = "SELECT * FROM customer;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String cId = dbc.result.getString("cId");
				String name = dbc.result.getString("customerName");
				String address = dbc.result.getString("address");
				double bill = dbc.result.getDouble("bill");
				
				Customer c = new Customer(cId,name,address,bill);
				ar.add(c);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][4];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Customer)obj[i]).getCId();
			data[i][1] = ((Customer)obj[i]).getName();
			data[i][2] = ((Customer)obj[i]).getAddress();
			data[i][3] = (((Customer)obj[i]).getBill())+"";
		}
		return data;
	}
}




