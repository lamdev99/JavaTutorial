package JavaJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ResultSetMetaDataDB {
    private static String sqlSelectAll = "select * from student";
    private static String DB_URL = "jdbc:mysql://localhost:3306/t3h";
    private static String USER_NAME = "root";
    private static String PASSWORD = "68686868";
    public static void main(String args[]) {
        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sqlSelectAll);
            ResultSet rs = preparedStatement.executeQuery();
            java.sql.ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("Tong so cot la: " + rsmd.getColumnCount());
            System.out.println("Ten cot thu hai la: " + rsmd.getColumnName(2));
            System.out.println("Column type cua cot thu 2 la: " + rsmd.getColumnTypeName(2));
            System.out.println("Name Table: " + rsmd.getTableName(2));
            preparedStatement.close();
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
         } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}
