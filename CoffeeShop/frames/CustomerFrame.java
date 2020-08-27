package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class CustomerFrame extends JFrame implements ActionListener
{
	private JLabel pIdLabel, productNameLabel, quantityLabel, priceLabel;
	private JTextField pIdTF, productNameTF, quantityTF, priceTF;
	private JButton getAllBtn, backBtn;
	private JPanel panel;
	private JTable pTable;
	private JScrollPane pTableSP;
	
	private User user;
	//private CustomerRepo cr;
	private UserRepo ur;
	private ProductRepo pr;
	
	
	public CustomerFrame(User user)
	{
		super("CustomerFrame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		pr = new ProductRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", ""}};
		
		String head[] = {"Id", "Name", "Quantity", "Price"};
		
		pTable = new JTable(data,head);
		pTableSP = new JScrollPane(pTable);
		pTableSP.setBounds(350, 100, 400, 150);
		pTable.setEnabled(false);
		panel.add(pTableSP);
		
		pIdLabel = new JLabel("ID :");
		pIdLabel.setBounds(100,100,100,30);
		panel.add(pIdLabel);
		
		pIdTF = new JTextField();
		pIdTF.setBounds(220,100,100,30);
		panel.add(pIdTF);
		
		productNameLabel = new JLabel("Name :");
		productNameLabel.setBounds(100,150,100,30);
		panel.add(productNameLabel);
		
		productNameTF = new JTextField();
		productNameTF.setBounds(220,150,100,30);
		panel.add(productNameTF);
		
		quantityLabel = new JLabel("Quantity: ");
		quantityLabel.setBounds(100,200,100,30);
		panel.add(quantityLabel);
		
		quantityTF = new JTextField();
		quantityTF.setBounds(220,200,100,30);
		panel.add(quantityTF);
		
		priceLabel = new JLabel("Price: ");
		priceLabel.setBounds(100,250,100,30);
		panel.add(priceLabel);
		
		priceTF = new JTextField();
		priceTF.setBounds(220,250,100,30);
		panel.add(priceTF);
		
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
		
		if(command.equals(getAllBtn.getText()))
		{
			String data[][] = pr.getAllProduct();
			String head[] = {"Id", "Name", "Quantity", "Price"};
			
			panel.remove(pTableSP);
			
			pTable = new JTable(data,head);
			pTable.setEnabled(false);
			pTableSP = new JScrollPane(pTable);
			pTableSP.setBounds(350, 100, 400, 150);
			panel.add(pTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		else if(command.equals(backBtn.getText()))
		{
			CustomerHome ch = new CustomerHome(user);
			ch.setVisible(true);
			this.setVisible(false);
		}
		else{}
		
	}
}