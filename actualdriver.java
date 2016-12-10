import java.util.*;
import java.io.*;
import java.sql.*;

public class actualdriver
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

        // Erase Database
        answer = input.readLine("Begin? Press enter: ");
        if(answer != null)
        {
            System.out.println("Erasing Database");
            aapp.eraseDB();
        }

        // Load Airline Info
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Loading Airline Info");
            aapp.loadAirline("loadairline.csv");
            // aapp.showTable("Airline");
        }

        // Load Plane Info
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Loading Plane Info");
            aapp.loadPlane("loadplane.csv");
            // aapp.showTable("Plane");
        }

        // Load Flight Schedule Info
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Loading Flight Schedule");
            aapp.loadSchedule("loadschedule.csv");
            // aapp.showTable("Flight");
        }

        // Load Pricing Info
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Loading Price Info");
            aapp.loadPrice("loadpricing.csv");
            // aapp.showTable("Price");
        }

        // Add Customers
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Adding Customer");
            ccpp.addCustomer("Mrs", "Reizoirmed", "Camaracer", "0000000000000000", "APR-2009", "000 United Rd", "Pittsburgh", "PA", "1234567000", "RC000@gmail.com");
        }

        // Show customers
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Showing Customer Info");
            ccpp.showCustomer("Reizoirmed", "Camaracer");
        }

        // Find Routes
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Finding Routes");
            ccpp.findRoutes("JFK", "SEA");
        }

        // Find Routes Given Airline
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Finding Routes given Airline");
            ccpp.findRoutesAirlines("JFK", "SEA", "United Airlines");
        }

        // Find Routes Given Date
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Finding Routes on a given Date");
            ccpp.findRoutesDate("JFK", "SEA", "M");
        }

        // Find Routes give date and airline_id
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Finding Routes given Date and Airline");
            ccpp.findRoutesDateAirline("JFK", "SEA", "M", "United Airlines");
        }

        // Add Reservations
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Adding Reservation");
            ccpp.addReservation("11000", "0000000000000000", "1", "000", "19-MAY-19 02:00:00");
        }

        // Find Price Between cities
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Finding Price of Reservation");
            ccpp.findPrice("JFK", "SEA");
        }

        //Change existing price
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Changing Price of Ticket");
            aapp.changePrice("JFK", "SEA", "00001", "1000", "500");
        }

        // Buy Ticket
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Buying Ticket");
            ccpp.buyReservation("11000");
        }

        // Show Reservation Info
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Showing Reservation Added");
            ccpp.findReservation("11000");
        }

        //Generate Passenger Manifest for a specific flight on given date
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Generating Passenger manifest for all flights on all dates");
            aapp.generateManifest("000", "19-MAY-19 02:00:00");
        }

        // String table = input.readLine("Please specify a table to display: ");
        // aapp.showTable(table);
        connection.close();
    }
}
