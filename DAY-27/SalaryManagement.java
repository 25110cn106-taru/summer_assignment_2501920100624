import java.util.ArrayList;
import java.util.Scanner;

public class SalaryManagement {

    static class Employee {
        int id;
        String name;
        double basicSalary;
        double hra;        // House Rent Allowance (20% of basic)
        double da;         // Dearness Allowance (10% of basic)
        double ta;         // Travel Allowance (5% of basic)
        double pf;         // Provident Fund deduction (12% of basic)
        double tax;        // Tax deduction (5% of gross)
        double grossSalary;
        double netSalary;

        Employee(int id, String name, double basicSalary) {
            this.id = id;
            this.name = name;
            this.basicSalary = basicSalary;
            calculateSalary();
        }

        void calculateSalary() {
            hra = basicSalary * 0.20;
            da  = basicSalary * 0.10;
            ta  = basicSalary * 0.05;
            grossSalary = basicSalary + hra + da + ta;
            pf  = basicSalary * 0.12;
            tax = grossSalary * 0.05;
            netSalary = grossSalary - pf - tax;
        }

        void displayPayslip() {
            System.out.println("============================================");
            System.out.println("             SALARY PAYSLIP                 ");
            System.out.println("============================================");
            System.out.printf("Employee ID   : %d%n", id);
            System.out.printf("Employee Name : %s%n", name);
            System.out.println("--------------------------------------------");
            System.out.println("EARNINGS:");
            System.out.printf("  Basic Salary          : Rs. %10.2f%n", basicSalary);
            System.out.printf("  HRA (20%%)             : Rs. %10.2f%n", hra);
            System.out.printf("  DA  (10%%)             : Rs. %10.2f%n", da);
            System.out.printf("  TA   (5%%)             : Rs. %10.2f%n", ta);
            System.out.printf("  Gross Salary          : Rs. %10.2f%n", grossSalary);
            System.out.println("--------------------------------------------");
            System.out.println("DEDUCTIONS:");
            System.out.printf("  PF  (12%% of Basic)    : Rs. %10.2f%n", pf);
            System.out.printf("  Tax  (5%% of Gross)    : Rs. %10.2f%n", tax);
            System.out.println("--------------------------------------------");
            System.out.printf("  NET SALARY            : Rs. %10.2f%n", netSalary);
            System.out.println("============================================\n");
        }
    }

    static ArrayList<Employee> employees = new ArrayList<>();
    static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Salary Management System ===\n");

        while (running) {
            System.out.println("1. Add Employee");
            System.out.println("2. Generate Payslip by ID");
            System.out.println("3. View All Employees Summary");
            System.out.println("4. Update Basic Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Basic Salary: Rs. ");
                    double basic = scanner.nextDouble();
                    scanner.nextLine();
                    employees.add(new Employee(nextId++, name, basic));
                    System.out.println("Employee added successfully!\n");
                    break;

                case 2:
                    System.out.print("Enter Employee ID: ");
                    int pid = scanner.nextInt();
                    scanner.nextLine();
                    Employee emp = findById(pid);
                    if (emp != null) emp.displayPayslip();
                    else System.out.println("Employee not found.\n");
                    break;

                case 3:
                    if (employees.isEmpty()) {
                        System.out.println("No employees found.\n");
                    } else {
                        System.out.println("+------+-----------------+------------+------------+------------+");
                        System.out.println("| ID   | Name            | Basic (Rs) | Gross (Rs) | Net   (Rs) |");
                        System.out.println("+------+-----------------+------------+------------+------------+");
                        for (Employee e : employees) {
                            System.out.printf("| %-4d | %-15s | %10.2f | %10.2f | %10.2f |%n",
                                    e.id, e.name, e.basicSalary, e.grossSalary, e.netSalary);
                        }
                        System.out.println("+------+-----------------+------------+------------+------------+\n");
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID: ");
                    int uid = scanner.nextInt();
                    scanner.nextLine();
                    Employee toUpdate = findById(uid);
                    if (toUpdate != null) {
                        System.out.printf("Current Basic Salary: Rs. %.2f%n", toUpdate.basicSalary);
                        System.out.print("Enter New Basic Salary: Rs. ");
                        toUpdate.basicSalary = scanner.nextDouble();
                        scanner.nextLine();
                        toUpdate.calculateSalary();
                        System.out.println("Salary updated successfully!\n");
                    } else {
                        System.out.println("Employee not found.\n");
                    }
                    break;

                case 5:
                    System.out.print("Enter Employee ID to delete: ");
                    int did = scanner.nextInt();
                    scanner.nextLine();
                    Employee toDelete = findById(did);
                    if (toDelete != null) {
                        employees.remove(toDelete);
                        System.out.println("Employee removed.\n");
                    } else {
                        System.out.println("Employee not found.\n");
                    }
                    break;

                case 6:
                    System.out.println("Exiting Salary Management System.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.\n");
            }
        }
        scanner.close();
    }

    static Employee findById(int id) {
        for (Employee e : employees) {
            if (e.id == id) return e;
        }
        return null;
    }
}