package hexagonal.architecture.application.domain;

import java.math.BigDecimal;

public class BankAccount {

	private BigDecimal balance;
	private Transactions transactions;
	private StatementPrinter statementPrinter;
	
	public BankAccount(Transactions transactions, StatementPrinter statementPrinter, BigDecimal valueOf) {
		this.transactions = transactions;
		this.statementPrinter = statementPrinter;
		this.balance = valueOf;
	}

	public void deposit(String systemDate, BigDecimal valueOf) {
		balance = balance.add(valueOf);
		Transaction deposit = new Transaction(systemDate, valueOf, balance);
		transactions.add(deposit);
	}

}
