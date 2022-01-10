package ss2_loop.excercise;

import java.util.Scanner;

public class e3_PrimeUnder100 {
    public static void main(String[] args) {
        int count = 0;
        int n = 2;
        int i = 2;

        while (count < 100) {
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

