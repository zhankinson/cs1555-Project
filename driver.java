import java.util.*;
import java.io.*;

public class driver
{
  public static void main(String[] args) throws Exception
  {
    boolean proceed = true;
    Scanner input = new Scanner(System.in);
    String answer;
    while(proceed)
    {
      System.out.print("Are you a Customer or Admin? (type C or A): ");
      answer = input.next();
      if(answer.compareTo("C") == 0)
      {
        CustomerInterface capp = new CustomerInterface();
        proceed = false;
      }
      else if(answer.compareTo("A") == 0)
      {
        AdministratorInterface aapp = new AdministratorInterface();
        proceed = false;
      }
      else
      {
        System.out.print("Please input a valid option");
      }
    }
    input.close();
  }
}
