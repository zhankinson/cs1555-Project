import java.util.*;
import java.io.*;
import java.sql.*;

public class actualdriver
{
    public static void main(String[] args) throws Exception
    {
        boolean proceed = true;
        Console input = System.console();
        String answer;

        String username = input.readLine("Please enter a Username: ");
        String password = new String(input.readPassword("Please enter a password: "));
        Connection connection = null; //used to hold the jdbc connection to the DB

        while(proceed)
        {
            System.out.print("Are you a Customer or Admin? (type C or A): ");
            answer = input.readLine();
            if(answer.compareTo("C") == 0)
            {
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
				
				ccpp.findReservation("000000001");
				
				proceed = false; 
            }
            else if(answer.compareTo("A") == 0)
            {
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
                AdministratorInterface aapp = new AdministratorInterface(connection);
                // Erase Database
                aapp.eraseDB();

                // Load Airline information
                aapp.loadAirline("loadairline.txt");

                // Load Plane information
                aapp.loadPlane("loadplane.txt");

                //Load Schedule information
                aapp.loadSchedule("loadschedule.txt");

                //Load pricing information
                aapp.loadPrice("loadpricing.txt");

                //Change existing price
                String d = input.readLine("Please enter a departure city: ");
                String a = input.readLine("Please enter an arrival city: ");
                String h = input.readLine("Please enter a hight price: ");
                String l = input.readLine("Please enter a low price: ");
                aapp.changePrice(d, a, h, l);

                //Generate Passenger Manifest for a specific flight on given date
                String num = input.readLine("Please enter a flight number: ");
                String date = input.readLine("Please enter a flight date: ");
                aapp.generateManifest(num, date);

                //Show table
                String table = input.readLine("Please specify a table to display: ");
                aapp.showTable(table);
                proceed = false;
            }
            else
            {
                System.out.print("Please input a valid option");
            }
        }
        connection.close();
    }
}
