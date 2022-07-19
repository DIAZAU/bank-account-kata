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

	@Test
	public void store_a_deposit_transaction() {

		val bankAccount = mock(BankAccount.class);
		val transaction = mock(Transaction.class);

		doReturn(Optional.of(bankAccount)).when(loadAccountPort).load(1234L);
		doReturn(transaction).when(bankAccount).deposit(SYSTEM_DATE, BigDecimal.valueOf(100));
		doReturn(1234L).when(bankAccount).getId();
		doReturn(BigDecimal.valueOf(100)).when(bankAccount).getBalance();

		// Given
		val id = 1234L;
		val amount = BigDecimal.valueOf(100);

		// When
		val deposit = service.deposit(id, amount);

		// Then
		assertThat(true).isEqualTo(deposit);
		assertThat(bankAccount.getId()).isEqualTo(id);
		assertThat(bankAccount.getBalance()).isEqualTo(amount);

	}

}
