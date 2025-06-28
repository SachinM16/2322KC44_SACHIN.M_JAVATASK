import java.io.*;

public class ReadFileExample {
    public static void main(String[] args) {
        // Path to the file (if placed in the same folder as your Java file or compiled .class file)
        String fileName = "demo.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("File content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
