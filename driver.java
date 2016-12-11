import java.util.*;
import java.io.*;
import java.sql.*;

public class driver
{
    public static void main(String[] args) throws Exception
    {
        Console input = System.console();
        String answer;

        String username = input.readLine("Please enter a Username: ");
        String password = new String(input.readPassword("Please enter a password: "));
        Connection connection = null; //used to hold the jdbc connection to the DB

        Boolean begin = true;

        while(begin)
        {
            answer = input.readLine("Please choose an option: \nPress 1 for Driver \nPress 2 for Benchmark test \nPress 3 to Quit \n");
            if(answer.compareTo("1") == 0)
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
                AdministratorInterface aapp = new AdministratorInterface(connection);

                // Erase Database
                answer = input.readLine("Erase Database? Press enter: ");
                if(answer != null)
                {
                    System.out.println("Erasing Database");
                    aapp.eraseDB();
                    System.out.println("");
                }

                // Load Airline Info
                answer = input.readLine("Load Airlines? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Loading Airline Info");
                    aapp.loadAirline("loadairline.csv");
                    System.out.println("");
                    // aapp.showTable("Airline");
                }

                // Load Plane Info
                answer = input.readLine("Load Planes? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Loading Plane Info");
                    aapp.loadPlane("loadplane.csv");
                    System.out.println("");
                    // aapp.showTable("Plane");
                }

                // Load Flight Schedule Info
                answer = input.readLine("Load Flights? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Loading Flight Schedule");
                    aapp.loadSchedule("loadschedule.csv");
                    System.out.println("");
                    // aapp.showTable("Flight");
                }

                // Load Pricing Info
                answer = input.readLine("Load Prices? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Loading Price Info");
                    aapp.loadPrice("loadpricing.csv");
                    System.out.println("");
                    // aapp.showTable("Price");
                }

                // Add Customers
                answer = input.readLine("Add Customers? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Adding Customer");
                    ccpp.addCustomer("Mrs", "Reizoirmed", "Camaracer", "0000000000000000", "APR-2009", "000 United Rd", "Pittsburgh", "PA", "1234567000", "RC000@gmail.com");
                    System.out.println("");
                }

                // Show customers
                answer = input.readLine("Show Customers? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Showing Customer Info");
                    ccpp.showCustomer("Reizoirmed", "Camaracer");
                    System.out.println("");
                }

                // Find Routes
                answer = input.readLine("Find Routes from HAW to LON? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Finding Routes");
                    ccpp.findRoutes("HAW", "LON");
                    System.out.println("");
                }

                // Find Routes Given Airline
                answer = input.readLine("Find Routes from HAW to LON on Frontier Airlines? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Finding Routes given Airline");
                    ccpp.findRoutesAirlines("HAW", "LON", "Frontier Airlines");
                    System.out.println("");
                }

                // Find Routes Given Date
                answer = input.readLine("Find Routes from HAW to LON on 19-MAY-19? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Finding Routes on a given Date");
                    ccpp.findRoutesDate("HAW", "LON", "05-MAY-05 00:00:00");
                    System.out.println("");
                }

                // Find Routes give date and airline_id
                answer = input.readLine("Find Routes from HAW to LON on 05-MAY-05 for Frontier Airlines? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Finding Routes given Date and Airline");
                    ccpp.findRoutesDateAirline("HAW", "LON", "05-MAY-05 00:00:00", "Frontier Airlines");
                    System.out.println("");
                }

                // Add Reservations
                answer = input.readLine("Add Reservation for Customer added? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Adding Reservation");
                    ccpp.addReservation("11000", "000000000000000", "1", "000", "05-MAY-05 00:00:00");
                    System.out.println("");
                }

                // Find Price Between cities
                answer = input.readLine("Find price for flights between HAW to LON? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Finding Price of Reservation");
                    ccpp.findPrice("HAW", "LON");
                    System.out.println("");
                }

                //Change existing price
                answer = input.readLine("Change Price of flights between HAW and LON for Frontier Airlines? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Changing Price of Ticket");
                    aapp.changePrice("HAW", "LON", "00006", "1", "0");
                    System.out.println("");
                }

                // Buy Ticket
                answer = input.readLine("Buy Ticket? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Buying Ticket");
                    ccpp.buyReservation("11000");
                    System.out.println("");
                }

                // Show Reservation Info
                answer = input.readLine("Show reservation info for newly purchased ticket? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Showing Reservation Added");
                    ccpp.findReservation("11000");
                    System.out.println("");
                }

                //Generate Passenger Manifest for a specific flight on given date
                answer = input.readLine("Generate Manifest for flight where tick was bought? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Generating Passenger manifest for all flights on all dates");
                    aapp.generateManifest("000", "05-MAY-05 00:00:00");
                    System.out.println("");
                }
                connection.close();
            }
            else if(answer.compareTo("2") == 0)
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
                AdministratorInterface aapp = new AdministratorInterface(connection);
                // Erase Database
                answer = input.readLine("Begin? Press enter: ");
                if(answer != null)
                {
                    System.out.println("Erasing Database");
                    aapp.eraseDB();
                    System.out.println("Database Erased\n");
                }

                // Load Airline Info
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Loading Airline Info");
                    aapp.loadAirline("loadairline.csv");
                    System.out.println("Added 11 Airlines\n");
                    // aapp.showTable("Airline");
                }

                // Load Plane Info
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Loading Plane Info");
                    aapp.loadPlane("loadplane.csv");
                    System.out.println("Added 50 Planes\n");
                    // aapp.showTable("Plane");
                }

                // Load Flight Schedule Info
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Loading Flight Schedule");
                    aapp.loadSchedule("loadschedule.csv");
                    System.out.println("Added 50 Schedules\n");
                    // aapp.showTable("Flight");
                }

                // Load Pricing Info
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Loading Price Info");
                    aapp.loadPrice("loadpricing.csv");
                    System.out.println("Added 50 Prices\n");
                    // aapp.showTable("Price");
                }

                // Add Customers
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Adding Customer");
                    ccpp.addCustomer("Mr", "Morsalmarcred", "Crumeecred", "0000000000000000", "JUL-2002", "000 United Rd", "Pittsburgh", "PA", "1234567000", "MC000@gmail.com");
        			ccpp.addCustomer("Mr", "Caurakarc", "Morurakmur", "0000000000000001", "AUG-2001", "001 United Rd", "Pittsburgh", "PA", "1234567001", "CM001@gmail.com");
        			ccpp.addCustomer("Mr", "Zedcrazur", "Azaksalmared", "0000000000000002", "JUL-2018", "002 United Rd", "Pittsburgh", "PA", "1234567002", "ZA002@gmail.com");
        			ccpp.addCustomer("Mrs", "Drakmures", "Caclomur", "0000000000000003", "OCT-2016", "003 United Rd", "Pittsburgh", "PA", "1234567003", "DC003@gmail.com");
        			ccpp.addCustomer("Mrs", "Zurzercred", "Caarkcred", "0000000000000004", "DEC-2017", "004 United Rd", "Pittsburgh", "PA", "1234567004", "ZC004@gmail.com");
        			ccpp.addCustomer("Mrs", "Marirder", "Jagloricred", "0000000000000005", "AUG-2008", "005 United Rd", "Pittsburgh", "PA", "1234567005", "MJ005@gmail.com");
        			ccpp.addCustomer("Mr", "Rayirzur", "Zurairure", "0000000000000006", "OCT-2010", "006 United Rd", "Pittsburgh", "PA", "1234567006", "RZ006@gmail.com");
        			ccpp.addCustomer("Mr", "Cryarctron", "Mrokslamararc", "0000000000000007", "NOV-2010", "007 United Rd", "Pittsburgh", "PA", "1234567007", "CM007@gmail.com");
        			ccpp.addCustomer("Mr", "Marlorizur", "Drakuraker", "0000000000000008", "FEB-2014", "008 United Rd", "Pittsburgh", "PA", "1234567008", "MD008@gmail.com");
        			ccpp.addCustomer("Mrs", "Azurmaraccred", "Madcraes", "0000000000000009", "OCT-2017", "009 United Rd", "Pittsburgh", "PA", "1234567009", "AM009@gmail.com");
        			ccpp.addCustomer("Mrs", "Luklorier", "Mrokmurmed", "0000000000000010", "APR-2007", "010 United Rd", "Pittsburgh", "PA", "1234567010", "LM010@gmail.com");
        			ccpp.addCustomer("Mrs", "Madmeetron", "Jarmirimur", "0000000000000011", "JUN-2007", "011 United Rd", "Pittsburgh", "PA", "1234567011", "MJ011@gmail.com");
        			ccpp.addCustomer("Mr", "Raclomur", "Merzoirtron", "0000000000000012", "OCT-2017", "012 United Rd", "Pittsburgh", "PA", "1234567012", "RM012@gmail.com");
        			ccpp.addCustomer("Mr", "Mermurmur", "Crocloes", "0000000000000013", "JUN-2019", "013 United Rd", "Pittsburgh", "PA", "1234567013", "MC013@gmail.com");
        			ccpp.addCustomer("Mrs", "Madarcer", "Crusorark", "0000000000000014", "SEP-2002", "014 United Rd", "Pittsburgh", "PA", "1234567014", "MC014@gmail.com");
        			ccpp.addCustomer("Mrs", "Cruurakark", "Cromurure", "0000000000000015", "DEC-2012", "015 United Rd", "Pittsburgh", "PA", "1234567015", "CC015@gmail.com");
        			ccpp.addCustomer("Mr", "Zedird", "Krzercred", "0000000000000016", "APR-2000", "016 United Rd", "Pittsburgh", "PA", "1234567016", "ZK016@gmail.com");
        			ccpp.addCustomer("Mr", "Zorkmurure", "Azakredder", "0000000000000017", "MAR-2018", "017 United Rd", "Pittsburgh", "PA", "1234567017", "ZA017@gmail.com");
        			ccpp.addCustomer("Mr", "Creosalmarark", "Rasored", "0000000000000018", "AUG-2003", "018 United Rd", "Pittsburgh", "PA", "1234567018", "CR018@gmail.com");
        			ccpp.addCustomer("Mr", "Caairmur", "Drakarcmur", "0000000000000019", "OCT-2019", "019 United Rd", "Pittsburgh", "PA", "1234567019", "CD019@gmail.com");
                    System.out.println("Added 20 Customers\n");
                }

                // Show customers
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Showing Customer Info");
                    ccpp.showCustomer("Morsalmarcred", "Crumeecred");
        			ccpp.showCustomer("Caurakarc", "Morurakmur");
        			ccpp.showCustomer("Zedcrazur", "Azaksalmared");
        			ccpp.showCustomer("Drakmures", "Caclomur");
        			ccpp.showCustomer("Zurzercred", "Caarkcred");
        			ccpp.showCustomer("Marirder", "Jagloricred");
        			ccpp.showCustomer("Rayirzur", "Zurairure");
        			ccpp.showCustomer("Cryarctron", "Mrokslamararc");
        			ccpp.showCustomer("Marlorizur", "Drakuraker");
        			ccpp.showCustomer("Azurmaraccred", "Madcraes");
        			ccpp.showCustomer("Luklorier", "Mrokmurmed");
        			ccpp.showCustomer("Madmeetron", "Jarmirimur");
        			ccpp.showCustomer("Raclomur", "Merzoirtron");
        			ccpp.showCustomer("Mermurmur", "Crocloes");
        			ccpp.showCustomer("Madarcer", "Crusorark");
        			ccpp.showCustomer("Cruurakark", "Cromurure");
        			ccpp.showCustomer("Zedird", "Krzercred");
        			ccpp.showCustomer("Zorkmurure", "Azakredder");
        			ccpp.showCustomer("Creosalmarark", "Rasored");
        			ccpp.showCustomer("Caairmur", "Drakarcmur");
                    System.out.println("Shown 20 Customers\n");
                }

                // Find Routes
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Finding Routes");
                    ccpp.findRoutes("HAW", "LON");
                    ccpp.findRoutes("LAX", "PIT");
                    ccpp.findRoutes("BOS", "SEA");
                    ccpp.findRoutes("SCN", "BOS");
                    ccpp.findRoutes("LON", "SEA");
                    ccpp.findRoutes("PIT", "LON");
                    ccpp.findRoutes("LAX", "LON");
                    ccpp.findRoutes("SCN", "MIA");
                    ccpp.findRoutes("JFK", "PIT");
                    ccpp.findRoutes("JFK", "SEA");
                    ccpp.findRoutes("SEA", "PIT");
                    ccpp.findRoutes("AUS", "PHI");
                    ccpp.findRoutes("AUS", "BOS");
                    ccpp.findRoutes("SCN", "BOS");
                    ccpp.findRoutes("PIT", "LON");
                    ccpp.findRoutes("LON", "LAX");
                    ccpp.findRoutes("PAR", "HAW");
                    ccpp.findRoutes("LAX", "PIT");
                    ccpp.findRoutes("PHI", "BOS");
                    ccpp.findRoutes("LAX", "MIA");
                    System.out.println("Found results for 20 routes\n");
                }

                // Find Routes Given Airline
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Finding Routes given Airline");
                    ccpp.findRoutesAirlines("HAW", "LON", "Frontier Airlines");
                    ccpp.findRoutesAirlines("LAX", "PIT", "Delta AirLines");
                    ccpp.findRoutesAirlines("BOS", "SEA", "Alaska Airlines");
                    ccpp.findRoutesAirlines("SCN", "BOS", "All Nippon Airways");
                    ccpp.findRoutesAirlines("LON", "SEA", "Alaska Airlines");
                    ccpp.findRoutesAirlines("PIT", "LON", "JetBlue");
                    ccpp.findRoutesAirlines("LAX", "LON", "American Airlines");
                    ccpp.findRoutesAirlines("SCN", "MIA", "United Airlines");
                    ccpp.findRoutesAirlines("JFK", "PIT", "American Airlines");
                    ccpp.findRoutesAirlines("JFK", "SEA", "Delta AirLines");
                    ccpp.findRoutesAirlines("SEA", "PIT", "All Nippon Airways");
                    ccpp.findRoutesAirlines("AUS", "PHI", "Alaska Airlines");
                    ccpp.findRoutesAirlines("AUS", "BOS", "American Airlines");
                    ccpp.findRoutesAirlines("SCN", "BOS", "United Airlines");
                    ccpp.findRoutesAirlines("PIT", "LON", "Spirit Airlines");
                    ccpp.findRoutesAirlines("LON", "LAX", "Southwest Airlines");
                    ccpp.findRoutesAirlines("PAR", "HAW", "Alaska Airlines");
                    ccpp.findRoutesAirlines("LAX", "PIT", "Virgin Airlines");
                    ccpp.findRoutesAirlines("PHI", "BOS", "JetBlue");
                    ccpp.findRoutesAirlines("LAX", "MIA", "Alaska Airlines");
                    System.out.println("Found results for 20 routes");
                }

                // Find Routes Given Date
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Finding Routes on a given Date");
                    ccpp.findRoutesDate("HAW", "LON", "05-MAY-05 00:00:00");
                    ccpp.findRoutesDate("LAX", "PIT", "11-AUG-11 00:00:00");
                    ccpp.findRoutesDate("BOS", "SEA", "17-JUL-17 01:00:00");
                    ccpp.findRoutesDate("SCN", "BOS", "18-AUG-18 00:00:00");
                    ccpp.findRoutesDate("LON", "SEA", "15-MAY-15 00:00:00");
                    ccpp.findRoutesDate("PIT", "LON", "19-AUG-19 00:00:00");
                    ccpp.findRoutesDate("LAX", "LON", "02-AUG-02 00:00:00");
                    ccpp.findRoutesDate("SCN", "MIA", "07-NOV-07 01:00:00");
                    ccpp.findRoutesDate("JFK", "PIT", "17-APR-17 03:00:00");
                    ccpp.findRoutesDate("JFK", "SEA", "14-OCT-14 01:00:00");
                    ccpp.findRoutesDate("SEA", "PIT", "14-NOV-14 03:00:00");
                    ccpp.findRoutesDate("AUS", "PHI", "02-AUG-02 01:00:00");
                    ccpp.findRoutesDate("AUS", "BOS", "05-AUG-05 01:00:00");
                    ccpp.findRoutesDate("SCN", "BOS", "14-JUN-14 03:00:00");
                    ccpp.findRoutesDate("PIT", "LON", "10-AUG-10 01:00:00");
                    ccpp.findRoutesDate("LON", "LAX", "10-OCT-10 00:00:00");
                    ccpp.findRoutesDate("PAR", "HAW", "16-JAN-16 01:00:00");
                    ccpp.findRoutesDate("LAX", "PIT", "17-FEB-17 00:00:00");
                    ccpp.findRoutesDate("PHI", "BOS", "06-MAY-06 00:00:00");
                    ccpp.findRoutesDate("LAX", "MIA", "19-APR-19 02:00:00");
                    System.out.println("Found results for 20 routes");
                }

                // Find Routes give date and airline_id
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Finding Routes given Date and Airline");
                    ccpp.findRoutesDateAirline("HAW", "LON", "05-MAY-05 00:00:00", "Frontier Airlines");
                    ccpp.findRoutesDateAirline("LAX", "PIT", "11-AUG-11 00:00:00", "Delta AirLines");
                    ccpp.findRoutesDateAirline("BOS", "SEA", "17-JUL-17 01:00:00", "Alaska Airlines");
                    ccpp.findRoutesDateAirline("SCN", "BOS", "18-AUG-18 00:00:00", "All Nippon Airways");
                    ccpp.findRoutesDateAirline("LON", "SEA", "15-MAY-15 00:00:00", "Alaska Airlines");
                    ccpp.findRoutesDateAirline("PIT", "LON", "19-AUG-19 00:00:00", "JetBlue");
                    ccpp.findRoutesDateAirline("LAX", "LON", "02-AUG-02 00:00:00", "American Airlines");
                    ccpp.findRoutesDateAirline("SCN", "MIA", "07-NOV-07 01:00:00", "United Airlines");
                    ccpp.findRoutesDateAirline("JFK", "PIT", "17-APR-17 03:00:00", "American Airlines");
                    ccpp.findRoutesDateAirline("JFK", "SEA", "14-OCT-14 01:00:00", "Delta AirLines");
                    ccpp.findRoutesDateAirline("SEA", "PIT", "14-NOV-14 03:00:00", "All Nippon Airways");
                    ccpp.findRoutesDateAirline("AUS", "PHI", "02-AUG-02 01:00:00", "Alaska Airlines");
                    ccpp.findRoutesDateAirline("AUS", "BOS", "05-AUG-05 01:00:00", "American Airlines");
                    ccpp.findRoutesDateAirline("SCN", "BOS", "14-JUN-14 03:00:00", "United Airlines");
                    ccpp.findRoutesDateAirline("PIT", "LON", "10-AUG-10 01:00:00", "Spirit Airlines");
                    ccpp.findRoutesDateAirline("LON", "LAX", "10-OCT-10 00:00:00", "Southwest Airlines");
                    ccpp.findRoutesDateAirline("PAR", "HAW", "16-JAN-16 01:00:00", "Alaska Airlines");
                    ccpp.findRoutesDateAirline("LAX", "PIT", "17-FEB-17 00:00:00", "Virgin Airlines");
                    ccpp.findRoutesDateAirline("PHI", "BOS", "06-MAY-06 00:00:00", "JetBlue");
                    ccpp.findRoutesDateAirline("LAX", "MIA", "19-APR-19 02:00:00", "Alaska Airlines");
                    System.out.println("Found results for 20 routes");
                }

                // Add Reservations
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Adding Reservation");
                    ccpp.addReservation("11000", "000000000000000", "1", "000", "05-MAY-05 00:00:00");
                    ccpp.addReservation("11001", "000000000000001", "1", "001", "11-AUG-11 00:00:00");
                    ccpp.addReservation("11002", "000000000000002", "1", "002", "17-JUL-17 01:00:00");
                    ccpp.addReservation("11003", "000000000000003", "1", "003", "18-AUG-18 00:00:00");
                    ccpp.addReservation("11004", "000000000000004", "1", "004", "15-MAY-15 00:00:00");
                    System.out.println("Added 5 reservations");
                }

                // Find Price Between cities
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Finding Price of Route");
                    ccpp.findPrice("HAW", "LON");
                    ccpp.findPrice("LAX", "PIT");
                    ccpp.findPrice("BOS", "SEA");
                    ccpp.findPrice("SCN", "BOS");
                    ccpp.findPrice("LON", "SEA");
                    ccpp.findPrice("PIT", "LON");
                    ccpp.findPrice("LAX", "LON");
                    ccpp.findPrice("SCN", "MIA");
                    ccpp.findPrice("JFK", "PIT");
                    ccpp.findPrice("JFK", "SEA");
                    ccpp.findPrice("SEA", "PIT");
                    ccpp.findPrice("AUS", "PHI");
                    ccpp.findPrice("AUS", "BOS");
                    ccpp.findPrice("SCN", "BOS");
                    ccpp.findPrice("PIT", "LON");
                    ccpp.findPrice("LON", "LAX");
                    ccpp.findPrice("PAR", "HAW");
                    ccpp.findPrice("LAX", "PIT");
                    ccpp.findPrice("PHI", "BOS");
                    ccpp.findPrice("LAX", "MIA");
                    System.out.println("Found price of 20 routes");
                }

                //Change existing price
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Changing Price of Flights");
                    aapp.changePrice("HAW", "LON", "00006", "1", "0");
                    aapp.changePrice("LAX", "PIT", "00003", "1", "0");
                    aapp.changePrice("BOS", "SEA", "00000", "1", "0");
                    aapp.changePrice("SCN", "BOS", "00002", "1", "0");
                    aapp.changePrice("LON", "SEA", "00000", "1", "0");
                    aapp.changePrice("PIT", "LON", "00004", "1", "0");
                    aapp.changePrice("LAX", "LON", "00005", "1", "0");
                    aapp.changePrice("SCN", "MIA", "00001", "1", "0");
                    aapp.changePrice("JFK", "PIT", "00005", "1", "0");
                    aapp.changePrice("JFK", "SEA", "00003", "1", "0");
                    aapp.changePrice("SEA", "PIT", "00002", "1", "0");
                    System.out.println("Changed Price of 10 Flights");
                }

                // Buy Ticket
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Buying Ticket");
                    ccpp.buyReservation("11000");
                    ccpp.buyReservation("11001");
                    ccpp.buyReservation("11002");
                    ccpp.buyReservation("11003");
                    System.out.println("Bought 4 tickets");
                }

                // Show Reservation Info
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Showing Reservation Added");
                    ccpp.findReservation("11000");
                    ccpp.findReservation("11001");
                    ccpp.findReservation("11002");
                    ccpp.findReservation("11003");
                    ccpp.findReservation("11004");
                    System.out.println("Shown 5 Reservations");
                }

                //Generate Passenger Manifest for a specific flight on given date
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Generating Passenger manifest for all flights on all dates");
                    aapp.generateManifest("000", "05-MAY-05 00:00:00");
                    aapp.generateManifest("001", "11-AUG-11 00:00:00");
                    aapp.generateManifest("002", "17-JUL-17 01:00:00");
                    aapp.generateManifest("003", "18-AUG-18 00:00:00");
                    aapp.generateManifest("004", "15-MAY-15 00:00:00");
                    aapp.generateManifest("005", "19-AUG-19 00:00:00");
                    aapp.generateManifest("006", "02-AUG-02 00:00:00");
                    aapp.generateManifest("007", "07-NOV-07 01:00:00");
                    aapp.generateManifest("008", "17-APR-17 03:00:00");
                    aapp.generateManifest("009", "14-OCT-14 01:00:00");
                    aapp.generateManifest("010", "14-NOV-14 03:00:00");
                    aapp.generateManifest("011", "02-AUG-02 01:00:00");
                    aapp.generateManifest("012", "05-AUG-05 01:00:00");
                    aapp.generateManifest("013", "14-JUN-14 03:00:00");
                    aapp.generateManifest("014", "10-AUG-10 01:00:00");
                    aapp.generateManifest("015", "10-OCT-10 00:00:00");
                    aapp.generateManifest("016", "16-JAN-16 01:00:00");
                    aapp.generateManifest("017", "17-FEB-17 00:00:00");
                    aapp.generateManifest("018", "06-MAY-06 00:00:00");
                    aapp.generateManifest("019", "19-APR-19 02:00:00");
                    aapp.generateManifest("020", "09-JUL-09 03:00:00");
                    aapp.generateManifest("021", "20-JUN-20 00:00:00");
                    aapp.generateManifest("022", "15-JAN-15 01:00:00");
                    aapp.generateManifest("023", "20-AUG-20 03:00:00");
                    aapp.generateManifest("024", "19-APR-19 02:00:00");
                    aapp.generateManifest("025", "02-AUG-02 03:00:00");
                    aapp.generateManifest("026", "13-OCT-13 02:00:00");
                    aapp.generateManifest("027", "16-AUG-16 00:00:00");
                    aapp.generateManifest("028", "01-SEP-01 01:00:00");
                    aapp.generateManifest("029", "08-OCT-08 02:00:00");
                    aapp.generateManifest("030", "17-JUL-17 01:00:00");
                    aapp.generateManifest("031", "17-MAR-17 00:00:00");
                    aapp.generateManifest("032", "11-AUG-11 02:00:00");
                    aapp.generateManifest("033", "15-NOV-15 01:00:00");
                    aapp.generateManifest("034", "06-OCT-06 00:00:00");
                    aapp.generateManifest("035", "03-AUG-03 02:00:00");
                    aapp.generateManifest("036", "18-JAN-18 03:00:00");
                    aapp.generateManifest("037", "02-MAR-02 03:00:00");
                    aapp.generateManifest("038", "01-MAR-01 02:00:00");
                    aapp.generateManifest("039", "07-AUG-07 01:00:00");
                    System.out.println("Generated Manifest for 40 Flights");
                }
            }
            else if(answer.compareTo("3") == 0)
            {
                System.out.println("Quitting");
                begin = false;
            }
            else
            {
                System.out.println("Please choose a valid option");
            }
            connection.close();
        }
    }
}
