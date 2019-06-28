package com.revature.controller;

import java.util.Scanner;
import com.revature.model.Bank;
import com.revature.repository.BankRepository;
import com.revature.repository.BankRepositoryJdbc;

public class BankLogic {
	

	public static void displayMenu() {
		System.out.println("                                                          *******************************************************");
		System.out.println("                                                          *                 REVATURE BANK MENU                  *");
		System.out.println("                                                          *******************************************************");
		System.out.println("                                                          *                                                     *");
		System.out.println("                                                          *              [ 1 ] Register user.                   *");
		System.out.println("                                                          *              [ 2 ] Login to account.                *");
		System.out.println("                                                          *              [ 3 ] Make a Deposit.                  *");
		System.out.println("                                                          *              [ 4 ] Make a Withdrawal.               *");
		System.out.println("                                                          *              [ 5 ] Check account balance.           *");
		System.out.println("                                                          *              [ 6 ] List transactions.               *");
		System.out.println("                                                          *              [ 7 ] Logout.                          *");
		System.out.println("                                                          *              [ 8 ] Exit.                            *");
		System.out.println("                                                          *                                                     *");
		System.out.println("                                                          *******************************************************");
		System.out.print("                                                                           Enter your selection : ");		
	}
	

	public static void registerUser() {
		
		System.out.println("Hello from the registerUser() method.");
	}
	public static void loginUser() {
		System.out.println("Hello from the loginUser() method.");
	}
	public static void makeAdeposit() {
//		BankRepository repository = new BankRepositoryJdbc();
//		Bank bankUser = new Bank();
//		double deposit = 0.00;
//		int account;
//		System.out.print("Enter your account number : ");
//		Scanner scanner = new Scanner(System.in);
//		String userInput = scanner.nextLine();
//		account = Integer.parseInt(userInput);
//		if ((account > 0 )|| (account <= 9000)) {
//			bankUser = repository.findByAccountNum(account);
//	
//		} else {
//			System.out.println("Account number out of range [ 0 - 9000].");
//		}
		
		
		System.out.println("Hello from the makeAdeposit() method.");
	}
	public static void makeAwithdrawal() {
			
		System.out.println("Hello from the makeAwithdrawal() method.");
	}
	public static void checkBalance() {
		BankRepository repository = new BankRepositoryJdbc();
		Bank bankUser = new Bank();
		bankUser = repository.findByAccountNum(1001);
		System.out.println("Your account balance is $ " + String.format("%.2f", bankUser.getAccount_balance()));
		System.out.println("Account number : " + bankUser.getAccount_num());
		System.out.println("User name : " + bankUser.getUser_name());
		System.out.println("Social : " + bankUser.getSoc_sec_num());
	}
	public static void listTransactions() {
		System.out.println("Hello from the listTransactions() method.");
	}
	public static void logoutUser() {
		System.out.println("Hello from the logoutUser() method.");
	}
	public static void bankMenu() {
		displayMenu();
		int account = 0;
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();	
		Integer menuChoice = Integer.parseInt(userInput);
		while (( menuChoice >= 1 ) || ( menuChoice <= 7 )) {
			switch(menuChoice) {
			case 1 : 
				registerUser();
				break;
			case 2 :
				loginUser();
				break;
			case 3 :
				makeAdeposit();
				break;
			case 4 :
				makeAwithdrawal();
				break;
			case 5 :
				checkBalance();				
				break;
			case 6 :
				listTransactions();
				break;
			case 7 :
				logoutUser();
				break;
			}
			displayMenu();
			userInput = scanner.nextLine();	
			menuChoice = Integer.parseInt(userInput);
		}
		System.exit(0);
	}
	public static boolean validateUsername(String username) {	
		boolean goodOne = ((username.equals("")) ? false : true);
		return goodOne;
	}
	public static String readAccount() {
		Scanner forString = new Scanner(System.in);
		System.out.print("Enter your account number : ");
		String accountNum = forString.nextLine();
		String trimmed = accountNum.trim();

		return trimmed;	
	}
	public static boolean validateAccount(String acct) {	
		boolean goodOne = ((acct.equals("")) ? false : true);
		return goodOne;
	}
	public static String readSocial() {
		
		Scanner forString = new Scanner(System.in);
		System.out.print("Enter your Social Security Number w/o hyphens : ");
		String socialSecNum = forString.nextLine();
		String trimmed = socialSecNum.trim();

		return trimmed;	
	}
	public static boolean validateSocial(String ssnum) {	
		boolean goodOne = ((ssnum.equals("")) ? false : true);
		return goodOne;
	}
	public static String readPassword() {
		
		Scanner forString = new Scanner(System.in);
		System.out.print("Enter your password : ");
		String password = forString.nextLine();
		String trimmed = password.trim();

		return trimmed;	
	}
	public static boolean validatePassword(String pwd) {	
		boolean goodOne = ((pwd.equals("")) ? false : true);
		return goodOne;
	}
	
	public static void main(String[] args) {

		bankMenu();	

	}	
}
