package com.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;


public class CheckEmployee implements ActionListener{
	
	
	JTextField JTextField1=null;
	
	
	CheckEmployee() {
		JFrame jframe = new JFrame("Client");
		//jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setTitle("Check Employee");
		jframe.setBounds(0,0,600,600);
		
		jframe.setResizable(false);
		jframe.getContentPane().setLayout(null);
		 Container c=jframe.getContentPane();
		
		 Label label1= new Label("CompanyID");
		 Label label2= new Label("Company Employee ID"); 
		 
		 JTextField1= new JTextField("CompanyID");
		JTextField JTextField2= new JTextField("Company Employee ID");
		
		JButton jbutton = new JButton("Check");
		jbutton.setActionCommand("Check");
		jbutton.addActionListener(this); //this refers to client
		
		JButton jbutton2 = new JButton("Update");
		jbutton2.addActionListener(this);
		
		JButton jbutton3 = new JButton("Exit");
		jbutton2.addActionListener(this);
		
		
		
		JPanel jpanelTop = new JPanel();
		
		JPanel jpanelBottom = new JPanel();
		
		
		
		
		//JTextArea text = new JTextArea();
		
		//jpanelTop.add(text);
		//jpanelTop.add(JTextField1);
		//jpanelBottom.add(JTextField2);
		
	
		//jpanelBottom.add(jbutton);
		//jpanelBottom.add(jbutton2);
		//jframe.add(JTextField1,"Center");//,BorderLayout.WEST
		//jframe.add(jpanelBottom,"Center");
		
		//jframe.setVisible(true);
		label1.setBounds(30,30,200,30);
		label2.setBounds(30,50,300,30);
		JTextField1.setBounds(30,100,300,30);
		jbutton.setBounds(90,200,80,30);
		jbutton2.setBounds(90,280,80,30);
		c.add(label1);
		c.add(label2);
		c.add(JTextField1);
		  c.add(jbutton);
		  c.add(jbutton2);
		  jframe.setVisible(true);
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		
		if (name.equals("Check"))
		{
			System.out.println("Check");

			
			SQLConnect tempSqlConnect = new SQLConnect();
			//tempSqlConnect.dbConnect();
			Statement tempStatement = tempSqlConnect.dbConnect("dev_data");
			 ResultSet rs = tempSqlConnect.selectEmployeeQuery("263", "TM01112486");
			if (rs != null)
			{
				String password="";
				
					try {
						while (rs.next()) {
							
							password = rs.getString("user_key");
						     
						   }
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				Decrypt tempDecrypt = new Decrypt();
				password = tempDecrypt.decode(password);
				JTextField1.setText(password);
				//System.out.print(password);
			}
			//System.out.print(tempSqlConnect.selectEmployeeQuery("263", "TM01112486"));
			//jframe.getContentPane().add(emptyLabel, )
			//System.out.println("daa");
		
		}
		
		else if (name.equalsIgnoreCase("Update")) {
			System.out.println("Update");
		}
		else if (name.equalsIgnoreCase("Exit")) {
			System.out.println("Exit");
			System.exit(0);
		}
		
	}
	
}
