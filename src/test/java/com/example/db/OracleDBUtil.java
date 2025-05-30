package com.example.db;// OracleDBUtil.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDBUtil {
    public static Connection getConnection() throws SQLException {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521/FREEPDB1"; // or XEPDB1
        String username = "system";
        String password = "admin";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
