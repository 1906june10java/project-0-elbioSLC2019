package com.revature.model;

public class Transactions  implements Comparable<Transactions> {

	private int transac_num;
	
	private int account_num;
	
	public Transactions(int transac_num, int account_num, double transac_amount, char transac_type,
			String transac_date) {
		super();
		this.transac_num = transac_num;
		this.account_num = account_num;
		this.transac_amount = transac_amount;
		this.transac_type = transac_type;
		this.transac_date = transac_date;
	}

	private double transac_amount;
	
	private char transac_type;
	
	private String transac_date;
	
	public Transactions() {}
	
//	TRANSAC_NUM	NUMBER(16,0)	Yes		TRANSACTION NUMBER	1
//	TRANSAC_ACCT_NUM	NUMBER(12,0)	Yes		TRANSACTION ACCOUNT NUMBER	2
//	TRANSAC_AMOUNT	NUMBER(10,2)	Yes		TRANSACTION AMOUNT	3
//	TRANSAC_TYPE	CHAR(1 BYTE)	Yes		"D" DEPOSIT/"W" WITHDRAWAL	4
//	TRANSAC_DATE	VARCHAR2(10 BYTE)	Yes		YYYY-MM-DD FORMAT	5

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account_num;
		long temp;
		temp = Double.doubleToLongBits(transac_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((transac_date == null) ? 0 : transac_date.hashCode());
		result = prime * result + transac_num;
		result = prime * result + transac_type;
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
		Transactions other = (Transactions) obj;
		if (account_num != other.account_num)
			return false;
		if (Double.doubleToLongBits(transac_amount) != Double.doubleToLongBits(other.transac_amount))
			return false;
		if (transac_date == null) {
			if (other.transac_date != null)
				return false;
		} else if (!transac_date.equals(other.transac_date))
			return false;
		if (transac_num != other.transac_num)
			return false;
		if (transac_type != other.transac_type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transactions [transac_num=" + transac_num + ", account_num=" + account_num + ", transac_amount="
				+ transac_amount + ", transac_type=" + transac_type + ", transac_date=" + transac_date + "]";
	}

	public int getTransac_num() {
		return transac_num;
	}

	public void setTransac_num(int transac_num) {
		this.transac_num = transac_num;
	}

	public int getAccount_num() {
		return account_num;
	}

	public void setAccount_num(int account_num) {
		this.account_num = account_num;
	}

	public double getTransac_amount() {
		return transac_amount;
	}

	public void setTransac_amount(double transac_amount) {
		this.transac_amount = transac_amount;
	}

	public char getTransac_type() {
		return transac_type;
	}

	public void setTransac_type(char transac_type) {
		this.transac_type = transac_type;
	}

	public String getTransac_date() {
		return transac_date;
	}

	public void setTransac_date(String transac_date) {
		this.transac_date = transac_date;
	}	
		
	@Override
	public int compareTo(Transactions o) {
		// TODO Auto-generated method stub
		return 0;
	}	

}