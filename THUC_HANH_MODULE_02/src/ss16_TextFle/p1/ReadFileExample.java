package ss16_TextFle.p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFileExample {

    public void readFileText(String filePath) {
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            br.close();

            System.out.println("Sum = " + sum);
        } catch (Exception e) {
            System.err.println("File is not found or faulty!");
        }
    }

    public static void main(String[] args) {
            System.out.println("Enter file path: ");
            Scanner scanner = new Scanner(System.in);
            String path = scanner.nextLine();

            ReadFileExample readFileEx = new ReadFileExample();
            readFileEx.readFileText(path);
    }
}
