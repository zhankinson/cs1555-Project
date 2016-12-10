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

		ccpp.addCustomer("John", "Johnson", "1234152512341234", "APR-2020", "Ridley st", "Lancaster", "PA", "1234123234", "john.johnson@gmail.com");
		ccpp.showCustomer("John", "Johnson");
		ccpp.findReservation("00199");

        AdministratorInterface aapp = new AdministratorInterface(connection);
        // Erase Database
        // aapp.eraseDB();
        //
        // Load Airline information
        // aapp.loadAirline("loadairline.csv");
        //
        // // Load Plane information
        // aapp.loadPlane("loadplane.csv");
        //
        // //Load Schedule information
        // aapp.loadSchedule("loadschedule.csv");
        //
        // //Load pricing information
        // aapp.loadPrice("loadpricing.csv");

        // //Change existing price
        do {
            aapp.changePrice("JFK", "SEA", "00001", "1000", "500");
            aapp.changePrice("BOS", "HAW", "00007", "1000", "500");
            aapp.changePrice("JFK", "PHI", "00000", "1000", "500");
            aapp.changePrice("SCN", "PHI", "00005", "1000", "500");
            aapp.changePrice("LON", "LAX", "00002", "1000", "500");
            aapp.changePrice("SCN", "PIT", "00006", "1000", "500");
            aapp.changePrice("JFK", "MIA", "00000", "1000", "500");
            aapp.changePrice("PIT", "PHI", "00000", "1000", "500");
            aapp.changePrice("PHI", "HAW", "00007", "1000", "500");
            aapp.changePrice("PHI", "MIA", "00002", "1000", "500");
            aapp.changePrice("BOS", "MIA", "00004", "1000", "500");
            aapp.changePrice("SCN", "MIA", "00006", "1000", "500");
            aapp.changePrice("MIA", "PIT", "00004", "1000", "500");
            aapp.changePrice("PIT", "JFK", "00001", "1000", "500");
            aapp.changePrice("BOS", "LON", "00007", "1000", "500");
            aapp.changePrice("PAR", "LON", "00000", "1000", "500");
            aapp.changePrice("SCN", "LAX", "00003", "1000", "500");
            aapp.changePrice("PAR", "MIA", "00006", "1000", "500");
            aapp.changePrice("AUS", "LON", "00009", "1000", "500");
            aapp.changePrice("JFK", "LON", "00004", "1000", "500");
            aapp.changePrice("LON", "BOS", "00008", "1000", "500");
            aapp.changePrice("LON", "MIA", "00006", "1000", "500");
            aapp.changePrice("HAW", "LAX", "00000", "1000", "500");
            aapp.changePrice("LON", "JFK", "00001", "1000", "500");
            aapp.changePrice("PIT", "HAW", "00006", "1000", "500");
            aapp.changePrice("LAX", "PIT", "00007", "1000", "500");
            aapp.changePrice("AUS", "BOS", "00004", "1000", "500");
            aapp.changePrice("JFK", "HAW", "00009", "1000", "500");
            aapp.changePrice("SEA", "PIT", "00001", "1000", "500");
            aapp.changePrice("PHI", "JFK", "00004", "1000", "500");
            aapp.changePrice("LAX", "HAW", "00009", "1000", "500");
            aapp.changePrice("HAW", "AUS", "00002", "1000", "500");
            aapp.changePrice("JFK", "BOS", "00006", "1000", "500");
            aapp.changePrice("LON", "HAW", "00004", "1000", "500");
            aapp.changePrice("PHI", "BOS", "00006", "1000", "500");
            aapp.changePrice("MIA", "SEA", "00008", "1000", "500");
            aapp.changePrice("PIT", "MIA", "00004", "1000", "500");
            aapp.changePrice("PHI", "PAR", "00001", "1000", "500");
            aapp.changePrice("JFK", "PHI", "00009", "1000", "500");
            aapp.changePrice("LON", "PHI", "00000", "1000", "500");
            aapp.changePrice("JFK", "PHI", "00007", "1000", "500");
            aapp.changePrice("PAR", "SEA", "00008", "1000", "500");
            aapp.changePrice("SEA", "LAX", "00007", "1000", "500");
            aapp.changePrice("MIA", "AUS", "00008", "1000", "500");
            aapp.changePrice("AUS", "MIA", "00008", "1000", "500");
            aapp.changePrice("HAW", "JFK", "00006", "1000", "500");
            aapp.changePrice("PAR", "PHI", "00001", "1000", "500");
            aapp.changePrice("JFK", "SEA", "00007", "1000", "500");
            aapp.changePrice("BOS", "PAR", "00009", "1000", "500");
            aapp.changePrice("JFK", "SEA", "00008", "1000", "500");
            aapp.changePrice("LAX", "HAW", "00003", "1000", "500");
            aapp.changePrice("AUS", "LON", "00001", "1000", "500");
            aapp.changePrice("MIA", "PHI", "00003", "1000", "500");
            aapp.changePrice("LON", "AUS", "00003", "1000", "500");
            aapp.changePrice("SEA", "PIT", "00009", "1000", "500");
            aapp.changePrice("SCN", "PIT", "00008", "1000", "500");
            aapp.changePrice("BOS", "SEA", "00002", "1000", "500");
            aapp.changePrice("PHI", "SEA", "00005", "1000", "500");
            aapp.changePrice("JFK", "HAW", "00005", "1000", "500");
            aapp.changePrice("PIT", "PAR", "00005", "1000", "500");
            aapp.changePrice("MIA", "LAX", "00009", "1000", "500");
            aapp.changePrice("LON", "AUS", "00000", "1000", "500");
            aapp.changePrice("LON", "PIT", "00008", "1000", "500");
            aapp.changePrice("MIA", "LON", "00001", "1000", "500");
            aapp.changePrice("JFK", "PIT", "00006", "1000", "500");
            aapp.changePrice("MIA", "SEA", "00004", "1000", "500");
            aapp.changePrice("PHI", "JFK", "00005", "1000", "500");
            aapp.changePrice("MIA", "BOS", "00003", "1000", "500");
            aapp.changePrice("PHI", "LON", "00005", "1000", "500");
            aapp.changePrice("PIT", "LAX", "00003", "1000", "500");
            aapp.changePrice("SCN", "SEA", "00009", "1000", "500");
            aapp.changePrice("BOS", "HAW", "00002", "1000", "500");
            aapp.changePrice("MIA", "HAW", "00001", "1000", "500");
            aapp.changePrice("PHI", "AUS", "00003", "1000", "500");
            aapp.changePrice("BOS", "PHI", "00001", "1000", "500");
            aapp.changePrice("PIT", "LON", "00004", "1000", "500");
            aapp.changePrice("SEA", "LON", "00009", "1000", "500");
            aapp.changePrice("SCN", "LON", "00003", "1000", "500");
            aapp.changePrice("PIT", "LON", "00009", "1000", "500");
            aapp.changePrice("PAR", "MIA", "00007", "1000", "500");
            aapp.changePrice("HAW", "AUS", "00004", "1000", "500");
            aapp.changePrice("LAX", "PHI", "00005", "1000", "500");
            aapp.changePrice("PHI", "SEA", "00001", "1000", "500");
            aapp.changePrice("PIT", "PHI", "00001", "1000", "500");
            aapp.changePrice("HAW", "MIA", "00008", "1000", "500");
            aapp.changePrice("PIT", "BOS", "00008", "1000", "500");
            aapp.changePrice("SEA", "HAW", "00004", "1000", "500");
            aapp.changePrice("JFK", "BOS", "00005", "1000", "500");
            aapp.changePrice("AUS", "PHI", "00005", "1000", "500");
            aapp.changePrice("HAW", "LAX", "00001", "1000", "500");
            aapp.changePrice("PAR", "PHI", "00000", "1000", "500");
            aapp.changePrice("MIA", "BOS", "00002", "1000", "500");
            aapp.changePrice("JFK", "AUS", "00005", "1000", "500");
            aapp.changePrice("AUS", "PIT", "00003", "1000", "500");
            aapp.changePrice("BOS", "SCN", "00009", "1000", "500");
            aapp.changePrice("SEA", "PIT", "00000", "1000", "500");
            aapp.changePrice("MIA", "PIT", "00007", "1000", "500");
            aapp.changePrice("MIA", "LAX", "00004", "1000", "500");
            aapp.changePrice("LON", "PAR", "00009", "1000", "500");
            aapp.changePrice("HAW", "BOS", "00001", "1000", "500");
        } while (false);

        //Generate Passenger Manifest for a specific flight on given date
        do {
            aapp.generateManifest("000", "19-MAY-19 02:00:00");
            aapp.generateManifest("000", "19-MAY-19 02:00:00");
            aapp.generateManifest("001", "10-MAY-10 03:00:00");
            aapp.generateManifest("001", "10-MAY-10 03:00:00");
            aapp.generateManifest("002", "02-FEB-02 00:00:00");
            aapp.generateManifest("002", "02-FEB-02 00:00:00");
            aapp.generateManifest("003", "19-FEB-19 01:00:00");
            aapp.generateManifest("003", "19-FEB-19 01:00:00");
            aapp.generateManifest("004", "17-SEP-17 01:00:00");
            aapp.generateManifest("004", "17-SEP-17 01:00:00");
            aapp.generateManifest("005", "14-JUN-14 01:00:00");
            aapp.generateManifest("005", "14-JUN-14 01:00:00");
            aapp.generateManifest("006", "13-MAR-13 01:00:00");
            aapp.generateManifest("006", "13-MAR-13 01:00:00");
            aapp.generateManifest("007", "09-AUG-09 02:00:00");
            aapp.generateManifest("007", "09-AUG-09 02:00:00");
            aapp.generateManifest("008", "18-DEC-18 00:00:00");
            aapp.generateManifest("008", "18-DEC-18 00:00:00");
            aapp.generateManifest("009", "19-SEP-19 02:00:00");
            aapp.generateManifest("009", "19-SEP-19 02:00:00");
            aapp.generateManifest("010", "11-NOV-11 03:00:00");
            aapp.generateManifest("010", "11-NOV-11 03:00:00");
            aapp.generateManifest("011", "17-JAN-17 00:00:00");
            aapp.generateManifest("011", "17-JAN-17 00:00:00");
            aapp.generateManifest("012", "18-MAR-18 03:00:00");
            aapp.generateManifest("012", "18-MAR-18 03:00:00");
            aapp.generateManifest("013", "08-JUN-08 00:00:00");
            aapp.generateManifest("013", "08-JUN-08 00:00:00");
            aapp.generateManifest("014", "02-FEB-02 00:00:00");
            aapp.generateManifest("014", "02-FEB-02 00:00:00");
            aapp.generateManifest("015", "07-MAY-07 01:00:00");
            aapp.generateManifest("015", "07-MAY-07 01:00:00");
            aapp.generateManifest("016", "04-MAR-04 03:00:00");
            aapp.generateManifest("016", "04-MAR-04 03:00:00");
            aapp.generateManifest("017", "15-AUG-15 02:00:00");
            aapp.generateManifest("017", "15-AUG-15 02:00:00");
            aapp.generateManifest("018", "04-MAR-04 03:00:00");
            aapp.generateManifest("018", "04-MAR-04 03:00:00");
            aapp.generateManifest("019", "16-NOV-16 03:00:00");
            aapp.generateManifest("019", "16-NOV-16 03:00:00");
            aapp.generateManifest("020", "08-FEB-08 01:00:00");
            aapp.generateManifest("020", "08-FEB-08 01:00:00");
            aapp.generateManifest("021", "12-SEP-12 02:00:00");
            aapp.generateManifest("021", "12-SEP-12 02:00:00");
            aapp.generateManifest("022", "15-APR-15 00:00:00");
            aapp.generateManifest("022", "15-APR-15 00:00:00");
            aapp.generateManifest("023", "12-DEC-12 00:00:00");
            aapp.generateManifest("023", "12-DEC-12 00:00:00");
            aapp.generateManifest("024", "19-APR-19 00:00:00");
            aapp.generateManifest("024", "19-APR-19 00:00:00");
            aapp.generateManifest("025", "17-JUL-17 03:00:00");
            aapp.generateManifest("025", "17-JUL-17 03:00:00");
            aapp.generateManifest("026", "14-OCT-14 01:00:00");
            aapp.generateManifest("026", "14-OCT-14 01:00:00");
            aapp.generateManifest("027", "06-APR-06 02:00:00");
            aapp.generateManifest("027", "06-APR-06 02:00:00");
            aapp.generateManifest("028", "15-FEB-15 03:00:00");
            aapp.generateManifest("028", "15-FEB-15 03:00:00");
            aapp.generateManifest("029", "13-FEB-13 01:00:00");
            aapp.generateManifest("029", "13-FEB-13 01:00:00");
            aapp.generateManifest("030", "20-JAN-20 01:00:00");
            aapp.generateManifest("030", "20-JAN-20 01:00:00");
            aapp.generateManifest("031", "07-DEC-07 00:00:00");
            aapp.generateManifest("031", "07-DEC-07 00:00:00");
            aapp.generateManifest("032", "04-FEB-04 01:00:00");
            aapp.generateManifest("032", "04-FEB-04 01:00:00");
            aapp.generateManifest("033", "05-DEC-05 02:00:00");
            aapp.generateManifest("033", "05-DEC-05 02:00:00");
            aapp.generateManifest("034", "05-DEC-05 00:00:00");
            aapp.generateManifest("034", "05-DEC-05 00:00:00");
            aapp.generateManifest("035", "08-JUN-08 03:00:00");
            aapp.generateManifest("035", "08-JUN-08 03:00:00");
            aapp.generateManifest("036", "09-DEC-09 03:00:00");
            aapp.generateManifest("036", "09-DEC-09 03:00:00");
            aapp.generateManifest("037", "06-JAN-06 03:00:00");
            aapp.generateManifest("037", "06-JAN-06 03:00:00");
            aapp.generateManifest("038", "07-AUG-07 03:00:00");
            aapp.generateManifest("038", "07-AUG-07 03:00:00");
            aapp.generateManifest("039", "05-FEB-05 03:00:00");
            aapp.generateManifest("039", "05-FEB-05 03:00:00");
            aapp.generateManifest("040", "05-APR-05 02:00:00");
            aapp.generateManifest("040", "05-APR-05 02:00:00");
            aapp.generateManifest("041", "07-JAN-07 00:00:00");
            aapp.generateManifest("041", "07-JAN-07 00:00:00");
            aapp.generateManifest("042", "07-AUG-07 00:00:00");
            aapp.generateManifest("042", "07-AUG-07 00:00:00");
            aapp.generateManifest("043", "13-FEB-13 02:00:00");
            aapp.generateManifest("043", "13-FEB-13 02:00:00");
            aapp.generateManifest("044", "19-JAN-19 01:00:00");
            aapp.generateManifest("044", "19-JAN-19 01:00:00");
            aapp.generateManifest("045", "13-JAN-13 03:00:00");
            aapp.generateManifest("045", "13-JAN-13 03:00:00");
            aapp.generateManifest("046", "03-JAN-03 03:00:00");
            aapp.generateManifest("046", "03-JAN-03 03:00:00");
            aapp.generateManifest("047", "05-OCT-05 01:00:00");
            aapp.generateManifest("047", "05-OCT-05 01:00:00");
            aapp.generateManifest("048", "01-MAR-01 01:00:00");
            aapp.generateManifest("048", "01-MAR-01 01:00:00");
            aapp.generateManifest("049", "06-MAY-06 01:00:00");
            aapp.generateManifest("049", "06-MAY-06 01:00:00");
            aapp.generateManifest("050", "04-APR-04 03:00:00");
            aapp.generateManifest("050", "04-APR-04 03:00:00");
            aapp.generateManifest("051", "17-FEB-17 01:00:00");
            aapp.generateManifest("051", "17-FEB-17 01:00:00");
            aapp.generateManifest("052", "14-MAR-14 03:00:00");
            aapp.generateManifest("052", "14-MAR-14 03:00:00");
            aapp.generateManifest("053", "20-MAY-20 01:00:00");
            aapp.generateManifest("053", "20-MAY-20 01:00:00");
            aapp.generateManifest("054", "01-JAN-01 00:00:00");
            aapp.generateManifest("054", "01-JAN-01 00:00:00");
            aapp.generateManifest("055", "02-SEP-02 02:00:00");
            aapp.generateManifest("055", "02-SEP-02 02:00:00");
            aapp.generateManifest("056", "04-JUN-04 03:00:00");
            aapp.generateManifest("056", "04-JUN-04 03:00:00");
            aapp.generateManifest("057", "05-OCT-05 00:00:00");
            aapp.generateManifest("057", "05-OCT-05 00:00:00");
            aapp.generateManifest("058", "13-NOV-13 00:00:00");
            aapp.generateManifest("058", "13-NOV-13 00:00:00");
            aapp.generateManifest("059", "16-JUN-16 02:00:00");
            aapp.generateManifest("059", "16-JUN-16 02:00:00");
            aapp.generateManifest("060", "09-APR-09 02:00:00");
            aapp.generateManifest("060", "09-APR-09 02:00:00");
            aapp.generateManifest("061", "07-JUL-07 01:00:00");
            aapp.generateManifest("061", "07-JUL-07 01:00:00");
            aapp.generateManifest("062", "18-AUG-18 02:00:00");
            aapp.generateManifest("062", "18-AUG-18 02:00:00");
            aapp.generateManifest("063", "16-DEC-16 01:00:00");
            aapp.generateManifest("063", "16-DEC-16 01:00:00");
            aapp.generateManifest("064", "07-MAR-07 03:00:00");
            aapp.generateManifest("064", "07-MAR-07 03:00:00");
            aapp.generateManifest("065", "15-JAN-15 03:00:00");
            aapp.generateManifest("065", "15-JAN-15 03:00:00");
            aapp.generateManifest("066", "01-DEC-01 00:00:00");
            aapp.generateManifest("066", "01-DEC-01 00:00:00");
            aapp.generateManifest("067", "06-APR-06 01:00:00");
            aapp.generateManifest("067", "06-APR-06 01:00:00");
            aapp.generateManifest("068", "20-JUL-20 03:00:00");
            aapp.generateManifest("068", "20-JUL-20 03:00:00");
            aapp.generateManifest("069", "09-NOV-09 02:00:00");
            aapp.generateManifest("069", "09-NOV-09 02:00:00");
            aapp.generateManifest("070", "20-JUL-20 01:00:00");
            aapp.generateManifest("070", "20-JUL-20 01:00:00");
            aapp.generateManifest("071", "04-NOV-04 00:00:00");
            aapp.generateManifest("071", "04-NOV-04 00:00:00");
            aapp.generateManifest("072", "13-JAN-13 00:00:00");
            aapp.generateManifest("072", "13-JAN-13 00:00:00");
            aapp.generateManifest("073", "13-OCT-13 02:00:00");
            aapp.generateManifest("073", "13-OCT-13 02:00:00");
            aapp.generateManifest("074", "06-SEP-06 00:00:00");
            aapp.generateManifest("074", "06-SEP-06 00:00:00");
            aapp.generateManifest("075", "12-APR-12 00:00:00");
            aapp.generateManifest("075", "12-APR-12 00:00:00");
            aapp.generateManifest("076", "09-JUL-09 03:00:00");
            aapp.generateManifest("076", "09-JUL-09 03:00:00");
            aapp.generateManifest("077", "17-APR-17 00:00:00");
            aapp.generateManifest("077", "17-APR-17 00:00:00");
            aapp.generateManifest("078", "13-OCT-13 02:00:00");
            aapp.generateManifest("078", "13-OCT-13 02:00:00");
            aapp.generateManifest("079", "20-MAR-20 02:00:00");
            aapp.generateManifest("079", "20-MAR-20 02:00:00");
            aapp.generateManifest("080", "09-APR-09 00:00:00");
            aapp.generateManifest("080", "09-APR-09 00:00:00");
            aapp.generateManifest("081", "06-DEC-06 00:00:00");
            aapp.generateManifest("081", "06-DEC-06 00:00:00");
            aapp.generateManifest("082", "13-FEB-13 01:00:00");
            aapp.generateManifest("082", "13-FEB-13 01:00:00");
            aapp.generateManifest("083", "14-MAY-14 02:00:00");
            aapp.generateManifest("083", "14-MAY-14 02:00:00");
            aapp.generateManifest("084", "01-MAY-01 02:00:00");
            aapp.generateManifest("084", "01-MAY-01 02:00:00");
            aapp.generateManifest("085", "03-DEC-03 03:00:00");
            aapp.generateManifest("085", "03-DEC-03 03:00:00");
            aapp.generateManifest("086", "18-AUG-18 01:00:00");
            aapp.generateManifest("086", "18-AUG-18 01:00:00");
            aapp.generateManifest("087", "16-JAN-16 02:00:00");
            aapp.generateManifest("087", "16-JAN-16 02:00:00");
            aapp.generateManifest("088", "05-NOV-05 00:00:00");
            aapp.generateManifest("088", "05-NOV-05 00:00:00");
            aapp.generateManifest("089", "17-OCT-17 03:00:00");
            aapp.generateManifest("089", "17-OCT-17 03:00:00");
            aapp.generateManifest("090", "01-MAR-01 01:00:00");
            aapp.generateManifest("090", "01-MAR-01 01:00:00");
            aapp.generateManifest("091", "12-SEP-12 03:00:00");
            aapp.generateManifest("091", "12-SEP-12 03:00:00");
            aapp.generateManifest("092", "10-DEC-10 03:00:00");
            aapp.generateManifest("092", "10-DEC-10 03:00:00");
            aapp.generateManifest("093", "10-AUG-10 02:00:00");
            aapp.generateManifest("093", "10-AUG-10 02:00:00");
            aapp.generateManifest("094", "20-AUG-20 02:00:00");
            aapp.generateManifest("094", "20-AUG-20 02:00:00");
            aapp.generateManifest("095", "15-JAN-15 01:00:00");
            aapp.generateManifest("095", "15-JAN-15 01:00:00");
            aapp.generateManifest("096", "12-OCT-12 00:00:00");
            aapp.generateManifest("096", "12-OCT-12 00:00:00");
            aapp.generateManifest("097", "16-MAY-16 02:00:00");
            aapp.generateManifest("097", "16-MAY-16 02:00:00");
            aapp.generateManifest("098", "16-FEB-16 00:00:00");
            aapp.generateManifest("098", "16-FEB-16 00:00:00");
            aapp.generateManifest("099", "16-NOV-16 00:00:00");
            aapp.generateManifest("099", "16-NOV-16 00:00:00");
        } while(false);
        // String table = input.readLine("Please specify a table to display: ");
        // aapp.showTable(table);

        connection.close();
    }
}
