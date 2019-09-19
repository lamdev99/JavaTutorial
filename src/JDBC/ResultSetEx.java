package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetEx {
    private static String DB_URL = "jdbc:mysql://localhost:3306/t3h";
    private static String USER_NAME = "root";
    private static String PASSWORD = "68686868";

    public static void main(String[] args) {
        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("Select * from nguoi");
            rs.absolute(1);
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
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
