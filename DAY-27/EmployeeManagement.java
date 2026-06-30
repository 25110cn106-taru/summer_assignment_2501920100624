import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagement {

    static class Employee {
        int id;
        String name;
        String department;
        String designation;
        double salary;

        Employee(int id, String name, String department, String designation, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.designation = designation;
            this.salary = salary;
        }

        void display() {
            System.out.printf("| %-4d | %-15s | %-12s | %-15s | %-10.2f |%n",
                    id, name, department, designation, salary);
        }
    }

    static ArrayList<Employee> employees = new ArrayList<>();
    static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Employee Management System ===\n");

        while (running) {
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = scanner.nextLine();
                    System.out.print("Enter Designation: ");
                    String desig = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();
                    employees.add(new Employee(nextId++, name, dept, desig, salary));
                    System.out.println("Employee added successfully!\n");
                    break;

                case 2:
                    if (employees.isEmpty()) {
                        System.out.println("No employees found.\n");
                    } else {
                        printHeader();
                        for (Employee e : employees) e.display();
                        printFooter();
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();
                    Employee found = findById(searchId);
                    if (found != null) {
                        printHeader();
                        found.display();
                        printFooter();
                    } else {
                        System.out.println("Employee not found.\n");
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    Employee toUpdate = findById(updateId);
                    if (toUpdate != null) {
                        System.out.print("New Name (" + toUpdate.name + "): ");
                        toUpdate.name = scanner.nextLine();
                        System.out.print("New Department (" + toUpdate.department + "): ");
                        toUpdate.department = scanner.nextLine();
                        System.out.print("New Designation (" + toUpdate.designation + "): ");
                        toUpdate.designation = scanner.nextLine();
                        System.out.print("New Salary (" + toUpdate.salary + "): ");
                        toUpdate.salary = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Employee updated successfully!\n");
                    } else {
                        System.out.println("Employee not found.\n");
                    }
                    break;

                case 5:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    Employee toDelete = findById(deleteId);
                    if (toDelete != null) {
                        employees.remove(toDelete);
                        System.out.println("Employee deleted successfully!\n");
                    } else {
                        System.out.println("Employee not found.\n");
                    }
                    break;

                case 6:
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
        System.out.println("+------+-----------------+--------------+-----------------+------------+");
        System.out.println("| ID   | Name            | Department   | Designation     | Salary     |");
        System.out.println("+------+-----------------+--------------+-----------------+------------+");
    }

    static void printFooter() {
        System.out.println("+------+-----------------+--------------+-----------------+------------+\n");
    }

    static Employee findById(int id) {
        for (Employee e : employees) {
            if (e.id == id) return e;
        }
        return null;
    }
}
