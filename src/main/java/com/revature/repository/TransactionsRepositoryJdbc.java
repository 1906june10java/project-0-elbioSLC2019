package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Transactions;

import com.revature.util.ConnectionUtil;

import oracle.jdbc.OracleResultSet;

public class TransactionsRepositoryJdbc implements TransactionsRepository {

	private static final Logger LOGGER = Logger.getLogger(TransactionsRepositoryJdbc.class);
	
	@Override
	public boolean create(Transactions transaction) {
		LOGGER.trace("Entering create method with parameter: " + transaction);
		try(Connection connection = ConnectionUtil.getConnection()) {
			int parameterIndex = 0;
			String sql = "INSERT INTO TRANSACTIONS VALUES (?, ?, ?, ?, TO_DATE(?, 'MM-DD-YYYY'))";

			PreparedStatement statement = connection.prepareStatement(sql);
		
			statement.setInt(++parameterIndex, transaction.getTransac_num());
			statement.setInt(++parameterIndex, transaction.getAccount_num());
			statement.setDouble(++parameterIndex, transaction.getTransac_amount());
			statement.setString(++parameterIndex, transaction.getTransac_type());
			statement.setString(++parameterIndex, transaction.getTransac_date());

			if (statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LOGGER.error("Could not create transaction.", e);
		}
		return false;
	}

	@Override
	public boolean createSecure(Transactions transaction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Transactions findByTransac_Num(int transac_num) {
		LOGGER.trace("Entering find by Account Number method with parameter: " + transac_num);
		try(Connection connection = ConnectionUtil.getConnection()) {
			int parameterIndex = 0;
			String sql = "SELECT * FROM TRANSACTIONS WHERE TRANSAC_ACCT_NUM = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(++parameterIndex, transac_num);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				return new Transactions (
							result.getInt("ACCOUNT_NUM"),						
							result.getInt("TRANSAC_ACCT_NUM"),
							result.getDouble("TRANSAC_AMOUNT"),
							result.getString("TRANSAC_TYPE"),
							result.getString("TRANSAC_DATE")
							
						);
			}
			
		} catch (SQLException e) {
			LOGGER.error("Could not find Transaction.", e);
		}
		return null;
	}

	@Override
	public List<Transactions>findAll() {
		LOGGER.trace("Entering finding all Accounts");
		try(Connection connection = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM TRANSACTIONS ORDER BY TRANSACT_ACCOUNT_NUM";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			List<Transactions> transactions = new ArrayList<>();
			
			while(result.next()) {
				transactions.add(new Transactions (
						
							result.getInt("ACCOUNT_NUM"),						
							result.getInt("TRANSAC_ACCT_NUM"),
							result.getDouble("TRANSAC_AMOUNT"),
							result.getString("TRANSAC_TYPE"),					
							result.getString("TRANSAC_DATE")

						));
			}
			return transactions;
		} catch (SQLException e) {
			LOGGER.error("Could not find all Accounts.", e);
		}
		return null;
	}


	public static void main(String[] args) {
		TransactionsRepository repository = new TransactionsRepositoryJdbc();
		repository.create(
				new Transactions(11,
						        1005,
						        400.00,
						        "D",
						        "2019-06-23"));

		LOGGER.info(repository.findByTransac_Num(5));
		
		List<Transactions> transactions = repository.findAll();
		for(Transactions trans: transactions) {
			LOGGER.info(trans);
		}
	}
}



