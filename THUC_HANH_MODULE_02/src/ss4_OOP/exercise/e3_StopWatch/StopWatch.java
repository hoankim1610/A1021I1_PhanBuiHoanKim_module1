package ss4_OOP.exercise.e3_StopWatch;

import java.util.Arrays;
import java.util.Date;

import static java.lang.StrictMath.floor;
import static java.lang.StrictMath.random;

public class StopWatch {

        private Date startTime;
        private Date endTime;
        public void start() {
            startTime = new Date();
        }
        public void stop() {
            endTime = new Date();
        }
        public long getElapsedTime() {
            return endTime.getTime() - startTime.getTime();
        }

        public void main(String[] args) {
            StopWatch sw = new StopWatch();
            double[] arr = new double[100000];
            int length= arr.length;
            for (int i = 0; i < length; i++) {
                arr[i] = floor(random() * 100) + 1;
            }

            System.out.println("Array before sort");
            System.out.println(Arrays.toString(arr));
            sw.start();
            selectionSort(arr);
            sw.stop();
            System.out.println("Array after sort");
            System.out.println(Arrays.toString(arr));
            System.out.printf("Elapsed Time: %d ms.", sw.getElapsedTime());
        }

        private static void selectionSort(double[] arr){
            int length= arr.length;
            for (int i = 0; i < length; i++) {
                int min_pos= i;
                for (int j = 0; j < length-i; j++) {
                    if(arr[min_pos]> arr[j]) min_pos= j;
                }

                if(min_pos!= i){
                    double tmp= arr[min_pos];
                    arr[min_pos]= arr[i];
                    arr[i]= tmp;
                }
            }
        }
}
