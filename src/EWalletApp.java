import java.util.ArrayList;  
import java.util.Scanner;

public class EWalletApp {
	//this is the app class, has the GUI and create one object of your expense calculator class. The expense calculator class is the implementation of the Expenser interface 
	private ArrayList<User> AllData;
	
	public static void main(String[] args) {
	
		
		Calculations calc = new Calculations(new User("TestUser","TestPassword"));
		
		//for currency conversion testing
		calc.addCurrency("TestCur", 2);
		
		//for export testing
		calc.addMonthlyIncome(new Wage("job", 50, "june"));
		calc.addMonthlyIncome(new Wage("job", 30, "may"));
		calc.addMonthlyIncome(new Wage("gambling", 1000, "may"));
		calc.addExpense(new Expense("eggs", 50, 4));
		calc.addExpense(new Expense("eggs", 10, 1));
		calc.addExpense(new Expense("rent", 100, 1));
		
		
		//console welcome
		System.out.println("Welcome to your eWallet!");
		System.out.println("Menu: ");
		System.out.println("'AddE' for adding expenses.");
		System.out.println("'AddI' for adding monthly income.");
		System.out.println("'Convert' for converting to foriegn currency.");
		System.out.println("'Export' for exporting a report to file.");
		System.out.println("'Exit' to close application.");
		
		
		
		Scanner scnr = new Scanner(System.in);
		String menuChoice;
		
		while(true) {
			System.out.println("Enter Command: ");
			menuChoice = scnr.next();
			
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
			else if (menuChoice.contentEquals("Export")) {
				System.out.println("Desired file name: ");
				String name = scnr.next();
				
				System.out.println("Desired file path (must end with backslash): ");
				calc.filePath = scnr.next();
				
				System.out.println("What kind of report? (Income, Expense, IBT/IncomeByType, EBT/ExpenseByType): ");
				calc.kindOfReport =  scnr.next();
				
				if(calc.kindOfReport.equals("Income") || calc.kindOfReport.equals("Expense")) {
					calc.exportReport(name);
				}
				//IBT and EBT commands are accepted as short spellings for convenience. 
				else if(calc.kindOfReport.equals("IncomeByType") || calc.kindOfReport.equals("IBT")) {
					System.out.println("Type of report: "); 
					calc.reportType =  scnr.next();
					calc.kindOfReport = "IncomeByType";
					calc.exportReport(name);
				}
				else if(calc.kindOfReport.equals("ExpenseByType") || calc.kindOfReport.equals("EBT")) {
					System.out.println("Type of report: "); 
					calc.reportType =  scnr.next();
					calc.kindOfReport = "ExpenseByType";
					calc.exportReport(name);
				}
				else {
					System.out.println(calc.kindOfReport + " is not a valid kind of report");
				}
			}
			else if (menuChoice.contentEquals("Exit")) {
				break;
			}
		}
		
		
		scnr.close();
	}

}
