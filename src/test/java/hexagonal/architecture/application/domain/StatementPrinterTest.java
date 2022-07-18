package hexagonal.architecture.application.domain;

import static hexagonal.architecture.application.domain.StatementPrinter.STATEMENT_HEADER;
import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StatementPrinterTest {

	private static final List<Transaction> NO_TRANSACIONS = Collections.emptyList();
	private StatementPrinter statementPrinter;
	Console console;
	
	@BeforeEach
	void setUp() throws Exception {
		console = Mockito.mock(Console.class);
		statementPrinter = new StatementPrinter(console);
	}
	
	@Test
	public void print_header_even_when_there_are_no_transactions() {
		statementPrinter.print(NO_TRANSACIONS);
		verify(console).printLine(STATEMENT_HEADER);
	}
	
	@Test
	public void print_transactions_in_chronological_order() {

		//when
		Transaction deposit_1 = new Transaction("01/04/2014", BigDecimal.valueOf(1000), BigDecimal.valueOf(1000));
		Transaction withdrawal = new Transaction("02/04/2014", BigDecimal.valueOf(-100), BigDecimal.valueOf(900));
		Transaction deposit_2 = new Transaction("10/04/2014", BigDecimal.valueOf(500), BigDecimal.valueOf(1400));
		List<Transaction> transactionList = asList(deposit_1, withdrawal, deposit_2);

		//given
		statementPrinter.print(transactionList);

		//then
		verify(console).printLine("OPERATION  | DATE       | AMOUNT  | BALANCE");
		verify(console).printLine("Deposit | 01/04/2014 | 1000,00 | 1000,00");
		verify(console).printLine("Withdraw | 02/04/2014 | -100,00 | 900,00");
		verify(console).printLine("Deposit | 10/04/2014 | 500,00 | 1400,00");

	}

}
