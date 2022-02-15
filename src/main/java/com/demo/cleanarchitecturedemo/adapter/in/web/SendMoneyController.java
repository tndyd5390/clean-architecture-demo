package com.demo.cleanarchitecturedemo.adapter.in.web;

import com.demo.cleanarchitecturedemo.account.application.port.in.SendMoneyCommand;
import com.demo.cleanarchitecturedemo.account.application.port.in.SendMoneyUseCase;
import com.demo.cleanarchitecturedemo.account.domain.Account.AccountId;
import com.demo.cleanarchitecturedemo.account.domain.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class SendMoneyController {

    private final SendMoneyUseCase sendMoneyUseCase;

    @PostMapping(path = "/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}")
    void sendMoney(
        @PathVariable("sourceAccountId") Long sourceAccountId,
        @PathVariable("targetAccountId") Long targetAccountId,
        @PathVariable("amount") Long amount) {

        SendMoneyCommand command = new SendMoneyCommand(
            new AccountId(sourceAccountId),
            new AccountId(targetAccountId),
            Money.of(amount));

        sendMoneyUseCase.sendMoney(command);
    }

}
