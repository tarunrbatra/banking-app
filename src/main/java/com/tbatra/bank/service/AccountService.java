package com.tbatra.bank.service;

import com.tbatra.bank.dto.AccountDTO;

import java.util.List;

public interface AccountService {

    AccountDTO createAccount (AccountDTO accountDTO);

    AccountDTO getAccountbyId (Long id);

    AccountDTO depositAmount (Long id, Double amount);

    AccountDTO withdrawAmount (Long id, Double amount);

    List<AccountDTO> getAllAccounts ();

    String deleteAccount (Long id);

}
