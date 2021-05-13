package org.example.database;

import javax.swing.*;
import java.sql.*;

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

	public void deleteEmployee(String id) throws SQLException {
		try {
			open();
			pStmt = conn.prepareStatement("delete from employees where id=?");
			pStmt.setInt(1, Integer.parseInt(id));

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
			close();
		} catch (SQLException addErr) {
			addErr.printStackTrace();
		}
	}

		public void updateUser(String id, String firstName, String lastName, String
		department, String email, double salary){

			try {

				open();

				String OppdaterSQL = "UPDATE employees SET first_name = ?,  last_name = ?, department = ?, email = ?, salary = ? WHERE id = ?";

				stmt = conn.prepareStatement(OppdaterSQL);


				pStmt.setInt(6, Integer.parseInt(id));
				pStmt.setString(1, firstName);
				pStmt.setString(2, lastName);
				pStmt.setString(3, department);
				pStmt.setString(4, email);
				pStmt.setDouble(5, salary);


				pStmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Bruker er oppdatert");
				close();

			} catch (
					SQLException e1) {
				e1.printStackTrace();
			}
		}
	}


