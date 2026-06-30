import java.util.Scanner;

public class StudentRecordArraysStrings {

    static final int MAX_STUDENTS = 50;
    static String[] names = new String[MAX_STUDENTS];
    static int[] roll = new int[MAX_STUDENTS];
    static double[] marks = new double[MAX_STUDENTS];
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Student Record System (Arrays & Strings) ===\n");

        while (running) {
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Roll Number");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Calculate Class Average");
            System.out.println("6. Find Topper");
            System.out.println("7. Sort Students by Marks");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (count >= MAX_STUDENTS) {
                        System.out.println("Student list is full!\n");
                        break;
                    }
                    System.out.print("Enter Roll Number: ");
                    roll[count] = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    names[count] = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    marks[count] = scanner.nextDouble();
                    count++;
                    System.out.println("Student added successfully!\n");
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No records found.\n");
                    } else {
                        printHeader();
                        for (int i = 0; i < count; i++) {
                            printRow(i);
                        }
                        printFooter();
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll Number to search: ");
                    int searchRoll = scanner.nextInt();
                    boolean foundR = false;
                    for (int i = 0; i < count; i++) {
                        if (roll[i] == searchRoll) {
                            printHeader();
                            printRow(i);
                            printFooter();
                            foundR = true;
                            break;
                        }
                    }
                    if (!foundR) System.out.println("Student not found.\n");
                    break;

                case 4:
                    System.out.print("Enter Name to search: ");
                    String searchName = scanner.nextLine().toLowerCase();
                    boolean foundN = false;
                    printHeader();
                    for (int i = 0; i < count; i++) {
                        if (names[i].toLowerCase().contains(searchName)) {
                            printRow(i);
                            foundN = true;
                        }
                    }
                    printFooter();
                    if (!foundN) System.out.println("Student not found.\n");
                    break;

                case 5:
                    if (count == 0) {
                        System.out.println("No records to calculate average.\n");
                    } else {
                        double sum = 0;
                        for (int i = 0; i < count; i++) sum += marks[i];
                        System.out.printf("Class Average: %.2f%n%n", sum / count);
                    }
                    break;

                case 6:
                    if (count == 0) {
                        System.out.println("No records found.\n");
                    } else {
                        int topIndex = 0;
                        for (int i = 1; i < count; i++) {
                            if (marks[i] > marks[topIndex]) topIndex = i;
                        }
                        System.out.println("Topper: " + names[topIndex] + " (Roll No: " + roll[topIndex]
                                + ") with " + marks[topIndex] + " marks\n");
                    }
                    break;

                case 7:
                    if (count == 0) {
                        System.out.println("No records to sort.\n");
                    } else {
                        // Simple bubble sort (descending by marks)
                        for (int i = 0; i < count - 1; i++) {
                            for (int j = 0; j < count - 1 - i; j++) {
                                if (marks[j] < marks[j + 1]) {
                                    double tempM = marks[j]; marks[j] = marks[j + 1]; marks[j + 1] = tempM;
                                    int tempR = roll[j]; roll[j] = roll[j + 1]; roll[j + 1] = tempR;
                                    String tempN = names[j]; names[j] = names[j + 1]; names[j + 1] = tempN;
                                }
                            }
                        }
                        System.out.println("Sorted by marks (Descending):");
                        printHeader();
                        for (int i = 0; i < count; i++) printRow(i);
                        printFooter();
                    }
                    break;

                case 8:
                    System.out.println("Exiting. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.\n");
            }
        }
        scanner.close();
    }

    static void printHeader() {
        System.out.println("+------+--------------------+----------+");
        System.out.println("| Roll | Name               | Marks    |");
        System.out.println("+------+--------------------+----------+");
    }

    static void printRow(int i) {
        System.out.printf("| %-4d | %-18s | %-8.2f |%n", roll[i], names[i], marks[i]);
    }

    static void printFooter() {
        System.out.println("+------+--------------------+----------+\n");
    }
} 
