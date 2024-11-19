package OS;
import java.util.Arrays;
import java.util.Scanner;
public class C_SCAN {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 // Input track positions
 System.out.print("Enter the track positions: ");
 String[] inputTracks = scanner.nextLine().split(" ");
 int numberOfTracks = inputTracks.length;
 int[] tracks = new int[numberOfTracks];
 // Parse input track positions
 for (int i = 0; i < numberOfTracks; i++) {
 tracks[i] = Integer.parseInt(inputTracks[i]);
 }
 // Input starting position
 System.out.print("Enter starting position: ");
 int headStartPosition = scanner.nextInt();
 // Sort the track positions
 Arrays.sort(tracks);
 double totalSeekTime = 0;
 // Print header for the output
 System.out.printf("%-20s %-30s%n", "Tracks traversed", 
"Difference Between tracks");
 // C-SCAN algorithm
 // Move to the right first
 for (int i = 0; i < numberOfTracks; i++) {
 if (tracks[i] >= headStartPosition) {
 int difference = Math.abs(tracks[i] -
headStartPosition);
 totalSeekTime += difference;
 System.out.printf("%-20d %-30d%n", tracks[i], 
difference);
 headStartPosition = tracks[i]; // Update head position
 }
 }
 // Jump to the beginning of the track
 if (headStartPosition != tracks[numberOfTracks - 1]) {
 int difference = Math.abs(tracks[0] - headStartPosition) 
+ Math.abs(tracks[numberOfTracks - 1] - tracks[0]);
 totalSeekTime += difference;
 System.out.printf("%-20d %-30d%n", tracks[0], 
difference);
 headStartPosition = tracks[0]; // Reset head position
 }
 // Move to the right again after jump
 for (int i = 0; i < numberOfTracks; i++) {
 if (tracks[i] > headStartPosition) {
 int difference = Math.abs(tracks[i] -
headStartPosition);
 totalSeekTime += difference;
 System.out.printf("%-20d %-30d%n", tracks[i], 
difference);
 headStartPosition = tracks[i]; // Update head position
 }
 }
 // Calculate and print average seek time
 double averageSeekTime = totalSeekTime / 
(numberOfTracks + 1); // Including jump
 System.out.printf("Average seek time: %.7f%n", 
averageSeekTime);
 
 scanner.close();
 }
}
