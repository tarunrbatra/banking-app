package com.tbatra.bank.mapper;

import com.tbatra.bank.dto.AccountDTO;
import com.tbatra.bank.entity.Account;

public class AccountMapper {

    public static Account mapToAccount (AccountDTO accountDTO) {

        Account account = new Account(
                accountDTO.id(),
                accountDTO.accountHOlderName(),
                accountDTO.accountBalance()
        );

        return account;
    }

    public static AccountDTO mapToAccountDTO (Account account) {

        AccountDTO accountDTO = new AccountDTO(
                account.getId(),
                account.getAccountName(),
                account.getAccountBalance()
        );

        return accountDTO;

    }

}
