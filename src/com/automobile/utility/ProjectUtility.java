package com.automobile.utility;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

import com.automobile.entity.Vehicle;

public class ProjectUtility {

	public static void main(String[] args) throws MalformedURLException, IOException {
		LoginUtility login=new LoginUtility();
		projectMenu();
	}

	public static void projectMenu() throws MalformedURLException, IOException {

		Scanner scanner = new Scanner(System.in);
		System.out.println("******************AUTOMOBILE SERVICE MANAGEMENT SYSTEM*********************");
		boolean condition = true;
		do {
			System.out.println("Enter your Choice");
			System.out.println("---------------------------------");
			System.out.println("1. Staff ");
			System.out.println("2. Spareparts");
			System.out.println("3. Customer ");
			System.out.println("4. Vehicle ");
			System.out.println("5. Reservation ");
			System.out.println("6. Service ");
			System.out.println("7. Bill ");
			System.out.println("8. Exit");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				StaffUtility.menu();
				System.out.println("\n");
				break;

			case 2:
				SparePartsUtility.menu();
				System.out.println("\n");
				break;

			case 3:
				CustomerUtility.menu();
				System.out.println("\n");
				break;

			case 4:
				VehicleUtility.menu();
				System.out.println("\n");
				break;

			case 5:
				ReservationUtility.menu();
				System.out.println("\n");
				break;

			case 6:
				ServiceUtility.menu();
				System.out.println("\n");
				break;

			case 7:
				BillUtility.menu();
				System.out.println("\n");
				break;

			case 8:
				System.out.println("*******************THANK YOU!*****************");
				condition = false;
				break;
			
			default:
				System.out.println("Invalid Option!");

			}
		} while (condition);

	}
}
