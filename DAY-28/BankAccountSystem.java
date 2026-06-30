import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountSystem {

    static class Account {
        int accountNumber;
        String holderName;
        double balance;
        ArrayList<String> transactionHistory = new ArrayList<>();

        Account(int accountNumber, String holderName, double balance) {
            this.accountNumber = accountNumber;
            this.holderName = holderName;
            this.balance = balance;
            transactionHistory.add("Account opened with balance: Rs. " + balance);
        }

        void deposit(double amount) {
            balance += amount;
            transactionHistory.add("Deposited: Rs. " + amount + " | Balance: Rs. " + balance);
        }

        boolean withdraw(double amount) {
            if (amount > balance) return false;
            balance -= amount;
            transactionHistory.add("Withdrew: Rs. " + amount + " | Balance: Rs. " + balance);
            return true;
        }

        void display() {
            System.out.printf("| %-6d | %-18s | %-12.2f |%n", accountNumber, holderName, balance);
        }
    }

    static ArrayList<Account> accounts = new ArrayList<>();
    static int nextAccNo = 1001;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Bank Account Management System ===\n");

        while (running) {
            System.out.println("1. Open New Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. View Transaction History");
            System.out.println("6. View All Accounts");
            System.out.println("7. Close Account");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Holder Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Initial Deposit Amount: Rs. ");
                    double initial = scanner.nextDouble();
                    if (initial < 0) {
                        System.out.println("Initial deposit cannot be negative.\n");
                    } else {
                        Account acc = new Account(nextAccNo++, name, initial);
                        accounts.add(acc);
                        System.out.println("Account opened successfully! Account No: " + acc.accountNumber + "\n");
                    }
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    int depAccNo = scanner.nextInt();
                    Account depAcc = findAccount(depAccNo);
                    if (depAcc != null) {
                        System.out.print("Enter Deposit Amount: Rs. ");
                        double depAmt = scanner.nextDouble();
                        if (depAmt <= 0) {
                            System.out.println("Invalid amount.\n");
                        } else {
                            depAcc.deposit(depAmt);
                            System.out.printf("Deposited successfully! New Balance: Rs. %.2f%n%n", depAcc.balance);
                        }
                    } else {
                        System.out.println("Account not found.\n");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int wAccNo = scanner.nextInt();
                    Account wAcc = findAccount(wAccNo);
                    if (wAcc != null) {
                        System.out.print("Enter Withdrawal Amount: Rs. ");
                        double wAmt = scanner.nextDouble();
                        if (wAmt <= 0) {
                            System.out.println("Invalid amount.\n");
                        } else if (wAcc.withdraw(wAmt)) {
                            System.out.printf("Withdrawal successful! Remaining Balance: Rs. %.2f%n%n", wAcc.balance);
                        } else {
                            System.out.println("Insufficient balance.\n");
                        }
                    } else {
                        System.out.println("Account not found.\n");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    int balAccNo = scanner.nextInt();
                    Account balAcc = findAccount(balAccNo);
                    if (balAcc != null) {
                        System.out.printf("Account Holder: %s | Balance: Rs. %.2f%n%n", balAcc.holderName, balAcc.balance);
                    } else {
                        System.out.println("Account not found.\n");
                    }
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    int histAccNo = scanner.nextInt();
                    Account histAcc = findAccount(histAccNo);
                    if (histAcc != null) {
                        System.out.println("\n--- Transaction History ---");
                        for (String t : histAcc.transactionHistory) {
                            System.out.println(t);
                        }
                        System.out.println();
                    } else {
                        System.out.println("Account not found.\n");
                    }
                    break;

                case 6:
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts found.\n");
                    } else {
                        System.out.println("+--------+--------------------+--------------+");
                        System.out.println("| AccNo  | Holder Name        | Balance (Rs) |");
                        System.out.println("+--------+--------------------+--------------+");
                        for (Account a : accounts) a.display();
                        System.out.println("+--------+--------------------+--------------+\n");
                    }
                    break;

                case 7:
                    System.out.print("Enter Account Number to close: ");
                    int closeAccNo = scanner.nextInt();
                    Account closeAcc = findAccount(closeAccNo);
                    if (closeAcc != null) {
                        accounts.remove(closeAcc);
                        System.out.println("Account closed successfully!\n");
                    } else {
                        System.out.println("Account not found.\n");
                    }
                    break;

                case 8:
                    System.out.println("Thank you for banking with us. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.\n");
            }
        }
        scanner.close();
    }

    static Account findAccount(int accNo) {
        for (Account a : accounts) {
            if (a.accountNumber == accNo) return a;
        }
        return null;
    }
}