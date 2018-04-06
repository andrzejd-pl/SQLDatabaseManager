package Database;

import java.sql.*;

public class MysqlConnector {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

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

    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + databaseName, user, password);
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        }
    }

    public void close() {
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
        }
    }

//    public
}
