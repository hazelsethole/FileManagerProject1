package file_manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileManagerApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> fileList = new ArrayList<>();

        while (true) {
            displayWelcomeScreen();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    listFilesInAscendingOrder(fileList);
                    break;
                case 2:
                    handleFileOperations(fileList, scanner);
                    break;
                case 3:
                    System.out.println("Closing the application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayWelcomeScreen() {
        System.out.println("EazySort File Manager");
        System.out.println("Developer: Hazel Sethole");
        System.out.println("Options:");
        System.out.println("1. List files in ascending order");
        System.out.println("2. File operations");
        System.out.println("3. Close the application");
    }

    private static int getUserChoice(Scanner scanner) {
        while (true) {
            System.out.print("Enter your choice: ");
            try {
                return scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); 
            }
        }
    } 

    private static void listFilesInAscendingOrder(List<String> fileList) {
        if (fileList.isEmpty()) {
            System.out.println("The root directory is empty.");
        } else {
            Collections.sort(fileList);
            System.out.println("File names in ascending order:");
            for (String fileName : fileList) {
                System.out.println(fileName);
            }
        }
    }

    private static void handleFileOperations(ArrayList<String> fileList, Scanner scanner) {
        while (true) {
            System.out.println("File Operations:");
            System.out.println("1. Add a file");
            System.out.println("2. Delete a file");
            System.out.println("3. Search for a file");
            System.out.println("4. Back to main menu");

            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    addFile(fileList, scanner);
                    break;
                case 2:
                    deleteFile((ArrayList<String>) fileList, scanner);
                    break;
                case 3:
                    searchFile(fileList, scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addFile(ArrayList<String> fileList, Scanner scanner) {
        scanner.nextLine(); 
        System.out.print("Enter the file name to add: ");
        String fileName = scanner.nextLine();
        fileList.add(fileName);
        System.out.println("File added successfully.");
    }

    private static void deleteFile(ArrayList<String> fileList, Scanner scanner) {
    	scanner.nextLine();
        System.out.print("Enter the file name to delete: ");
        String fileNameToDelete = scanner.nextLine();
        boolean removed = fileList.removeIf(fileName ->
                fileName.equalsIgnoreCase(fileNameToDelete)
        );
        if (removed) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("File not found.");
        }
    }

    private static void searchFile(ArrayList<String> fileList, Scanner scanner) {
    	scanner.nextLine();
        System.out.print("Enter the file name to search: ");
        String fileNameToSearch = scanner.nextLine();
        boolean found = false;
        for (String fileName : fileList) {
            if (fileName.equals(fileNameToSearch)) {
                System.out.println("File found: " + fileName);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("File not found.");
        }
    }
}
