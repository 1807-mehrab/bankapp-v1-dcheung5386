package banking;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import java.util.c

public class Main {


public static void main(String[]args) throws InterruptedException {
	
	  Scanner sc = new Scanner(System.in);
      System.out.println("Username: ");
      String name = sc.nextLine();
      System.out.println("Password: ");
      String Password = sc.nextLine();
   
    
      String testy = "User1";
      String testy2 ="Password";
      
       
      if (name.equals(testy) && Password.equals(testy2))
      {	
    	  
    		  System.out.println("Welcome ");
    		  TimeUnit.SECONDS.sleep(2);
    		
   	  }
    	 
      else {
    	  System.out.println("Please enter the right information");
    		TimeUnit.SECONDS.sleep(2);
    		 System.exit(1);
      }
      
     CheckingAccounts loggedIn = new CheckingAccounts();
     System.out.println("Menu");
     System.out.println("Please Select a function");
     System.out.println("Checking Account");
     System.out.println("Credit Account");
     System.out.println("View Personal Information");
     
     String menuInput = sc.nextLine();
     
   
     switch(menuInput)
     {
     case "Checking Account":menuInput = " ";
     System.out.println("Your Checking Balance is $" + CheckingAccounts.checkingBalance);
     TimeUnit.SECONDS.sleep(3);
    
     case "Credit Account":menuInput= " ";
     System.out.println("Test");
     
     case "View Person Information":menuInput= " ";
     System.out.println(Person.firstName);// firstname has to be static find a way around that 
     
     
     }
    
    
     
     System.out.println("Your Checking Balance is $" + CheckingAccounts.checkingBalance);
      
      
}
}






