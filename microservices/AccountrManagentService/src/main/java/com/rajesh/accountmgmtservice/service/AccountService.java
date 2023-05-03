package com.rajesh.accountmgmtservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajesh.accountmgmtservice.dao.AccountsRepository;
import com.rajesh.accountmgmtservice.model.Accounts;

@Service
public class AccountService {

	@Autowired
	private AccountsRepository accountRepository;

	public String createAccount(Accounts id) {
		accountRepository.save(id);
		return "Created Successfully";
	}

	public Accounts getAccountInfo(int id) {
		return accountRepository.findById(id).orElse(null);
	}

	public int getBalance(int id) {
		return accountRepository.findBalanceByAcctId(id);
	}

	public String depositAmount(int id, int amount) {
		accountRepository.saveBalanceByAcctId(id, amount);
		return "Amount Deposited Successfully";
	}

	public String withdrawAmount(int id, int amount) {
		accountRepository.withdrawAmountByAcctId(id, amount);
		return "Amount Withdrawn Successfully";
	}

	public String deleteAccount(int id) {
		if (accountRepository.existsById(id)) {
			accountRepository.deleteById(id);
			return "Account Deleted Successfully";
		} else {
			return "No Record Found";
		}
	}

}
