package OS;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class SJF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of processes -- ");
        int numProcesses = sc.nextInt();
        int[][] processes = new int[numProcesses][2];
        int[] waitingTime = new int[numProcesses];
        int[] turnaroundTime = new int[numProcesses];
        for (int i = 0; i < numProcesses; i++) {
            System.out.print("Enter Burst Time for Process " + i + " -- ");
            processes[i][0] = i;
            processes[i][1] = sc.nextInt();
        }
        Arrays.sort(processes, Comparator.comparingInt(a -> a[1]));
        waitingTime[0] = 0;
        for (int i = 1; i < numProcesses; i++) {
            waitingTime[i] = waitingTime[i - 1] + processes[i - 1][1];
        }
        for (int i = 0; i < numProcesses; i++) {
            turnaroundTime[i] = waitingTime[i] + processes[i][1];
        }
        System.out.println("PROCESS\tBURST TIME\tWAITING TIME\tTURNAROUND TIME");
        for (int i = 0; i < numProcesses; i++) {
            System.out.println("P" + processes[i][0] + "\t\t" + processes[i][1] + "\t\t" + waitingTime[i] + "\t\t" + turnaroundTime[i]);
        }
        double totalWaitingTime = 0, totalTurnaroundTime = 0;
        for (int i = 0; i < numProcesses; i++) {
            totalWaitingTime += waitingTime[i];
            totalTurnaroundTime += turnaroundTime[i];
        }

        double averageWaitingTime = totalWaitingTime / numProcesses;
        double averageTurnaroundTime = totalTurnaroundTime / numProcesses;

        System.out.printf("Average Waiting Time -- %.6f\n", averageWaitingTime);
        System.out.printf("Average Turnaround Time -- %.6f\n", averageTurnaroundTime);

        sc.close();
    }
}