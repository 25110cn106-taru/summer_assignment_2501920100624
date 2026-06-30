import java.util.Scanner;

public class MiniEmployeeManagement {

    static final int MAX_EMPLOYEES = 50;
    static String[] names = new String[MAX_EMPLOYEES];
    static String[] departments = new String[MAX_EMPLOYEES];
    static double[] salaries = new double[MAX_EMPLOYEES];
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Mini Employee Management System ===\n");

        while (running) {
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by Name");
            System.out.println("4. Update Salary");
            System.out.println("5. Calculate Total & Average Salary");
            System.out.println("6. Find Highest Paid Employee");
            System.out.println("7. Display Employees by Department");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (count >= MAX_EMPLOYEES) {
                        System.out.println("Employee list is full!\n");
                        break;
                    }
                    System.out.print("Enter Employee Name: ");
                    names[count] = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    departments[count] = scanner.nextLine();
                    System.out.print("Enter Salary: Rs. ");
                    salaries[count] = scanner.nextDouble();
                    scanner.nextLine();
                    count++;
                    System.out.println("Employee added successfully!\n");
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No employees found.\n");
                    } else {
                        printHeader();
                        for (int i = 0; i < count; i++) printRow(i);
                        printFooter();
                    }
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine().toLowerCase();
                    boolean found = false;
                    printHeader();
                    for (int i = 0; i < count; i++) {
                        if (names[i].toLowerCase().contains(searchName)) {
                            printRow(i);
                            found = true;
                        }
                    }
                    printFooter();
                    if (!found) System.out.println("Employee not found.\n");
                    break;

                case 4:
                    System.out.print("Enter Employee Name: ");
                    String updateName = scanner.nextLine();
                    int updateIndex = findByName(updateName);
                    if (updateIndex == -1) {
                        System.out.println("Employee not found.\n");
                    } else {
                        System.out.print("Enter New Salary: Rs. ");
                        salaries[updateIndex] = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Salary updated successfully!\n");
                    }
                    break;

                case 5:
                    if (count == 0) {
                        System.out.println("No employees found.\n");
                    } else {
                        double total = 0;
                        for (int i = 0; i < count; i++) total += salaries[i];
                        System.out.printf("Total Salary: Rs. %.2f%n", total);
                        System.out.printf("Average Salary: Rs. %.2f%n%n", total / count);
                    }
                    break;

                case 6:
                    if (count == 0) {
                        System.out.println("No employees found.\n");
                    } else {
                        int topIndex = 0;
                        for (int i = 1; i < count; i++) {
                            if (salaries[i] > salaries[topIndex]) topIndex = i;
                        }
                        System.out.println("Highest Paid Employee: " + names[topIndex]
                                + " (" + departments[topIndex] + ") - Rs. " + salaries[topIndex] + "\n");
                    }
                    break;

                case 7:
                    System.out.print("Enter Department: ");
                    String dept = scanner.nextLine().toLowerCase();
                    boolean foundDept = false;
                    printHeader();
                    for (int i = 0; i < count; i++) {
                        if (departments[i].toLowerCase().equals(dept)) {
                            printRow(i);
                            foundDept = true;
                        }
                    }
                    printFooter();
                    if (!foundDept) System.out.println("No employees found in this department.\n");
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

    static int findByName(String name) {
        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(name)) return i;
        }
        return -1;
    }

    static void printHeader() {
        System.out.println("+--------------------+--------------------+------------+");
        System.out.println("| Name               | Department         | Salary     |");
        System.out.println("+--------------------+--------------------+------------+");
    }

    static void printRow(int i) {
        System.out.printf("| %-18s | %-18s | %-10.2f |%n", names[i], departments[i], salaries[i]);
    }

    static void printFooter() {
        System.out.println("+--------------------+--------------------+------------+\n");
    }
}
