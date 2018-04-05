import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class MainClass {
    public static void main(String[] args) {
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

            while (resultSet.next()) {
                System.out.println(resultSet.getRow());
            }

            resultSet.close();
            statement.close();
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
