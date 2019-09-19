package JDBC;

import java.sql.*;

public class DatabaseMetaData {
    private static String DB_URL = "jdbc:mysql://localhost:3306/t3h";
    private static String USER_NAME = "root";
    private static String PASSWORD = "68686868";

    public static void main(String args[]) {
        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            java.sql.DatabaseMetaData databaseMetaData = conn.getMetaData();
            System.out.println("Driver Name: " + databaseMetaData.getDriverName());
            System.out.println("Driver Version: " + databaseMetaData.getDriverVersion());
            System.out.println("Username: " + databaseMetaData.getUserName());
            System.out.println("Database Product Name: " + databaseMetaData.getDatabaseProductName());
            System.out.println("Database Product Version; " + databaseMetaData.getDatabaseProductVersion());
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection(String dbURL, String userName,
                                           String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}

