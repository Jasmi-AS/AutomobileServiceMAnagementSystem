package com.automobile.utility;

import java.util.List;
import java.util.Scanner;

import com.automobile.entity.Bill;
import com.automobile.entity.Customer;
import com.automobile.entity.SpareParts;
import com.automobile.entity.Vehicle;
import com.automobile.services.BillServiceImpl;
import com.automobile.services.CustomerServiceImpl;
import com.automobile.services.SparePartServiceImpl;

/***
 * 
 * @author jasmi
 *
 */
public class CustomerUtility {
	public static void main(String[] args) {

		menu();
	}

	private static void insertIntoCustomer() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("-------------------INSERTING INTO CUSTOMER-----------------");
		System.out.println("Enter the Customer Name:");
		String cusName = scanner.nextLine();
		System.out.println("Enter the Customer Address:");
		String cusAddress = scanner.nextLine();
		System.out.println("Enter the Customer PhoneNumber:");
		String cusPhoneNumber = scanner.nextLine();

		Customer customer = new Customer();
		customer.setCusName(cusName);
		customer.setCusAddress(cusAddress);
		customer.setCusPhoneNumber(cusPhoneNumber);

		CustomerServiceImpl customerService = new CustomerServiceImpl();
		customerService.save(customer);
	}

	public static void getAllCustomer() {

		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		List<Customer> customerList = customerServiceImpl.findAll();
		display();
		for (Customer customer : customerList) {
			System.out.println(customer.getCusId() + "\t\t" + customer.getCusName() + "\t\t" + customer.getCusAddress()
					+ "\t\t" + customer.getCusPhoneNumber());
		}
	}

	private static void display() {
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("customer_id\tcustomer_name\tcustomer_address\tcustomer_phonenumber");
		System.out.println("-----------------------------------------------------------------------");

	}

	public static void getUpdate() {
		getAllCustomer();
		System.out.println("_________________________________________________________________");
		Scanner scanner = new Scanner(System.in);
		System.out.println("------------------UPDATING INTO CUSTOMER------------------------");
		System.out.println("Enter the Customer ID:");
		int customerID = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the updated Customer Name:");
		String customerName = scanner.nextLine();
		System.out.println("Enter the updated Customer Address:");
		String customerAddress = scanner.nextLine();
		System.out.println("Enter the updated Customer Phonenumber:");
		String phoneNumber = scanner.nextLine();

		Customer customer = new Customer(customerID, customerName, customerAddress, phoneNumber);
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		customerServiceImpl.update(customer);
	}

	private static void getDelete() {
		getAllCustomer();
		Scanner scanner = new Scanner(System.in);
		System.out.println("--------------------DELETING INTO CUSTOMER------------------------\n");
		System.out.println("Enter the Customer ID:");
		int customerId = scanner.nextInt();
		Customer customer = new Customer();
		customer.setCusId(customerId);

		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		customerServiceImpl.delete(customer);
	}

	public static void getFindById() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Bill Id to find :");
		int customerId = scanner.nextInt();

		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		Customer customer = customerServiceImpl.findById(customerId);
		if (customer != null) {
			display();
			System.out.println(customer.getCusId() + "\t\t" + customer.getCusName() + "\t\t" + customer.getCusAddress()
					+ "\t\t" + customer.getCusPhoneNumber());
		} else {
			System.out.println("No details found with the given ID,Try Again...");
		}
	}
	public static void menu() {
		Scanner Scanner = new Scanner(System.in);
		boolean condition = true;
		do {
			System.out.println("-------------------CUSTOMER DETAILS--------------------\n");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show Customer List");
			System.out.println("2. Add new Customer");
			System.out.println("3. update Customer");
			System.out.println("4. delete Customer");
//			System.out.println("5.Find by Id");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			int choice = Scanner.nextInt();

			switch (choice) {

			case 1:
				getAllCustomer();
				System.out.println("\n");
				break;
			case 2:

				insertIntoCustomer();
				getAllCustomer();
				System.out.println("\n");

				break;
			case 3:
				getUpdate();
				getAllCustomer();
				System.out.println("\n");

				break;
			case 4:
				getDelete();
				getAllCustomer();
				System.out.println("\n");
				
				break;

//			case 5:
//				getFindById();
//				System.out.println("\n");
//				
//				break;
			case 5:
				System.out.println("--------------------THANK YOU---------------------");
				condition = false;
				break;

			default:
				System.out.println("Invalid option !\n");
			}

		} while (condition);
	}

}
