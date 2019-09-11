package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Statementt {
    private static String DB_URL = "jdbc:mysql://localhost:3306/t3h";
    private static String USER_NAME = "root";
    private static String PASSWORD = "68686868";

    public static void main(String[] args) {
        try {
            // connnect to database 'testdb'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);

            //Tạo một đối tượng Statement được sử dụng để thực thi các câu truy vấn SQL.
            Statement statement = conn.createStatement();
            //update statement
            statement.executeUpdate("UPDATE nguoi set name = 'newupdate' where id = 1");
            //insert statement
            statement.executeUpdate("insert into nguoi(name,age) " +
                    "values('lamkzNEU',20)");
            //create Table
            statement.executeUpdate("create table nguoi" +
                    "(id integer auto_increment primary key, " +
                    "name varchar(255)," +
                    "age integer not null)");
            //delete statement
            statement.executeUpdate("delete from nguoi where id = 1");
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
            //System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}
