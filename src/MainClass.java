import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class MainClass {
    public static void main(String[] args) throws IOException {
        String user, passwd;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Welcome in SQLDatabaseManager!!!");
            System.out.print("User: ");
            user = br.readLine();
            System.out.print("Passwd: ");
            passwd = br.readLine();

            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.101/database", user, passwd);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from firmy;");

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
