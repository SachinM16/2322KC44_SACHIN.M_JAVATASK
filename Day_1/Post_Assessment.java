import java.util.Scanner;

public class StudentResult {
    public static int calculateTotal(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }
    public static double calculateAverage(int total, int numSubjects) {
        return (double) total / numSubjects;
    }
    public static String determineGrade(double average) {
        if (average >= 90) return "A+";
        else if (average >= 80) return "A";
        else if (average >= 70) return "B";
        else if (average >= 60) return "C";
        else if (average >= 50) return "D";
        else return "Fail";
    }
    public static void printResult(String name, int[] marks, int total, double average, String grade) {
        System.out.println("\n----- Student Result -----");
        System.out.println("Name: " + name);
        System.out.println("Marks:");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Subject " + (i + 1) + ": " + marks[i]);
        }
        System.out.println("Total: " + total);
        System.out.printf("Average: %.2f\n", average);
        System.out.println("Grade: " + grade);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        int numSubjects = 5;
        int[] marks = new int[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
        int total = calculateTotal(marks);
        double average = calculateAverage(total, numSubjects);
        String grade = determineGrade(average);
        printResult(name, marks, total, average, grade);
        
        sc.close();
    }
}
