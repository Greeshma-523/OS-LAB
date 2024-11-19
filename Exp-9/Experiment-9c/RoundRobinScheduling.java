package OS;
import java.util.Scanner;
public class RoundRobinScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();
        int[] burstTime = new int[n];
        int[] remainingBurstTime = new int[n];
        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Burst Time for process " + (i + 1) + ": ");
            burstTime[i] = sc.nextInt();
            remainingBurstTime[i] = burstTime[i];
        }
        System.out.print("Enter the size of time slice: ");
        int timeSlice = sc.nextInt();
        int time = 0;
        boolean done;
        do {
            done = true;
            for (int i = 0; i < n; i++) {
                if (remainingBurstTime[i] > 0) {
                    done = false;
                    if (remainingBurstTime[i] > timeSlice) {
                        time += timeSlice;
                        remainingBurstTime[i] -= timeSlice;
                    } else {
                        time += remainingBurstTime[i];
                        waitingTime[i] = time - burstTime[i];
                        remainingBurstTime[i] = 0;
                    }
                }
            }
        } while (!done);
        for (int i = 0; i < n; i++) {
            turnaroundTime[i] = burstTime[i] + waitingTime[i];
        }
        double totalWaitingTime = 0;
        double totalTurnaroundTime = 0;
        for (int i = 0; i < n; i++) {
            totalWaitingTime += waitingTime[i];
            totalTurnaroundTime += turnaroundTime[i];
        }
        double averageWaitingTime = totalWaitingTime / n;
        double averageTurnaroundTime = totalTurnaroundTime / n;
        System.out.println("\nPROCESS\tBURST TIME\tWAITING TIME\tTURNAROUND TIME");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t\t" + burstTime[i] + "\t\t" + waitingTime[i] + "\t\t" + turnaroundTime[i]);
        }
        System.out.printf("\nThe Average Turnaround time is: %.6f", averageTurnaroundTime);
        System.out.printf("\nThe Average Waiting time is: %.6f", averageWaitingTime);
    }
}
