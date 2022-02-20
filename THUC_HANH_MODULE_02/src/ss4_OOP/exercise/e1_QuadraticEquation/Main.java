package ss4_OOP.exercise.e1_QuadraticEquation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a");
        double a = Integer.parseInt(input.nextLine());

        System.out.println("Enter b");
        double b = Integer.parseInt(input.nextLine());

        System.out.println("Enter c");
        double c = Integer.parseInt(input.nextLine());

        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        System.out.println("a =" + quadraticEquation.getA());
        System.out.println("b =" + quadraticEquation.getB());
        System.out.println("c =" + quadraticEquation.getC());
        System.out.println("delta =" + quadraticEquation.getDiscriminant());

        if (quadraticEquation.getDiscriminant() > 0) {
            System.out.println("The equation has two distinct roots: " + quadraticEquation.getRoot1() + quadraticEquation.getRoot2());
        } else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println("The equation has only root: " + quadraticEquation.getRoot2());
        } else
            System.out.println("The equation has no root.");
        }
}

