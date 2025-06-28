import java.util.HashMap;
import java.util.Map;

public class StudentMarksAverage {
    public static void main(String[] args) {
        // Create a HashMap to store student name → marks
        HashMap<String, Integer> studentMarks = new HashMap<>();

        // Add data
        studentMarks.put("Alice", 85);
        studentMarks.put("Bob", 78);
        studentMarks.put("Charlie", 92);
        studentMarks.put("Diana", 88);

        // Display all students and their marks
        System.out.println("Student Marks:");
        for (Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        // Compute average
        int total = 0;
        for (int marks : studentMarks.values()) {
            total += marks;
        }

        double average = (double) total / studentMarks.size();
        System.out.println("\nAverage Marks: " + average);
    }
}
