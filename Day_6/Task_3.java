class Worker extends Thread {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    public void run() {
        try {
            System.out.println(name + " is starting...");
            Thread.sleep(1000); // Simulate work (1 second)
            System.out.println(name + " has completed.");
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted.");
        }
    }
}

public class ThreadCoordination {
    public static void main(String[] args) {
        Worker w1 = new Worker("Worker-1");
        Worker w2 = new Worker("Worker-2");

        w1.start();
        try {
            // Ensure Worker-1 finishes before starting Worker-2
            w1.join(); // Main thread waits for w1 to finish
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        w2.start();
        try {
            w2.join(); // Wait for Worker-2 to finish before ending main
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Main thread exiting.");
    }
}
