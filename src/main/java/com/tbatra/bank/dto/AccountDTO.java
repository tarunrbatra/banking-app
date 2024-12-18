package com.tbatra.bank.dto;

// using record (added in java 16) for creating a DTO
public record AccountDTO (Long id,
                          String accountHOlderName,
                          Double accountBalance) {
}

//public class AccountDTO {
//    public AccountDTO(Long id, String accountHOlderName, Double accountBalance) {
//        Id = id;
//        this.accountHOlderName = accountHOlderName;
//        this.accountBalance = accountBalance;
//    }
//
//    private Long Id;
//    private String accountHOlderName;
//    private Double accountBalance;
//
//    public Long getId() {
//        return Id;
//    }
//
//    public void setId(Long id) {
//        Id = id;
//    }
//
//    public String getAccountHOlderName() {
//        return accountHOlderName;
//    }
//
//    public void setAccountHOlderName(String accountHOlderName) {
//        this.accountHOlderName = accountHOlderName;
//    }
//
//    public Double getAccountBalance() {
//        return accountBalance;
//    }
//
//    public void setAccountBalance(Double accountBalance) {
//        this.accountBalance = accountBalance;
//    }
//}
