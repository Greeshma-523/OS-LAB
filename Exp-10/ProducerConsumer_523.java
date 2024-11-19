package OS;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

class Buffer {
    private int value;
    private boolean isEmpty = true;

    // Semaphore to track empty and full slots
    private final Semaphore empty = new Semaphore(1);
    private final Semaphore full = new Semaphore(0);

    // Method to produce an item in the buffer
    public void produce(int val) throws InterruptedException {
        empty.acquire();  // Wait if the buffer is full
        value = val;
        isEmpty = false;
        System.out.println("Produced value: " + value);
        full.release();   // Signal that the buffer has a value
    }

    // Method to consume an item from the buffer
    public int consume() throws InterruptedException {
        full.acquire();   // Wait if the buffer is empty
        isEmpty = true;
        int consumedValue = value;
        System.out.println("The consumed value is " + consumedValue);
        empty.release();  // Signal that the buffer is empty
        return consumedValue;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Buffer buffer = new Buffer();

        while (true) {
            System.out.println("1. Produce 2. Consume 3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Produce
                    System.out.print("Enter the value: ");
                    int value = scanner.nextInt();
                    try {
                        buffer.produce(value);
                    } catch (InterruptedException e) {
                        System.out.println("Production interrupted.");
                    }
                    break;

                case 2: // Consume
                    if (buffer.isEmpty()) {
                        System.out.println("Buffer is Empty");
                    } else {
                        try {
                            buffer.consume();
                        } catch (InterruptedException e) {
                            System.out.println("Consumption interrupted.");
                        }
                    }
                    break;

                case 3: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}