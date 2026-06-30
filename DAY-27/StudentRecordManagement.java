import java.util.ArrayList;
import java.util.Scanner;

public class StudentRecordManagement {

    static class Student {
        int id;
        String name;
        int age;
        double marks;

        Student(int id, String name, int age, double marks) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.marks = marks;
        }

        String getGrade() {
            if (marks >= 90) return "A+";
            else if (marks >= 80) return "A";
            else if (marks >= 70) return "B";
            else if (marks >= 60) return "C";
            else if (marks >= 50) return "D";
            else return "F";
        }

        void display() {
            System.out.printf("| %-4d | %-15s | %-3d | %-6.2f | %-5s |%n",
                    id, name, age, marks, getGrade());
        }
    }

    static ArrayList<Student> students = new ArrayList<>();
    static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Student Record Management System ===\n");

        while (running) {
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter Marks (0-100): ");
                    double marks = scanner.nextDouble();
                    scanner.nextLine();
                    students.add(new Student(nextId++, name, age, marks));
                    System.out.println("Student added successfully!\n");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No records found.\n");
                    } else {
                        System.out.println("+------+-----------------+-----+--------+-------+");
                        System.out.println("| ID   | Name            | Age | Marks  | Grade |");
                        System.out.println("+------+-----------------+-----+--------+-------+");
                        for (Student s : students) s.display();
                        System.out.println("+------+-----------------+-----+--------+-------+\n");
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();
                    Student found = findById(searchId);
                    if (found != null) {
                        System.out.println("+------+-----------------+-----+--------+-------+");
                        System.out.println("| ID   | Name            | Age | Marks  | Grade |");
                        System.out.println("+------+-----------------+-----+--------+-------+");
                        found.display();
                        System.out.println("+------+-----------------+-----+--------+-------+\n");
                    } else {
                        System.out.println("Student not found.\n");
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    Student toUpdate = findById(updateId);
                    if (toUpdate != null) {
                        System.out.print("New Name (" + toUpdate.name + "): ");
                        toUpdate.name = scanner.nextLine();
                        System.out.print("New Age (" + toUpdate.age + "): ");
                        toUpdate.age = scanner.nextInt();
                        System.out.print("New Marks (" + toUpdate.marks + "): ");
                        toUpdate.marks = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Student updated successfully!\n");
                    } else {
                        System.out.println("Student not found.\n");
                    }
                    break;

                case 5:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    Student toDelete = findById(deleteId);
                    if (toDelete != null) {
                        students.remove(toDelete);
                        System.out.println("Student deleted successfully!\n");
                    } else {
                        System.out.println("Student not found.\n");
                    }
                    break;

                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.\n");
            }
        }
        scanner.close();
    }

    static Student findById(int id) {
        for (Student s : students) {
            if (s.id == id) return s;
        }
        return null;
    }
} {
    
}
