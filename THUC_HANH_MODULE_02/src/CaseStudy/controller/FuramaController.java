package CaseStudy.controller;

import java.util.Scanner;

public class FuramaController {

    public static void main(String[] args) {
        displayMainMenu();
    }

    private static void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to Furama Resort.");
            System.out.println("Choose value from 1 to 6:");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    EmployeeView.employeeManagement();
                    break;
                case 2:
                    CustomerView.customerManagement();
                    break;
//                case 3:
//                    iStudentService.delete();
//                    break;
//                case 4:
//                    iStudentService.search();
//                    break;
//                case 5:
//                    System.exit(0);
            }
        }
    }

}
