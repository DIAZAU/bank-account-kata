package hexagonal.architecture.application.port.out;

import java.util.Optional;

import hexagonal.architecture.adapter.persistence.TransactionEntity;

public interface LoadTransactionPort {
    Optional<TransactionEntity> load(Long id);
}