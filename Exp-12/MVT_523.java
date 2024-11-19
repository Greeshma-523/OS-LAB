package OS;
import java.util.Scanner;
public class MVT{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total memory available (in Bytes): ");
        int totalMemory = sc.nextInt();
        int availableMemory = totalMemory;

        int totalAllocatedMemory = 0;
        int processCount = 0;

        boolean continueAllocation = true;

        while (continueAllocation && availableMemory > 0) {
            processCount++;
            System.out.print("Enter memory required for process " + processCount + " (in Bytes): ");
            int memoryRequired = sc.nextInt();

            if (memoryRequired <= availableMemory) {
                availableMemory -= memoryRequired;
                totalAllocatedMemory += memoryRequired;
                System.out.println("Memory is allocated for Process " + processCount);
            } else {
                System.out.println("Memory is Full");
                processCount--; 
                break;
            }

            
            System.out.print("Do you want to continue(y/n): ");
            char choice = sc.next().charAt(0);
            if (choice == 'n' || choice == 'N') {
                continueAllocation = false;
            }
        }

        
        System.out.println("\nTotal Memory Available: " + totalMemory);
        System.out.println("PROCESS\tMEMORY ALLOCATED");

        for (int i = 1; i <= processCount; i++) {
            int memoryAllocated = (i == processCount && availableMemory + totalAllocatedMemory < totalMemory) ? 0 : totalMemory - availableMemory;
            System.out.println(i + "\t\t" + memoryAllocated);
        }

        System.out.println("Total Memory Allocated is " + totalAllocatedMemory);
        int externalFragmentation = availableMemory;
        System.out.println("Total External Fragmentation is " + externalFragmentation);

        
    }
}
