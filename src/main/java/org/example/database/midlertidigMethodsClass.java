package org.example.database;

import java.sql.*;

public class midlertidigMethodsClass {
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


}
