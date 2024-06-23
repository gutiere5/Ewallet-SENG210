import java.util.Scanner;

import javax.swing.DefaultListModel;

public class Calculations implements Expenser{
	public User userAtHand;
         
    // Initialize user 
    public Calculations(User user) {
    	this.userAtHand = user;
    }
    
    // Generates ReportListModel List for JList GUI use 
 	DefaultListModel<String> reportListModel = new DefaultListModel<>();;
    
	// As a user I'd like to add a monthly expense so I can track and report my expenses - 3pts
	public void addExpense (Expense Ex) {
		userAtHand.addExpenseList(Ex);
		updateMonthlySavings();		// Updates Monthly Saving when Expense is added
	}
	// As a user I'd like to add a monthly income so I can track and report my income all year - 3pts
	public void addMonthlyIncome (Wage W) {
		userAtHand.addIncomeList(W);
		updateMonthlySavings();	// Updates Monthly Savings when Monthly Income is added
	}
	//As  a user I would like to view a detailed report of all expenses, income, and summary information 
	//summary information include : total income, total income for each type, total income for each month, total expense, total expense for each type, 
	//total savings (total income- total expenses) to date, if the total savings are less than zero it should be reported as total new debt. 	
	public void PrintFullreport() {
		
	}
	//As  a user I would like to view a detailed report of all expenses, and summary information for expenses 
	public void PrintExpensereport() {
		
	}
	//As  a user I would like to view a detailed report of all income, and summary information for income
	public void PrintIncomereport() {
		String incomeInfo; 		// Used to store Source, amount, Month

		// Clears Current List information and prints updates
		reportListModel.clear();
		
		// Gets information for Report Income
		for (Wage wage: userAtHand.getIncome()) {
			incomeInfo = "Source: " + wage.source + "    Amount: " + wage.amount + "    Month: " + wage.Month;
			reportListModel .addElement(incomeInfo);
		}
	}
	
	//As  a user I would like to view a detailed report of income of a certain type, and summary information for income
	public void PrintIncomereportbyTpe(){
		String incomeInfo; 		// Used to store Source, amount, Month
		String type; 			// User input from filter text field

		reportListModel.clear();
		
		type = MainGUI.filterField.getText();
		
		// Gets filtered information for Report Income
		for (Wage wage: userAtHand.getIncome()) {
			if (wage.source.equals(type)) {
				incomeInfo = "Source: " + wage.source + "    Amount: " + wage.amount + "    Month: " + wage.Month;
				reportListModel .addElement(incomeInfo);
			}
		}		
	}
	
	//As  a user I would like to view a detailed report of expense of a certain type , and summary information for expenses
	public void PrintExpensebyType() {
		
	}
	// As a user I would like to choose a report and export it as an external file (any type is fine preferences are csv or JSON)
	public void exportReport(String reportTitle) {
		
	}
	//	As a user I would like to view my current balance in a different currency 
	//Bonus : try to use the same convert function to convert from foreign currency to USD 
	public double convertForeignCurrency(Currency C, double amount) {
		double returnAmount = 0;
		
		returnAmount = C.rate * amount;
		
		return returnAmount; 
	}
	
	//used to find a currency from the userAtHand's currency rates list.
	public Currency findCurrencyByName(String name) {
		Currency returnCurrency = null;
		
		for(Currency cur : userAtHand.getCurrencyRates()) {
			if(cur.name.equals(name)) {
				returnCurrency = cur;
				break;
			}
		}
		
		return returnCurrency;
	}
	
	public void addCurrency(String name, double rate) {
		userAtHand.addCurrencyRate(new Currency(name, rate));
	}
	
	//	As a user I would like to load multiple expenses from an external file all at once returning true if loaded successfully and false otherwise 
	public boolean loadExpenseFile(String filePath) {
		return false; //temporary line to fix error. 
	}
	//	As a user I would like to load multiple income from an external file all at once returning true if loaded successfully and false otherwise 
	public boolean loadIncomeFile(String filePath) {
		return false; //temporary line to fix error. 
	}
	// As a user I would like to provide an item and a price and get an estimate in number of months needed to save up to buy this item. (based on current monthly saving. 
	public int whenCanIBuy(String itemname,double  price) {
		return 0; //temporary line to fix error. 
	}
	
	// updates monthly savings based on latest added income and expenses. This is an internal function not called by the users.  Bonus: what is the most efficient way to call it (when?)? 
	public void updateMonthlySavings() {
		
		
		userAtHand.monthlysavings = userAtHand.getRecentIncome() - userAtHand.getTotalExpensesAmount();	

		
		
		
	}

}
