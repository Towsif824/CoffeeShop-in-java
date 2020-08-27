package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class PurchaseFrame extends JFrame implements ActionListener
{
	private JLabel prIdLabel, purchaseNameLabel, quantityLabel, priceLabel,customerIdLabel;
	private JTextField prIdTF, purchaseNameTF, quantityTF,priceTF,customerIdTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable prTable;
	private JScrollPane prTableSP;
	
	private User user;
	private UserRepo ur;
	private PurchaseRepo pur;
	
	
	public PurchaseFrame(User user)
	{
		super("PurchaseFrame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		//er = new EmployeeRepo();
		ur = new UserRepo();
		pur = new PurchaseRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "","", ""}};
		
		String head[] = {"Id", "ProductID","CustomerID" ,"Quantity", "Price"};
		
		prTable = new JTable(data,head);
		prTableSP = new JScrollPane(prTable);
		prTableSP.setBounds(350, 100, 400, 150);
		prTable.setEnabled(false);
		panel.add(prTableSP);
		
		prIdLabel = new JLabel("ID :");
		prIdLabel.setBounds(100,100,100,30);
		panel.add(prIdLabel);
		
		prIdTF = new JTextField();
		prIdTF.setBounds(220,100,100,30);
		panel.add(prIdTF);
		
		purchaseNameLabel = new JLabel("ProductID :");
		purchaseNameLabel.setBounds(100,150,100,30);
		panel.add(purchaseNameLabel);
		
		purchaseNameTF = new JTextField();
		purchaseNameTF.setBounds(220,150,100,30);
		panel.add(purchaseNameTF);
		
		customerIdLabel = new JLabel("CustomerID :");
		customerIdLabel.setBounds(100,200,100,30);
		panel.add(customerIdLabel);
		
		customerIdTF = new JTextField();
		customerIdTF.setBounds(220,200,100,30);
		panel.add(customerIdTF);
		
		quantityLabel = new JLabel("Quantity: ");
		quantityLabel.setBounds(100,250,100,30);
		panel.add(quantityLabel);
		
		
		quantityTF = new JTextField();
		quantityTF.setBounds(220,250,100,30);
		panel.add(quantityTF);
		
		priceLabel = new JLabel("Price: ");
		priceLabel.setBounds(100,300,100,30);
		panel.add(priceLabel);
		
		priceTF = new JTextField();
		priceTF.setBounds(220,300,100,30);
		panel.add(priceTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,300,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(200,300,80,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(300,300,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(400,300,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(500,300,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(500,260,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 350, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loadBtn.getText()))
		{
			if(!prIdTF.getText().equals("") || !prIdTF.getText().equals(null))
			{
				Purchase p = pur.searchPurchase(prIdTF.getText());
				if(p!= null)
				{
					purchaseNameTF.setText(p.getPId());
					customerIdTF.setText(p.getCId());
					quantityTF.setText(p.getQuantity()+"");
					priceTF.setText(p.getPrice()+"");
					
					prIdTF.setEnabled(false);
					purchaseNameTF.setEnabled(true);
					customerIdTF.setEnabled(true);
					quantityTF.setEnabled(true);
					priceTF.setEnabled(true);
					
					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			Purchase e = new Purchase();
			
			e.setPrId(prIdTF.getText());
			e.setPId(purchaseNameTF.getText());
			e.setCId(customerIdTF.getText());
			e.setQuantity(Integer.parseInt(quantityTF.getText()));
			e.setPrice(Double.parseDouble(priceTF.getText()));
			
			pur.insertPurchase(e);
			
			JOptionPane.showMessageDialog(this, "Inserted");
			
			prIdTF.setText("");
			purchaseNameTF.setText("");
			customerIdTF.setText("");
			quantityTF.setText("");
			priceTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			prIdTF.setText("");
			purchaseNameTF.setText("");
			customerIdTF.setText("");
			quantityTF.setText("");
			priceTF.setText("");
			
			prIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Purchase e = new Purchase();
			
			e.setPrId(prIdTF.getText());
			e.setPId(purchaseNameTF.getText());
			e.setCId(customerIdTF.getText());
			e.setQuantity(Integer.parseInt(quantityTF.getText()));
			e.setPrice(Double.parseDouble(priceTF.getText()));
			
			pur.updatePurchase(e);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			prIdTF.setText("");
			purchaseNameTF.setText("");
			customerIdTF.setText("");
			quantityTF.setText("");
			priceTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			prIdTF.setEnabled(true);
			purchaseNameTF.setEnabled(true);
			customerIdTF.setEnabled(true);
			quantityTF.setEnabled(true);
			priceTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			pur.deletePurchase(prIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			prIdTF.setText("");
			purchaseNameTF.setText("");
			customerIdTF.setText("");
			quantityTF.setText("");
			priceTF.setText("");
			
			prIdTF.setEnabled(true);
			purchaseNameTF.setEnabled(true);
			customerIdTF.setEnabled(true);
			quantityTF.setEnabled(true);
			priceTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = pur.getAllPurchase();
			String head[] = {"Id", "ProductID", "CustomerID","Quantity", "Price"};
			
			panel.remove(prTableSP);
			
			prTable = new JTable(data,head);
			prTable.setEnabled(false);
			prTableSP = new JScrollPane(prTable);
			prTableSP.setBounds(350, 100, 400, 150);
			panel.add(prTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		
		else if(command.equals(backBtn.getText()))
		{
			EmployeeHome eh = new EmployeeHome(user);
			eh.setVisible(true);
			this.setVisible(false);
		}
		else{}
		
	}
}