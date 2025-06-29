# Multithreaded Banking Application (Java)

##Project Description

This mini-project is a simulation of a multithreaded banking system built using Java. It demonstrates how multiple users (threads) can attempt to withdraw money from the same bank account concurrently. The application ensures data consistency and avoids overdrawing by utilizing Java's synchronized methods. Each transaction is logged with artificial delays using `Thread.sleep()` to realistically mimic network latency or processing time. All operations include thread names and updated balances for clarity.

---

##Features

- Simulates multiple users accessing the same bank account
- Prevents race conditions and overdrawing using synchronized methods
- Uses `Thread.sleep()` to simulate real-world delays during transactions
- Logs every transaction with thread name and current balance

---

##How Concurrency is Handled

Concurrency is handled by synchronizing the `withdraw()` method in the `BankAccount` class. This ensures that only one thread can access the method at a time, thus avoiding data inconsistency or negative balances. Here's how it's done:

- Each user is represented by a `Thread` object.
- All threads share the same `BankAccount` object.
- The `withdraw()` method is marked as `synchronized` to lock access.
- Thread delays are introduced to simulate real-world banking operations and expose potential race conditions, which are then handled by synchronization.

--