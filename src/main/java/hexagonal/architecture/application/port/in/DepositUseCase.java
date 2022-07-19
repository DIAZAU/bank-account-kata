package hexagonal.architecture.application.port.in;

import java.math.BigDecimal;

public interface DepositUseCase {
	Boolean deposit(Long id, BigDecimal amount);
}