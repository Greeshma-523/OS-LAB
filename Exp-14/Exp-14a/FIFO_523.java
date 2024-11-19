package OS;
import java.util.Scanner;

public class FIFO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of frames
        System.out.print("Enter the number of frames: ");
        int numberOfFrames = scanner.nextInt();

        // Input: Number of pages
        System.out.print("Enter the number of pages: ");
        int numberOfPages = scanner.nextInt();

        // Input: Page reference string
        int[] pageReference = new int[numberOfPages];
        System.out.println("Enter the page reference string:");
        for (int i = 0; i < numberOfPages; i++) {
            pageReference[i] = scanner.nextInt();
        }

        // FIFO Page Replacement
        int[] frames = new int[numberOfFrames];
        int pageFaults = 0;
        int index = 0; // To keep track of the next frame to replace

        // Initialize frames with -1
        for (int i = 0; i < numberOfFrames; i++) {
            frames[i] = -1;
        }

        // Process each page in the reference string
        for (int i = 0; i < numberOfPages; i++) {
            boolean pageFound = false;

            // Check if the page is already in the frames
            for (int j = 0; j < numberOfFrames; j++) {
                if (frames[j] == pageReference[i]) {
                    pageFound = true; // Page is found
                    break;
                }
            }

            // If page not found, it's a page fault
            if (!pageFound) {
                frames[index] = pageReference[i]; // Replace the oldest page
                index = (index + 1) % numberOfFrames; // Move to the next frame
                pageFaults++; // Increment page fault count
            }

            // Print the current status of the frames
            for (int j = 0; j < numberOfFrames; j++) {
                System.out.print(frames[j] + " ");
            }
            System.out.println();
        }

        // Output the total number of page faults
        System.out.println("Number of page faults: " + pageFaults);
        
        scanner.close();
    }
}


