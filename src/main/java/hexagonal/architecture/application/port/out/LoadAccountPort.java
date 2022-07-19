package hexagonal.architecture.application.port.out;

import java.util.Optional;

import hexagonal.architecture.application.domain.BankAccount;

public interface LoadAccountPort {
    Optional<BankAccount> load(Long id);
}