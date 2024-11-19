package OS;
import java.util.Scanner;
public class DeadLockPrevention {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 // Input for number of jobs
 System.out.print("Enter no of jobs: ");
 int numJobs = scanner.nextInt();
 String[] jobNames = new String[numJobs];
 int[] jobTimes = new int[numJobs];
 // Input for job names and their execution times
 for (int i = 0; i < numJobs; i++) {
 System.out.print("Enter name and time: ");
 jobNames[i] = scanner.next();
 jobTimes[i] = scanner.nextInt();
 }
 // Input for available resources
 System.out.print("Enter the available resources: ");
 int availableResources = scanner.nextInt();
 // Initialize the safe sequence and remaining resources
 StringBuilder safeSequence = new StringBuilder();
 int remainingResources = availableResources;
 // Check if we can find a safe sequence
 boolean[] completed = new boolean[numJobs];
 int completedCount = 0;
 while (completedCount < numJobs) {
 boolean found = false;
 for (int i = 0; i < numJobs; i++) {
 // Check if the job can be completed and hasn't been completed yet
 if (!completed[i] && jobTimes[i] <= 
remainingResources) {
 // Allocate resources to this job
 remainingResources -= jobTimes[i];
 safeSequence.append(jobNames[i]).append(" ").append(jobTimes[i]).append(", ");
 completed[i] = true;
 completedCount++;
 found = true;
 }
 }
 // If no job was found that could be executed, we have a potential deadlock
 if (!found) {
 System.out.println("No safe sequence found. Potential deadlock!");
 return;
 }
 }
 // Print the safe sequence
 System.out.println("Safe sequence is: " + 
safeSequence.substring(0, safeSequence.length() - 2) + ".");
 scanner.close();
 }
}