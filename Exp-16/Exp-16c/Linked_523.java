package OS;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Linked {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for blocks that are already allocated
        System.out.print("Enter how many blocks are already allocated: ");
        int allocatedCount = scanner.nextInt();

        Set<Integer> allocatedBlocks = new HashSet<>();
        System.out.print("Enter the block numbers that are already allocated: ");
        for (int i = 0; i < allocatedCount; i++) {
            allocatedBlocks.add(scanner.nextInt());
        }

        // Input for starting index block and length of the file
        System.out.print("Enter the starting index block & length: ");
        int startBlock = scanner.nextInt();
        int length = scanner.nextInt();

        // Attempting to allocate blocks
        int blocksAllocated = 0;
        int currentBlock = startBlock;

        while (blocksAllocated < length) {
            System.out.print(currentBlock + " -> ");
            if (allocatedBlocks.contains(currentBlock)) {
                System.out.println("1 (file is already allocated)");
            } else {
                System.out.println("1");
                blocksAllocated++;
            }
            currentBlock++;
        }

        System.out.println("File is allocated to disk.");
        scanner.close();
    }
}
