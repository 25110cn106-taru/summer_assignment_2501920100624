import java.util.Scanner;

public class MarksheetGeneration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Marksheet Generation System ===");
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Roll Number: ");
        String roll = scanner.nextLine();
        System.out.print("Enter Class: ");
        String studentClass = scanner.nextLine();
        System.out.print("Enter Number of Subjects: ");
        int n = scanner.nextInt();

        String[] subjects = new String[n];
        int[] marks = new int[n];
        int total = 0;

        for (int i = 0; i < n; i++) {
            scanner.nextLine();
            System.out.print("Enter Subject " + (i + 1) + " Name: ");
            subjects[i] = scanner.nextLine();
            System.out.print("Enter Marks (out of 100): ");
            marks[i] = scanner.nextInt();
            total += marks[i];
        }

        double percentage = (double) total / n;
        String grade;
        if (percentage >= 90) grade = "A+";
        else if (percentage >= 80) grade = "A";
        else if (percentage >= 70) grade = "B";
        else if (percentage >= 60) grade = "C";
        else if (percentage >= 50) grade = "D";
        else grade = "F";

        String result = percentage >= 33 ? "PASS" : "FAIL";

        System.out.println("\n==========================================");
        System.out.println("              MARKSHEET                  ");
        System.out.println("==========================================");
        System.out.println("Name        : " + name);
        System.out.println("Roll No.    : " + roll);
        System.out.println("Class       : " + studentClass);
        System.out.println("------------------------------------------");
        System.out.printf("%-20s %10s%n", "Subject", "Marks");
        System.out.println("------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-20s %10d%n", subjects[i], marks[i]);
        }
        System.out.println("------------------------------------------");
        System.out.println("Total Marks  : " + total + " / " + (n * 100));
        System.out.printf("Percentage   : %.2f%%\n", percentage);
        System.out.println("Grade        : " + grade);
        System.out.println("Result       : " + result);
        System.out.println("==========================================");

        scanner.close();
    }
}