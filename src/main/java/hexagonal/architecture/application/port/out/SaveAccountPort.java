package hexagonal.architecture.application.port.out;

import java.math.BigDecimal;

public interface SaveAccountPort {
	Long update(Long id, BigDecimal balance);
}