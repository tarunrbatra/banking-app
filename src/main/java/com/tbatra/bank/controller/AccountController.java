package com.tbatra.bank.controller;

import com.tbatra.bank.dto.AccountDTO;
import com.tbatra.bank.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 *
 *
 *
 */

@RestController
@RequestMapping("api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Add account api endpoint
    @PostMapping()
    public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO) {
        return new ResponseEntity<>(accountService.createAccount(accountDTO), HttpStatus.CREATED);
    }

    // Get account api endpoint
    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getAccountbyId(id));
    }

    // Deposit amount api endpoint
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDTO> depositAmount(@PathVariable Long id,
                                                    @RequestBody Map<String, Double> requestMap) {

        Double amount = requestMap.get("amount");
        AccountDTO accountDTO = accountService.depositAmount(id, amount);

        return ResponseEntity.ok(accountDTO);
    }

    // Withdraw amount api endpoint
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDTO> withdrawAmount(@PathVariable Long id,
                                                    @RequestBody Map<String, Double> requestMap) {

        Double amount = requestMap.get("amount");
        AccountDTO accountDTO = accountService.withdrawAmount(id, amount);

        return ResponseEntity.ok(accountDTO);
    }

    // Api endpoint to get a list of all accounts
    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {

        List<AccountDTO> accountDTOs = accountService.getAllAccounts();

        return ResponseEntity.ok(accountDTOs);
    }

    // Api endpoint to delete a account
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.deleteAccount(id));
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from AccountController";
    }

}