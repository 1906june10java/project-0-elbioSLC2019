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
	public boolean create(Transactions transaction) {
		LOGGER.trace("Entering create method with parameter: " + transaction);
		try(Connection connection = ConnectionUtil.getConnection()) {
			int parameterIndex = 0;
			String sql = "INSERT INTO TRANSACTIONS VALUES (?, ?, ?, ?, ?)";

			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(++parameterIndex, transaction.getTransac_num());
			statement.setInt++parameterIndex, transaction.getAccount_num());
			statement.setString(++parameterIndex, transaction.getTransac_amount());
			statement.setChar(++parameterIndex, transaction.getTransac_type());
			statement.setString(++parameterIndex, transaction.getTransac_date());

			if (statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LOGGER.error("Could not create bank.", e);
		}
		return false;
	}
}




