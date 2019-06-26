package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Bank;

import com.revature.util.ConnectionUtil;

public class BankRepositoryJdbc implements BankRepository {

	private static final Logger LOGGER = Logger.getLogger(BankRepositoryJdbc.class);

	@Override
	public boolean create(Bank bank) {
		LOGGER.trace("Entering create method with parameter: " + bank);
		try(Connection connection = ConnectionUtil.getConnection()) {
			int parameterIndex = 0;
			String sql = "INSERT INTO BANK VALUES (?, ?, ?, ?, ?)";

			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(++parameterIndex, bank.getAccount_num());
			statement.setDouble(++parameterIndex, bank.getAccount_balance());
			statement.setString(++parameterIndex, bank.getUser_name());
			statement.setString(++parameterIndex, bank.getSoc_sec_num());
			statement.setString(++parameterIndex, bank.getPassword());

			if (statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LOGGER.error("Could not create bank.", e);
		}
		return false;
	}

	@Override
	public boolean createSecure(Bank bank) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Bank findByAccountNum(int account_num) {
		LOGGER.trace("Entering find  by Account Number method with parameter: " + account_num);
		try(Connection connection = ConnectionUtil.getConnection()) {
			int parameterIndex = 0;
			String sql = "SELECT * FROM BANK WHERE ACCOUNT_NUM = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(++parameterIndex, account_num);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				return new Bank (
							result.getInt("ACCOUNT_NUM"),						
							result.getDouble("ACCOUNT_BALANCE"),
							result.getString("USER_NAME"),
							result.getString("SOC_SEC_NUM"),
							result.getString("PASSWORD")
							
						);
			}
		} catch (SQLException e) {
			LOGGER.error("Could not find Account.", e);
		}
		return null;
	}

	@Override
	public List<Bank>findAll() {
		LOGGER.trace("Entering finding all Accounts");
		try(Connection connection = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM BANK ORDER BY ACCOUNT_NUM";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			List<Bank> accounts = new ArrayList<>();
			
			while(result.next()) {
				accounts.add(new Bank (
							result.getInt("ACCOUNT_NUM"),
							result.getDouble("ACCOUNT_BALANCE"),
							result.getString("USER_NAME"),
							result.getString("SOC_SEC_NUM"),
							result.getString("PASSWORD")
						));
			}
			return accounts;
		} catch (SQLException e) {
			LOGGER.error("Could not find all Accounts.", e);
		}
		return null;
	}

	public static void main(String[] args) {
		BankRepository repository = new BankRepositoryJdbc();
		repository.create(
				new Bank(1010,
						640.00,
						"WILLIAM",
						"987654321",
						"JAVA8"
						)
				);
		
		LOGGER.info(repository.findByAccountNum(1003));
		
		List<Bank> accounts = repository.findAll();
		for(Bank bank: accounts) {
			LOGGER.info(bank);
		}
	}
}
