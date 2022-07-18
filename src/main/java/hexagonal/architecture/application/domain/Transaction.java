package hexagonal.architecture.application.domain;

import java.math.BigDecimal;

public class Transaction {
	
	private final String date;
	private final BigDecimal amount;
	private final BigDecimal balance;

	public Transaction(String date, BigDecimal amount, BigDecimal balance) {
		this.date = date;
		this.amount = amount;
		this.balance = balance;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public String getDate() {
		return date;
	}

	public BigDecimal getBalance() {
		return balance;
	}
}