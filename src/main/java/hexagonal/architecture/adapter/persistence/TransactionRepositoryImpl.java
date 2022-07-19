package hexagonal.architecture.adapter.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import hexagonal.architecture.application.domain.BankAccount;
import hexagonal.architecture.application.domain.Transaction;
import hexagonal.architecture.application.mapper.BankAccountMapper;
import hexagonal.architecture.application.port.out.LoadTransactionPort;
import hexagonal.architecture.application.port.out.SaveTransactionPort;

@Component
public class TransactionRepositoryImpl implements LoadTransactionPort, SaveTransactionPort {

	private TransactionRepository repository;

	public TransactionRepositoryImpl(TransactionRepository repository) {
		this.repository = repository;
	}

	@Override
	public Optional<TransactionEntity> load(Long id) {
		return repository.findById(id);
	}

	@Override
	public TransactionEntity save(BankAccount account, Transaction transaction) {
		BankAccountMapper bankAccountMapper = new BankAccountMapper();
		return repository.save(bankAccountMapper.toEntity(account, transaction));
	}
}
