package com.automobile.utility;

import java.io.FileNotFoundException;

import com.automobile.entity.Bill;
import com.automobile.entity.Customer;
import com.automobile.entity.Service;
import com.automobile.entity.Vehicle;
import com.automobile.services.BillServiceImpl;
import com.automobile.services.CustomerServiceImpl;
import com.automobile.services.ServiceServiceImpl;
import com.automobile.services.VehicleServiceImpl;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

public class BillPdfGenerator {

	public static void main(String[] args) throws IOException {

		generateBillById();
	}

	public static void generateBillById() throws MalformedURLException, IOException {

		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(
					"C:\\Users\\safaj\\Desktop\\Canddella\\AutomobileServiceManagementSystemProject\\pdf\\demo2.pdf"));
			document.open();
			document.add(Image.getInstance(
					"C:\\Users\\safaj\\Desktop\\Canddella\\AutomobileServiceManagementSystemProject\\pdf\\image1.jpeg"));

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the bill id");
			int billId = scanner.nextInt();

			BillServiceImpl billServiceImpl = new BillServiceImpl();
			Bill bill = billServiceImpl.findById(billId);

			Bill bill1 = billServiceImpl.generateBillById(billId);

			ServiceServiceImpl serviceServiceImpl = new ServiceServiceImpl();
			Service service = serviceServiceImpl.findById(bill.getService().getServiceId());

			CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
			Customer customer = customerServiceImpl.findById(bill.getCustomer().getCusId());

			VehicleServiceImpl VehicleServiceImpl = new VehicleServiceImpl();
			Vehicle vehicle = VehicleServiceImpl.findById(bill.getVehicle().getVehicleId());
			
		                  
			Paragraph para = new Paragraph("-------------------------------------------BILL-------------------------------------------"); 
			 para.setAlignment(Element.ALIGN_CENTER);
			 
			Paragraph para1 = new Paragraph("        ");   
			Paragraph customerName = new Paragraph("Customer Name         : " + customer.getCusName());
			Paragraph customerNumber = new Paragraph("Customer Number     : " + customer.getCusPhoneNumber());
			Paragraph vehicleName = new Paragraph("Vehicle name            : " + vehicle.getVehicleName());
			Paragraph vehicleNumber = new Paragraph("Vehicle number         : " + vehicle.getVehicleNumber());
			Paragraph serviceName = new Paragraph("Service Type             : " + service.getServiceType());
			Paragraph paymentMode = new Paragraph("payment Mode          : " + bill.getPaymentMode());
			Paragraph amount = new Paragraph("Total Amount            : " + bill.getBillAmount());

			document.add(para);
			document.add(para1);
			document.add(customerName);
			document.add(customerNumber);
			document.add(vehicleName);
			document.add(vehicleNumber);
			document.add(serviceName);
			document.add(paymentMode);
			document.add(amount);

			document.close();
			writer.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
