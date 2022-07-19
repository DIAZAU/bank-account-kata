package hexagonal.architecture.application.domain;

import java.math.BigDecimal;

public class BankAccount {

	private Long id;
	private BigDecimal balance;
	private Transactions transactions;
	private StatementPrinter statementPrinter;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Transactions getTransactions() {
		return transactions;
	}

	public void setTransactions(Transactions transactions) {
		this.transactions = transactions;
	}

	public StatementPrinter getStatementPrinter() {
		return statementPrinter;
	}

	public void setStatementPrinter(StatementPrinter statementPrinter) {
		this.statementPrinter = statementPrinter;
	}

	public BankAccount() {
		this.transactions = new Transactions();
		this.statementPrinter = new StatementPrinter(new Console());
		this.balance = BigDecimal.valueOf(0);
	}

	public BankAccount(Transactions transactions, StatementPrinter statementPrinter, BigDecimal balance) {
		this.transactions = transactions;
		this.statementPrinter = statementPrinter;
		this.balance = balance;
	}

	public Transaction withdraw(String clock, BigDecimal amount) {
		if (balance.compareTo(amount) < 0) {
			return null;
		}

		balance = balance.add(amount);
		Transaction withdraw = new Transaction(clock, amount, balance);
		transactions.add(withdraw);
		return withdraw;
	}

	public Transaction deposit(String clock, BigDecimal amount) {
		balance = balance.add(amount);
		Transaction deposit = new Transaction(clock, amount, balance);
		transactions.add(deposit);
		return deposit;
	}

	public void printStatement() {
		statementPrinter.print(transactions.all());
	}

	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", balance=" + balance + ", transactions=" + transactions
				+ ", statementPrinter=" + statementPrinter + "]";
	}

}
