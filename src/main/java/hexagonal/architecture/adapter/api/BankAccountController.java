package hexagonal.architecture.adapter.api;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hexagonal.architecture.application.port.in.DepositUseCase;
import hexagonal.architecture.application.port.in.WithdrawUseCase;

@RestController
@RequestMapping("/account")
public class BankAccountController {

    private final DepositUseCase depositUseCase;
    private final WithdrawUseCase withdrawUseCase;

    public BankAccountController(DepositUseCase depositUseCase, WithdrawUseCase withdrawUseCase) {
        this.depositUseCase = depositUseCase;
        this.withdrawUseCase = withdrawUseCase;
    }

    @PostMapping(value = "/{id}/deposit/{amount}")
    Boolean deposit(@PathVariable final Long id, @PathVariable final BigDecimal amount) {
        return depositUseCase.deposit(id, amount);
    }

    @PostMapping(value = "/{id}/withdraw/{amount}")
    Boolean withdraw(@PathVariable final Long id, @PathVariable final BigDecimal amount) {
        return withdrawUseCase.withdraw(id, amount);
    }
}

