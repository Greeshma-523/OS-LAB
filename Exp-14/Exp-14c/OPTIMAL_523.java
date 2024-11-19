package OS;
import java.util.Scanner;
import java.util.ArrayList;

public class OPTIMAL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Length of reference string
        System.out.print("Enter length of the reference string: ");
        int referenceLength = scanner.nextInt();

        // Input: Reference string
        int[] referenceString = new int[referenceLength];
        System.out.println("Enter the reference string:");
        for (int i = 0; i < referenceLength; i++) {
            referenceString[i] = scanner.nextInt();
        }

        // Input: Number of frames
        System.out.print("Enter no of frames: ");
        int numberOfFrames = scanner.nextInt();

        ArrayList<Integer> frames = new ArrayList<>(numberOfFrames);
        int pageFaults = 0;

        // Process each page in the reference string
        for (int i = 0; i < referenceLength; i++) {
            int page = referenceString[i];

            // Check if page is already in frames
            if (frames.contains(page)) {
                // Page is already in memory, no page fault
            } else {
                // Page fault occurs if page is not in frames
                pageFaults++;

                // If frames are full, we need to replace a page
                if (frames.size() == numberOfFrames) {
                    int farthest = i + 1;
                    int pageToReplace = -1;

                    // Find the optimal page to replace
                    for (Integer framePage : frames) {
                        int j;
                        for (j = i + 1; j < referenceLength; j++) {
                            if (referenceString[j] == framePage) {
                                if (j > farthest) {
                                    farthest = j;
                                    pageToReplace = framePage;
                                }
                                break;
                            }
                        }
                        if (j == referenceLength) { // If page not found in future, replace it
                            pageToReplace = framePage;
                            break;
                        }
                    }

                    // Remove the page that is farthest in future
                    frames.remove((Integer) pageToReplace);
                }

                // Add the new page to frames
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
        System.out.println("Number of page faults: " + pageFaults);

        // Calculate and output the page fault rate
        float pageFaultRate = (float) pageFaults / referenceLength * 100;
        System.out.printf("Page fault rate = %.2f\n", pageFaultRate);

        scanner.close();
    }
}