package entity;

import java.lang.*;

public class Purchase
{
	private String prId;
	private String pId;
	private String cId;
	private int quantity;
	private double price;
	
	public Purchase(){}
	public Purchase(String prId, String pId, String cId, int quantity, double price)
	{
		this.prId = prId;
		this.pId = pId;
		this.cId = cId;
		this.quantity = quantity;
		this.price = price;
	}
	
	public void setPrId(String prId){this.prId = prId;}
	public void setPId(String pId){this.pId = pId;}
	public void setCId(String cId){this.cId = cId;}
	public void setQuantity(int quantity){this.quantity = quantity;}
	public void setPrice(double price){this.price = price;}
	
	public String getPrId(){return prId;}
	public String getPId(){return pId;}
	public String getCId(){return pId;}
	public int getQuantity(){return quantity;}
	public double getPrice(){return price;}
}