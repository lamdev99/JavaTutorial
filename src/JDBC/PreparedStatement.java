package JDBC;

import java.sql.*;

public class PreparedStatement {
    private static String DB_URL = "jdbc:mysql://localhost:3306/t3h";
    private static String USER_NAME = "root";
    private static String PASSWORD = "68686868";

    public static void main(String[] args) {
        String sqlInsert = "INSERT INTO student VALUES(?, ?, ?)";
        String selectAll = "SELECT * FROM student";
        try {
            // connect to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL,
                    USER_NAME, PASSWORD);
            Statement stmt = conn.createStatement();
            // crate statement to insert student
            stmt.executeUpdate("insert into sinhvien(id,ten,age)" +
                    "values(1,'Lam',20)");
            stmt.executeUpdate("insert into sinhvien(ten,age)" +
                    "values('Nam',20)");
            ResultSet rs = stmt.executeQuery("select * from sinhvien");
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
