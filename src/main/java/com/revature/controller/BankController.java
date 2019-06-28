package com.revature.controller;

import java.util.Scanner;

public class BankController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please input something: ");
		String userInput = scanner.nextLine();
		System.out.println("User input: " + userInput);
	
		Integer i = Integer.parseInt(userInput);
		System.out.println(i);
	}
}
