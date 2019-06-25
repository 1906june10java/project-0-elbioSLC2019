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

public class TransactionsRepositoryJdbc implements TransactionsRepository {

	private static final Logger LOGGER = Logger.getLogger(TransactionsRepositoryJdbc.class);
	
	@Override
	public boolean create(Transactions transactions) {
		LOGGER.trace("Entering create method with parameter: " + transactions);
		try(Connection connection = ConnectionUtil.getConnection()) {
			int parameterIndex = 0;
			String sql = "INSERT INTO TRANSACTIONS VALUES (?, ?, ?, ?, ?)";

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
}




