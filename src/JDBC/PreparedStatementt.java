package JDBC;

import java.sql.*;
import java.sql.PreparedStatement;

public class PreparedStatementt {
    private static String DB_URL = "jdbc:mysql://localhost:3306/t3h";
    private static String USER_NAME = "root";
    private static String PASSWORD = "68686868";

    public static void main(String[] args) {
        String sqlInsert = "INSERT INTO nguoi VALUES(?, ?, ?)";
        String selectAll = "SELECT * FROM nguoi";
        try {
            // connect to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL,
                    USER_NAME, PASSWORD);
            java.sql.PreparedStatement preparedStatement = conn.prepareStatement(sqlInsert);
            preparedStatement.setInt(1, 3);
            preparedStatement.setString(2, "LamTz");
            preparedStatement.setInt(3, 19);
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(selectAll);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
            }
            preparedStatement.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
