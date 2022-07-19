package hexagonal.architecture.adapter.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import hexagonal.architecture.application.port.in.DepositUseCase;
import hexagonal.architecture.application.port.in.WithdrawUseCase;
import lombok.val;

class BankAccountControllerTest {

	private DepositUseCase depositUseCase;
	private WithdrawUseCase withdrawUseCase;
	private BankAccountController bankAccountController;

	@BeforeEach
	void setUp() throws Exception {
		depositUseCase = Mockito.mock(DepositUseCase.class);
		bankAccountController = new BankAccountController(depositUseCase);
	}
	
	@Test
	public void should_convert_request_to_command_and_call_deposit() {
		
		// Given
		doReturn(true).when(depositUseCase).deposit(1234L, BigDecimal.valueOf(100));

		// When
		val created = bankAccountController.deposit(1234L, BigDecimal.valueOf(100));

		// Then
		assertThat(created).isEqualTo(true);
	}
	
	
	@Test
	public void should_convert_request_to_command_and_call_withdraw() {
		
		// Given
		doReturn(true).when(withdrawUseCase).withdraw(1234L, BigDecimal.valueOf(-100));

		// When
		val created = bankAccountController.withdraw(1234L, BigDecimal.valueOf(-100));

		// Then
		assertThat(created).isEqualTo(true);
	}
}
