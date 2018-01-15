package com.asig.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl="jdbc:postgresql://localhost:5432/postgres";
		String user="postgres";
		String pass="user123";
		try {
			System.out.println("connecting to db");
			Connection myConn=DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("connection successful");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
