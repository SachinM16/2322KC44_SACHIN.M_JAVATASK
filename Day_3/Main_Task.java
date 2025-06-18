import java.util.ArrayList;        
import java.util.InputMismatchException; 
import java.util.Scanner;
public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice; 
        do {
            displayMenu(); 
            choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    addStudent(); 
                    break;
                case 2:
                    assignMark(); 
                    break;
                case 3:
                    displayAllResults();
                    break;
                case 4:
                    System.out.println("Exiting Student Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
            System.out.println(); 
        } while (choice != 4);
        scanner.close(); 
    }
    private static void displayMenu() {
        System.out.println("--- Student Management System ---");
        System.out.println("1. Add New Student");
        System.out.println("2. Assign Mark to Student");
        System.out.println("3. Display All Student Results");
        System.out.println("4. Exit");
        System.out.println("---------------------------------");
    }
    private static int getIntInput(String prompt) {
        while (true) { 
            System.out.print(prompt);
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.nextLine();
        }
    }
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    private static void addStudent() {
        int rollNumber = getIntInput("Enter Student Roll Number: ");
        if (findStudentByRollNumber(rollNumber) != null) {
            System.out.println("Error: Student with Roll Number " + rollNumber + " already exists. Please use a unique roll number.");
            return;
        }
        String name = getStringInput("Enter Student Name: ");
        Student newStudent = new Student(rollNumber, name);
        students.add(newStudent);
        System.out.println("Student '" + name + "' (Roll No: " + rollNumber + ") added successfully.");
    }
    private static void assignMark() {
        if (students.isEmpty()) {
            System.out.println("No students registered yet. Please add students first.");
            return;
        }
        int rollNumber = getIntInput("Enter Roll Number of the student to assign mark: ");
        Student studentToUpdate = findStudentByRollNumber(rollNumber);
        if (studentToUpdate != null) {
            int mark = getIntInput("Enter Mark for " + studentToUpdate.getName() + " (0-100): ");
            studentToUpdate.setMark(mark);
            if(mark >= 0 && mark <= 100) {
                 System.out.println("Mark assigned successfully for " + studentToUpdate.getName() + ".");
            }
        } else {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }
    private static void displayAllResults() {
        if (students.isEmpty()) {
            System.out.println("No students to display results for. Please add students first.");
            return;
        }
        System.out.println("--- Displaying All Student Results ---");
        for (Student student : students) {
            student.displayStudentDetails();
        }
        System.out.println("------------------------------------");
    }
    private static Student findStudentByRollNumber(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student; 
            }
        }
        return null; 
    }
} 
class Student {
    private int rollNumber;
    private String name;
    private int mark; 
    public Student(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.mark = -1;
    }
    public int getRollNumber() {
        return rollNumber;
    }
    public String getName() {
        return name;
    }
    public int getMark() {
        return mark;
    }
    public void setMark(int mark) {
        if (mark >= 0 && mark <= 100) {
            this.mark = mark;
        } else {
            System.out.println("Invalid mark. Mark must be between 0 and 100.");
        }
    }
    public void displayStudentDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        if (mark != -1) { 
            System.out.println("Mark: " + mark);
            if (mark >= 50) {
                System.out.println("Result: Pass");
            } else {
                System.out.println("Result: Fail");
            }
        } else {
            System.out.println("Mark: Not Assigned Yet");
            System.out.println("Result: N/A"); /
        }
        System.out.println("-----------------------");
    }
} 
