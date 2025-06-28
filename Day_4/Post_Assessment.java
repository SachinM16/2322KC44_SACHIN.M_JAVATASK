import java.io.*;
import java.util.*;

public class EmployeeSystem {
    static final String FILE_NAME = "employee.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Employee Record System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addEmployee(sc);
                case 2 -> viewEmployees();
                case 3 -> updateEmployee(sc);
                case 4 -> deleteEmployee(sc);
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice");
            }
        } while (choice != 5);
    }

    static void addEmployee(Scanner sc) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            System.out.print("Enter ID: ");
            String id = sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Department: ");
            String dept = sc.nextLine();
            System.out.print("Enter Salary: ");
            String salary = sc.nextLine();

            writer.write(id + "," + name + "," + dept + "," + salary);
            writer.newLine();
            System.out.println("Employee added.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void viewEmployees() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n--- Employee List ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void updateEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to update: ");
        String updateId = sc.nextLine();
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(updateId)) {
                    found = true;
                    System.out.print("Enter new Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter new Department: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter new Salary: ");
                    String salary = sc.nextLine();
                    writer.write(updateId + "," + name + "," + dept + "," + salary);
                } else {
                    writer.write(line);
                }
                writer.newLine();
            }

            if (found) {
                if (!inputFile.delete() || !tempFile.renameTo(inputFile)) {
                    System.out.println("Error updating file.");
                } else {
                    System.out.println("Employee updated.");
                }
            } else {
                tempFile.delete();
                System.out.println("Employee ID not found.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void deleteEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to delete: ");
        String deleteId = sc.nextLine();
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(deleteId)) {
                    found = true;
                    continue; // Skip writing this line
                }
                writer.write(line);
                writer.newLine();
            }

            if (found) {
                if (!inputFile.delete() || !tempFile.renameTo(inputFile)) {
                    System.out.println("Error deleting file.");
                } else {
                    System.out.println("Employee deleted.");
                }
            } else {
                tempFile.delete();
                System.out.println("Employee ID not found.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
