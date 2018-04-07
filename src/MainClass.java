import Database.Data;
import Database.MysqlConnector;

import java.sql.*;

public class MainClass {
    public static void main(String[] args) {
        Arguments arguments = new Arguments(args);
        MysqlConnector mysqlConnector = new MysqlConnector(arguments.getHost(),arguments.getDatabase(), arguments.getUser(), arguments.getPassword());
        try {
            System.out.println("Welcome in SQLDatabaseManager!!!");
            Class.forName("com.mysql.jdbc.Driver");

            mysqlConnector.connect();
            Data data = mysqlConnector.execute("select * from tagi;");
            mysqlConnector.close();

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mysqlConnector.close();
        }
    }
}
