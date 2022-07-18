package hexagonal.architecture.application.domain;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BankAccountTest {

	private static final String SYSTEM_DATE = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	Transactions transactions;
	Clock clock;
	StatementPrinter statementPrinter;
	private BankAccount account;
	private static final List<Transaction> TRANSACTION_LIST = new ArrayList<>();

	@BeforeEach
	void setUp() throws Exception {

		clock = Mockito.mock(Clock.class);
		transactions = Mockito.mock(Transactions.class);
		statementPrinter = Mockito.mock(StatementPrinter.class);
		given(clock.dateAsString()).willReturn(SYSTEM_DATE);
		account = new BankAccount(transactions, statementPrinter, BigDecimal.valueOf(400));
	}

	@Test
	void store_a_deposit_transaction() {
		// when
		Transaction deposit = new Transaction(SYSTEM_DATE, BigDecimal.valueOf(100), BigDecimal.valueOf(500));

		// given
		account.deposit(SYSTEM_DATE, BigDecimal.valueOf(100));

		// then
		verify(transactions).add(eq(deposit));
	}
	
	@Test public void
	store_a_withdrawal_transaction() {
	
		Transaction withdrawal = new Transaction(SYSTEM_DATE, BigDecimal.valueOf(-100), BigDecimal.valueOf(300));

		account.withdraw(SYSTEM_DATE, BigDecimal.valueOf(-100));

		verify(transactions).add(eq(withdrawal));
	}
	
	@Test public void
	print_a_statement_containing_all_transactions() {
		given(transactions.all()).willReturn(TRANSACTION_LIST);

		account.printStatement();

		verify(statementPrinter).print(TRANSACTION_LIST);
	}
	
}
