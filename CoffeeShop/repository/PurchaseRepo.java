package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class PurchaseRepo implements IPurchaseRepo
{
	DatabaseConnection dbc;
	
	public PurchaseRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertPurchase(Purchase pr)
	{
		String query = "INSERT INTO purchase VALUES ('"+pr.getPrId()+"','"+pr.getPId()+"','"+pr.getCId()+"','"+pr.getQuantity()+"',"+pr.getPrice()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deletePurchase(String prId)
	{
		String query = "DELETE from purchase WHERE prId='"+prId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updatePurchase(Purchase pr)
	{
		String query = "UPDATE purchase SET pId='"+pr.getPId()+"',cId = '"+pr.getCId()+"', quantity = "+pr.getQuantity()+", price = "+pr.getPrice()+" WHERE prId='"+pr.getPrId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Purchase searchPurchase(String prId)
	{
		Purchase pur = null;
		String query = "SELECT `pId`, `cId`,`quantity`, `price` FROM `purchase` WHERE `prId`='"+prId+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String pId = dbc.result.getString("pId");
				String cId = dbc.result.getString("cId");
				int quantity = dbc.result.getInt("quantity");
				double price = dbc.result.getDouble("price");
				
				pur = new Purchase();
				pur.setPrId(prId);
				pur.setPId(pId);
				pur.setCId(cId);
				pur.setQuantity(quantity);
				pur.setPrice(price);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return pur;
	}
	public String[][] getAllPurchase()
	{
		ArrayList<Purchase> ar = new ArrayList<Purchase>();
		String query = "SELECT * FROM purchase;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String prId = dbc.result.getString("prId");
				String pId = dbc.result.getString("pId");
				String cId = dbc.result.getString("cId");
				int	quantity = dbc.result.getInt("quantity");
				double price = dbc.result.getDouble("price");
				
				Purchase pr = new Purchase(prId,pId,cId,quantity,price);
				ar.add(pr);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][5];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Purchase)obj[i]).getPrId();
			data[i][1] = ((Purchase)obj[i]).getPId();
			data[i][2] = ((Purchase)obj[i]).getCId();
			data[i][3] = (((Purchase)obj[i]).getQuantity())+"";
			data[i][4] = (((Purchase)obj[i]).getPrice())+"";
		}
		return data;
	}
}




