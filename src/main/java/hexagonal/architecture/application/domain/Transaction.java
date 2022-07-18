package hexagonal.architecture.application.domain;

import java.math.BigDecimal;

public class Transaction {
	
	private final String date;
	private final BigDecimal amount;
	private final BigDecimal balance;

	public Transaction(String string, BigDecimal valueOf, BigDecimal valueOf2) {
		this.date = string;
		this.amount = valueOf;
		this.balance = valueOf2;
	}

}