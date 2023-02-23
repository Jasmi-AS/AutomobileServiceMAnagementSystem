package com.automobile.utility;

import java.util.List;
import java.util.Scanner;

import com.automobile.entity.Customer;
import com.automobile.entity.SpareParts;
import com.automobile.entity.Staff;
import com.automobile.services.CustomerServiceImpl;
import com.automobile.services.SparePartServiceImpl;
import com.automobile.services.StaffServiceImpl;

public class StaffUtility {

	public static void main(String[] args) {
		menu();
	}

	private static void insertIntoStaff() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("-----------------INSERTING INTO STAFF----------------------------\n");
		System.out.println("Enter the Staff Name:");
		String staffName = scanner.nextLine();
		System.out.println("Enter the Staff Phone Number:");
		String staffPhoneNumber = scanner.nextLine();
		Staff staff = new Staff();
		staff.setStaffName(staffName);
		staff.setStaffPhoneNumber(staffPhoneNumber);
		StaffServiceImpl staffServiceImpl = new StaffServiceImpl();
		staffServiceImpl.save(staff);
	}

	public static void getAllStaff() {

		StaffServiceImpl staffServiceImpl = new StaffServiceImpl();
		List<Staff> staffList = staffServiceImpl.findAll();
		display();
		for (Staff staff : staffList) {
			System.out
					.println(staff.getStaffId() + "\t\t" + staff.getStaffName() + "\t\t" + staff.getStaffPhoneNumber());
		}

	}

	private static void display() {
		System.out.println("------------------------------------------------------------");
		System.out.println("staff_id\tstaff_name\tstaff_phonenumber");
		System.out.println("------------------------------------------------------------");

	}

	public static void getUpdate() {
		getAllStaff();
		Scanner scanner = new Scanner(System.in);
		System.out.println("---------------------UPDATING INTO STAFF----------------------------\n");
		System.out.println("Enter the staffID:");
		int staffID = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the updated staff Name:");
		String staffName = scanner.nextLine();
		System.out.println("Enter the updated staff phonenumber:");
		String staffPhoneNumber = scanner.nextLine();

		Staff staff = new Staff(staffID, staffName, staffPhoneNumber);
		StaffServiceImpl staffServiceImpl = new StaffServiceImpl();
		staffServiceImpl.update(staff);
	}

	private static void getDelete() {
		getAllStaff();
		Scanner scanner = new Scanner(System.in);
		System.out.println("------------------------DELETING INTO VEHICLE-----------------------\n");
		System.out.println("Enter the staffID:");
		int staffId = scanner.nextInt();
		Staff staff = new Staff();
		staff.setStaffId(staffId);

		StaffServiceImpl staffServiceImpl = new StaffServiceImpl();
		staffServiceImpl.delete(staff);
	}

	private static void getFindById() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Bill Id to find :");
		int staffId = scanner.nextInt();

		StaffServiceImpl staffServiceImpl = new StaffServiceImpl();
		Staff staff = staffServiceImpl.findById(staffId);
		if (staff != null) {
			display();
			System.out
					.println(staff.getStaffId() + "\t\t" + staff.getStaffName() + "\t\t" + staff.getStaffPhoneNumber());
		} else {
			System.out.println("No details found with the given ID,Try Again...");
		}
	}

	public static void menu() {
		Scanner Scanner = new Scanner(System.in);
		boolean condition = true;
		do {
			System.out.println("-------------------STAFF DETAILS---------------------\n");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show staff List");
			System.out.println("2. Add new Staff");
			System.out.println("3. Update Staff List");
			System.out.println("4. Delete Staff");
//			System.out.println("5. Find by id");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			int choice = Scanner.nextInt();

			switch (choice) {

			case 1:
				getAllStaff();
				System.out.println("\n");
				break;
			case 2:

				insertIntoStaff();
//				getAllStaff();
				System.out.println("\n");

				break;
			case 3:
				getUpdate();
//				getAllStaff();
				System.out.println("\n");

				break;
			case 4:
				getDelete();
//				getAllStaff();
				System.out.println("\n");
				
				break;

//			case 5:
//				getFindById();
//				System.out.println("\n");
//				
//				break;
			
			case 5:
				System.out.println("-------------------THANK YOU--------------------");
				condition = false;
				break;

			default:
				System.out.println("Invalid option !\n");
			}

		} while (condition);
	}

}
