package interfaces;

import java.lang.*;

import entity.*;

public interface ICustomer
{
	public void insertCustomer(Customer c);
	public void deleteCustomer(String cId);
	public void updateCustomer(Customer c);
	public Customer searchCustomer(String cId);
	//public Customer getCustomer(String cId);
	public String[][] getAllCustomer();
}