import java.util.Scanner;

public class ATMSimulation {
    private static double balance = 10000.00; // Initial balance
    private static final int PIN = 2406; // Predefined PIN for simulation

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to the ATM ===");
        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (enteredPin != PIN) {
            System.out.println("Incorrect PIN. Access denied.");
            scanner.close();
            return;
        }

        System.out.println("PIN verified. Access granted.\n");

        boolean running = true;
        while (running) {
            System.out.println("--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Current Balance: Rs. %.2f%n%n", balance);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: Rs. ");
                    double deposit = scanner.nextDouble();
                    if (deposit <= 0) {
                        System.out.println("Invalid amount. Please enter a positive value.\n");
                    } else {
                        balance += deposit;
                        System.out.printf("Rs. %.2f deposited successfully. New Balance: Rs. %.2f%n%n", deposit, balance);
                    }
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: Rs. ");
                    double withdraw = scanner.nextDouble();
                    if (withdraw <= 0) {
                        System.out.println("Invalid amount.\n");
                    } else if (withdraw > balance) {
                        System.out.println("Insufficient funds.\n");
                    } else {
                        balance -= withdraw;
                        System.out.printf("Rs. %.2f withdrawn successfully. Remaining Balance: Rs. %.2f%n%n", withdraw, balance);
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.\n");
            }
        }
        scanner.close();
    }
}