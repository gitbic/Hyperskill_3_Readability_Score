package readability;

import java.io.*;
import java.util.Scanner;

class FileIO {

    void write(String str, String path) {
        try (FileWriter fw = new FileWriter(path)) {
            fw.write(str);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    String read(String path) {
        try (Scanner sc = new Scanner(new File(path))) {
            StringBuilder sb = new StringBuilder();
            while (sc.hasNext()) {
                sb.append(sc.nextLine());
            }
            return sb.toString();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
