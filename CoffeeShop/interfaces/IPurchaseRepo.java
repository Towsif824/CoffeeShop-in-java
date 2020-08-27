package interfaces;

import java.lang.*;

import entity.*;

public interface IPurchaseRepo
{
	public void insertPurchase(Purchase pr);
	public void deletePurchase(String prId);
	public void updatePurchase(Purchase pr);
	public Purchase searchPurchase(String prId);
	//public Purchase getPurchase(String prId);
	public String[][] getAllPurchase();
}