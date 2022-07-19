package hexagonal.architecture.adapter.persistence;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class BankAccountRepositoryImpl {

	private BankAccountRepository repository;
	
	public BankAccountRepositoryImpl(BankAccountRepository repository) {
		this.repository = repository;
	}

	public Long update(long l, BigDecimal valueOf) {
		return repository.update(l, valueOf);
	}

}
