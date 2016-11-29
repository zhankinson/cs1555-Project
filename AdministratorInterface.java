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
import java.util.Date;
import java.util.Scanner;

public class AdministratorInterface {

    /**
     * @param args the command line arguments
     */
    private Connection connection; //used to hold the jdbc connection to the DB
    private Statement st; //used to create an instance of the connection
    private ResultSet resultSet; //used to hold the result of your query (if one
    private ResultSetMetaData rsmd; // exists)
    private String query;  //this will hold the query we are using
    private String username, password;
    private String confirm;
    private String filename;
    private String departCity;
    private String arriveCity;
    private String highPrice;
    private String lowPrice;
    private String flightNumber;
    private String flightDate;

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

        boolean whileLoop = true;

        System.out.println("Hello Administrator to the future of flight");
        System.out.println("Here are you options for the menu (type 1-7)");
        System.out.println("1.) Erase Database");
        System.out.println("2.) Load Airline Info");
        System.out.println("3.) Load Schedule Info");
        System.out.println("4.) Load/Change Pricing Info");
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
                st = connection.createStatement();
                query = "TRUNCATE TABLE *";
                try{
                  connection.setAutoCommit(false);
                  st.executeUpdate(query);
                  connection.commit();
                  System.out.println("Delete Successful");
                }
                catch(SQLException e){
                  System.out.println("Error: Delete Unsuccessful");
                  System.err.println(e.toString());
                  try {
                    connection.rollback();
                  }
                  catch(SQLException ee){
                    System.err.println(ee.toString());
                  }
                }
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
              st = connection.createStatement();
              String sql = "load data infile '"+filename+
              "' into table Airline "+
              " fields terminated by \',\' enclosed by \'\"'"+
              " lines terminated by \'\\n\'";
              try{
                connection.setAutoCommit(false);
                st.executeUpdate(sql);
                connection.commit();
                System.out.println("Load Successful");
              }
              catch(SQLException e){
                System.out.println("Error: Load Unsuccessful");
                System.err.println(e.toString());
                try{
                  connection.rollback();
                }
                catch(SQLException ee){
                  System.err.println(ee.toString());
                }
              }
            }
            else if(n == 3){
              System.out.print("Please supply a filename: ");
              filename = reader.next();
              st = connection.createStatement();
              String sql = "load data infile '"+filename+
              "' into table Flight "+
              " fields terminated by \',\' enclosed by \'\"'"+
              " lines terminated by \'\\n\'";
              try{
                connection.setAutoCommit(false);
                st.executeUpdate(sql);
                connection.commit();
                System.out.println("Load Successful");
              }
              catch(SQLException e){
                System.out.println("Error: Load Unsuccessful");
                System.err.println(e.toString());
                try{
                  connection.rollback();
                }
                catch(SQLException ee){
                  System.err.println(ee.toString());
                }
              }
            }
            else if(n == 4){
              System.out.println("Please selection an option");
              System.out.println("Load pricing information: \"L\"");
              System.out.println("OR");
              System.out.println("Change the price of an existing flight: \"C\"");
              answer = reader.next().toUpperCase();
              if(answer.compareTo("L") == 0)
              {
                System.out.print("Please supply a filename: ");
                filename = reader.next();
                st = connection.createStatement();
                String sql = "load data infile '"+filename+
                "' into table Price "+
                " fields terminated by \',\' enclosed by \'\"'"+
                " lines terminated by \'\\n\'";
                try{
                  connection.setAutoCommit(false);
                  st.executeUpdate(sql);
                  connection.commit();
                  System.out.println("Load Successful");
                }
                catch(SQLException e){
                  System.out.println("Error: Load Unsuccessful");
                  System.err.println(e.toString());
                  try{
                    connection.rollback();
                  }
                  catch(SQLException ee){
                    System.err.println(ee.toString());
                  }
                }
              }
              else if(answer.compareTo("C") == 0)
              {
                System.out.println("Please supply: departure city, arrival city, high price and low price");
                System.out.print("Departure city: ");
                departCity = reader.next();
                System.out.print("Arrival city: ");
                arriveCity = reader.next();
                System.out.print("High price: ");
                highPrice = reader.next();
                System.out.print("Low price: ");
                lowPrice = reader.next();
                query = "update Price set high_price = ?, low_price = ? "+
                        "where departure_city = ? and arrival_city = ?";
                PreparedStatement pStatement = connection.prepareStatement(query);
                pStatement.setInt(1, Integer.parseInt(highPrice));
                pStatement.setInt(2, Integer.parseInt(lowPrice));
                pStatement.setString(3, departCity);
                pStatement.setString(4, arriveCity);
                try{
                  connection.setAutoCommit(false);
                  pStatement.executeUpdate();
                  connection.commit();
                  System.out.println("Update Successful");
                }
                catch(SQLException e){
                  System.out.println("Error: Update Unsuccessful");
                  try{
                    connection.rollback();
                  }
                  catch(SQLException ee){
                    System.err.println(ee.toString());
                  }
                }
              }
              else
              {
                System.out.println("Invalid input: Request declined");
              }
            }
            else if(n == 5){
              System.out.print("Please supply a filename: ");
              filename = reader.next();
              st = connection.createStatement();
              String sql = "load data infile '"+filename+
              "' into table Airline "+
              " fields terminated by \',\' enclosed by \'\"'"+
              " lines terminated by \'\\n\'";
              try{
                connection.setAutoCommit(false);
                st.executeUpdate(sql);
                connection.commit();
                System.out.println("Load Successful");
              }
              catch(SQLException e){
                System.out.println("Error: Load Unsuccessful");
                System.err.println(e.toString());
                try{
                  connection.rollback();
                }
                catch(SQLException ee){
                  System.err.println(ee.toString());
                }
              }
            }
            else if(n == 6){
              System.out.println("Please supply a flight number and date");
              System.out.print("Flight number: ");
              flightNumber = reader.next();
              System.out.print("Date (DD-Mon-YY HH24:MI:SS): ");
              flightDate = reader.next();
              java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("dd-MMM-yy HH24:mm:ss");
              java.sql.Date formatDate = null;
              try{
                // preDate = new java.util.Date(flightDate);
                formatDate = new java.sql.Date (df.parse(flightDate).getTime());
              }
              catch (Exception e){
                e.printStackTrace();
              }
              query = "select (salutation, first_name, last_name) "+
                      "from Customer "+
                      "where cid = (select cid "+
                                  "from Reservation "+
                                  "where reservation_number = (select reservation_number "+
                                                              "from Reservation_detail "+
                                                              "where flight_number = ? "+
                                                              "AND flight_date = to_date(?, 'DD-MON-YYYY HH24:MI:SS')))";
              PreparedStatement pStatement = connection.prepareStatement(query);
              pStatement.setString(1, flightNumber);
              pStatement.setDate(2, formatDate);
              try{
                connection.setAutoCommit(false);
                resultSet = pStatement.executeQuery();
                rsmd = resultSet.getMetaData();
                connection.commit();
                int colNm = rsmd.getColumnCount();
                while (resultSet.next()) {
                  for (int i = 1; i <= colNm; i++) {
                    if(i>1) System.out.print(", ");
                    String colVal = resultSet.getString(i);
                    System.out.print(colVal + " " + rsmd.getColumnName(i));
                  }
                  System.out.println("");
                }
              }
              catch(SQLException e){
                System.out.println("Error: Cannot Generate Manifest");
                System.err.println(e.toString());
                try{
                  connection.rollback();
                }
                catch(SQLException ee){
                  System.err.println(ee.toString());
                }
              }
            }
            else if(n == 7){
                System.out.println("Quiting");
                whileLoop = false;
            }
            else if(n == 0){
              System.out.println("1.) Erase Database");
              System.out.println("2.) Load Airline Info");
              System.out.println("3.) Load Schedule Info");
              System.out.println("4.) Load/Change Pricing Info");
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
