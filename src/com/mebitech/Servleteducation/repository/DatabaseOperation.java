package com.mebitech.Servleteducation.repository;

import java.sql.*;

/**
 * Created by Mebitech on 17.07.2017.
 */
public class DatabaseOperation {

    private final static String JDBC_URL = "jdbc:mysql://localhost:3306/Servlet";
    private final static String JDBC_USERNAME = "root";
    private final static String JDBC_PASSWORD = "";
    private Connection connection;

    public void connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        }
    }

    public void disconnect() throws SQLException {
        if (connection != null || !connection.isClosed()) {
            connection.close();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;

    }

}
