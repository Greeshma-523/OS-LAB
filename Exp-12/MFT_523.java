package OS;
import java.util.Scanner;
public class MFT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total memory available (in Bytes): ");
        int totalMemory = sc.nextInt();
        System.out.print("Enter the block size (in Bytes): ");
        int blockSize = sc.nextInt();
        
        System.out.print("Enter the number of processes: ");
        int numProcesses = sc.nextInt();
        
        int[] processMemory = new int[numProcesses];
        for (int i = 0; i < numProcesses; i++) {
            System.out.print("Enter memory required for process " + (i + 1) + " (in Bytes): ");
            processMemory[i] = sc.nextInt();
        }
        int numBlocks = totalMemory / blockSize;
        System.out.println("No. of Blocks available in memory: " + numBlocks);
        System.out.println("\nPROCESS\tMEMORY REQUIRED\t\tALLOCATED\tINTERNAL FRAGMENTATION");
        int totalInternalFragmentation = 0;
        int externalFragmentation = 0;
        int allocatedProcesses = 0;
        for (int i = 0; i < numProcesses; i++) {
            if (allocatedProcesses < numBlocks) {
                if (processMemory[i] <= blockSize) {
                    int internalFragmentation = blockSize - processMemory[i];
                    totalInternalFragmentation += internalFragmentation;
                    allocatedProcesses++;
                    System.out.println((i + 1) + "\t\t" + processMemory[i] + "\t\tYES\t\t" + internalFragmentation);
                } else {
                    System.out.println((i + 1) + "\t\t" + processMemory[i] + "\t\tNO\t\t---");
                }
            } else {
                externalFragmentation += processMemory[i];
                System.out.println((i + 1) + "\t\t" + processMemory[i] + "\t\tNO\t\t---");
            }
        }
        
        System.out.println("Memory is Full, Remaining Processes cannot be accommodated");
        System.out.println("Total Internal Fragmentation is " + totalInternalFragmentation);
        System.out.println("Total External Fragmentation is " + externalFragmentation);
          }
}
