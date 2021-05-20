package org.example.database;


import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import org.example.gui.*;

import javax.swing.*;

public class DatabaseConnection extends Component {

	
	
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

	public void updateCustomerAfterEmployeeDelete(int employeeNumber) throws SQLException {
		pStmt = conn.prepareStatement("update customers set salesRepEmployeeNumber = NULL WHERE salesRepEmployeeNumber = ?");
		pStmt.setInt(1, employeeNumber);
		pStmt.execute();

	}

	public void updateReportsToAfterEmployeeDelete(int employeeNumber) throws SQLException {
		pStmt = conn.prepareStatement("update employees set reportsTo = NULL WHERE reportsTo = ?");
		pStmt.setInt(1, employeeNumber);
		pStmt.execute();
	}

	public void deleteEmployee(int employeeNumber) throws SQLException {
		try {
			open();
			updateCustomerAfterEmployeeDelete(employeeNumber);
			updateReportsToAfterEmployeeDelete(employeeNumber);
			pStmt = conn.prepareStatement("DELETE FROM employees WHERE employeeNumber=?");
			pStmt.setInt(1, employeeNumber);

			pStmt.executeUpdate();
			successMessage("Successfully deleted");
			close();
		} catch (SQLException deleteErr) {
			deleteErr.printStackTrace();
		}
	}

	public void addEmployee(int employeeNumber, String lastName, String firstName, String extension, String email, String officeCode, int reportsTo, String jobTitle) throws SQLException {
		try {
			open();
			pStmt = conn.prepareStatement("INSERT INTO employees(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle)" +
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
			successMessage("Successfully added");
			close();
		} catch (SQLIntegrityConstraintViolationException addErr) {
			errorMessage("Reports to does not exist");
		}
	}
	public void updateOffice(String officeCode, String city, String phone, String addressLine1, String addressLine2, String state, String country, String postalCode, String territory) throws SQLException {
		try {
			open();
			pStmt = conn.prepareStatement("UPDATE offices SET city = ?, phone = ?, addressLine1 = ?, addressLine2 = ?, state = ?, country = ?, postalCode = ?, territory = ? WHERE officeCode = ?");
					

			pStmt.setString(1, city);
			pStmt.setString(2, phone);
			pStmt.setString(3, addressLine1);
			pStmt.setString(4, addressLine2);
			pStmt.setString(5, state);
			pStmt.setString(6, country);
			pStmt.setString(7, postalCode);
			pStmt.setString(8, territory);
			pStmt.setString(9, officeCode);
			pStmt.executeUpdate();
			successMessage("Successfully updated");
			close();
		} catch (SQLException addErr) {
			addErr.printStackTrace();
		}
	}

	public void addOrder(int orderNumber, String orderDate, String requiredDate, String shippedDate, String status, String comments, int customerNumber) throws SQLException {
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
			successMessage("Successfully added");
			close();
		}catch(SQLIntegrityConstraintViolationException e) {
			errorMessage("Customer does not exist");

		}catch(MysqlDataTruncation e) {
			errorMessage("The date input has to be yyyy-mm-dd");

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

		public void updateUser( String lastName, String firstName, String extension, String email, String officeCode, int reportsTo, String jobTitle, int employeeNumber) throws SQLException{
			try {
				open();
				pStmt = conn.prepareStatement("UPDATE employees SET lastName = ?,  firstName = ?, extension = ?, email = ?, officeCode = ?, reportsTo = ?, jobTitle = ? WHERE employeeNumber = ?");
				
				
				pStmt.setString(1, lastName);
				pStmt.setString(2, firstName);
				pStmt.setString(3, extension);
				pStmt.setString(4, email);
				pStmt.setString(5, officeCode);
				pStmt.setInt(6, reportsTo);
				pStmt.setString(7, jobTitle);
				pStmt.setInt(8, employeeNumber);
				
				pStmt.execute();
				successMessage("Successfully updated");
				close();
			}catch(SQLIntegrityConstraintViolationException e) {
				errorMessage("The employee you are going to report to does not exist");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		public void updateOrder(String orderDate, String requiredDate, String shippedDate, String status, String comments, int orderNumber) throws SQLException {
			try {
				open();
				pStmt = conn.prepareStatement("UPDATE orders SET orderDate = ?, requiredDate = ?, shippedDate = ?, status = ?, comments = ? WHERE orderNumber = ?");

				pStmt.setString(1, orderDate);
				pStmt.setString(2, requiredDate);
				pStmt.setString(3, shippedDate);
				pStmt.setString(4, status);
				pStmt.setString(5, comments);
				pStmt.setInt(6, orderNumber);

				pStmt.execute();
				successMessage("Successfully updated");
				close();
			}catch(MysqlDataTruncation e) {
				errorMessage("The date input has to be yyyy-mm-dd");
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}


		public List<OrdersList> searchByDate(String datestr1, String datestr2) throws SQLException{
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
			    	

			    	OrdersList current = new OrdersList(customerNumber, orderDate, requiredDate, shippedDate, status, comment, orderNumber);
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
		    	}
		    	close();
		    	return employees;
		    }catch(SQLException e) {
		      e.printStackTrace();
		    }
			return null;	 
		}
		
		public List<Customer> showCustomers() throws SQLException {
			ArrayList<Customer> customers = new ArrayList<Customer>();
			try{
			open();
		    pStmt = conn.prepareStatement("SELECT * FROM customers");
		    resSet = pStmt.executeQuery();
		    	while (resSet.next()) {
		    		int customerNumber = resSet.getInt("customerNumber");
		    		String customerName = resSet.getString("customerName");
		    		String contactLastName = resSet.getString("contactLastName");
		    		String contactFirstName = resSet.getString("contactFirstName");
		    		String phone = resSet.getString("phone");
		    		String addressLine1 = resSet.getString("addressLine1");
		    		String addressLine2 = resSet.getString("addressLine2");
		    		String city = resSet.getString("city");
		    		String state = resSet.getString("state");
		    		String postalCode = resSet.getString("postalCode");
		    		String country = resSet.getString("country");
		    		int salesRepEmployeeNumber = resSet.getInt("salesRepEmployeeNumber");
		    		double creditLimit = resSet.getDouble("creditLimit");
		    				    		
		    		Customer current = new Customer(customerNumber, country, customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, salesRepEmployeeNumber, creditLimit);
		    		customers.add(current);
		    	}
		    	close();
		    	return customers;
		    }catch(SQLException e) {
		      e.printStackTrace();
		    }
			return null;	 
		}
		
		public List<Employee> sortEmployeesJobTitle(String chosenJobTitle) throws SQLException {
			ArrayList<Employee> employees = new ArrayList<Employee>();
			try{
			open();
		    pStmt = conn.prepareStatement("SELECT * FROM employees WHERE jobTitle = ?");
		    pStmt.setString(1, chosenJobTitle);
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
		    	}
		    	close();
		    	return employees;
		    }catch(SQLException e) {
		      e.printStackTrace();
		    }
			return null;	 
		}
		
		public List<OfficesList> showOffices() throws SQLException {
			ArrayList<OfficesList> offices = new ArrayList<OfficesList>();
			try{
			open();
		    pStmt = conn.prepareStatement("SELECT * FROM offices");
		    resSet = pStmt.executeQuery();
		    
		    while (resSet.next()) {
		    	String officeCode = resSet.getString("officeCode");
		    	String city = resSet.getString("city");
		    	String phone = resSet.getString("phone");
				String addressLine1 = resSet.getString("addressLine1");
		    	String addressLine2 = resSet.getString("addressLine2");
		    	String state = resSet.getString("state");
		    	String country = resSet.getString("country");
		    	String postalCode = resSet.getString("postalCode");
		    	String territory = resSet.getString("territory");



		    	OfficesList current = new OfficesList(officeCode, city, phone,  addressLine1, addressLine2, state, country, postalCode, territory);
		    	offices.add(current);
		    	
		    	
		    	
		      }
		    
		    close();
		    return offices;
		    } catch (SQLException e) {
		      e.printStackTrace();
		 }
			return null;
				 
		}

	public List<OrdersList> showOrders() throws SQLException {
		ArrayList<OrdersList> orders = new ArrayList<OrdersList>();
		try{
			open();
			pStmt = conn.prepareStatement("SELECT * FROM orders");
			resSet = pStmt.executeQuery();

			while (resSet.next()) {
				int orderNumber = resSet.getInt("orderNumber");
				String orderDate = resSet.getString("orderDate");
				String requiredDate = resSet.getString("requiredDate");
				String shippedDate = resSet.getString("shippedDate");
				String status = resSet.getString("status");
				String comments = resSet.getString("comments");
				int customerNumber = resSet.getInt("customerNumber");


				OrdersList current = new OrdersList(orderNumber, orderDate, requiredDate, shippedDate, status, comments, customerNumber);
				orders.add(current);
				/*employees = employees.toString();*/


			}

			close();
			return orders;
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

	public void deleteOrderDetailsAfterDelete(int orderNumber) throws SQLException {
		pStmt = conn.prepareStatement("delete from orderdetails where orderNumber=?");
		pStmt.setInt(1, orderNumber);
		pStmt.executeUpdate();
	}

	public void deleteOrder(int orderNumber) throws SQLException {
		try {
			open();
			deleteOrderDetailsAfterDelete(orderNumber);
			pStmt = conn.prepareStatement("delete from orders where orderNumber=?");
			pStmt.setInt(1, orderNumber);

			pStmt.executeUpdate();
			successMessage("Successfully deleted");

			close();
		} catch (SQLException deleteErr) {
			deleteErr.printStackTrace();
		}

	}
		public void errorMessage(String errorMsg) {
			JOptionPane.showMessageDialog(this, errorMsg, "Error", JOptionPane.ERROR_MESSAGE);
		}

		public void successMessage(String succMsg) {
		JOptionPane.showMessageDialog(this,succMsg, "Success", JOptionPane.INFORMATION_MESSAGE);
		}
	}





