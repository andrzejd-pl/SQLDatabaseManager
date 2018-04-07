import java.sql.*;

public class MainClass {
    public static void main(String[] args) {
        Arguments arguments = new Arguments(args);

        try {
            System.out.println("Welcome in SQLDatabaseManager!!!");

            Connection conn = DriverManager.getConnection("jdbc:mysql://" + arguments.getHost() +"/"+ arguments.getDatabase() +"", arguments.getUser(), arguments.getPassword());
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from customers;");

            do {
                System.out.print(resultSet.getRow() + " ");
                String id = resultSet.getString(1);
                System.out.println(id);
            } while (resultSet.next());

            resultSet.close();
            statement.close();
            conn.close();
        }
        catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        }
    }
}
