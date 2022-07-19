package hexagonal.architecture.adapter.configuration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hexagonal.architecture.adapter.persistence.BankAccountRepositoryImpl;
import hexagonal.architecture.application.port.out.SaveTransactionPort;
import hexagonal.architecture.application.service.BankAccountService;

@SpringBootApplication
public class BeanConfiguration {

    @Bean
    BankAccountService bankAccountService(BankAccountRepositoryImpl repository, SaveTransactionPort saveTransactionPort) {
        return new BankAccountService(repository, repository, saveTransactionPort);
    }
}
