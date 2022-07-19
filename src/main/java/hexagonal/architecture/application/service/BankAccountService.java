package hexagonal.architecture.application.service;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

import hexagonal.architecture.application.domain.BankAccount;
import hexagonal.architecture.application.domain.Clock;
import hexagonal.architecture.application.domain.Transaction;
import hexagonal.architecture.application.port.in.DepositUseCase;
import hexagonal.architecture.application.port.in.WithdrawUseCase;
import hexagonal.architecture.application.port.out.LoadAccountPort;
import hexagonal.architecture.application.port.out.SaveAccountPort;
import hexagonal.architecture.application.port.out.SaveTransactionPort;

public class BankAccountService implements DepositUseCase, WithdrawUseCase {

	private LoadAccountPort loadAccountPort;
	private SaveAccountPort saveAccountPort;
	private SaveTransactionPort saveTransactionPort;

	public BankAccountService(LoadAccountPort loadAccountPort, SaveAccountPort saveAccountPort,
			SaveTransactionPort saveTransactionPort) {
		this.loadAccountPort = loadAccountPort;
		this.saveAccountPort = saveAccountPort;
		this.saveTransactionPort = saveTransactionPort;
	}

	@Override
	public Boolean deposit(Long id, BigDecimal amount) throws NullPointerException {

		BankAccount account = loadAccountPort.load(id).orElseThrow(NoSuchElementException::new);

		Transaction transaction = account.deposit(new Clock().dateAsString(), amount);
		return saveAccountTransaction(id, account, transaction);
	}

	@Override
	public boolean withdraw(Long id, BigDecimal amount) throws NullPointerException {
		BankAccount account = loadAccountPort.load(id).orElseThrow(NoSuchElementException::new);
		Transaction transaction = account.withdraw(new Clock().dateAsString(), account.getBalance());
		return saveAccountTransaction(id, account, transaction);
	}

	private Boolean saveAccountTransaction(Long id, BankAccount account, Transaction transaction) {
		if (transaction != null) {
			saveAccountPort.update(id, account.getBalance());
			saveTransactionPort.save(account, transaction);
			return true;
		}
		return false;
	}
}
