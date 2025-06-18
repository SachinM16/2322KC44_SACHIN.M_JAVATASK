import java.util.ArrayList;
import java.util.Scanner;
class Book {
    String title;
    String author;
    boolean isIssued;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    @Override
    public String toString() {
        return title + " by " + author + (isIssued ? " [Issued]" : " [Available]");
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();
    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added successfully.\n");
    }
    public void removeBook(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                books.remove(book);
                System.out.println("Book removed successfully.\n");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found.\n");
        }
    }
    public void issueBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                if (!book.isIssued) {
                    book.isIssued = true;
                    System.out.println("Book issued successfully.\n");
                } else {
                    System.out.println("Book is already issued.\n");
                }
                return;
            }
        }
        System.out.println("Book not found.\n");
    }
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty.\n");
        } else {
            System.out.println("---- Book List ----");
            for (Book book : books) {
                System.out.println(book);
            }
            System.out.println();
        }
    }
}
public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("Library Menu");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Title: ");
                    String titleAdd = sc.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();
                    library.addBook(titleAdd, author);
                    break;
                case 2:
                    System.out.print("Enter Book Title to Remove: ");
                    String titleRemove = sc.nextLine();
                    library.removeBook(titleRemove);
                    break;
                case 3:
                    System.out.print("Enter Book Title to Issue: ");
                    String titleIssue = sc.nextLine();
                    library.issueBook(titleIssue);
                    break;
                case 4:
                    library.displayBooks();
                    break;
                case 5:
                    System.out.println("Exiting Library System...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.\n");
            }

        } while (choice != 5);

        sc.close();
    }
}
