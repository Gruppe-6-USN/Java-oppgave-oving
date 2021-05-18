package org.example.database;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {

	private static final String database = "jdbc:mysql://itfag.usn.no/233574";

	private static final String brukernavn = "233574";
	private static final String pw = "JWeiMrF0";

	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pStmt = null;
	private ResultSet resSet = null;


	public void open() throws SQLException {
		try {
			
			conn = DriverManager.getConnection(database, brukernavn, pw);

			stmt = conn.createStatement();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void close() throws SQLException {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void deleteEmployee(int employeeNumber) throws SQLException {
		try {
			open();
			pStmt = conn.prepareStatement("delete from employees where employeeNumber=?");
			pStmt.setInt(1, employeeNumber);

			pStmt.executeUpdate();

			close();
		} catch (SQLException deleteErr) {
			deleteErr.printStackTrace();
		}
	}

	public void addEmployee(String lastName, String firstName, String extension, String email, String officeCode, int reportsTo, String jobTitle) throws SQLException {
		try {
			open();
			pStmt = conn.prepareStatement("insert into employees (last_name, first_name, extension, email, officeCode, jobTitle)" +
					"values (?, ?, ?, ?, ?, ?, ?)");
			pStmt.setString(1, lastName);
			pStmt.setString(2, firstName);
			pStmt.setString(3, extension);
			pStmt.setString(4, email);
			pStmt.setString(5, officeCode);
			pStmt.setInt(6, reportsTo);
			pStmt.setString(7, jobTitle);
			pStmt.execute();
			close();
		} catch (SQLException addErr) {
			addErr.printStackTrace();
		}
	}

		public void updateUser(String firstName, String lastName, String extension, String email, String officeCode, int reportsTo, String jobTitle, int employeeNumber) throws SQLException{
			try {
				open();
				pStmt = conn.prepareStatement("UPDATE employees SET first_name = ?,  last_name = ?, extension = ?, email = ?, officeCode = ?, reportsTo = ?, jobTitle = ?,  WHERE employeeNumber = ?");
				
				
				pStmt.setString(1, firstName);
				pStmt.setString(2, lastName);
				pStmt.setString(3, extension);
				pStmt.setString(4, email);
				pStmt.setString(5, officeCode);
				pStmt.setInt(6,reportsTo);
				pStmt.setString(7, jobTitle);
				pStmt.setInt(8, employeeNumber);
				
				pStmt.execute();
				close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		public List<Employee> showEmployees() throws SQLException {
			ArrayList<Employee> employees = new ArrayList<Employee>();
			try{
			open();
		    pStmt = conn.prepareStatement("SELECT * FROM employees");
		    resSet = pStmt.executeQuery();
		    
		    while (resSet.next()) {
		    	int employeeNumber = resSet.getInt("employeeNumber");
		    	String firstName = resSet.getString("first_name");
		    	String lastName = resSet.getString("last_name");
				String extension = resSet.getString("extension");
		    	String email = resSet.getString("email");
		    	String officeCode = resSet.getString("officeCode");
		    	int reportsTo = resSet.getInt("reportsTo");
		    	String jobTitle = resSet.getString("jobTitle");



		    	Employee current = new Employee(employeeNumber, firstName, lastName, extension, email, officeCode, reportsTo, jobTitle);
		    	employees.add(current);
		    	/*employees = employees.toString();*/
		    	
		    	
		      }
		    
		    close();
		    return employees;
		    } catch (SQLException e) {
		      e.printStackTrace();
		 }
			return null;
				 
		}

	public List<Employee> showEmployeesJobTitle(String jobTitle) throws SQLException {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		try{
			open();
			pStmt = conn.prepareStatement("SELECT * FROM employees WHERE jobTitle = ?");
			resSet = pStmt.executeQuery();

			pStmt.setString(1, jobTitle);

			while (resSet.next()) {
				int employeeNumber = resSet.getInt("employeeNumber");
				String firstName = resSet.getString("first_name");
				String lastName = resSet.getString("last_name");
				String extension = resSet.getString("extension");
				String email = resSet.getString("email");
				String officeCode = resSet.getString("officeCode");
				int reportsTo = resSet.getInt("reportsTo");
				resSet.getString("jobTitle");



				Employee current = new Employee(employeeNumber, firstName, lastName, extension, email, officeCode, reportsTo, jobTitle);
				employees.add(current);
				/*employees = employees.toString();*/


			}

			close();
			return employees;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
		
		
	}


