package com.revature.repository;

import java.util.List;

import com.revature.model.Bank;

/**
 * 
 * This is the  DAO (Data Access Object).
 * 
 * -> Defines CRUD operations for this particular pojo.
 * -> NO BUSINESS LOGIC SHOULD BE PRESENT on these kind of
 * Objects.
 */

public interface BankRepository {

	/**
	 * Will insert a hero into the database table.
	 * 
	 * @param bank
	 * @return if the record was inserted
	 */ 
	public boolean create(Bank bank);
	
	/**
	 * Will insert a hero into the database table,
	 * but using a stored procedure.
	 * 
	 * @param bank
	 * @return if the record was inserted
	 */
	public boolean createSecure(Bank bank);
	
	public Bank findByAccountNum(int account_num);
	
	public List<Bank> findAll();
	
}

