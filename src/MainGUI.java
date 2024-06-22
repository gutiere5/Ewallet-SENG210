import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainGUI extends JFrame{

	// Initialize JPanel cards as a field
	JPanel cards;

	// JTextFields
	JTextField usernameField = new JTextField();		// Used in loginWindow()
	JTextField passwordField = new JTextField();		// Used in loginWindow()
	JTextField sourceIncomeField = new JTextField();	// Used in mainPanel()
	JTextField amountIncomeField = new JTextField();	// Used in mainPanel()
	JTextField monthField = new JTextField();			// Used in mainPanel()
	JTextField sourceExpenseField = new JTextField();	// Used in mainPanel()
	JTextField amountExpenseField = new JTextField();	// Used in mainPanel()
	JTextField yearlyFreqField = new JTextField();		// Used in mainPanel()

	// JButtons
	JButton loginButton = new JButton("Login");				// Used in loginWindow()
	JButton addExpenseButton = new JButton("Add Expense");	// Used in mainPanel()
	JButton addIncomeButton = new JButton("Add Income");	// Used in mainPanel()
	JButton printIncomeButton = new JButton("Income Report");	// Used in mainPanel()
	JButton printExpenseButton = new JButton("Expense Report");	// Used in mainPanel()
	JButton printIncomeButtonType = new JButton("Income Report By Type");	// Used in mainPanel()
	JButton printExpenseButtonType = new JButton("Expense Report By Type");	// Used in mainPanel()
	JButton printFullReportButton = new JButton("Print Full Report");		// Used in mainPanel()
	JButton covertForeiCurrcyButton = new JButton("Convert Foreign Currency");	// Used in mainPanel()

	// JLabels
	JLabel statusLabel = new JLabel();		// Used in loginWindow() and to show who is logged in
	
	//TODO Testing
	JLabel currentIncome = new JLabel();	
	JLabel currentExpense = new JLabel();	
	JLabel currentSavings = new JLabel();	
	
	
	

	/**
	 * Constructor for MainGUI
	 */
	public MainGUI() {
		////////////////////////////
		/// Frame Settings
		//////////////////////////
		setTitle("EWallet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 300);
		setLocationRelativeTo(null); // Center the window

		// Initialized actionPerformed()
		actionPerformed();

		// Create card panel with Card Layout
		cards = new JPanel(new CardLayout());
		//TODO Testing    cards.add(loginWindow(), "LoginPanel");
		cards.add(mainPanel(), "MainPanel");

		add(cards);
	}

	public JPanel mainPanel() {
		
		// Create main panel with BorderLayout
		JPanel mainPanel = new JPanel(new BorderLayout());

		// Create a sub panel with GridLayout for the Income and Expense labels
		JPanel centerPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5); // Padding

		// Create a sub panel with BoxLayout for the report buttons
		JPanel reportPanel = new JPanel();
		reportPanel.setLayout(new BoxLayout(reportPanel, BoxLayout.Y_AXIS));
		reportPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		//TODO Create a sub panel for testing income and expenses
		JPanel testingPanel = new JPanel();
		reportPanel.setLayout(new BoxLayout(reportPanel, BoxLayout.Y_AXIS));


		// JLabels
		JLabel sourceIncomeLabel = new JLabel("Source:");
		JLabel amountIncomeLabel = new JLabel("Amount:");
		JLabel monthLabel = new JLabel("Month:");
		JLabel sourceExpenseLabel = new JLabel("Source:");
		JLabel amountExpenseLabel = new JLabel("Amout:");
		JLabel yearlyFreqLabel = new JLabel("Yearly Freq:");
		JLabel actionsLabel = new JLabel("Actions", SwingConstants.CENTER);
		actionsLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		JLabel expensesLabel = new JLabel("Expenses");
		JLabel incomeLabel = new JLabel("Income");

		//////////////
		// Add labels and text fields to the mainPanel with GridBagLayout
		// Column 1
		gbc.gridx = 0;
		gbc.gridy = 0;
		centerPanel.add(expensesLabel, gbc);
		
		gbc.gridy = 1;
		centerPanel.add(sourceIncomeLabel, gbc);
		
		gbc.gridy = 2;
		centerPanel.add(amountIncomeLabel, gbc);
		
		gbc.gridy = 3;
		centerPanel.add(monthLabel, gbc);
		
		// Column 2 
		gbc.ipadx = 60;
		gbc.gridx = 1;
		gbc.gridy = 1;
		centerPanel.add(sourceIncomeField, gbc);
		
		gbc.gridy = 2;
		centerPanel.add(amountIncomeField, gbc);
		
		gbc.gridy = 3;
		centerPanel.add(monthField, gbc);
		
		gbc.gridy = 4;
		centerPanel.add(addExpenseButton, gbc);
		
		// Column 3
		gbc.ipadx = 0;
		gbc.gridx = 2;
		gbc.gridy = 0;
		centerPanel.add(incomeLabel, gbc);
		
		gbc.gridy = 1;
		centerPanel.add(sourceExpenseLabel, gbc);
		
		gbc.gridy = 2;
		centerPanel.add(amountExpenseLabel, gbc);
		
		gbc.gridy = 3;
		centerPanel.add(yearlyFreqLabel, gbc);
		
		// Column 4
		gbc.ipadx = 60;
		gbc.gridx = 3;
		gbc.gridy = 1;
		centerPanel.add(sourceExpenseField, gbc);
		
		gbc.gridy = 2;
		centerPanel.add(amountExpenseField, gbc);
		
		gbc.gridy = 3;
		centerPanel.add(yearlyFreqField, gbc);
		
		gbc.gridy = 4;
		centerPanel.add(addIncomeButton, gbc);
		
		//////////////
		// Add buttons to reportLabel panel
		reportPanel.add(actionsLabel);
		reportPanel.add(Box.createVerticalStrut(5)); // Add space between label and buttons
		reportPanel.add(printIncomeButton);
		reportPanel.add(Box.createVerticalStrut(5)); // Add space between buttons
		reportPanel.add(printExpenseButton);
		reportPanel.add(Box.createVerticalStrut(5)); // Add space between buttons
		reportPanel.add(printIncomeButtonType);
		reportPanel.add(Box.createVerticalStrut(5)); // Add space between buttons
		reportPanel.add(printExpenseButtonType);
		reportPanel.add(Box.createVerticalStrut(5)); // Add space between buttons
		reportPanel.add(printFullReportButton);
		reportPanel.add(Box.createVerticalStrut(5)); // Add space between buttons
		reportPanel.add(covertForeiCurrcyButton);


		//////////////
		// Add labels to testingPanel panel
		testingPanel.add(currentIncome);
		testingPanel.add(currentExpense);
		testingPanel.add(currentSavings);
		
		// Add the sub-panel to the center of the main panel
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(reportPanel, BorderLayout.EAST);
		mainPanel.add(testingPanel, BorderLayout.WEST);


		return mainPanel;
	}

	/**
	 * Creates the panel for user login.
	 * @return JPanel representing the login window.
	 */
	public JPanel loginWindow() {	        
		// Panel for user login
		JPanel loginPanel = new JPanel(new GridLayout(3,2));

		// JLabels 
		JLabel usernameLabel = new JLabel("Username: ");
		JLabel passwordLabel = new JLabel("Password: ");
		JLabel hintLabel = new JLabel("Hint: User, Pass"); // TODO This can be change too

		// Add Components to Panel
		loginPanel.add(usernameLabel);
		loginPanel.add(usernameField);
		loginPanel.add(passwordLabel);
		loginPanel.add(passwordField);
		loginPanel.add(hintLabel); 
		loginPanel.add(loginButton);

		// Add Panel to Frame
		setLayout(new BorderLayout());
		add(loginPanel, BorderLayout.CENTER);
		add(statusLabel, BorderLayout.SOUTH);

		return loginPanel;
	}

	public void actionPerformed() {
		// Action for the LoginButton
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cardLayout = (CardLayout)(cards.getLayout());
				String inputUsername = usernameField.getText();
				String inputPassword = passwordField.getText();
				boolean isValidLogin;

				/////////////////////////
				// TODO This code will need to be changed for proper login function
				isValidLogin = false;
				if (inputUsername.equals("User") & inputPassword.equals("Pass")) {
					isValidLogin = true; 
				}
				/////////////////////////

				if (isValidLogin) {
					statusLabel.setText("Login Successful: "+ inputUsername);

					//Switches to Expense Panel
					cardLayout.show(cards, "MainPanel");
					setSize(400, 300);
				}
				else {
					statusLabel.setText("Invalid Username or Password");
				}		
			}
		});

		//TODO Add Expense Button Action
		addExpenseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Handle add expense action here
				System.out.println("Add Expense button clicked");
			}
		});

		//TODO Add Income Button Action
		addIncomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Handle add income action here
				System.out.println("Add Monthly Income button clicked");
			}
		});

		//TODO print income report Button Action
		printIncomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Handle add income action here
				System.out.println("Print Income Report button clicked");
			}
		});

		//TODO print expense report Button Action
		printExpenseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Handle add income action here
				System.out.println("Print Expense Report button clicked");
			}
		});
	}
	
	public void updateInfo() {
		//currentIncome = ;	
		//currentExpense = ;	
		//currentSavings =;	
	}

	public static void main(String[] args) {
		MainGUI GUI = new MainGUI();

		GUI.setVisible(true); 
	}
}
