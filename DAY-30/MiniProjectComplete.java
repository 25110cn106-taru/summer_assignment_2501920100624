import java.util.Scanner;

/**
 * Complete Mini Project: Student-Course Management System
 * Demonstrates: Arrays, Strings, and Functions (Methods)
 */
public class MiniProjectComplete {

    static final int MAX_STUDENTS = 50;
    static String[] studentNames = new String[MAX_STUDENTS];
    static int[] rollNumbers = new int[MAX_STUDENTS];
    static String[] courses = new String[MAX_STUDENTS];
    static double[] marks = new double[MAX_STUDENTS];
    static int studentCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=====================================================");
        System.out.println("   STUDENT-COURSE MANAGEMENT SYSTEM (Mini Project)   ");
        System.out.println("=====================================================\n");

        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addStudent(scanner); break;
                case 2: displayAllStudents(); break;
                case 3: searchByRoll(scanner); break;
                case 4: searchByName(scanner); break;
                case 5: updateMarks(scanner); break;
                case 6: deleteStudent(scanner); break;
                case 7: showStatistics(); break;
                case 8: showTopperPerCourse(); break;
                case 9: sortByMarks(); break;
                case 10:
                    System.out.println("Exiting program. Thank you!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.\n");
            }
        }
        scanner.close();
    }

    // ── Function: Display Menu ──
    static void showMenu() {
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Search by Roll Number");
        System.out.println("4. Search by Name");
        System.out.println("5. Update Marks");
        System.out.println("6. Delete Student");
        System.out.println("7. Show Statistics (Avg/Max/Min)");
        System.out.println("8. Show Topper per Course");
        System.out.println("9. Sort Students by Marks");
        System.out.println("10. Exit");
        System.out.print("Choose option: ");
    }

    // ── Function: Add Student ──
    static void addStudent(Scanner scanner) {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("Student list is full!\n");
            return;
        }
        System.out.print("Enter Roll Number: ");
        rollNumbers[studentCount] = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Student Name: ");
        studentNames[studentCount] = scanner.nextLine().trim();
        System.out.print("Enter Course Name: ");
        courses[studentCount] = scanner.nextLine().trim();
        System.out.print("Enter Marks (0-100): ");
        marks[studentCount] = scanner.nextDouble();
        scanner.nextLine();
        studentCount++;
        System.out.println("Student added successfully!\n");
    }

    // ── Function: Display All Students ──
    static void displayAllStudents() {
        if (studentCount == 0) {
            System.out.println("No student records found.\n");
            return;
        }
        printHeader();
        for (int i = 0; i < studentCount; i++) {
            printRow(i);
        }
        printFooter();
    }

    // ── Function: Search by Roll Number ──
    static void searchByRoll(Scanner scanner) {
        System.out.print("Enter Roll Number: ");
        int roll = scanner.nextInt();
        int index = findByRoll(roll);
        if (index == -1) {
            System.out.println("Student not found.\n");
        } else {
            printHeader();
            printRow(index);
            printFooter();
        }
    }

    // ── Function: Search by Name (uses String methods) ──
    static void searchByName(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter Name (or part of it): ");
        String search = scanner.nextLine().trim().toLowerCase();
        boolean found = false;
        printHeader();
        for (int i = 0; i < studentCount; i++) {
            if (studentNames[i].toLowerCase().contains(search)) {
                printRow(i);
                found = true;
            }
        }
        printFooter();
        if (!found) System.out.println("No matching students found.\n");
    }

    // ── Function: Update Marks ──
    static void updateMarks(Scanner scanner) {
        System.out.print("Enter Roll Number: ");
        int roll = scanner.nextInt();
        int index = findByRoll(roll);
        if (index == -1) {
            System.out.println("Student not found.\n");
        } else {
            System.out.print("Enter New Marks: ");
            marks[index] = scanner.nextDouble();
            System.out.println("Marks updated successfully!\n");
        }
    }

    // ── Function: Delete Student (shifts array elements) ──
    static void deleteStudent(Scanner scanner) {
        System.out.print("Enter Roll Number to delete: ");
        int roll = scanner.nextInt();
        int index = findByRoll(roll);
        if (index == -1) {
            System.out.println("Student not found.\n");
            return;
        }
        for (int i = index; i < studentCount - 1; i++) {
            studentNames[i] = studentNames[i + 1];
            rollNumbers[i] = rollNumbers[i + 1];
            courses[i] = courses[i + 1];
            marks[i] = marks[i + 1];
        }
        studentCount--;
        System.out.println("Student deleted successfully!\n");
    }

    // ── Function: Show Statistics ──
    static void showStatistics() {
        if (studentCount == 0) {
            System.out.println("No records available.\n");
            return;
        }
        double sum = 0, max = marks[0], min = marks[0];
        for (int i = 0; i < studentCount; i++) {
            sum += marks[i];
            if (marks[i] > max) max = marks[i];
            if (marks[i] < min) min = marks[i];
        }
        System.out.println("--- Statistics ---");
        System.out.printf("Average Marks : %.2f%n", sum / studentCount);
        System.out.printf("Highest Marks : %.2f%n", max);
        System.out.printf("Lowest Marks  : %.2f%n%n", min);
    }

    // ── Function: Show Topper for Each Unique Course ──
    static void showTopperPerCourse() {
        if (studentCount == 0) {
            System.out.println("No records available.\n");
            return;
        }
        String[] seenCourses = new String[studentCount];
        int seenCount = 0;

        System.out.println("--- Course Toppers ---");
        for (int i = 0; i < studentCount; i++) {
            String course = courses[i];
            boolean alreadySeen = false;
            for (int j = 0; j < seenCount; j++) {
                if (seenCourses[j].equalsIgnoreCase(course)) {
                    alreadySeen = true;
                    break;
                }
            }
            if (alreadySeen) continue;

            seenCourses[seenCount++] = course;

            int topperIndex = i;
            for (int k = i + 1; k < studentCount; k++) {
                if (courses[k].equalsIgnoreCase(course) && marks[k] > marks[topperIndex]) {
                    topperIndex = k;
                }
            }
            System.out.println(course + " -> " + studentNames[topperIndex]
                    + " (Roll: " + rollNumbers[topperIndex] + ", Marks: " + marks[topperIndex] + ")");
        }
        System.out.println();
    }

    // ── Function: Sort by Marks (Bubble Sort, Descending) ──
    static void sortByMarks() {
        if (studentCount == 0) {
            System.out.println("No records to sort.\n");
            return;
        }
        for (int i = 0; i < studentCount - 1; i++) {
            for (int j = 0; j < studentCount - 1 - i; j++) {
                if (marks[j] < marks[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
        System.out.println("Students sorted by marks (Descending):");
        printHeader();
        for (int i = 0; i < studentCount; i++) printRow(i);
        printFooter();
    }

    // ── Function: Swap helper for sorting ──
    static void swap(int i, int j) {
        double tempMarks = marks[i]; marks[i] = marks[j]; marks[j] = tempMarks;
        int tempRoll = rollNumbers[i]; rollNumbers[i] = rollNumbers[j]; rollNumbers[j] = tempRoll;
        String tempName = studentNames[i]; studentNames[i] = studentNames[j]; studentNames[j] = tempName;
        String tempCourse = courses[i]; courses[i] = courses[j]; courses[j] = tempCourse;
    }

    // ── Function: Find Index by Roll Number ──
    static int findByRoll(int roll) {
        for (int i = 0; i < studentCount; i++) {
            if (rollNumbers[i] == roll) return i;
        }
        return -1;
    }

    // ── Function: Print Table Header ──
    static void printHeader() {
        System.out.println("+------+--------------------+--------------------+----------+");
        System.out.println("| Roll | Name               | Course             | Marks    |");
        System.out.println("+------+--------------------+--------------------+----------+");
    }

    // ── Function: Print One Row ──
    static void printRow(int i) {
        System.out.printf("| %-4d | %-18s | %-18s | %-8.2f |%n",
                rollNumbers[i], studentNames[i], courses[i], marks[i]);
    }

    // ── Function: Print Table Footer ──
    static void printFooter() {
        System.out.println("+------+--------------------+--------------------+----------+\n");
    }
}