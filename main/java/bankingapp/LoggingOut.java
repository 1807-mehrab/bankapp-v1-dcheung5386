package bankingapp;

import java.util.concurrent.TimeUnit;

public class LoggingOut {
public static void loggingMethod() {
	  System.out.println("Logging you out");
	     try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	     System.out.println("Thank You With Banking With Bank of Derrick");
	     
	System.exit(0);
	
}
}