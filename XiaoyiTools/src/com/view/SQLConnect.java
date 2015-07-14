package com.view;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Xiaoyi
 */
public class SQLConnect {
    Statement statement;
    Connection conn;
   public Statement dbConnect(String databaseName)
   {
      try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          conn = DriverManager.getConnection("jdbc:sqlserver://10.208.121.234;databaseName="+databaseName+";","xiaoyic","bd9ap2cu");
         System.out.println("connected");
         statement = conn.createStatement();        
        
         
      } catch (Exception e) {
         e.printStackTrace();
      }
      return statement;
   }
   
   public Statement returnStatement()
  {
	 if (conn != null)
	 {	 
     try {
          statement = conn.createStatement();        
       
     } catch (Exception e) {
        e.printStackTrace();
     }
	 }
     return statement;
  }
   
   public Statement dbConnect()
  {
     try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         conn = DriverManager.getConnection("jdbc:sqlserver://10.208.121.234;databaseName=dev_data;","xiaoyic","bd9ap2cu");
        System.out.println("connected");
        statement = conn.createStatement();        
       
     } catch (Exception e) {
        e.printStackTrace();
     }
     return statement;
  }
   public ResultSet selectEmployeeQuery(String companyId,String companyEmployeeId)
   {
	   String queryString = "select top 1* from reward_employees re join reward_user ru on re.user_id = ru.user_id where re.company_id="+companyId+"and company_employee_id='"+companyEmployeeId+"'";
	   ResultSet rs = null;
	   //Row Count
	   int rsCount = 0;
	  // System.out.println("da444a");
	 
	try {
		rs = statement.executeQuery(queryString);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//rs.getInt("id");rs.getString(1
	/*try {
		while (rs.next()) {
			
			 rsCount = rsCount + 1;
		     
		   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
       return rs;
   }
   
   
   public void selectUsersQuery(String companyId,String companyEmployeeId)
   {
	   String queryString = "select top 1 * from reward_user where company_id="+companyId+"and company_employee_id='"+companyEmployeeId+"'";
	   ResultSet rs = null;
	   //Row Count
	   int rsCount = 0;
	 
	try {
		rs = statement.executeQuery(queryString);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       try {
		while (rs.next()) {
			//rs.getInt("id");rs.getString(1
			 rsCount = rsCount + 1;
		      
		     
		   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   
   public void close()
   {
	  
	     if (statement != null)
			try {
				statement.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	     if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   
   }
   
   
   public void closeStatement(Statement tempStatement)
   {
	  
	     if (tempStatement != null)
			try {
				tempStatement.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    
	   
   }
   
}

