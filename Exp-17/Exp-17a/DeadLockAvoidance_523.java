package OS;
import java.util.Scanner;
public class DeadLockAvoidance {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 // Input for number of processes and resources
 System.out.print("Enter the no. of processes and resources: ");
 int numProcesses = scanner.nextInt();
 int numResources = scanner.nextInt();
 // Input for claim matrix
 int[][] claimMatrix = new 
int[numProcesses][numResources];
 System.out.println("Enter the claim matrix:");
 for (int i = 0; i < numProcesses; i++) {
 for (int j = 0; j < numResources; j++) {
 claimMatrix[i][j] = scanner.nextInt();
 }
 }
 // Input for allocation matrix
 int[][] allocationMatrix = new 
int[numProcesses][numResources];
 System.out.println("Enter the allocation matrix:");
 for (int i = 0; i < numProcesses; i++) {
 for (int j = 0; j < numResources; j++) {
 allocationMatrix[i][j] = scanner.nextInt();
 }
 }
 // Input for available resources
 int[] available = new int[numResources];
 System.out.print("Resource vector:");
 for (int i = 0; i < numResources; i++) {
 available[i] = scanner.nextInt();
 }
 // Create need matrix
 int[][] needMatrix = new 
int[numProcesses][numResources];
 for (int i = 0; i < numProcesses; i++) {
 for (int j = 0; j < numResources; j++) {
 needMatrix[i][j] = claimMatrix[i][j] -
allocationMatrix[i][j];
 }
 }
 // To keep track of completed processes
 boolean[] finished = new boolean[numProcesses];
 int count = 0;
 // Main loop to check for safe sequence
 while (count < numProcesses) {
 boolean found = false;
 for (int p = 0; p < numProcesses; p++) {
 if (!finished[p]) {
 // Check if the process can be allocated resources
 boolean canAllocate = true;
 for (int j = 0; j < numResources; j++) {
 if (needMatrix[p][j] > available[j]) {
 canAllocate = false;
 break;
 }
 }
 // If can allocate resources
 if (canAllocate) {
 System.out.println("All the resources can be allocated to Process " + p);
 System.out.print("Available resources are: ");
 for (int j = 0; j < numResources; j++) {
 System.out.print(available[j] + " ");
 }
 System.out.println();
 // Ask user if they want to execute the process
 System.out.print("Process " + p + " executed? (y/n): ");
 char execute = scanner.next().charAt(0);
 if (execute == 'y' || execute == 'Y') {
 // Simulate resource allocation
 for (int j = 0; j < numResources; j++) {
 available[j] += allocationMatrix[p][j];
 allocationMatrix[p][j] = 0; // Free up allocated resources
 needMatrix[p][j] = 0; // Process finished
 }
 finished[p] = true;
 count++;
 found = true;
 }
 }
 }
 }
 // If no process was allocated in this iteration, then 
 if (!found) {
 break;
 }
 }
 // Check if all processes finished
 if (count == numProcesses) {
 System.out.println("System is in safe mode");
 System.out.println("The given state is a safe state.");
 } else {
 System.out.println("System is not in a safe state.");
 }
 scanner.close();
 }
}