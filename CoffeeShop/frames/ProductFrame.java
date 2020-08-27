package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class ProductFrame extends JFrame implements ActionListener
{
	private JLabel pIdLabel, productNameLabel, quantityLabel, priceLabel;
	private JTextField pIdTF, productNameTF, quantityTF,priceTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable pTable;
	private JScrollPane pTableSP;
	
	private User user;
	private UserRepo ur;
	private ProductRepo pr;
	
	
	public ProductFrame(User user)
	{
		super("ProductFrame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		

		ur = new UserRepo();
		pr = new ProductRepo();
		
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
			if(!pIdTF.getText().equals("") || !pIdTF.getText().equals(null))
			{
				Product p = pr.searchProduct(pIdTF.getText());
				if(p!= null)
				{
					productNameTF.setText(p.getName());
					quantityTF.setText(p.getQuantity()+"");
					priceTF.setText(p.getPrice()+"");
					
					pIdTF.setEnabled(false);
					productNameTF.setEnabled(true);
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
			Product e = new Product();

			
			e.setPId(pIdTF.getText());
			e.setName(productNameTF.getText());
			e.setQuantity(Integer.parseInt(quantityTF.getText()));
			e.setPrice(Double.parseDouble(priceTF.getText()));
			
			
			pr.insertProduct(e);

			
			pIdTF.setText("");
			productNameTF.setText("");
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
			pIdTF.setText("");
			productNameTF.setText("");
			quantityTF.setText("");
			priceTF.setText("");
			
			pIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Product e = new Product();
			
			e.setPId(pIdTF.getText());
			e.setName(productNameTF.getText());
			e.setQuantity(Integer.parseInt(quantityTF.getText()));
			e.setPrice(Double.parseDouble(priceTF.getText()));
			
			pr.updateProduct(e);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			pIdTF.setText("");
			productNameTF.setText("");
			quantityTF.setText("");
			priceTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			pIdTF.setEnabled(true);
			productNameTF.setEnabled(true);
			quantityTF.setEnabled(true);
			priceTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			pr.deleteProduct(pIdTF.getText());

			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			pIdTF.setText("");
			productNameTF.setText("");
			quantityTF.setText("");
			priceTF.setText("");
			
			pIdTF.setEnabled(true);
			productNameTF.setEnabled(true);
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
			EmployeeHome eh = new EmployeeHome(user);
			eh.setVisible(true);
			this.setVisible(false);
		}
		else{}
		
	}
}