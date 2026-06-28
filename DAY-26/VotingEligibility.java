import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Voting Eligibility System ===");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Are you a citizen? (yes/no): ");
        String citizenship = scanner.nextLine().trim().toLowerCase();

        System.out.print("Are you registered to vote? (yes/no): ");
        String registered = scanner.nextLine().trim().toLowerCase();

        System.out.println("\n--- Eligibility Result for " + name + " ---");

        if (age < 18) {
            System.out.println("Result: NOT ELIGIBLE");
            System.out.println("Reason: You must be at least 18 years old to vote.");
        } else if (!citizenship.equals("yes")) {
            System.out.println("Result: NOT ELIGIBLE");
            System.out.println("Reason: You must be a citizen to vote.");
        } else if (!registered.equals("yes")) {
            System.out.println("Result: NOT ELIGIBLE");
            System.out.println("Reason: You must be registered to vote.");
        } else {
            System.out.println("Result: ELIGIBLE TO VOTE");
            System.out.println("You meet all the requirements. Please exercise your right to vote!");
        }

        scanner.close();
    }
}