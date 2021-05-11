package org.example.database;

import java.sql.*;

public class DatabaseConnection {

private static final String database ="jdbc:mysql//https://itfag.usn.no/233574";

private static final String brukernavn = "233574";
private static final String pw = "JWeiMrF0";

private Connection conn = null;
private Statement stmt = null;
private PreparedStatement pStmt = null;
private ResultSet resSet = null;


    public void open() throws SQLException {
        try {
            //Establish connection
            conn = DriverManager.getConnection(database, brukernavn,pw);
            //Create statement that will be used for executing SQL queries
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();// More elegant solutions for catching errors exist but they are out of the scope for this course
        }
    }

    public void close() throws SQLException{
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

            resSet = pStmt.executeQuery();

            close();
        } catch(SQLException deleteErr) {
            deleteErr.printStackTrace();
        }
    }

    public void addEmployee(String lastName, String firstName, String department, String email, double salary) throws SQLException {
        try{
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
}
