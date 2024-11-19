package OS;
import java.util.Scanner;
public class FCFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of processes -- ");
        int numProcesses = sc.nextInt();
        int[] burstTime = new int[numProcesses];
        int[] waitingTime = new int[numProcesses];
        int[] turnaroundTime = new int[numProcesses];
        for (int i = 0; i < numProcesses; i++) {
            System.out.print("Enter Burst Time for Process " + i + " -- ");
            burstTime[i] = sc.nextInt();
        }
        waitingTime[0] = 0;
        for (int i = 1; i < numProcesses; i++) {
            waitingTime[i] = waitingTime[i - 1] + burstTime[i - 1];
        }
              for (int i = 0; i < numProcesses; i++) {
            turnaroundTime[i] = waitingTime[i] + burstTime[i];
        }
        System.out.println("PROCESS\tBURST TIME\tWAITING TIME\tTURNAROUND TIME");
        for (int i = 0; i < numProcesses; i++) {
            System.out.println("P" + i + "\t\t" + burstTime[i] + "\t\t" + waitingTime[i] + "\t\t" + turnaroundTime[i]);
        }
        double totalWaitingTime = 0, totalTurnaroundTime = 0;
        for (int i = 0; i < numProcesses; i++) {
            totalWaitingTime += waitingTime[i];
            totalTurnaroundTime += turnaroundTime[i];
        }

        double averageWaitingTime = totalWaitingTime / numProcesses;
        double averageTurnaroundTime = totalTurnaroundTime / numProcesses;

        System.out.printf("Average Waiting Time-- %.6f\n", averageWaitingTime);
        System.out.printf("Average Turnaround Time -- %.6f\n", averageTurnaroundTime);

        sc.close();
    }
}

