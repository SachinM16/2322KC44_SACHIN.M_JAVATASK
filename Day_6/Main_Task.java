class TicketCounter {
    private int seatsAvailable = 5;

    // Synchronized method to book tickets
    public void bookTicket(String user, int seatsRequested) {
        System.out.println(user + " trying to book " + seatsRequested + " seat(s)...");

        synchronized (this) {
            if (seatsAvailable >= seatsRequested) {
                System.out.println(user + " booking in progress...");
                try {
                    Thread.sleep(1000); // simulate delay
                } catch (InterruptedException e) {
                    System.out.println("Booking interrupted.");
                }

                seatsAvailable -= seatsRequested;
                System.out.println(user + " successfully booked " + seatsRequested + " seat(s).");
            } else {
                System.out.println("Sorry " + user + ", only " + seatsAvailable + " seat(s) available.");
            }

            System.out.println("Remaining seats: " + seatsAvailable);
        }
    }
}

class User extends Thread {
    private String name;
    private int seatsToBook;
    private TicketCounter counter;

    public User(String name, int seatsToBook, TicketCounter counter) {
        this.name = name;
        this.seatsToBook = seatsToBook;
        this.counter = counter;
    }

    public void run() {
        counter.bookTicket(name, seatsToBook);
    }
}

public class TicketBookingSimulation {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter();

        // Multiple users trying to book tickets
        User u1 = new User("Alice", 2, counter);
        User u2 = new User("Bob", 1, counter);
        User u3 = new User("Charlie", 3, counter); // may fail due to limited seats
        User u4 = new User("Diana", 1, counter);   // may or may not succeed

        // Start booking threads
        u1.start();
        u2.start();
        u3.start();
        u4.start();
    }
}
