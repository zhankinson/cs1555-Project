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
        Boolean proceed = true;
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

        long startTime = System.currentTimeMillis() / 1000L;

        System.out.println("Erasing Database");
        aapp.eraseDB();
        answer = input.readLine("Continue? (Y): ");
        if(answer.toUpperCase().compareTo("Y") == 0)
        {
            System.out.println("Loading Airline Info");
            aapp.loadAirline("loadariline.csv");
            aapp.showTable("Airline");
        }

        answer = input.readLine("Continue? (Y): ");
        if(answer.toUpperCase().compareTo("Y") == 0)
        {
            System.out.println("Loading Plane Info");
            aapp.loadPlane("loadplane.csv");
            aapp.showTable("Plane");
        }

        answer = input.readLine("Continue? (Y): ");
        if(answer.toUpperCase().compareTo("Y") == 0)
        {
            System.out.println("Loading Flight Schedule");
            aapp.loadSchedule("loadschedule.csv");
            aapp.showTable("Flight");
        }

        answer = input.readLine("Continue? (Y): ");
        if(answer.toUpperCase().compareTo("Y") == 0)
        {
            System.out.println("Loading Price Info");
            aapp.loadPrice("loadpricing.csv");
            aapp.showTable("Price");
        }

        answer = input.readLine("Continue? (Y): ");
        if(answer.toUpperCase().compareTo("Y") == 0)
        {
            System.out.println("Adding Customers");
            ccpp.addCustomer("00000", "Mrs", "Reizoirmed", "Camaracer", "0000000000000000", "APR-2009", "000 United Rd", "Pittsburgh", "PA", "1234567000", "RC000@gmail.com", "00002");
            ccpp.addCustomer("00001", "Mr", "Mjolzoirtron", "Zorksalmard", "0000000000000001", "DEC-2006", "001 United Rd", "Pittsburgh", "PA", "1234567001", "MZ001@gmail.com", "00000");
            ccpp.addCustomer("00002", "Mr", "Jarcresed", "Morirarc", "0000000000000002", "JUN-2010", "002 United Rd", "Pittsburgh", "PA", "1234567002", "JM002@gmail.com", "00009");
            ccpp.addCustomer("00003", "Mr", "Cryclomur", "Reiurakd", "0000000000000003", "JUN-2019", "003 United Rd", "Pittsburgh", "PA", "1234567003", "CR003@gmail.com", "00002");
            ccpp.addCustomer("00004", "Mr", "Crocraer", "Merredmur", "0000000000000004", "NOV-2011", "004 United Rd", "Pittsburgh", "PA", "1234567004", "CM004@gmail.com", "00001");
            ccpp.addCustomer("00005", "Mrs", "Luksorure", "Azakirder", "0000000000000005", "JAN-2009", "005 United Rd", "Pittsburgh", "PA", "1234567005", "LA005@gmail.com", "00002");
            ccpp.addCustomer("00006", "Mrs", "Creoarkd", "Drakzerarc", "0000000000000006", "MAY-2001", "006 United Rd", "Pittsburgh", "PA", "1234567006", "CD006@gmail.com", "00002");
            ccpp.addCustomer("00007", "Mr", "Azakmimed", "Madcramur", "0000000000000007", "APR-2018", "007 United Rd", "Pittsburgh", "PA", "1234567007", "AM007@gmail.com", "00009");
            ccpp.addCustomer("00008", "Mr", "Lukmider", "Crumaracmed", "0000000000000008", "JUL-2007", "008 United Rd", "Pittsburgh", "PA", "1234567008", "LC008@gmail.com", "00004");
            ccpp.addCustomer("00009", "Mrs", "Zedcraes", "Zorkmiarc", "0000000000000009", "MAY-2009", "009 United Rd", "Pittsburgh", "PA", "1234567009", "ZZ009@gmail.com", "00001");
            ccpp.addCustomer("00010", "Mr", "Raylories", "Drakcloes", "0000000000000010", "APR-2016", "010 United Rd", "Pittsburgh", "PA", "1234567010", "RD010@gmail.com", "00004");
            ccpp.addCustomer("00011", "Mrs", "Mrokmaracer", "Caclomed", "0000000000000011", "DEC-2018", "011 United Rd", "Pittsburgh", "PA", "1234567011", "MC011@gmail.com", "00009");
            ccpp.addCustomer("00012", "Mrs", "Krsalmarcred", "Mrokmurzur", "0000000000000012", "JAN-2016", "012 United Rd", "Pittsburgh", "PA", "1234567012", "KM012@gmail.com", "00009");
            ccpp.addCustomer("00013", "Mr", "Reimurzur", "Breurakzur", "0000000000000013", "JAN-2011", "013 United Rd", "Pittsburgh", "PA", "1234567013", "RB013@gmail.com", "00008");
            ccpp.addCustomer("00014", "Mr", "Zorkmiark", "Croarkes", "0000000000000014", "AUG-2014", "014 United Rd", "Pittsburgh", "PA", "1234567014", "ZC014@gmail.com", "00003");
            ccpp.addCustomer("00015", "Mrs", "Krmurtron", "Ramiries", "0000000000000015", "APR-2010", "015 United Rd", "Pittsburgh", "PA", "1234567015", "KR015@gmail.com", "00005");
            ccpp.addCustomer("00016", "Mrs", "Morsortron", "Azurredmur", "0000000000000016", "JUN-2016", "016 United Rd", "Pittsburgh", "PA", "1234567016", "MA016@gmail.com", "00008");
            ccpp.addCustomer("00017", "Mrs", "Cacrad", "Zursalmarder", "0000000000000017", "MAY-2001", "017 United Rd", "Pittsburgh", "PA", "1234567017", "CZ017@gmail.com", "00007");
            ccpp.addCustomer("00018", "Mr", "Crycraarc", "Azakairarc", "0000000000000018", "JAN-2010", "018 United Rd", "Pittsburgh", "PA", "1234567018", "CA018@gmail.com", "00000");
            ccpp.addCustomer("00019", "Mrs", "Zorkzoirtron", "Raires", "0000000000000019", "APR-2015", "019 United Rd", "Pittsburgh", "PA", "1234567019", "ZR019@gmail.com", "00003");
            ccpp.addCustomer("00020", "Mrs", "Crureder", "Zedmaracer", "0000000000000020", "OCT-2009", "020 United Rd", "Pittsburgh", "PA", "1234567020", "CZ020@gmail.com", "00004");
            ccpp.addCustomer("00021", "Mrs", "Cameezur", "Rayirark", "0000000000000021", "AUG-2001", "021 United Rd", "Pittsburgh", "PA", "1234567021", "CR021@gmail.com", "00002");
            ccpp.addCustomer("00022", "Mr", "Morzerzur", "Raymurarc", "0000000000000022", "OCT-2009", "022 United Rd", "Pittsburgh", "PA", "1234567022", "MR022@gmail.com", "00002");
            ccpp.addCustomer("00023", "Mr", "Zorkcresarc", "Creocrescred", "0000000000000023", "OCT-2010", "023 United Rd", "Pittsburgh", "PA", "1234567023", "ZC023@gmail.com", "00002");
            ccpp.addCustomer("00024", "Mr", "Cauraktron", "Azurzerark", "0000000000000024", "NOV-2000", "024 United Rd", "Pittsburgh", "PA", "1234567024", "CA024@gmail.com", "00007");
            ccpp.addCustomer("00025", "Mr", "Camaracarc", "Mrokcresmed", "0000000000000025", "JUL-2015", "025 United Rd", "Pittsburgh", "PA", "1234567025", "CM025@gmail.com", "00009");
            ccpp.addCustomer("00026", "Mr", "Caurakarc", "Morzoires", "0000000000000026", "APR-2016", "026 United Rd", "Pittsburgh", "PA", "1234567026", "CM026@gmail.com", "00009");
            ccpp.addCustomer("00027", "Mrs", "Azurmurer", "Raysormur", "0000000000000027", "JAN-2005", "027 United Rd", "Pittsburgh", "PA", "1234567027", "AR027@gmail.com", "00007");
            ccpp.addCustomer("00028", "Mr", "Cazered", "Crourakcred", "0000000000000028", "DEC-2018", "028 United Rd", "Pittsburgh", "PA", "1234567028", "CC028@gmail.com", "00000");
            ccpp.addCustomer("00029", "Mrs", "Reimaracer", "Lukloricred", "0000000000000029", "APR-2002", "029 United Rd", "Pittsburgh", "PA", "1234567029", "RL029@gmail.com", "00003");
            ccpp.addCustomer("00030", "Mrs", "Mararcmed", "Azakcramur", "0000000000000030", "APR-2004", "030 United Rd", "Pittsburgh", "PA", "1234567030", "MA030@gmail.com", "00004");
            ccpp.addCustomer("00031", "Mrs", "Azakmiriark", "Drakairure", "0000000000000031", "MAY-2012", "031 United Rd", "Pittsburgh", "PA", "1234567031", "AD031@gmail.com", "00003");
            ccpp.addCustomer("00032", "Mr", "Zedmurzur", "Creoairmed", "0000000000000032", "NOV-2008", "032 United Rd", "Pittsburgh", "PA", "1234567032", "ZC032@gmail.com", "00008");
            ccpp.addCustomer("00033", "Mr", "Mercraark", "Zedmirizur", "0000000000000033", "AUG-2007", "033 United Rd", "Pittsburgh", "PA", "1234567033", "MZ033@gmail.com", "00007");
            ccpp.addCustomer("00034", "Mrs", "Crymaraced", "Racloure", "0000000000000034", "JUL-2014", "034 United Rd", "Pittsburgh", "PA", "1234567034", "CR034@gmail.com", "00007");
            ccpp.addCustomer("00035", "Mrs", "Brezoirmed", "Jagmiriarc", "0000000000000035", "AUG-2012", "035 United Rd", "Pittsburgh", "PA", "1234567035", "BJ035@gmail.com", "00002");
            ccpp.addCustomer("00036", "Mr", "Mjollorier", "Crymirider", "0000000000000036", "APR-2005", "036 United Rd", "Pittsburgh", "PA", "1234567036", "MC036@gmail.com", "00001");
            ccpp.addCustomer("00037", "Mrs", "Creoredder", "Drakcloder", "0000000000000037", "NOV-2005", "037 United Rd", "Pittsburgh", "PA", "1234567037", "CD037@gmail.com", "00008");
            ccpp.addCustomer("00038", "Mr", "Zorkmiries", "Reicresd", "0000000000000038", "JAN-2009", "038 United Rd", "Pittsburgh", "PA", "1234567038", "ZR038@gmail.com", "00004");
            ccpp.addCustomer("00039", "Mr", "Lukcraer", "Drakzermed", "0000000000000039", "FEB-2015", "039 United Rd", "Pittsburgh", "PA", "1234567039", "LD039@gmail.com", "00009");
            ccpp.addCustomer("00040", "Mrs", "Mrokmurer", "Rayurakark", "0000000000000040", "DEC-2000", "040 United Rd", "Pittsburgh", "PA", "1234567040", "MR040@gmail.com", "00000");
            ccpp.addCustomer("00041", "Mrs", "Azurmirimur", "Drakmurark", "0000000000000041", "MAR-2014", "041 United Rd", "Pittsburgh", "PA", "1234567041", "AD041@gmail.com", "00007");
            ccpp.addCustomer("00042", "Mr", "Azakcresmed", "Jagcloure", "0000000000000042", "NOV-2015", "042 United Rd", "Pittsburgh", "PA", "1234567042", "AJ042@gmail.com", "00007");
            ccpp.addCustomer("00043", "Mr", "Jarredcred", "Drakzercred", "0000000000000043", "FEB-2012", "043 United Rd", "Pittsburgh", "PA", "1234567043", "JD043@gmail.com", "00008");
            ccpp.addCustomer("00044", "Mrs", "Jarcramed", "Jararcarc", "0000000000000044", "MAY-2010", "044 United Rd", "Pittsburgh", "PA", "1234567044", "JJ044@gmail.com", "00003");
            ccpp.addCustomer("00045", "Mr", "Krzoirder", "Zedredmed", "0000000000000045", "JAN-2001", "045 United Rd", "Pittsburgh", "PA", "1234567045", "KZ045@gmail.com", "00007");
            ccpp.addCustomer("00046", "Mrs", "Caairer", "Brearkure", "0000000000000046", "NOV-2016", "046 United Rd", "Pittsburgh", "PA", "1234567046", "CB046@gmail.com", "00009");
            ccpp.addCustomer("00047", "Mr", "Reisalmarure", "Zurird", "0000000000000047", "SEP-2008", "047 United Rd", "Pittsburgh", "PA", "1234567047", "RZ047@gmail.com", "00000");
            ccpp.addCustomer("00048", "Mrs", "Lukzertron", "Mjolzerzur", "0000000000000048", "AUG-2017", "048 United Rd", "Pittsburgh", "PA", "1234567048", "LM048@gmail.com", "00009");
            ccpp.addCustomer("00049", "Mrs", "Cruirark", "Bremeetron", "0000000000000049", "SEP-2008", "049 United Rd", "Pittsburgh", "PA", "1234567049", "CB049@gmail.com", "00004");
            ccpp.addCustomer("00050", "Mrs", "Madcrader", "Lukzerarc", "0000000000000050", "APR-2004", "050 United Rd", "Pittsburgh", "PA", "1234567050", "ML050@gmail.com", "00005");
            ccpp.addCustomer("00051", "Mrs", "Reiredtron", "Lukarctron", "0000000000000051", "AUG-2019", "051 United Rd", "Pittsburgh", "PA", "1234567051", "RL051@gmail.com", "00005");
            ccpp.addCustomer("00052", "Mrs", "Drakzeres", "Madsorder", "0000000000000052", "SEP-2009", "052 United Rd", "Pittsburgh", "PA", "1234567052", "DM052@gmail.com", "00007");
            ccpp.addCustomer("00053", "Mr", "Rayclotron", "Lukmeemed", "0000000000000053", "DEC-2002", "053 United Rd", "Pittsburgh", "PA", "1234567053", "RL053@gmail.com", "00007");
            ccpp.addCustomer("00054", "Mr", "Crysorarc", "Crysalmard", "0000000000000054", "SEP-2016", "054 United Rd", "Pittsburgh", "PA", "1234567054", "CC054@gmail.com", "00000");
            ccpp.addCustomer("00055", "Mr", "Mrokmiure", "Creosalmarark", "0000000000000055", "MAR-2018", "055 United Rd", "Pittsburgh", "PA", "1234567055", "MC055@gmail.com", "00004");
            ccpp.addCustomer("00056", "Mr", "Zorkairder", "Krzoires", "0000000000000056", "MAY-2018", "056 United Rd", "Pittsburgh", "PA", "1234567056", "ZK056@gmail.com", "00001");
            ccpp.addCustomer("00057", "Mr", "Mersalmares", "Cryreder", "0000000000000057", "SEP-2018", "057 United Rd", "Pittsburgh", "PA", "1234567057", "MC057@gmail.com", "00003");
            ccpp.addCustomer("00058", "Mrs", "Raarces", "Croarcd", "0000000000000058", "FEB-2007", "058 United Rd", "Pittsburgh", "PA", "1234567058", "RC058@gmail.com", "00005");
            ccpp.addCustomer("00059", "Mr", "Draksorure", "Zedslamared", "0000000000000059", "JAN-2019", "059 United Rd", "Pittsburgh", "PA", "1234567059", "DZ059@gmail.com", "00001");
            ccpp.addCustomer("00060", "Mr", "Zedarkark", "Marmeees", "0000000000000060", "NOV-2009", "060 United Rd", "Pittsburgh", "PA", "1234567060", "ZM060@gmail.com", "00008");
            ccpp.addCustomer("00061", "Mr", "Zurcresmed", "Croredtron", "0000000000000061", "FEB-2007", "061 United Rd", "Pittsburgh", "PA", "1234567061", "ZC061@gmail.com", "00004");
            ccpp.addCustomer("00062", "Mr", "Crusorder", "Zedmaraczur", "0000000000000062", "SEP-2012", "062 United Rd", "Pittsburgh", "PA", "1234567062", "CZ062@gmail.com", "00002");
            ccpp.addCustomer("00063", "Mr", "Zedmeeark", "Mjolmirimed", "0000000000000063", "APR-2009", "063 United Rd", "Pittsburgh", "PA", "1234567063", "ZM063@gmail.com", "00008");
            ccpp.addCustomer("00064", "Mrs", "Zorkzered", "Rayurakmur", "0000000000000064", "MAY-2019", "064 United Rd", "Pittsburgh", "PA", "1234567064", "ZR064@gmail.com", "00004");
            ccpp.addCustomer("00065", "Mr", "Marmurzur", "Creoredmur", "0000000000000065", "AUG-2017", "065 United Rd", "Pittsburgh", "PA", "1234567065", "MC065@gmail.com", "00005");
            ccpp.addCustomer("00066", "Mrs", "Krcloer", "Zedmeezur", "0000000000000066", "APR-2002", "066 United Rd", "Pittsburgh", "PA", "1234567066", "KZ066@gmail.com", "00000");
            ccpp.addCustomer("00067", "Mr", "Zurarcure", "Creourakmur", "0000000000000067", "MAY-2007", "067 United Rd", "Pittsburgh", "PA", "1234567067", "ZC067@gmail.com", "00006");
            ccpp.addCustomer("00068", "Mrs", "Racraure", "Marmimed", "0000000000000068", "SEP-2014", "068 United Rd", "Pittsburgh", "PA", "1234567068", "RM068@gmail.com", "00003");
            ccpp.addCustomer("00069", "Mr", "Drakcresarc", "Reimeed", "0000000000000069", "NOV-2004", "069 United Rd", "Pittsburgh", "PA", "1234567069", "DR069@gmail.com", "00005");
            ccpp.addCustomer("00070", "Mr", "Zedurakes", "Jagzoirer", "0000000000000070", "APR-2013", "070 United Rd", "Pittsburgh", "PA", "1234567070", "ZJ070@gmail.com", "00001");
            ccpp.addCustomer("00071", "Mr", "Zorksalmarder", "Breurakzur", "0000000000000071", "FEB-2001", "071 United Rd", "Pittsburgh", "PA", "1234567071", "ZB071@gmail.com", "00006");
            ccpp.addCustomer("00072", "Mrs", "Marzoired", "Raysorder", "0000000000000072", "JAN-2002", "072 United Rd", "Pittsburgh", "PA", "1234567072", "MR072@gmail.com", "00003");
            ccpp.addCustomer("00073", "Mr", "Morslamarmed", "Cryired", "0000000000000073", "MAR-2012", "073 United Rd", "Pittsburgh", "PA", "1234567073", "MC073@gmail.com", "00004");
            ccpp.addCustomer("00074", "Mrs", "Caloriark", "Madcreses", "0000000000000074", "MAR-2000", "074 United Rd", "Pittsburgh", "PA", "1234567074", "CM074@gmail.com", "00001");
            ccpp.addCustomer("00075", "Mr", "Rauraked", "Zedzoirder", "0000000000000075", "JAN-2014", "075 United Rd", "Pittsburgh", "PA", "1234567075", "RZ075@gmail.com", "00008");
            ccpp.addCustomer("00076", "Mr", "Zorkzoirmed", "Azaksortron", "0000000000000076", "JUL-2010", "076 United Rd", "Pittsburgh", "PA", "1234567076", "ZA076@gmail.com", "00000");
            ccpp.addCustomer("00077", "Mrs", "Drakzerzur", "Rayarkmur", "0000000000000077", "MAR-2014", "077 United Rd", "Pittsburgh", "PA", "1234567077", "DR077@gmail.com", "00007");
            ccpp.addCustomer("00078", "Mr", "Krmiries", "Merlorider", "0000000000000078", "NOV-2014", "078 United Rd", "Pittsburgh", "PA", "1234567078", "KM078@gmail.com", "00008");
            ccpp.addCustomer("00079", "Mr", "Cruarker", "Luksorzur", "0000000000000079", "MAR-2013", "079 United Rd", "Pittsburgh", "PA", "1234567079", "CL079@gmail.com", "00002");
            ccpp.addCustomer("00080", "Mrs", "Croredder", "Zorklorid", "0000000000000080", "FEB-2005", "080 United Rd", "Pittsburgh", "PA", "1234567080", "CZ080@gmail.com", "00006");
            ccpp.addCustomer("00081", "Mrs", "Casalmarder", "Mrokzerder", "0000000000000081", "JAN-2002", "081 United Rd", "Pittsburgh", "PA", "1234567081", "CM081@gmail.com", "00002");
            ccpp.addCustomer("00082", "Mr", "Mrokredd", "Bremaracmur", "0000000000000082", "MAR-2002", "082 United Rd", "Pittsburgh", "PA", "1234567082", "MB082@gmail.com", "00001");
            ccpp.addCustomer("00083", "Mr", "Zorkirzur", "Zedcramur", "0000000000000083", "MAY-2006", "083 United Rd", "Pittsburgh", "PA", "1234567083", "ZZ083@gmail.com", "00001");
            ccpp.addCustomer("00084", "Mrs", "Crolorimur", "Croaired", "0000000000000084", "JAN-2004", "084 United Rd", "Pittsburgh", "PA", "1234567084", "CC084@gmail.com", "00006");
            ccpp.addCustomer("00085", "Mr", "Merarcd", "Zursores", "0000000000000085", "MAR-2002", "085 United Rd", "Pittsburgh", "PA", "1234567085", "MZ085@gmail.com", "00005");
            ccpp.addCustomer("00086", "Mr", "Jaglorier", "Reireded", "0000000000000086", "APR-2002", "086 United Rd", "Pittsburgh", "PA", "1234567086", "JR086@gmail.com", "00005");
            ccpp.addCustomer("00087", "Mr", "Camirier", "Mrokmizur", "0000000000000087", "OCT-2017", "087 United Rd", "Pittsburgh", "PA", "1234567087", "CM087@gmail.com", "00008");
            ccpp.addCustomer("00088", "Mr", "Mjolmier", "Crourakark", "0000000000000088", "APR-2014", "088 United Rd", "Pittsburgh", "PA", "1234567088", "MC088@gmail.com", "00001");
            ccpp.addCustomer("00089", "Mrs", "Creocreses", "Lukarked", "0000000000000089", "JUN-2001", "089 United Rd", "Pittsburgh", "PA", "1234567089", "CL089@gmail.com", "00007");
            ccpp.addCustomer("00090", "Mr", "Jagirer", "Jarzerer", "0000000000000090", "JUL-2009", "090 United Rd", "Pittsburgh", "PA", "1234567090", "JJ090@gmail.com", "00008");
            ccpp.addCustomer("00091", "Mrs", "Cromiries", "Brecreses", "0000000000000091", "OCT-2008", "091 United Rd", "Pittsburgh", "PA", "1234567091", "CB091@gmail.com", "00002");
            ccpp.addCustomer("00092", "Mrs", "Cruredzur", "Azurmider", "0000000000000092", "DEC-2016", "092 United Rd", "Pittsburgh", "PA", "1234567092", "CA092@gmail.com", "00001");
            ccpp.addCustomer("00093", "Mrs", "Zedarkmur", "Zorkcresd", "0000000000000093", "JUN-2005", "093 United Rd", "Pittsburgh", "PA", "1234567093", "ZZ093@gmail.com", "00009");
            ccpp.addCustomer("00094", "Mrs", "Azuraired", "Reiirder", "0000000000000094", "MAR-2001", "094 United Rd", "Pittsburgh", "PA", "1234567094", "AR094@gmail.com", "00008");
            ccpp.addCustomer("00095", "Mrs", "Jarmaraccred", "Krurakmed", "0000000000000095", "MAY-2010", "095 United Rd", "Pittsburgh", "PA", "1234567095", "JK095@gmail.com", "00002");
            ccpp.addCustomer("00096", "Mrs", "Drakmeearc", "Drakreder", "0000000000000096", "MAR-2012", "096 United Rd", "Pittsburgh", "PA", "1234567096", "DD096@gmail.com", "00009");
            ccpp.addCustomer("00097", "Mrs", "Morsalmares", "Morredark", "0000000000000097", "APR-2001", "097 United Rd", "Pittsburgh", "PA", "1234567097", "MM097@gmail.com", "00002");
            ccpp.addCustomer("00098", "Mr", "Krcloer", "Mjolmiriarc", "0000000000000098", "JAN-2017", "098 United Rd", "Pittsburgh", "PA", "1234567098", "KM098@gmail.com", "00009");
            ccpp.addCustomer("00099", "Mrs", "Drakmicred", "Marzerure", "0000000000000099", "AUG-2012", "099 United Rd", "Pittsburgh", "PA", "1234567099", "DM099@gmail.com", "00000");
            ccpp.addCustomer("00100", "Mr", "Jagzoires", "Crucresure", "0000000000000100", "APR-2007", "100 United Rd", "Pittsburgh", "PA", "1234567100", "JC100@gmail.com", "00009");
            ccpp.addCustomer("00101", "Mr", "Jarloritron", "Reimaraced", "0000000000000101", "APR-2018", "101 United Rd", "Pittsburgh", "PA", "1234567101", "JR101@gmail.com", "00004");
            ccpp.addCustomer("00102", "Mr", "Mjolmies", "Azurlorider", "0000000000000102", "JUL-2013", "102 United Rd", "Pittsburgh", "PA", "1234567102", "MA102@gmail.com", "00002");
            ccpp.addCustomer("00103", "Mr", "Drakzerd", "Breredzur", "0000000000000103", "MAR-2017", "103 United Rd", "Pittsburgh", "PA", "1234567103", "DB103@gmail.com", "00006");
            ccpp.addCustomer("00104", "Mr", "Azakzoirder", "Merarctron", "0000000000000104", "JUN-2015", "104 United Rd", "Pittsburgh", "PA", "1234567104", "AM104@gmail.com", "00008");
            ccpp.addCustomer("00105", "Mrs", "Bremaracark", "Camirizur", "0000000000000105", "JUL-2006", "105 United Rd", "Pittsburgh", "PA", "1234567105", "BC105@gmail.com", "00001");
            ccpp.addCustomer("00106", "Mrs", "Cruzoirarc", "Morreder", "0000000000000106", "DEC-2008", "106 United Rd", "Pittsburgh", "PA", "1234567106", "CM106@gmail.com", "00006");
            ccpp.addCustomer("00107", "Mrs", "Reicloarc", "Reislamarcred", "0000000000000107", "JUN-2005", "107 United Rd", "Pittsburgh", "PA", "1234567107", "RR107@gmail.com", "00007");
            ccpp.addCustomer("00108", "Mrs", "Merurakcred", "Caredarc", "0000000000000108", "DEC-2006", "108 United Rd", "Pittsburgh", "PA", "1234567108", "MC108@gmail.com", "00007");
            ccpp.addCustomer("00109", "Mrs", "Crymurzur", "Lukmier", "0000000000000109", "MAY-2013", "109 United Rd", "Pittsburgh", "PA", "1234567109", "CL109@gmail.com", "00002");
            ccpp.addCustomer("00110", "Mr", "Zedslamares", "Zorkclomed", "0000000000000110", "DEC-2014", "110 United Rd", "Pittsburgh", "PA", "1234567110", "ZZ110@gmail.com", "00008");
            ccpp.addCustomer("00111", "Mr", "Azakarkes", "Marsalmard", "0000000000000111", "JUN-2015", "111 United Rd", "Pittsburgh", "PA", "1234567111", "AM111@gmail.com", "00001");
            ccpp.addCustomer("00112", "Mrs", "Camiriark", "Zedcrestron", "0000000000000112", "AUG-2012", "112 United Rd", "Pittsburgh", "PA", "1234567112", "CZ112@gmail.com", "00004");
            ccpp.addCustomer("00113", "Mr", "Azurarkzur", "Crucrestron", "0000000000000113", "SEP-2008", "113 United Rd", "Pittsburgh", "PA", "1234567113", "AC113@gmail.com", "00000");
            ccpp.addCustomer("00114", "Mrs", "Zurmaraccred", "Krredcred", "0000000000000114", "FEB-2016", "114 United Rd", "Pittsburgh", "PA", "1234567114", "ZK114@gmail.com", "00003");
            ccpp.addCustomer("00115", "Mrs", "Madredzur", "Crysorer", "0000000000000115", "FEB-2017", "115 United Rd", "Pittsburgh", "PA", "1234567115", "MC115@gmail.com", "00007");
            ccpp.addCustomer("00116", "Mrs", "Lukcresed", "Cromiure", "0000000000000116", "NOV-2005", "116 United Rd", "Pittsburgh", "PA", "1234567116", "LC116@gmail.com", "00003");
            ccpp.addCustomer("00117", "Mr", "Crymured", "Camaracarc", "0000000000000117", "APR-2015", "117 United Rd", "Pittsburgh", "PA", "1234567117", "CC117@gmail.com", "00009");
            ccpp.addCustomer("00118", "Mrs", "Jarzerark", "Rayslamarmed", "0000000000000118", "JUL-2019", "118 United Rd", "Pittsburgh", "PA", "1234567118", "JR118@gmail.com", "00001");
            ccpp.addCustomer("00119", "Mrs", "Mjolsormed", "Jarairtron", "0000000000000119", "SEP-2003", "119 United Rd", "Pittsburgh", "PA", "1234567119", "MJ119@gmail.com", "00009");
            ccpp.addCustomer("00120", "Mr", "Reicresder", "Creourakark", "0000000000000120", "SEP-2016", "120 United Rd", "Pittsburgh", "PA", "1234567120", "RC120@gmail.com", "00008");
            ccpp.addCustomer("00121", "Mr", "Marsorure", "Jarsalmarmur", "0000000000000121", "OCT-2011", "121 United Rd", "Pittsburgh", "PA", "1234567121", "MJ121@gmail.com", "00002");
            ccpp.addCustomer("00122", "Mr", "Madmeearc", "Zorkmurark", "0000000000000122", "APR-2014", "122 United Rd", "Pittsburgh", "PA", "1234567122", "MZ122@gmail.com", "00000");
            ccpp.addCustomer("00123", "Mr", "Azursored", "Krsalmarure", "0000000000000123", "JAN-2010", "123 United Rd", "Pittsburgh", "PA", "1234567123", "AK123@gmail.com", "00004");
            ccpp.addCustomer("00124", "Mr", "Bremeeed", "Madreded", "0000000000000124", "JUL-2013", "124 United Rd", "Pittsburgh", "PA", "1234567124", "BM124@gmail.com", "00008");
            ccpp.addCustomer("00125", "Mr", "Merairure", "Raymaracd", "0000000000000125", "JUL-2004", "125 United Rd", "Pittsburgh", "PA", "1234567125", "MR125@gmail.com", "00002");
            ccpp.addCustomer("00126", "Mrs", "Madsord", "Marmaraced", "0000000000000126", "SEP-2012", "126 United Rd", "Pittsburgh", "PA", "1234567126", "MM126@gmail.com", "00006");
            ccpp.addCustomer("00127", "Mrs", "Cruloritron", "Brecloark", "0000000000000127", "SEP-2019", "127 United Rd", "Pittsburgh", "PA", "1234567127", "CB127@gmail.com", "00007");
            ccpp.addCustomer("00128", "Mr", "Bresorcred", "Brezerzur", "0000000000000128", "MAY-2006", "128 United Rd", "Pittsburgh", "PA", "1234567128", "BB128@gmail.com", "00002");
            ccpp.addCustomer("00129", "Mr", "Calorid", "Jarmirimed", "0000000000000129", "JAN-2010", "129 United Rd", "Pittsburgh", "PA", "1234567129", "CJ129@gmail.com", "00001");
            ccpp.addCustomer("00130", "Mrs", "Brecresd", "Marcresed", "0000000000000130", "JUL-2008", "130 United Rd", "Pittsburgh", "PA", "1234567130", "BM130@gmail.com", "00001");
            ccpp.addCustomer("00131", "Mrs", "Merredcred", "Bresord", "0000000000000131", "OCT-2002", "131 United Rd", "Pittsburgh", "PA", "1234567131", "MB131@gmail.com", "00003");
            ccpp.addCustomer("00132", "Mr", "Brezerark", "Reisord", "0000000000000132", "JUN-2004", "132 United Rd", "Pittsburgh", "PA", "1234567132", "BR132@gmail.com", "00007");
            ccpp.addCustomer("00133", "Mr", "Camurd", "Crosormur", "0000000000000133", "AUG-2008", "133 United Rd", "Pittsburgh", "PA", "1234567133", "CC133@gmail.com", "00005");
            ccpp.addCustomer("00134", "Mr", "Jarmeemed", "Crymimur", "0000000000000134", "JUL-2002", "134 United Rd", "Pittsburgh", "PA", "1234567134", "JC134@gmail.com", "00000");
            ccpp.addCustomer("00135", "Mrs", "Creozoirure", "Zurcresmur", "0000000000000135", "JAN-2018", "135 United Rd", "Pittsburgh", "PA", "1234567135", "CZ135@gmail.com", "00004");
            ccpp.addCustomer("00136", "Mrs", "Zorkslamarzur", "Creomaracark", "0000000000000136", "NOV-2012", "136 United Rd", "Pittsburgh", "PA", "1234567136", "ZC136@gmail.com", "00002");
            ccpp.addCustomer("00137", "Mrs", "Madzered", "Merredder", "0000000000000137", "JUL-2014", "137 United Rd", "Pittsburgh", "PA", "1234567137", "MM137@gmail.com", "00000");
            ccpp.addCustomer("00138", "Mrs", "Krarczur", "Azursored", "0000000000000138", "MAY-2008", "138 United Rd", "Pittsburgh", "PA", "1234567138", "KA138@gmail.com", "00007");
            ccpp.addCustomer("00139", "Mr", "Crocloder", "Mercrazur", "0000000000000139", "APR-2004", "139 United Rd", "Pittsburgh", "PA", "1234567139", "CM139@gmail.com", "00005");
            ccpp.addCustomer("00140", "Mrs", "Reizerure", "Morredder", "0000000000000140", "APR-2004", "140 United Rd", "Pittsburgh", "PA", "1234567140", "RM140@gmail.com", "00003");
            ccpp.addCustomer("00141", "Mr", "Rayredtron", "Marirtron", "0000000000000141", "AUG-2017", "141 United Rd", "Pittsburgh", "PA", "1234567141", "RM141@gmail.com", "00002");
            ccpp.addCustomer("00142", "Mrs", "Zorkaired", "Zorkcrazur", "0000000000000142", "FEB-2019", "142 United Rd", "Pittsburgh", "PA", "1234567142", "ZZ142@gmail.com", "00009");
            ccpp.addCustomer("00143", "Mrs", "Zorkmurmed", "Cameeder", "0000000000000143", "JUN-2019", "143 United Rd", "Pittsburgh", "PA", "1234567143", "ZC143@gmail.com", "00003");
            ccpp.addCustomer("00144", "Mr", "Azaklorimur", "Cryurakd", "0000000000000144", "DEC-2010", "144 United Rd", "Pittsburgh", "PA", "1234567144", "AC144@gmail.com", "00007");
            ccpp.addCustomer("00145", "Mrs", "Zurslamarmur", "Mjolreder", "0000000000000145", "AUG-2012", "145 United Rd", "Pittsburgh", "PA", "1234567145", "ZM145@gmail.com", "00003");
            ccpp.addCustomer("00146", "Mrs", "Crumaracd", "Zurslamarure", "0000000000000146", "JUN-2017", "146 United Rd", "Pittsburgh", "PA", "1234567146", "CZ146@gmail.com", "00008");
            ccpp.addCustomer("00147", "Mrs", "Lukzoirure", "Morarcmur", "0000000000000147", "JUN-2009", "147 United Rd", "Pittsburgh", "PA", "1234567147", "LM147@gmail.com", "00000");
            ccpp.addCustomer("00148", "Mrs", "Krsorcred", "Mormid", "0000000000000148", "NOV-2004", "148 United Rd", "Pittsburgh", "PA", "1234567148", "KM148@gmail.com", "00007");
            ccpp.addCustomer("00149", "Mrs", "Cruired", "Mormirid", "0000000000000149", "JUL-2016", "149 United Rd", "Pittsburgh", "PA", "1234567149", "CM149@gmail.com", "00002");
            ccpp.addCustomer("00150", "Mrs", "Morsorzur", "Krsorder", "0000000000000150", "APR-2005", "150 United Rd", "Pittsburgh", "PA", "1234567150", "MK150@gmail.com", "00008");
            ccpp.addCustomer("00151", "Mr", "Zorkreder", "Mrokarkzur", "0000000000000151", "APR-2015", "151 United Rd", "Pittsburgh", "PA", "1234567151", "ZM151@gmail.com", "00000");
            ccpp.addCustomer("00152", "Mrs", "Racratron", "Cryzoirder", "0000000000000152", "APR-2011", "152 United Rd", "Pittsburgh", "PA", "1234567152", "RC152@gmail.com", "00006");
            ccpp.addCustomer("00153", "Mrs", "Jarcresmed", "Mrokarcarc", "0000000000000153", "OCT-2000", "153 United Rd", "Pittsburgh", "PA", "1234567153", "JM153@gmail.com", "00006");
            ccpp.addCustomer("00154", "Mrs", "Cruredd", "Brearkure", "0000000000000154", "MAY-2016", "154 United Rd", "Pittsburgh", "PA", "1234567154", "CB154@gmail.com", "00007");
            ccpp.addCustomer("00155", "Mrs", "Mormirimur", "Morzerder", "0000000000000155", "OCT-2008", "155 United Rd", "Pittsburgh", "PA", "1234567155", "MM155@gmail.com", "00000");
            ccpp.addCustomer("00156", "Mr", "Krarkzur", "Drakloricred", "0000000000000156", "AUG-2000", "156 United Rd", "Pittsburgh", "PA", "1234567156", "KD156@gmail.com", "00007");
            ccpp.addCustomer("00157", "Mr", "Cruarkure", "Creomurcred", "0000000000000157", "SEP-2019", "157 United Rd", "Pittsburgh", "PA", "1234567157", "CC157@gmail.com", "00009");
            ccpp.addCustomer("00158", "Mr", "Brearcder", "Breairmed", "0000000000000158", "AUG-2016", "158 United Rd", "Pittsburgh", "PA", "1234567158", "BB158@gmail.com", "00005");
            ccpp.addCustomer("00159", "Mr", "Creomid", "Zurmiriarc", "0000000000000159", "JAN-2008", "159 United Rd", "Pittsburgh", "PA", "1234567159", "CZ159@gmail.com", "00006");
            ccpp.addCustomer("00160", "Mrs", "Croreder", "Azakarkcred", "0000000000000160", "DEC-2009", "160 United Rd", "Pittsburgh", "PA", "1234567160", "CA160@gmail.com", "00009");
            ccpp.addCustomer("00161", "Mrs", "Azurairmed", "Cryurakmur", "0000000000000161", "JUL-2007", "161 United Rd", "Pittsburgh", "PA", "1234567161", "AC161@gmail.com", "00004");
            ccpp.addCustomer("00162", "Mrs", "Croarcarc", "Raaird", "0000000000000162", "DEC-2013", "162 United Rd", "Pittsburgh", "PA", "1234567162", "CR162@gmail.com", "00005");
            ccpp.addCustomer("00163", "Mr", "Ralorider", "Zedzeres", "0000000000000163", "FEB-2005", "163 United Rd", "Pittsburgh", "PA", "1234567163", "RZ163@gmail.com", "00008");
            ccpp.addCustomer("00164", "Mr", "Raired", "Mrokurakarc", "0000000000000164", "FEB-2013", "164 United Rd", "Pittsburgh", "PA", "1234567164", "RM164@gmail.com", "00006");
            ccpp.addCustomer("00165", "Mr", "Azurzerzur", "Breredmur", "0000000000000165", "SEP-2009", "165 United Rd", "Pittsburgh", "PA", "1234567165", "AB165@gmail.com", "00008");
            ccpp.addCustomer("00166", "Mr", "Zorkcreszur", "Merzoircred", "0000000000000166", "SEP-2003", "166 United Rd", "Pittsburgh", "PA", "1234567166", "ZM166@gmail.com", "00004");
            ccpp.addCustomer("00167", "Mr", "Madmeemed", "Zurcratron", "0000000000000167", "MAR-2010", "167 United Rd", "Pittsburgh", "PA", "1234567167", "MZ167@gmail.com", "00004");
            ccpp.addCustomer("00168", "Mr", "Raymiriure", "Marcraer", "0000000000000168", "FEB-2002", "168 United Rd", "Pittsburgh", "PA", "1234567168", "RM168@gmail.com", "00001");
            ccpp.addCustomer("00169", "Mr", "Zedurakzur", "Morredark", "0000000000000169", "JAN-2007", "169 United Rd", "Pittsburgh", "PA", "1234567169", "ZM169@gmail.com", "00001");
            ccpp.addCustomer("00170", "Mr", "Croairark", "Creomaraced", "0000000000000170", "MAR-2005", "170 United Rd", "Pittsburgh", "PA", "1234567170", "CC170@gmail.com", "00004");
            ccpp.addCustomer("00171", "Mrs", "Mjolurakmur", "Azurzoirmur", "0000000000000171", "APR-2001", "171 United Rd", "Pittsburgh", "PA", "1234567171", "MA171@gmail.com", "00002");
            ccpp.addCustomer("00172", "Mr", "Marredtron", "Drakcraure", "0000000000000172", "MAR-2001", "172 United Rd", "Pittsburgh", "PA", "1234567172", "MD172@gmail.com", "00006");
            ccpp.addCustomer("00173", "Mr", "Azakzoircred", "Zedmaracarc", "0000000000000173", "AUG-2018", "173 United Rd", "Pittsburgh", "PA", "1234567173", "AZ173@gmail.com", "00002");
            ccpp.addCustomer("00174", "Mrs", "Merirarc", "Cacramur", "0000000000000174", "APR-2010", "174 United Rd", "Pittsburgh", "PA", "1234567174", "MC174@gmail.com", "00002");
            ccpp.addCustomer("00175", "Mr", "Breairer", "Crumeearc", "0000000000000175", "OCT-2007", "175 United Rd", "Pittsburgh", "PA", "1234567175", "BC175@gmail.com", "00000");
            ccpp.addCustomer("00176", "Mrs", "Drakmeecred", "Mormeemur", "0000000000000176", "APR-2006", "176 United Rd", "Pittsburgh", "PA", "1234567176", "DM176@gmail.com", "00002");
            ccpp.addCustomer("00177", "Mr", "Jarclod", "Zedcreser", "0000000000000177", "MAR-2014", "177 United Rd", "Pittsburgh", "PA", "1234567177", "JZ177@gmail.com", "00006");
            ccpp.addCustomer("00178", "Mrs", "Mrokredcred", "Lukzoired", "0000000000000178", "MAR-2018", "178 United Rd", "Pittsburgh", "PA", "1234567178", "ML178@gmail.com", "00005");
            ccpp.addCustomer("00179", "Mrs", "Jagzoired", "Zorkmurd", "0000000000000179", "MAR-2001", "179 United Rd", "Pittsburgh", "PA", "1234567179", "JZ179@gmail.com", "00000");
            ccpp.addCustomer("00180", "Mrs", "Azurslamarer", "Crumies", "0000000000000180", "DEC-2013", "180 United Rd", "Pittsburgh", "PA", "1234567180", "AC180@gmail.com", "00008");
            ccpp.addCustomer("00181", "Mrs", "Zorkzoirder", "Zedmizur", "0000000000000181", "FEB-2002", "181 United Rd", "Pittsburgh", "PA", "1234567181", "ZZ181@gmail.com", "00006");
            ccpp.addCustomer("00182", "Mrs", "Crumaracmur", "Merarkure", "0000000000000182", "JUL-2015", "182 United Rd", "Pittsburgh", "PA", "1234567182", "CM182@gmail.com", "00009");
            ccpp.addCustomer("00183", "Mr", "Reimiriure", "Jagmaracd", "0000000000000183", "MAY-2012", "183 United Rd", "Pittsburgh", "PA", "1234567183", "RJ183@gmail.com", "00006");
            ccpp.addCustomer("00184", "Mr", "Ramaracmed", "Azakurakd", "0000000000000184", "FEB-2010", "184 United Rd", "Pittsburgh", "PA", "1234567184", "RA184@gmail.com", "00005");
            ccpp.addCustomer("00185", "Mrs", "Ramiriark", "Drakcraes", "0000000000000185", "FEB-2003", "185 United Rd", "Pittsburgh", "PA", "1234567185", "RD185@gmail.com", "00009");
            ccpp.addCustomer("00186", "Mrs", "Cromier", "Madzerer", "0000000000000186", "OCT-2013", "186 United Rd", "Pittsburgh", "PA", "1234567186", "CM186@gmail.com", "00003");
            ccpp.addCustomer("00187", "Mr", "Crusormur", "Lukcramed", "0000000000000187", "SEP-2007", "187 United Rd", "Pittsburgh", "PA", "1234567187", "CL187@gmail.com", "00003");
            ccpp.addCustomer("00188", "Mrs", "Merairer", "Cruzoirmur", "0000000000000188", "JAN-2002", "188 United Rd", "Pittsburgh", "PA", "1234567188", "MC188@gmail.com", "00001");
            ccpp.addCustomer("00189", "Mrs", "Zedmaracarc", "Cryarkmed", "0000000000000189", "MAR-2008", "189 United Rd", "Pittsburgh", "PA", "1234567189", "ZC189@gmail.com", "00000");
            ccpp.addCustomer("00190", "Mr", "Madslamarzur", "Crumeeure", "0000000000000190", "JUN-2006", "190 United Rd", "Pittsburgh", "PA", "1234567190", "MC190@gmail.com", "00001");
            ccpp.addCustomer("00191", "Mrs", "Reimider", "Azakarcder", "0000000000000191", "JUL-2015", "191 United Rd", "Pittsburgh", "PA", "1234567191", "RA191@gmail.com", "00003");
            ccpp.addCustomer("00192", "Mr", "Madmizur", "Jagmiriarc", "0000000000000192", "JUL-2015", "192 United Rd", "Pittsburgh", "PA", "1234567192", "MJ192@gmail.com", "00000");
            ccpp.addCustomer("00193", "Mr", "Azurmurmed", "Jaguraker", "0000000000000193", "MAY-2000", "193 United Rd", "Pittsburgh", "PA", "1234567193", "AJ193@gmail.com", "00009");
            ccpp.addCustomer("00194", "Mrs", "Jarslamarmur", "Drakmeeer", "0000000000000194", "OCT-2001", "194 United Rd", "Pittsburgh", "PA", "1234567194", "JD194@gmail.com", "00006");
            ccpp.addCustomer("00195", "Mrs", "Zorksalmarzur", "Madlorimed", "0000000000000195", "APR-2017", "195 United Rd", "Pittsburgh", "PA", "1234567195", "ZM195@gmail.com", "00000");
            ccpp.addCustomer("00196", "Mr", "Krzoirzur", "Krzoirmed", "0000000000000196", "JUL-2014", "196 United Rd", "Pittsburgh", "PA", "1234567196", "KK196@gmail.com", "00003");
            ccpp.addCustomer("00197", "Mr", "Krcrader", "Jagredark", "0000000000000197", "MAR-2003", "197 United Rd", "Pittsburgh", "PA", "1234567197", "KJ197@gmail.com", "00008");
            ccpp.addCustomer("00198", "Mrs", "Marlorizur", "Creoairure", "0000000000000198", "AUG-2012", "198 United Rd", "Pittsburgh", "PA", "1234567198", "MC198@gmail.com", "00003");
            ccpp.addCustomer("00199", "Mr", "Marcloure", "Jagcreser", "0000000000000199", "OCT-2012", "199 United Rd", "Pittsburgh", "PA", "1234567199", "MJ199@gmail.com", "00003");
            ccpp.showTable("Customer");
        }

        answer = input.readLine("Continue? (Y): ");
        if(answer.toUpperCase().compareTo("Y") == 0)
        {

        }



        long endTime = System.currentTimeMillis() / 1000L;

        long totalTime = endTime-startTime;
        System.out.println("Finished in: "+totalTime);

        connection.close();
    }
}
