package com.view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.*;


public class MainView implements ActionListener{
	
	
	
	public static void main(String[] args)
	
	{
		MainView tempclient = new MainView();
		
		//jframe.getContentPane().add(emptyLabel, )
	}
	
	private MainView() {
		JFrame jframe = new JFrame("Client");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setTitle("QQ");
		jframe.setSize(600,600);
		
		jframe.setResizable(false);
		jframe.setLayout(new FlowLayout());
		
		JButton jbutton = new JButton("Check Employee");
		jbutton.setActionCommand("Check Employee");
		jbutton.addActionListener(this); //this refers to client
		
		JButton jbutton2 = new JButton("Click Me 2");
		jbutton2.addActionListener(this);
		
		JMenuBar jmenubar = new JMenuBar();
		
		JMenu file = new JMenu("File");
		
		JMenuItem newmenuitem = new JMenuItem("New");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem close = new JMenuItem("Exit");
		close.addActionListener(this);
		JMenuItem extra = new JMenu("Extra"); //Jmenu
		
		JMenuItem hello1 = new JMenuItem("Hello1");
		JMenuItem hello2 = new JMenuItem("Hello2");
		
		extra.add(hello1);
		extra.add(hello2);
		
		file.add(newmenuitem);
		file.add(save);
		file.add(extra);
		file.addSeparator();
		file.add(close);
		
		JPanel jpanelTop = new JPanel();
		
		//JMenuItem[] items = {open, save, saveas,exit};
		
		
		//for (JMenuItem item: items) {
		//	item.addActionListener(this);
		//}
		
		
		jmenubar.add(file);
		
		JTextArea text = new JTextArea();
		
		jpanelTop.add(text);
		//text.setBorder(null);
		
		
		jframe.add(jpanelTop);//,BorderLayout.WEST
		jframe.add(jbutton);
		jframe.add(jbutton2);
		jframe.setJMenuBar(jmenubar);
		jframe.setVisible(true);
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		
		if (name.equals("Check Employee"))
		{
			CheckEmployee checkEmployee1= new CheckEmployee();
		}
		
		else if (name.equalsIgnoreCase("Click Me 2")) {
			System.out.println("Click Me 2");
		}
		else if (name.equalsIgnoreCase("Exit")) {
			System.out.println("Exit");
			System.exit(0);
		}
		
	}
	
}
