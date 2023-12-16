package com.example.tax;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class TaxApplication {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Scanner s=new Scanner(System.in);
		System.out.println("Welcome to the Tax Payment Application");
		while (true) {
			System.out.println("Please select which tax you want to pay: \n1. Income \n2. Property\n3. Exit");
			int userChoice = s.nextInt();
			String taxChoice = "";
			switch (userChoice) {
		
		
		case 1:{
			taxChoice="incomeTax";
			break;
		}
		case 2:{
			taxChoice="propertyTax";
			break;
		}
		case 3:{
			System.out.println("Exiting....");
			return;
		}
		default:{
			 System.out.println("Invalid choice");
		}
			
		}
			Tax tax=(Tax) context.getBean(taxChoice);
			if(tax.isTaxPayed()) {
				System.out.println("You have already paid "+tax.getTaxType()+" tax");			
			}
			else {
				System.out.println("Enter Amount:");
				int amount=s.nextInt();
				tax.setTaxableAmount(amount);
				tax.calculateTaxAmount();
				System.out.println("Press 'y' to pay tax ");
				char yes=s.next().charAt(0);
				if(yes=='y') {
					tax.payTax();
				}
				
			}
			
			}
		
}
}
