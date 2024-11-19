package OS;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Indexed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for index block
        System.out.print("Enter index block: ");
        int indexBlock = scanner.nextInt();

        // Map to store the file numbers and their allocation status
        Map<Integer, Integer> fileAllocation = new HashMap<>();

        boolean continueInput = true;
        while (continueInput) {
            // Input for number of files
            System.out.print("Enter number of files on index: ");
            int numberOfFiles = scanner.nextInt();
            for (int i = 0; i < numberOfFiles; i++) {
                System.out.print("Enter file number: ");
                int fileNumber = scanner.nextInt();
                fileAllocation.put(fileNumber, 1); // Mark as allocated
            }

            System.out.println("Allocated");
            System.out.println("File indexed");

            // Display allocated files
            for (Map.Entry<Integer, Integer> entry : fileAllocation.entrySet()) {
                System.out.println(indexBlock + " -> " + entry.getKey() + ":" + entry.getValue());
            }

            // Check if user wants to enter more files
            System.out.print("Enter 1 to enter more files and 0 to exit: ");
            int choice = scanner.nextInt();
            continueInput = (choice == 1);
        }

        scanner.close();
    }
}
