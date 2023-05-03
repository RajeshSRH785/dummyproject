package com.rajesh.accountmgmtservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rajesh.accountmgmtservice.model.Accounts;
import com.rajesh.accountmgmtservice.service.AccountService;


@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	// createAccount happens upon createCustomer
	@PostMapping("/account")
	public ResponseEntity<String> createCustomer(@RequestBody Accounts id) {
		String status = accountService.createAccount(id);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}

	// checkBalance
	@GetMapping("/account/{id}/balance")
	public int getBalance(@PathVariable int id) {
		return accountService.getBalance(id);
	}

	// depositAmount
	@PutMapping("/account/{id}/deposit/{amount}")
	public ResponseEntity<String> depositAmount(@PathVariable int id, @PathVariable int amount) {
		String status = accountService.depositAmount(id, amount);
		return new ResponseEntity<>(status, HttpStatus.OK);

	}

	// withdrawAmount
	@PutMapping("/account/{id}/withdraw/{amount}")
	public ResponseEntity<String> withdrawAmount(@PathVariable int id, @PathVariable int amount) {
		String status = accountService.withdrawAmount(id, amount);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	// deleteAccount
	@DeleteMapping("/account/{id}")
	public  ResponseEntity<String> deleteAccount(@PathVariable int id) {
		String status = accountService.deleteAccount(id);
		return new ResponseEntity<>(status, HttpStatus.OK);

	}

	// getAccountInfo
	@GetMapping("/account/{id}")
	public Accounts getAccountInfo(@PathVariable int id) {
		return accountService.getAccountInfo(id);
	}

}
