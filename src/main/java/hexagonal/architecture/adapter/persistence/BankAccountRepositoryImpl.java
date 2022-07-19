package hexagonal.architecture.adapter.persistence;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Component;

import hexagonal.architecture.application.domain.BankAccount;
import hexagonal.architecture.application.mapper.BankAccountMapper;
import hexagonal.architecture.application.port.out.LoadAccountPort;
import hexagonal.architecture.application.port.out.SaveAccountPort;

@Component
public class BankAccountRepositoryImpl implements LoadAccountPort, SaveAccountPort {

	private BankAccountRepository repository;

	public BankAccountRepositoryImpl(BankAccountRepository repository) {
		this.repository = repository;
	}

	@Override
	public Optional<BankAccount> load(Long id) {
		
		BankAccountMapper bankAccountConverter = new BankAccountMapper();

		Optional<BankAccountEntity> opBankAccountEntity = repository.findById(id);

		if (opBankAccountEntity.isPresent()) {
			return Optional.empty();
		}
		return Optional.of(bankAccountConverter.toDto(opBankAccountEntity.get()));
	}

	@Override
	public Long update(Long id, BigDecimal balance) {
		return repository.update(id, balance);
	}
}
