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

	public void withdraw(String clock, BigDecimal amount) {
		if (balance.compareTo(amount) > 0) {
			balance = balance.add(amount);
			Transaction withdraw = new Transaction(clock, amount, balance);
			transactions.add(withdraw);
		}
	}

	public void printStatement() {
		statementPrinter.print(transactions.all());
	}

	@Override
	public String toString() {
		return "BankAccount [ balance=" + balance + ", transactions=" + transactions
				+ ", statementPrinter=" + statementPrinter + "]";
	}

}
