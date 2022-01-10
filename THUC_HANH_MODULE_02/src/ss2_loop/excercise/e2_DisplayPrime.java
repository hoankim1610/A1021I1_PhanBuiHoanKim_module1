package ss2_loop.excercise;

import java.util.Scanner;

public class e2_DisplayPrime {
    public static void main(String[] args) {
        int numbers;
        int count = 0;
        int n = 2;
        int i = 2;
        Scanner number = new Scanner(System.in);
        System.out.println("How much numbers you would like to display?");
        numbers = number.nextInt();

        while (count < numbers) {
            for (int j = 2; j < i; j++){
                if (i % j == 0){
                    n ++;
                }
            }
            if (n == 0){
                System.out.println(i + "\n");
                count ++;
            }
            i++;
            n = 0;
        }
    }
}
