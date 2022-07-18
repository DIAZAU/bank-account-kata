package hexagonal.architecture.application.domain;

import java.math.BigDecimal;

public class BankAccount {

	private BigDecimal balance;
	private Transactions transactions;
	private StatementPrinter statementPrinter;
	
	public BankAccount(Transactions transactions, StatementPrinter statementPrinter, BigDecimal balance) {
		this.transactions = transactions;
		this.statementPrinter = statementPrinter;
		this.balance = balance;
	}

	public void deposit(String systemDate, BigDecimal amount) {
		balance = balance.add(amount);
		Transaction deposit = new Transaction(systemDate, amount, balance);
		transactions.add(deposit);
	}

}
