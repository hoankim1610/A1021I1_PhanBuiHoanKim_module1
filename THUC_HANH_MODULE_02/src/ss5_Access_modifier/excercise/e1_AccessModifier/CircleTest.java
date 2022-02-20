package ss5_Access_modifier.excercise.e1_AccessModifier;

import java.util.Scanner;

public class CircleTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input radius: ");
        double r = Integer.parseInt(input.nextLine());

        Circle circle = new Circle(r, "green");
        System.out.println("radius = " + circle.getRadius());
        System.out.println("Area = " + circle.getArea());
        System.out.println(circle.getColor());
    }

}
