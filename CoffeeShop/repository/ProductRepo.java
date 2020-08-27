package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class ProductRepo implements IProductRepo
{
	DatabaseConnection dbc;
	
	public ProductRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertProduct(Product p)
	{
		String query = "INSERT INTO products VALUES ('"+p.getPId()+"','"+p.getName()+"','"+p.getQuantity()+"',"+p.getPrice()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteProduct(String pId)
	{
		String query = "DELETE from products WHERE pId='"+pId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateProduct(Product p)
	{
		String query = "UPDATE products SET productName='"+p.getName()+"', quantity = "+p.getQuantity()+", price = "+p.getPrice()+" WHERE cId='"+p.getPId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Product searchProduct(String pId)
	{
		Product pro = null;
		String query = "SELECT `productName`, `quantity`, `price` FROM `products` WHERE `pId`='"+pId+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String name = dbc.result.getString("productName");
				int quantity = dbc.result.getInt("quantity");
				double price = dbc.result.getDouble("price");
				
				pro = new Product();
				pro.setPId(pId);
				pro.setName(name);
				pro.setQuantity(quantity);
				pro.setPrice(price);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return pro;
	}
	public String[][] getAllProduct()
	{
		ArrayList<Product> ar = new ArrayList<Product>();
		String query = "SELECT * FROM products;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String pId = dbc.result.getString("pId");
				String name = dbc.result.getString("productName");
				int quantity = dbc.result.getInt("quantity");
				double price = dbc.result.getDouble("price");
				
				Product p = new Product(pId,name,quantity,price);
				ar.add(p);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][4];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Product)obj[i]).getPId();
			data[i][1] = ((Product)obj[i]).getName();
			data[i][2] = (((Product)obj[i]).getQuantity())+"";
			data[i][3] = (((Product)obj[i]).getPrice())+"";
		}
		return data;
	}
}




