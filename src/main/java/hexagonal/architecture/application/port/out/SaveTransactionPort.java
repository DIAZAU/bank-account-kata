package hexagonal.architecture.application.port.out;

import hexagonal.architecture.adapter.persistence.TransactionEntity;
import hexagonal.architecture.application.domain.BankAccount;
import hexagonal.architecture.application.domain.Transaction;

public interface SaveTransactionPort {
	TransactionEntity save(BankAccount account, Transaction transaction);
}