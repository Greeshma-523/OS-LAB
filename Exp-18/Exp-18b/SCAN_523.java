package OS;
import java.util.Arrays;
import java.util.Scanner;
public class SCAN {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 // Input the number of tracks
 System.out.print("Enter no. of tracks: ");
 int numberOfTracks = scanner.nextInt();
 
 // Array to hold track positions
 int[] tracks = new int[numberOfTracks];
 // Input track positions
 System.out.print("Enter track positions: ");
 for (int i = 0; i < numberOfTracks; i++) {
 tracks[i] = scanner.nextInt();
 }
 // Sort the track positions
 Arrays.sort(tracks);
 // Assuming the disk head starts at the first track
 int headStartPosition = tracks[0]; // You can modify this to start at a specific position
 double totalHeadMovements = 0;
 // Print header for the output
 System.out.printf("%-20s %-30s%n", "Tracks traversed", 
"Difference between tracks");
 
 // SCAN algorithm: moving to the right then left
 // Traverse to the right
 for (int i = 0; i < numberOfTracks; i++) {
 if (tracks[i] >= headStartPosition) {
 int difference = Math.abs(tracks[i] -
headStartPosition);
 totalHeadMovements += difference;
 System.out.printf("%-20d %-30d%n", tracks[i], 
difference);
 headStartPosition = tracks[i]; // Update head position
 }
 }
 
 // Traverse to the left
 for (int i = numberOfTracks - 1; i >= 0; i--) {
 if (tracks[i] < headStartPosition) {
 int difference = Math.abs(tracks[i] -
headStartPosition);
 totalHeadMovements += difference;
 System.out.printf("%-20d %-30d%n", tracks[i], 
difference);
 headStartPosition = tracks[i]; // Update head position
 }
 }
 // Calculate and print average head movements
 double averageHeadMovements = totalHeadMovements 
/ numberOfTracks;
 System.out.printf("Average head movements: %.2f%n", 
averageHeadMovements);
 
 scanner.close();
 }
}