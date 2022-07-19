package hexagonal.architecture.adapter.api;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hexagonal.architecture.application.port.in.DepositUseCase;

@RestController
@RequestMapping("/account")
public class BankAccountController {

	private DepositUseCase depositUseCase;

	public BankAccountController(DepositUseCase depositUseCase) {
		this.depositUseCase = depositUseCase;
	}

	@PostMapping(value = "/{id}/deposit/{amount}")
	public Boolean deposit(long id, BigDecimal amount) {
		 return depositUseCase.deposit(id, amount);
	}

}
