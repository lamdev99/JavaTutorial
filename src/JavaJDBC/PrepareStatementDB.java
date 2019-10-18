package JavaJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepareStatementDB {
    private static String DB_URL = "jdbc:mysql://localhost:3306/testdatabase";
    private static String USER_NAME = "root";
    private static String PASSWORD = "68686868";

    public static void main(String[] args) {
        String sqlInsert = "UPDATE nguoi set name = ? where id = ?";
        String selectAll = "SELECT * FROM nguoi";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            java.sql.PreparedStatement preparedStatement = conn.prepareStatement(sqlInsert);
            preparedStatement.setInt(2, 2);
            preparedStatement.setString(1, "Long");
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
