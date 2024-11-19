package OS;
import java.util.Scanner;

public class Sequential {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for starting block and length of the file
        System.out.print("Enter the starting block & length of file: ");
        int startingBlock = scanner.nextInt();
        int length = scanner.nextInt();

        // Allocating blocks
        for (int i = 0; i < length; i++) {
            int blockNumber = startingBlock + i;
            System.out.println(blockNumber + " -> 1");
        }

        System.out.println("The file is allocated to disk.");
        scanner.close();
    }
}

