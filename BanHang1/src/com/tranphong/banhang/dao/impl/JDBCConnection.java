package com.tranphong.banhang.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
 public Connection getJDBCConnection()
 {	
	 final String username = "root";
		final String password = "";
		final String url = "jdbc:mysql://localhost:3306/banhang";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(url,username,password); 
	 }catch(Exception e)
	 {
		 System.out.println("ket noi that bai"+e);
	 }
	 
	 return null; 
 }
 public static void main(String[] args)
 {
	 JDBCConnection jdbcConnection =new JDBCConnection();
	 Connection connection=jdbcConnection.getJDBCConnection();
	 if(connection==null)
	 {
		 System.out.println("ket noi that bai");
	 }
	 else
	 {
		 System.out.println("ket noi thanh cong");
	 }
 }
}
