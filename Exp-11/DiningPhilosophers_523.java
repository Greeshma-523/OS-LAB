package OS;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

class Philosopher extends Thread {
    private int id;
    private Semaphore[] forks;
    private boolean isHungry = false;

    public Philosopher(int id, Semaphore[] forks) {
        this.id = id;
        this.forks = forks;
    }

    public void setHungry(boolean isHungry) {
        this.isHungry = isHungry;
    }

    public boolean isHungry() {
        return this.isHungry;
    }

    public long getId() {
        return this.id;
    }

    public void eat() throws InterruptedException {
        System.out.println("P " + id + " is granted to eat");
        Thread.sleep(1000);  // Simulate eating
        System.out.println("P " + id + " has finished eating");
    }

    public void waitToEat() {
        System.out.println("P " + id + " is waiting");
    }

    public void run() {
        // Each philosopher does nothing by default
    }
}

public class DiningPhilosophers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("DINING PHILOSOPHER PROBLEM");
        System.out.print("Enter the total no. of philosophers: ");
        int totalPhilosophers = scanner.nextInt();

        // Create semaphores for forks (one for each philosopher)
        Semaphore[] forks = new Semaphore[totalPhilosophers];
        for (int i = 0; i < totalPhilosophers; i++) {
            forks[i] = new Semaphore(1);
        }

        // Create philosophers
        Philosopher[] philosophers = new Philosopher[totalPhilosophers];
        for (int i = 0; i < totalPhilosophers; i++) {
            philosophers[i] = new Philosopher(i, forks);
        }

        System.out.print("How many are hungry: ");
        int hungryCount = scanner.nextInt();

        for (int i = 0; i < hungryCount; i++) {
            System.out.print("Enter philosopher " + (i + 1) + " position: ");
            int pos = scanner.nextInt();
            philosophers[pos - 1].setHungry(true);
        }

        while (true) {
            System.out.println("1. One can eat at a time");
            System.out.println("2. Two can eat at a time");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    allowOnePhilosopherToEat(philosophers);
                    break;
                case 2:
                    allowTwoPhilosophersToEat(philosophers);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    // Allow one philosopher to eat at a time
    private static void allowOnePhilosopherToEat(Philosopher[] philosophers) {
        System.out.println("Allow one philosopher to eat at any time");

        for (Philosopher philosopher : philosophers) {
            if (philosopher.isHungry()) {
                try {
                    philosopher.eat();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                philosopher.waitToEat();
            }
        }
    }

    // Allow two philosophers to eat at a time
    private static void allowTwoPhilosophersToEat(Philosopher[] philosophers) {
        System.out.println("Allow two philosophers to eat at same time");

        // Loop through all combinations of hungry philosophers
        for (int i = 0; i < philosophers.length; i++) {
            for (int j = i + 1; j < philosophers.length; j++) {
                if (philosophers[i].isHungry() && philosophers[j].isHungry()) {
                    System.out.println("Combination: P " + philosophers[i].getId() + " and P " + philosophers[j].getId() + " are granted to eat");
                    try {
                        philosophers[i].eat();
                        philosophers[j].eat();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    philosophers[i].waitToEat();
                    philosophers[j].waitToEat();
                }
            }
        }
    }
}

