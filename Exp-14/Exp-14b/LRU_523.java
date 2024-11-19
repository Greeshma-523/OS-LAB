package OS;
import java.util.ArrayList;
import java.util.Scanner;

public class LRU {
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

        // LRU Page Replacement
        ArrayList<Integer> frames = new ArrayList<>(numberOfFrames);
        int pageFaults = 0;

        // Process each page in the reference string
        for (int i = 0; i < numberOfPages; i++) {
            int page = pageReference[i];

            // Check if the page is already in the frames
            if (frames.contains(page)) {
                // If page is in frames, move it to the end (most recently used)
                frames.remove((Integer) page);
                frames.add(page);
            } else {
                // Page fault occurs if the page is not in frames
                pageFaults++;

                // If frames are full, remove the least recently used page (first element)
                if (frames.size() == numberOfFrames) {
                    frames.remove(0);
                }

                // Add the new page to the frames
                frames.add(page);
            }

            // Print the current status of the frames
            for (int j = 0; j < numberOfFrames; j++) {
                if (j < frames.size()) {
                    System.out.print(frames.get(j) + " ");
                } else {
                    System.out.print("-1 ");
                }
            }
            System.out.println();
        }

        // Output the total number of page faults
        System.out.println("No of page faults: " + pageFaults);
        
        scanner.close();
    }
}