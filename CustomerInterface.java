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
import java.io.*;
import java.util.Scanner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
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
    private int cid = 11000;
	private int reservationID = 11000;
	private int lowCost;
	private ResultSet resultSet1;
	private ResultSet resultSet2;
	private ResultSet resultSet3;
	private ResultSet resultSet4;

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
    private int resNumber = 00200;
    private int res_cid;
    private int cost;
    private String ticketed;
    private String flightNumber;
    private String flightDate;
	private String credNum;

  	//variables for Task 10
  	private String reservationNumber;

    private boolean loop;

    //public CustomerInterface() throws SQLException, IOException{
	public CustomerInterface(Connection link) throws SQLException, IOException{
		this.connection = link;

		/*
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
        System.out.println("5.) Find All Routes from a City, given the air lines");
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
				System.out.println("Please Enter Your First Name");
                  firstName = input.nextLine();
				  System.out.println("Please Enter Your Last Name");
                  lastName = input.nextLine();
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
                  System.out.println("Please Enter Your Credit Card Expiration Date (MON-YYYY)");
                  creditCardDate = input.nextLine();
				  addCustomer(firstName, lastName, creditCard, creditCardDate, street, city, state, phoneNumber, email);
            }
            else if(n == 2){
                System.out.println("Please Enter the First Name to search");
                firstName = input.nextLine();
                System.out.println("Please Enter the Last Name to search");
                lastName = input.nextLine();
				showCustomer(firstName, lastName);
            }
            else if(n == 3){
              System.out.print("Please enter a 3-letter city (Example: PIT for Pittsburgh): ");
              cityA = reader.next();
              System.out.print("Please enter another city: ");
              cityB = reader.next();
			  findPrice(cityA, cityB);
            }
            else if(n == 4){
              System.out.print("Departure city: ");
              departCity = reader.next();
              System.out.print("Arrival city: ");
			  System.out.println();
              arriveCity = reader.next();
              findRoutes(departCity, arriveCity);
            }
      			else if(n == 5){
      				System.out.print("Please enter a 3-letter city (Example: PIT for Pittsburgh): ");
      				  cityA = reader.next();
      				  System.out.print("Please enter another city: ");
      				  cityB = reader.next();
      				  System.out.print("Please enter name of airline: ");
      				  airline = br.readLine();
					  findRoutesAirlines(cityA, cityB, airline);
      			}
      			else if(n == 6){
      				System.out.print("Please enter a 3-letter city (Example: PIT for Pittsburgh): ");
      				  cityA = reader.next();
      				  System.out.print("Please enter another city: ");
      				  cityB = reader.next();
      				  System.out.print("Please enter the initials for the day of the week(ie: M): ");
      				  date = reader.next();
					  findRoutesDate(cityA, cityB, date);
      			}
      			else if(n == 7){
      				System.out.print("Please enter a 3-letter city (Example: PIT for Pittsburgh): ");
      				  cityA = reader.next();
      				  System.out.print("Please enter another city: ");
      				  cityB = reader.next();
      				  System.out.print("Please enter the initials for the day of the week(ie: M): ");
      				  date = reader.next();
					  System.out.print("Please enter name of airline: ");
      				  airline = br.readLine();
					  findRoutesDateAirline(cityA, cityB, date, airline);
      			}
      			else if(n == 8){
					  String leg = "5";
					  boolean anotherPlane = false;
					  System.out.println("Please Enter Your CID");
					  firstName = input.nextLine();
					  System.out.println("Please Enter Your Credit Card Number");
					  creditCard = input.nextLine();
					  String flightNumber;
					  String userDate;
					  while(!leg.equals("0")){

						  System.out.print("Please the Leg of the trip: ");
						  leg = reader.next();
						  if(leg.equals("0"))
							  break;
						  System.out.print("Please enter the flight_number: ");
						  flightNumber = reader.next();
						  System.out.print("Please enter the date of the trip (DD-MON-YYYY HH24:MI:SS): ");
						  userDate = br.readLine();

						  addReservation(firstName, creditCard, leg, flightNumber, userDate);

					  }

      			}
      			else if(n == 9){
      				System.out.println("Please enter the Reservation Number");
                      reservationNumber = input.nextLine();
					  findReservation(reservationNumber);
      			}
      			else if(n == 10){
      				System.out.println("Please enter the Reservation Number");
                      reservationNumber = input.nextLine();
                      buyReservation(reservationNumber);
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
		*/

    }

	public void addCustomer(String salutation, String firstName, String lastName, String creditCard, String creditCardDate, String street, String city, String state, String phoneNumber, String email) throws SQLException, IOException
    {
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("MMM-yyyy");
		  java.sql.Date expiration = null;
		  try{
			expiration = new java.sql.Date (df.parse(creditCardDate).getTime());
		  }
		  catch (Exception e){
			e.printStackTrace();
		  }

		query = "Select * from Customer";
		statement = connection.createStatement();
		resultSet = statement.executeQuery(query);
		boolean found = false;

		while(resultSet.next()){
			if(firstName.equals(resultSet.getString(3)) && lastName.equals(resultSet.getString(4))){
				System.out.println("Your customer name already exists");
				System.out.println("");
				found = true;
				break;
			}
		}
		if(found){
		}
		else{

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
		  System.out.println("");
		  cid++;
		}
	}

	public void showCustomer(String firstName, String lastName) throws SQLException, IOException{
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
		   System.out.println("");
		}

	}

	public void findPrice(String cityA, String cityB) throws SQLException, IOException{
		try{
		  query = "select * from Price where (departure_city = ? AND arrival_city = ?) OR (departure_city = ? AND arrival_city = ?)";
		  PreparedStatement pStatement = connection.prepareStatement(query);
		  pStatement.setString(1, cityA);
		  pStatement.setString(2, cityB);
		  pStatement.setString(3, cityB);
		  pStatement.setString(4, cityA);

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

	public void findRoutes(String departCity, String arriveCity) throws SQLException, IOException{
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

	public void findRoutesAirlines(String cityA, String cityB, String airline) throws SQLException, IOException{
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
				  System.out.println("Departure City: "+resultSet.getString(4));
				  System.out.println("Arrival City: "+resultSet.getString(5));
				  System.out.println("Departure Time: "+resultSet.getString(6));
				  System.out.println("Arrival Time: "+resultSet.getString(7));
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

	public void findRoutesDate(String cityA, String cityB, String userDate) throws SQLException, IOException{
		boolean anotherPlane = false;
		// try{
		  
			//see capacity
			query = "select p.owner_id, p.plane_type, p.plane_capacity, f.flight_number, f.departure_city, f.arrival_city, f.departure_time, f.arrival_time from plane p, flight f, airline a where p.plane_type = f.plane_type and p.owner_id = f.airline_id and a.airline_id = f.airline_id and ((f.departure_city = ? AND f.arrival_city = ?) or (f.departure_city = ? AND f.arrival_city = ?))";
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setString(1, cityA);
			pStatement.setString(2, cityB);
			pStatement.setString(3, cityB);
			pStatement.setString(4, cityA);
			resultSet1 = pStatement.executeQuery();
			while(resultSet1.next()){
			
				//see taken seats
			    query = "select count(reservation_number) from Reservation_detail where flight_date = to_date(?, 'DD-MON-YYYY HH24:MI:SS') AND flight_number = ? group by flight_number";
			    pStatement = connection.prepareStatement(query);
				pStatement.setString(1, userDate);
				pStatement.setString(2, resultSet1.getString(4));
				resultSet = pStatement.executeQuery();


				//sees if there is another upgradable plane or another seat
				query = "select * from (select * from Plane where (plane_capacity > (select plane_capacity from Plane where plane_type = ? and owner_id = ?)) ORDER BY plane_capacity asc) where rownum <= 1";
				pStatement = connection.prepareStatement(query);
				pStatement.setString(2, resultSet1.getString(1));
				pStatement.setString(1, resultSet1.getString(2));
				connection.setAutoCommit(false);
				resultSet2 = pStatement.executeQuery();
				connection.commit();

				//get costs
				query = "select high_price, low_price from Price where departure_city = ? and arrival_city = ? and airline_id = ?";
				pStatement = connection.prepareStatement(query);
				pStatement.setString(1, resultSet1.getString(4));
				pStatement.setString(2, resultSet1.getString(5));
				pStatement.setString(3, resultSet1.getString(1));
				resultSet4 = pStatement.executeQuery();
				resultSet4.next();

				//get present date
				query = "select c_date from Our_Date where rownum<=1";
				pStatement = connection.prepareStatement(query);
				resultSet3 = pStatement.executeQuery();
				resultSet3.next();


				if(resultSet2.next()){
					anotherPlane = true;
				}
				if(anotherPlane && resultSet.next()){
					if(anotherPlane || Integer.parseInt(resultSet1.getString(3)) > Integer.parseInt(resultSet.getString(1))){
						System.out.println("Airline ID: "+resultSet1.getString(1));
						System.out.println("Flight Number: "+resultSet1.getString(4));
						System.out.println("Departure City: "+resultSet1.getString(5));
						System.out.println("Arrival City: "+resultSet1.getString(6));
						System.out.println("Departure Time: "+resultSet1.getString(7));
						System.out.println("Arrival Time: "+resultSet1.getString(8));
						System.out.println("");


					}
					else{
						System.out.println("Seats not available for flight " + resultSet1.getString(4));
						System.out.println("");
						reservationID++;
					}
				}
				//no seats so start the flight
				else{
					System.out.println("Airline ID: "+resultSet1.getString(1));
					System.out.println("Flight Number: "+resultSet1.getString(4));
					System.out.println("Departure City: "+resultSet1.getString(5));
					System.out.println("Arrival City: "+resultSet1.getString(6));
					System.out.println("Departure Time: "+resultSet1.getString(7));
					System.out.println("Arrival Time: "+resultSet1.getString(8));
					System.out.println("");
				}
			}
		// }
		// catch (SQLException e){
		// 	System.out.println("No matches to your flights;");
        //
		//   }
	}

	public void findRoutesDateAirline(String cityA, String cityB, String airline, String userDate) throws SQLException, IOException{
		boolean anotherPlane = false;
		// try{
		  
			//see capacity
			query = "select p.owner_id, p.plane_type, p.plane_capacity, f.flight_number, f.departure_city, f.arrival_city, f.departure_time, f.arrival_time from plane p, flight f, airline a where p.plane_type = f.plane_type and p.owner_id = f.airline_id and a.airline_id = f.airline_id and a.airline_name = ? and ((f.departure_city = ? AND f.arrival_city = ?) or (f.departure_city = ? AND f.arrival_city = ?))";
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setString(1, airline);
			pStatement.setString(2, cityA);
			pStatement.setString(3, cityB);
			pStatement.setString(4, cityB);
			pStatement.setString(5, cityA);
			resultSet1 = pStatement.executeQuery();
			while(resultSet1.next()){
			
				//see taken seats
			    query = "select count(reservation_number) from Reservation_detail where flight_date = to_date(?, 'DD-MON-YYYY HH24:MI:SS') AND flight_number = ? group by flight_number";
			    pStatement = connection.prepareStatement(query);
				pStatement.setString(1, userDate);
				pStatement.setString(2, resultSet1.getString(4));
				resultSet = pStatement.executeQuery();


				//sees if there is another upgradable plane or another seat
				query = "select * from (select * from Plane where (plane_capacity > (select plane_capacity from Plane where plane_type = ? and owner_id = ?)) ORDER BY plane_capacity asc) where rownum <= 1";
				pStatement = connection.prepareStatement(query);
				pStatement.setString(2, resultSet1.getString(1));
				pStatement.setString(1, resultSet1.getString(2));
				connection.setAutoCommit(false);
				resultSet2 = pStatement.executeQuery();
				connection.commit();

				//get costs
				query = "select high_price, low_price from Price where departure_city = ? and arrival_city = ? and airline_id = ?";
				pStatement = connection.prepareStatement(query);
				pStatement.setString(1, resultSet1.getString(4));
				pStatement.setString(2, resultSet1.getString(5));
				pStatement.setString(3, resultSet1.getString(1));
				resultSet4 = pStatement.executeQuery();
				resultSet4.next();

				//get present date
				query = "select c_date from Our_Date where rownum<=1";
				pStatement = connection.prepareStatement(query);
				resultSet3 = pStatement.executeQuery();
				resultSet3.next();


				if(resultSet2.next()){
					anotherPlane = true;
				}
				if(anotherPlane && resultSet.next()){
					if(anotherPlane || Integer.parseInt(resultSet1.getString(3)) > Integer.parseInt(resultSet.getString(1))){
						System.out.println("Airline ID: "+resultSet1.getString(1));
						System.out.println("Flight Number: "+resultSet1.getString(4));
						System.out.println("Departure City: "+resultSet1.getString(5));
						System.out.println("Arrival City: "+resultSet1.getString(6));
						System.out.println("Departure Time: "+resultSet1.getString(7));
						System.out.println("Arrival Time: "+resultSet1.getString(8));
						System.out.println("");


					}
					else{
						System.out.println("Seats not available for flight " + resultSet1.getString(4));
						System.out.println("");
						reservationID++;
					}
				}
				//no seats so start the flight
				else{
					System.out.println("Airline ID: "+resultSet1.getString(1));
					System.out.println("Flight Number: "+resultSet1.getString(4));
					System.out.println("Departure City: "+resultSet1.getString(5));
					System.out.println("Arrival City: "+resultSet1.getString(6));
					System.out.println("Departure Time: "+resultSet1.getString(7));
					System.out.println("Arrival Time: "+resultSet1.getString(8));
					System.out.println("");
				}
			}
		// }
		// catch (SQLException e){
		// 	System.out.println("No matches to your flights;");
        //
		//   }
	}

	public void addReservation(String firstName, String creditCard, String leg, String flightNumber, String userDate) throws SQLException, IOException{
		boolean anotherPlane = false;
		// try{
		  //see taken seats
		  query = "select count(reservation_number) from Reservation_detail where flight_date = to_date(?, 'DD-MON-YYYY HH24:MI:SS') AND flight_number = ? group by flight_number";
		   PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setString(1, userDate);
			pStatement.setString(2, flightNumber);
			resultSet = pStatement.executeQuery();

			//see capacity
			query = "select p.owner_id, p.plane_type, p.plane_capacity, f.departure_city, f.arrival_city from plane p, flight f where p.plane_type = f.plane_type and p.owner_id = f.airline_id and f.flight_number = ?";
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, flightNumber);
			resultSet1 = pStatement.executeQuery();
			resultSet1.next();

			//sees if there is another upgradable plane or another seat
			query = "select * from (select * from Plane where (plane_capacity > (select plane_capacity from Plane where plane_type = ? and owner_id = ?)) ORDER BY plane_capacity asc) where rownum <= 1";
			pStatement = connection.prepareStatement(query);
			pStatement.setString(2, resultSet1.getString(1));
			pStatement.setString(1, resultSet1.getString(2));
			connection.setAutoCommit(false);
			resultSet2 = pStatement.executeQuery();
			connection.commit();
			resultSet2.next();

			//get costs
			query = "select high_price, low_price from Price where departure_city = ? and arrival_city = ? and airline_id = ?";
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, resultSet1.getString(4));
			pStatement.setString(2, resultSet1.getString(5));
			pStatement.setString(3, resultSet1.getString(1));
			resultSet4 = pStatement.executeQuery();
			resultSet4.next();

			//get present date
			query = "select c_date from Our_Date where rownum<=1";
			pStatement = connection.prepareStatement(query);
			resultSet3 = pStatement.executeQuery();
			resultSet3.next();


			if(resultSet2.next()){
				anotherPlane = true;
			}
			if(anotherPlane && resultSet.next()){
				if(anotherPlane || Integer.parseInt(resultSet1.getString(3)) > Integer.parseInt(resultSet.getString(1))){
					if(leg.equals("2")){


						query = "update Reservation set cost = ? where reservation_number = ?";

						  PreparedStatement updateStatement = connection.prepareStatement(query);
						  updateStatement.setString(2, Integer.toString(reservationID-1));
						  updateStatement.setInt(1, resultSet4.getInt(2));


						query = "insert into Reservation values (?, ?, ?, ?, ?, ?, ?, ?)";

						  updateStatement = connection.prepareStatement(query);
						  updateStatement.setString(1, Integer.toString(reservationID));
						  updateStatement.setString(2, firstName);
						  updateStatement.setInt(3, resultSet4.getInt(2));
						  updateStatement.setString(4, creditCard);
						  updateStatement.setDate(5, resultSet3.getDate(1));
						  updateStatement.setString(6, "N");
						  updateStatement.setString(7, resultSet1.getString(4));
						  updateStatement.setString(8, resultSet1.getString(5));
						  updateStatement.executeQuery();
						  connection.commit();

						  query = "insert into Reservation_detail values (?, ?, to_date(?, 'DD-MON-YYYY HH24:MI:SS'), ?)";

						  updateStatement = connection.prepareStatement(query);
						  updateStatement.setString(1, Integer.toString(reservationID));
						  updateStatement.setString(2, flightNumber);
						  updateStatement.setString(3, userDate);
						  updateStatement.setInt(4, Integer.parseInt(leg));
						  updateStatement.executeQuery();
						  connection.commit();
					}
					else if(leg.equals("1")){
						//hold on to lowCost just in case user adds in another leg
						lowCost = resultSet4.getInt(2);

						query = "insert into Reservation values (?, ?, ?, ?, ?, ?, ?, ?)";

						  PreparedStatement updateStatement = connection.prepareStatement(query);
						  updateStatement.setString(1, Integer.toString(reservationID));
						  updateStatement.setString(2, firstName);
						  updateStatement.setInt(3, resultSet4.getInt(1));
						  updateStatement.setString(4, creditCard);
						  updateStatement.setDate(5, resultSet3.getDate(1));
						  updateStatement.setString(6, "N");
						  updateStatement.setString(7, resultSet1.getString(4));
						  updateStatement.setString(8, resultSet1.getString(5));
						  updateStatement.executeQuery();
						  connection.commit();

						  query = "insert into Reservation_detail values (?, ?, to_date(?, 'DD-MON-YYYY HH24:MI:SS'), ?)";

						  updateStatement = connection.prepareStatement(query);
						  updateStatement.setString(1, Integer.toString(reservationID));
						  updateStatement.setString(2, flightNumber);
						  updateStatement.setString(3, userDate);
						  updateStatement.setInt(4, Integer.parseInt(leg));
						  updateStatement.executeQuery();
						  connection.commit();
					}
					else{
						query = "insert into Reservation values (?, ?, ?, ?, ?, ?, ?, ?)";

						  PreparedStatement updateStatement = connection.prepareStatement(query);
						  updateStatement.setString(1, Integer.toString(reservationID));
						  updateStatement.setString(2, firstName);
						  updateStatement.setInt(3, resultSet4.getInt(2));
						  updateStatement.setString(4, creditCard);
						  updateStatement.setDate(5, resultSet3.getDate(1));
						  updateStatement.setString(6, "N");
						  updateStatement.setString(7, resultSet1.getString(4));
						  updateStatement.setString(8, resultSet1.getString(5));
						  updateStatement.executeQuery();
						  connection.commit();

						  query = "insert into Reservation_detail values (?, ?, to_date(?, 'DD-MON-YYYY HH24:MI:SS'), ?)";

						  updateStatement = connection.prepareStatement(query);
						  updateStatement.setString(1, Integer.toString(reservationID));
						  updateStatement.setString(2, flightNumber);
						  updateStatement.setString(3, userDate);
						  updateStatement.setInt(4, Integer.parseInt(leg));
						  updateStatement.executeQuery();
						  connection.commit();
					}


				}
				else{
					System.out.println("Seats not available for flight " + flightNumber);
					System.out.println("");
					reservationID++;
				}
			}
			else{
				//hold on to lowCost just in case user adds in another leg
				lowCost = resultSet4.getInt(2);

				query = "insert into Reservation values (?, ?, ?, ?, ?, ?, ?, ?)";

				  PreparedStatement updateStatement = connection.prepareStatement(query);
				  updateStatement.setString(1, Integer.toString(reservationID));
				  updateStatement.setString(2, firstName);
				  updateStatement.setInt(3, resultSet4.getInt(1));
				  updateStatement.setString(4, creditCard);
				  updateStatement.setDate(5, resultSet3.getDate(1));
				  updateStatement.setString(6, "N");
				  updateStatement.setString(7, resultSet1.getString(4));
				  updateStatement.setString(8, resultSet1.getString(5));
				  updateStatement.executeQuery();
				  connection.commit();

                  query = "insert into Reservation_detail values (?, ?, to_date(?, 'DD-MON-YYYY HH24:MI:SS'), ?)";

                  updateStatement = connection.prepareStatement(query);
                  updateStatement.setString(1, Integer.toString(reservationID));
                  updateStatement.setString(2, flightNumber);
                  updateStatement.setString(3, userDate);
                  updateStatement.setInt(4, Integer.parseInt(leg));
                  updateStatement.executeQuery();
                  connection.commit();
			}
			System.out.println("Reservations made, your reservation number: " + Integer.toString(reservationID));
			reservationID++;
		// }
		// catch (SQLException e){
		// 	System.out.println("No matches to your flights;");
        //
		//   }
	}

	public void findReservation(String reservationNumber) throws SQLException, IOException{
		query = "Select * from totalReservation where reservation_number = ?";
		  PreparedStatement updateStatement = connection.prepareStatement(query);
		  updateStatement.setString(1, reservationNumber);

		  resultSet = updateStatement.executeQuery();
		while(resultSet.next()){

			 System.out.println("Info on " + reservationNumber);
			 System.out.println("CID " + resultSet.getString(2));
			 System.out.println("Cost " + resultSet.getInt(3));
			 System.out.println("Reservation Date " + resultSet.getString(5));
			 System.out.println("Ticketed " + resultSet.getString(6));
			 System.out.println("Departure City " + resultSet.getString(7));
			 System.out.println("Arrival City " + resultSet.getString(8));
			 System.out.println("Flight Number " + resultSet.getString(9));
			 System.out.println("Flight Date "  + resultSet.getString(10));
			 System.out.println("Leg " + resultSet.getString(11));
			 System.out.println("");
		}
	}

	public void buyReservation(String reservationNumber) throws SQLException, IOException{
		query = "Select * from totalReservation where reservation_number = ?";
		  PreparedStatement updateStatement = connection.prepareStatement(query);
		  updateStatement.setString(1, reservationNumber);

		 resultSet1 = updateStatement.executeQuery();
		  while(resultSet1.next()){
			  if(resultSet1.getString(6).equals("Y")){
				  System.out.println("This ticket has already been purchased");
				  System.out.println("");
			  }
			  else{

				 query = "Update Reservation set ticketed = 'Y' where reservation_number = ?";
				  updateStatement = connection.prepareStatement(query);
				  updateStatement.setString(1, reservationNumber);

				  resultSet2 = updateStatement.executeQuery();
				  System.out.println("Ticket Purchased ");
				  System.out.println("");
			  }
		}

	}

    // public static void main(String[] args) throws SQLException, IOException {
         // TODO code application logic here
      //   CustomerInterface app = new CustomerInterface();

     //}

}
