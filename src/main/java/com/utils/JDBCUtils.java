package com.utils;

import java.sql.*;

public class JDBCUtils {
    private static volatile JDBCUtils instance;
    private static Connection connection = null;
    //private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/datadevelopers";
    private static final String DATABASE_URL = "jdbc:sqlite:identifier.sqlite";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public JDBCUtils() {
    }

    private static Connection getInstance() {
        if (instance == null) {
            synchronized (JDBCUtils.class) {
                if (instance == null) {
                    instance = new JDBCUtils();
                    installConnection();
                }
            }
        }
        return connection;
    }

    private static Connection installConnection() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static PreparedStatement getPreparedStatement(String sql) {
        try {
            return getInstance().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Statement getStatement() {
        try {
            return getInstance().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
