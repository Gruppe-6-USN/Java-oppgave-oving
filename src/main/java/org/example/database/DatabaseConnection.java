package org.example.database;


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

	public void addEmployee(int employeeNumber, String lastName, String firstName, String extension, String email, String officeCode, int reportsTo, String jobTitle) throws SQLException {
		try {
			open();
			pStmt = conn.prepareStatement("insert into employees (employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle)" +
					"values (?, ?, ?, ?, ?, ?, ?, ?)");
			pStmt.setInt(1, employeeNumber);
			pStmt.setString(2, lastName);
			pStmt.setString(3, firstName);
			pStmt.setString(4, extension);
			pStmt.setString(5, email);
			pStmt.setString(6, officeCode);
			pStmt.setInt(7, reportsTo);
			pStmt.setString(8, jobTitle);
			pStmt.execute();
			close();
		} catch (SQLException addErr) {
			addErr.printStackTrace();
		}
	}

	public void addOrder(int orderNumber, String orderDate, String requiredDate, String shippedDate, String status, String comments, int customerNumber) {
		try {
			open();
			pStmt = conn.prepareStatement("insert into orders (orderNumber, orderDate, requiredDate, shippedDate, status, comments, customerNumber)" +
					"values (?, ?, ?, ?, ?, ?, ?)");

			pStmt.setInt(1, orderNumber);
			pStmt.setString(2, orderDate);
			pStmt.setString(3, requiredDate);
			pStmt.setString(4, shippedDate);
			pStmt.setString(5, status);
			pStmt.setString(6, comments);
			pStmt.setInt(7, customerNumber);
			pStmt.execute();
			close();

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

		public void updateUser( String lastName, String firstName, String extension, String email, int officeCode, int reportsTo, String jobTitle, int employeeNumber) throws SQLException{
			try {
				open();
				pStmt = conn.prepareStatement("UPDATE employees SET lastName = ?,  firstName = ?, extension = ?, email = ?, officeCode = ?, reportsTo = ?, jobTitle = ? WHERE employeeNumber = ?");
				
				
				pStmt.setString(1, lastName);
				pStmt.setString(2, firstName);
				pStmt.setString(3, extension);
				pStmt.setString(4, email);
				pStmt.setInt(5, officeCode);
				pStmt.setInt(6, reportsTo);
				pStmt.setString(7, jobTitle);
				pStmt.setInt(8, employeeNumber);
				
				pStmt.execute();
				close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		public List<OrdersList> showOrders(String datestr1, String datestr2) throws SQLException{
			ArrayList<OrdersList> orders = new ArrayList<OrdersList>();
			
			try {
				open();
				pStmt = conn.prepareStatement("SELECT * FROM orders where orderDate >= ? and orderDate <= ?");
				pStmt.setString(1, datestr1);
				pStmt.setString(2, datestr2);
				resSet = pStmt.executeQuery();
				
			    while (resSet.next()) {
			    	int orderNumber = resSet.getInt("orderNumber");
			    	int customerNumber = resSet.getInt("customerNumber");
			    	String orderDate = resSet.getString("orderDate");
			    	String requiredDate = resSet.getString("requiredDate");
			    	String shippedDate = resSet.getString("shippeDdate");
			    	String status = resSet.getString("status");
			    	String comment = resSet.getString("comments");
			    	

			    	OrdersList current = new OrdersList(customerNumber, orderNumber, orderDate, requiredDate, shippedDate, status, comment);
			    	orders.add(current);
			    	
			    	
			    	
			      }
				close();
				return orders;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return null;
		}
		
		public List<Employee> showEmployees() throws SQLException {
			ArrayList<Employee> employees = new ArrayList<Employee>();
			try{
			open();
		    pStmt = conn.prepareStatement("SELECT * FROM employees");
		    resSet = pStmt.executeQuery();
		    
		    while (resSet.next()) {
		    	int employeeNumber = resSet.getInt("employeeNumber");
		    	String firstName = resSet.getString("firstName");
		    	String lastName = resSet.getString("lastName");
				String extension = resSet.getString("extension");
		    	String email = resSet.getString("email");
		    	String officeCode = resSet.getString("officeCode");
		    	int reportsTo = resSet.getInt("reportsTo");
		    	String jobTitle = resSet.getString("jobTitle");



		    	Employee current = new Employee(employeeNumber, lastName, firstName,  extension, email, officeCode, reportsTo, jobTitle);
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
			pStmt.setString(1, jobTitle);
			resSet = pStmt.executeQuery();



			while (resSet.next()) {
				int employeeNumber = resSet.getInt("employeeNumber");
				String lastName = resSet.getString("lastName");
				String firstName = resSet.getString("firstName");
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


