package com.tbatra.bank.service.impl;

import com.tbatra.bank.dto.AccountDTO;
import com.tbatra.bank.entity.Account;
import com.tbatra.bank.exception.AccountException;
import com.tbatra.bank.mapper.AccountMapper;
import com.tbatra.bank.repository.AccountRepository;
import com.tbatra.bank.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {

        Account account = AccountMapper.mapToAccount(accountDTO);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDTO(savedAccount);
    }

    @Override
    public AccountDTO getAccountbyId(Long id) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountException("Account does not exists"));

        return AccountMapper.mapToAccountDTO(account);
    }

    @Override
    public AccountDTO depositAmount(Long id, Double amount) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountException("Account does not exists"));

        Double newBalance = account.getAccountBalance() + amount;
        account.setAccountBalance(newBalance);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDTO(savedAccount);
    }

    @Override
    public AccountDTO withdrawAmount(Long id, Double withdrawAmount) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountException("Account does not exists"));

        // validate if sufficient balance in the account
        if (account.getAccountBalance() < withdrawAmount) {
            new RuntimeException("Insufficient balance");
        }

        Double newBalance = account.getAccountBalance() - withdrawAmount;
        account.setAccountBalance(newBalance);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDTO(savedAccount);
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        List<Account> accountList = accountRepository.findAll();
        List<AccountDTO> accountDTOS = accountList.stream().map(account -> AccountMapper.mapToAccountDTO(account))
                .collect(Collectors.toList());

        return accountDTOS;
    }

    @Override
    public String deleteAccount(Long id) {

        accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountException("Account does not exists"));

        accountRepository.deleteById(id);
        return "Account " + id + " delete successfully";
    }
}
