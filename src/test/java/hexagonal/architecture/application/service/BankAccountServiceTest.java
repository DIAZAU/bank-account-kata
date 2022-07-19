package hexagonal.architecture.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hexagonal.architecture.application.domain.BankAccount;
import hexagonal.architecture.application.domain.Transaction;
import hexagonal.architecture.application.port.out.LoadAccountPort;
import hexagonal.architecture.application.port.out.SaveAccountPort;
import hexagonal.architecture.application.port.out.SaveTransactionPort;
import hexagonal.architecture.application.service.BankAccountService;
import lombok.val;

class BankAccountServiceTest {

	private LoadAccountPort loadAccountPort;
	private SaveAccountPort saveAccountPort;
	private SaveTransactionPort saveTransactionPort;
	private BankAccountService service;
	
	private static final String SYSTEM_DATE = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

	@BeforeEach
	void setUp() throws Exception {
		loadAccountPort = mock(LoadAccountPort.class);
		saveAccountPort = mock(SaveAccountPort.class);
		saveTransactionPort = mock(SaveTransactionPort.class);
		service = new BankAccountService(loadAccountPort, saveAccountPort, saveTransactionPort);
	}

}
