package ss2_loop.excercise;

import java.util.Scanner;

public class e1_drawing {

    public static void main(String[] args) {
        int length = -1;
        int width = -1;
        int choices = -1;
        Scanner input = new Scanner(System.in);
        System.out.println("1. Print the rectangle\n" +
                "\n" +
                "2. Print the square triangle\n" +
                "\n" +
                "3. Print isosceles triangle\n" +
                "\n" +
                "0. Exit");
        System.out.println("Enter your choice");


        while (choices != 0) {
            choices = input.nextInt();
            switch (choices) {
                case 1 :
                    System.out.println("Enter length");
                    length = input.nextInt();
                    System.out.println("Enter width");
                    width = input.nextInt();
                    for (int i = 1; i <= length; i ++) {
                        for (int j = 1; j <= width; j ++ ) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;

                case 2 :
                    System.out.println("Enter length");
                    length = input.nextInt();
                    System.out.println("Enter width");
                    width = input.nextInt();
                    for (int i = 1; i <= length; i ++) {
                        for (int j = 1; j <= width; j++) {
                            if (i > j)
                                System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;

                case 3 :
                    System.out.println("Enter length");
                    length = input.nextInt();
                    System.out.println("Enter width");
                    width = input.nextInt();
                    for (int i = 1; i<= width; i++) {
                        for (int j = i; j < length*2; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 1; j < i * 2 ; j++) {
                            System.out.print("*");
                        }
                        System.out.println("\n");
                    }
                    break;

                case 0 :
                    System.exit(0);

                default:
                    System.out.println("No choice");
            }
        }

    }
}
