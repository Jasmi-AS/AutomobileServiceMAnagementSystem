package com.automobile.utility;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Scanner;

import com.automobile.entity.Bill;
import com.automobile.entity.Customer;
import com.automobile.entity.Service;
import com.automobile.entity.Vehicle;
import com.automobile.services.BillServiceImpl;

public class BillUtility {

	public static void main(String[] args) throws MalformedURLException, IOException {

		menu();
//		getAllBill();
//		getFindById();
		BillPdfGenerator BillPdfGenerator=new BillPdfGenerator();
	}
	

	private static void insertIntoBill() {
		Scanner scanner = new Scanner(System.in);

		VehicleUtility.getAllVehicle();
		System.out.println("___________________________________________________________________________");
		ServiceUtility.getAllServices();
		System.out.println("___________________________________________________________________________");
		CustomerUtility.getAllCustomer();
		System.out.println("___________________________________________________________________________");
		System.out.println("--------------------INSERTING INTO BILL----------------------\n");
		System.out.println("Enter the Vehicle ID:");
		int vehicleID = scanner.nextInt();
		System.out.println("Enter the Service ID:");
		int serviceID = scanner.nextInt();
		System.out.println("Enter the customer ID:");
		int customerId=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Payment Mode:");
		String paymentMode = scanner.nextLine();
		System.out.println("Enter the Bill Amount:");
		double billAmount = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Enter the Bill Date");
		String billDate = scanner.nextLine();

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleId(vehicleID);

		Service service = new Service();
		service.setServiceId(serviceID);
		
		Customer customer=new Customer();
		customer.setCusId(customerId);

		Bill bill = new Bill();
		bill.setVehicle(vehicle);
		bill.setService(service);
		bill.setCustomer(customer);
		bill.setPaymentMode(paymentMode);
		bill.setBillAmount(billAmount);
		bill.setBillDate(billDate);

		BillServiceImpl billServiceImpl = new BillServiceImpl();
		billServiceImpl.save(bill);

	}

	private static void getAllBill() {

		BillServiceImpl billServiceImpl = new BillServiceImpl();
		List<Bill> billList = billServiceImpl.findAll();
		display();
		for (Bill bill : billList) {

			System.out.println(bill.getBillId() + "\t\t" + bill.getVehicle().getVehicleId() + " \t\t "
					+ bill.getService().getServiceId() + "\t\t" +bill.getCustomer().getCusId()+"\t\t"+ bill.getPaymentMode() + "  \t\t  " + bill.getBillAmount()+" \t\t "
					+ bill.getBillDate());
		}
	}

	private static void display() {
		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.println("bill_id\t\tvehicle_id\tservice_id\tcustomer_id\tpayment_mode\t\tbill_amount\t\tbill_date");
		System.out.println("----------------------------------------------------------------------------------------------------");
	}

	public static void getUpdate() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("---------------------UPDATING INTO BILL-------------------------\n");
		System.out.println("Enter the Bill ID:");
		int billId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Vehicle ID:");
		int vehicleId = scanner.nextInt();
		System.out.println("Enter the Service ID:");
		int serviceId = scanner.nextInt();
		System.out.println("Enter the customer ID:");
		int customerId=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Payment Mode:");
		String paymentMode = scanner.nextLine();
		System.out.println("Enter the Bill Amount:");
		double billAmount = scanner.nextDouble();
		System.out.println("Enter the Bill Date:");
		String billDate = scanner.nextLine();

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleId(vehicleId);

		Service service = new Service();
		service.setServiceId(serviceId);
		
		Customer customer=new Customer();
		customer.setCusId(customerId);

		Bill bill = new Bill(billId, vehicle, service,customer, paymentMode, billAmount, billDate);
		BillServiceImpl billServiceImpl = new BillServiceImpl();
		billServiceImpl.update(bill);
	}

	private static void getDelete() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("----------------------DELETING INTO  BILL---------------------------\n");
		System.out.println("Enter the Bill ID :");
		int billId = scanner.nextInt();
		Bill bill = new Bill();
		bill.setBillId(billId);

		BillServiceImpl billServiceImpl = new BillServiceImpl();
		billServiceImpl.delete(bill);
	}

	public static void getFindById() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Bill Id to find :");
		int billId = scanner.nextInt();

		BillServiceImpl billServiceImpl = new BillServiceImpl();
		Bill bill = billServiceImpl.findById(billId);
		if (bill != null) {
			display();
			System.out.println(
					bill.getBillId() + " \t\t " + bill.getVehicle().getVehicleId() + " \t\t " + bill.getService().getServiceId()+"\t\t"+bill.getCustomer().getCusId()+
							 "\t\t " + bill.getPaymentMode() + " \t\t " + bill.getBillAmount() + " \t\t " + bill.getBillDate());
		} else {
			System.out.println("No details found with the given ID,Try Again...");
		}
	}

	public static void menu() throws MalformedURLException, IOException {
		Scanner scanner = new Scanner(System.in);
		boolean condition = true;
		int choice;
		do {
			System.out.println("-----------------------BILL DETAILS---------------------------\n");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show Bill List");
			System.out.println("2. Add new Bill");
			System.out.println("3. update Bill List");
			System.out.println("4. delete Bill");
//			System.out.println("5. Find by ID");
			System.out.println("5. Generate Bill");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {

			case 1:
				getAllBill();
				System.out.println("\n");
				break;
			case 2:

				insertIntoBill();
//				getAllBill();
				System.out.println("\n");

				break;
			case 3:
				getUpdate();
//				getAllBill();
				System.out.println("\n");

				break;
			case 4:
				getDelete();
//				getAllBill();
				System.out.println("\n");
				
				break;
			case 5:
				BillPdfGenerator.generateBillById();
//				System.out.println("\n");
				
				break;
			case 6:
				System.out.println("--------------------THANK YOU----------------------");
				condition = false;
				break;

			default:
				System.out.println("Invalid option!\n");
			}

		} while (condition);

	}
	
}
