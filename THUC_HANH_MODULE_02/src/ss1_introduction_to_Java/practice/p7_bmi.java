package ss1_introduction_to_Java.practice;

import java.util.Scanner;

public class p7_bmi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight, height, bmi;
        System.out.println("Enter weight");
        weight = scanner.nextDouble();
        System.out.println("Enter height");
        height = scanner.nextDouble();
        bmi = weight/Math.pow(height, 2);

        if (bmi < 18.5)
            System.out.println("Underweight");
        else if (bmi < 25.0)
            System.out.println("Normal");
        else if (bmi < 30.0)
            System.out.println("Overweight");
        else
            System.out.println("Obesity");
        }
    }

