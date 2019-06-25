package com.revature.model;

public class Bank implements Comparable<Bank> {

	private int account_num;
	
	private double account_balance;
	
	private String user_name;
	
	public Bank(int account_num, double account_balance, String user_name, String soc_sec_num, String password) {
		super();
		this.account_num = account_num;
		this.account_balance = account_balance;
		this.user_name = user_name;
		this.soc_sec_num = soc_sec_num;
		this.password = password;
	}

	private String soc_sec_num;
	
	private String password;
	
	public Bank() {}

	public int getAccount_num() {
		return account_num;
	}

	public void setAccount_num(int account_num) {
		this.account_num = account_num;
	}

	public double getAccount_balance() {
		return account_balance;
	}

	public void setAccount_balance(double account_balance) {
		this.account_balance = account_balance;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getSoc_sec_num() {
		return soc_sec_num;
	}

	public void setSoc_sec_num(String soc_sec_num) {
		this.soc_sec_num = soc_sec_num;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(account_balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + account_num;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((soc_sec_num == null) ? 0 : soc_sec_num.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		if (Double.doubleToLongBits(account_balance) != Double.doubleToLongBits(other.account_balance))
			return false;
		if (account_num != other.account_num)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (soc_sec_num == null) {
			if (other.soc_sec_num != null)
				return false;
		} else if (!soc_sec_num.equals(other.soc_sec_num))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bank [account_num=" + account_num + ", account_balance=" + account_balance + ", user_name=" + user_name
				+ ", soc_sec_num=" + soc_sec_num + ", password=" + password + "]";
	}

	@Override
	public int compareTo(Bank o) {
		// TODO Auto-generated method stub
		return 0;
	}	
}
