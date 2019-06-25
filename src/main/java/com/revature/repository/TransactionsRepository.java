package com.revature.repository;

import java.util.List;

import com.revature.model.Transactions;

/**
 * 
 * This is the  DAO (Data Access Object).
 * 
 * -> Defines CRUD operations for this particular pojo.
 * -> NO BUSINESS LOGIC SHOULD BE PRESENT on these kind of
 * Objects.
 */

public interface TransactionsRepository {

	/**
	 * Will insert a transaction into the database table.
	 * 
	 * @param transaction
	 * @return if the record was inserted
	 */ 
	public boolean create(Transactions transaction);
	
	/**
	 * Will insert a hero into the database table,
	 * but using a stored procedure.
	 * 
	 * @param transactions
	 * @return if the record was inserted
	 */
	public boolean createSecure(Transactions transaction);
	
	public Transactions findByTransac_Num(int transac_num);
	
	public List<Transactions> findAll();
	
}