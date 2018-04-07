package Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlConnector {
    private Connection connection;

    private String host;
    private String databaseName;
    private String user;
    private String password;

    public MysqlConnector(String host, String database, String user, String password) {
        this.host = host;
        this.databaseName = database;
        this.user = user;
        this.password = password;
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + databaseName, user, password);
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException ignored) {
        }
    }

    public Data execute(String query) throws SQLException {
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
                row.add(resultSet.getString(i));
            }
            rows.add(row);
        } while (resultSet.next());

        resultSet.close();
        statement.close();

        return new Data(columns, rows);
    }
}
