package com.app.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcurl= "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user="dac";
		String password="dac";
		try 
		{
			System.out.println("Connecting to database: "+jdbcurl);
			Connection mycon = DriverManager.getConnection(jdbcurl,user,password);
			System.out.println("Connection successful...");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

}
