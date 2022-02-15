package com.demo.cleanarchitecturedemo.account.application.service;

import com.demo.cleanarchitecturedemo.account.application.port.in.SendMoneyCommand;
import com.demo.cleanarchitecturedemo.account.application.port.in.SendMoneyUseCase;
import com.demo.cleanarchitecturedemo.account.application.port.out.AccountLock;
import com.demo.cleanarchitecturedemo.account.application.port.out.LoadAccountPort;
import com.demo.cleanarchitecturedemo.account.application.port.out.UpdateAccountStatePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class SendMoneyService implements SendMoneyUseCase {

    private final LoadAccountPort loadAccountPort;
    private final AccountLock accountLock;
    private final UpdateAccountStatePort updateAccountStatePort;

    public boolean sendMoney(SendMoneyCommand command) {
        return false;
    }
}
