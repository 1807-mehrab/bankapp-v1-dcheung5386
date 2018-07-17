package bankingapp;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {


public static void main(String[]args) throws InterruptedException {
	
	 System.out.println("Welcome To Bank of Derrick ");
	 Logindao LD = new Logindao();
	 SqlInputDao SID = new SqlInputDao();
	
	Scanner sc = new Scanner(System.in);
	 System.out.println("Are you a new user or existing user?");
	 System.out.println("Input ''NEW''for a new account ");
	 String newOrOldUser = sc.nextLine();
	 String appendedNewUser = newOrOldUser.toUpperCase();
	 while (appendedNewUser.equals("NEW")) { //creating a user
		 System.out.println("Input a First Name");// First Name creation
		 String newFirstname = sc.nextLine();
		 System.out.println("Input a Last Name");// Last Name creation
		 String newLastname = sc.nextLine();
		 System.out.println("Input a Username"); //Username creation
		 String newUsername = sc.nextLine();
		 System.out.println("Input a Password"); //Password creation
		 String newPW = sc.nextLine();
		 
		 SID.newAccount(newUsername.toUpperCase(),newPW.toUpperCase(),newFirstname.toUpperCase(),newLastname.toUpperCase());
		 //using variable
		 
	 }
      System.out.println("Username: ");
      String inputName = sc.nextLine();
      System.out.println("Password: ");
      String inputPassword = sc.nextLine();
   
 
  String name = inputName.toUpperCase();
  String Password = inputPassword.toUpperCase();
   
    
       boolean loginQueue =false;
	while(loginQueue  == false){
      if (LD.getUserName(name) && Password.equals(LD.getPassword(name))) //if username and password is a combination in the database
      {	
    	  
    		  System.out.println("Welcome ");
    		 
    		  TimeUnit.SECONDS.sleep(2);
    		  loginQueue =true;
   	  }
    	 
      else {
    	  
    	  System.out.println("Please enter the right information");
    		TimeUnit.SECONDS.sleep(2);
    	
    		System.out.println("Username: ");
    	      String loopLogin = sc.nextLine();
    	      System.out.println("Password: ");
    	      String loopPW = sc.nextLine();
    	      name = loopLogin.toUpperCase();
    		   Password = loopPW.toUpperCase();
    		  
      }
	  
       }
	
	boolean menuQueue =false;
	while(menuQueue == false){
		System.out.println("Welcome to your account,  " + LD.getFirstName(name) + " " + LD.getLastName(name)); //gets first name from database and displays here
     System.out.println("Menu");
     
     System.out.println("Please Select a function");
     System.out.println("Checking Account");
    
     System.out.println("View Personal Information");
     System.out.println("Log Out");

     
     String loggedInput = sc.nextLine();
     
    String menuInput = loggedInput.toUpperCase();
   // boolean mainMenuActive = false;
   // while(mainMenuActive==false){
     switch(menuInput)
     {
     case "VIEW": System.out.println("Your checking account number is " + LD.getTheCheckingAmountNumber(name));
     System.out.println("Your account balance is $ " + LD.getCheckingAmount(name)); 
    
     case "CHECKING ACCOUNT":      System.out.println("$ " + LD.getCheckingAmount(name));
     TimeUnit.SECONDS.sleep(3);
     System.out.println("Do you want to view checking account, withdraw ,deposit , or log out");
     String checkingMenuInput = sc.nextLine();
     
  
     switch(checkingMenuInput.toUpperCase()) {
     
     case "VIEW": System.out.println("Your checking account number is " + LD.getTheCheckingAmountNumber(name));
     System.out.println("Your account balance is $ " + LD.getCheckingAmount(name));
     loginQueue  = false;
     break;
     case "DEPOSIT": System.out.println("How much are you depositing?"); //deposit case
     
     String depositAmount = sc.nextLine();
     double depoResult = Double.parseDouble(depositAmount);	
		
		while(depoResult < 0) { // no negative deposit , which are withdrawals
			System.out.println("Please put another denomination");
			String depositAmounts= sc.nextLine();
			  depoResult = Double.parseDouble(depositAmounts);
		}
     
		SID.depositSQL(name,depoResult);
		System.out.println("Your account balance is $" + LD.getCheckingAmount(name));
		loginQueue = true;
		break;
     
     case "WITHDRAW": System.out.print("How much are you withdrawing?");
   
     String withdrawalAmount = sc.nextLine();
   
     Double withdrawlResult = Double.parseDouble(withdrawalAmount);	
     while(withdrawlResult > LD.getCheckingAmount(name) && withdrawlResult > 0 ) {
     if(withdrawlResult > LD.getCheckingAmount(name) | withdrawlResult <= 0) // don't want to overdraft
     {
    	 System.out.println("You cannot withdraw a negative denomination");
    	 System.out.println("Please try put another amount");
    	 
     }
     }
    	 SID.withdrawSQL(name,withdrawlResult);
    	 System.out.println("Your new balance $" + LD.getCheckingAmount(name)); //redisplay checking account balance
     
    	 loginQueue = true;
     
     break;
   
     
     case "LOG OUT":
    	 LoggingOut.loggingMethod();
    	
     break;
     }
     
     
     case "LOG OUT":  
    	 LoggingOut.loggingMethod();
    	
    break;
     
     }
     loginQueue  = false;
	}
    }   
//}
}

 



















