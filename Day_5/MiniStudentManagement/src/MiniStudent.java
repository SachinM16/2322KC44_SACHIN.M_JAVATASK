import java.io.*;
import java.util.*;

public class StudentManagementApp {
    static ArrayList<String> studentNames = new ArrayList<>();
    static HashMap<Integer, List<String>> studentCourses = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Mini Student Management App ---");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student by ID");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All");
            System.out.println("5. Save to File");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent(sc);
                case 2 -> searchStudent(sc);
                case 3 -> deleteStudent(sc);
                case 4 -> displayAll();
                case 5 -> saveToFile();
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 6);

        sc.close();
    }

    static void addStudent(Scanner sc) {
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        if (studentCourses.containsKey(id)) {
            System.out.println("Student ID already exists.");
            return;
        }

        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        studentNames.add(name);

        List<String> courses = new ArrayList<>();
        System.out.print("Enter number of courses: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter course " + (i + 1) + ": ");
            courses.add(sc.nextLine());
        }

        studentCourses.put(id, courses);
        System.out.println("Student added successfully.");
    }

    static void searchStudent(Scanner sc) {
        System.out.print("Enter student ID to search: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (studentCourses.containsKey(id)) {
            System.out.println("Courses enrolled: " + studentCourses.get(id));
        } else {
            System.out.println("Student ID not found.");
        }
    }

    static void deleteStudent(Scanner sc) {
        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (studentCourses.remove(id) != null) {
            System.out.println("Student deleted.");
        } else {
            System.out.println("Student ID not found.");
        }
    }

    static void displayAll() {
        System.out.println("\n--- All Student Data ---");
        for (Map.Entry<Integer, List<String>> entry : studentCourses.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Courses: " + entry.getValue());
        }
    }

    static void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("courses.txt"))) {
            for (Map.Entry<Integer, List<String>> entry : studentCourses.entrySet()) {
                writer.write("ID: " + entry.getKey() + " - " + String.join(", ", entry.getValue()));
                writer.newLine();
            }
            System.out.println("Courses saved to courses.txt.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}
