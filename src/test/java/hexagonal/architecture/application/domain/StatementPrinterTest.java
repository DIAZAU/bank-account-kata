package hexagonal.architecture.application.domain;

import static hexagonal.architecture.application.domain.StatementPrinter.STATEMENT_HEADER;
import static org.mockito.Mockito.verify;

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

}
