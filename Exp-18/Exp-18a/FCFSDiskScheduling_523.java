package OS;
import java.util.Scanner;
public class FCFSDiskScheduling {
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
 // Calculate the difference between tracks and total head movements
 int previousTrack = tracks[0];
 double totalHeadMovements = 0;
 
 System.out.printf("%-20s %-30s%n", "Tracks traversed", 
"Difference between tracks");
 
 for (int i = 0; i < numberOfTracks; i++) {
 // Calculate difference
 int difference = Math.abs(tracks[i] - previousTrack);
 totalHeadMovements += difference;
 
 // Print track and difference
 System.out.printf("%-20d %-30d%n", tracks[i], 
difference);
 previousTrack = tracks[i]; // Update previous track
 }
 // Calculate and print average head movements
 double averageHeadMovements = totalHeadMovements 
/ numberOfTracks;
 System.out.printf("Average head movements: %.6f%n", 
averageHeadMovements);
 
 scanner.close();
 }
}