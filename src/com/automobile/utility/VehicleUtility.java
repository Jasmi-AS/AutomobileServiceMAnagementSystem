package com.automobile.utility;

import java.util.List;
import java.util.Scanner;

import com.automobile.entity.Customer;
import com.automobile.entity.Staff;
import com.automobile.entity.Vehicle;
import com.automobile.services.CustomerServiceImpl;
import com.automobile.services.StaffServiceImpl;
import com.automobile.services.VehicleServiceImpl;

public class VehicleUtility {

	public static void main(String[] args) {

		menu();

	}

	public static void insertIntoVehicle() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("_____________________________________________________________");
		System.out.println("-----------------INSERTING INTO VEHICLE----------------------\n");
		CustomerUtility.getAllCustomer();
		System.out.println("");
		System.out.println("Enter the Customer Id:");
		int customerId = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter the Vehicle Name:");
		String vehicleName = scanner.nextLine();
		System.out.println("Enter the Vehicle Type:");
		String vehicleType = scanner.nextLine();
		System.out.println("Enter the Vehicle Number:");
		String vehicleNumber = scanner.nextLine();

		Customer customer = new Customer();
		customer.setCusId(customerId);

		Vehicle vehicle = new Vehicle();
		vehicle.setCustomer(customer);
		vehicle.setVehicleName(vehicleName);
		vehicle.setVehicleType(vehicleType);
		vehicle.setVehicleNumber(vehicleNumber);
		VehicleServiceImpl vehicleServiceImpl = new VehicleServiceImpl();
		vehicleServiceImpl.save(vehicle);
	}

	public static void getAllVehicle() {

		VehicleServiceImpl vehicleServiceImpl = new VehicleServiceImpl();
		List<Vehicle> vehicleList = vehicleServiceImpl.findAll();
		display();
		for (Vehicle vehicle : vehicleList) {
			System.out.println(vehicle.getVehicleId() + "\t\t" + vehicle.getCustomer().getCusId() + "\t\t"
					+ vehicle.getVehicleName() + "\t\t" + vehicle.getVehicleType() + "\t\t"
					+ vehicle.getVehicleNumber());
		}

	}

	private static void display() {
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("vehicle_id\tcustomer_id\tvehicle_name\tvehicle_type\tvehicle_number");
		System.out.println("------------------------------------------------------------------------------");

	}

	public static void getUpdate() {
		getAllVehicle();
		Scanner scanner = new Scanner(System.in);
		System.out.println("-----------------------UPDATING INTO VEHICLE-------------------------\n");
		System.out.println("Enter the Vehicle ID:");
		int vehicleID = scanner.nextInt();
		System.out.println("Enter the Customer Id:");
		int customerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the updated Vehicle Name:");
		String vehicleName = scanner.nextLine();
		System.out.println("Enter the updated Vehicle Type:");
		String vehicleType = scanner.nextLine();
		System.out.println("Enter the updated Vehicle Number:");
		String vehicleNumber = scanner.nextLine();

		Customer customer = new Customer();
		customer.setCusId(customerId);

		Vehicle vehicle = new Vehicle(vehicleID, customer, vehicleName, vehicleType, vehicleNumber);
		VehicleServiceImpl vehicleServiceImpl = new VehicleServiceImpl();
		vehicleServiceImpl.update(vehicle);
	}

	private static void getDelete() {
		getAllVehicle();
		Scanner scanner = new Scanner(System.in);
		System.out.println("---------------------DELETING INTO VEHICLE--------------------------\n");
		System.out.println("Enter the Vehicle ID:");
		int VehicleId = scanner.nextInt();
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleId(VehicleId);

		VehicleServiceImpl vehicleServiceImpl = new VehicleServiceImpl();
		vehicleServiceImpl.delete(vehicle);
	}

	private static void getFindById() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Bill Id to find :");
		int vehicleId = scanner.nextInt();

		VehicleServiceImpl vehicleServiceImpl = new VehicleServiceImpl();
		Vehicle vehicle = vehicleServiceImpl.findById(vehicleId);
		if (vehicle != null) {
			display();
			System.out.println(vehicle.getVehicleId() + "\t\t" + vehicle.getCustomer().getCusId() + "\t\t"
					+ vehicle.getVehicleName() + "\t\t" + vehicle.getVehicleType()+"\t\t"+vehicle.getVehicleNumber());
		} else {
			System.out.println("No details found with the given ID,Try Again...");
		}
	}

	public static void menu() {
		Scanner Scanner = new Scanner(System.in);
		boolean condition = true;
		do {
			System.out.println("-------------------VEHICLES DETAILS---------------------\n");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show  Vehicle List");
			System.out.println("2. Add new Vehicle");
			System.out.println("3. Update Vehicle List");
			System.out.println("4. Delete Vehicle");
//			System.out.println("5. Find by Id");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			int choice = Scanner.nextInt();

			switch (choice) {

			case 1:
				getAllVehicle();
				System.out.println("\n");
				break;
			case 2:

				insertIntoVehicle();
//				getAllVehicle();
				System.out.println("\n");

				break;
			case 3:
				getUpdate();
//				getAllVehicle();
				System.out.println("\n");

				break;
			case 4:
				getDelete();
//				getAllVehicle();
				System.out.println("\n");

				break;

//			case 5:
//				getFindById();
//				System.out.println("\n");
//
//				break;
//
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
