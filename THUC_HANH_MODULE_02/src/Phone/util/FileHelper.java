package Phone.util;

import Phone.model.HandPhone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHelper<T> {
    public List<String> read(String path) {
        List<String> result = new ArrayList<>();
        createIfNotExists(path);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty())
                    result.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void write(String path, List<T> ts, boolean isAppend) {
        createIfNotExists(path);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, isAppend))) {
            for (int i = 0; i < ts.size(); i++) {
                bufferedWriter.write(ts.get(i).toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createIfNotExists(String path) {
        try {
            File file = new File(path);
            if (!file.exists())
                file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
