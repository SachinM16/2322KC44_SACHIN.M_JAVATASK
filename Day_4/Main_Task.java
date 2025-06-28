import java.io.*;

public class ResultProcessor {
    public static void main(String[] args) {
        String inputFile = "Marks.txt";     // You MUST create this file manually
        String outputFile = "results.txt";  // This file will be created by the program

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split by comma: name, mark1, mark2, mark3
                String[] parts = line.split(",");
                String name = parts[0];
                int total = 0;

                for (int i = 1; i < parts.length; i++) {
                    total += Integer.parseInt(parts[i]);
                }

                double average = total / (parts.length - 1.0);
                writer.write(name + " - Total: " + total + ", Average: " + average);
                writer.newLine();
            }

            System.out.println("Results written to " + outputFile + " successfully.");
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
