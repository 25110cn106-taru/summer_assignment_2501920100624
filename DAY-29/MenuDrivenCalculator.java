import java.util.Scanner;

public class MenuDrivenCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Menu-Driven Calculator ===\n");

        while (running) {
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Modulus");
            System.out.println("6. Power (x^y)");
            System.out.println("7. Square Root");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();

            if (choice == 8) {
                System.out.println("Exiting Calculator. Goodbye!");
                running = false;
                continue;
            }

            if (choice == 7) {
                System.out.print("Enter number: ");
                double num = scanner.nextDouble();
                if (num < 0) {
                    System.out.println("Cannot find square root of a negative number.\n");
                } else {
                    System.out.printf("Result: sqrt(%.2f) = %.4f%n%n", num, Math.sqrt(num));
                }
                continue;
            }

            if (choice < 1 || choice > 6) {
                System.out.println("Invalid option. Try again.\n");
                continue;
            }

            System.out.print("Enter first number: ");
            double a = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double b = scanner.nextDouble();

            switch (choice) {
                case 1:
                    System.out.printf("Result: %.2f + %.2f = %.2f%n%n", a, b, (a + b));
                    break;
                case 2:
                    System.out.printf("Result: %.2f - %.2f = %.2f%n%n", a, b, (a - b));
                    break;
                case 3:
                    System.out.printf("Result: %.2f * %.2f = %.2f%n%n", a, b, (a * b));
                    break;
                case 4:
                    if (b == 0) {
                        System.out.println("Error: Division by zero is not allowed.\n");
                    } else {
                        System.out.printf("Result: %.2f / %.2f = %.4f%n%n", a, b, (a / b));
                    }
                    break;
                case 5:
                    if (b == 0) {
                        System.out.println("Error: Modulus by zero is not allowed.\n");
                    } else {
                        System.out.printf("Result: %.2f %% %.2f = %.2f%n%n", a, b, (a % b));
                    }
                    break;
                case 6:
                    System.out.printf("Result: %.2f ^ %.2f = %.4f%n%n", a, b, Math.pow(a, b));
                    break;
            }
        }
        scanner.close();
    }
}