package hexagonal.architecture.application.domain;

import java.util.List;

public class StatementPrinter {
	

	public static final String STATEMENT_HEADER = "OPERATION  | DATE       | AMOUNT  | BALANCE";

	private Console console;

	public StatementPrinter(Console console) {
		this.console = console;
	}
	public void print(List<Transaction> transactionList) {
		printHeader();
	}

	private void printHeader() {
		console.printLine(STATEMENT_HEADER);
	}
}
