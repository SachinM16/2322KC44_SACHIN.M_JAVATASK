import java.util.Scanner;

public class MiniAddressBook {

    static final int MAX_CONTACTS = 100;
    static String[] contacts = new String[MAX_CONTACTS];
    static int count = 0;
    public static void addContact(String name, String phone) {
        if (count < MAX_CONTACTS) {
            contacts[count] = name + " - " + phone;
            count++;
            System.out.println("Contact added successfully.\n");
        } else {
            System.out.println("Address book is full!\n");
        }
    }
    public static void displayContacts() {
        if (count == 0) {
            System.out.println("Address book is empty.\n");
        } else {
            System.out.println("---- Address Book ----");
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ". " + contacts[i]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Mini Address Book");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 
          switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();
                    addContact(name, phone);
                    break;
                case 2:
                    displayContacts();
                    break;
                case 3:
                    System.out.println("Exiting Address Book...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        } while (choice != 3);
        sc.close();
    }
}
