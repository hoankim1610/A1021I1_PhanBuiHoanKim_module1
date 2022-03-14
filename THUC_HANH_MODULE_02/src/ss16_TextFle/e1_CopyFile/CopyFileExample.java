package ss16_TextFle.e1_CopyFile;

import java.io.*;

public class CopyFileExample {
    public static void main(String[] args) throws IOException {
        InputStream inStream = null;
        OutputStream outStream = null;

        try {
            inStream = new FileInputStream(new File("src/numbers.txt"));
            outStream = new FileOutputStream(new File("result.txt"));

            int length;
            byte[] buffer = new byte[1024];

            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }
            System.out.println("File is copied successful!");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("File is not found or faulty!");
        } finally {
            inStream.close();
            outStream.close();
        }
    }
}
