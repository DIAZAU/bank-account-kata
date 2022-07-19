package hexagonal.architecture.adapter.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BankAccountRepositoryImplTest {

	BankAccountRepository bankAccountrepository;
	BankAccountRepositoryImpl bankAccountRepositoryImpl;

	@BeforeEach
	void setUp() throws Exception {
		bankAccountrepository = Mockito.mock(BankAccountRepository.class);
		bankAccountRepositoryImpl = new BankAccountRepositoryImpl(bankAccountrepository);
	}

	@Test
	void should_update_the_balance_of_the_account() {
		
		given(bankAccountrepository.update(1L, BigDecimal.valueOf(500))).willReturn(1L);

		// act and assert
		Long id = bankAccountRepositoryImpl.update(1L, BigDecimal.valueOf(500));
		assertThat(id).isEqualTo(1L);

		// verify
		verify(bankAccountrepository).update(1L, BigDecimal.valueOf(500));
	}

}
