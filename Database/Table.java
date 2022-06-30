package Database;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Table {
    private String path;
    Table(String path) {
        this.path = path;
    }
    public void insert(String data,boolean append) throws IOException {
        FileWriter writer = new FileWriter(path, append);
        writer.write(data + "\n");
        writer.close();
    }
    public ArrayList<String> get() throws IOException {
        ArrayList<String> data = new ArrayList<String>();
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            data.add(scanner.nextLine());
        }
        scanner.close();
        return data;
    }
    public String getPath() {
        return path;
    }
}
