import java.util.*;
import java.io.*;

public class driver
{
  public static void main(String[] args) throws Exception
  {
    boolean proceed = true;
    Console input = System.console();
    String answer;

    String username = input.readLine("Please enter a Username: ");
    String password = new String(input.readPassword("Please enter a password: "));

    while(proceed)
    {
      System.out.print("Are you a Customer or Admin? (type C or A): ");
      answer = input.readLine();
      if(answer.compareTo("C") == 0)
      {
        CustomerInterface capp = new CustomerInterface();
        proceed = false;
      }
      else if(answer.compareTo("A") == 0)
      {
        AdministratorInterface aapp = new AdministratorInterface(username, password);
        proceed = false;
      }
      else
      {
        System.out.print("Please input a valid option");
      }
    }
  }
}
