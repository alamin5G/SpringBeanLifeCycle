package com.goonok;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.*;

public class StudentDAO {
	/*
	 * To write JDBC connection code
	 */
	
	private String driver;
	private String url;
	private String userName;
	private String password;
	
	Connection connection;
	
	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		System.out.println("setting driver");
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		System.out.println("setting url");
		this.url = url;
	}

	public String getUserName() {
		
		return userName;
	}

	public void setUserName(String userName) {
		System.out.println("setting user");
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		System.out.println("setting password");
		this.password = password;
	}
	
	
	public void createStudentDBConnection() throws ClassNotFoundException, SQLException {
		
		System.out.println("Init DB Connection");
		//Load Driver
		Class.forName(driver);
		
		//get a connection
		connection = DriverManager.getConnection(url, userName, password);
	}
	
	
	public void selectAllRows() throws ClassNotFoundException, SQLException {
		
		createStudentDBConnection(); //- used instead @PostConstruct before the method name
		//execute query
		Statement statement = connection.createStatement();
		System.out.println("created connection");
		System.out.println("Retriving all student data");
		ResultSet resultSet = statement.executeQuery("SELECT * FROM school.student");
		
		while(resultSet.next()) {
			int ROOL_NO = resultSet.getInt(1);
			String STUDENT_NAME = resultSet.getString(2);
			String STUDENT_ADDRESS = resultSet.getString(3);
			System.out.println(ROOL_NO + "\t" + STUDENT_NAME + "\t" + STUDENT_ADDRESS);
		}
		closeConnection(); //same as connection.close();
	}
	
	public void deleteStudentRecord(int ROOL_NO) throws ClassNotFoundException, SQLException {
	
		createStudentDBConnection(); //- used instead @PostConstruct before the method name
		//execute Query
		System.out.println("Created connection");
		Statement statement = connection.createStatement();
		statement.executeUpdate("DELETE FROM school.student WHERE ROOL_NO = " +ROOL_NO);
		System.out.println("Record Deleted with the ROOL_NO:" + ROOL_NO + " is successful");
	
		closeConnection();
		
	}
	
	public void closeConnection() throws SQLException {
		System.out.println("closed connection");
		connection.close();
	}
}
