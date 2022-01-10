package ss1_introduction_to_Java.excercise;

import java.util.Scanner;

public class e3_currency {
    public static void main(String[] args) {
        double usd;
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much you would like to change? ");
        usd = scanner.nextDouble();
        double vnd = usd * 23000;
        System.out.println("vnd : " + vnd);
    }
}
