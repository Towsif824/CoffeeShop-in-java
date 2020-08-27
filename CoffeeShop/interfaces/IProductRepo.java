package interfaces;

import java.lang.*;

import entity.*;

public interface IProductRepo
{
	public void insertProduct(Product p);
	public void deleteProduct(String pId);
	public void updateProduct(Product p);
	public Product searchProduct(String pId);
	//public Product getProduct(String pId);
	public String[][] getAllProduct();
}