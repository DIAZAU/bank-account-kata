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
		withdrawUseCase = Mockito.mock(WithdrawUseCase.class);
		bankAccountController = new BankAccountController(depositUseCase, withdrawUseCase);
	}
}
