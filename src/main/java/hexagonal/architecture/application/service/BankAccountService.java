package hexagonal.architecture.application.service;

import hexagonal.architecture.application.port.in.SaveTransactionPort;
import hexagonal.architecture.application.port.out.LoadAccountPort;
import hexagonal.architecture.application.port.out.SaveAccountPort;

public class BankAccountService {

	public BankAccountService(LoadAccountPort loadAccountPort, SaveAccountPort saveAccountPort,
			SaveTransactionPort saveTransactionPort) {
		// TODO Auto-generated constructor stub
	}

}
