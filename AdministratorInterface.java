/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package administratorinterface;

/**
 *
 * @author Zach
 */

import java.sql.*;
import java.util.Scanner;

public class AdministratorInterface {

    /**
     * @param args the command line arguments
     */
    private Connection connection; //used to hold the jdbc connection to the DB
    private Statement statement; //used to create an instance of the connection
    private ResultSet resultSet; //used to hold the result of your query (if one
                                 // exists)
    private String query;  //this will hold the query we are using
    private String username, password;

    private boolean loop;

    public AdministratorInterface() throws SQLException{
       username = "tik12"; //This is your username in oracle
       password = "3886681"; //This is your password in oracle
       try{
         //Register the oracle driver.  This needs the oracle files provided
         //in the oracle.zip file, unzipped into the local directory and
         //the class path set to include the local directory
         DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
         //This is the location of the database.  This is the database in oracle
         //provided to the class
         String url = "jdbc:oracle:thin:@class3.cs.pitt.edu:1521:dbclass";

         connection = DriverManager.getConnection(url, username, password);
         //create a connection to DB on class3.cs.pitt.edu
       }
       catch(Exception Ex)  //What to do with any exceptions
       {
         System.out.println("Error connecting to database.  Machine Error: " +
               Ex.toString());
           Ex.printStackTrace();
       }

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        int n, p;
        Scanner input = new Scanner(System.in);
        String answer;
        String confirm;
        String filename;
        String d_city;
        String a_city;
        String h_price;
        String l_price;
        String f_number;
        String f_date;
        boolean whileLoop = true;

        System.out.println("Hello Administrator to the future of flight");
        System.out.println("Here are you options for the menu (type 1-7)");
        System.out.println("1.) Erase Database");
        System.out.println("2.) Load Airline Info");
        System.out.println("3.) Load Schedule Info");
        System.out.println("4.) Load Pricing Info");
        System.out.println("5.) Load Plane info");
        System.out.println("6.) Generate Passenger Manifest");
        System.out.println("7.) Quit");
        System.out.println("0.) Display Options");

        while(whileLoop){
            System.out.println("Enter a number: ");
            n = reader.nextInt(); // Scans the next token of the input as an int.

            if(n == 1){
              System.out.println("Are you sure you want to delete the whole database?");
              System.out.println("Please Confirm with: Y or Yes");
              confirm = reader.next().toUpperCase();
              if(confirm.compareTo("Y")==0 || confirm.compareTo("YES")==0)
              {
                System.out.println("Deleting all records...");
                // Statement st = connection.createStatement();
                // query = "TRUNCATE TABLE *";
                // st.executeUpdate(query);
                System.out.println("Delete Successful");
              }
              else if(confirm.compareTo("N")==0 || confirm.compareTo("NO")==0)
              {
                System.out.println("Deletion Cancelled");
              }
              else
              {
                System.out.println("Invalid input: Request declined");
              }
            }
            else if(n == 2){
              System.out.print("Please supply a filename: ");
              filename = reader.next();
            }
            else if(n == 3){
              System.out.print("Please supply a filename: ");
              filename = reader.next();
            }
            else if(n == 4){
              System.out.println("Please selection an option");
              System.out.println("Load pricing information: \"L\"");
              System.out.println("OR");
              System.out.println("Change the price of an existing flight: \"C\"");
              answer = reader.next();
              if(answer.compareTo("L") == 0)
              {
                System.out.print("Please supply a filename: ");
                filename = reader.next();
              }
              else if(answer.compareTo("C") == 0)
              {
                System.out.println("Please supply: departure city, arrival city, high price and low price");
                System.out.print("Departure city: ");
                d_city = reader.next();
                System.out.print("Arrival city: ");
                a_city = reader.next();
                System.out.print("High price: ");
                h_price = reader.next();
                System.out.print("Low price: ");
                l_price = reader.next();
              }
              else
              {
                System.out.println("Invalid input: Request declined");
              }
            }
            else if(n == 5){
              System.out.print("Please supply a filename: ");
              filename = reader.next();
            }
            else if(n == 6){
              System.out.println("Please supply a flight number and date");
              System.out.print("Flight number: ");
              f_number = reader.next();
              System.out.print("Date: ");
              f_date = reader.next();
            }
            else if(n == 7){
                System.out.println("Quiting");
                whileLoop = false;
            }
            else if(n == 0){
              System.out.println("1.) Erase Database");
              System.out.println("2.) Load Airline Info");
              System.out.println("3.) Load Schedule Info");
              System.out.println("4.) Load Pricing Info");
              System.out.println("5.) Load Plane info");
              System.out.println("6.) Generate Passenger Manifest");
              System.out.println("7.) Quit");
              System.out.println("0.) Display Options");
            }
            else{
                System.out.println("Wrong input: Please input something from 1-7");
            }
        }
        connection.close();
    }

    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        AdministratorInterface app = new AdministratorInterface();

    }

}
