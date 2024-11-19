package OS;
import java.util.ArrayList;
import java.util.Scanner;

public class SingleLevelDirectory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Enter the directory name
        System.out.print("Enter name of directory: ");
        String directoryName = scanner.nextLine();
        
        ArrayList<String> files = new ArrayList<>();
        
        while (true) {
            // Display menu
            System.out.println("\n1. Create File");
            System.out.println("2. Delete File");
            System.out.println("3. Search File");
            System.out.println("4. Display Files");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1: // Create File
                    System.out.print("Enter the name of the file: ");
                    String newFile = scanner.nextLine();
                    if (files.contains(newFile)) {
                        System.out.println("File " + newFile + " already exists.");
                    } else {
                        files.add(newFile);
                        System.out.println("File " + newFile + " created.");
                    }
                    break;
                
                case 2: // Delete File
                    System.out.print("Enter the name of the file: ");
                    String deleteFile = scanner.nextLine();
                    if (files.contains(deleteFile)) {
                        files.remove(deleteFile);
                        System.out.println("File " + deleteFile + " is deleted.");
                    } else {
                        System.out.println("File " + deleteFile + " not found.");
                    }
                    break;
                
                case 3: // Search File
                    System.out.print("Enter the name of the file: ");
                    String searchFile = scanner.nextLine();
                    if (files.contains(searchFile)) {
                        System.out.println("File " + searchFile + " found.");
                    } else {
                        System.out.println("File " + searchFile + " not found.");
                    }
                    break;
                
                case 4: // Display Files
                    System.out.println("The files are: " + String.join(" ", files));
                    break;
                
                case 5: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
