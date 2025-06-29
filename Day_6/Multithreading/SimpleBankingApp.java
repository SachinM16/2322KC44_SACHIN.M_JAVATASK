import java.util.concurrent.atomic.AtomicInteger;

public class SimpleBankingApp {
    
    private static double accountBalance = 1000.0;
    private static AtomicInteger transactionCounter = new AtomicInteger(0);
    
    public static synchronized boolean withdraw(double amount, String userName) {
        String threadName = Thread.currentThread().getName();
        int transactionId = transactionCounter.incrementAndGet();
        
        try {
            System.out.println("Transaction #" + transactionId + 
                             " | Thread: " + threadName + 
                             " | User: " + userName + 
                             " | Attempting to withdraw: $" + amount);
            
            Thread.sleep(200);
            
            if (accountBalance >= amount && amount > 0) {
                Thread.sleep(300);
                accountBalance -= amount;
                
                System.out.println("SUCCESS | Transaction #" + transactionId + 
                                 " | Thread: " + threadName + 
                                 " | User: " + userName + 
                                 " | Withdrew: $" + amount + 
                                 " | New Balance: $" + accountBalance);
                return true;
            } else {
                System.out.println("FAILED | Transaction #" + transactionId + 
                                 " | Thread: " + threadName + 
                                 " | User: " + userName + 
                                 " | Insufficient funds! Attempted: $" + amount + 
                                 " | Available: $" + accountBalance);
                return false;
            }
            
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " was interrupted");
            return false;
        }
    }
    
    static class BankUser implements Runnable {
        private String userName;
        private double[] withdrawalAmounts;
        
        public BankUser(String userName, double[] withdrawalAmounts) {
            this.userName = userName;
            this.withdrawalAmounts = withdrawalAmounts;
        }
        
        public void run() {
            System.out.println("User " + userName + " started on thread: " + 
                             Thread.currentThread().getName());
            
            for (int i = 0; i < withdrawalAmounts.length; i++) {
                withdraw(withdrawalAmounts[i], userName);
                
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    System.out.println(userName + " was interrupted");
                    break;
                }
            }
            
            System.out.println("User " + userName + " completed all transactions");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== MULTITHREADED BANKING APPLICATION ===");
        System.out.println("Initial Account Balance: $" + accountBalance);
        System.out.println("Starting concurrent banking operations...");
        
        BankUser alice = new BankUser("Alice", new double[]{150.0, 200.0, 100.0});
        BankUser bob = new BankUser("Bob", new double[]{250.0, 300.0, 150.0});
        BankUser charlie = new BankUser("Charlie", new double[]{100.0, 400.0, 200.0});
        BankUser diana = new BankUser("Diana", new double[]{350.0, 100.0, 250.0});
        
        Thread thread1 = new Thread(alice, "Banking-Thread-1");
        Thread thread2 = new Thread(bob, "Banking-Thread-2");
        Thread thread3 = new Thread(charlie, "Banking-Thread-3");
        Thread thread4 = new Thread(diana, "Banking-Thread-4");
        
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted");
        }
        
        System.out.println("=== FINAL RESULTS ===");
        System.out.println("Final Account Balance: $" + accountBalance);
        System.out.println("Total Transactions: " + transactionCounter.get());
        System.out.println("SUCCESS: No overdrawing occurred!");
        
        System.out.println("=== OVERDRAW PREVENTION TEST ===");
        Thread testThread1 = new Thread(new Runnable() {
            public void run() {
                withdraw(accountBalance, "TestUser1");
            }
        }, "Test-Thread-1");
        
        Thread testThread2 = new Thread(new Runnable() {
            public void run() {
                withdraw(50.0, "TestUser2");
            }
        }, "Test-Thread-2");
        
        testThread1.start();
        testThread2.start();
        
        try {
            testThread1.join();
            testThread2.join();
        } catch (InterruptedException e) {
            System.out.println("Test interrupted");
        }
        
        System.out.println("Final Balance: $" + accountBalance);
        System.out.println("Application completed successfully!");
    }
}