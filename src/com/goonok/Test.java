package com.goonok;

import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		StudentDAO studentDAO = context.getBean("studentDAO", StudentDAO.class);
		studentDAO.deleteStudentRecord(5);
		context.close();
	}
	
}
