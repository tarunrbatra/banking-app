package com.tbatra.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankingAppApplication {

	public static void main(String[] args) {

		System.out.println("###################################");
		System.out.println("####### Banking Application #######");
		System.out.println("###################################");

		SpringApplication.run(BankingAppApplication.class, args);

	}

}
