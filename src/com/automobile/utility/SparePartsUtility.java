package com.automobile.utility;

import java.util.List;
import java.util.Scanner;

import com.automobile.entity.Service;
import com.automobile.entity.SpareParts;
import com.automobile.entity.Vehicle;
import com.automobile.services.ServiceServiceImpl;
import com.automobile.services.SparePartServiceImpl;

public class SparePartsUtility {

	public static void main(String[] args) {

		menu();
//		getUpdate();

	}

	private static void insertIntoSpareParts() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("-----------------INSERTING INTO SPAREPARTS-----------------------\n");
		System.out.println("Enter the Spareparts Name:");
		String sparepartsName = scanner.nextLine();
		System.out.println("Enter the Spareparts Amount:");
		Double sparepartsAmount = scanner.nextDouble();

		
		SpareParts spareParts = new SpareParts();
		
		spareParts.setSparepartsName(sparepartsName);
		spareParts.setSparepartsAmount(sparepartsAmount);

		SparePartServiceImpl sparePartServiceImpl = new SparePartServiceImpl();
		sparePartServiceImpl.save(spareParts);

	}

	public static void getAllSpareParts() {

		SparePartServiceImpl sparePartServiceImpl = new SparePartServiceImpl();
		List<SpareParts> sparePartsList = sparePartServiceImpl.findAll();
		display();
		for (SpareParts spareParts : sparePartsList) {

			System.out.println(spareParts.getSparepartsId() + "\t\t" + spareParts.getSparepartsName() + "\t\t"
					+ spareParts.getSparepartsAmount());
		}
	}

	private static void display() {
		System.out.println(
				"----------------------------------------------------------------");
		System.out.println("spareparts_id\tspareparts_name\tspareparts_amount");
		System.out.println(
				"-----------------------------------------------------------------");

	}

	public static void getUpdate() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("------------------UPDATING INTO SPAREPARTS----------------------\n");
		System.out.println("Enter the SpareParts ID:");
		int sparePartsId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the updated Spareparts Name:");
		String sparepartsName = scanner.nextLine();
		System.out.println("Enter the updated Spareparts Amount:");
		Double sparepartsAmount = scanner.nextDouble();

		SpareParts spareParts = new SpareParts(sparePartsId,  sparepartsName, sparepartsAmount);
		SparePartServiceImpl sparePartServiceImpl = new SparePartServiceImpl();
		sparePartServiceImpl.update(spareParts);
	}

	private static void getDelete() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("-------------------DELETING INTO SPAREPARTS----------------------\n");
		System.out.println("Enter the SparePartsID:");
		int sparePartsId = scanner.nextInt();
		SpareParts spareParts = new SpareParts();
		spareParts.setSparepartsId(sparePartsId);

		SparePartServiceImpl sparePartServiceImpl = new SparePartServiceImpl();
		sparePartServiceImpl.delete(spareParts);
	}

	private static void getFindById() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Bill Id to find :");
		int sparePartsId = scanner.nextInt();

		SparePartServiceImpl sparePartServiceImpl = new SparePartServiceImpl();
		SpareParts spareParts = sparePartServiceImpl.findById(sparePartsId);
		if (spareParts != null) {
			display();
			System.out.println(spareParts.getSparepartsId() + "\t\t" + spareParts.getSparepartsName() + "\t\t"
					+ spareParts.getSparepartsAmount());
		} else {
			System.out.println("No details found with the given ID,Try Again...");
		}
	}

	public static void menu() {
		Scanner input = new Scanner(System.in);
		boolean condition = true;
		int choice;
		do {
			System.out.println("-------------------SPAREPARTS DETAILS-----------------------\n");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show Spareparts List");
			System.out.println("2. Add new Spareparts");
			System.out.println("3. Update Spareparts");
			System.out.println("4. Delete Spareparts");
//			System.out.println("5. Find by Id");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			choice = input.nextInt();

			switch (choice) {

			case 1:
				getAllSpareParts();
				System.out.println("\n");
				break;
			case 2:

				insertIntoSpareParts();
//				getAllSpareParts();
				System.out.println("\n");

				break;
			case 3:
				getUpdate();
//				getAllSpareParts();
				System.out.println("\n");

				break;
			case 4:
				getDelete();
//				getAllSpareParts();
				System.out.println("\n");
				break;

//			case 5:
//				getFindById();
//				System.out.println("\n");
//				break;
//				
				
			case 5:
				System.out.println("--------------------THANK YOU---------------------");
				condition = false;
				break;

			default:
				System.out.println("Invalid option!\n");
			}

		} while (condition);
	}
}
