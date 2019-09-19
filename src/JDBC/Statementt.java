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
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE nguoi set name = 'newupdate' where id = 1");
            statement.executeUpdate("insert into nguoi(name,age) " + "values('lamkzNEU',20)");
            statement.executeUpdate("create table nguoi" +
                    "(id integer auto_increment primary key, " +
                    "name varchar(255)," +
                    "age integer not null)");
            statement.executeUpdate("delete from nguoi where id = 1");
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
