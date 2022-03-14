package ss3_array_method.excercise;

import java.util.Scanner;

public class removeElements {
    public static void main(String[] args) {
        String[] name = new String[5];
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (i < name.length) {
            System.out.print("Enter element " + (i + 1) + ": ");
            name[i] = scanner.nextLine();
            i++;
        }
        System.out.printf("Elements in array: ", "\t");
        for (int j = 0; j < name.length; j++) {
            System.out.print(name[j] + "\t");
        }

        System.out.println("Enter a student you want to remove: ");
        String student = scanner.nextLine();
        for (int k = 0; k < name.length - 1; k++) {
            if (name[k].equals(student)) {
                System.out.println("Position of the students in the list " + student + " is: " + k);
                System.out.println("Student's array after remove");
                break;
            } else if (name[k].equals(student)) {
                System.out.println("Not found ");
                break;
            }
        }
        for (int j = 0; j < name.length; j++) {
            name[j] = name[j + 1];
            System.out.print(name[j] + "\t");
        }
    }
}
