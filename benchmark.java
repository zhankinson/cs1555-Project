import java.util.*;
import java.io.*;
import java.sql.*;

public class benchmark
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
			ccpp.addCustomer("Mr", "Creocresd", "Drakarczur", "0000000000000050", "FEB-2005", "050 United Rd", "Pittsburgh", "PA", "1234567050", "CD050@gmail.com");
			ccpp.addCustomer("Mrs", "Cacraark", "Zedsalmarark", "0000000000000051", "APR-2017", "051 United Rd", "Pittsburgh", "PA", "1234567051", "CZ051@gmail.com");
			ccpp.addCustomer("Mr", "Brezerer", "Mjolmirizur", "0000000000000052", "AUG-2004", "052 United Rd", "Pittsburgh", "PA", "1234567052", "BM052@gmail.com");
			ccpp.addCustomer("Mrs", "Azakslamarer", "Zorkairtron", "0000000000000053", "JAN-2012", "053 United Rd", "Pittsburgh", "PA", "1234567053", "AZ053@gmail.com");
			ccpp.addCustomer("Mrs", "Rasormed", "Creoaird", "0000000000000054", "APR-2011", "054 United Rd", "Pittsburgh", "PA", "1234567054", "RC054@gmail.com");
			ccpp.addCustomer("Mrs", "Zursalmarure", "Lukirarc", "0000000000000055", "JUL-2013", "055 United Rd", "Pittsburgh", "PA", "1234567055", "ZL055@gmail.com");
			ccpp.addCustomer("Mr", "Morarcer", "Reiaircred", "0000000000000056", "APR-2014", "056 United Rd", "Pittsburgh", "PA", "1234567056", "MR056@gmail.com");
			ccpp.addCustomer("Mr", "Krcraark", "Merarczur", "0000000000000057", "JUL-2018", "057 United Rd", "Pittsburgh", "PA", "1234567057", "KM057@gmail.com");
			ccpp.addCustomer("Mrs", "Zurmimed", "Mrokairark", "0000000000000058", "JUN-2006", "058 United Rd", "Pittsburgh", "PA", "1234567058", "ZM058@gmail.com");
			ccpp.addCustomer("Mr", "Morlorimur", "Zorkmiriark", "0000000000000059", "NOV-2001", "059 United Rd", "Pittsburgh", "PA", "1234567059", "MZ059@gmail.com");
			ccpp.addCustomer("Mrs", "Zurredmed", "Zurmaracd", "0000000000000060", "JUL-2003", "060 United Rd", "Pittsburgh", "PA", "1234567060", "ZZ060@gmail.com");
			ccpp.addCustomer("Mrs", "Mrokarkcred", "Crycrad", "0000000000000061", "NOV-2019", "061 United Rd", "Pittsburgh", "PA", "1234567061", "MC061@gmail.com");
			ccpp.addCustomer("Mrs", "Jarsortron", "Zedairder", "0000000000000062", "JUN-2017", "062 United Rd", "Pittsburgh", "PA", "1234567062", "JZ062@gmail.com");
			ccpp.addCustomer("Mrs", "Zurarkzur", "Zedirmur", "0000000000000063", "JUN-2003", "063 United Rd", "Pittsburgh", "PA", "1234567063", "ZZ063@gmail.com");
			ccpp.addCustomer("Mrs", "Azurmiricred", "Azakcloer", "0000000000000064", "OCT-2015", "064 United Rd", "Pittsburgh", "PA", "1234567064", "AA064@gmail.com");
			ccpp.addCustomer("Mrs", "Marmirimed", "Croarczur", "0000000000000065", "NOV-2006", "065 United Rd", "Pittsburgh", "PA", "1234567065", "MC065@gmail.com");
			ccpp.addCustomer("Mrs", "Krurakure", "Merarcure", "0000000000000066", "MAY-2013", "066 United Rd", "Pittsburgh", "PA", "1234567066", "KM066@gmail.com");
			ccpp.addCustomer("Mrs", "Madmimur", "Mjolsalmarcred", "0000000000000067", "MAY-2018", "067 United Rd", "Pittsburgh", "PA", "1234567067", "MM067@gmail.com");
			ccpp.addCustomer("Mr", "Mrokslamard", "Krmied", "0000000000000068", "OCT-2018", "068 United Rd", "Pittsburgh", "PA", "1234567068", "MK068@gmail.com");
			ccpp.addCustomer("Mr", "Bresalmararc", "Krzoired", "0000000000000069", "NOV-2002", "069 United Rd", "Pittsburgh", "PA", "1234567069", "BK069@gmail.com");
			ccpp.addCustomer("Mrs", "Drakcrescred", "Cryirtron", "0000000000000070", "NOV-2008", "070 United Rd", "Pittsburgh", "PA", "1234567070", "DC070@gmail.com");
			ccpp.addCustomer("Mr", "Crulorider", "Zurredder", "0000000000000071", "OCT-2009", "071 United Rd", "Pittsburgh", "PA", "1234567071", "CZ071@gmail.com");
			ccpp.addCustomer("Mrs", "Lukcresarc", "Mjolclocred", "0000000000000072", "MAY-2003", "072 United Rd", "Pittsburgh", "PA", "1234567072", "LM072@gmail.com");
			ccpp.addCustomer("Mrs", "Crucrestron", "Breredark", "0000000000000073", "AUG-2001", "073 United Rd", "Pittsburgh", "PA", "1234567073", "CB073@gmail.com");
			ccpp.addCustomer("Mrs", "Reiloriark", "Morsortron", "0000000000000074", "NOV-2017", "074 United Rd", "Pittsburgh", "PA", "1234567074", "RM074@gmail.com");
            System.out.println("Added 75 Customers\n");
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
			ccpp.showCustomer("Creocresd", "Drakarczur");
			ccpp.showCustomer("Cacraark", "Zedsalmarark");
			ccpp.showCustomer("Brezerer", "Mjolmirizur");
			ccpp.showCustomer("Azakslamarer", "Zorkairtron");
			ccpp.showCustomer("Rasormed", "Creoaird");
			ccpp.showCustomer("Zursalmarure", "Lukirarc");
			ccpp.showCustomer("Morarcer", "Reiaircred");
			ccpp.showCustomer("Krcraark", "Merarczur");
			ccpp.showCustomer("Zurmimed", "Mrokairark");
			ccpp.showCustomer("Morlorimur", "Zorkmiriark");
			ccpp.showCustomer("Zurredmed", "Zurmaracd");
			ccpp.showCustomer("Mrokarkcred", "Crycrad");
			ccpp.showCustomer("Jarsortron", "Zedairder");
			ccpp.showCustomer("Zurarkzur", "Zedirmur");
			ccpp.showCustomer("Azurmiricred", "Azakcloer");
			ccpp.showCustomer("Marmirimed", "Croarczur");
			ccpp.showCustomer("Krurakure", "Merarcure");
			ccpp.showCustomer("Madmimur", "Mjolsalmarcred");
			ccpp.showCustomer("Mrokslamard", "Krmied");
			ccpp.showCustomer("Bresalmararc", "Krzoired");
			ccpp.showCustomer("Drakcrescred", "Cryirtron");
			ccpp.showCustomer("Crulorider", "Zurredder");
			ccpp.showCustomer("Lukcresarc", "Mjolclocred");
			ccpp.showCustomer("Crucrestron", "Breredark");
			ccpp.showCustomer("Reiloriark", "Morsortron");
            System.out.println("Shown 75 Customers\n");
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
            ccpp.addReservation("00000", "000000000000000", "1", "000", "14-NOV-14 03:00:00");
            ccpp.addReservation("00002", "000000000000001", "1", "002", "13-NOV-13 02:00:00");
            ccpp.addReservation("00004", "000000000000002", "1", "004", "14-OCT-14 02:00:00");
            ccpp.addReservation("00006", "000000000000003", "1", "006", "11-JUN-11 01:00:00");
            ccpp.addReservation("00008", "000000000000004", "1", "008", "19-OCT-19 00:00:00");
            ccpp.addReservation("00010", "000000000000005", "1", "010", "05-JUL-05 01:00:00");
            ccpp.addReservation("00012", "000000000000006", "1", "012", "16-DEC-16 00:00:00");
            ccpp.addReservation("00014", "000000000000007", "1", "014", "04-APR-04 00:00:00");
            ccpp.addReservation("00016", "000000000000008", "1", "016", "14-JAN-14 01:00:00");
            ccpp.addReservation("00018", "000000000000009", "1", "018", "03-JAN-03 01:00:00");
            ccpp.addReservation("00020", "000000000000010", "1", "020", "18-JAN-18 03:00:00");
            ccpp.addReservation("00022", "000000000000011", "1", "022", "13-MAR-13 01:00:00");
            ccpp.addReservation("00024", "000000000000012", "1", "024", "06-SEP-06 03:00:00");
            ccpp.addReservation("00026", "000000000000013", "1", "026", "04-JUL-04 01:00:00");
            ccpp.addReservation("00028", "000000000000014", "1", "028", "13-NOV-13 01:00:00");
            ccpp.addReservation("00030", "000000000000015", "1", "030", "16-MAR-16 00:00:00");
            ccpp.addReservation("00032", "000000000000016", "1", "032", "09-JAN-09 03:00:00");
            ccpp.addReservation("00034", "000000000000017", "1", "034", "09-JUN-09 01:00:00");
            ccpp.addReservation("00036", "000000000000018", "1", "036", "15-JUN-15 00:00:00");
            ccpp.addReservation("00038", "000000000000019", "1", "038", "07-DEC-07 01:00:00");
            ccpp.addReservation("00040", "000000000000020", "1", "040", "02-DEC-02 03:00:00");
            ccpp.addReservation("00042", "000000000000021", "1", "042", "04-AUG-04 01:00:00");
            ccpp.addReservation("00044", "000000000000022", "1", "044", "19-JUN-19 00:00:00");
            ccpp.addReservation("00046", "000000000000023", "1", "046", "13-JAN-13 02:00:00");
            ccpp.addReservation("00048", "000000000000024", "1", "048", "05-AUG-05 02:00:00");
            ccpp.addReservation("00050", "000000000000025", "1", "050", "05-FEB-05 00:00:00");
            ccpp.addReservation("00052", "000000000000026", "1", "052", "09-JUN-09 02:00:00");
            ccpp.addReservation("00054", "000000000000027", "1", "054", "10-MAR-10 00:00:00");
            ccpp.addReservation("00056", "000000000000028", "1", "056", "14-JUN-14 01:00:00");
            ccpp.addReservation("00058", "000000000000029", "1", "058", "14-SEP-14 03:00:00");
            ccpp.addReservation("00060", "000000000000030", "1", "060", "06-JAN-06 02:00:00");
            ccpp.addReservation("00062", "000000000000031", "1", "062", "06-JUN-06 02:00:00");
            ccpp.addReservation("00064", "000000000000032", "1", "064", "11-JUL-11 00:00:00");
            ccpp.addReservation("00066", "000000000000033", "1", "066", "06-MAR-06 00:00:00");
            ccpp.addReservation("00068", "000000000000034", "1", "068", "17-AUG-17 02:00:00");
            ccpp.addReservation("00070", "000000000000035", "1", "070", "07-OCT-07 02:00:00");
            ccpp.addReservation("00072", "000000000000036", "1", "072", "06-JAN-06 03:00:00");
            ccpp.addReservation("00074", "000000000000037", "1", "074", "15-FEB-15 03:00:00");
            ccpp.addReservation("00076", "000000000000038", "1", "076", "07-MAR-07 00:00:00");
            ccpp.addReservation("00078", "000000000000039", "1", "078", "04-SEP-04 03:00:00");
            ccpp.addReservation("00080", "000000000000040", "1", "080", "13-FEB-13 01:00:00");
            ccpp.addReservation("00082", "000000000000041", "1", "082", "20-JAN-20 03:00:00");
            ccpp.addReservation("00084", "000000000000042", "1", "084", "10-NOV-10 01:00:00");
            ccpp.addReservation("00086", "000000000000043", "1", "086", "17-JAN-17 01:00:00");
            ccpp.addReservation("00088", "000000000000044", "1", "088", "07-JUN-07 00:00:00");
            ccpp.addReservation("00090", "000000000000045", "1", "090", "16-DEC-16 00:00:00");
            ccpp.addReservation("00092", "000000000000046", "1", "092", "13-AUG-13 02:00:00");
            ccpp.addReservation("00094", "000000000000047", "1", "094", "19-MAY-19 03:00:00");
            ccpp.addReservation("00096", "000000000000048", "1", "096", "08-OCT-08 02:00:00");
            ccpp.addReservation("00098", "000000000000049", "1", "098", "20-SEP-20 02:00:00");
            ccpp.addReservation("00100", "000000000000050", "1", "100", "09-JUL-09 02:00:00");
            ccpp.addReservation("00102", "000000000000051", "1", "102", "10-SEP-10 00:00:00");
            ccpp.addReservation("00104", "000000000000052", "1", "104", "03-OCT-03 02:00:00");
            ccpp.addReservation("00106", "000000000000053", "1", "106", "04-NOV-04 03:00:00");
            ccpp.addReservation("00108", "000000000000054", "1", "108", "18-AUG-18 02:00:00");
            ccpp.addReservation("00110", "000000000000055", "1", "110", "12-JUN-12 02:00:00");
            ccpp.addReservation("00112", "000000000000056", "1", "112", "10-FEB-10 02:00:00");
            ccpp.addReservation("00114", "000000000000057", "1", "114", "18-APR-18 01:00:00");
            ccpp.addReservation("00116", "000000000000058", "1", "116", "13-SEP-13 02:00:00");
            ccpp.addReservation("00118", "000000000000059", "1", "118", "09-FEB-09 03:00:00");
            ccpp.addReservation("00120", "000000000000060", "1", "120", "20-NOV-20 01:00:00");
            ccpp.addReservation("00122", "000000000000061", "1", "122", "17-NOV-17 00:00:00");
            ccpp.addReservation("00124", "000000000000062", "1", "124", "15-MAR-15 00:00:00");
            ccpp.addReservation("00126", "000000000000063", "1", "126", "20-JAN-20 02:00:00");
            ccpp.addReservation("00128", "000000000000064", "1", "128", "02-NOV-02 00:00:00");
            ccpp.addReservation("00130", "000000000000065", "1", "130", "18-MAY-18 03:00:00");
            ccpp.addReservation("00132", "000000000000066", "1", "132", "15-JUL-15 01:00:00");
            ccpp.addReservation("00134", "000000000000067", "1", "134", "10-JUL-10 00:00:00");
            ccpp.addReservation("00136", "000000000000068", "1", "136", "14-MAR-14 00:00:00");
            ccpp.addReservation("00138", "000000000000069", "1", "138", "17-JAN-17 01:00:00");
            ccpp.addReservation("00140", "000000000000070", "1", "140", "14-AUG-14 01:00:00");
            ccpp.addReservation("00142", "000000000000071", "1", "142", "15-JUL-15 01:00:00");
            ccpp.addReservation("00144", "000000000000072", "1", "144", "19-FEB-19 03:00:00");
            ccpp.addReservation("00146", "000000000000073", "1", "146", "15-MAR-15 02:00:00");
            ccpp.addReservation("00148", "000000000000074", "1", "148", "19-JUN-19 00:00:00");
            ccpp.addReservation("00150", "000000000000075", "1", "150", "08-JAN-08 01:00:00");
            ccpp.addReservation("00152", "000000000000076", "1", "152", "18-NOV-18 00:00:00");
            ccpp.addReservation("00154", "000000000000077", "1", "154", "13-FEB-13 02:00:00");
            ccpp.addReservation("00156", "000000000000078", "1", "156", "18-JUL-18 03:00:00");
            ccpp.addReservation("00158", "000000000000079", "1", "158", "14-OCT-14 02:00:00");
            ccpp.addReservation("00160", "000000000000080", "1", "160", "17-JAN-17 01:00:00");
            ccpp.addReservation("00162", "000000000000081", "1", "162", "20-AUG-20 03:00:00");
            ccpp.addReservation("00164", "000000000000082", "1", "164", "01-OCT-01 00:00:00");
            ccpp.addReservation("00166", "000000000000083", "1", "166", "06-JUL-06 01:00:00");
            ccpp.addReservation("00168", "000000000000084", "1", "168", "19-DEC-19 03:00:00");
            ccpp.addReservation("00170", "000000000000085", "1", "170", "12-JAN-12 02:00:00");
            ccpp.addReservation("00172", "000000000000086", "1", "172", "03-MAR-03 00:00:00");
            ccpp.addReservation("00174", "000000000000087", "1", "174", "01-JUN-01 01:00:00");
            ccpp.addReservation("00176", "000000000000088", "1", "176", "03-JAN-03 00:00:00");
            ccpp.addReservation("00178", "000000000000089", "1", "178", "19-JUL-19 00:00:00");
            ccpp.addReservation("00180", "000000000000090", "1", "180", "06-OCT-06 01:00:00");
            ccpp.addReservation("00182", "000000000000091", "1", "182", "15-FEB-15 00:00:00");
            ccpp.addReservation("00184", "000000000000092", "1", "184", "10-DEC-10 01:00:00");
            ccpp.addReservation("00186", "000000000000093", "1", "186", "16-OCT-16 03:00:00");
            ccpp.addReservation("00188", "000000000000094", "1", "188", "17-NOV-17 00:00:00");
            ccpp.addReservation("00190", "000000000000095", "1", "190", "03-MAY-03 02:00:00");
            ccpp.addReservation("00192", "000000000000096", "1", "192", "19-JUL-19 03:00:00");
            ccpp.addReservation("00194", "000000000000097", "1", "194", "11-MAR-11 01:00:00");
            ccpp.addReservation("00196", "000000000000098", "1", "196", "20-NOV-20 00:00:00");
            ccpp.addReservation("00198", "000000000000099", "1", "198", "03-AUG-03 01:00:00");
            System.out.println("Added 100 reservations");
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
            ccpp.buyReservation("11050");
            ccpp.buyReservation("11051");
            ccpp.buyReservation("11052");
            ccpp.buyReservation("11053");
            ccpp.buyReservation("11054");
            ccpp.buyReservation("11055");
            ccpp.buyReservation("11056");
            ccpp.buyReservation("11057");
            ccpp.buyReservation("11058");
            ccpp.buyReservation("11059");
            ccpp.buyReservation("11060");
            ccpp.buyReservation("11061");
            ccpp.buyReservation("11062");
            ccpp.buyReservation("11063");
            ccpp.buyReservation("11064");
            ccpp.buyReservation("11065");
            ccpp.buyReservation("11066");
            ccpp.buyReservation("11067");
            ccpp.buyReservation("11068");
            ccpp.buyReservation("11069");
            ccpp.buyReservation("11070");
            ccpp.buyReservation("11071");
            ccpp.buyReservation("11072");
            ccpp.buyReservation("11073");
            ccpp.buyReservation("11074");
            ccpp.buyReservation("11075");
            ccpp.buyReservation("11076");
            ccpp.buyReservation("11077");
            ccpp.buyReservation("11078");
            ccpp.buyReservation("11079");
            ccpp.buyReservation("11080");
            ccpp.buyReservation("11081");
            ccpp.buyReservation("11082");
            ccpp.buyReservation("11083");
            ccpp.buyReservation("11084");
            ccpp.buyReservation("11085");
            ccpp.buyReservation("11086");
            ccpp.buyReservation("11087");
            ccpp.buyReservation("11088");
            ccpp.buyReservation("11089");
            ccpp.buyReservation("11090");
            ccpp.buyReservation("11091");
            ccpp.buyReservation("11092");
            ccpp.buyReservation("11093");
            ccpp.buyReservation("11094");
            ccpp.buyReservation("11095");
            ccpp.buyReservation("11096");
            ccpp.buyReservation("11097");
            ccpp.buyReservation("11098");
            ccpp.buyReservation("11099");
            System.out.println("Bought 100 tickets");
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
            ccpp.findReservation("11050");
            ccpp.findReservation("11051");
            ccpp.findReservation("11052");
            ccpp.findReservation("11053");
            ccpp.findReservation("11054");
            ccpp.findReservation("11055");
            ccpp.findReservation("11056");
            ccpp.findReservation("11057");
            ccpp.findReservation("11058");
            ccpp.findReservation("11059");
            ccpp.findReservation("11060");
            ccpp.findReservation("11061");
            ccpp.findReservation("11062");
            ccpp.findReservation("11063");
            ccpp.findReservation("11064");
            ccpp.findReservation("11065");
            ccpp.findReservation("11066");
            ccpp.findReservation("11067");
            ccpp.findReservation("11068");
            ccpp.findReservation("11069");
            ccpp.findReservation("11070");
            ccpp.findReservation("11071");
            ccpp.findReservation("11072");
            ccpp.findReservation("11073");
            ccpp.findReservation("11074");
            ccpp.findReservation("11075");
            ccpp.findReservation("11076");
            ccpp.findReservation("11077");
            ccpp.findReservation("11078");
            ccpp.findReservation("11079");
            ccpp.findReservation("11080");
            ccpp.findReservation("11081");
            ccpp.findReservation("11082");
            ccpp.findReservation("11083");
            ccpp.findReservation("11084");
            ccpp.findReservation("11085");
            ccpp.findReservation("11086");
            ccpp.findReservation("11087");
            ccpp.findReservation("11088");
            ccpp.findReservation("11089");
            ccpp.findReservation("11090");
            ccpp.findReservation("11091");
            ccpp.findReservation("11092");
            ccpp.findReservation("11093");
            ccpp.findReservation("11094");
            ccpp.findReservation("11095");
            ccpp.findReservation("11096");
            ccpp.findReservation("11097");
            ccpp.findReservation("11098");
            ccpp.findReservation("11099");
            System.out.println("Shown 100 Reservations");
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
            System.out.println("Generated Manifest for 50 Flights");
        }

        // String table = input.readLine("Please specify a table to display: ");
        // aapp.showTable(table);
        connection.close();
    }
}
