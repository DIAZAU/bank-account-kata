package hexagonal.architecture.application.domain;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * 
 * @author cisse
 *
 */
class TransactionsTest {

	private Transactions transactions;
	
	@BeforeEach
	void setUp() throws Exception {
		transactions = new Transactions();
	}

	/*
	 * Function to test transactions on the same order there were added
	 */
	@Test public void
	return_transactions_on_the_same_order_they_were_added() {
		Transaction deposit = new Transaction("17/07/2022", BigDecimal.valueOf(100), BigDecimal.valueOf(0));
		Transaction withdrawal = new Transaction("18/07/2022", BigDecimal.valueOf(-50), BigDecimal.valueOf(50) );

		transactions.add(deposit);
		transactions.add(withdrawal);

		List<Transaction> transactionList = transactions.all();

		assertThat(transactionList.size(), is(2));
		assertThat(transactionList.get(0), is(deposit));
		assertThat(transactionList.get(1), is(withdrawal));
	}

}
