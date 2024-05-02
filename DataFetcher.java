package com.shopNest.dbHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataFetcher {
	

	public static String fetchPassword(String uname) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String password = "system";
		
		String sql="select pass from customers where uname=?";
		String dbPass="";
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,user,password);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs=ps.executeQuery();
			rs.next();
			dbPass=rs.getString(1);
		}catch(Exception e) {
			System.out.println("Login issues");
			e.printStackTrace();
		}
		return dbPass;
		
	}
	
	public static List fetchUsersInfo()
	{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String password = "system";
		String sql="select uname,mail,gender,address from customers";
		List ulist=new ArrayList();
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,user,password);
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				String temp=rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getString(4);
				ulist.add(temp);
			}
		}catch(Exception e) {
			System.out.println("Problem in login.....");
		}
		return ulist;
	}
	

}
