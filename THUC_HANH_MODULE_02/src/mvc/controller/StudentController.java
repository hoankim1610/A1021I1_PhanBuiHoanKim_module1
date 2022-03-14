package mvc.controller;

import mvc.model.service.IStudentService;
import mvc.model.service.StudentService;

import java.util.Scanner;

public class StudentController {
    public static void main(String[] args) {
        IStudentService iStudentService = new StudentService();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to student's programme");
            System.out.println("Choose a method.");
            System.out.println("1. Display student");
            System.out.println("2. Add student");
            System.out.println("3. Delete student");
            System.out.println("4. Exit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    iStudentService.display();
                    break;
                case 2:
                    iStudentService.add();
                    break;
                case 3:
                    iStudentService.delete();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
