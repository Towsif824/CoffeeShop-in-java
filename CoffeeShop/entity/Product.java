package entity;

import java.lang.*;

public class Product
{
	private String pId;
	private String name;
	private int quantity;
	private double price;
	
	public Product(){}
	public Product(String pId, String name, int quantity, double price)
	{
		this.pId = pId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	public void setPId(String pId){this.pId = pId;}
	public void setName(String name){this.name = name;}
	public void setQuantity(int quantity){this.quantity = quantity;}
	public void setPrice(double price){this.price = price;}
	
	public String getPId(){return pId;}
	public String getName(){return name;}
	public int getQuantity(){return quantity;}
	public double getPrice(){return price;}
}