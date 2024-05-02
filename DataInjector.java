package com.shopNest.dbHandler;

import java.sql.*;

public class DataInjector {
	public static String addCustomer(String uname, String mail, String pass, String gender, String address) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String password = "system";
		String sql = "INSERT INTO CUSTOMERS values(?,?,?,?,?)";
		String regStatus = "";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, uname);
			ps.setString(2, mail);
			ps.setString(3, pass);
			ps.setString(4, gender);
			ps.setString(5, address);

			ps.executeUpdate();

			regStatus = "Success";
		} catch (Exception ex) {
			System.out.println("Problem in adding customer");
			ex.printStackTrace();
			regStatus = "Fail";
		} finally {
			return regStatus;
		}

	}

	public static boolean addProduct(int pid, String pname, String pdesc, int pprice, String pimg) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String password = "system";
		String sql = "INSERT INTO products values(?,?,?,?,?)";
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, pid);
			ps.setString(2, pname);
			ps.setString(3, pdesc);
			ps.setInt(4, pprice);
			ps.setString(5, pimg);

			ps.executeUpdate();

			
		} catch (Exception ex) {
			System.out.println("Problem in adding product....");
			ex.printStackTrace();
			return false;
		}
		return true;
	}

}
