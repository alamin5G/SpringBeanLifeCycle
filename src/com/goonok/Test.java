package com.goonok;

import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		StudentDAO studentDAO = new StudentDAO();
		studentDAO.selectAllRows();
		studentDAO.deleteStudentRecord(2);
	}
	
}
