package org.example.database;

import java.sql.*;

public class DatabaseConnection {

private String database ="jdbc:mysql//https://itfag.usn.no/233574";

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
}
