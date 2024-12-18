package com.tbatra.bank.dto;

// using record (added in java 16) for creating a DTO
public record AccountDTO (Long id,
                          String accountHOlderName,
                          Double accountBalance) {
}