  
public class Calculations implements Expenser{
	private User userAtHand;
    private double totalIncome; // For testing purposes - Elber 
    private double totalExpenses; // For testing purposes - Elber 
    public double totalSavings; // For testing purposes - Elber 
	
	// Elber - created this constructor 
	public Calculations(User user) {
		this.userAtHand = user;
		this.totalSavings = 0.0;
		
	}
	
	// As a user I'd like to add a monthly expense so I can track and report my expenses - 3pts
	public void addExpense (Expense Ex) {
		EWalletApp.newUser.addExpenseList(Ex);
		System.out.println("Expense added: Source - " + Ex.source + "; Amount - " + Ex.amount + "; Frequency per year - " + Ex.yearlyfrequency);
		updateMonthlySavings();		// Updates Monthly Saving when Expense is added
	}
	// As a user I'd like to add a monthly income so I can track and report my income all year - 3pts
	public void addMonthlyIncome (Wage W) {
		EWalletApp.newUser.addIncomeList(W);
		System.out.println("Income added: Source - " + W.source + "; Amount - " + W.amount + "; Month - " + W.Month);
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
		
	}
	//As  a user I would like to view a detailed report of income of a certain type, and summary information for income
	public void PrintIncomereportbyTpe() {
		
	}
	//As  a user I would like to view a detailed report of expense of a certain type , and summary information for expenses
	public void PrintExpensebyType() {
		
	}
	// As a user I would like to choose a report and export it as an external file (any type is fine preferences are csv or JSON)
	public void exportReport(String reportTitle) {
		
	}
	//	As a user I would like to view my current balance in a different currency 
	//Bonus : try to use the same convert function to convert from foreign currency to USD 
	public Currency convertForeignCurrency(Currency C, double amount) {
		return null; //temporary line to fix error. 
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
	
	// Elber
	// updates monthly savings based on latest added income and expenses. This is an internal function not called by the users.  Bonus: what is the most efficient way to call it (when?)? 
	public void updateMonthlySavings() {
		this.totalSavings = this.totalIncome - this.totalExpenses;
		
	}
		
}
