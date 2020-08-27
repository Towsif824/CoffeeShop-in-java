package entity;

import java.lang.*;

public class Customer
{
	private String cId;
	private String name;
	private String address;
	private double bill;
	
	public Customer(){}
	public Customer(String cId, String name, String address, double bill)
	{
		this.cId = cId;
		this.name = name;
		this.address = address;
		this.bill = bill;
	}
	
	public void setCId(String cId){this.cId = cId;}
	public void setName(String name){this.name = name;}
	public void setRequestOrder(String address){this.address = address;}
	public void setBill(double bill){this.bill = bill;}
	
	public String getCId(){return cId;}
	public String getName(){return name;}
	public String getRequestOrder(){return address;}
	public double getBill(){return bill;}
}