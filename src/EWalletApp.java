import java.util.ArrayList;
import java.util.Scanner;

public class EWalletApp {
	//this is the app class, has the GUI and create one object of your expense calculator class. The expense calculator class is the implementation of the Expenser interface 
	private ArrayList<User> AllData;
	
	public static void main(String[] args) {
	
		
		Calculations calc = new Calculations(new User("TestUser","TestPassword"));
		
		//for currency conversion testing
		calc.addCurrency("TestCur", 2);		
	}

}
