package com.github.cleanarchdemo.infrastructure.repository.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/clean_arch";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        return connection == null || connection.isClosed() ? connection = DriverManager.getConnection(URL, USERNAME, PASSWORD) : connection;
    }
}