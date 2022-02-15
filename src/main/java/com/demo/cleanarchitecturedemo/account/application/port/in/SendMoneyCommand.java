package com.demo.cleanarchitecturedemo.account.application.port.in;


import com.demo.cleanarchitecturedemo.account.domain.Account;
import com.demo.cleanarchitecturedemo.account.domain.Account.AccountId;
import com.demo.cleanarchitecturedemo.account.domain.Money;
import com.demo.cleanarchitecturedemo.common.SelfValidating;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class SendMoneyCommand extends SelfValidating<SendMoneyCommand> {

    @NotNull
    private final Account.AccountId sourceAccountId;

    @NotNull
    private final Account.AccountId targetAccountId;

    @NotNull
    private final Money money;

    public SendMoneyCommand(
        AccountId sourceAccountId,
        AccountId targetAccountId,
        Money money) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.money = money;
        this.validateSelf();
    }
}
