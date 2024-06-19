import java.util.ArrayList;  
import java.util.Scanner;

public class EWalletApp {
	//this is the app class, has the GUI and create one object of your expense calculator class. The expense calculator class is the implementation of the Expenser interface 
	private ArrayList<User> AllData;
	
	public static void main(String[] args) {
	
		
		Calculations calc = new Calculations(new User("TestUser","TestPassword"));
		
		//for currency conversion testing
		calc.addCurrency("TestCur", 2);
		
		//console welcome
		System.out.println("Welcome to your eWallet!");
		System.out.println("Menu: ");
		System.out.println("'AddE' for adding expenses.");
		System.out.println("'AddI' for adding monthly income.");
		System.out.println("'Convert' for converting to foriegn currency.");
		
		
		
		Scanner scnr = new Scanner(System.in);
		String menuChoice = scnr.next();
		
		if (menuChoice.contentEquals("AddE")) {
			System.out.println("Expense Source: ");
			String source = scnr.next();
			
			System.out.println("Amount: ");
			double amount = scnr.nextDouble();
			
			System.out.println("Frequency (Per Year): ");
			int freq = scnr.nextInt();
			
			Expense newExpense = new Expense(source, amount, freq);
			
			calc.addExpense(newExpense);
		}
		else if (menuChoice.contentEquals("AddI")) {
			System.out.println("Income Source: ");
			String source = scnr.next();
			
			System.out.println("Amount: ");
			double amount = scnr.nextDouble();
			
			System.out.println("Month: ");
			String month = scnr.next();
			
			Wage newWage = new Wage(source, amount, month);
			
			calc.addMonthlyIncome(newWage);
		}
		else if (menuChoice.contentEquals("Convert")) {
			System.out.println("Currency: ");
			String name = scnr.next();
			
			System.out.println("Amount: ");
			double amount = scnr.nextDouble();
			
			Currency currency = calc.findCurrencyByName(name);
			
			if(currency == null) {
				System.out.println("There is no currency called " + name);
			}
			else {
				System.out.println("Amount in " + name + ": " + calc.convertForeignCurrency(currency, amount));
			}
		}
		
		scnr.close();
	}

}
