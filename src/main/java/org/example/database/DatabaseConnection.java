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

	public void deleteEmployee(int id) throws SQLException {
		try {
			open();
			pStmt = conn.prepareStatement("delete from employees where id=?");
			pStmt.setInt(1, id);

			pStmt.executeUpdate();

			close();
		} catch (SQLException deleteErr) {
			deleteErr.printStackTrace();
		}
	}

	public void addEmployee(String lastName, String firstName, String department, String email, double salary) throws SQLException {
		try {
			open();
			pStmt = conn.prepareStatement("insert into employees (last_name, first_name, department, email, salary)" +
					"values (?, ?, ?, ?, ?)");
			pStmt.setString(1, lastName);
			pStmt.setString(2, firstName);
			pStmt.setString(3, department);
			pStmt.setString(4, email);
			pStmt.setDouble(5, salary);
			pStmt.execute();
			close();
		} catch (SQLException addErr) {
			addErr.printStackTrace();
		}
	}

		public void updateUser(String firstName, String lastName, String department, String email, double salary, int id) throws SQLException{
			try {
				open();
				pStmt = conn.prepareStatement("UPDATE employees SET first_name = ?,  last_name = ?, department = ?, email = ?, salary = ? WHERE id = ?");
				
				
				pStmt.setString(1, firstName);
				pStmt.setString(2, lastName);
				pStmt.setString(3, department);
				pStmt.setString(4, email);
				pStmt.setDouble(5, salary);
				pStmt.setInt(6, id);
				
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
		    	int id = resSet.getInt("id");
		    	String firstName = resSet.getString("first_name");
		    	String lastName = resSet.getString("last_name");
		    	String email = resSet.getString("email");
		    	String department = resSet.getString("department");
		    	double salary = resSet.getDouble("salary");

		    	Employee current = new Employee(id, firstName, lastName, email, department, salary);
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


