package hexagonal.architecture.application.domain;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

public class Transactions {

	private List<Transaction> transactionList = new ArrayList<>();
	
	public void add(Transaction deposit) {
		transactionList.add(deposit);
		
	}

	public List<Transaction> all() {
		return unmodifiableList(transactionList);
	}

}
