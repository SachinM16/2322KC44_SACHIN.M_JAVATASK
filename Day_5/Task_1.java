import java.util.ArrayList;
import java.util.Iterator;

public class StudentList {
    public static void main(String[] args) {
        // Create ArrayList of students
        ArrayList<String> students = new ArrayList<>();
        students.add("Alice");
        students.add("Bob");
        students.add("Charlie");
        students.add("Diana");

        // Display using Iterator
        Iterator<String> iterator = students.iterator();
        System.out.println("Student List:");
        while (iterator.hasNext()) {
            String student = iterator.next();
            System.out.println(student);
        }
    }
}
