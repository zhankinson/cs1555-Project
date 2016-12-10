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
        }

        // Load Airline Info
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Loading Airline Info");
            aapp.loadAirline("loadairline.csv");
            // aapp.showTable("Airline");
        }

        // Load Plane Info
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Loading Plane Info");
            aapp.loadPlane("loadplane.csv");
            // aapp.showTable("Plane");
        }

        // Load Flight Schedule Info
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Loading Flight Schedule");
            aapp.loadSchedule("loadschedule.csv");
            // aapp.showTable("Flight");
        }

        // Load Pricing Info
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Loading Price Info");
            aapp.loadPrice("loadpricing.csv");
            // aapp.showTable("Price");
        }

        // Add Customers
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Adding Customer");
            ccpp.addCustomer('Mr', 'Morsalmarcred', 'Crumeecred', '0000000000000000', 'JUL-2002', '000 United Rd', 'Pittsburgh', 'PA', '1234567000', 'MC000@gmail.com');
			ccpp.addCustomer('Mr', 'Caurakarc', 'Morurakmur', '0000000000000001', 'AUG-2001', '001 United Rd', 'Pittsburgh', 'PA', '1234567001', 'CM001@gmail.com');
			ccpp.addCustomer('Mr', 'Zedcrazur', 'Azaksalmared', '0000000000000002', 'JUL-2018', '002 United Rd', 'Pittsburgh', 'PA', '1234567002', 'ZA002@gmail.com');
			ccpp.addCustomer('Mrs', 'Drakmures', 'Caclomur', '0000000000000003', 'OCT-2016', '003 United Rd', 'Pittsburgh', 'PA', '1234567003', 'DC003@gmail.com');
			ccpp.addCustomer('Mrs', 'Zurzercred', 'Caarkcred', '0000000000000004', 'DEC-2017', '004 United Rd', 'Pittsburgh', 'PA', '1234567004', 'ZC004@gmail.com');
			ccpp.addCustomer('Mrs', 'Marirder', 'Jagloricred', '0000000000000005', 'AUG-2008', '005 United Rd', 'Pittsburgh', 'PA', '1234567005', 'MJ005@gmail.com');
			ccpp.addCustomer('Mr', 'Rayirzur', 'Zurairure', '0000000000000006', 'OCT-2010', '006 United Rd', 'Pittsburgh', 'PA', '1234567006', 'RZ006@gmail.com');
			ccpp.addCustomer('Mr', 'Cryarctron', 'Mrokslamararc', '0000000000000007', 'NOV-2010', '007 United Rd', 'Pittsburgh', 'PA', '1234567007', 'CM007@gmail.com');
			ccpp.addCustomer('Mr', 'Marlorizur', 'Drakuraker', '0000000000000008', 'FEB-2014', '008 United Rd', 'Pittsburgh', 'PA', '1234567008', 'MD008@gmail.com');
			ccpp.addCustomer('Mrs', 'Azurmaraccred', 'Madcraes', '0000000000000009', 'OCT-2017', '009 United Rd', 'Pittsburgh', 'PA', '1234567009', 'AM009@gmail.com');
			ccpp.addCustomer('Mrs', 'Luklorier', 'Mrokmurmed', '0000000000000010', 'APR-2007', '010 United Rd', 'Pittsburgh', 'PA', '1234567010', 'LM010@gmail.com');
			ccpp.addCustomer('Mrs', 'Madmeetron', 'Jarmirimur', '0000000000000011', 'JUN-2007', '011 United Rd', 'Pittsburgh', 'PA', '1234567011', 'MJ011@gmail.com');
			ccpp.addCustomer('Mr', 'Raclomur', 'Merzoirtron', '0000000000000012', 'OCT-2017', '012 United Rd', 'Pittsburgh', 'PA', '1234567012', 'RM012@gmail.com');
			ccpp.addCustomer('Mr', 'Mermurmur', 'Crocloes', '0000000000000013', 'JUN-2019', '013 United Rd', 'Pittsburgh', 'PA', '1234567013', 'MC013@gmail.com');
			ccpp.addCustomer('Mrs', 'Madarcer', 'Crusorark', '0000000000000014', 'SEP-2002', '014 United Rd', 'Pittsburgh', 'PA', '1234567014', 'MC014@gmail.com');
			ccpp.addCustomer('Mrs', 'Cruurakark', 'Cromurure', '0000000000000015', 'DEC-2012', '015 United Rd', 'Pittsburgh', 'PA', '1234567015', 'CC015@gmail.com');
			ccpp.addCustomer('Mr', 'Zedird', 'Krzercred', '0000000000000016', 'APR-2000', '016 United Rd', 'Pittsburgh', 'PA', '1234567016', 'ZK016@gmail.com');
			ccpp.addCustomer('Mr', 'Zorkmurure', 'Azakredder', '0000000000000017', 'MAR-2018', '017 United Rd', 'Pittsburgh', 'PA', '1234567017', 'ZA017@gmail.com');
			ccpp.addCustomer('Mr', 'Creosalmarark', 'Rasored', '0000000000000018', 'AUG-2003', '018 United Rd', 'Pittsburgh', 'PA', '1234567018', 'CR018@gmail.com');
			ccpp.addCustomer('Mr', 'Caairmur', 'Drakarcmur', '0000000000000019', 'OCT-2019', '019 United Rd', 'Pittsburgh', 'PA', '1234567019', 'CD019@gmail.com');
			ccpp.addCustomer('Mr', 'Reicracred', 'Cryarcer', '0000000000000020', 'OCT-2007', '020 United Rd', 'Pittsburgh', 'PA', '1234567020', 'RC020@gmail.com');
			ccpp.addCustomer('Mrs', 'Mrokurakmur', 'Morlorider', '0000000000000021', 'APR-2013', '021 United Rd', 'Pittsburgh', 'PA', '1234567021', 'MM021@gmail.com');
			ccpp.addCustomer('Mr', 'Morclotron', 'Mermid', '0000000000000022', 'AUG-2008', '022 United Rd', 'Pittsburgh', 'PA', '1234567022', 'MM022@gmail.com');
			ccpp.addCustomer('Mr', 'Creocloed', 'Cruirzur', '0000000000000023', 'AUG-2017', '023 United Rd', 'Pittsburgh', 'PA', '1234567023', 'CC023@gmail.com');
			ccpp.addCustomer('Mrs', 'Crycratron', 'Madcresmed', '0000000000000024', 'JUN-2017', '024 United Rd', 'Pittsburgh', 'PA', '1234567024', 'CM024@gmail.com');
			ccpp.addCustomer('Mrs', 'Jararked', 'Zorkzoirarc', '0000000000000025', 'JUN-2003', '025 United Rd', 'Pittsburgh', 'PA', '1234567025', 'JZ025@gmail.com');
			ccpp.addCustomer('Mrs', 'Mersalmarzur', 'Jagmaracark', '0000000000000026', 'AUG-2007', '026 United Rd', 'Pittsburgh', 'PA', '1234567026', 'MJ026@gmail.com');
			ccpp.addCustomer('Mr', 'Cryarccred', 'Creozoirtron', '0000000000000027', 'JUN-2009', '027 United Rd', 'Pittsburgh', 'PA', '1234567027', 'CC027@gmail.com');
			ccpp.addCustomer('Mrs', 'Racloer', 'Rayirmur', '0000000000000028', 'JUN-2014', '028 United Rd', 'Pittsburgh', 'PA', '1234567028', 'RR028@gmail.com');
			ccpp.addCustomer('Mrs', 'Cromirimur', 'Zorkarkder', '0000000000000029', 'DEC-2012', '029 United Rd', 'Pittsburgh', 'PA', '1234567029', 'CZ029@gmail.com');
			ccpp.addCustomer('Mrs', 'Marired', 'Zurmaraccred', '0000000000000030', 'JUN-2018', '030 United Rd', 'Pittsburgh', 'PA', '1234567030', 'MZ030@gmail.com');
			ccpp.addCustomer('Mrs', 'Crourakmur', 'Cacresder', '0000000000000031', 'DEC-2006', '031 United Rd', 'Pittsburgh', 'PA', '1234567031', 'CC031@gmail.com');
			ccpp.addCustomer('Mrs', 'Jarmeemur', 'Azakaircred', '0000000000000032', 'AUG-2004', '032 United Rd', 'Pittsburgh', 'PA', '1234567032', 'JA032@gmail.com');
			ccpp.addCustomer('Mr', 'Marirzur', 'Jarmied', '0000000000000033', 'APR-2007', '033 United Rd', 'Pittsburgh', 'PA', '1234567033', 'MJ033@gmail.com');
			ccpp.addCustomer('Mr', 'Merzoirtron', 'Mjolreded', '0000000000000034', 'AUG-2014', '034 United Rd', 'Pittsburgh', 'PA', '1234567034', 'MM034@gmail.com');
			ccpp.addCustomer('Mrs', 'Mrokirzur', 'Cruairder', '0000000000000035', 'MAR-2013', '035 United Rd', 'Pittsburgh', 'PA', '1234567035', 'MC035@gmail.com');
			ccpp.addCustomer('Mr', 'Cruirarc', 'Reicresder', '0000000000000036', 'SEP-2017', '036 United Rd', 'Pittsburgh', 'PA', '1234567036', 'CR036@gmail.com');
			ccpp.addCustomer('Mrs', 'Zedmurmur', 'Cromeemed', '0000000000000037', 'MAR-2017', '037 United Rd', 'Pittsburgh', 'PA', '1234567037', 'ZC037@gmail.com');
			ccpp.addCustomer('Mr', 'Zedsorzur', 'Cryurakmur', '0000000000000038', 'FEB-2017', '038 United Rd', 'Pittsburgh', 'PA', '1234567038', 'ZC038@gmail.com');
			ccpp.addCustomer('Mrs', 'Raycloed', 'Crycrazur', '0000000000000039', 'FEB-2006', '039 United Rd', 'Pittsburgh', 'PA', '1234567039', 'RC039@gmail.com');
			ccpp.addCustomer('Mr', 'Morsord', 'Zedslamared', '0000000000000040', 'NOV-2016', '040 United Rd', 'Pittsburgh', 'PA', '1234567040', 'MZ040@gmail.com');
			ccpp.addCustomer('Mr', 'Krmiricred', 'Azakloriark', '0000000000000041', 'DEC-2013', '041 United Rd', 'Pittsburgh', 'PA', '1234567041', 'KA041@gmail.com');
			ccpp.addCustomer('Mrs', 'Azaksalmarark', 'Zorkcresarc', '0000000000000042', 'JUN-2007', '042 United Rd', 'Pittsburgh', 'PA', '1234567042', 'AZ042@gmail.com');
			ccpp.addCustomer('Mr', 'Marmeeer', 'Luksores', '0000000000000043', 'JUN-2010', '043 United Rd', 'Pittsburgh', 'PA', '1234567043', 'ML043@gmail.com');
			ccpp.addCustomer('Mr', 'Krsalmarark', 'Mjolarctron', '0000000000000044', 'SEP-2009', '044 United Rd', 'Pittsburgh', 'PA', '1234567044', 'KM044@gmail.com');
			ccpp.addCustomer('Mrs', 'Madslamarure', 'Zorkmeetron', '0000000000000045', 'MAY-2001', '045 United Rd', 'Pittsburgh', 'PA', '1234567045', 'MZ045@gmail.com');
			ccpp.addCustomer('Mrs', 'Reiarkes', 'Zedzoirzur', '0000000000000046', 'MAR-2017', '046 United Rd', 'Pittsburgh', 'PA', '1234567046', 'RZ046@gmail.com');
			ccpp.addCustomer('Mrs', 'Rayredcred', 'Mercraarc', '0000000000000047', 'SEP-2018', '047 United Rd', 'Pittsburgh', 'PA', '1234567047', 'RM047@gmail.com');
			ccpp.addCustomer('Mr', 'Lukcloes', 'Merarces', '0000000000000048', 'JUL-2010', '048 United Rd', 'Pittsburgh', 'PA', '1234567048', 'LM048@gmail.com');
			ccpp.addCustomer('Mr', 'Raylorizur', 'Morsorarc', '0000000000000049', 'DEC-2015', '049 United Rd', 'Pittsburgh', 'PA', '1234567049', 'RM049@gmail.com');
			ccpp.addCustomer('Mr', 'Creocresd', 'Drakarczur', '0000000000000050', 'FEB-2005', '050 United Rd', 'Pittsburgh', 'PA', '1234567050', 'CD050@gmail.com');
			ccpp.addCustomer('Mrs', 'Cacraark', 'Zedsalmarark', '0000000000000051', 'APR-2017', '051 United Rd', 'Pittsburgh', 'PA', '1234567051', 'CZ051@gmail.com');
			ccpp.addCustomer('Mr', 'Brezerer', 'Mjolmirizur', '0000000000000052', 'AUG-2004', '052 United Rd', 'Pittsburgh', 'PA', '1234567052', 'BM052@gmail.com');
			ccpp.addCustomer('Mrs', 'Azakslamarer', 'Zorkairtron', '0000000000000053', 'JAN-2012', '053 United Rd', 'Pittsburgh', 'PA', '1234567053', 'AZ053@gmail.com');
			ccpp.addCustomer('Mrs', 'Rasormed', 'Creoaird', '0000000000000054', 'APR-2011', '054 United Rd', 'Pittsburgh', 'PA', '1234567054', 'RC054@gmail.com');
			ccpp.addCustomer('Mrs', 'Zursalmarure', 'Lukirarc', '0000000000000055', 'JUL-2013', '055 United Rd', 'Pittsburgh', 'PA', '1234567055', 'ZL055@gmail.com');
			ccpp.addCustomer('Mr', 'Morarcer', 'Reiaircred', '0000000000000056', 'APR-2014', '056 United Rd', 'Pittsburgh', 'PA', '1234567056', 'MR056@gmail.com');
			ccpp.addCustomer('Mr', 'Krcraark', 'Merarczur', '0000000000000057', 'JUL-2018', '057 United Rd', 'Pittsburgh', 'PA', '1234567057', 'KM057@gmail.com');
			ccpp.addCustomer('Mrs', 'Zurmimed', 'Mrokairark', '0000000000000058', 'JUN-2006', '058 United Rd', 'Pittsburgh', 'PA', '1234567058', 'ZM058@gmail.com');
			ccpp.addCustomer('Mr', 'Morlorimur', 'Zorkmiriark', '0000000000000059', 'NOV-2001', '059 United Rd', 'Pittsburgh', 'PA', '1234567059', 'MZ059@gmail.com');
			ccpp.addCustomer('Mrs', 'Zurredmed', 'Zurmaracd', '0000000000000060', 'JUL-2003', '060 United Rd', 'Pittsburgh', 'PA', '1234567060', 'ZZ060@gmail.com');
			ccpp.addCustomer('Mrs', 'Mrokarkcred', 'Crycrad', '0000000000000061', 'NOV-2019', '061 United Rd', 'Pittsburgh', 'PA', '1234567061', 'MC061@gmail.com');
			ccpp.addCustomer('Mrs', 'Jarsortron', 'Zedairder', '0000000000000062', 'JUN-2017', '062 United Rd', 'Pittsburgh', 'PA', '1234567062', 'JZ062@gmail.com');
			ccpp.addCustomer('Mrs', 'Zurarkzur', 'Zedirmur', '0000000000000063', 'JUN-2003', '063 United Rd', 'Pittsburgh', 'PA', '1234567063', 'ZZ063@gmail.com');
			ccpp.addCustomer('Mrs', 'Azurmiricred', 'Azakcloer', '0000000000000064', 'OCT-2015', '064 United Rd', 'Pittsburgh', 'PA', '1234567064', 'AA064@gmail.com');
			ccpp.addCustomer('Mrs', 'Marmirimed', 'Croarczur', '0000000000000065', 'NOV-2006', '065 United Rd', 'Pittsburgh', 'PA', '1234567065', 'MC065@gmail.com');
			ccpp.addCustomer('Mrs', 'Krurakure', 'Merarcure', '0000000000000066', 'MAY-2013', '066 United Rd', 'Pittsburgh', 'PA', '1234567066', 'KM066@gmail.com');
			ccpp.addCustomer('Mrs', 'Madmimur', 'Mjolsalmarcred', '0000000000000067', 'MAY-2018', '067 United Rd', 'Pittsburgh', 'PA', '1234567067', 'MM067@gmail.com');
			ccpp.addCustomer('Mr', 'Mrokslamard', 'Krmied', '0000000000000068', 'OCT-2018', '068 United Rd', 'Pittsburgh', 'PA', '1234567068', 'MK068@gmail.com');
			ccpp.addCustomer('Mr', 'Bresalmararc', 'Krzoired', '0000000000000069', 'NOV-2002', '069 United Rd', 'Pittsburgh', 'PA', '1234567069', 'BK069@gmail.com');
			ccpp.addCustomer('Mrs', 'Drakcrescred', 'Cryirtron', '0000000000000070', 'NOV-2008', '070 United Rd', 'Pittsburgh', 'PA', '1234567070', 'DC070@gmail.com');
			ccpp.addCustomer('Mr', 'Crulorider', 'Zurredder', '0000000000000071', 'OCT-2009', '071 United Rd', 'Pittsburgh', 'PA', '1234567071', 'CZ071@gmail.com');
			ccpp.addCustomer('Mrs', 'Lukcresarc', 'Mjolclocred', '0000000000000072', 'MAY-2003', '072 United Rd', 'Pittsburgh', 'PA', '1234567072', 'LM072@gmail.com');
			ccpp.addCustomer('Mrs', 'Crucrestron', 'Breredark', '0000000000000073', 'AUG-2001', '073 United Rd', 'Pittsburgh', 'PA', '1234567073', 'CB073@gmail.com');
			ccpp.addCustomer('Mrs', 'Reiloriark', 'Morsortron', '0000000000000074', 'NOV-2017', '074 United Rd', 'Pittsburgh', 'PA', '1234567074', 'RM074@gmail.com');
			ccpp.addCustomer('Mr', 'Jagmider', 'Mroksalmarmur', '0000000000000075', 'MAR-2000', '075 United Rd', 'Pittsburgh', 'PA', '1234567075', 'JM075@gmail.com');
			ccpp.addCustomer('Mrs', 'Camaraccred', 'Mjolcrescred', '0000000000000076', 'SEP-2002', '076 United Rd', 'Pittsburgh', 'PA', '1234567076', 'CM076@gmail.com');
			ccpp.addCustomer('Mr', 'Cryzermed', 'Creomeetron', '0000000000000077', 'SEP-2012', '077 United Rd', 'Pittsburgh', 'PA', '1234567077', 'CC077@gmail.com');
			ccpp.addCustomer('Mrs', 'Azakmured', 'Mrokmurtron', '0000000000000078', 'AUG-2016', '078 United Rd', 'Pittsburgh', 'PA', '1234567078', 'AM078@gmail.com');
			ccpp.addCustomer('Mr', 'Creosored', 'Morredark', '0000000000000079', 'JUL-2006', '079 United Rd', 'Pittsburgh', 'PA', '1234567079', 'CM079@gmail.com');
			ccpp.addCustomer('Mrs', 'Crusalmarure', 'Azakslamartron', '0000000000000080', 'MAR-2012', '080 United Rd', 'Pittsburgh', 'PA', '1234567080', 'CA080@gmail.com');
			ccpp.addCustomer('Mrs', 'Creoaires', 'Breslamartron', '0000000000000081', 'SEP-2017', '081 United Rd', 'Pittsburgh', 'PA', '1234567081', 'CB081@gmail.com');
			ccpp.addCustomer('Mrs', 'Azakarczur', 'Zurcloed', '0000000000000082', 'MAR-2019', '082 United Rd', 'Pittsburgh', 'PA', '1234567082', 'AZ082@gmail.com');
			ccpp.addCustomer('Mr', 'Rasalmarure', 'Crumeetron', '0000000000000083', 'OCT-2003', '083 United Rd', 'Pittsburgh', 'PA', '1234567083', 'RC083@gmail.com');
			ccpp.addCustomer('Mr', 'Reimiarc', 'Drakmeees', '0000000000000084', 'FEB-2004', '084 United Rd', 'Pittsburgh', 'PA', '1234567084', 'RD084@gmail.com');
			ccpp.addCustomer('Mr', 'Mroklorid', 'Rayirarc', '0000000000000085', 'JUN-2009', '085 United Rd', 'Pittsburgh', 'PA', '1234567085', 'MR085@gmail.com');
			ccpp.addCustomer('Mrs', 'Mrokcramur', 'Mersalmartron', '0000000000000086', 'APR-2018', '086 United Rd', 'Pittsburgh', 'PA', '1234567086', 'MM086@gmail.com');
			ccpp.addCustomer('Mrs', 'Mjolarkark', 'Marzoircred', '0000000000000087', 'AUG-2018', '087 United Rd', 'Pittsburgh', 'PA', '1234567087', 'MM087@gmail.com');
			ccpp.addCustomer('Mrs', 'Mormeezur', 'Jarsalmared', '0000000000000088', 'MAR-2006', '088 United Rd', 'Pittsburgh', 'PA', '1234567088', 'MJ088@gmail.com');
			ccpp.addCustomer('Mrs', 'Zurcloarc', 'Mjolmirid', '0000000000000089', 'MAR-2005', '089 United Rd', 'Pittsburgh', 'PA', '1234567089', 'ZM089@gmail.com');
			ccpp.addCustomer('Mr', 'Zurslamarder', 'Marslamararc', '0000000000000090', 'DEC-2005', '090 United Rd', 'Pittsburgh', 'PA', '1234567090', 'ZM090@gmail.com');
			ccpp.addCustomer('Mrs', 'Bremaraces', 'Crozertron', '0000000000000091', 'APR-2005', '091 United Rd', 'Pittsburgh', 'PA', '1234567091', 'BC091@gmail.com');
			ccpp.addCustomer('Mr', 'Marmaracer', 'Zedmied', '0000000000000092', 'JUN-2015', '092 United Rd', 'Pittsburgh', 'PA', '1234567092', 'MZ092@gmail.com');
			ccpp.addCustomer('Mr', 'Creomitron', 'Lukurakure', '0000000000000093', 'JUL-2007', '093 United Rd', 'Pittsburgh', 'PA', '1234567093', 'CL093@gmail.com');
			ccpp.addCustomer('Mrs', 'Zedarkmed', 'Azakarctron', '0000000000000094', 'NOV-2011', '094 United Rd', 'Pittsburgh', 'PA', '1234567094', 'ZA094@gmail.com');
			ccpp.addCustomer('Mr', 'Mjolirmur', 'Madairure', '0000000000000095', 'MAR-2010', '095 United Rd', 'Pittsburgh', 'PA', '1234567095', 'MM095@gmail.com');
			ccpp.addCustomer('Mr', 'Mrokarcmur', 'Jagcratron', '0000000000000096', 'JAN-2015', '096 United Rd', 'Pittsburgh', 'PA', '1234567096', 'MJ096@gmail.com');
			ccpp.addCustomer('Mr', 'Brearkarc', 'Madmures', '0000000000000097', 'APR-2003', '097 United Rd', 'Pittsburgh', 'PA', '1234567097', 'BM097@gmail.com');
			ccpp.addCustomer('Mrs', 'Breredarc', 'Crocraure', '0000000000000098', 'SEP-2010', '098 United Rd', 'Pittsburgh', 'PA', '1234567098', 'BC098@gmail.com');
			ccpp.addCustomer('Mrs', 'Crozoired', 'Zurslamarzur', '0000000000000099', 'AUG-2004', '099 United Rd', 'Pittsburgh', 'PA', '1234567099', 'CZ099@gmail.com');
			ccpp.addCustomer('Mrs', 'Reisalmares', 'Azurcreses', '0000000000000100', 'JUL-2003', '100 United Rd', 'Pittsburgh', 'PA', '1234567100', 'RA100@gmail.com');
			ccpp.addCustomer('Mr', 'Jagredarc', 'Merslamarcred', '0000000000000101', 'SEP-2010', '101 United Rd', 'Pittsburgh', 'PA', '1234567101', 'JM101@gmail.com');
			ccpp.addCustomer('Mr', 'Jaglorier', 'Madlorimed', '0000000000000102', 'FEB-2001', '102 United Rd', 'Pittsburgh', 'PA', '1234567102', 'JM102@gmail.com');
			ccpp.addCustomer('Mrs', 'Madmies', 'Merloriure', '0000000000000103', 'MAY-2017', '103 United Rd', 'Pittsburgh', 'PA', '1234567103', 'MM103@gmail.com');
			ccpp.addCustomer('Mrs', 'Bremurzur', 'Jagarced', '0000000000000104', 'JUN-2012', '104 United Rd', 'Pittsburgh', 'PA', '1234567104', 'BJ104@gmail.com');
			ccpp.addCustomer('Mrs', 'Cruzerzur', 'Zorkredtron', '0000000000000105', 'MAY-2009', '105 United Rd', 'Pittsburgh', 'PA', '1234567105', 'CZ105@gmail.com');
			ccpp.addCustomer('Mr', 'Azakmaraced', 'Mjolired', '0000000000000106', 'DEC-2011', '106 United Rd', 'Pittsburgh', 'PA', '1234567106', 'AM106@gmail.com');
			ccpp.addCustomer('Mrs', 'Krirzur', 'Crumaracarc', '0000000000000107', 'MAY-2002', '107 United Rd', 'Pittsburgh', 'PA', '1234567107', 'KC107@gmail.com');
			ccpp.addCustomer('Mrs', 'Croairark', 'Mrokmeees', '0000000000000108', 'APR-2016', '108 United Rd', 'Pittsburgh', 'PA', '1234567108', 'CM108@gmail.com');
			ccpp.addCustomer('Mr', 'Jagirtron', 'Crycresmed', '0000000000000109', 'SEP-2003', '109 United Rd', 'Pittsburgh', 'PA', '1234567109', 'JC109@gmail.com');
			ccpp.addCustomer('Mr', 'Razerer', 'Azursalmarcred', '0000000000000110', 'OCT-2017', '110 United Rd', 'Pittsburgh', 'PA', '1234567110', 'RA110@gmail.com');
			ccpp.addCustomer('Mrs', 'Azakmiried', 'Jarslamarmed', '0000000000000111', 'JUN-2008', '111 United Rd', 'Pittsburgh', 'PA', '1234567111', 'AJ111@gmail.com');
			ccpp.addCustomer('Mr', 'Krmeeure', 'Zurslamarure', '0000000000000112', 'JUN-2017', '112 United Rd', 'Pittsburgh', 'PA', '1234567112', 'KZ112@gmail.com');
			ccpp.addCustomer('Mr', 'Zurmurtron', 'Zurredmed', '0000000000000113', 'NOV-2017', '113 United Rd', 'Pittsburgh', 'PA', '1234567113', 'ZZ113@gmail.com');
			ccpp.addCustomer('Mr', 'Drakmurd', 'Azurirder', '0000000000000114', 'FEB-2017', '114 United Rd', 'Pittsburgh', 'PA', '1234567114', 'DA114@gmail.com');
			ccpp.addCustomer('Mr', 'Raycreser', 'Krirmed', '0000000000000115', 'JUN-2017', '115 United Rd', 'Pittsburgh', 'PA', '1234567115', 'RK115@gmail.com');
			ccpp.addCustomer('Mrs', 'Azakcratron', 'Raloritron', '0000000000000116', 'MAR-2007', '116 United Rd', 'Pittsburgh', 'PA', '1234567116', 'AR116@gmail.com');
			ccpp.addCustomer('Mrs', 'Marclod', 'Marirder', '0000000000000117', 'AUG-2000', '117 United Rd', 'Pittsburgh', 'PA', '1234567117', 'MM117@gmail.com');
			ccpp.addCustomer('Mr', 'Lukzermur', 'Creomaraccred', '0000000000000118', 'JUN-2006', '118 United Rd', 'Pittsburgh', 'PA', '1234567118', 'LC118@gmail.com');
			ccpp.addCustomer('Mrs', 'Cameetron', 'Caarkder', '0000000000000119', 'OCT-2000', '119 United Rd', 'Pittsburgh', 'PA', '1234567119', 'CC119@gmail.com');
			ccpp.addCustomer('Mrs', 'Cryzoirark', 'Lukmurarc', '0000000000000120', 'JUN-2004', '120 United Rd', 'Pittsburgh', 'PA', '1234567120', 'CL120@gmail.com');
			ccpp.addCustomer('Mr', 'Morlorider', 'Mrokarkarc', '0000000000000121', 'DEC-2007', '121 United Rd', 'Pittsburgh', 'PA', '1234567121', 'MM121@gmail.com');
			ccpp.addCustomer('Mr', 'Jagredd', 'Jagmeees', '0000000000000122', 'OCT-2011', '122 United Rd', 'Pittsburgh', 'PA', '1234567122', 'JJ122@gmail.com');
			ccpp.addCustomer('Mr', 'Rayarces', 'Zedmeecred', '0000000000000123', 'DEC-2019', '123 United Rd', 'Pittsburgh', 'PA', '1234567123', 'RZ123@gmail.com');
			ccpp.addCustomer('Mrs', 'Creoarcark', 'Jagzerark', '0000000000000124', 'APR-2005', '124 United Rd', 'Pittsburgh', 'PA', '1234567124', 'CJ124@gmail.com');
			ccpp.addCustomer('Mr', 'Cromeed', 'Crourakure', '0000000000000125', 'APR-2001', '125 United Rd', 'Pittsburgh', 'PA', '1234567125', 'CC125@gmail.com');
			ccpp.addCustomer('Mr', 'Azakcrader', 'Raycresder', '0000000000000126', 'JUN-2014', '126 United Rd', 'Pittsburgh', 'PA', '1234567126', 'AR126@gmail.com');
			ccpp.addCustomer('Mr', 'Creoclomur', 'Jarslamarark', '0000000000000127', 'AUG-2013', '127 United Rd', 'Pittsburgh', 'PA', '1234567127', 'CJ127@gmail.com');
			ccpp.addCustomer('Mrs', 'Krmurmur', 'Creourakure', '0000000000000128', 'FEB-2014', '128 United Rd', 'Pittsburgh', 'PA', '1234567128', 'KC128@gmail.com');
			ccpp.addCustomer('Mrs', 'Rayairarc', 'Jagmurzur', '0000000000000129', 'AUG-2007', '129 United Rd', 'Pittsburgh', 'PA', '1234567129', 'RJ129@gmail.com');
			ccpp.addCustomer('Mrs', 'Jarmaracarc', 'Brecresmed', '0000000000000130', 'JUN-2016', '130 United Rd', 'Pittsburgh', 'PA', '1234567130', 'JB130@gmail.com');
			ccpp.addCustomer('Mr', 'Mrokslamarer', 'Creocraer', '0000000000000131', 'APR-2005', '131 United Rd', 'Pittsburgh', 'PA', '1234567131', 'MC131@gmail.com');
			ccpp.addCustomer('Mr', 'Raycraure', 'Crocresd', '0000000000000132', 'DEC-2008', '132 United Rd', 'Pittsburgh', 'PA', '1234567132', 'RC132@gmail.com');
			ccpp.addCustomer('Mr', 'Mermurcred', 'Krsalmarer', '0000000000000133', 'DEC-2012', '133 United Rd', 'Pittsburgh', 'PA', '1234567133', 'MK133@gmail.com');
			ccpp.addCustomer('Mr', 'Lukirarc', 'Madmaraced', '0000000000000134', 'DEC-2014', '134 United Rd', 'Pittsburgh', 'PA', '1234567134', 'LM134@gmail.com');
			ccpp.addCustomer('Mrs', 'Morurakmur', 'Mersortron', '0000000000000135', 'JUL-2015', '135 United Rd', 'Pittsburgh', 'PA', '1234567135', 'MM135@gmail.com');
			ccpp.addCustomer('Mrs', 'Zursorure', 'Reilorimed', '0000000000000136', 'OCT-2015', '136 United Rd', 'Pittsburgh', 'PA', '1234567136', 'ZR136@gmail.com');
			ccpp.addCustomer('Mrs', 'Drakairmur', 'Mrokarced', '0000000000000137', 'JUL-2013', '137 United Rd', 'Pittsburgh', 'PA', '1234567137', 'DM137@gmail.com');
			ccpp.addCustomer('Mrs', 'Mersalmarmur', 'Zurredcred', '0000000000000138', 'FEB-2000', '138 United Rd', 'Pittsburgh', 'PA', '1234567138', 'MZ138@gmail.com');
			ccpp.addCustomer('Mrs', 'Cruirder', 'Azursalmarure', '0000000000000139', 'JUN-2010', '139 United Rd', 'Pittsburgh', 'PA', '1234567139', 'CA139@gmail.com');
			ccpp.addCustomer('Mrs', 'Bremies', 'Cruslamarcred', '0000000000000140', 'NOV-2008', '140 United Rd', 'Pittsburgh', 'PA', '1234567140', 'BC140@gmail.com');
			ccpp.addCustomer('Mr', 'Zedmurd', 'Bremeeark', '0000000000000141', 'DEC-2016', '141 United Rd', 'Pittsburgh', 'PA', '1234567141', 'ZB141@gmail.com');
			ccpp.addCustomer('Mr', 'Krzoirer', 'Creoired', '0000000000000142', 'SEP-2019', '142 United Rd', 'Pittsburgh', 'PA', '1234567142', 'KC142@gmail.com');
			ccpp.addCustomer('Mr', 'Creomiries', 'Mrokires', '0000000000000143', 'JUL-2009', '143 United Rd', 'Pittsburgh', 'PA', '1234567143', 'CM143@gmail.com');
			ccpp.addCustomer('Mr', 'Krredder', 'Jagsorer', '0000000000000144', 'JUN-2002', '144 United Rd', 'Pittsburgh', 'PA', '1234567144', 'KJ144@gmail.com');
			ccpp.addCustomer('Mr', 'Drakredder', 'Merairder', '0000000000000145', 'JUN-2002', '145 United Rd', 'Pittsburgh', 'PA', '1234567145', 'DM145@gmail.com');
			ccpp.addCustomer('Mrs', 'Breurakder', 'Jagcresure', '0000000000000146', 'AUG-2013', '146 United Rd', 'Pittsburgh', 'PA', '1234567146', 'BJ146@gmail.com');
			ccpp.addCustomer('Mrs', 'Ralorid', 'Rasores', '0000000000000147', 'NOV-2015', '147 United Rd', 'Pittsburgh', 'PA', '1234567147', 'RR147@gmail.com');
			ccpp.addCustomer('Mrs', 'Azakmeezur', 'Rayurakarc', '0000000000000148', 'MAR-2013', '148 United Rd', 'Pittsburgh', 'PA', '1234567148', 'AR148@gmail.com');
			ccpp.addCustomer('Mrs', 'Mrokmiarc', 'Reizerarc', '0000000000000149', 'APR-2017', '149 United Rd', 'Pittsburgh', 'PA', '1234567149', 'MR149@gmail.com');
			ccpp.addCustomer('Mr', 'Krcrazur', 'Zedloriarc', '0000000000000150', 'MAY-2016', '150 United Rd', 'Pittsburgh', 'PA', '1234567150', 'KZ150@gmail.com');
			ccpp.addCustomer('Mr', 'Azurmirimed', 'Jagmaraced', '0000000000000151', 'MAY-2005', '151 United Rd', 'Pittsburgh', 'PA', '1234567151', 'AJ151@gmail.com');
			ccpp.addCustomer('Mr', 'Zedmeezur', 'Cairark', '0000000000000152', 'MAR-2009', '152 United Rd', 'Pittsburgh', 'PA', '1234567152', 'ZC152@gmail.com');
			ccpp.addCustomer('Mr', 'Mrokired', 'Bremied', '0000000000000153', 'JAN-2019', '153 United Rd', 'Pittsburgh', 'PA', '1234567153', 'MB153@gmail.com');
			ccpp.addCustomer('Mr', 'Raymirimur', 'Mersored', '0000000000000154', 'AUG-2006', '154 United Rd', 'Pittsburgh', 'PA', '1234567154', 'RM154@gmail.com');
			ccpp.addCustomer('Mrs', 'Mrokarcer', 'Zedcresure', '0000000000000155', 'NOV-2018', '155 United Rd', 'Pittsburgh', 'PA', '1234567155', 'MZ155@gmail.com');
			ccpp.addCustomer('Mrs', 'Cameeure', 'Cromeeer', '0000000000000156', 'AUG-2019', '156 United Rd', 'Pittsburgh', 'PA', '1234567156', 'CC156@gmail.com');
			ccpp.addCustomer('Mrs', 'Brearcder', 'Marsorark', '0000000000000157', 'AUG-2005', '157 United Rd', 'Pittsburgh', 'PA', '1234567157', 'BM157@gmail.com');
			ccpp.addCustomer('Mrs', 'Jararccred', 'Zorkmaracer', '0000000000000158', 'SEP-2013', '158 United Rd', 'Pittsburgh', 'PA', '1234567158', 'JZ158@gmail.com');
			ccpp.addCustomer('Mr', 'Madclozur', 'Jagarkark', '0000000000000159', 'NOV-2019', '159 United Rd', 'Pittsburgh', 'PA', '1234567159', 'MJ159@gmail.com');
			ccpp.addCustomer('Mr', 'Marslamares', 'Calorider', '0000000000000160', 'DEC-2018', '160 United Rd', 'Pittsburgh', 'PA', '1234567160', 'MC160@gmail.com');
			ccpp.addCustomer('Mr', 'Crymured', 'Zedarker', '0000000000000161', 'NOV-2008', '161 United Rd', 'Pittsburgh', 'PA', '1234567161', 'CZ161@gmail.com');
			ccpp.addCustomer('Mrs', 'Mjolzermur', 'Mermurmed', '0000000000000162', 'JUL-2016', '162 United Rd', 'Pittsburgh', 'PA', '1234567162', 'MM162@gmail.com');
			ccpp.addCustomer('Mrs', 'Caloriarc', 'Ramier', '0000000000000163', 'MAR-2000', '163 United Rd', 'Pittsburgh', 'PA', '1234567163', 'CR163@gmail.com');
			ccpp.addCustomer('Mrs', 'Krarkmed', 'Crucloes', '0000000000000164', 'JUL-2006', '164 United Rd', 'Pittsburgh', 'PA', '1234567164', 'KC164@gmail.com');
			ccpp.addCustomer('Mrs', 'Jagaird', 'Crumaraces', '0000000000000165', 'APR-2006', '165 United Rd', 'Pittsburgh', 'PA', '1234567165', 'JC165@gmail.com');
			ccpp.addCustomer('Mrs', 'Zedzeres', 'Zurcraarc', '0000000000000166', 'AUG-2018', '166 United Rd', 'Pittsburgh', 'PA', '1234567166', 'ZZ166@gmail.com');
			ccpp.addCustomer('Mrs', 'Morarcmur', 'Croird', '0000000000000167', 'AUG-2013', '167 United Rd', 'Pittsburgh', 'PA', '1234567167', 'MC167@gmail.com');
			ccpp.addCustomer('Mr', 'Zorksalmartron', 'Cruzerd', '0000000000000168', 'JUN-2002', '168 United Rd', 'Pittsburgh', 'PA', '1234567168', 'ZC168@gmail.com');
			ccpp.addCustomer('Mrs', 'Jagslamarmed', 'Rairmed', '0000000000000169', 'SEP-2018', '169 United Rd', 'Pittsburgh', 'PA', '1234567169', 'JR169@gmail.com');
			ccpp.addCustomer('Mr', 'Raloriark', 'Cryloricred', '0000000000000170', 'MAR-2016', '170 United Rd', 'Pittsburgh', 'PA', '1234567170', 'RC170@gmail.com');
			ccpp.addCustomer('Mrs', 'Lukzoird', 'Reilorimur', '0000000000000171', 'DEC-2009', '171 United Rd', 'Pittsburgh', 'PA', '1234567171', 'LR171@gmail.com');
			ccpp.addCustomer('Mrs', 'Azurclomur', 'Crysorzur', '0000000000000172', 'MAY-2018', '172 United Rd', 'Pittsburgh', 'PA', '1234567172', 'AC172@gmail.com');
			ccpp.addCustomer('Mr', 'Jararkarc', 'Cruairzur', '0000000000000173', 'DEC-2002', '173 United Rd', 'Pittsburgh', 'PA', '1234567173', 'JC173@gmail.com');
			ccpp.addCustomer('Mrs', 'Cazeres', 'Marlorider', '0000000000000174', 'NOV-2000', '174 United Rd', 'Pittsburgh', 'PA', '1234567174', 'CM174@gmail.com');
			ccpp.addCustomer('Mrs', 'Crozoirzur', 'Lukmaracark', '0000000000000175', 'MAR-2004', '175 United Rd', 'Pittsburgh', 'PA', '1234567175', 'CL175@gmail.com');
			ccpp.addCustomer('Mr', 'Crymeees', 'Krmirid', '0000000000000176', 'MAR-2003', '176 United Rd', 'Pittsburgh', 'PA', '1234567176', 'CK176@gmail.com');
			ccpp.addCustomer('Mrs', 'Reizermed', 'Jarmiriure', '0000000000000177', 'DEC-2011', '177 United Rd', 'Pittsburgh', 'PA', '1234567177', 'RJ177@gmail.com');
			ccpp.addCustomer('Mr', 'Azurairzur', 'Raymizur', '0000000000000178', 'NOV-2006', '178 United Rd', 'Pittsburgh', 'PA', '1234567178', 'AR178@gmail.com');
			ccpp.addCustomer('Mr', 'Merairmed', 'Crocresmed', '0000000000000179', 'AUG-2004', '179 United Rd', 'Pittsburgh', 'PA', '1234567179', 'MC179@gmail.com');
			ccpp.addCustomer('Mr', 'Zurzermur', 'Ramurtron', '0000000000000180', 'FEB-2009', '180 United Rd', 'Pittsburgh', 'PA', '1234567180', 'ZR180@gmail.com');
			ccpp.addCustomer('Mrs', 'Camaracarc', 'Caarker', '0000000000000181', 'JAN-2009', '181 United Rd', 'Pittsburgh', 'PA', '1234567181', 'CC181@gmail.com');
			ccpp.addCustomer('Mrs', 'Racraer', 'Mrokmies', '0000000000000182', 'APR-2017', '182 United Rd', 'Pittsburgh', 'PA', '1234567182', 'RM182@gmail.com');
			ccpp.addCustomer('Mr', 'Mrokarccred', 'Jagzoirzur', '0000000000000183', 'MAR-2016', '183 United Rd', 'Pittsburgh', 'PA', '1234567183', 'MJ183@gmail.com');
			ccpp.addCustomer('Mrs', 'Mrokmurmed', 'Jarsorcred', '0000000000000184', 'DEC-2005', '184 United Rd', 'Pittsburgh', 'PA', '1234567184', 'MJ184@gmail.com');
			ccpp.addCustomer('Mrs', 'Zorkzerd', 'Jagmeearc', '0000000000000185', 'SEP-2000', '185 United Rd', 'Pittsburgh', 'PA', '1234567185', 'ZJ185@gmail.com');
			ccpp.addCustomer('Mrs', 'Krirark', 'Croired', '0000000000000186', 'JUL-2016', '186 United Rd', 'Pittsburgh', 'PA', '1234567186', 'KC186@gmail.com');
			ccpp.addCustomer('Mrs', 'Camiricred', 'Raymaraces', '0000000000000187', 'JUN-2018', '187 United Rd', 'Pittsburgh', 'PA', '1234567187', 'CR187@gmail.com');
			ccpp.addCustomer('Mrs', 'Luksord', 'Lukcraark', '0000000000000188', 'MAY-2014', '188 United Rd', 'Pittsburgh', 'PA', '1234567188', 'LL188@gmail.com');
			ccpp.addCustomer('Mr', 'Azurzertron', 'Madmaracd', '0000000000000189', 'NOV-2004', '189 United Rd', 'Pittsburgh', 'PA', '1234567189', 'AM189@gmail.com');
			ccpp.addCustomer('Mrs', 'Rayredmed', 'Drakarcure', '0000000000000190', 'MAR-2005', '190 United Rd', 'Pittsburgh', 'PA', '1234567190', 'RD190@gmail.com');
			ccpp.addCustomer('Mr', 'Rameecred', 'Azurcloarc', '0000000000000191', 'SEP-2019', '191 United Rd', 'Pittsburgh', 'PA', '1234567191', 'RA191@gmail.com');
			ccpp.addCustomer('Mrs', 'Reisalmarure', 'Zorkarczur', '0000000000000192', 'OCT-2002', '192 United Rd', 'Pittsburgh', 'PA', '1234567192', 'RZ192@gmail.com');
			ccpp.addCustomer('Mr', 'Zorkarcark', 'Cruarkes', '0000000000000193', 'JUL-2019', '193 United Rd', 'Pittsburgh', 'PA', '1234567193', 'ZC193@gmail.com');
			ccpp.addCustomer('Mr', 'Racresmur', 'Azurcreszur', '0000000000000194', 'OCT-2008', '194 United Rd', 'Pittsburgh', 'PA', '1234567194', 'RA194@gmail.com');
			ccpp.addCustomer('Mr', 'Azakmiried', 'Lukcresarc', '0000000000000195', 'FEB-2014', '195 United Rd', 'Pittsburgh', 'PA', '1234567195', 'AL195@gmail.com');
			ccpp.addCustomer('Mrs', 'Raloricred', 'Crylorid', '0000000000000196', 'JUN-2003', '196 United Rd', 'Pittsburgh', 'PA', '1234567196', 'RC196@gmail.com');
			ccpp.addCustomer('Mr', 'Crulorid', 'Rayairarc', '0000000000000197', 'JUL-2017', '197 United Rd', 'Pittsburgh', 'PA', '1234567197', 'CR197@gmail.com');
			ccpp.addCustomer('Mrs', 'Croslamares', 'Mjolslamarmur', '0000000000000198', 'JUN-2003', '198 United Rd', 'Pittsburgh', 'PA', '1234567198', 'CM198@gmail.com');
			ccpp.addCustomer('Mrs', 'Reicloed', 'Cryclod', '0000000000000199', 'JAN-2010', '199 United Rd', 'Pittsburgh', 'PA', '1234567199', 'RC199@gmail.com');





        }

        // Show customers
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Showing Customer Info");
            ccpp.showCustomer('Morsalmarcred', 'Crumeecred');
			ccpp.showCustomer('Caurakarc', 'Morurakmur');
			ccpp.showCustomer('Zedcrazur', 'Azaksalmared');
			ccpp.showCustomer('Drakmures', 'Caclomur');
			ccpp.showCustomer('Zurzercred', 'Caarkcred');
			ccpp.showCustomer('Marirder', 'Jagloricred');
			ccpp.showCustomer('Rayirzur', 'Zurairure');
			ccpp.showCustomer('Cryarctron', 'Mrokslamararc');
			ccpp.showCustomer('Marlorizur', 'Drakuraker');
			ccpp.showCustomer('Azurmaraccred', 'Madcraes');
			ccpp.showCustomer('Luklorier', 'Mrokmurmed');
			ccpp.showCustomer('Madmeetron', 'Jarmirimur');
			ccpp.showCustomer('Raclomur', 'Merzoirtron');
			ccpp.showCustomer('Mermurmur', 'Crocloes');
			ccpp.showCustomer('Madarcer', 'Crusorark');
			ccpp.showCustomer('Cruurakark', 'Cromurure');
			ccpp.showCustomer('Zedird', 'Krzercred');
			ccpp.showCustomer('Zorkmurure', 'Azakredder');
			ccpp.showCustomer('Creosalmarark', 'Rasored');
			ccpp.showCustomer('Caairmur', 'Drakarcmur');
			ccpp.showCustomer('Reicracred', 'Cryarcer');
			ccpp.showCustomer('Mrokurakmur', 'Morlorider');
			ccpp.showCustomer('Morclotron', 'Mermid');
			ccpp.showCustomer('Creocloed', 'Cruirzur');
			ccpp.showCustomer('Crycratron', 'Madcresmed');
			ccpp.showCustomer('Jararked', 'Zorkzoirarc');
			ccpp.showCustomer('Mersalmarzur', 'Jagmaracark');
			ccpp.showCustomer('Cryarccred', 'Creozoirtron');
			ccpp.showCustomer('Racloer', 'Rayirmur');
			ccpp.showCustomer('Cromirimur', 'Zorkarkder');
			ccpp.showCustomer('Marired', 'Zurmaraccred');
			ccpp.showCustomer('Crourakmur', 'Cacresder');
			ccpp.showCustomer('Jarmeemur', 'Azakaircred');
			ccpp.showCustomer('Marirzur', 'Jarmied');
			ccpp.showCustomer('Merzoirtron', 'Mjolreded');
			ccpp.showCustomer('Mrokirzur', 'Cruairder');
			ccpp.showCustomer('Cruirarc', 'Reicresder');
			ccpp.showCustomer('Zedmurmur', 'Cromeemed');
			ccpp.showCustomer('Zedsorzur', 'Cryurakmur');
			ccpp.showCustomer('Raycloed', 'Crycrazur');
			ccpp.showCustomer('Morsord', 'Zedslamared');
			ccpp.showCustomer('Krmiricred', 'Azakloriark');
			ccpp.showCustomer('Azaksalmarark', 'Zorkcresarc');
			ccpp.showCustomer('Marmeeer', 'Luksores');
			ccpp.showCustomer('Krsalmarark', 'Mjolarctron');
			ccpp.showCustomer('Madslamarure', 'Zorkmeetron');
			ccpp.showCustomer('Reiarkes', 'Zedzoirzur');
			ccpp.showCustomer('Rayredcred', 'Mercraarc');
			ccpp.showCustomer('Lukcloes', 'Merarces');
			ccpp.showCustomer('Raylorizur', 'Morsorarc');
			ccpp.showCustomer('Creocresd', 'Drakarczur');
			ccpp.showCustomer('Cacraark', 'Zedsalmarark');
			ccpp.showCustomer('Brezerer', 'Mjolmirizur');
			ccpp.showCustomer('Azakslamarer', 'Zorkairtron');
			ccpp.showCustomer('Rasormed', 'Creoaird');
			ccpp.showCustomer('Zursalmarure', 'Lukirarc');
			ccpp.showCustomer('Morarcer', 'Reiaircred');
			ccpp.showCustomer('Krcraark', 'Merarczur');
			ccpp.showCustomer('Zurmimed', 'Mrokairark');
			ccpp.showCustomer('Morlorimur', 'Zorkmiriark');
			ccpp.showCustomer('Zurredmed', 'Zurmaracd');
			ccpp.showCustomer('Mrokarkcred', 'Crycrad');
			ccpp.showCustomer('Jarsortron', 'Zedairder');
			ccpp.showCustomer('Zurarkzur', 'Zedirmur');
			ccpp.showCustomer('Azurmiricred', 'Azakcloer');
			ccpp.showCustomer('Marmirimed', 'Croarczur');
			ccpp.showCustomer('Krurakure', 'Merarcure');
			ccpp.showCustomer('Madmimur', 'Mjolsalmarcred');
			ccpp.showCustomer('Mrokslamard', 'Krmied');
			ccpp.showCustomer('Bresalmararc', 'Krzoired');
			ccpp.showCustomer('Drakcrescred', 'Cryirtron');
			ccpp.showCustomer('Crulorider', 'Zurredder');
			ccpp.showCustomer('Lukcresarc', 'Mjolclocred');
			ccpp.showCustomer('Crucrestron', 'Breredark');
			ccpp.showCustomer('Reiloriark', 'Morsortron');
			ccpp.showCustomer('Jagmider', 'Mroksalmarmur');
			ccpp.showCustomer('Camaraccred', 'Mjolcrescred');
			ccpp.showCustomer('Cryzermed', 'Creomeetron');
			ccpp.showCustomer('Azakmured', 'Mrokmurtron');
			ccpp.showCustomer('Creosored', 'Morredark');
			ccpp.showCustomer('Crusalmarure', 'Azakslamartron');
			ccpp.showCustomer('Creoaires', 'Breslamartron');
			ccpp.showCustomer('Azakarczur', 'Zurcloed');
			ccpp.showCustomer('Rasalmarure', 'Crumeetron');
			ccpp.showCustomer('Reimiarc', 'Drakmeees');
			ccpp.showCustomer('Mroklorid', 'Rayirarc');
			ccpp.showCustomer('Mrokcramur', 'Mersalmartron');
			ccpp.showCustomer('Mjolarkark', 'Marzoircred');
			ccpp.showCustomer('Mormeezur', 'Jarsalmared');
			ccpp.showCustomer('Zurcloarc', 'Mjolmirid');
			ccpp.showCustomer('Zurslamarder', 'Marslamararc');
			ccpp.showCustomer('Bremaraces', 'Crozertron');
			ccpp.showCustomer('Marmaracer', 'Zedmied');
			ccpp.showCustomer('Creomitron', 'Lukurakure');
			ccpp.showCustomer('Zedarkmed', 'Azakarctron');
			ccpp.showCustomer('Mjolirmur', 'Madairure');
			ccpp.showCustomer('Mrokarcmur', 'Jagcratron');
			ccpp.showCustomer('Brearkarc', 'Madmures');
			ccpp.showCustomer('Breredarc', 'Crocraure');
			ccpp.showCustomer('Crozoired', 'Zurslamarzur');
			ccpp.showCustomer('Reisalmares', 'Azurcreses');
			ccpp.showCustomer('Jagredarc', 'Merslamarcred');
			ccpp.showCustomer('Jaglorier', 'Madlorimed');
			ccpp.showCustomer('Madmies', 'Merloriure');
			ccpp.showCustomer('Bremurzur', 'Jagarced');
			ccpp.showCustomer('Cruzerzur', 'Zorkredtron');
			ccpp.showCustomer('Azakmaraced', 'Mjolired');
			ccpp.showCustomer('Krirzur', 'Crumaracarc');
			ccpp.showCustomer('Croairark', 'Mrokmeees');
			ccpp.showCustomer('Jagirtron', 'Crycresmed');
			ccpp.showCustomer('Razerer', 'Azursalmarcred');
			ccpp.showCustomer('Azakmiried', 'Jarslamarmed');
			ccpp.showCustomer('Krmeeure', 'Zurslamarure');
			ccpp.showCustomer('Zurmurtron', 'Zurredmed');
			ccpp.showCustomer('Drakmurd', 'Azurirder');
			ccpp.showCustomer('Raycreser', 'Krirmed');
			ccpp.showCustomer('Azakcratron', 'Raloritron');
			ccpp.showCustomer('Marclod', 'Marirder');
			ccpp.showCustomer('Lukzermur', 'Creomaraccred');
			ccpp.showCustomer('Cameetron', 'Caarkder');
			ccpp.showCustomer('Cryzoirark', 'Lukmurarc');
			ccpp.showCustomer('Morlorider', 'Mrokarkarc');
			ccpp.showCustomer('Jagredd', 'Jagmeees');
			ccpp.showCustomer('Rayarces', 'Zedmeecred');
			ccpp.showCustomer('Creoarcark', 'Jagzerark');
			ccpp.showCustomer('Cromeed', 'Crourakure');
			ccpp.showCustomer('Azakcrader', 'Raycresder');
			ccpp.showCustomer('Creoclomur', 'Jarslamarark');
			ccpp.showCustomer('Krmurmur', 'Creourakure');
			ccpp.showCustomer('Rayairarc', 'Jagmurzur');
			ccpp.showCustomer('Jarmaracarc', 'Brecresmed');
			ccpp.showCustomer('Mrokslamarer', 'Creocraer');
			ccpp.showCustomer('Raycraure', 'Crocresd');
			ccpp.showCustomer('Mermurcred', 'Krsalmarer');
			ccpp.showCustomer('Lukirarc', 'Madmaraced');
			ccpp.showCustomer('Morurakmur', 'Mersortron');
			ccpp.showCustomer('Zursorure', 'Reilorimed');
			ccpp.showCustomer('Drakairmur', 'Mrokarced');
			ccpp.showCustomer('Mersalmarmur', 'Zurredcred');
			ccpp.showCustomer('Cruirder', 'Azursalmarure');
			ccpp.showCustomer('Bremies', 'Cruslamarcred');
			ccpp.showCustomer('Zedmurd', 'Bremeeark');
			ccpp.showCustomer('Krzoirer', 'Creoired');
			ccpp.showCustomer('Creomiries', 'Mrokires');
			ccpp.showCustomer('Krredder', 'Jagsorer');
			ccpp.showCustomer('Drakredder', 'Merairder');
			ccpp.showCustomer('Breurakder', 'Jagcresure');
			ccpp.showCustomer('Ralorid', 'Rasores');
			ccpp.showCustomer('Azakmeezur', 'Rayurakarc');
			ccpp.showCustomer('Mrokmiarc', 'Reizerarc');
			ccpp.showCustomer('Krcrazur', 'Zedloriarc');
			ccpp.showCustomer('Azurmirimed', 'Jagmaraced');
			ccpp.showCustomer('Zedmeezur', 'Cairark');
			ccpp.showCustomer('Mrokired', 'Bremied');
			ccpp.showCustomer('Raymirimur', 'Mersored');
			ccpp.showCustomer('Mrokarcer', 'Zedcresure');
			ccpp.showCustomer('Cameeure', 'Cromeeer');
			ccpp.showCustomer('Brearcder', 'Marsorark');
			ccpp.showCustomer('Jararccred', 'Zorkmaracer');
			ccpp.showCustomer('Madclozur', 'Jagarkark');
			ccpp.showCustomer('Marslamares', 'Calorider');
			ccpp.showCustomer('Crymured', 'Zedarker');
			ccpp.showCustomer('Mjolzermur', 'Mermurmed');
			ccpp.showCustomer('Caloriarc', 'Ramier');
			ccpp.showCustomer('Krarkmed', 'Crucloes');
			ccpp.showCustomer('Jagaird', 'Crumaraces');
			ccpp.showCustomer('Zedzeres', 'Zurcraarc');
			ccpp.showCustomer('Morarcmur', 'Croird');
			ccpp.showCustomer('Zorksalmartron', 'Cruzerd');
			ccpp.showCustomer('Jagslamarmed', 'Rairmed');
			ccpp.showCustomer('Raloriark', 'Cryloricred');
			ccpp.showCustomer('Lukzoird', 'Reilorimur');
			ccpp.showCustomer('Azurclomur', 'Crysorzur');
			ccpp.showCustomer('Jararkarc', 'Cruairzur');
			ccpp.showCustomer('Cazeres', 'Marlorider');
			ccpp.showCustomer('Crozoirzur', 'Lukmaracark');
			ccpp.showCustomer('Crymeees', 'Krmirid');
			ccpp.showCustomer('Reizermed', 'Jarmiriure');
			ccpp.showCustomer('Azurairzur', 'Raymizur');
			ccpp.showCustomer('Merairmed', 'Crocresmed');
			ccpp.showCustomer('Zurzermur', 'Ramurtron');
			ccpp.showCustomer('Camaracarc', 'Caarker');
			ccpp.showCustomer('Racraer', 'Mrokmies');
			ccpp.showCustomer('Mrokarccred', 'Jagzoirzur');
			ccpp.showCustomer('Mrokmurmed', 'Jarsorcred');
			ccpp.showCustomer('Zorkzerd', 'Jagmeearc');
			ccpp.showCustomer('Krirark', 'Croired');
			ccpp.showCustomer('Camiricred', 'Raymaraces');
			ccpp.showCustomer('Luksord', 'Lukcraark');
			ccpp.showCustomer('Azurzertron', 'Madmaracd');
			ccpp.showCustomer('Rayredmed', 'Drakarcure');
			ccpp.showCustomer('Rameecred', 'Azurcloarc');
			ccpp.showCustomer('Reisalmarure', 'Zorkarczur');
			ccpp.showCustomer('Zorkarcark', 'Cruarkes');
			ccpp.showCustomer('Racresmur', 'Azurcreszur');
			ccpp.showCustomer('Azakmiried', 'Lukcresarc');
			ccpp.showCustomer('Raloricred', 'Crylorid');
			ccpp.showCustomer('Crulorid', 'Rayairarc');
			ccpp.showCustomer('Croslamares', 'Mjolslamarmur');
			ccpp.showCustomer('Reicloed', 'Cryclod');

        }

        // Find Routes
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Finding Routes");
            ccpp.findRoutes("JFK", "SEA");
        }

        // Find Routes Given Airline
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Finding Routes given Airline");
            ccpp.findRoutesAirlines("JFK", "SEA", "United Airlines");
        }

        // Find Routes Given Date
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Finding Routes on a given Date");
            ccpp.findRoutesDate("JFK", "SEA", "M");
        }

        // Find Routes give date and airline_id
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Finding Routes given Date and Airline");
            ccpp.findRoutesDateAirline("JFK", "SEA", "M", "United Airlines");
        }

        // Add Reservations
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Adding Reservation");
            ccpp.addReservation("11000", "0000000000000000", "1", "000", "19-MAY-19 02:00:00");
            System.out.println("");
        }

        // Find Price Between cities
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Finding Price of Reservation");
            ccpp.findPrice("JFK", "SEA");
        }

        //Change existing price
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Changing Price of Ticket");
            aapp.changePrice("JFK", "SEA", "00001", "2000", "1700");
            System.out.println("");
        }

        // Buy Ticket
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Buying Ticket");
            ccpp.buyReservation("11000");
            System.out.println("");
        }

        // Show Reservation Info
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Showing Reservation Added");
            ccpp.findReservation("11000");
            System.out.println("");
        }

        //Generate Passenger Manifest for a specific flight on given date
        answer = input.readLine("Continue? Press Enter: ");
        if(answer != null)
        {
            System.out.println("Generating Passenger manifest for all flights on all dates");
            aapp.generateManifest("000", "19-MAY-19 02:00:00");
        }

        // String table = input.readLine("Please specify a table to display: ");
        // aapp.showTable(table);
        connection.close();
    }
}
