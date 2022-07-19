package hexagonal.architecture.application.service;

import java.math.BigDecimal;

import hexagonal.architecture.application.port.out.LoadAccountPort;
import hexagonal.architecture.application.port.out.SaveAccountPort;
import hexagonal.architecture.application.port.out.SaveTransactionPort;

public class BankAccountService {

	public BankAccountService(LoadAccountPort loadAccountPort, SaveAccountPort saveAccountPort,
			SaveTransactionPort saveTransactionPort) {
		// TODO Auto-generated constructor stub
	}

	public Object deposit(long id, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

}
