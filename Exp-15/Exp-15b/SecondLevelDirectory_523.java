package OS;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class SecondLevelDirectory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // HashMap to store directories and their corresponding files
        HashMap<String, ArrayList<String>> directories = new HashMap<>();

        while (true) {
            // Display menu
            System.out.println("\n1. Create Directory");
            System.out.println("2. Create File");
            System.out.println("3. Delete File");
            System.out.println("4. Search File");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Create Directory
                    System.out.print("Enter name of directory: ");
                    String newDirectory = scanner.nextLine();
                    if (directories.containsKey(newDirectory)) {
                        System.out.println("Directory already exists.");
                    } else {
                        directories.put(newDirectory, new ArrayList<>());
                        System.out.println("Directory created.");
                    }
                    break;

                case 2: // Create File
                    System.out.print("Enter name of the directory: ");
                    String dirToCreateFile = scanner.nextLine();
                    if (directories.containsKey(dirToCreateFile)) {
                        System.out.print("Enter name of the file: ");
                        String newFile = scanner.nextLine();
                        ArrayList<String> files = directories.get(dirToCreateFile);
                        if (files.contains(newFile)) {
                            System.out.println("File already exists.");
                        } else {
                            files.add(newFile);
                            System.out.println("File created.");
                        }
                    } else {
                        System.out.println("Directory not found.");
                    }
                    break;

                case 3: // Delete File
                    System.out.print("Enter name of the directory: ");
                    String dirToDeleteFile = scanner.nextLine();
                    if (directories.containsKey(dirToDeleteFile)) {
                        System.out.print("Enter name of the file: ");
                        String deleteFile = scanner.nextLine();
                        ArrayList<String> files = directories.get(dirToDeleteFile);
                        if (files.remove(deleteFile)) {
                            System.out.println("File deleted.");
                        } else {
                            System.out.println("File not found.");
                        }
                    } else {
                        System.out.println("Directory not found.");
                    }
                    break;

                case 4: // Search File
                    System.out.print("Enter name of the directory: ");
                    String dirToSearchFile = scanner.nextLine();
                    if (directories.containsKey(dirToSearchFile)) {
                        System.out.print("Enter name of the file: ");
                        String searchFile = scanner.nextLine();
                        ArrayList<String> files = directories.get(dirToSearchFile);
                        if (files.contains(searchFile)) {
                            System.out.println("File found.");
                        } else {
                            System.out.println("File not found.");
                        }
                    } else {
                        System.out.println("Directory not found.");
                    }
                    break;

                case 5: // Display
                    System.out.println("Directories and their files:");
                    for (String directory : directories.keySet()) {
                        System.out.println("Directory: " + directory);
                        ArrayList<String> files = directories.get(directory);
                        if (files.isEmpty()) {
                            System.out.println("  No files.");
                        } else {
                            System.out.println("  Files: " + String.join(", ", files));
                        }
                    }
                    break;

                case 6: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
