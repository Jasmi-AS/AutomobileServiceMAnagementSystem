package com.automobile.utility;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Scanner;

import com.automobile.dao.LoginDAO;

public class LoginUtility {
	public static void main(String[] args) throws MalformedURLException, IOException {
		login();
	}

	public static void login() throws MalformedURLException, IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("---Login---");
		System.out.println();

		System.out.println("Enter User Name :");
		String userName = scanner.nextLine();
		System.out.println("Enter Password :");
		String password = scanner.nextLine();

		LoginDAO loginDao = new LoginDAO();
		boolean isLoginValid;
		try {
			isLoginValid = loginDao.findByUsernameAndPassword(userName, password);
			if (isLoginValid) {
				ProjectUtility.projectMenu();
			} else {
				System.out.println("Login Failed! Incorrect user name or password. Try again");
				System.out.println();
				login();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
