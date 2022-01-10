package ss2_loop.practice;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class p4_drawingMenu {
    public static void main(String[] args) {
        int choices = -1;
        Scanner input = new Scanner(System.in);
        System.out.println("You have 4 choices : \n" +
                "0. Exit\n" +
                "1. Draw the triangle\n" +
                "2. Draw the square\n" +
                "3. Draw the rectangle\n");
        System.out.println("Enter your number : \n");
        while(choices != 0) {
            choices = input.nextInt();
            switch (choices) {
                case 1:
                    System.out.println("Draw the triangle");
                    System.out.println("******");
                    System.out.println("*****");
                    System.out.println("****");
                    System.out.println("***");
                    System.out.println("**");
                    System.out.println("*");
                    break;
                case 2:
                    System.out.println("Draw the square");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    break;
                case 3:
                    System.out.println("Draw the rectangle");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
