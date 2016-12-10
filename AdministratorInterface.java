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
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.FileReader;

public class AdministratorInterface {

    /**
    * @param args the command line arguments
    */
    private static Statement st; //used to create an instance of the connection
    private static ResultSet resultSet; //used to hold the result of your query (if one
    private static ResultSetMetaData rsmd; // exists)
    private static String query;  //this will hold the query we are using
    private static String username, password;
    private static String confirm;
    private static String filename;
    private static String departCity;
    private static String arriveCity;
    private static String highPrice;
    private static String lowPrice;
    private static String flightNumber;
    private static String flightDate;
    private static Scanner reader = new Scanner(System.in);  // Reading from System.in
    private static String answer;
    private static BufferedReader infile;
    private static Connection connection;


    private boolean loop;

    public AdministratorInterface(Connection link) throws SQLException{
        this.connection = link;
    }

    public void eraseDB()
    {
        System.out.println("Deleting all records...");
        try{
            st = connection.createStatement();
            connection.setAutoCommit(false);
            st.executeUpdate("delete from Reservation_detail");
            st.executeUpdate("delete from Reservation");
            st.executeUpdate("delete from Customer");
            st.executeUpdate("delete from Price");
            st.executeUpdate("delete from Flight");
            st.executeUpdate("delete from Plane");
            st.executeUpdate("delete from Airline");
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

    public void loadAirline(String filename)
    {
        try {
            infile = new BufferedReader(new FileReader(filename));
        } catch (java.io.FileNotFoundException f){
            System.out.println("Cannot Locate File: "+filename);
            System.err.println(f.toString());
        }
        try{
            st = connection.createStatement();
            while(infile.ready())
            {
                String[] line = infile.readLine().split(",");
                String sql = "insert into Airline values ('"+line[0]+"', '"+line[1]+"', '"+line[2]+"', "+line[3]+")";
                connection.setAutoCommit(false);
                st.executeUpdate(sql);
                connection.commit();
            }
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
        catch(java.io.IOException eee){
            System.out.println("Error: Load Unsuccessful");
            System.err.println(eee.toString());
        }

        try{
            String show = "select * from Airline";
            PreparedStatement pStatement = connection.prepareStatement(show);
            connection.setAutoCommit(false);
            resultSet = pStatement.executeQuery();
            connection.commit();
            while(resultSet.next())
            {
                System.out.print(resultSet.getString(1) + " ");
                System.out.print(resultSet.getString(2) + " ");
                System.out.print(resultSet.getString(3) + " ");
                System.out.print(resultSet.getString(4) + "\n");
            }
        }
        catch(Exception se){
            System.err.println(se.toString());
        }
    }

    public void loadSchedule(String filename)
    {
        try {
            infile = new BufferedReader(new FileReader(filename));
        } catch (java.io.FileNotFoundException f){
            System.out.println("Cannot Locate File: "+filename);
            System.err.println(f.toString());
        }
        try{
            st = connection.createStatement();
            while(infile.ready())
            {
                String[] line = infile.readLine().split(",");
                String sql = "insert into Flight values ('"+line[0]+"', '"+line[1]+"', '"+line[2]+"', '"+line[3]+"', '"+line[4]+"', '"+line[5]+"', '"+line[6]+"', '"+line[7]+"')";
                connection.setAutoCommit(false);
                st.executeUpdate(sql);
                connection.commit();
            }
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
        catch(java.io.IOException eee){
            System.out.println("Error: Load Unsuccessful");
            System.err.println(eee.toString());
        }

        try{
            String show = "select * from Flight";
            PreparedStatement pStatement = connection.prepareStatement(show);
            connection.setAutoCommit(false);
            resultSet = pStatement.executeQuery();
            connection.commit();
            while(resultSet.next())
            {
                System.out.print(resultSet.getString(1) + " ");
                System.out.print(resultSet.getString(2) + " ");
                System.out.print(resultSet.getString(3) + " ");
                System.out.print(resultSet.getString(4) + " ");
                System.out.print(resultSet.getString(5) + " ");
                System.out.print(resultSet.getString(6) + " ");
                System.out.print(resultSet.getString(7) + " ");
                System.out.print(resultSet.getString(8) + "\n");
            }
        }
        catch(Exception se)
        {
            System.err.println(se.toString());
        }
    }

    public void loadPrice(String filename)
    {
        try {
            infile = new BufferedReader(new FileReader(filename));
        } catch (java.io.FileNotFoundException f){
            System.out.println("Cannot Locate File: "+filename);
            System.err.println(f.toString());
        }
        try{
            st = connection.createStatement();
            while(infile.ready())
            {
                String[] line = infile.readLine().split(",");
                String sql = "insert into Price values ('"+line[0]+"', '"+line[1]+"', '"+line[2]+"', '"+line[3]+"', '"+line[4]+"')";
                connection.setAutoCommit(false);
                st.executeUpdate(sql);
                connection.commit();
            }
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
        catch(java.io.IOException eee){
            System.out.println("Error: Load Unsuccessful");
            System.err.println(eee.toString());
        }

        try{
            String show = "select * from Price";
            PreparedStatement pStatement = connection.prepareStatement(show);
            connection.setAutoCommit(false);
            resultSet = pStatement.executeQuery();
            connection.commit();
            while(resultSet.next())
            {
                System.out.print(resultSet.getString(1) + " ");
                System.out.print(resultSet.getString(2) + " ");
                System.out.print(resultSet.getString(3) + " ");
                System.out.print(resultSet.getString(4) + " ");
                System.out.print(resultSet.getString(5) + "\n");
            }
        }
        catch(Exception se){
            System.err.println(se.toString());
        }
    }

    public void changePrice(String departCity, String arriveCity, String highPrice, String lowPrice, String airline)
    {
        query = "update Price set high_price = ?, low_price = ? "+
        "where departure_city = ? and arrival_city = ? and airline_id = ?";
        try{
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, Integer.parseInt(highPrice));
            pStatement.setInt(2, Integer.parseInt(lowPrice));
            pStatement.setString(3, departCity);
            pStatement.setString(4, arriveCity);
            pStatement.setString(5, airline);
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

    public void loadPlane(String filename)
    {
        try {
            infile = new BufferedReader(new FileReader(filename));
        } catch (java.io.FileNotFoundException f){
            System.out.println("Cannot Locate File: "+filename);
            System.err.println(f.toString());
        }
        try{
            st = connection.createStatement();
            while(infile.ready())
            {
                String[] line = infile.readLine().split(",");
                String sql = "insert into Plane values ('"+line[0]+"', '"+line[1]+"', '"+line[2]+"', to_date('"+line[3]+"', 'MM/DD/YYYY'), '"+line[4]+"', '"+line[5]+"')";
                connection.setAutoCommit(false);
                st.executeUpdate(sql);
                connection.commit();
            }
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
        catch(java.io.IOException eee){
            System.out.println("Error: Load Unsuccessful");
            System.err.println(eee.toString());
        }

        try{
            String show = "select * from Plane";
            PreparedStatement pStatement = connection.prepareStatement(show);
            connection.setAutoCommit(false);
            resultSet = pStatement.executeQuery();
            connection.commit();
            while(resultSet.next())
            {
                System.out.print(resultSet.getString(1) + " ");
                System.out.print(resultSet.getString(2) + " ");
                System.out.print(resultSet.getString(3) + " ");
                System.out.print(resultSet.getString(4) + " ");
                System.out.print(resultSet.getString(5) + " ");
                System.out.print(resultSet.getString(6) + "\n");
            }
        }
        catch (Exception se)
        {
            System.err.println(se.toString());
        }
    }

    public void generateManifest(String flightNumber, String flightDate)
    {
        query = "select * from Customer c, Reservation r, Reservation_detail res "+
        "where c.cid = r.cid AND r.reservation_number = res.reservation_number AND res.flight_number = ? AND res.flight_date = to_date('"+flightDate+"', 'DD-MON-YYYY HH24:MI:SS')";
        try{
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setString(1, flightNumber);
            connection.setAutoCommit(false);
            resultSet = pStatement.executeQuery();
            connection.commit();
            while (resultSet.next()) {
                System.out.println("Salutation: "+resultSet.getString(2));
                System.out.println("First Name: "+resultSet.getString(3));
                System.out.println("Last Name: "+resultSet.getString(4));
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

    public void showTable(String table)
    {
        String show = "select * from "+table;
        try{
            PreparedStatement pStatement = connection.prepareStatement(show);
            connection.setAutoCommit(false);
            resultSet = pStatement.executeQuery();
            rsmd = resultSet.getMetaData();
            int colNum = rsmd.getColumnCount();
            while(resultSet.next())
            {
                for(int i = 1; i <= colNum; i++)
                {
                    if(i > 1) System.out.print(", ");
                    String colVal = resultSet.getString(i);
                    System.out.print(colVal);
                }
                System.out.println("");
            }
            connection.commit();
        }
        catch(SQLException e){
            System.out.println("Error: Cannot Query Table "+table);
            e.printStackTrace();
        }
    }
    // public static void main(String[] args) throws SQLException {
    //   // TODO code application logic here
    //   AdministratorInterface app = new AdministratorInterface();
    //
    // }

}
