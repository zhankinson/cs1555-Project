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

        Boolean begin = true;

        while(begin)
        {
            answer = input.readLine("Please choose an option: \nPress 1 for Driver \nPress 2 for Benchmark test \nPress 3 to Quit \n");
            if(answer.compareTo("1") == 0)
            {
                // Erase Database
                answer = input.readLine("Erase Database? Press enter: ");
                if(answer != null)
                {
                    System.out.println("Erasing Database");
                    aapp.eraseDB();
                }

                // Load Airline Info
                answer = input.readLine("Load Airlines? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Loading Airline Info");
                    aapp.loadAirline("loadairline.csv");
                    // aapp.showTable("Airline");
                }

                // Load Plane Info
                answer = input.readLine("Load Planes? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Loading Plane Info");
                    aapp.loadPlane("loadplane.csv");
                    // aapp.showTable("Plane");
                }

                // Load Flight Schedule Info
                answer = input.readLine("Load Flights? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Loading Flight Schedule");
                    aapp.loadSchedule("loadschedule.csv");
                    // aapp.showTable("Flight");
                }

                // Load Pricing Info
                answer = input.readLine("Load Prices? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Loading Price Info");
                    aapp.loadPrice("loadpricing.csv");
                    // aapp.showTable("Price");
                }

                // Add Customers
                answer = input.readLine("Add Customers? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Adding Customer");
                    ccpp.addCustomer("Mrs", "Reizoirmed", "Camaracer", "0000000000000000", "APR-2009", "000 United Rd", "Pittsburgh", "PA", "1234567000", "RC000@gmail.com");
                }

                // Show customers
                answer = input.readLine("Show Customers? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Showing Customer Info");
                    ccpp.showCustomer("Reizoirmed", "Camaracer");
                }

                // Find Routes
                answer = input.readLine("Find Routes from JFK to SEA? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Finding Routes");
                    ccpp.findRoutes("JFK", "SEA");
                }

                // Find Routes Given Airline
                answer = input.readLine("Find Routes from JFK to SEA on United Airlines? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Finding Routes given Airline");
                    ccpp.findRoutesAirlines("JFK", "SEA", "United Airlines");
                }

                // Find Routes Given Date
                answer = input.readLine("Find Routes from JFK to SEA on 19-MAY-19? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Finding Routes on a given Date");
                    ccpp.findRoutesDate("JFK", "SEA", "19-MAY-19 02:00:00");
                }

                // Find Routes give date and airline_id
                answer = input.readLine("Find Routes from JFK to SEA on 19-MAY-19 for United Airlines? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Finding Routes given Date and Airline");
                    ccpp.findRoutesDateAirline("JFK", "SEA", "United Airlines", "19-MAY-19 02:00:00");
                }

                // Add Reservations
                answer = input.readLine("Add Reservation for Customer added? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Adding Reservation");
                    ccpp.addReservation("11000", "0000000000000000", "1", "000", "19-MAY-19 02:00:00");
                    System.out.println("");
                }

                // Find Price Between cities
                answer = input.readLine("Find price for flights between JFK to SEA? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Finding Price of Reservation");
                    ccpp.findPrice("JFK", "SEA");
                }

                //Change existing price
                answer = input.readLine("Change Price of flights between JFK and SEA for United Airlines? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Changing Price of Ticket");
                    aapp.changePrice("JFK", "SEA", "00001", "2000", "1700");
                    System.out.println("");
                }

                // Buy Ticket
                answer = input.readLine("Buy Ticket? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Buying Ticket");
                    ccpp.buyReservation("11000");
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
                    aapp.generateManifest("000", "19-MAY-19 02:00:00");
                }
            }
            else if(answer.compareTo("2") == 0)
            {
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
                    System.out.println("Added 100 Schedules\n");
                    // aapp.showTable("Flight");
                }

                // Load Pricing Info
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Loading Price Info");
                    aapp.loadPrice("loadpricing.csv");
                    System.out.println("Added 100 Prices\n");
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
        			ccpp.addCustomer("Mr", "Reicracred", "Cryarcer", "0000000000000020", "OCT-2007", "020 United Rd", "Pittsburgh", "PA", "1234567020", "RC020@gmail.com");
        			ccpp.addCustomer("Mrs", "Mrokurakmur", "Morlorider", "0000000000000021", "APR-2013", "021 United Rd", "Pittsburgh", "PA", "1234567021", "MM021@gmail.com");
        			ccpp.addCustomer("Mr", "Morclotron", "Mermid", "0000000000000022", "AUG-2008", "022 United Rd", "Pittsburgh", "PA", "1234567022", "MM022@gmail.com");
        			ccpp.addCustomer("Mr", "Creocloed", "Cruirzur", "0000000000000023", "AUG-2017", "023 United Rd", "Pittsburgh", "PA", "1234567023", "CC023@gmail.com");
        			ccpp.addCustomer("Mrs", "Crycratron", "Madcresmed", "0000000000000024", "JUN-2017", "024 United Rd", "Pittsburgh", "PA", "1234567024", "CM024@gmail.com");
        			ccpp.addCustomer("Mrs", "Jararked", "Zorkzoirarc", "0000000000000025", "JUN-2003", "025 United Rd", "Pittsburgh", "PA", "1234567025", "JZ025@gmail.com");
        			ccpp.addCustomer("Mrs", "Mersalmarzur", "Jagmaracark", "0000000000000026", "AUG-2007", "026 United Rd", "Pittsburgh", "PA", "1234567026", "MJ026@gmail.com");
        			ccpp.addCustomer("Mr", "Cryarccred", "Creozoirtron", "0000000000000027", "JUN-2009", "027 United Rd", "Pittsburgh", "PA", "1234567027", "CC027@gmail.com");
        			ccpp.addCustomer("Mrs", "Racloer", "Rayirmur", "0000000000000028", "JUN-2014", "028 United Rd", "Pittsburgh", "PA", "1234567028", "RR028@gmail.com");
        			ccpp.addCustomer("Mrs", "Cromirimur", "Zorkarkder", "0000000000000029", "DEC-2012", "029 United Rd", "Pittsburgh", "PA", "1234567029", "CZ029@gmail.com");
        			ccpp.addCustomer("Mrs", "Marired", "Zurmaraccred", "0000000000000030", "JUN-2018", "030 United Rd", "Pittsburgh", "PA", "1234567030", "MZ030@gmail.com");
        			ccpp.addCustomer("Mrs", "Crourakmur", "Cacresder", "0000000000000031", "DEC-2006", "031 United Rd", "Pittsburgh", "PA", "1234567031", "CC031@gmail.com");
        			ccpp.addCustomer("Mrs", "Jarmeemur", "Azakaircred", "0000000000000032", "AUG-2004", "032 United Rd", "Pittsburgh", "PA", "1234567032", "JA032@gmail.com");
        			ccpp.addCustomer("Mr", "Marirzur", "Jarmied", "0000000000000033", "APR-2007", "033 United Rd", "Pittsburgh", "PA", "1234567033", "MJ033@gmail.com");
        			ccpp.addCustomer("Mr", "Merzoirtron", "Mjolreded", "0000000000000034", "AUG-2014", "034 United Rd", "Pittsburgh", "PA", "1234567034", "MM034@gmail.com");
        			ccpp.addCustomer("Mrs", "Mrokirzur", "Cruairder", "0000000000000035", "MAR-2013", "035 United Rd", "Pittsburgh", "PA", "1234567035", "MC035@gmail.com");
        			ccpp.addCustomer("Mr", "Cruirarc", "Reicresder", "0000000000000036", "SEP-2017", "036 United Rd", "Pittsburgh", "PA", "1234567036", "CR036@gmail.com");
        			ccpp.addCustomer("Mrs", "Zedmurmur", "Cromeemed", "0000000000000037", "MAR-2017", "037 United Rd", "Pittsburgh", "PA", "1234567037", "ZC037@gmail.com");
        			ccpp.addCustomer("Mr", "Zedsorzur", "Cryurakmur", "0000000000000038", "FEB-2017", "038 United Rd", "Pittsburgh", "PA", "1234567038", "ZC038@gmail.com");
        			ccpp.addCustomer("Mrs", "Raycloed", "Crycrazur", "0000000000000039", "FEB-2006", "039 United Rd", "Pittsburgh", "PA", "1234567039", "RC039@gmail.com");
        			ccpp.addCustomer("Mr", "Morsord", "Zedslamared", "0000000000000040", "NOV-2016", "040 United Rd", "Pittsburgh", "PA", "1234567040", "MZ040@gmail.com");
        			ccpp.addCustomer("Mr", "Krmiricred", "Azakloriark", "0000000000000041", "DEC-2013", "041 United Rd", "Pittsburgh", "PA", "1234567041", "KA041@gmail.com");
        			ccpp.addCustomer("Mrs", "Azaksalmarark", "Zorkcresarc", "0000000000000042", "JUN-2007", "042 United Rd", "Pittsburgh", "PA", "1234567042", "AZ042@gmail.com");
        			ccpp.addCustomer("Mr", "Marmeeer", "Luksores", "0000000000000043", "JUN-2010", "043 United Rd", "Pittsburgh", "PA", "1234567043", "ML043@gmail.com");
        			ccpp.addCustomer("Mr", "Krsalmarark", "Mjolarctron", "0000000000000044", "SEP-2009", "044 United Rd", "Pittsburgh", "PA", "1234567044", "KM044@gmail.com");
        			ccpp.addCustomer("Mrs", "Madslamarure", "Zorkmeetron", "0000000000000045", "MAY-2001", "045 United Rd", "Pittsburgh", "PA", "1234567045", "MZ045@gmail.com");
        			ccpp.addCustomer("Mrs", "Reiarkes", "Zedzoirzur", "0000000000000046", "MAR-2017", "046 United Rd", "Pittsburgh", "PA", "1234567046", "RZ046@gmail.com");
        			ccpp.addCustomer("Mrs", "Rayredcred", "Mercraarc", "0000000000000047", "SEP-2018", "047 United Rd", "Pittsburgh", "PA", "1234567047", "RM047@gmail.com");
        			ccpp.addCustomer("Mr", "Lukcloes", "Merarces", "0000000000000048", "JUL-2010", "048 United Rd", "Pittsburgh", "PA", "1234567048", "LM048@gmail.com");
        			ccpp.addCustomer("Mr", "Raylorizur", "Morsorarc", "0000000000000049", "DEC-2015", "049 United Rd", "Pittsburgh", "PA", "1234567049", "RM049@gmail.com");
                    System.out.println("Added 50 Customers\n");
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
        			ccpp.showCustomer("Reicracred", "Cryarcer");
        			ccpp.showCustomer("Mrokurakmur", "Morlorider");
        			ccpp.showCustomer("Morclotron", "Mermid");
        			ccpp.showCustomer("Creocloed", "Cruirzur");
        			ccpp.showCustomer("Crycratron", "Madcresmed");
        			ccpp.showCustomer("Jararked", "Zorkzoirarc");
        			ccpp.showCustomer("Mersalmarzur", "Jagmaracark");
        			ccpp.showCustomer("Cryarccred", "Creozoirtron");
        			ccpp.showCustomer("Racloer", "Rayirmur");
        			ccpp.showCustomer("Cromirimur", "Zorkarkder");
        			ccpp.showCustomer("Marired", "Zurmaraccred");
        			ccpp.showCustomer("Crourakmur", "Cacresder");
        			ccpp.showCustomer("Jarmeemur", "Azakaircred");
        			ccpp.showCustomer("Marirzur", "Jarmied");
        			ccpp.showCustomer("Merzoirtron", "Mjolreded");
        			ccpp.showCustomer("Mrokirzur", "Cruairder");
        			ccpp.showCustomer("Cruirarc", "Reicresder");
        			ccpp.showCustomer("Zedmurmur", "Cromeemed");
        			ccpp.showCustomer("Zedsorzur", "Cryurakmur");
        			ccpp.showCustomer("Raycloed", "Crycrazur");
        			ccpp.showCustomer("Morsord", "Zedslamared");
        			ccpp.showCustomer("Krmiricred", "Azakloriark");
        			ccpp.showCustomer("Azaksalmarark", "Zorkcresarc");
        			ccpp.showCustomer("Marmeeer", "Luksores");
        			ccpp.showCustomer("Krsalmarark", "Mjolarctron");
        			ccpp.showCustomer("Madslamarure", "Zorkmeetron");
        			ccpp.showCustomer("Reiarkes", "Zedzoirzur");
        			ccpp.showCustomer("Rayredcred", "Mercraarc");
        			ccpp.showCustomer("Lukcloes", "Merarces");
        			ccpp.showCustomer("Raylorizur", "Morsorarc");
                    System.out.println("Shown 50 Customers\n");
                }

                // Find Routes
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Finding Routes");
                    ccpp.findRoutes("MIA", "JFK");
                    ccpp.findRoutes("PHI", "HAW");
                    ccpp.findRoutes("JFK", "LON");
                    ccpp.findRoutes("JFK", "HAW");
                    ccpp.findRoutes("PHI", "SEA");
                    ccpp.findRoutes("PIT", "AUS");
                    ccpp.findRoutes("BOS", "JFK");
                    ccpp.findRoutes("PAR", "SEA");
                    ccpp.findRoutes("PIT", "BOS");
                    ccpp.findRoutes("LON", "PAR");
                    ccpp.findRoutes("PAR", "HAW");
                    ccpp.findRoutes("SCN", "JFK");
                    ccpp.findRoutes("LAX", "AUS");
                    ccpp.findRoutes("BOS", "LON");
                    ccpp.findRoutes("BOS", "LON");
                    ccpp.findRoutes("LON", "JFK");
                    ccpp.findRoutes("PAR", "JFK");
                    ccpp.findRoutes("LAX", "AUS");
                    ccpp.findRoutes("PIT", "HAW");
                    ccpp.findRoutes("SEA", "MIA");
                    System.out.println("Found results for 20 routes\n");
                }

                // Find Routes Given Airline
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Finding Routes given Airline");
                    ccpp.findRoutesAirlines("MIA", "LON",  "Kang Hankinson Airlines");
                    ccpp.findRoutesAirlines("BOS", "MIA",  "Delta Air Lines");
                    ccpp.findRoutesAirlines("LON", "PHI",  "United Airlines");
                    ccpp.findRoutesAirlines("PAR", "SEA",  "Kang Hankinson Airlines");
                    ccpp.findRoutesAirlines("BOS", "LAX",  "Kang Hankinson Airlines");
                    ccpp.findRoutesAirlines("SCN", "LON",  "Kang Hankinson Airlines");
                    ccpp.findRoutesAirlines("LAX", "AUS",  "Kang Hankinson Airlines");
                    ccpp.findRoutesAirlines("HAW", "MIA",  "All Nippon Airways");
                    ccpp.findRoutesAirlines("LON", "SEA",  "United Airlines");
                    ccpp.findRoutesAirlines("AUS", "LAX",  "Delta Air Lines");
                    ccpp.findRoutesAirlines("SCN", "SEA",  "Kang Hankinson Airlines");
                    ccpp.findRoutesAirlines("SEA", "AUS",  "All Nippon Airways");
                    ccpp.findRoutesAirlines("BOS", "PHI",  "United Airlines");
                    ccpp.findRoutesAirlines("LON", "JFK",  "Delta Air Lines");
                    ccpp.findRoutesAirlines("SEA", "BOS",  "Kang Hankinson Airlines");
                    ccpp.findRoutesAirlines("HAW", "MIA",  "Delta Air Lines");
                    ccpp.findRoutesAirlines("PIT", "BOS",  "Kang Hankinson Airlines");
                    ccpp.findRoutesAirlines("LON", "HAW",  "All Nippon Airways");
                    ccpp.findRoutesAirlines("BOS", "LAX",  "United Airlines");
                    ccpp.findRoutesAirlines("PIT", "PAR",  "United Airlines");
                    System.out.println("Found results for 20 routes");
                }

                // Find Routes Given Date
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Finding Routes on a given Date");
                    ccpp.findRoutesDate("MIA", "LON", "T");
                    ccpp.findRoutesDate("BOS", "MIA", "M");
                    ccpp.findRoutesDate("LON", "PHI", "W");
                    ccpp.findRoutesDate("PAR", "SEA", "T");
                    ccpp.findRoutesDate("BOS", "LAX", "T");
                    ccpp.findRoutesDate("SCN", "LON", "T");
                    ccpp.findRoutesDate("LAX", "AUS", "T");
                    ccpp.findRoutesDate("HAW", "MIA", "T");
                    ccpp.findRoutesDate("LON", "SEA", "W");
                    ccpp.findRoutesDate("AUS", "LAX", "M");
                    ccpp.findRoutesDate("SCN", "SEA", "T");
                    ccpp.findRoutesDate("SEA", "AUS", "T");
                    ccpp.findRoutesDate("BOS", "PHI", "W");
                    ccpp.findRoutesDate("LON", "JFK", "M");
                    ccpp.findRoutesDate("SEA", "BOS", "T");
                    ccpp.findRoutesDate("HAW", "MIA", "M");
                    ccpp.findRoutesDate("PIT", "BOS", "T");
                    ccpp.findRoutesDate("LON", "HAW", "T");
                    ccpp.findRoutesDate("BOS", "LAX", "W");
                    ccpp.findRoutesDate("PIT", "PAR", "W");
                    System.out.println("Found results for 20 routes");
                }

                // Find Routes give date and airline_id
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Finding Routes given Date and Airline");
                    ccpp.findRoutesDateAirline("MIA", "LON",  "Kang Hankinson Airlines", "T");
                    ccpp.findRoutesDateAirline("BOS", "MIA",  "Delta Air Lines", "M");
                    ccpp.findRoutesDateAirline("LON", "PHI",  "United Airlines", "W");
                    ccpp.findRoutesDateAirline("PAR", "SEA",  "Kang Hankinson Airlines", "T");
                    ccpp.findRoutesDateAirline("BOS", "LAX",  "Kang Hankinson Airlines", "T");
                    ccpp.findRoutesDateAirline("SCN", "LON",  "Kang Hankinson Airlines", "T");
                    ccpp.findRoutesDateAirline("LAX", "AUS",  "Kang Hankinson Airlines", "T");
                    ccpp.findRoutesDateAirline("HAW", "MIA",  "All Nippon Airways", "T");
                    ccpp.findRoutesDateAirline("LON", "SEA",  "United Airlines", "W");
                    ccpp.findRoutesDateAirline("AUS", "LAX",  "Delta Air Lines", "M");
                    ccpp.findRoutesDateAirline("SCN", "SEA",  "Kang Hankinson Airlines", "T");
                    ccpp.findRoutesDateAirline("SEA", "AUS",  "All Nippon Airways", "T");
                    ccpp.findRoutesDateAirline("BOS", "PHI",  "United Airlines", "W");
                    ccpp.findRoutesDateAirline("LON", "JFK",  "Delta Air Lines", "M");
                    ccpp.findRoutesDateAirline("SEA", "BOS",  "Kang Hankinson Airlines", "T");
                    ccpp.findRoutesDateAirline("HAW", "MIA",  "Delta Air Lines", "M");
                    ccpp.findRoutesDateAirline("PIT", "BOS",  "Kang Hankinson Airlines", "T");
                    ccpp.findRoutesDateAirline("LON", "HAW",  "All Nippon Airways", "T");
                    ccpp.findRoutesDateAirline("BOS", "LAX",  "United Airlines", "W");
                    ccpp.findRoutesDateAirline("PIT", "PAR",  "United Airlines", "W");
                    System.out.println("Found results for 20 routes");
                }

                // Add Reservations
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Adding Reservation");
                    ccpp.addReservation("11000", "000000000000000", "1", "000", "14-NOV-14 03:00:00");
                    ccpp.addReservation("11002", "000000000000001", "1", "002", "13-NOV-13 02:00:00");
                    ccpp.addReservation("11004", "000000000000002", "1", "004", "14-OCT-14 02:00:00");
                    ccpp.addReservation("11006", "000000000000003", "1", "006", "11-JUN-11 01:00:00");
                    ccpp.addReservation("11008", "000000000000004", "1", "008", "19-OCT-19 00:00:00");
                    ccpp.addReservation("11010", "000000000000005", "1", "010", "05-JUL-05 01:00:00");
                    ccpp.addReservation("11012", "000000000000006", "1", "012", "16-DEC-16 00:00:00");
                    ccpp.addReservation("11014", "000000000000007", "1", "014", "04-APR-04 00:00:00");
                    ccpp.addReservation("11016", "000000000000008", "1", "016", "14-JAN-14 01:00:00");
                    ccpp.addReservation("11018", "000000000000009", "1", "018", "03-JAN-03 01:00:00");
                    ccpp.addReservation("11020", "000000000000010", "1", "020", "18-JAN-18 03:00:00");
                    ccpp.addReservation("11022", "000000000000011", "1", "022", "13-MAR-13 01:00:00");
                    ccpp.addReservation("11024", "000000000000012", "1", "024", "06-SEP-06 03:00:00");
                    ccpp.addReservation("11026", "000000000000013", "1", "026", "04-JUL-04 01:00:00");
                    ccpp.addReservation("11028", "000000000000014", "1", "028", "13-NOV-13 01:00:00");
                    ccpp.addReservation("11030", "000000000000015", "1", "030", "16-MAR-16 00:00:00");
                    ccpp.addReservation("11032", "000000000000016", "1", "032", "09-JAN-09 03:00:00");
                    ccpp.addReservation("11034", "000000000000017", "1", "034", "09-JUN-09 01:00:00");
                    ccpp.addReservation("11036", "000000000000018", "1", "036", "15-JUN-15 00:00:00");
                    ccpp.addReservation("11038", "000000000000019", "1", "038", "07-DEC-07 01:00:00");
                    ccpp.addReservation("11040", "000000000000020", "1", "040", "02-DEC-02 03:00:00");
                    ccpp.addReservation("11042", "000000000000021", "1", "042", "04-AUG-04 01:00:00");
                    ccpp.addReservation("11044", "000000000000022", "1", "044", "19-JUN-19 00:00:00");
                    ccpp.addReservation("11046", "000000000000023", "1", "046", "13-JAN-13 02:00:00");
                    ccpp.addReservation("11048", "000000000000024", "1", "048", "05-AUG-05 02:00:00");
                    ccpp.addReservation("11050", "000000000000025", "1", "050", "05-FEB-05 00:00:00");
                    ccpp.addReservation("11052", "000000000000026", "1", "052", "09-JUN-09 02:00:00");
                    ccpp.addReservation("11054", "000000000000027", "1", "054", "10-MAR-10 00:00:00");
                    ccpp.addReservation("11056", "000000000000028", "1", "056", "14-JUN-14 01:00:00");
                    ccpp.addReservation("11058", "000000000000029", "1", "058", "14-SEP-14 03:00:00");
                    ccpp.addReservation("11060", "000000000000030", "1", "060", "06-JAN-06 02:00:00");
                    ccpp.addReservation("11062", "000000000000031", "1", "062", "06-JUN-06 02:00:00");
                    ccpp.addReservation("11064", "000000000000032", "1", "064", "11-JUL-11 00:00:00");
                    ccpp.addReservation("11066", "000000000000033", "1", "066", "06-MAR-06 00:00:00");
                    ccpp.addReservation("11068", "000000000000034", "1", "068", "17-AUG-17 02:00:00");
                    ccpp.addReservation("11070", "000000000000035", "1", "070", "07-OCT-07 02:00:00");
                    ccpp.addReservation("11072", "000000000000036", "1", "072", "06-JAN-06 03:00:00");
                    ccpp.addReservation("11074", "000000000000037", "1", "074", "15-FEB-15 03:00:00");
                    ccpp.addReservation("11076", "000000000000038", "1", "076", "07-MAR-07 00:00:00");
                    ccpp.addReservation("11078", "000000000000039", "1", "078", "04-SEP-04 03:00:00");
                    ccpp.addReservation("11080", "000000000000040", "1", "080", "13-FEB-13 01:00:00");
                    ccpp.addReservation("11082", "000000000000041", "1", "082", "20-JAN-20 03:00:00");
                    ccpp.addReservation("11084", "000000000000042", "1", "084", "10-NOV-10 01:00:00");
                    ccpp.addReservation("11086", "000000000000043", "1", "086", "17-JAN-17 01:00:00");
                    ccpp.addReservation("11088", "000000000000044", "1", "088", "07-JUN-07 00:00:00");
                    ccpp.addReservation("11090", "000000000000045", "1", "090", "16-DEC-16 00:00:00");
                    ccpp.addReservation("11092", "000000000000046", "1", "092", "13-AUG-13 02:00:00");
                    ccpp.addReservation("11094", "000000000000047", "1", "094", "19-MAY-19 03:00:00");
                    ccpp.addReservation("11096", "000000000000048", "1", "096", "08-OCT-08 02:00:00");
                    ccpp.addReservation("11098", "000000000000049", "1", "098", "20-SEP-20 02:00:00");
                    System.out.println("Added 50 reservations");
                }

                // Find Price Between cities
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Finding Price of Route");
                    ccpp.findPrice("MIA", "JFK");
                    ccpp.findPrice("PHI", "HAW");
                    ccpp.findPrice("JFK", "LON");
                    ccpp.findPrice("JFK", "HAW");
                    ccpp.findPrice("PHI", "SEA");
                    ccpp.findPrice("PIT", "AUS");
                    ccpp.findPrice("BOS", "JFK");
                    ccpp.findPrice("PAR", "SEA");
                    ccpp.findPrice("PIT", "BOS");
                    ccpp.findPrice("LON", "PAR");
                    ccpp.findPrice("PAR", "HAW");
                    ccpp.findPrice("SCN", "JFK");
                    ccpp.findPrice("LAX", "AUS");
                    ccpp.findPrice("BOS", "LON");
                    ccpp.findPrice("BOS", "LON");
                    ccpp.findPrice("LON", "JFK");
                    ccpp.findPrice("PAR", "JFK");
                    ccpp.findPrice("LAX", "AUS");
                    ccpp.findPrice("PIT", "HAW");
                    ccpp.findPrice("SEA", "MIA");
                    ccpp.findPrice("BOS", "JFK");
                    ccpp.findPrice("HAW", "JFK");
                    ccpp.findPrice("SEA", "LAX");
                    ccpp.findPrice("MIA", "SEA");
                    ccpp.findPrice("LON", "PHI");
                    ccpp.findPrice("PAR", "LAX");
                    ccpp.findPrice("PHI", "AUS");
                    ccpp.findPrice("LON", "SEA");
                    ccpp.findPrice("PHI", "SEA");
                    ccpp.findPrice("SEA", "PIT");
                    ccpp.findPrice("LAX", "LON");
                    ccpp.findPrice("PHI", "LON");
                    ccpp.findPrice("HAW", "BOS");
                    ccpp.findPrice("PAR", "BOS");
                    ccpp.findPrice("JFK", "HAW");
                    ccpp.findPrice("BOS", "LAX");
                    ccpp.findPrice("MIA", "AUS");
                    ccpp.findPrice("PIT", "PHI");
                    ccpp.findPrice("PHI", "PAR");
                    ccpp.findPrice("MIA", "PAR");
                    ccpp.findPrice("LAX", "AUS");
                    ccpp.findPrice("AUS", "BOS");
                    ccpp.findPrice("HAW", "MIA");
                    ccpp.findPrice("BOS", "AUS");
                    ccpp.findPrice("LAX", "BOS");
                    ccpp.findPrice("MIA", "HAW");
                    ccpp.findPrice("LAX", "LON");
                    ccpp.findPrice("AUS", "PAR");
                    ccpp.findPrice("LON", "HAW");
                    ccpp.findPrice("JFK", "SEA");
                    System.out.println("Found price of 50 routes");
                }

                //Change existing price
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Changing Price of Ticket");
                    aapp.changePrice("JFK", "SEA", "00001", "1", "0");
                    aapp.changePrice("BOS", "HAW", "00007", "1", "0");
                    aapp.changePrice("JFK", "PHI", "00000", "1", "0");
                    aapp.changePrice("SCN", "PHI", "00005", "1", "0");
                    aapp.changePrice("LON", "LAX", "00002", "1", "0");
                    aapp.changePrice("SCN", "PIT", "00006", "1", "0");
                    aapp.changePrice("JFK", "MIA", "00000", "1", "0");
                    aapp.changePrice("PIT", "PHI", "00000", "1", "0");
                    aapp.changePrice("PHI", "HAW", "00007", "1", "0");
                    aapp.changePrice("PHI", "MIA", "00002", "1", "0");
                    aapp.changePrice("BOS", "MIA", "00004", "1", "0");
                    aapp.changePrice("SCN", "MIA", "00006", "1", "0");
                    aapp.changePrice("MIA", "PIT", "00004", "1", "0");
                    aapp.changePrice("PIT", "JFK", "00001", "1", "0");
                    aapp.changePrice("BOS", "LON", "00007", "1", "0");
                    aapp.changePrice("PAR", "LON", "00000", "1", "0");
                    aapp.changePrice("SCN", "LAX", "00003", "1", "0");
                    aapp.changePrice("PAR", "MIA", "00006", "1", "0");
                    aapp.changePrice("AUS", "LON", "00009", "1", "0");
                    aapp.changePrice("JFK", "LON", "00004", "1", "0");
                    aapp.changePrice("LON", "BOS", "00008", "1", "0");
                    aapp.changePrice("LON", "MIA", "00006", "1", "0");
                    aapp.changePrice("HAW", "LAX", "00000", "1", "0");
                    aapp.changePrice("LON", "JFK", "00001", "1", "0");
                    aapp.changePrice("PIT", "HAW", "00006", "1", "0");
                    aapp.changePrice("LAX", "PIT", "00007", "1", "0");
                    aapp.changePrice("AUS", "BOS", "00004", "1", "0");
                    aapp.changePrice("JFK", "HAW", "00009", "1", "0");
                    aapp.changePrice("SEA", "PIT", "00001", "1", "0");
                    aapp.changePrice("PHI", "JFK", "00004", "1", "0");
                    aapp.changePrice("LAX", "HAW", "00009", "1", "0");
                    aapp.changePrice("HAW", "AUS", "00002", "1", "0");
                    aapp.changePrice("JFK", "BOS", "00006", "1", "0");
                    aapp.changePrice("LON", "HAW", "00004", "1", "0");
                    aapp.changePrice("PHI", "BOS", "00006", "1", "0");
                    aapp.changePrice("MIA", "SEA", "00008", "1", "0");
                    aapp.changePrice("PIT", "MIA", "00004", "1", "0");
                    aapp.changePrice("PHI", "PAR", "00001", "1", "0");
                    aapp.changePrice("JFK", "PHI", "00009", "1", "0");
                    aapp.changePrice("LON", "PHI", "00000", "1", "0");
                    aapp.changePrice("JFK", "PHI", "00007", "1", "0");
                    aapp.changePrice("PAR", "SEA", "00008", "1", "0");
                    aapp.changePrice("SEA", "LAX", "00007", "1", "0");
                    aapp.changePrice("MIA", "AUS", "00008", "1", "0");
                    aapp.changePrice("AUS", "MIA", "00008", "1", "0");
                    aapp.changePrice("HAW", "JFK", "00006", "1", "0");
                    aapp.changePrice("PAR", "PHI", "00001", "1", "0");
                    aapp.changePrice("JFK", "SEA", "00007", "1", "0");
                    aapp.changePrice("BOS", "PAR", "00009", "1", "0");
                    aapp.changePrice("JFK", "SEA", "00008", "1", "0");
                    aapp.changePrice("LAX", "HAW", "00003", "1", "0");
                    aapp.changePrice("AUS", "LON", "00001", "1", "0");
                    aapp.changePrice("MIA", "PHI", "00003", "1", "0");
                    aapp.changePrice("LON", "AUS", "00003", "1", "0");
                    aapp.changePrice("SEA", "PIT", "00009", "1", "0");
                    aapp.changePrice("SCN", "PIT", "00008", "1", "0");
                    aapp.changePrice("BOS", "SEA", "00002", "1", "0");
                    aapp.changePrice("PHI", "SEA", "00005", "1", "0");
                    aapp.changePrice("JFK", "HAW", "00005", "1", "0");
                    aapp.changePrice("PIT", "PAR", "00005", "1", "0");
                    aapp.changePrice("MIA", "LAX", "00009", "1", "0");
                    aapp.changePrice("LON", "AUS", "00000", "1", "0");
                    aapp.changePrice("LON", "PIT", "00008", "1", "0");
                    aapp.changePrice("MIA", "LON", "00001", "1", "0");
                    aapp.changePrice("JFK", "PIT", "00006", "1", "0");
                    aapp.changePrice("MIA", "SEA", "00004", "1", "0");
                    aapp.changePrice("PHI", "JFK", "00005", "1", "0");
                    aapp.changePrice("MIA", "BOS", "00003", "1", "0");
                    aapp.changePrice("PHI", "LON", "00005", "1", "0");
                    aapp.changePrice("PIT", "LAX", "00003", "1", "0");
                    aapp.changePrice("SCN", "SEA", "00009", "1", "0");
                    aapp.changePrice("BOS", "HAW", "00002", "1", "0");
                    aapp.changePrice("MIA", "HAW", "00001", "1", "0");
                    aapp.changePrice("PHI", "AUS", "00003", "1", "0");
                    aapp.changePrice("BOS", "PHI", "00001", "1", "0");
                    aapp.changePrice("PIT", "LON", "00004", "1", "0");
                    aapp.changePrice("SEA", "LON", "00009", "1", "0");
                    aapp.changePrice("SCN", "LON", "00003", "1", "0");
                    aapp.changePrice("PIT", "LON", "00009", "1", "0");
                    aapp.changePrice("PAR", "MIA", "00007", "1", "0");
                    aapp.changePrice("HAW", "AUS", "00004", "1", "0");
                    aapp.changePrice("LAX", "PHI", "00005", "1", "0");
                    aapp.changePrice("PHI", "SEA", "00001", "1", "0");
                    aapp.changePrice("PIT", "PHI", "00001", "1", "0");
                    aapp.changePrice("HAW", "MIA", "00008", "1", "0");
                    aapp.changePrice("PIT", "BOS", "00008", "1", "0");
                    aapp.changePrice("SEA", "HAW", "00004", "1", "0");
                    aapp.changePrice("JFK", "BOS", "00005", "1", "0");
                    aapp.changePrice("AUS", "PHI", "00005", "1", "0");
                    aapp.changePrice("HAW", "LAX", "00001", "1", "0");
                    aapp.changePrice("PAR", "PHI", "00000", "1", "0");
                    aapp.changePrice("MIA", "BOS", "00002", "1", "0");
                    aapp.changePrice("JFK", "AUS", "00005", "1", "0");
                    aapp.changePrice("AUS", "PIT", "00003", "1", "0");
                    aapp.changePrice("BOS", "SCN", "00009", "1", "0");
                    aapp.changePrice("SEA", "PIT", "00000", "1", "0");
                    aapp.changePrice("MIA", "PIT", "00007", "1", "0");
                    aapp.changePrice("MIA", "LAX", "00004", "1", "0");
                    aapp.changePrice("LON", "PAR", "00009", "1", "0");
                    aapp.changePrice("HAW", "BOS", "00001", "1", "0");

                    System.out.println("");
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
                    ccpp.buyReservation("11004");
                    ccpp.buyReservation("11005");
                    ccpp.buyReservation("11006");
                    ccpp.buyReservation("11007");
                    ccpp.buyReservation("11008");
                    ccpp.buyReservation("11009");
                    ccpp.buyReservation("11010");
                    ccpp.buyReservation("11011");
                    ccpp.buyReservation("11012");
                    ccpp.buyReservation("11013");
                    ccpp.buyReservation("11014");
                    ccpp.buyReservation("11015");
                    ccpp.buyReservation("11016");
                    ccpp.buyReservation("11017");
                    ccpp.buyReservation("11018");
                    ccpp.buyReservation("11019");
                    ccpp.buyReservation("11020");
                    ccpp.buyReservation("11021");
                    ccpp.buyReservation("11022");
                    ccpp.buyReservation("11023");
                    ccpp.buyReservation("11024");
                    ccpp.buyReservation("11025");
                    ccpp.buyReservation("11026");
                    ccpp.buyReservation("11027");
                    ccpp.buyReservation("11028");
                    ccpp.buyReservation("11029");
                    ccpp.buyReservation("11030");
                    ccpp.buyReservation("11031");
                    ccpp.buyReservation("11032");
                    ccpp.buyReservation("11033");
                    ccpp.buyReservation("11034");
                    ccpp.buyReservation("11035");
                    ccpp.buyReservation("11036");
                    ccpp.buyReservation("11037");
                    ccpp.buyReservation("11038");
                    ccpp.buyReservation("11039");
                    ccpp.buyReservation("11040");
                    ccpp.buyReservation("11041");
                    ccpp.buyReservation("11042");
                    ccpp.buyReservation("11043");
                    ccpp.buyReservation("11044");
                    ccpp.buyReservation("11045");
                    ccpp.buyReservation("11046");
                    ccpp.buyReservation("11047");
                    ccpp.buyReservation("11048");
                    ccpp.buyReservation("11049");
                    System.out.println("Bought 50 tickets");
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
                    ccpp.findReservation("11005");
                    ccpp.findReservation("11006");
                    ccpp.findReservation("11007");
                    ccpp.findReservation("11008");
                    ccpp.findReservation("11009");
                    ccpp.findReservation("11010");
                    ccpp.findReservation("11011");
                    ccpp.findReservation("11012");
                    ccpp.findReservation("11013");
                    ccpp.findReservation("11014");
                    ccpp.findReservation("11015");
                    ccpp.findReservation("11016");
                    ccpp.findReservation("11017");
                    ccpp.findReservation("11018");
                    ccpp.findReservation("11019");
                    ccpp.findReservation("11020");
                    ccpp.findReservation("11021");
                    ccpp.findReservation("11022");
                    ccpp.findReservation("11023");
                    ccpp.findReservation("11024");
                    ccpp.findReservation("11025");
                    ccpp.findReservation("11026");
                    ccpp.findReservation("11027");
                    ccpp.findReservation("11028");
                    ccpp.findReservation("11029");
                    ccpp.findReservation("11030");
                    ccpp.findReservation("11031");
                    ccpp.findReservation("11032");
                    ccpp.findReservation("11033");
                    ccpp.findReservation("11034");
                    ccpp.findReservation("11035");
                    ccpp.findReservation("11036");
                    ccpp.findReservation("11037");
                    ccpp.findReservation("11038");
                    ccpp.findReservation("11039");
                    ccpp.findReservation("11040");
                    ccpp.findReservation("11041");
                    ccpp.findReservation("11042");
                    ccpp.findReservation("11043");
                    ccpp.findReservation("11044");
                    ccpp.findReservation("11045");
                    ccpp.findReservation("11046");
                    ccpp.findReservation("11047");
                    ccpp.findReservation("11048");
                    ccpp.findReservation("11049");
                    System.out.println("Shown 50 Reservations");
                }

                //Generate Passenger Manifest for a specific flight on given date
                answer = input.readLine("Continue? Press Enter: ");
                if(answer != null)
                {
                    System.out.println("Generating Passenger manifest for all flights on all dates");
                    aapp.generateManifest("000", "14-NOV-14 03:00:00");
                    aapp.generateManifest("002", "13-NOV-13 02:00:00");
                    aapp.generateManifest("004", "14-OCT-14 02:00:00");
                    aapp.generateManifest("006", "11-JUN-11 01:00:00");
                    aapp.generateManifest("008", "19-OCT-19 00:00:00");
                    aapp.generateManifest("010", "05-JUL-05 01:00:00");
                    aapp.generateManifest("012", "16-DEC-16 00:00:00");
                    aapp.generateManifest("014", "04-APR-04 00:00:00");
                    aapp.generateManifest("016", "14-JAN-14 01:00:00");
                    aapp.generateManifest("018", "03-JAN-03 01:00:00");
                    aapp.generateManifest("020", "18-JAN-18 03:00:00");
                    aapp.generateManifest("022", "13-MAR-13 01:00:00");
                    aapp.generateManifest("024", "06-SEP-06 03:00:00");
                    aapp.generateManifest("026", "04-JUL-04 01:00:00");
                    aapp.generateManifest("028", "13-NOV-13 01:00:00");
                    aapp.generateManifest("030", "16-MAR-16 00:00:00");
                    aapp.generateManifest("032", "09-JAN-09 03:00:00");
                    aapp.generateManifest("034", "09-JUN-09 01:00:00");
                    aapp.generateManifest("036", "15-JUN-15 00:00:00");
                    aapp.generateManifest("038", "07-DEC-07 01:00:00");
                    aapp.generateManifest("040", "02-DEC-02 03:00:00");
                    aapp.generateManifest("042", "04-AUG-04 01:00:00");
                    aapp.generateManifest("044", "19-JUN-19 00:00:00");
                    aapp.generateManifest("046", "13-JAN-13 02:00:00");
                    aapp.generateManifest("048", "05-AUG-05 02:00:00");
                    aapp.generateManifest("050", "05-FEB-05 00:00:00");
                    aapp.generateManifest("052", "09-JUN-09 02:00:00");
                    aapp.generateManifest("054", "10-MAR-10 00:00:00");
                    aapp.generateManifest("056", "14-JUN-14 01:00:00");
                    aapp.generateManifest("058", "14-SEP-14 03:00:00");
                    aapp.generateManifest("060", "06-JAN-06 02:00:00");
                    aapp.generateManifest("062", "06-JUN-06 02:00:00");
                    aapp.generateManifest("064", "11-JUL-11 00:00:00");
                    aapp.generateManifest("066", "06-MAR-06 00:00:00");
                    aapp.generateManifest("068", "17-AUG-17 02:00:00");
                    aapp.generateManifest("070", "07-OCT-07 02:00:00");
                    aapp.generateManifest("072", "06-JAN-06 03:00:00");
                    aapp.generateManifest("074", "15-FEB-15 03:00:00");
                    aapp.generateManifest("076", "07-MAR-07 00:00:00");
                    aapp.generateManifest("078", "04-SEP-04 03:00:00");
                    aapp.generateManifest("080", "13-FEB-13 01:00:00");
                    aapp.generateManifest("082", "20-JAN-20 03:00:00");
                    aapp.generateManifest("084", "10-NOV-10 01:00:00");
                    aapp.generateManifest("086", "17-JAN-17 01:00:00");
                    aapp.generateManifest("088", "07-JUN-07 00:00:00");
                    aapp.generateManifest("090", "16-DEC-16 00:00:00");
                    aapp.generateManifest("092", "13-AUG-13 02:00:00");
                    aapp.generateManifest("094", "19-MAY-19 03:00:00");
                    aapp.generateManifest("096", "08-OCT-08 02:00:00");
                    aapp.generateManifest("098", "20-SEP-20 02:00:00");
                    aapp.generateManifest("100", "09-JUL-09 02:00:00");
                    aapp.generateManifest("102", "10-SEP-10 00:00:00");
                    aapp.generateManifest("104", "03-OCT-03 02:00:00");
                    aapp.generateManifest("106", "04-NOV-04 03:00:00");
                    aapp.generateManifest("108", "18-AUG-18 02:00:00");
                    aapp.generateManifest("110", "12-JUN-12 02:00:00");
                    aapp.generateManifest("112", "10-FEB-10 02:00:00");
                    aapp.generateManifest("114", "18-APR-18 01:00:00");
                    aapp.generateManifest("116", "13-SEP-13 02:00:00");
                    aapp.generateManifest("118", "09-FEB-09 03:00:00");
                    aapp.generateManifest("120", "20-NOV-20 01:00:00");
                    aapp.generateManifest("122", "17-NOV-17 00:00:00");
                    aapp.generateManifest("124", "15-MAR-15 00:00:00");
                    aapp.generateManifest("126", "20-JAN-20 02:00:00");
                    aapp.generateManifest("128", "02-NOV-02 00:00:00");
                    aapp.generateManifest("130", "18-MAY-18 03:00:00");
                    aapp.generateManifest("132", "15-JUL-15 01:00:00");
                    aapp.generateManifest("134", "10-JUL-10 00:00:00");
                    aapp.generateManifest("136", "14-MAR-14 00:00:00");
                    aapp.generateManifest("138", "17-JAN-17 01:00:00");
                    aapp.generateManifest("140", "14-AUG-14 01:00:00");
                    aapp.generateManifest("142", "15-JUL-15 01:00:00");
                    aapp.generateManifest("144", "19-FEB-19 03:00:00");
                    aapp.generateManifest("146", "15-MAR-15 02:00:00");
                    aapp.generateManifest("148", "19-JUN-19 00:00:00");
                    aapp.generateManifest("150", "08-JAN-08 01:00:00");
                    aapp.generateManifest("152", "18-NOV-18 00:00:00");
                    aapp.generateManifest("154", "13-FEB-13 02:00:00");
                    aapp.generateManifest("156", "18-JUL-18 03:00:00");
                    aapp.generateManifest("158", "14-OCT-14 02:00:00");
                    aapp.generateManifest("160", "17-JAN-17 01:00:00");
                    aapp.generateManifest("162", "20-AUG-20 03:00:00");
                    aapp.generateManifest("164", "01-OCT-01 00:00:00");
                    aapp.generateManifest("166", "06-JUL-06 01:00:00");
                    aapp.generateManifest("168", "19-DEC-19 03:00:00");
                    aapp.generateManifest("170", "12-JAN-12 02:00:00");
                    aapp.generateManifest("172", "03-MAR-03 00:00:00");
                    aapp.generateManifest("174", "01-JUN-01 01:00:00");
                    aapp.generateManifest("176", "03-JAN-03 00:00:00");
                    aapp.generateManifest("178", "19-JUL-19 00:00:00");
                    aapp.generateManifest("180", "06-OCT-06 01:00:00");
                    aapp.generateManifest("182", "15-FEB-15 00:00:00");
                    aapp.generateManifest("184", "10-DEC-10 01:00:00");
                    aapp.generateManifest("186", "16-OCT-16 03:00:00");
                    aapp.generateManifest("188", "17-NOV-17 00:00:00");
                    aapp.generateManifest("190", "03-MAY-03 02:00:00");
                    aapp.generateManifest("192", "19-JUL-19 03:00:00");
                    aapp.generateManifest("194", "11-MAR-11 01:00:00");
                    aapp.generateManifest("196", "20-NOV-20 00:00:00");
                    aapp.generateManifest("198", "03-AUG-03 01:00:00");
                    System.out.println("Generated Manifest for 100 Flights");
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
        }
        connection.close();
    }
}
