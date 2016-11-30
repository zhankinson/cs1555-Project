/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package customerinterface;

/**
 *
 * @author Tim
 */
import java.io.BufferedReader;
import java.sql.*;
import java.util.Scanner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


public class CustomerInterface {

    /**
     * @param args the command line arguments
     */

    private Connection connection; //used to hold the jdbc connection to the DB
    private Statement statement; //used to create an instance of the connection
    private ResultSet resultSet; //used to hold the result of your query (if one
    private ResultSetMetaData rsmd; // exists)
    private String query;  //this will hold the query we are using
    private String username, password;
    private int cid = 110000000;

    //Variables for Task 1 and 2
    private String salutation;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String phoneNumber;
    private String email;
    private String creditCard;
    private String creditCardDate;
  	private String date;

    //Variables for Task 3
    private String cityA;
    private String cityB;

    //Variables for Task 4
    private String departCity;
    private String arriveCity;

  	//variables for Task 5
  	private String airline;

    //variables for task 8
    private int ResNumber = 00200;
    private int res_cid;
    private int cost;
    private String ticketed;
    private String flightNumber;
    private String flightDate;
	private String credNum;
    private int leg;

  	//variables for Task 10
  	private String reservationNumber;

    private boolean loop;

    public CustomerInterface() throws SQLException{
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
       catch(Exception Ex)
       { //What to do with any exceptions
         System.out.println("Error connecting to database.  Machine Error: " +
               Ex.toString());
           Ex.printStackTrace();
       }

	   DateFormat dateFormat = new SimpleDateFormat("DD-MON-YYYY HH24:MI:SS");
	   
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        int n, p;
        Scanner input = new Scanner(System.in);
        String answer;
        boolean whileLoop = true;

        System.out.println("Hello Customer to the future of flight");
        System.out.println("Here are you options for the menu (type 1-11)");
        System.out.println("1.) Add Customer");
        System.out.println("2.) Show Customer Info");
        System.out.println("3.) Find Price of Flight");
        System.out.println("4.) Find All Routes from a City");
        System.out.println("5.) Find All Routes from a City, given the Airport");
        System.out.println("6.) Find all routes with available seats between two cities on a given date");
        System.out.println("7.) For a given airline, find all routes with available seats between two cities on given date");
        System.out.println("8.) Add Reservation");
        System.out.println("9.) Show reservation info");
        System.out.println("10.) Buy ticket fro existing reservation");
        System.out.println("11.) Quit");
        System.out.println("0.) Display Options");

        while(whileLoop){
            System.out.println("Enter a number: ");
            n = reader.nextInt(); // Scans the next token of the input as an int.

            if(n == 1){
                loop = true;
                while(loop){
                    System.out.println("1.) Mr");
                    System.out.println("2.) Ms");
                    System.out.println("3.) Mrs");
                    System.out.println("Enter a number for your salutation: ");
                    p = reader.nextInt();
                    if(p == 1){
                        salutation = "Mr";
                        loop = false;
                    }
                    else if(p == 2){
                        salutation = "Ms";
                        loop = false;
                    }
                    else if(p == 3){
                        salutation = "Mrs";
                        loop = false;
                    }
                    else{
                        System.out.println("Please select a valid input");
                    }
                }
                loop = true;
                boolean found = false;
                while(loop){
                    System.out.println("Please Enter Your First Name");
                    firstName = input.nextLine();
                    System.out.println("Please Enter Your Last Name");
                    lastName = input.nextLine();
                    query = "Select * from Customer";
                    statement = connection.createStatement();
                    resultSet = statement.executeQuery(query);
                    while(resultSet.next()){
                        if(firstName.equals(resultSet.getString(3)) && lastName.equals(resultSet.getString(4))){
                            System.out.println("Your customer name already exists");
                            found = true;
                            break;
                        }
                        else if(resultSet.next() == false){
                          loop = false;
                        }
                    }
                }
                if(found == false){
                  System.out.println("Please Enter Your Street Address");
                  street = input.nextLine();
                  System.out.println("Please Enter Your City");
                  city = input.nextLine();
                  System.out.println("Please Enter Your State");
                  state = input.nextLine();
                  System.out.println("Please Enter Your Phone Number");
                  phoneNumber = input.nextLine();
                  System.out.println("Please Enter Your Email Address");
                  email = input.nextLine();
                  System.out.println("Please Enter Your Credit Card Number");
                  creditCard = input.nextLine();
                  System.out.println("Please Enter Your Credit Card Expiration Date (MM/YYYY)");
                  creditCardDate = input.nextLine();
                  java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("MM/yyyy");
                  java.sql.Date expiration = null;
                  try{
                    expiration = new java.sql.Date (df.parse(creditCardDate).getTime());
                  }
                  catch (Exception e){
                    e.printStackTrace();
                  }
                  query = "insert into Customer values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                  PreparedStatement updateStatement = connection.prepareStatement(query);
                  updateStatement.setString(1, Integer.toString(cid));
                  updateStatement.setString(2, salutation);
                  updateStatement.setString(3, firstName);
                  updateStatement.setString(4, lastName);
                  updateStatement.setString(5, creditCard);
                  updateStatement.setDate(6, expiration);
                  updateStatement.setString(7, street);
                  updateStatement.setString(8, city);
                  updateStatement.setString(9, state);
                  updateStatement.setString(10, phoneNumber);
                  updateStatement.setString(11, email);
                  updateStatement.setString(12, null);

                  updateStatement.executeUpdate();
                  System.out.println("Your PittRewards number is " + Integer.toString(cid));
                  cid++;
                }
            }
            else if(n == 2){
                System.out.println("Please Enter the First Name to search");
                firstName = input.nextLine();
                System.out.println("Please Enter the Last Name to search");
                lastName = input.nextLine();
                query = "Select * from Customer where first_name = ? and last_name = ?";
                PreparedStatement updateStatement = connection.prepareStatement(query);
                updateStatement.setString(1, firstName);
                updateStatement.setString(2, lastName);

                resultSet = updateStatement.executeQuery();
                System.out.println("Info on " + firstName + " " + lastName);
                while(resultSet.next()){
                   System.out.println("PittRewards " + resultSet.getString(1));
                   System.out.println("Salutation " + resultSet.getString(2));
                   System.out.println("First Name " + resultSet.getString(3));
                   System.out.println("Last Name " + resultSet.getString(4));
                   System.out.println("Credit Card Number " + resultSet.getString(5));
                   System.out.println("Credit Card Expiration Date " + resultSet.getDate(6));
                   System.out.println("Street " + resultSet.getString(7));
                   System.out.println("City " + resultSet.getString(8));
                   System.out.println("State " + resultSet.getString(9));
                   System.out.println("Phone Number " + resultSet.getString(10));
                   System.out.println("Email " + resultSet.getString(11));
                   System.out.println("Frequent Miles " + resultSet.getString(12));
                }
            }
            else if(n == 3){
              System.out.print("Please enter a 3-letter city (Example: PIT for Pittsburgh): ");
              cityA = reader.next();
              System.out.print("Please enter another city: ");
              cityB = reader.next();
              query = "select * from Price where (departure_city = ? AND arrival_city = ?) OR (departure_city = ? AND arrival_city = ?)";
              PreparedStatement pStatement = connection.prepareStatement(query);
              pStatement.setString(1, cityA);
              pStatement.setString(2, cityB);
              pStatement.setString(3, cityB);
              pStatement.setString(4, cityA);
              try{
                connection.setAutoCommit(false);
                resultSet = pStatement.executeQuery();
                connection.commit();
                while (resultSet.next()) {
                  System.out.println("Departure City: "+resultSet.getString(1));
                  System.out.println("Arrival City: "+resultSet.getString(2));
                  System.out.println("High Price: "+resultSet.getString(4));
                  System.out.println("Low Price: "+resultSet.getString(5));
                  System.out.println("");
                }
              }
              catch (SQLException e){
                System.out.println("Error: Cannot complete search");
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
              System.out.print("Departure city: ");
              departCity = reader.next();
              System.out.print("Arrival city: ");
              arriveCity = reader.next();
              query = "select * "+
                      "from Flight "+
                      "where departure_city = ? AND arrival_city = ?";
              PreparedStatement pStatement = connection.prepareStatement(query);
              pStatement.setString(1, departCity);
              pStatement.setString(2, arriveCity);
              try{
                connection.setAutoCommit(false);
                resultSet = pStatement.executeQuery();
                connection.commit();
                while (resultSet.next()) {
                    System.out.println("Departure City: "+resultSet.getString(4));
          					System.out.println("Arrival City: "+resultSet.getString(5));
          					System.out.println("Flight Number: "+resultSet.getString(1));
          					System.out.println("Departure Time: "+resultSet.getString(6));
          					System.out.println("Arrival Time: "+resultSet.getString(7));
          					System.out.println("");
                }
              }
              catch(SQLException e){
                System.out.println("Error: Cannot complete search");
                try{
                  connection.rollback();
                }
                catch(SQLException ee){
                  System.err.println(ee.toString());
                }
              }
            }
      			else if(n == 5){
      				System.out.print("Please enter a 3-letter city (Example: PIT for Pittsburgh): ");
      				  cityA = reader.next();
      				  System.out.print("Please enter another city: ");
      				  cityB = reader.next();
      				  System.out.print("Please enter name of airline: ");
      				  airline = br.readline();
      				  query = "select * from Flight "+
      						  "where ((departure_city = ? "+
      						  "AND arrival_city = ?) "+
      						  "OR (departure_city = ? "+
      						  "AND arrival_city = ?))" +
      						  "AND airline_id = (select airline_id from airline where airline_name = ?)";
      				  PreparedStatement pStatement = connection.prepareStatement(query);
      				  pStatement.setString(1, cityA);
      				  pStatement.setString(2, cityB);
      				  pStatement.setString(3, cityB);
      				  pStatement.setString(4, cityA);
      				  pStatement.setString(5, airline);
      				  try{
        					connection.setAutoCommit(false);
        					resultSet = pStatement.executeQuery();
        					connection.commit();
        					while (resultSet.next()) {
        					  System.out.println("Airline ID: "+resultSet.getString(2));
        					  System.out.println("Flight Number: "+resultSet.getString(1));
        					  System.out.println("Departure City: "+resultSet.getString(3));
        					  System.out.println("Arrival City: "+resultSet.getString(4));
        					  System.out.println("Departure Time: "+resultSet.getString(5));
        					  System.out.println("Arrival Time: "+resultSet.getString(6));
        					  System.out.println("");
        					}
      				  }
      				  catch (SQLException e){
        					System.out.println("Error: Cannot complete search");
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
      				System.out.print("Please enter a 3-letter city (Example: PIT for Pittsburgh): ");
      				  cityA = reader.next();
      				  System.out.print("Please enter another city: ");
      				  cityB = reader.next();
      				  System.out.print("Please enter the date: ");
      				  airline = reader.next();
      				  query = "select * from Flight "+
      						  "where ((departure_city = ? "+
      						  "AND arrival_city = ?) "+
      						  "OR (departure_city = ? "+
      						  "AND arrival_city = ?))" +
      						  "AND departure_time = ?)";
      				  PreparedStatement pStatement = connection.prepareStatement(query);
      				  pStatement.setString(1, cityA);
      				  pStatement.setString(2, cityB);
      				  pStatement.setString(3, cityB);
      				  pStatement.setString(4, cityA);
      				  pStatement.setString(5, airline);
      				  try{
        					connection.setAutoCommit(false);
        					resultSet = pStatement.executeQuery();
        					connection.commit();
        					while (resultSet.next()) {
        					  System.out.println("Airline ID: "+resultSet.getString(2));
        					  System.out.println("Flight Number: "+resultSet.getString(1));
        					  System.out.println("Departure City: "+resultSet.getString(3));
        					  System.out.println("Arrival City: "+resultSet.getString(4));
        					  System.out.println("Departure Time: "+resultSet.getString(5));
        					  System.out.println("Arrival Time: "+resultSet.getString(6));
        					  System.out.println("");
        					}
      				  }
      				  catch (SQLException e){
        					System.out.println("Error: Cannot complete search");
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
      				System.out.print("Please enter a 3-letter city (Example: PIT for Pittsburgh): ");
      				  cityA = reader.next();
      				  System.out.print("Please enter another city: ");
      				  cityB = reader.next();
      				  System.out.print("Please enter the date: ");
      				  date = reader.next();
      				  System.out.print("Please enter name of airline: ");
      				  airline = br.readline();
      				  query = "select * from Flight "+
      						  "where ((departure_city = ? "+
      						  "AND arrival_city = ?) "+
      						  "OR (departure_city = ? "+
      						  "AND arrival_city = ?))" +
      						  "AND departure_time = ? AND (select airline_id from airline where airline_name = ?))";
      				  PreparedStatement pStatement = connection.prepareStatement(query);
      				  pStatement.setString(1, cityA);
      				  pStatement.setString(2, cityB);
      				  pStatement.setString(3, cityB);
      				  pStatement.setString(4, cityA);
      				  pStatement.setString(5, date);
      				  pStatement.setString(6, airline);
      				  try{
        					connection.setAutoCommit(false);
        					resultSet = pStatement.executeQuery();
        					connection.commit();
        					while (resultSet.next()) {
        					  System.out.println("Airline ID: "+resultSet.getString(2));
        					  System.out.println("Flight Number: "+resultSet.getString(1));
        					  System.out.println("Departure City: "+resultSet.getString(3));
        					  System.out.println("Arrival City: "+resultSet.getString(4));
        					  System.out.println("Departure Time: "+resultSet.getString(5));
        					  System.out.println("Arrival Time: "+resultSet.getString(6));
        					  System.out.println("");
        					}
      				  }
      				  catch (SQLException e){
        					System.out.println("Error: Cannot complete search");
        					System.err.println(e.toString());
        					try{
        					  connection.rollback();
        					}
        					catch(SQLException ee){
        					  System.err.println(ee.toString());
        					}
      				  }
      			}
      			else if(n == 8){
					  flightDate = 2;
					  int legNum = 1;
					  while(flightDate != 0 || legNum <= 4){
						  System.out.print("CID: ");
						  res_cid = reader.nextInt();
						  System.out.print("Flight Number: ");
						  flightNumber = reader.next();
						  System.out.print("Flight Date: ");
						  flightDate = br.readLine();
						  query = "Select * from Customer where cid = ?";
							PreparedStatement updateStatement = connection.prepareStatement(query);
							updateStatement.setString(1, res_cid);

							resultSet = updateStatement.executeQuery();
							while(resultSet.next()){
							   credNum = resultSet.getString(5));
							}
							
							query = "Select * from Flight where flight_number = ?";
							PreparedStatement updateStatement = connection.prepareStatement(query);
							updateStatement.setString(1, flightNumber);

							resultSet = updateStatement.executeQuery();
							while(resultSet.next()){
							   cityA = resultSet.getString(4));
							   cityB = resultSet.getString(5));
							}
							
							query = "Select * from Price where departure_city = ? AND arrival_city = ?";
							PreparedStatement updateStatement = connection.prepareStatement(query);
							updateStatement.setString(1, CityA);
							updateStatement.setString(2, cityB);

							resultSet = updateStatement.executeQuery();
							while(resultSet.next()){
							   cost = resultSet.getInt(high_price);
							}
							
							Date date = new Date();
							query = "insert into Reservation values (?, ?, ?, ?, to_date('?', 'DD-MON-YYYY HH24:MI:SS'), ?, ?, ?)";
							PreparedStatement updateStatement = connection.prepareStatement(query);
							updateStatement.setString(1, Integer.toString(resNumber));
							updateStatement.setString(2, res_cid);
							updateStatement.setInt(3, cost);
							updateStatement.setString(4, credNum);
							updateStatement.setString(5, dateFormat.format(date));
							updateStatement.setString(6, 'N');
							updateStatement.setString(7, cityA);
							updateStatement.setString(8, cityB);
							resultSet = updateStatement.executeQuery();
							
							query = "insert into Reservation_detail values (?, ?, to_date('', 'DD-MON-YYYY HH24:MI:SS'), ?)";
							PreparedStatement updateStatement = connection.prepareStatement(query);
							updateStatement.setString(1, Integer.toString(resNumber));
							updateStatement.setString(2, flightNumber);
							updateStatement.setInt(3, flightDate);
							updateStatement.setString(4, Integer.toString(legNum));
							
							legNum++;
							
					  }


      			}
      			else if(n == 9){
      				System.out.println("Please enter the Reservation Number");
                      reservationNumber = input.nextLine();

                      query = "Select * from Reservation where reservation_number = ?";
                      PreparedStatement updateStatement = connection.prepareStatement(query);
                      updateStatement.setString(1, reservationNumber);

                      resultSet = updateStatement.executeQuery();
                      System.out.println("Info on " + reservationNumber);
      				if(resultSet == null){
      					System.println("Reservation number does not exist");
      				}
                      while(resultSet.next()){
                         System.out.println("CID " + resultSet.getString(2));
                         System.out.println("Cost " + resultSet.getInt(3));
                         System.out.println("Reservation Date " + resultSet.getDate(4));
                         System.out.println("Ticketed " + resultSet.getString(5));
                         System.out.println("Departure City " + resultSet.getDate(6));
                         System.out.println("Arrival City " + resultSet.getString(7));
                         System.out.println("");
                      }
      			}
      			else if(n == 10){
      				System.out.println("Please enter the Reservation Number");
                      reservationNumber = input.nextLine();

                      query = "Update Reservation set ticketed = 'Y' where reservation_number = ?";
                      PreparedStatement updateStatement = connection.prepareStatement(query);
                      updateStatement.setString(1, reservationNumber);

                      resultSet = updateStatement.executeQuery();
                      System.out.println("Ticket Purchased ");
      			}
            else if(n == 11){
                System.out.println("Quiting");
                whileLoop = false;
            }
            else if(n == 0){
              System.out.println("1.) Add Customer");
              System.out.println("2.) Show Customer Info");
              System.out.println("3.) Find Price of Flight");
              System.out.println("4.) Find All Routes from a City");
              System.out.println("5.) Find All Routes from a City, given the Airport");
              System.out.println("6.) Find all routes with available seats between two cities on a given date");
              System.out.println("7.) For a given airline, find all routes with available seats between two cities on given date");
              System.out.println("8.) Add Reservation");
              System.out.println("9.) Show reservation info");
              System.out.println("10.) Buy ticket fro existing reservation");
              System.out.println("11.) Quit");
              System.out.println("0.) Display Options");
            }
            else{
                System.out.println("Wrong input please input something from 1-11");
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        CustomerInterface app = new CustomerInterface();

    }

}
