package OS;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Process {
    int id, burstTime, priority, waitingTime, turnaroundTime;

    public Process(int id, int burstTime, int priority) {
        this.id = id;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}
public class PriorityScheduling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();
        Process[] processes = new Process[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the Burst Time & Priority of Process " + i + ": ");
            int burstTime = sc.nextInt();
            int priority = sc.nextInt();
            processes[i] = new Process(i, burstTime, priority);
        }
        Arrays.sort(processes, Comparator.comparingInt(p -> p.priority));
        int currentTime = 0;
        double totalWaitingTime = 0;
        double totalTurnaroundTime = 0;
        for (int i = 0; i < n; i++) {
            Process p = processes[i];
            p.waitingTime = currentTime;
            p.turnaroundTime = p.waitingTime + p.burstTime;
            totalWaitingTime += p.waitingTime;
            totalTurnaroundTime += p.turnaroundTime;
            currentTime += p.burstTime;
        }
        double averageWaitingTime = totalWaitingTime / n;
        double averageTurnaroundTime = totalTurnaroundTime / n;
        System.out.println("\nPROCESS\tPRIORITY\tBURST TIME\tWAITING TIME\tTURNAROUND TIME");
        for (Process p : processes) {
            System.out.println(p.id + "\t\t" + p.priority + "\t\t" + p.burstTime + "\t\t" + p.waitingTime + "\t\t" + p.turnaroundTime);
        }
        System.out.printf("\nAverage Waiting Time is: %.6f", averageWaitingTime);
        System.out.printf("\nAverage Turnaround Time is: %.6f", averageTurnaroundTime);
    }
}

