package hexagonal.architecture.application.domain;

import static java.util.stream.Collectors.toList;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class StatementPrinter {
	

	public static final String STATEMENT_HEADER = "OPERATION  | DATE       | AMOUNT  | BALANCE";

	private Console console;

	public StatementPrinter(Console console) {
		this.console = console;
	}
	public void print(List<Transaction> transactionList) {
		printHeader();
		printStatementLinesFor(transactionList);
	}

	private void printHeader() {
		console.printLine(STATEMENT_HEADER);
	}
	
	private void printStatementLinesFor(List<Transaction> transactionList) {
		List<String> statementLines = statementLines(transactionList);
		statementLines.forEach(console::printLine);
	}
	
	private List<String> statementLines(List<Transaction> transactionList) {
		AtomicInteger runningBalance = new AtomicInteger(0);
		return transactionList
							.stream()
							.map(transaction -> statementLine(runningBalance, transaction))
							.collect(toList());
	}

	private String statementLine(AtomicInteger runningBalance, Transaction t) {
		return  (t.getAmount().compareTo(BigDecimal.ZERO) >0 ? "Deposit" : "Withdraw") +
				" | " +
				t.getDate() +
				" | " +
				formatDecimal(t.getAmount()) +
				" | " +
				formatDecimal(t.getBalance());
	}

	private String formatDecimal(BigDecimal amount) {
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		return decimalFormat.format(amount);
	}

}
