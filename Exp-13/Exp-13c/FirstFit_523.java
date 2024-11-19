package OS;
import java.util.Scanner;

public class FirstFit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of blocks
        System.out.print("Enter the number of blocks: ");
        int numBlocks = sc.nextInt();
        int[] blockSize = new int[numBlocks];
        boolean[] blockAllocated = new boolean[numBlocks];

        // Input block sizes
        System.out.println("Enter the size of the blocks:");
        for (int i = 0; i < numBlocks; i++) {
            System.out.print("Block " + (i + 1) + ": ");
            blockSize[i] = sc.nextInt();
            blockAllocated[i] = false; // Initially, no blocks are allocated
        }

        // Input number of files
        System.out.print("Enter the number of files: ");
        int numFiles = sc.nextInt();
        int[] fileSize = new int[numFiles];
        int[] allocation = new int[numFiles]; // To store block allocated to each file

        // Input file sizes
        System.out.println("Enter the size of the files:");
        for (int i = 0; i < numFiles; i++) {
            System.out.print("File " + (i + 1) + ": ");
            fileSize[i] = sc.nextInt();
            allocation[i] = -1; // Initially no allocation
        }

        // First Fit allocation algorithm
        for (int i = 0; i < numFiles; i++) {
            for (int j = 0; j < numBlocks; j++) {
                if (!blockAllocated[j] && blockSize[j] >= fileSize[i]) {
                    allocation[i] = j; // Allocate the block
                    blockAllocated[j] = true; // Mark block as allocated
                    break; // Move to the next file
                }
            }
        }

        // Output the allocation details
        System.out.println("\nFile No\tFile Size\tBlock No\tBlock Size\tFragment");
        for (int i = 0; i < numFiles; i++) {
            if (allocation[i] != -1) {
                int blockIndex = allocation[i];
                int fragment = blockSize[blockIndex] - fileSize[i];
                System.out.println((i + 1) + "\t\t" + fileSize[i] + "\t\t" + (blockIndex + 1) + "\t\t" + blockSize[blockIndex] + "\t\t" + fragment);
            } else {
                System.out.println((i + 1) + "\t\t" + fileSize[i] + "\t\t" + "Not Allocated");
            }
        }

        sc.close();
    }
}