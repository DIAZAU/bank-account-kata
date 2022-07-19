package hexagonal.architecture.adapter.persistence;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "transaction")
public class TransactionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private Long id;

	@Column(name = "transaction_date")
	private String date;
	
	@Column(name = "transaction_amount")
	private BigDecimal amount;
	
	@Column(name = "transaction_balance")
	private BigDecimal balance;

	@ManyToOne
	@JoinColumn(name = "transaction_account_id")
	private BankAccountEntity account;
	
}
