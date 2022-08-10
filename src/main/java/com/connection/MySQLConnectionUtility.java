package com.connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
public class MySQLConnectionUtility {
    private static String MYSQL_HOST = "jdbc:mysql://localhost:3306/UserDetails";
    private static String MYSQL_USER_NAME = "root";
    private static String MYSQL_PASSWORD = "Pramati@123";
    private static volatile Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            synchronized (MySQLConnectionUtility.class) {
                if (connection == null) {
                    try {
                        connection = DriverManager.getConnection(MYSQL_HOST, MYSQL_USER_NAME, MYSQL_PASSWORD);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("SQL Exception while Creating Mysql Connection " + MYSQL_HOST + " With User " + MYSQL_USER_NAME);
                    }
                }
            }
        }
        return connection;
    }
}
