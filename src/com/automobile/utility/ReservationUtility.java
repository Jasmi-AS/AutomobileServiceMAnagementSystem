package com.automobile.utility;

import java.util.List;
import java.util.Scanner;

import com.automobile.entity.Customer;
import com.automobile.entity.Reservation;
import com.automobile.entity.Service;
import com.automobile.entity.SpareParts;
import com.automobile.entity.Staff;
import com.automobile.entity.Vehicle;
import com.automobile.services.CustomerServiceImpl;
import com.automobile.services.ReservationServiceImpl;
import com.automobile.services.ServiceServiceImpl;

public class ReservationUtility {

	public static void main(String[] args) {

		menu();
	}

	private static void insertIntoReservation() {
		VehicleUtility.getAllVehicle();
		System.out.println("______________________________________________________\n");
		StaffUtility.getAllStaff();
		System.out.println("______________________________________________________\n");
		Scanner scanner = new Scanner(System.in);
		System.out.println("------------------INSERTING INTO RESERVATION-------------------\n");
		System.out.println("Enter the Vehicle ID:");
		int vehicleID = scanner.nextInt();
		System.out.println("Enter the Staff ID:");
		int staffID = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Reservation Date:");
		String reservDate = scanner.nextLine();

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleId(vehicleID);

		Staff staff = new Staff();
		staff.setStaffId(staffID);

		Reservation reservation = new Reservation();
		reservation.setVehicle(vehicle);
		reservation.setStaff(staff);
		reservation.setReservationDate(reservDate);

		ReservationServiceImpl reservationServiceImpl = new ReservationServiceImpl();
		reservationServiceImpl.save(reservation);

	}

	private static void getAllReservation() {

		ReservationServiceImpl reservationServiceImpl = new ReservationServiceImpl();
		List<Reservation> ReservationList = reservationServiceImpl.findAll();
		display();
		for (Reservation reservation : ReservationList) {

			System.out.println(reservation.getReservationId() + "\t\t" + reservation.getVehicle().getVehicleId()
					+ " \t\t " + reservation.getStaff().getStaffId() + "\t\t" + reservation.getReservationDate());
		}
	}

	private static void display() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("reserv_id\tvehicle_id\tstaff_id\treserv_date");
		System.out.println("--------------------------------------------------------------------");
	}

	public static void getUpdate() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("--------------------UPDATING INTO RESERVATION---------------------\n");
		System.out.println("Enter the Reservation ID:");
		int reservId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Vehicle ID:");
		int vehicleId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Staff ID:");
		int staffId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the updated Reservation Date:");
		String reservDate = scanner.nextLine();

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleId(vehicleId);

		Staff staff = new Staff();
		staff.setStaffId(staffId);

		Reservation reservation = new Reservation(reservId, vehicle, staff, reservDate);
		ReservationServiceImpl reservationServiceImpl = new ReservationServiceImpl();
		reservationServiceImpl.update(reservation);
	}

	private static void getDelete() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("--------------------DELETING INTO RESERVATION-----------------------\n");
		System.out.println("Enter the Reserv ID:");
		int reservId = scanner.nextInt();
		Reservation reservation = new Reservation();
		reservation.setReservationId(reservId);

		ReservationServiceImpl reservationServiceImpl = new ReservationServiceImpl();
		reservationServiceImpl.delete(reservation);
	}

	private static void getFindById() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Bill Id to find :");
		int reservationId = scanner.nextInt();

		ReservationServiceImpl reservationServiceImpl = new ReservationServiceImpl();
		Reservation reservation = reservationServiceImpl.findById(reservationId);
		if (reservation != null) {
			display();
			System.out.println(reservation.getReservationId() + "\t\t" + reservation.getVehicle().getVehicleId() + "\t\t"
					+ reservation.getStaff().getStaffId() + "\t\t" + reservation.getReservationDate());
		} else {
			System.out.println("No details found with the given ID,Try Again...");
		}
	}

	public static void menu() {
		Scanner input = new Scanner(System.in);
		boolean condition = true;
		int choice;
		do {

			System.out.println("-------------------RESERVATION DETAILS--------------------\n");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show Reservation List");
			System.out.println("2. Add new Reservation");
			System.out.println("3. Update Reservation List");
			System.out.println("4. Delete Reservation");
//			System.out.println("5.Find by Id");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			choice = input.nextInt();

			switch (choice) {

			case 1:
				getAllReservation();
				System.out.println("\n");
				break;
			case 2:

				insertIntoReservation();
//				getAllReservation();
				System.out.println("\n");

				break;
			case 3:
				getUpdate();
//				getAllReservation();
				System.out.println("\n");

				break;
			case 4:
				getDelete();
//				getAllReservation();
				System.out.println("\n");
				
				break;
				
//			case 5:
//				getFindById();
//				System.out.println("\n");
//
//				break;

			case 5:

				System.out.println("---------------------THANK YOU-------------------------");
				condition = false;
				break;

			default:
				System.out.println("Invalid option!\n");
			}

		} while (condition);

	}

}
