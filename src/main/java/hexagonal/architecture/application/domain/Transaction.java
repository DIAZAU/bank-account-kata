package hexagonal.architecture.application.domain;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

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
	
	@Override
	public boolean equals(Object o) {
		return reflectionEquals(this, o);
	}

	@Override
	public int hashCode() {
		return reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return "Transaction{ date=" + date + ", amount=" + amount + ", balance="
				+ balance + '\'' + '}';
	}
}