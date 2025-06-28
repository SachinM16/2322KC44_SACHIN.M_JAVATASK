import java.util.HashSet;

public class UniqueEmailSet {
    public static void main(String[] args) {
        // Create a HashSet to store unique email addresses
        HashSet<String> emailSet = new HashSet<>();

        // Add email addresses
        emailSet.add("alice@example.com");
        emailSet.add("bob@example.com");
        emailSet.add("charlie@example.com");
        emailSet.add("alice@example.com"); // Duplicate, will not be added

        // Display the unique email addresses
        System.out.println("Unique Email Addresses:");
        for (String email : emailSet) {
            System.out.println(email);
        }
    }
}
