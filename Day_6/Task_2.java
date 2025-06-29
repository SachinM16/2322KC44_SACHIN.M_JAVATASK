class MessagePrinter implements Runnable {
    private String message;

    public MessagePrinter(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + message + " (" + i + ")");
            try {
                Thread.sleep(300); // Optional: pause for readability
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
    }

    public static void main(String[] args) {
        // Create Runnable instances
        Runnable r1 = new MessagePrinter("Hello from Thread 1");
        Runnable r2 = new MessagePrinter("Hello from Thread 2");

        // Create threads and start them
        Thread t1 = new Thread(r1, "Thread-1");
        Thread t2 = new Thread(r2, "Thread-2");

        t1.start();
        t2.start();
    }
}
