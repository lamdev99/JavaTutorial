package JDBC;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

public class testdb {
    private static String sqlSelectAll = "select * from student";
    private static String sqlInsert = "insert into student values(?,?,?)";
    private static String DB_URL = "jdbc:mysql://localhost:3306/t3h";
    private static String USER_NAME = "root";
    private static String PASSWORD = "68686868";
    public static void main(String args[]) {

        try {
            // connnect to database 'testdb'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            //    Statement stmt = conn.createStatement();
//            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
//                    ResultSet.CONCUR_UPDATABLE);
            // get data from table 'student'

            //Update
//            stmt.executeUpdate("INSERT INTO student(id, name, address) "
//                    + "VALUES (6, 'Lam', '3Vi')");
//            stmt.executeUpdate("update student set name = 'Nguyen Tung Lam', address = 'Ba Vi' where id = 6");
            PreparedStatement preparedStatement;
//            preparedStatement.setInt(1,7);
//            preparedStatement.setString(2,"Nam");
//            preparedStatement.setString(3,"Ba Vi");
//            //preparedStatement.execute();
            preparedStatement = conn.prepareStatement(sqlSelectAll);
            ResultSet rs = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("Tong so cot la: "+rsmd.getColumnCount());
            System.out.println("Ten cot thu hai la: "+rsmd.getColumnName(2));
            System.out.println("Column type cua cot thu 2 la: "+rsmd.getColumnTypeName(2));
            preparedStatement.close();
//
//            ResultSet rs = preparedStatement.executeQuery("select * from student order by name DESC");
//            //rs.absolute(3);
//            // show data
//            while (rs.next()) {
//                System.out.println(rs.getInt(1) + "  " + rs.getString(2)
//                        + "  " + rs.getString(3));
//            }
//            System.out.println(rs.getInt(1)+" "+rs.getString(2)+
//                    " "+rs.getString(3));
            // close connection
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

