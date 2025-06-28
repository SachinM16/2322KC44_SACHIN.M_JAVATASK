import java.io.*;

public class WriteToFileExample {
    public static void main(String[] args) {
        // File name to write to
        String fileName = "text.txt";

        // Strings to write
        String[] lines = {
            "This is the first line.",
            "This is the second line.",
            "This is the third line."
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine(); // Write a newline character
            }
            System.out.println("Data written to " + fileName + " successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
