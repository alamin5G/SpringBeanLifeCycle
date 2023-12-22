package com.goonok;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
	/*
	 * To write JDBC connection code
	 */
	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/school";
	private String userName = "root";
	private String password = "252646";
	
	public void selectAllRows() throws ClassNotFoundException, SQLException {
		System.out.println("Retriving all student data");
		
		//Load Driver
		Class.forName(driver);
		
		//get a connection
		Connection connection = DriverManager.getConnection(url, userName, password);
		
		//execute query
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM school.student");
		
		while(resultSet.next()) {
			int ROOL_NO = resultSet.getInt(1);
			String STUDENT_NAME = resultSet.getString(2);
			String STUDENT_ADDRESS = resultSet.getString(3);
			System.out.println(ROOL_NO + "\t" + STUDENT_NAME + "\t" + STUDENT_ADDRESS);
		}
	}
	
	public void deleteStudentRecord(int ROOL_NO) throws ClassNotFoundException, SQLException {
		//Load Driver
		Class.forName(driver);
		
		//get a connection
		Connection connection = DriverManager.getConnection(url, userName, password);
		
		//execute Query
		Statement statement = connection.createStatement();
		statement.executeUpdate("DELETE FROM school.student WHERE ROOL_NO = " +ROOL_NO);
		System.out.println("Record Deleted with the ROOL_NO:" + ROOL_NO + " is successful");
		connection.close();
		
	}
}
