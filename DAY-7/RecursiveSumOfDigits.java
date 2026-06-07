import java.util.Scanner;

public class RecursiveSumOfDigits {

    public static int sumDigits(int n) {
        if (n == 0)
            return 0;

        return (n % 10) + sumDigits(n / 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Sum of digits = " + sumDigits(n));

        sc.close();
    }
}