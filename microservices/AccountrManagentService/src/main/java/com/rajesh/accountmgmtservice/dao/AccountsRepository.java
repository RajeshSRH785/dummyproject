package com.rajesh.accountmgmtservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.rajesh.accountmgmtservice.model.Accounts;

public interface AccountsRepository extends CrudRepository<Accounts, Integer>, JpaRepository<Accounts, Integer> {

	@Query("select balance from Accounts where id = ?1")
	public int findBalanceByAcctId(int id);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Accounts set balance = balance+?2 where id=?1")
	public void saveBalanceByAcctId(int id, int balance);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Accounts set balance = balance-?2 where id=?1")
	public void withdrawAmountByAcctId(int id, int balance);
}
