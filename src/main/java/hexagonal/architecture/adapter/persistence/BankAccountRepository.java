package hexagonal.architecture.adapter.persistence;

import java.math.BigDecimal;

public interface BankAccountRepository {

	Object update(long l, BigDecimal valueOf);

}
