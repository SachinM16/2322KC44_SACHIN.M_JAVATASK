public class NumberPrinter extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Number: " + i);
            try {
                Thread.sleep(500); // Optional: Pause for 0.5 seconds between numbers
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
    }

    public static void main(String[] args) {
        NumberPrinter thread = new NumberPrinter();
        thread.start(); // Start the thread
    }
}
