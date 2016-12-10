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

		//ccpp.addCustomer("John", "Johnson", "1234152512341234", "APR-2020", "Ridley st", "Lancaster", "PA", "1234123234", "john.johnson@gmail.com");
		//ccpp.showCustomer("John", "Johnson");
		//ccpp.findPrice("PIT", "LAX");
		//ccpp.findRoutes("PIT", "LAX");
		//ccpp.findRoutesAirlines("PIT", "LAX", "Delta Air Lines");
		//ccpp.findRoutesDate("JFK", "LON", "S");
		//ccpp.findRoutesDateAirline("JFK", "LON", "S", "Jet Blue");
		// ccpp.findReservation("00199");
		// ccpp.buyReservation("00199");

        AdministratorInterface aapp = new AdministratorInterface(connection);

        // Erase Database
        answer = input.readLine("Begin? (Y): ");
        if(answer.toUpperCase().compareTo("Y") == 0)
        {
            System.out.println("Erasing Database");
            aapp.eraseDB();
        }

        // Load Airline Info
        answer = input.readLine("Continue? (Y): ");
        if(answer.toUpperCase().compareTo("Y") == 0)
        {
            System.out.println("Loading Airline Info");
            aapp.loadAirline("loadairline.csv");
            // aapp.showTable("Airline");
        }

        // Load Plane Info
        answer = input.readLine("Continue? (Y): ");
        if(answer.toUpperCase().compareTo("Y") == 0)
        {
            System.out.println("Loading Plane Info");
            aapp.loadPlane("loadplane.csv");
            // aapp.showTable("Plane");
        }

        // Load Flight Schedule Info
        answer = input.readLine("Continue? (Y): ");
        if(answer.toUpperCase().compareTo("Y") == 0)
        {
            System.out.println("Loading Flight Schedule");
            aapp.loadSchedule("loadschedule.csv");
            // aapp.showTable("Flight");
        }

        // Load Pricing Info
        answer = input.readLine("Continue? (Y): ");
        if(answer.toUpperCase().compareTo("Y") == 0)
        {
            System.out.println("Loading Price Info");
            aapp.loadPrice("loadpricing.csv");
            // aapp.showTable("Price");
        }

        // Add Customers
        answer = input.readLine("Continue? (Y): ");
        if(answer.toUpperCase().compareTo("Y") == 0)
        {
            System.out.println("Adding Customers");
            ccpp.addCustomer("Mrs", "Reizoirmed", "Camaracer", "0000000000000000", "APR-2009", "000 United Rd", "Pittsburgh", "PA", "1234567000", "RC000@gmail.com");
            ccpp.addCustomer("Mr", "Mjolzoirtron", "Zorksalmard", "0000000000000001", "DEC-2006", "001 United Rd", "Pittsburgh", "PA", "1234567001", "MZ001@gmail.com");
            ccpp.addCustomer("Mr", "Jarcresed", "Morirarc", "0000000000000002", "JUN-2010", "002 United Rd", "Pittsburgh", "PA", "1234567002", "JM002@gmail.com");
            ccpp.addCustomer("Mr", "Cryclomur", "Reiurakd", "0000000000000003", "JUN-2019", "003 United Rd", "Pittsburgh", "PA", "1234567003", "CR003@gmail.com");
            ccpp.addCustomer("Mr", "Crocraer", "Merredmur", "0000000000000004", "NOV-2011", "004 United Rd", "Pittsburgh", "PA", "1234567004", "CM004@gmail.com");
            ccpp.addCustomer("Mrs", "Luksorure", "Azakirder", "0000000000000005", "JAN-2009", "005 United Rd", "Pittsburgh", "PA", "1234567005", "LA005@gmail.com");
            ccpp.addCustomer("Mrs", "Creoarkd", "Drakzerarc", "0000000000000006", "MAY-2001", "006 United Rd", "Pittsburgh", "PA", "1234567006", "CD006@gmail.com");
            ccpp.addCustomer("Mr", "Azakmimed", "Madcramur", "0000000000000007", "APR-2018", "007 United Rd", "Pittsburgh", "PA", "1234567007", "AM007@gmail.com");
            ccpp.addCustomer("Mr", "Lukmider", "Crumaracmed", "0000000000000008", "JUL-2007", "008 United Rd", "Pittsburgh", "PA", "1234567008", "LC008@gmail.com");
            ccpp.addCustomer("Mrs", "Zedcraes", "Zorkmiarc", "0000000000000009", "MAY-2009", "009 United Rd", "Pittsburgh", "PA", "1234567009", "ZZ009@gmail.com");
            ccpp.addCustomer("Mr", "Raylories", "Drakcloes", "0000000000000010", "APR-2016", "010 United Rd", "Pittsburgh", "PA", "1234567010", "RD010@gmail.com");
            ccpp.addCustomer("Mrs", "Mrokmaracer", "Caclomed", "0000000000000011", "DEC-2018", "011 United Rd", "Pittsburgh", "PA", "1234567011", "MC011@gmail.com");
            ccpp.addCustomer("Mrs", "Krsalmarcred", "Mrokmurzur", "0000000000000012", "JAN-2016", "012 United Rd", "Pittsburgh", "PA", "1234567012", "KM012@gmail.com");
            ccpp.addCustomer("Mr", "Reimurzur", "Breurakzur", "0000000000000013", "JAN-2011", "013 United Rd", "Pittsburgh", "PA", "1234567013", "RB013@gmail.com");
            ccpp.addCustomer("Mr", "Zorkmiark", "Croarkes", "0000000000000014", "AUG-2014", "014 United Rd", "Pittsburgh", "PA", "1234567014", "ZC014@gmail.com");
            ccpp.addCustomer("Mrs", "Krmurtron", "Ramiries", "0000000000000015", "APR-2010", "015 United Rd", "Pittsburgh", "PA", "1234567015", "KR015@gmail.com");
            ccpp.addCustomer("Mrs", "Morsortron", "Azurredmur", "0000000000000016", "JUN-2016", "016 United Rd", "Pittsburgh", "PA", "1234567016", "MA016@gmail.com");
            ccpp.addCustomer("Mrs", "Cacrad", "Zursalmarder", "0000000000000017", "MAY-2001", "017 United Rd", "Pittsburgh", "PA", "1234567017", "CZ017@gmail.com");
            ccpp.addCustomer("Mr", "Crycraarc", "Azakairarc", "0000000000000018", "JAN-2010", "018 United Rd", "Pittsburgh", "PA", "1234567018", "CA018@gmail.com");
            ccpp.addCustomer("Mrs", "Zorkzoirtron", "Raires", "0000000000000019", "APR-2015", "019 United Rd", "Pittsburgh", "PA", "1234567019", "ZR019@gmail.com");
            ccpp.addCustomer("Mrs", "Crureder", "Zedmaracer", "0000000000000020", "OCT-2009", "020 United Rd", "Pittsburgh", "PA", "1234567020", "CZ020@gmail.com");
            ccpp.addCustomer("Mrs", "Cameezur", "Rayirark", "0000000000000021", "AUG-2001", "021 United Rd", "Pittsburgh", "PA", "1234567021", "CR021@gmail.com");
            ccpp.addCustomer("Mr", "Morzerzur", "Raymurarc", "0000000000000022", "OCT-2009", "022 United Rd", "Pittsburgh", "PA", "1234567022", "MR022@gmail.com");
            ccpp.addCustomer("Mr", "Zorkcresarc", "Creocrescred", "0000000000000023", "OCT-2010", "023 United Rd", "Pittsburgh", "PA", "1234567023", "ZC023@gmail.com");
            ccpp.addCustomer("Mr", "Cauraktron", "Azurzerark", "0000000000000024", "NOV-2000", "024 United Rd", "Pittsburgh", "PA", "1234567024", "CA024@gmail.com");
            ccpp.addCustomer("Mr", "Camaracarc", "Mrokcresmed", "0000000000000025", "JUL-2015", "025 United Rd", "Pittsburgh", "PA", "1234567025", "CM025@gmail.com");
            ccpp.addCustomer("Mr", "Caurakarc", "Morzoires", "0000000000000026", "APR-2016", "026 United Rd", "Pittsburgh", "PA", "1234567026", "CM026@gmail.com");
            ccpp.addCustomer("Mrs", "Azurmurer", "Raysormur", "0000000000000027", "JAN-2005", "027 United Rd", "Pittsburgh", "PA", "1234567027", "AR027@gmail.com");
            ccpp.addCustomer("Mr", "Cazered", "Crourakcred", "0000000000000028", "DEC-2018", "028 United Rd", "Pittsburgh", "PA", "1234567028", "CC028@gmail.com");
            ccpp.addCustomer("Mrs", "Reimaracer", "Lukloricred", "0000000000000029", "APR-2002", "029 United Rd", "Pittsburgh", "PA", "1234567029", "RL029@gmail.com");
            ccpp.addCustomer("Mrs", "Mararcmed", "Azakcramur", "0000000000000030", "APR-2004", "030 United Rd", "Pittsburgh", "PA", "1234567030", "MA030@gmail.com");
            ccpp.addCustomer("Mrs", "Azakmiriark", "Drakairure", "0000000000000031", "MAY-2012", "031 United Rd", "Pittsburgh", "PA", "1234567031", "AD031@gmail.com");
            ccpp.addCustomer("Mr", "Zedmurzur", "Creoairmed", "0000000000000032", "NOV-2008", "032 United Rd", "Pittsburgh", "PA", "1234567032", "ZC032@gmail.com");
            ccpp.addCustomer("Mr", "Mercraark", "Zedmirizur", "0000000000000033", "AUG-2007", "033 United Rd", "Pittsburgh", "PA", "1234567033", "MZ033@gmail.com");
            ccpp.addCustomer("Mrs", "Crymaraced", "Racloure", "0000000000000034", "JUL-2014", "034 United Rd", "Pittsburgh", "PA", "1234567034", "CR034@gmail.com");
            ccpp.addCustomer("Mrs", "Brezoirmed", "Jagmiriarc", "0000000000000035", "AUG-2012", "035 United Rd", "Pittsburgh", "PA", "1234567035", "BJ035@gmail.com");
            ccpp.addCustomer("Mr", "Mjollorier", "Crymirider", "0000000000000036", "APR-2005", "036 United Rd", "Pittsburgh", "PA", "1234567036", "MC036@gmail.com");
            ccpp.addCustomer("Mrs", "Creoredder", "Drakcloder", "0000000000000037", "NOV-2005", "037 United Rd", "Pittsburgh", "PA", "1234567037", "CD037@gmail.com");
            ccpp.addCustomer("Mr", "Zorkmiries", "Reicresd", "0000000000000038", "JAN-2009", "038 United Rd", "Pittsburgh", "PA", "1234567038", "ZR038@gmail.com");
            ccpp.addCustomer("Mr", "Lukcraer", "Drakzermed", "0000000000000039", "FEB-2015", "039 United Rd", "Pittsburgh", "PA", "1234567039", "LD039@gmail.com");
            ccpp.addCustomer("Mrs", "Mrokmurer", "Rayurakark", "0000000000000040", "DEC-2000", "040 United Rd", "Pittsburgh", "PA", "1234567040", "MR040@gmail.com");
            ccpp.addCustomer("Mrs", "Azurmirimur", "Drakmurark", "0000000000000041", "MAR-2014", "041 United Rd", "Pittsburgh", "PA", "1234567041", "AD041@gmail.com");
            ccpp.addCustomer("Mr", "Azakcresmed", "Jagcloure", "0000000000000042", "NOV-2015", "042 United Rd", "Pittsburgh", "PA", "1234567042", "AJ042@gmail.com");
            ccpp.addCustomer("Mr", "Jarredcred", "Drakzercred", "0000000000000043", "FEB-2012", "043 United Rd", "Pittsburgh", "PA", "1234567043", "JD043@gmail.com");
            ccpp.addCustomer("Mrs", "Jarcramed", "Jararcarc", "0000000000000044", "MAY-2010", "044 United Rd", "Pittsburgh", "PA", "1234567044", "JJ044@gmail.com");
            ccpp.addCustomer("Mr", "Krzoirder", "Zedredmed", "0000000000000045", "JAN-2001", "045 United Rd", "Pittsburgh", "PA", "1234567045", "KZ045@gmail.com");
            ccpp.addCustomer("Mrs", "Caairer", "Brearkure", "0000000000000046", "NOV-2016", "046 United Rd", "Pittsburgh", "PA", "1234567046", "CB046@gmail.com");
            ccpp.addCustomer("Mr", "Reisalmarure", "Zurird", "0000000000000047", "SEP-2008", "047 United Rd", "Pittsburgh", "PA", "1234567047", "RZ047@gmail.com");
            ccpp.addCustomer("Mrs", "Lukzertron", "Mjolzerzur", "0000000000000048", "AUG-2017", "048 United Rd", "Pittsburgh", "PA", "1234567048", "LM048@gmail.com");
            ccpp.addCustomer("Mrs", "Cruirark", "Bremeetron", "0000000000000049", "SEP-2008", "049 United Rd", "Pittsburgh", "PA", "1234567049", "CB049@gmail.com");
            ccpp.addCustomer("Mrs", "Madcrader", "Lukzerarc", "0000000000000050", "APR-2004", "050 United Rd", "Pittsburgh", "PA", "1234567050", "ML050@gmail.com");
            ccpp.addCustomer("Mrs", "Reiredtron", "Lukarctron", "0000000000000051", "AUG-2019", "051 United Rd", "Pittsburgh", "PA", "1234567051", "RL051@gmail.com");
            ccpp.addCustomer("Mrs", "Drakzeres", "Madsorder", "0000000000000052", "SEP-2009", "052 United Rd", "Pittsburgh", "PA", "1234567052", "DM052@gmail.com");
            ccpp.addCustomer("Mr", "Rayclotron", "Lukmeemed", "0000000000000053", "DEC-2002", "053 United Rd", "Pittsburgh", "PA", "1234567053", "RL053@gmail.com");
            ccpp.addCustomer("Mr", "Crysorarc", "Crysalmard", "0000000000000054", "SEP-2016", "054 United Rd", "Pittsburgh", "PA", "1234567054", "CC054@gmail.com");
            ccpp.addCustomer("Mr", "Mrokmiure", "Creosalmarark", "0000000000000055", "MAR-2018", "055 United Rd", "Pittsburgh", "PA", "1234567055", "MC055@gmail.com");
            ccpp.addCustomer("Mr", "Zorkairder", "Krzoires", "0000000000000056", "MAY-2018", "056 United Rd", "Pittsburgh", "PA", "1234567056", "ZK056@gmail.com");
            ccpp.addCustomer("Mr", "Mersalmares", "Cryreder", "0000000000000057", "SEP-2018", "057 United Rd", "Pittsburgh", "PA", "1234567057", "MC057@gmail.com");
            ccpp.addCustomer("Mrs", "Raarces", "Croarcd", "0000000000000058", "FEB-2007", "058 United Rd", "Pittsburgh", "PA", "1234567058", "RC058@gmail.com");
            ccpp.addCustomer("Mr", "Draksorure", "Zedslamared", "0000000000000059", "JAN-2019", "059 United Rd", "Pittsburgh", "PA", "1234567059", "DZ059@gmail.com");
            ccpp.addCustomer("Mr", "Zedarkark", "Marmeees", "0000000000000060", "NOV-2009", "060 United Rd", "Pittsburgh", "PA", "1234567060", "ZM060@gmail.com");
            ccpp.addCustomer("Mr", "Zurcresmed", "Croredtron", "0000000000000061", "FEB-2007", "061 United Rd", "Pittsburgh", "PA", "1234567061", "ZC061@gmail.com");
            ccpp.addCustomer("Mr", "Crusorder", "Zedmaraczur", "0000000000000062", "SEP-2012", "062 United Rd", "Pittsburgh", "PA", "1234567062", "CZ062@gmail.com");
            ccpp.addCustomer("Mr", "Zedmeeark", "Mjolmirimed", "0000000000000063", "APR-2009", "063 United Rd", "Pittsburgh", "PA", "1234567063", "ZM063@gmail.com");
            ccpp.addCustomer("Mrs", "Zorkzered", "Rayurakmur", "0000000000000064", "MAY-2019", "064 United Rd", "Pittsburgh", "PA", "1234567064", "ZR064@gmail.com");
            ccpp.addCustomer("Mr", "Marmurzur", "Creoredmur", "0000000000000065", "AUG-2017", "065 United Rd", "Pittsburgh", "PA", "1234567065", "MC065@gmail.com");
            ccpp.addCustomer("Mrs", "Krcloer", "Zedmeezur", "0000000000000066", "APR-2002", "066 United Rd", "Pittsburgh", "PA", "1234567066", "KZ066@gmail.com");
            ccpp.addCustomer("Mr", "Zurarcure", "Creourakmur", "0000000000000067", "MAY-2007", "067 United Rd", "Pittsburgh", "PA", "1234567067", "ZC067@gmail.com");
            ccpp.addCustomer("Mrs", "Racraure", "Marmimed", "0000000000000068", "SEP-2014", "068 United Rd", "Pittsburgh", "PA", "1234567068", "RM068@gmail.com");
            ccpp.addCustomer("Mr", "Drakcresarc", "Reimeed", "0000000000000069", "NOV-2004", "069 United Rd", "Pittsburgh", "PA", "1234567069", "DR069@gmail.com");
            ccpp.addCustomer("Mr", "Zedurakes", "Jagzoirer", "0000000000000070", "APR-2013", "070 United Rd", "Pittsburgh", "PA", "1234567070", "ZJ070@gmail.com");
            ccpp.addCustomer("Mr", "Zorksalmarder", "Breurakzur", "0000000000000071", "FEB-2001", "071 United Rd", "Pittsburgh", "PA", "1234567071", "ZB071@gmail.com");
            ccpp.addCustomer("Mrs", "Marzoired", "Raysorder", "0000000000000072", "JAN-2002", "072 United Rd", "Pittsburgh", "PA", "1234567072", "MR072@gmail.com");
            ccpp.addCustomer("Mr", "Morslamarmed", "Cryired", "0000000000000073", "MAR-2012", "073 United Rd", "Pittsburgh", "PA", "1234567073", "MC073@gmail.com");
            ccpp.addCustomer("Mrs", "Caloriark", "Madcreses", "0000000000000074", "MAR-2000", "074 United Rd", "Pittsburgh", "PA", "1234567074", "CM074@gmail.com");
            ccpp.addCustomer("Mr", "Rauraked", "Zedzoirder", "0000000000000075", "JAN-2014", "075 United Rd", "Pittsburgh", "PA", "1234567075", "RZ075@gmail.com");
            ccpp.addCustomer("Mr", "Zorkzoirmed", "Azaksortron", "0000000000000076", "JUL-2010", "076 United Rd", "Pittsburgh", "PA", "1234567076", "ZA076@gmail.com");
            ccpp.addCustomer("Mrs", "Drakzerzur", "Rayarkmur", "0000000000000077", "MAR-2014", "077 United Rd", "Pittsburgh", "PA", "1234567077", "DR077@gmail.com");
            ccpp.addCustomer("Mr", "Krmiries", "Merlorider", "0000000000000078", "NOV-2014", "078 United Rd", "Pittsburgh", "PA", "1234567078", "KM078@gmail.com");
            ccpp.addCustomer("Mr", "Cruarker", "Luksorzur", "0000000000000079", "MAR-2013", "079 United Rd", "Pittsburgh", "PA", "1234567079", "CL079@gmail.com");
            ccpp.addCustomer("Mrs", "Croredder", "Zorklorid", "0000000000000080", "FEB-2005", "080 United Rd", "Pittsburgh", "PA", "1234567080", "CZ080@gmail.com");
            ccpp.addCustomer("Mrs", "Casalmarder", "Mrokzerder", "0000000000000081", "JAN-2002", "081 United Rd", "Pittsburgh", "PA", "1234567081", "CM081@gmail.com");
            ccpp.addCustomer("Mr", "Mrokredd", "Bremaracmur", "0000000000000082", "MAR-2002", "082 United Rd", "Pittsburgh", "PA", "1234567082", "MB082@gmail.com");
            ccpp.addCustomer("Mr", "Zorkirzur", "Zedcramur", "0000000000000083", "MAY-2006", "083 United Rd", "Pittsburgh", "PA", "1234567083", "ZZ083@gmail.com");
            ccpp.addCustomer("Mrs", "Crolorimur", "Croaired", "0000000000000084", "JAN-2004", "084 United Rd", "Pittsburgh", "PA", "1234567084", "CC084@gmail.com");
            ccpp.addCustomer("Mr", "Merarcd", "Zursores", "0000000000000085", "MAR-2002", "085 United Rd", "Pittsburgh", "PA", "1234567085", "MZ085@gmail.com");
            ccpp.addCustomer("Mr", "Jaglorier", "Reireded", "0000000000000086", "APR-2002", "086 United Rd", "Pittsburgh", "PA", "1234567086", "JR086@gmail.com");
            ccpp.addCustomer("Mr", "Camirier", "Mrokmizur", "0000000000000087", "OCT-2017", "087 United Rd", "Pittsburgh", "PA", "1234567087", "CM087@gmail.com");
            ccpp.addCustomer("Mr", "Mjolmier", "Crourakark", "0000000000000088", "APR-2014", "088 United Rd", "Pittsburgh", "PA", "1234567088", "MC088@gmail.com");
            ccpp.addCustomer("Mrs", "Creocreses", "Lukarked", "0000000000000089", "JUN-2001", "089 United Rd", "Pittsburgh", "PA", "1234567089", "CL089@gmail.com");
            ccpp.addCustomer("Mr", "Jagirer", "Jarzerer", "0000000000000090", "JUL-2009", "090 United Rd", "Pittsburgh", "PA", "1234567090", "JJ090@gmail.com");
            ccpp.addCustomer("Mrs", "Cromiries", "Brecreses", "0000000000000091", "OCT-2008", "091 United Rd", "Pittsburgh", "PA", "1234567091", "CB091@gmail.com");
            ccpp.addCustomer("Mrs", "Cruredzur", "Azurmider", "0000000000000092", "DEC-2016", "092 United Rd", "Pittsburgh", "PA", "1234567092", "CA092@gmail.com");
            ccpp.addCustomer("Mrs", "Zedarkmur", "Zorkcresd", "0000000000000093", "JUN-2005", "093 United Rd", "Pittsburgh", "PA", "1234567093", "ZZ093@gmail.com");
            ccpp.addCustomer("Mrs", "Azuraired", "Reiirder", "0000000000000094", "MAR-2001", "094 United Rd", "Pittsburgh", "PA", "1234567094", "AR094@gmail.com");
            ccpp.addCustomer("Mrs", "Jarmaraccred", "Krurakmed", "0000000000000095", "MAY-2010", "095 United Rd", "Pittsburgh", "PA", "1234567095", "JK095@gmail.com");
            ccpp.addCustomer("Mrs", "Drakmeearc", "Drakreder", "0000000000000096", "MAR-2012", "096 United Rd", "Pittsburgh", "PA", "1234567096", "DD096@gmail.com");
            ccpp.addCustomer("Mrs", "Morsalmares", "Morredark", "0000000000000097", "APR-2001", "097 United Rd", "Pittsburgh", "PA", "1234567097", "MM097@gmail.com");
            ccpp.addCustomer("Mr", "Krcloer", "Mjolmiriarc", "0000000000000098", "JAN-2017", "098 United Rd", "Pittsburgh", "PA", "1234567098", "KM098@gmail.com");
            ccpp.addCustomer("Mrs", "Drakmicred", "Marzerure", "0000000000000099", "AUG-2012", "099 United Rd", "Pittsburgh", "PA", "1234567099", "DM099@gmail.com");
        }

        // Show customers
        answer = input.readLine("Continue? (Y): ");
        if(answer.toUpperCase().compareTo("Y") == 0)
        {
            System.out.println("Showing all customers");
            ccpp.showCustomer("Reizoirmed", "Camaracer");
            ccpp.showCustomer("Mjolzoirtron", "Zorksalmard");
            ccpp.showCustomer("Jarcresed", "Morirarc");
            ccpp.showCustomer("Cryclomur", "Reiurakd");
            ccpp.showCustomer("Crocraer", "Merredmur");
            ccpp.showCustomer("Luksorure", "Azakirder");
            ccpp.showCustomer("Creoarkd", "Drakzerarc");
            ccpp.showCustomer("Azakmimed", "Madcramur");
            ccpp.showCustomer("Lukmider", "Crumaracmed");
            ccpp.showCustomer("Zedcraes", "Zorkmiarc");
            ccpp.showCustomer("Raylories", "Drakcloes");
            ccpp.showCustomer("Mrokmaracer", "Caclomed");
            ccpp.showCustomer("Krsalmarcred", "Mrokmurzur");
            ccpp.showCustomer("Reimurzur", "Breurakzur");
            ccpp.showCustomer("Zorkmiark", "Croarkes");
            ccpp.showCustomer("Krmurtron", "Ramiries");
            ccpp.showCustomer("Morsortron", "Azurredmur");
            ccpp.showCustomer("Cacrad", "Zursalmarder");
            ccpp.showCustomer("Crycraarc", "Azakairarc");
            ccpp.showCustomer("Zorkzoirtron", "Raires");
            ccpp.showCustomer("Crureder", "Zedmaracer");
            ccpp.showCustomer("Cameezur", "Rayirark");
            ccpp.showCustomer("Morzerzur", "Raymurarc");
            ccpp.showCustomer("Zorkcresarc", "Creocrescred");
            ccpp.showCustomer("Cauraktron", "Azurzerark");
            ccpp.showCustomer("Camaracarc", "Mrokcresmed");
            ccpp.showCustomer("Caurakarc", "Morzoires");
            ccpp.showCustomer("Azurmurer", "Raysormur");
            ccpp.showCustomer("Cazered", "Crourakcred");
            ccpp.showCustomer("Reimaracer", "Lukloricred");
            ccpp.showCustomer("Mararcmed", "Azakcramur");
            ccpp.showCustomer("Azakmiriark", "Drakairure");
            ccpp.showCustomer("Zedmurzur", "Creoairmed");
            ccpp.showCustomer("Mercraark", "Zedmirizur");
            ccpp.showCustomer("Crymaraced", "Racloure");
            ccpp.showCustomer("Brezoirmed", "Jagmiriarc");
            ccpp.showCustomer("Mjollorier", "Crymirider");
            ccpp.showCustomer("Creoredder", "Drakcloder");
            ccpp.showCustomer("Zorkmiries", "Reicresd");
            ccpp.showCustomer("Lukcraer", "Drakzermed");
            ccpp.showCustomer("Mrokmurer", "Rayurakark");
            ccpp.showCustomer("Azurmirimur", "Drakmurark");
            ccpp.showCustomer("Azakcresmed", "Jagcloure");
            ccpp.showCustomer("Jarredcred", "Drakzercred");
            ccpp.showCustomer("Jarcramed", "Jararcarc");
            ccpp.showCustomer("Krzoirder", "Zedredmed");
            ccpp.showCustomer("Caairer", "Brearkure");
            ccpp.showCustomer("Reisalmarure", "Zurird");
            ccpp.showCustomer("Lukzertron", "Mjolzerzur");
            ccpp.showCustomer("Cruirark", "Bremeetron");
            ccpp.showCustomer("Madcrader", "Lukzerarc");
            ccpp.showCustomer("Reiredtron", "Lukarctron");
            ccpp.showCustomer("Drakzeres", "Madsorder");
            ccpp.showCustomer("Rayclotron", "Lukmeemed");
            ccpp.showCustomer("Crysorarc", "Crysalmard");
            ccpp.showCustomer("Mrokmiure", "Creosalmarark");
            ccpp.showCustomer("Zorkairder", "Krzoires");
            ccpp.showCustomer("Mersalmares", "Cryreder");
            ccpp.showCustomer("Raarces", "Croar");
            ccpp.showCustomer("Draksorure", "Zedslamared");
            ccpp.showCustomer("Zedarkark", "Marmeees");
            ccpp.showCustomer("Zurcresmed", "Croredtron");
            ccpp.showCustomer("Crusorder", "Zedmaraczur");
            ccpp.showCustomer("Zedmeeark", "Mjolmirimed");
            ccpp.showCustomer("Zorkzered", "Rayurakmur");
            ccpp.showCustomer("Marmurzur", "Creoredmur");
            ccpp.showCustomer("Krcloer", "Zedmeezur");
            ccpp.showCustomer("Zurarcure", "Creourakmur");
            ccpp.showCustomer("Racraure", "Marmimed");
            ccpp.showCustomer("Drakcresarc", "Reimeed");
            ccpp.showCustomer("Zedurakes", "Jagzoirer");
            ccpp.showCustomer("Zorksalmarder", "Breurakzur");
            ccpp.showCustomer("Marzoired", "Raysorder");
            ccpp.showCustomer("Morslamarmed", "Cryired");
            ccpp.showCustomer("Caloriark", "Madcreses");
            ccpp.showCustomer("Rauraked", "Zedzoirder");
            ccpp.showCustomer("Zorkzoirmed", "Azaksortron");
            ccpp.showCustomer("Drakzerzur", "Rayarkmur");
            ccpp.showCustomer("Krmiries", "Merlorider");
            ccpp.showCustomer("Cruarker", "Luksorzur");
            ccpp.showCustomer("Croredder", "Zorklorid");
            ccpp.showCustomer("Casalmarder", "Mrokzerder");
            ccpp.showCustomer("Mrokredd", "Bremaracmur");
            ccpp.showCustomer("Zorkirzur", "Zedcramur");
            ccpp.showCustomer("Crolorimur", "Croaired");
            ccpp.showCustomer("Merarcd", "Zursor");
            ccpp.showCustomer("Jaglorier", "Reireded");
            ccpp.showCustomer("Camirier", "Mrokmizur");
            ccpp.showCustomer("Mjolmier", "Crourakark");
            ccpp.showCustomer("Creocreses", "Lukarked");
            ccpp.showCustomer("Jagirer", "Jarzer");
            ccpp.showCustomer("Cromiries", "Brecreses");
            ccpp.showCustomer("Cruredzur", "Azurmider");
            ccpp.showCustomer("Zedarkmur", "Zorkcresd");
            ccpp.showCustomer("Azuraired", "Reiirder");
            ccpp.showCustomer("Jarmaraccred", "Krurakmed");
            ccpp.showCustomer("Drakmeearc", "Drakreder");
            ccpp.showCustomer("Morsalmares", "Morredark");
            ccpp.showCustomer("Krcloer", "Mjolmiriarc");
            ccpp.showCustomer("Drakmicred", "Marzerure");
        }

        // Add Reservations
        answer = input.readLine("Continue? (Y): ");
        if(answer.toUpperCase().compareTo("Y") == 0)
        {
            System.out.println("Adding Reservations");
        }

        //Change existing price
        answer = input.readLine("Continue? (Y): ");
        if(answer.toUpperCase().compareTo("Y") == 0)
        {
            System.out.println("Changing all prices to $1000 for high and $500 for low");
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
        }

        //Generate Passenger Manifest for a specific flight on given date
        answer = input.readLine("Continue? (Y): ");
        if(answer.toUpperCase().compareTo("Y") == 0)
        {
            System.out.println("Generating Passenger manifest for all flights on all dates");
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
        }
        // String table = input.readLine("Please specify a table to display: ");
        // aapp.showTable(table);
        connection.close();
    }
}
