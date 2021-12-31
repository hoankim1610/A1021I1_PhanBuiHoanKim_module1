package ss1_introduction_to_Java.excercise;

import java.util.Scanner;

public class p8_displayName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        System.out.println("What is your name?");
        name = scanner.next();
        System.out.println("Hello : " + name);
    }
}
