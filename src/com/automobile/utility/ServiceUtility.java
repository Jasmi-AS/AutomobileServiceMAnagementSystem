package com.automobile.utility;

import java.util.List;
import java.util.Scanner;

import com.automobile.entity.Reservation;
import com.automobile.entity.Service;
import com.automobile.entity.SpareParts;
import com.automobile.entity.Staff;
import com.automobile.entity.Vehicle;
import com.automobile.services.ReservationServiceImpl;
import com.automobile.services.ServiceServiceImpl;
import com.automobile.services.SparePartServiceImpl;
import com.automobile.services.StaffServiceImpl;

public class ServiceUtility {

	public static void main(String[] args) {

		menu();
//		getAllService() ;
//		insertIntoService();
//		getUpdate();
	}

	private static void insertIntoService() 
	{


			VehicleUtility.getAllVehicle();
			System.out.println("___________________________________________________\n");
			StaffUtility.getAllStaff();
			System.out.println("____________________________________________________\n");
            
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the Vehicle ID:");
			int vehicleId = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the Staff ID:");
			int staffId = scanner.nextInt();
			scanner.nextLine();

			System.out.println("Enter the Service Type:");
			String serviceType = scanner.nextLine();
			System.out.println("Enter the service Amount:");
			Double serviceAmount = scanner.nextDouble();

			
			Vehicle vehicle = new Vehicle();
			vehicle.setVehicleId(vehicleId);
			Staff staff=new Staff();
			staff.setStaffId(staffId);
						
			Service service = new Service();
			service.setVehicle(vehicle);
			service.setStaff(staff);
			service.setServiceType(serviceType);
			service.setServiceAmount(serviceAmount);
			
			ServiceServiceImpl serviceServiceImpl = new ServiceServiceImpl();
			serviceServiceImpl.save(service);

		}

		public static void getAllServices() {

			ServiceServiceImpl serviceServiceImpl = new ServiceServiceImpl();
			List<Service> serviceList = serviceServiceImpl.findAll();
			display();
			for (Service service : serviceList) {

				System.out.println(service.getServiceId() + "\t\t" + service.getVehicle().getVehicleId() + "\t\t"
						+ service.getStaff().getStaffId() + "\t\t"+service.getServiceType()+
				"\t\t"+service.getServiceAmount());
			}
		}

		private static void display() {
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("service_id\tvehicle_id\tstaff_id\tservice_type\tservice_amount");
			System.out.println("-------------------------------------------------------------------------------");
		}

		public static void getUpdate() {

			Scanner scanner = new Scanner(System.in);
			System.out.println("-------------------UPDATING INTO SERVICE----------------------\n");
			System.out.println("Enter the Service ID:");
			int serviceId = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the vehicle ID:");
			int vehicleId = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the staff ID:");
			int staffId = scanner.nextInt();
			scanner.nextLine();
			scanner.nextLine();
			System.out.println("Enter the updated Service Type:");
			String serviceType = scanner.nextLine();
			System.out.println("Enter the updated Service Amount:");
			Double serviceAmount = scanner.nextDouble();

			
			Vehicle vehicle = new Vehicle();
			vehicle.setVehicleId(vehicleId);
			
			Staff staff=new Staff ();
			staff.setStaffId(staffId);
			
					
			Service service = new Service(serviceId,vehicle,staff,serviceType,serviceAmount);
			ServiceServiceImpl serviceServiceImpl = new ServiceServiceImpl();
			serviceServiceImpl.update(service);
		}

		private static void getDelete() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("---------------------DELETING INTO SERVICE---------------------\n");
			System.out.println("Enter the Service ID:");
			int serviceId = scanner.nextInt();
			Service service = new Service();
			service.setServiceId(serviceId);

			ServiceServiceImpl serviceServiceImpl = new ServiceServiceImpl();
			serviceServiceImpl.delete(service);
		}
		private static void getFindById() {

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the Bill Id to find :");
			int serviceId = scanner.nextInt();

			ServiceServiceImpl serviceServiceImpl = new ServiceServiceImpl();
			Service service = serviceServiceImpl.findById(serviceId);
			if (service != null) {
				display();
				System.out.println(service.getServiceId() + "\t\t" + service.getVehicle().getVehicleId() + "\t\t"
						+ service.getStaff().getStaffId() + "\t\t" + service.getServiceType()+ "\t\t" +service.getServiceAmount());
			} else {
				System.out.println("No details found with the given ID,Try Again...");
			}
		}



		public static void menu() {
			Scanner input = new Scanner(System.in);
			boolean condition = true;
			int choice;
			do {
				System.out.println("******SERVICE******\n");
				System.out.println("Choose an option:\n");
				System.out.println("1. Show Services List");
				System.out.println("2. Add new Service");
				System.out.println("3. Update Service List");
				System.out.println("4. Delete Service");
//				System.out.println("5. Find by id");
				System.out.println("5. Exit");
				System.out.print("Enter your choice: ");
				choice = input.nextInt();

				switch (choice) {

				case 1:
					getAllServices();
					System.out.println("\n");
					break;
				case 2:

					insertIntoService();
					getAllServices();
					System.out.println("\n");

					break;
				case 3:
					getUpdate();
					getAllServices();
					System.out.println("\n");

					break;
				case 4:
					getDelete();
					getAllServices();
					System.out.println("\n");
					
                    break;
//				case 5:
//					getFindById();
//					System.out.println("\n");
//					
//					break;
				case 5:
					System.out.println("-------------------THANK YOU--------------------");
					condition = false;
					break;

				default:
					System.out.println("Invalid option!\n");
				}

			} while (condition);
		}
	}

