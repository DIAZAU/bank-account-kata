package hexagonal.architecture.adapter.persistence;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "account")
public class BankAccountEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;
	
	@Column(name = "account_balance")
    private BigDecimal balance;
	
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private List<TransactionEntity> transactions;
	
}
