package hexagonal.architecture.application.domain;

import java.util.List;

public class StatementPrinter {
	
	public static final String STATEMENT_HEADER = "OPERATION  | DATE       | AMOUNT  | BALANCE";

	private Console console;

	public StatementPrinter(Console console) {
		this.console = console;
	}

	public void print(List<Transaction> noTransacions) {
		printHeader();
		
	}

	private void printHeader() {
		console.printLine(STATEMENT_HEADER);
	}
}
