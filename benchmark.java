import java.util.*;
import java.io.*;
import java.sql.*;

public class benchmark
{
    public static void main(String[] args) throws Exception
    {
        Console input = System.console();
        String answer;

        String username = input.readLine("Please enter a Username: ");
        String password = new String(input.readPassword("Please enter a password: "));
        Connection connection = null; //used to hold the jdbc connection to the DB

        try{
            DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@class3.cs.pitt.edu:1521:dbclass";
            connection = DriverManager.getConnection(url, username, password);
        }
        catch(Exception Ex)
        {
            System.out.println("Error connecting to database.  Machine Error: " +
            Ex.toString());
            Ex.printStackTrace();
        }
        CustomerInterface ccpp = new CustomerInterface(connection);
        AdministratorInterface aapp = new AdministratorInterface(connection);

        long startTime = System.currentTimeMillis() / 1000L;

        long endTime = System.currentTimeMillis() / 1000L;

        long totalTime = endTime-startTime;
        System.out.println("Finished in: "+totalTime);

        connection.close();
    }
}
