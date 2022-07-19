package hexagonal.architecture;

import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hexagonal.architecture.application.domain.BankAccount;
import hexagonal.architecture.application.domain.Clock;

@SpringBootApplication
public class HexagonalApplication {
	public static void main(final String[] args) {
		SpringApplication.run(HexagonalApplication.class, args);
		
		Clock clock = new Clock();
		BankAccount account = new BankAccount();

		account.deposit(clock.dateAsString(), BigDecimal.valueOf(1000));
		account.withdraw(clock.dateAsString(), BigDecimal.valueOf(-300));
		account.withdraw(clock.dateAsString(), BigDecimal.valueOf(-50));
		account.deposit(clock.dateAsString(), BigDecimal.valueOf(500));

		account.printStatement();
	}
}
