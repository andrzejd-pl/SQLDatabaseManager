package com.dybowski_andrzej.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlConnector {
    private Connection connection;

    private String host;
    private String databaseName;
    private String user;
    private String password;

    private boolean connected = false;

    public MysqlConnector(String host, String database, String user, String password) throws ClassNotFoundException {
        this.host = host;
        this.databaseName = database;
        this.user = user;
        this.password = password;

        Class.forName("com.mysql.jdbc.Driver");
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + databaseName, user, password);
        connected = true;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException ignored) {
        } finally {
            connected = false;
        }
    }

    public Data execute(String query) throws SQLException {
        if (!connected) connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.first();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        List<List<String>> rows = new ArrayList<>();
        List<String> columns = new ArrayList<>();

        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            columns.add(resultSetMetaData.getColumnName(i));
        }

        do {
            List<String> row = new ArrayList<>();
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                row.add((resultSet.getString(i) == null) ? ("null") : (resultSet.getString(i)));
            }
            rows.add(row);
        } while (resultSet.next());

        resultSet.close();
        statement.close();

        return new Data(columns, rows);
    }

    public static class Builder {
        private String host;
        private String databaseName;
        private String user;
        private String password;

        public Builder setDatabaseName(String databaseName) {
            this.databaseName = databaseName;

            return this;
        }

        public Builder setHost(String host) {
            this.host = host;

            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;

            return this;
        }

        public Builder setUser(String user) {
            this.user = user;

            return this;
        }

        public MysqlConnector build() throws ClassNotFoundException {
            return new MysqlConnector(host, databaseName, user, password);
        }
    }
}
