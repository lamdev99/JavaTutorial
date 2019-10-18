package JavaJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StatementDB {
    private static String DB_URL = "jdbc:mysql://localhost:3306/testdatabase";
    private static String USER_NAME = "root";
    private static String PASSWORD = "68686868";

    public static void main(String[] args) {
        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE nguoi set name = 'Long' where id = 1");
            statement.executeUpdate("INSERT into nguoi(name,age) " + "values('Dan',20)");
            statement.executeUpdate("INSERT into nguoi(name,age) " + "values('Lam',19)");
            statement.executeUpdate("INSERT into nguoi(name,age) " + "values('Nam',21)");
            statement.executeUpdate("INSERT into nguoi(name,age) " + "values('Minh',22)");
            statement.executeUpdate("CREATE table nguoi" +
                    "(id integer auto_increment primary key, " +
                    "name varchar(255)," +
                    "age integer not null)");
            statement.executeUpdate("DELETE from nguoi where id = 1");
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
