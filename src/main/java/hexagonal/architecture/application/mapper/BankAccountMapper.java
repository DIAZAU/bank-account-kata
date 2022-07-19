package hexagonal.architecture.application.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import hexagonal.architecture.adapter.persistence.BankAccountEntity;
import hexagonal.architecture.adapter.persistence.TransactionEntity;
import hexagonal.architecture.application.domain.BankAccount;
import hexagonal.architecture.application.domain.Transaction;
import hexagonal.architecture.application.domain.Transactions;

public class BankAccountMapper {

	public BankAccount toDto(BankAccountEntity bankAccountEntity) {
		if (bankAccountEntity != null) {
			BankAccount bankAccount = new BankAccount();
			bankAccount.setId(bankAccountEntity.getId());
			bankAccount.setBalance(bankAccountEntity.getBalance());
			Transactions transactions = new Transactions();
			transactions.setTransactionList(toTransactions(bankAccountEntity.getTransactions()));
			bankAccount.setTransactions(transactions);
			return bankAccount;
		}
		return null;
	}

	public BankAccountEntity toEntity(BankAccount bankAccount) {
		if (bankAccount != null) {
			BankAccountEntity bankAccountEntity = new BankAccountEntity();
			bankAccountEntity.setId(bankAccount.getId());
			bankAccountEntity.setBalance(bankAccount.getBalance());
			return bankAccountEntity;
		}
		return null;
	}

	public TransactionEntity toEntity(BankAccount bankAccount, Transaction transaction) {
		
		if (bankAccount != null && transaction != null) {
			TransactionEntity transactionEntity = new TransactionEntity();
			transactionEntity.setDate(transaction.getDate());
			transactionEntity.setAmount(transaction.getAmount());
			transactionEntity.setBalance(transaction.getBalance());
			transactionEntity.setAccount(toEntity(bankAccount));
			return transactionEntity;
		}
		return null;
	}

	public Transaction toDto(TransactionEntity transactionEntity) {
		if (transactionEntity != null) {
			return new Transaction(transactionEntity.getDate(), transactionEntity.getAmount(),
					transactionEntity.getBalance());
		}
		return null;
	}


	public List<Transaction> toTransactions(List<TransactionEntity> liste) {
		return liste.stream().filter(Objects::nonNull).map(this::toDto).collect(Collectors.toList());
	}

}
